package com.capgemini.tests;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.HomePage;
import com.capgemini.pages.RentPg;
import com.capgemini.parameters.PropertyReader;
import com.capgemini.utils.Screenshots;

public class Tst_005_PgRent extends BaseReport {
	String baseURL;
	String browser;
	HomePage homePage;
	RentPg rentPg;
	String parentDriver;
	Set<String> windows;
	String propertyPath;
	String brandName;
	String occupancy;
	String boysorgirls;
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
		rentPg = new RentPg(driver);
		propertyPath = "./src/test/resources/PropertyData/TestData.properties";
		uname = PropertyReader.getPropertyData(propertyPath, "username");
		email = PropertyReader.getPropertyData(propertyPath, "email");
		phno = PropertyReader.getPropertyData(propertyPath, "phno");
		brandName = PropertyReader.getPropertyData(propertyPath, "brandName");
		occupancy = PropertyReader.getPropertyData(propertyPath, "occupancy");
		boysorgirls = PropertyReader.getPropertyData(propertyPath, "boysorgirls");
		parentDriver = driver.getWindowHandle();
	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh 
	 * Test scenario: Verify OTP screen appears after selecting PG brand, occupancy, gender filters, and
	 * contacting the owner.
	 */
	public void performPg() throws Exception {
		try {
			// step1: hover on the RENT
			homePage.getRentLink().click();
			Reporter.log("Clicked on Rent link", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "RentLinkClicked");
			generateExtentReportWithScreenshots("Click on Rent link", screenshotpath);

			// Step2: click on PG in
			BasePage.visibilityOfElement(driver, homePage.getPgRent());
			homePage.getPgRent().click();
			windows = driver.getWindowHandles();

			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
					Reporter.log("Clicked on PG in", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "PgInClicked");
					generateExtentReportWithScreenshots("click on PG in", screenshotpath);

					// step3:Click on Branded Pg filter
					BasePage.visibilityOfElement(driver, rentPg.getBrandedPg());
					rentPg.getBrandedPg().click();
					Reporter.log("Selected a Branded Pg filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "BrandedPgClicked");
					generateExtentReportWithScreenshots("Select a Branded Pg filter", screenshotpath);

					// step4:Select Branded PG name From dropDown
					BasePage.WaitUntillElementClickable(driver, rentPg.getBgDiv());
					WebElement brandFilter = BasePage.selectFromFilter(driver, rentPg.getBrandedPgList(), brandName);
					BasePage.visibilityOfElement(driver, brandFilter);
					brandFilter.click();
					rentPg = new RentPg(driver);
					Reporter.log("Selected a Option form DropDown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, brandName+"selected");
					generateExtentReportWithScreenshots("Select a Option from DropDown", screenshotpath);

					// step5:Select occupancy filter
					rentPg.getOccupancy().click();
					Reporter.log("Selected occupancy filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "occupancyFilter");
					generateExtentReportWithScreenshots("Select occupancy filter", screenshotpath);

					// step6:Select desired option(ex:- Single,Double,Triple,Others)
					BasePage.visibilityOfElement(driver, rentPg.getOpDiv());
					WebElement shareFilter = BasePage.selectFromFilter(driver, rentPg.getOccupancyList(), occupancy);
					BasePage.visibilityOfElement(driver, shareFilter);
					shareFilter.click();
					rentPg = new RentPg(driver);
					Reporter.log("Selected a Option form DropDown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, occupancy+"clicked");
					generateExtentReportWithScreenshots("Select a Option form DropDown", screenshotpath);

					// step7:Select Boys/Girls Filters
					rentPg.getBoysorgirls().click();
					Reporter.log("Select Boys/Girls Filters", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "boysorgirlsFilter");
					generateExtentReportWithScreenshots("Select Boys/Girls Filters", screenshotpath);

					// step8:Select a Option form DropDown
					BasePage.visibilityOfElement(driver, rentPg.getBoyorgirlDiv());
					WebElement bgFilter = BasePage.selectFromFilter(driver, rentPg.getBorgList(), boysorgirls);
					BasePage.visibilityOfElement(driver, bgFilter);
					bgFilter.click();
					rentPg = new RentPg(driver);
					Reporter.log("Selected a Option form DropDown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, boysorgirls+"Selected");
					generateExtentReportWithScreenshots("Select a Option form DropDown", screenshotpath);

					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
					BasePage.visibilityOfElement(driver, rentPg.getContactOwner());

					// step9:Click on Contact Owner button
					int retry = 2;
					while (retry > 0) {
						try {
							BasePage.WaitUntillElementClickable(driver, rentPg.getContactOwner());
							rentPg.getContactOwner().click();
							Reporter.log("Clicked on Contact Owner button", true);
							Assert.assertTrue(true);
							BasePage.visibilityOfElementLocatedByID(driver, "projectFormBlock");
							screenshotpath = Screenshots.takeScreenShot(driver, "ContactOwnerClicked");
							generateExtentReportWithScreenshots("Click on Contact Owner button", screenshotpath);
							break;
						} catch (StaleElementReferenceException e) {
							retry--;
						}

					}

					// step10:Enter userDetails
					BasePage.visibilityOfElementLocatedByID(driver, "projectFormBlock");
					rentPg.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step11:click on do-contact
					rentPg.getDoContact().click();
					BasePage.visibilityOfElement(driver, rentPg.getassertDiv());
					Reporter.log("Clicked on Do Contact", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "OtpScreenVisible");
					generateExtentReportWithScreenshots("OTP screen is visible", screenshotpath);
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
