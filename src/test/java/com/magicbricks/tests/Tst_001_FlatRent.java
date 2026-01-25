package com.magicbricks.tests;

import java.time.Duration;




import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.FlatRent;
import com.capgemini.pages.HomePage;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;

public class Tst_001_FlatRent extends BaseReport {

	String baseURL;
	String browser;
	HomePage homePage;
	String parentDriver;
	FlatRent flatRent;
	Set<String> windows;
	String excelPath;
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		homePage = new HomePage(driver);
		flatRent = new FlatRent(driver);
		parentDriver = driver.getWindowHandle();
		excelPath = "src/test/resources/ExcelData/TestData.xlsx";
		uname = ExcelReader.getCellData(excelPath, "userdata", 1, 0);
		email = ExcelReader.getCellData(excelPath, "userdata", 1, 1);
		phno = ExcelReader.getCellData(excelPath, "userdata", 1, 2);
	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh 
	 * Test scenario: Verify OTP screen appears after contacting the owner for a flat with default filters.
	 */
	public void performFlatRent() throws Exception {
		try {
			// step1: hover on the RENT
			homePage.getRentLink().click();
			Reporter.log("Clicked on Rent link", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "RentLinkClicked");
			generateExtentReportWithScreenshots("Click on Rent link", screenshotpath);

			// Step2: click on flat for rent
			BasePage.visibilityOfElement(driver, homePage.getFlatRent());
			homePage.getFlatRent().click();
			windows = driver.getWindowHandles();
			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					Reporter.log("Clicked on Flat for Rent link", true);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
					String title = driver.getTitle();
					BasePage.WaitUntilVisibilityOfTitle(driver, title);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "FlatLinkClicked");
					generateExtentReportWithScreenshots("Click on Flat for Rent link", screenshotpath);

					// step3:click on contact owner
					BasePage.visibilityOfElement(driver, flatRent.getContactOwner());
					flatRent.getContactOwner().click();
					Reporter.log("Clicked on Contact Owner button", true);
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ContactOwnerClicked");
					generateExtentReportWithScreenshots("Click on Contact Owner button", screenshotpath);

					// step4:enter user details
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					flatRent.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step5:click on do-contact
					flatRent.getDoContact().click();
					BasePage.visibilityOfElement(driver,flatRent.getassertDiv());
					Reporter.log("Clicked on Do Contact", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "OtpScreenVisible");
					generateExtentReportWithScreenshots("OTP screen is visible", screenshotpath);
					driver.close();
				}
			}
		} catch (Exception e) {
			Reporter.log("Unexpected Error occur..!", true);
			Assert.fail("Unexpected Error occur ...! OTP screen is not visible");
			screenshotpath = Screenshots.takeScreenShot(driver, "UnexpectedErrorOccur");
			generateExtentReportWithScreenshots("Unexpected Error occur ...! OTP screen is not visible",
					screenshotpath);
		}

		finally {
			driver.switchTo().window(parentDriver);
		}
	}

}
