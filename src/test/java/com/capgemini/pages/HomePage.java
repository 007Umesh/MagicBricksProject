package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// locating RENT using css locator
	@FindBy(id = "rentheading")
	private WebElement rentLink;

	@FindBy(partialLinkText = "Flat for rent")
	private WebElement flatRent;

	@FindBy(partialLinkText = "House for rent")
	private WebElement houseRent;

	@FindBy(partialLinkText = "Villa for rent in Bangalore")
	private WebElement villaRent;

	@FindBy(partialLinkText = "PG in Bangalore")
	private WebElement pgRent;

	@FindBy(partialLinkText = "Office Space")
	private WebElement officeSpace;

	@FindBy(partialLinkText = "Home Interiors")
	private WebElement homeInteriors;

	// Home Interior Design Services
	@FindBy(partialLinkText = "Home Interior Design Services")
	private WebElement homeInteriorsDesign;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRentLink() {
		return rentLink;
	}

	public WebElement getFlatRent() {
		return flatRent;
	}

	public WebElement getHouseRent() {
		return houseRent;
	}

	public WebElement getVillaRent() {
		return villaRent;
	}

	public WebElement getPgRent() {
		return pgRent;
	}

	public WebElement getOfficeSpace() {
		return officeSpace;
	}

	public WebElement getHomeInteriors() {
		return homeInteriors;
	}

	public WebElement getHomeInteriorsDesign() {
		return homeInteriorsDesign;
	}
}
