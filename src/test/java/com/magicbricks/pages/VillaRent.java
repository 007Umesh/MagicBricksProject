package com.magicbricks.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VillaRent {

	@FindBy(xpath = "//div[@class='top-filter__item']//div[@class='title-ellipsis' and contains(.,'BHK')]")
	//div[@class='top-filter__item']//div[@class='title-ellipsis' and contains(.,'Top Localities')]
	private WebElement bhkFilter;
	
	@FindBy(xpath = "(//div[@class='filter__component__drop-down'])[4]")
	private WebElement bhkDiv;	

	@FindAll(@FindBy(xpath = "//div[@class='filter__common__component__row   clearfix']//div"))
	private List<WebElement> bhkList;

	@FindBy(xpath = "//div[@class='filter__component__title']//div[@class='title-ellipsis' and text()='Posted By']")
	private WebElement postedbyFilter;
	
	@FindBy(xpath = "(//div[@class='filter__component__drop-down']//div[@class='filter__common__component  clearfix'])[5]/div/div")
	private WebElement postBydiv;	

	@FindAll(@FindBy(xpath = "(//div[@class='filter__common__component  clearfix'])[6]/div/div"))
	private List<WebElement> postByList;

	@FindBy(xpath = "(//div[@class='filter__component__drop-down']//div[@class='filter__component__cta-done'][normalize-space()='Done'])[4]")
	private WebElement done;

	@FindBy(xpath = "(//div[@class='mb-srp__action action--single mb-srp__card__action']//span[contains(text(),'Contact')])[1]")
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
	
	public WebElement getBhkDiv() {
		return bhkDiv;
	}

	public List<WebElement> getBhkList() {
		return bhkList;
	}

	public WebElement getPostBydiv() {
		return postBydiv;
	}

	public List<WebElement> getPostByList() {
		return postByList;
	}

	public VillaRent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getContactOwner() {
		return contactOwner;
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

	public WebElement getBhkFilter() {
		return bhkFilter;
	}



	public WebElement getPostedbyFilter() {
		return postedbyFilter;
	}

	public WebElement getDone() {
		return done;
	}

	public void setValues(String uname, String emailText, String phno) {
		userName.sendKeys(uname);
		userEmail.sendKeys(emailText);
		userPhno.sendKeys(phno);
	}
}
