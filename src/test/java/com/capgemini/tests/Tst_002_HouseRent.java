package com.capgemini.tests;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.HomePage;
import com.capgemini.pages.HouseRent;
import com.capgemini.parameters.PropertyReader;
import com.capgemini.utils.Screenshots;

public class Tst_002_HouseRent extends BaseReport {
	String baseURL;
	String browser;
	HomePage homePage;
	String parentDriver;
	HouseRent houseRent;
	Set<String> windows;
	String propertyPath;
	String localName;
	String uname;
	String email;
	String phno;
	String minValue;
	String maxValue;
	String screenshotpath;

	@BeforeClass
	public void setUpClass() throws Exception {
		baseURL = "https://www.magicbricks.com";
		browser = "chrome";
		driver = SetupDriver.getDriver(browser);
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		parentDriver = driver.getWindowHandle();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		homePage = new HomePage(driver);
		houseRent = new HouseRent(driver);
		parentDriver = driver.getWindowHandle();
		propertyPath = "./src/test/resources/PropertyData/TestData.properties";
		uname = PropertyReader.getPropertyData(propertyPath, "username");
		email = PropertyReader.getPropertyData(propertyPath, "email");
		phno = PropertyReader.getPropertyData(propertyPath, "phno");
		localName = PropertyReader.getPropertyData(propertyPath, "localityName");
		minValue = PropertyReader.getPropertyData(propertyPath, "minValue");
		maxValue = PropertyReader.getPropertyData(propertyPath, "maxValue");

	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh Test scenario: Verify OTP
	 * screen appears after applying locality and budget filters and contacting the
	 * owner for a house.
	 */
	public void performHouseRent() throws Exception {
		try {
			// step1: hover on the RENT
			homePage.getRentLink().click();
			Reporter.log("Clicked on Rent link", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "RentLinkClicked");
			generateExtentReportWithScreenshots("Click on Rent link", screenshotpath);

			// Step2: click on House for rent
			BasePage.visibilityOfElement(driver, homePage.getHouseRent());
			homePage.getHouseRent().click();
			windows = driver.getWindowHandles();

			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
					BasePage.WaitUntilVisibilityOfTitle(driver, "House for Rent in Bangalore");
					Reporter.log("Clicked on House for Rent link", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "HouseLinkClicked");
					generateExtentReportWithScreenshots("Click on House for Rent link", screenshotpath);

					// step3:Click on locality filter
					System.out.println(driver.getTitle());
					BasePage.visibilityOfElement(driver, houseRent.getLocalityFilter());
					houseRent.getLocalityFilter().click();
					Reporter.log("Selected a Locality Filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "LocalityFilterSelected");
					generateExtentReportWithScreenshots("Select a Locality Filter", screenshotpath);

					// step4:Select locality name from a dropdown
					BasePage.visibilityOfElement(driver, houseRent.getLocalDiv());
					WebElement locality = BasePage.selectFromFilter(driver, houseRent.getlocalCityName(), localName);
					BasePage.visibilityOfElement(driver, locality);
					locality.click();
					houseRent = new HouseRent(driver);
					Reporter.log("Selected locality name from a dropdown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "SelectedFromLocality");
					generateExtentReportWithScreenshots("Select locality name from a dropdown", screenshotpath);

					// step5:Select budget filter
					houseRent.getBudgetFilter().click();
					Reporter.log("Selected a budget Filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "budgetFilterSelected");
					generateExtentReportWithScreenshots("Select a budget Filter", screenshotpath);

					// step6:Select maximum value
					Select maxList = new Select(houseRent.getMaxBudgetList());
					maxList.selectByVisibleText("₹ " + maxValue);
					Reporter.log("Selected max value from dropdown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "maxValueSelected");
					generateExtentReportWithScreenshots("Select max value from dropdown", screenshotpath);

					// step7:Select minimum value
					Select minList = new Select(houseRent.getMinBudgetList());
					minList.selectByVisibleText("₹ " + minValue);
					Reporter.log("Selected min value from dropdown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "minValueSelected");
					generateExtentReportWithScreenshots("Select min value from dropdown", screenshotpath);
//					
//					//step8:Click Done
					houseRent.getDone().click();
					houseRent = new HouseRent(driver);
					Reporter.log("Selected min value from dropdown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "DoneClicked");
					generateExtentReportWithScreenshots("Select min value from dropdown", screenshotpath);

					// step9:Click on Contact Owner button
					BasePage.visibilityOfElement(driver, houseRent.getContactOwner());
					houseRent.getContactOwner().click();
					Reporter.log("Clicked on Contact Owner button", true);
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ContactOwnerClicked");
					generateExtentReportWithScreenshots("Click on Contact Owner button", screenshotpath);

					// step10:Enter user details
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					houseRent.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step11:click on do-contact
					houseRent.getDoContact().click();
					BasePage.visibilityOfElement(driver, houseRent.getassertDiv());
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
		}

		finally {
			driver.switchTo().window(parentDriver);
		}

	}
}
