package com.magicbricks.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentPg {

	@FindBy(xpath = "//div[@class='title-ellipsis text-limit-max']//span[contains(text(),'Branded PGs')]")
	private WebElement brandedPg;

	@FindBy(xpath = "(//div[@class='m-filter__ptype clearfix'])[3]")
	private WebElement bgDiv;// for wait

	@FindAll(@FindBy(xpath = " (//div[@class='m-filter__ptype clearfix'])[3]//div"))
	private List<WebElement> brandedPgList;

	@FindBy(linkText = "DONE")
	private WebElement done;

	@FindBy(xpath = "//div[@class='title-ellipsis text-limit-max']//span[@id='occupancy-title']")
	private WebElement occupancy;

	@FindBy(xpath = "(//div[@class='m-filter__ptype clearfix'])[5]")
	private WebElement boyorgirlDiv;// for wait

	@FindAll(@FindBy(xpath = "//div[@id='refineoccupancy']//div//div"))
	private List<WebElement> occupancyList;

	@FindBy(xpath = "//div[@class='title-ellipsis text-limit-max']//span[text()='Boys/Girls']")
	private WebElement boysorgirls;

	@FindBy(xpath = "//div[@id='refineoccupancy']")
	private WebElement opDiv;// for wait

	@FindAll(@FindBy(xpath = "(//div[@class='m-filter__ptype clearfix'])[5]//div"))
	private List<WebElement> borgList;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement userEmail;

	@FindBy(xpath = "//input[@id='userMobile']")
	private WebElement userphNo;

	@FindBy(xpath = "//button[@id='showProjContactButtonText']")
	private WebElement doContact;

	@FindBy(xpath = "//button[@class='m-srp-card__btn m-srp-card__btn--primary-o']")
	private WebElement contactOwner;
	
	@FindBy(xpath="//div[@class='mobileVerTop' and text()='Verify your number']")
	private WebElement assertDiv;
	
	public WebElement getassertDiv() {
		return assertDiv;
	}
	

	public WebElement getBrandedPg() {
		return brandedPg;
	}

	public WebElement getBgDiv() {
		return bgDiv;
	}

	public List<WebElement> getBrandedPgList() {
		return brandedPgList;
	}

	public WebElement getDone() {
		return done;
	}

	public WebElement getOccupancy() {
		return occupancy;
	}

	public WebElement getBoyorgirlDiv() {
		return boyorgirlDiv;
	}

	public List<WebElement> getOccupancyList() {
		return occupancyList;
	}

	public WebElement getBoysorgirls() {
		return boysorgirls;
	}

	public WebElement getOpDiv() {
		return opDiv;
	}

	public List<WebElement> getBorgList() {
		return borgList;
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
		return userphNo;
	}

	public WebElement getDoContact() {
		return doContact;
	}

	public RentPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setValues(String uname, String email, String phNo) {
		userName.sendKeys(uname);
		userEmail.sendKeys(email);
		userphNo.sendKeys(phNo);
	}

}
