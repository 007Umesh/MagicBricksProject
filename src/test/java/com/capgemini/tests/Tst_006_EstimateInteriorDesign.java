package com.capgemini.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.HomePage;
import com.capgemini.pages.InteriorDesign;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;

public class Tst_006_EstimateInteriorDesign extends BaseReport {
	String baseURL;
	String browser;
	Actions action;
	HomePage homePage;
	InteriorDesign interior;
	String parentDriver;
	Set<String> windows;
	String excelPath;
	String monthOption;
	String bhkType;
	String bhkSize = "Small";
	String uname;
	String email;
	String phno;
	String screenshotpath;

	@BeforeClass
	public void setUpClass() {
		baseURL = "https://www.magicbricks.com";
		browser = "chrome";
		driver = SetupDriver.getDriver(browser);
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		parentDriver = driver.getWindowHandle();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		homePage = new HomePage(driver);
		interior = new InteriorDesign(driver);
		action = new Actions(driver);
		excelPath = "src/test/resources/ExcelData/TestData.xlsx";
		uname = ExcelReader.getCellData(excelPath, "userdata1", 1, 0);
		email = ExcelReader.getCellData(excelPath, "userdata1", 1, 1);
		phno = ExcelReader.getCellData(excelPath, "userdata1", 1, 2);
		monthOption = ExcelReader.getCellData(excelPath, "userdata1", 1, 3);
		bhkType = ExcelReader.getCellData(excelPath, "userdata1", 1, 4);
		bhkSize = ExcelReader.getCellData(excelPath, "userdata1", 1, 5);
		parentDriver = driver.getWindowHandle();
	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh 
	 * Test scenario:Verify error message is shown when invalid user details are entered during the home
	 * interior estimate process.
	 */
	public void PerformHomeInterior() throws Exception {
		try {
			// step1: hover on the HomeInteriors
			action.moveToElement(homePage.getHomeInteriors()).build().perform();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			Reporter.log("hover on the HomeInteriors", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "HomeInteriorsClicked");
			generateExtentReportWithScreenshots("Hover on HomeInteriors", screenshotpath);

			// Step2: click on HomeInteriors Design Services
			BasePage.visibilityOfElement(driver, homePage.getHomeInteriorsDesign());
			homePage.getHomeInteriorsDesign().click();
			windows = driver.getWindowHandles();

			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					Reporter.log("Clicked on HomeInteriors Design Services", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "HomeInteriorsClicked");
					generateExtentReportWithScreenshots("click on HomeInteriors Design Services", screenshotpath);

					// step3:Close City POp-UP
					BasePage.visibilityOfElement(driver, interior.getCloseUp());
					Reporter.log("Closed City POp-UP", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ClosedcityPOp-UP");
					generateExtentReportWithScreenshots("Close City POp-UP", screenshotpath);
					//wait.until(ExpectedConditions.visibilityOf(interior.getCloseUp())).click();
					BasePage.visibilityOfElement(driver, interior.getCloseUp()).click();
					
					
					// Step4:Scroll to Full House Estimate for Interior Design
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1100);");
					BasePage.visibilityOfElement(driver, interior.getCalculate());
					Reporter.log("Scrolled to Full House Estimate for Interior Design", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ScrolledToEstimate");
					generateExtentReportWithScreenshots("Scroll to Full House Estimate for Interior Design",
							screenshotpath);

					// step5:Click on Calculate
					BasePage.visibilityOfElement(driver, interior.getCalculate());
					interior.getCalculate().click();
					BasePage.visibilityOfElement(driver, interior.getCloseUp());
					interior.getCloseUp().click();
					Reporter.log("Clicked on Calculate", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "CalculateClicked");
					generateExtentReportWithScreenshots("Click on Calculate", screenshotpath);

					// step6:Select the month
					BasePage.visibilityOfElement(driver, interior.getwaitDiv());
					WebElement monthFilter = BasePage.selectFromFilter(driver, interior.getMonthOption(), monthOption);
					BasePage.visibilityOfElement(driver, monthFilter);
					monthFilter.click();
					Reporter.log("Selected The Month", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "MonthSelected");
					generateExtentReportWithScreenshots("Select Month", screenshotpath);
					
					// step7:Click on Next
					BasePage.visibilityOfElement(driver, interior.getNextButton());
					interior.getNextButton().click();
					BasePage.visibilityOfElement(driver, interior.getwaitDiv());
					Reporter.log("Clicked on Next", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ClickedOnNext");
					generateExtentReportWithScreenshots("Click on Next", screenshotpath);

					// step8:Select the BHK type and Size
					BasePage.visibilityOfElement(driver, interior.getwaitDiv());
					WebElement bhkSizeFilter = BasePage.selectFromFilter(driver, interior.getBhkType(), bhkType);
					BasePage.visibilityOfElement(driver, bhkSizeFilter);
					bhkSizeFilter.click();
					if (bhkSize.equalsIgnoreCase(interior.getSmallBHK().getText())) {
						BasePage.visibilityOfElement(driver, interior.getbhkSizeWait());
						interior.getSmallBHK().click();
					} else {
						BasePage.visibilityOfElement(driver, interior.getbhkSizeWait());
						interior.getLargeBHK().click();
					}
					BasePage.visibilityOfElement(driver, interior.getbhkSizeWait());
					Reporter.log("Selected The Month", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "MonthSelected");
					generateExtentReportWithScreenshots("Select Month", screenshotpath);

					// step9:Click on Next
					BasePage.visibilityOfElement(driver, interior.getNextButton());
					interior.getNextButton().click();
					BasePage.visibilityOfElement(driver, interior.getwaitDiv());
					interior.getwaitDiv().click();
					Reporter.log("Clicked on Next", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ClickedOnNext");
					generateExtentReportWithScreenshots("Click on Next", screenshotpath);

					// step10:Enter user details
					BasePage.visibilityOfElement(driver, interior.getwaitDiv());
					interior.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step11:Click on Free Estimate
					interior.getEsitmateReady().click();
					BasePage.visibilityOfElement(driver, interior.getErrorMsg());
					Reporter.log("Clicked on Free Estimate", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ErrorMessageDisplayed");
					generateExtentReportWithScreenshots("Error Message Displayed", screenshotpath);
					driver.close();
				}
			}
		} catch (Exception e) {
			Reporter.log("Unexpected Error occur..!", true);
			Assert.fail("Unexpected Error occur ...! OTP screen is not visible" + e.getMessage());
			screenshotpath = Screenshots.takeScreenShot(driver, "UnexpectedErrorOccur");
			generateExtentReportWithScreenshots(
					"Unexpected Error occur ...! OTP screen is not visible" + e.getMessage(), screenshotpath);
		} finally {
			driver.switchTo().window(parentDriver);
		}
	}
}
