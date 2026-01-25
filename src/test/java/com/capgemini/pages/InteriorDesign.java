package com.capgemini.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteriorDesign {
	@FindBy(xpath = "//a[@class='quote-card icon-1']//span[text()='Calculate']")
	private WebElement calculate;
	
	@FindBy(xpath = "//div[@class='city-popup__close']")
	private WebElement closeup;
	
	@FindBy(xpath = "//div[@class='kwpe__optionswrap']")
	private WebElement waitDiv;
	
	//kwpe__layout--inner
//	@FindBy(xpath = "//div[@class='kwpe__optionswrap']")
//	private WebElement bhkDiv;
	
	@FindAll(@FindBy(xpath = "//li[@class='mb-form-ui__select__element int-search-form__input']/label"))
	private List<WebElement> monthOption;

	@FindBy(xpath = "//button[@class='cta cta-filled']")
	private WebElement nextButton;// 1--->2

	@FindAll(@FindBy(xpath = "//div[@class='kwpe__layout__cards bhkTypes']/div/label"))
	private List<WebElement> bhkType;
	
	@FindBy(xpath = "//div[@class='kwpe__sublayout']")
	private WebElement bhkSizeWait;

	@FindBy(xpath = "//div[@class='text-bold' and text()='Small']")
	private WebElement smallBHK;

	@FindBy(xpath = "//div[@class='text-bold' and text()='Large']")
	private WebElement largeBHK;

	@FindBy(id = "user-name")
	private WebElement userName;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "//button[@class='cta cta-filled']")
	private WebElement esitmateReady;
	
	@FindBy(xpath = "//div[@class='mb-form-ui__error']")
	private WebElement errorMsg;

	public WebElement getCalculate() {
		return calculate;
	}
	
	public WebElement getwaitDiv() {
		return waitDiv;
	}
	
	public WebElement getCloseUp() {
		return closeup;
	}

	public List<WebElement> getMonthOption() {
		return monthOption;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public List<WebElement> getBhkType() {
		return bhkType;
	}
	
	public WebElement getbhkSizeWait() {
		return bhkSizeWait;
	}
	
	public WebElement getSmallBHK() {
		return smallBHK;
	}

	public WebElement getLargeBHK() {
		return largeBHK;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPhone() {
		return phone;
	}
	

	public WebElement getemail() {
		return email;
	}
	
	public WebElement getEsitmateReady() {
		return esitmateReady;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	public InteriorDesign(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setValues(String uname, String emailId, String phNo) {
		userName.sendKeys(uname);
		email.sendKeys(emailId);
		phone.sendKeys(phNo);
	}
}
