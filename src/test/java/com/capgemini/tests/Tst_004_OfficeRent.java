package com.capgemini.tests;

import java.time.Duration;


import java.util.Set;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.BasePage;
import com.capgemini.pages.HomePage;
import com.capgemini.pages.OfficeSpaceRent;
import com.capgemini.parameters.JsonReader;
import com.capgemini.utils.Screenshots;

public class Tst_004_OfficeRent extends BaseReport {

	String baseURL;
	String browser;
	HomePage homePage;
	String parentDriver;
	OfficeSpaceRent officeSpace;
	Set<String> windows;
	String jsonPath;
	String bhkName;
	String postedByName;
	String uname;
	String email;
	String phno;
	String seatNo;
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
		officeSpace = new OfficeSpaceRent(driver);
		jsonPath = "./src/test/resources/JsonData/TestData.json";
		uname = JsonReader.getJsonData(jsonPath, "userName");
		email = JsonReader.getJsonData(jsonPath, "email");
		phno = JsonReader.getJsonData(jsonPath, "phNo");
		bhkName = JsonReader.getJsonData(jsonPath, "bhkName");
		postedByName = JsonReader.getJsonData(jsonPath, "postName");
		seatNo = JsonReader.getJsonData(jsonPath, "seatNo");
		parentDriver = driver.getWindowHandle();
	}

	@Test
	/*
	 * Created By : Umesh S 
	 * Reviewed By : Richa Singh 
	 * Test scenario:Verify OTP screen appears after entering seat requirements and contacting the owner for
	 * office space.
	 */
	public void performOfficeSpace() throws Exception {
		try {
			// step1: hover on the RENT
			homePage.getRentLink().click();
			Reporter.log("Clicked on Rent link", true);
			Assert.assertTrue(true);
			screenshotpath = Screenshots.takeScreenShot(driver, "RentLinkClicked");
			generateExtentReportWithScreenshots("Click on Rent link", screenshotpath);

			// Step2: click on Office Space for rent
			BasePage.visibilityOfElement(driver, homePage.getOfficeSpace());
			homePage.getOfficeSpace().click();
			windows = driver.getWindowHandles();

			for (String win : windows) {
				if (!win.equals(parentDriver)) {
					driver.switchTo().window(win);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
					Reporter.log("Clicked on Office Space for Rent link", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "OfficeSpaceClicked");
					generateExtentReportWithScreenshots("Click on Office Space for Rent link", screenshotpath);

					// step3:Click on SEATS filter
					BasePage.visibilityOfElement(driver, officeSpace.getSeatsFilter());
					officeSpace.getSeatsFilter().click();
					Reporter.log("Selected a SEATS Filter", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "SEATSClicked");
					generateExtentReportWithScreenshots("Select a SEATS Filter", screenshotpath);

					// step4:Enter a Number of seats
					BasePage.visibilityOfElement(driver, officeSpace.getSeatValueLabel());
					officeSpace.getSeatValueLabel().click();
					officeSpace.getSeatValue().sendKeys(seatNo);
					Reporter.log("Entered a Number of seats", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "NoOFSeats");
					generateExtentReportWithScreenshots("Enter a Number of seats", screenshotpath);

					// step5:Click Done
					officeSpace.getDone().click();
					officeSpace = new OfficeSpaceRent(driver);
					Reporter.log("Clicked Done", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "DoneClicked");
					generateExtentReportWithScreenshots("Click Done", screenshotpath);

					// step6:Click on Contact Owner button
					BasePage.visibilityOfElement(driver, officeSpace.getContactOwner());
					officeSpace.getContactOwner().click();
					Reporter.log("Clicked on Contact Owner button", true);
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "ContactOwnerClicked");
					generateExtentReportWithScreenshots("Click on Contact Owner button", screenshotpath);

					// step7:Enter UserDetails
					BasePage.visibilityOfElementLocatedByClass(driver, "contact-form__content");
					officeSpace.setValues(uname, email, phno);
					Reporter.log("User Details entered", true);
					Assert.assertTrue(true);
					screenshotpath = Screenshots.takeScreenShot(driver, "UserDetailsEntered");
					generateExtentReportWithScreenshots("Enter User Details", screenshotpath);

					// step8:click on do-contact
					officeSpace.getDoContact().click();
					BasePage.visibilityOfElement(driver, officeSpace.getassertDiv());
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
