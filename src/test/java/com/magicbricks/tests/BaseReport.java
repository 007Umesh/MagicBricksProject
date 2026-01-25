package com.magicbricks.tests;

import java.lang.reflect.Method;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.capgemini.utils.Screenshots;

public class BaseReport {
	protected static ExtentReports extentReport;
	protected static ExtentSparkReporter extentSparkReporter;
	protected  ExtentTest parentExtentTest;
	protected  ExtentTest extentTest;
	protected WebDriver driver;
	
	@BeforeSuite
	public void setupReport() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./Extent Reports/SampleReport.html");
		extentSparkReporter.config().setDocumentTitle("Automation Test Report");
		extentSparkReporter.config().setReportName("MagicBricks Automation Suite");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		
	}

	@BeforeClass
	public void setupClass() {
	parentExtentTest = extentReport.createTest(getClass().getSimpleName());
	}
	
	@BeforeMethod
	public void setupMethod(Method method) {
		extentTest = parentExtentTest.createNode(method.getName());
	}

	@AfterMethod
	public void getResult(ITestResult testResult) throws Exception {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshots.takeScreenShot(driver, testResult.getName());
			extentTest.fail(testResult.getThrowable());
			extentTest.fail("<b>Screenshots:</b><br><img src='"+screenshotPath+"' Style='width:90%; height:auto;'>");
			extentTest.log(Status.FAIL, testResult.getThrowable());
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("Test Passed");
			extentTest.log(Status.PASS, testResult.getTestName());
		}
		else if(testResult.getStatus() == ITestResult.SKIP){
			extentTest.skip(testResult.getThrowable());
			extentTest.log(Status.SKIP, testResult.getTestName());
		}
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	@AfterSuite
	public void endReport() {
		extentReport.flush();
	}
	
	public void generateExtentReportWithScreenshots(String stepDescription, String screenshotPath) {
		extentTest.info(stepDescription + "<br><img src='"+screenshotPath+ "'  Style='width:90%; height:auto;'>");
	}
}
