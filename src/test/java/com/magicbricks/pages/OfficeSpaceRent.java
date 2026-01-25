package com.magicbricks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficeSpaceRent {

	@FindBy(xpath = " //div[@class='filter__component topSeats']//div[@class='filter__component__title']//div[@class='title-ellipsis' and text()='Seat(s)']")
	private WebElement seatsFilter;

	@FindBy(xpath =  "//label[@class='filter__common__component__item-seat__label']")
	private WebElement seatValueLabel;
	
	@FindBy(css = "input#comSeat")
	private WebElement seatValue;

	@FindBy(xpath = "(//div[@class='filter__component__cta-done'])[5]")
	private WebElement done;

	@FindBy(xpath = "(//div[@class='mb-srp__action action--single mb-srp__card__action']//span[contains(.,'Contact')])[1]")
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
	
	public WebElement getassertDiv() {
		return assertDiv;
	}

	public OfficeSpaceRent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSeatsFilter() {
		return seatsFilter;
	}

	public WebElement getSeatValue() {
		return seatValue;
	}

	public WebElement getSeatValueLabel() {
		return seatValueLabel;
	}

	public WebElement getDone() {
		return done;
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

	public WebElement getContactOwner() {
		return contactOwner;
	}

	public WebElement getDoContact() {
		return doContact;
	}

	public void setValues(String uname, String emailText, String phno) {
		userName.sendKeys(uname);
		userEmail.sendKeys(emailText);
		userPhno.sendKeys(phno);
	}
}
