package com.magicbricks.utils;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
static int imageCount = 1;
public static String takeScreenShot(WebDriver driver, String filename) throws Exception {
	String screenShotPath = System.getProperty("user.dir") + "./Screenshots";
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String screenshotName = "Step_" + (imageCount++) + "_"+filename+".png";
	screenShotPath =  screenShotPath + File.separator + screenshotName;
	FileUtils.copyFile(screenshot, new File(screenShotPath));
	return screenShotPath;
}
}
