package com.magicbricks.tests;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.magicbricks.driversetup.SetupDriver;
import com.magicbricks.pages.BasePage;
import com.magicbricks.pages.HomePage;
import com.magicbricks.pages.VillaRent;
import com.magicbricks.parameters.JsonReader;
import com.magicbricks.utils.Screenshots;

public class Tst_003_VillaRent extends BaseReport {
	String baseURL;
	String browser;
	HomePage homePage;
	String parentDriver;
	VillaRent villaRent;
	Set<String> windows;
	String jsonPath;
	String bhkName;
	String postedByName;
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		homePage = new HomePage(driver);
		villaRent = new VillaRent(driver);
		jsonPath = "./src/test/resources/JsonData/TestData.json";
		uname = JsonReader.getJsonData(jsonPath, "userName");
		email = JsonReader.getJsonData(jsonPath, "email");
		phno = JsonReader.getJsonData(jsonPath, "phNo");
		bhkName = JsonReader.getJsonData(jsonPath, "bhkName");
		postedByName = JsonReader.getJsonData(jsonPath, "postName");
		parentDriver = driver.getWindowHandle();
	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh 
	 * Test scenario: Verify OTP screen appears after applying BHK and posted-by filters and contacting the
	 * owner for a villa.
	 */
	public void performVillaRent() throws Exception {
		try {
			// step1: hover on the RENT
			homePage.getRentLink().click();
			Reporter.log("Clicked on Rent link", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "RentLinkClicked");
			generateExtentReportWithScreenshots("Click on Rent link", screenshotpath);

			// Step2: click on Villa for rent
			BasePage.visibilityOfElement(driver, homePage.getVillaRent());
			homePage.getVillaRent().click();
			windows = driver.getWindowHandles();

			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
					Reporter.log("Clicked on Villa for Rent link", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "villaLinkClicked");
					generateExtentReportWithScreenshots("Click on Villa for Rent link", screenshotpath);

					// step3:Click on BHK filter
					BasePage.visibilityOfElement(driver, villaRent.getBhkFilter());
					villaRent.getBhkFilter().click();
					Reporter.log("Selected a BHK Filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "BHKClicked");
					generateExtentReportWithScreenshots("Select a BHK Filter", screenshotpath);

					//step4:Select from the dropdown
					BasePage.visibilityOfElement(driver, villaRent.getBhkDiv());
					WebElement bhkFilter = BasePage.selectFromFilter(driver, villaRent.getBhkList(), bhkName);
					BasePage.visibilityOfElement(driver, bhkFilter);
					bhkFilter.click();
					villaRent = new VillaRent(driver);
					Reporter.log("Selected bhk type from a dropdown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "bhkTypeSelected");
					generateExtentReportWithScreenshots("Selected bhk type from a dropdown", screenshotpath);

					// step5:Select PostBy filter
					villaRent.getPostedbyFilter().click();
					Reporter.log("Selected a PostBy Filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, bhkName+"Clicked");
					generateExtentReportWithScreenshots("Select a budget Filter", screenshotpath);
					
					// step6:Click on the posted by whom from a dropDown
					WebElement postFilter = BasePage.selectFromFilter(driver, villaRent.getPostByList(), postedByName);
					BasePage.visibilityOfElement(driver, postFilter);
					postFilter.click();
					villaRent = new VillaRent(driver);
					Reporter.log("Click on the posted by whom from a dropDown", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, postedByName+"clicked");
					generateExtentReportWithScreenshots("Select locality name from a dropdown", screenshotpath);

					// step7:Click Done
					BasePage.visibilityOfElement(driver, villaRent.getDone());
					villaRent.getDone().click();
					Reporter.log("Clicked Done", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "DoneClicked");
					generateExtentReportWithScreenshots("Click Done", screenshotpath);

					// step8:Click on Contact Owner button
					BasePage.visibilityOfElement(driver, villaRent.getContactOwner());
					villaRent.getContactOwner().click();
					Reporter.log("Clicked on Contact Owner button", true);
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ContactOwnerClicked");
					generateExtentReportWithScreenshots("Click on Contact Owner button", screenshotpath);

					// step9:Enter userDetails
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					villaRent.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step10:click on do-contact
					villaRent.getDoContact().click();
					BasePage.visibilityOfElement(driver, villaRent.getassertDiv());
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
