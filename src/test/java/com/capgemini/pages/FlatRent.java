package com.capgemini.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlatRent {

	@FindBy(xpath = "(//div[@class='mb-srp__list']//div//span[contains(.,'Contact Owner')])[1]")
	private WebElement contactOwner;

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement userEmail;

	@FindBy(xpath = "//input[@id='userMobile']")
	private WebElement userPhno;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement doContact;
	
	@FindBy(xpath="//div[@class='contact-form__heading' and text()='Verify your number']")
	private WebElement assertDiv;
	
	

	public FlatRent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getContactOwner() {
		return contactOwner;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getEmail() {
		return userEmail;
	}

	public WebElement getPhNo() {
		return userPhno;
	}

	public WebElement getDoContact() {
		return doContact;
	}
	
	public WebElement getassertDiv() {
		return assertDiv;
	}

	public void setValues(String uname, String email, String phNo) {
		userName.sendKeys(uname);
		userEmail.sendKeys(email);
		userPhno.sendKeys(phNo);
	}
}
