package com.magicbricks.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HouseRent {
	
	@FindBy(xpath = "//div[@class='top-filter__item']//div[@class='title-ellipsis' and contains(.,'Top Localities')]")
	private WebElement localityFilter;

	@FindAll(@FindBy(xpath = "//div[@class='filter__common__component__row   clearfix']//div"))
	private List<WebElement> localCityName;



	@FindBy(xpath = "//div[@class='filter__component__title']//div[@class='title-ellipsis' and text()='Budget']")
	private WebElement budgetFilter;

	@FindBy(xpath = "(//select[@class='filter-budget__select'])[1]")
	private WebElement minBudget;
	
	@FindBy(css = "div.filter-budget")
	private WebElement budgetDiv;
	
	@FindBy(xpath = "(//div[@class='filter__component__drop-down']//div[@class='filter__common__component  clearfix'])[1]/div/div")
	private WebElement localDiv;

	@FindBy(xpath = "(//select[@class='filter-budget__select'])[1]")
	private WebElement minBudgetList;
	
	@FindBy(xpath = "(//div[@class='filter-budget__fieldset__min-max max'])[1]")
	private WebElement maxBudget;

	@FindBy(xpath = "(//select[@class='filter-budget__select'])[2]")
	private WebElement maxBudgetList;

	@FindBy(xpath = "(//div[@class='filter__component__cta-done'])[3]")
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

	public WebElement getDone() {
		return done;
	}

	public WebElement getBudgetFilter() {
		return budgetFilter;
	}

	public WebElement getMinBudget() {
		return minBudget;
	}

	public WebElement getMinBudgetList() {
		return minBudgetList;
	}

	public WebElement getMaxBudget() {
		return maxBudget;
	}

	public WebElement getMaxBudgetList() {
		return maxBudgetList;
	}

	public List<WebElement> getlocalCityName() {
		return localCityName;
	}

	public WebElement getLocalityFilter() {
		return localityFilter;
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
	
	public WebElement getBudegtDiv() {
		return budgetDiv;
	}
	
	public WebElement getLocalDiv() {
		return localDiv;
	}
	
	
	WebDriver driver;

	public HouseRent(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setValues(String uname, String emailText, String phno) {
		userName.sendKeys(uname);
		userEmail.sendKeys(emailText);
		userPhno.sendKeys(phno);
	}
}
