package com.magicbricks.pages;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	//Method to wait for the particular element to visible based on web-element
	public static WebElement visibilityOfElement(WebDriver driver, WebElement waitElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(waitElement));
	}
	
	//Method to wait for the particular element to visible based on class name
	public static WebElement visibilityOfElementLocatedByClass(WebDriver driver, String className) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}

	//Method to wait for the particular element to visible based on Id
	public static WebElement visibilityOfElementLocatedByID(WebDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	//Method to wait for the particular element to visible and Clickable
	public static WebElement WaitUntillElementClickable(WebDriver driver, WebElement waitElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(waitElement));
	}

	//Method to wait for the title of a Website is visible
	public static void WaitUntilVisibilityOfTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	//Method to Acess the Particular Element from dropdowns
	public static WebElement selectFromFilter(WebDriver driver, List<WebElement> eleList, String key) {
		WebElement filter = null;
		for (int i = 0; i < eleList.size(); i++) {
			filter = eleList.get(i);
			if (filter.getText().equalsIgnoreCase(key)) {
				return filter;
			}
		}
		return null;
	}

}
