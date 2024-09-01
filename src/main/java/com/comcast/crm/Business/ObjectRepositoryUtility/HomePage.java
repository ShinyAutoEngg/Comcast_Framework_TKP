package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Initialization
	WebDriver driver = null;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//******************************************************************************	
	//Object Identification / Declaration
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contLink;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath ="//a[text()='Campaigns']")
	private WebElement campLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
//******************************************************************************	
	//Getters 
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return contLink;
	}

	public WebElement getProdLink() {
		return prodLink;
	}
	
	public WebElement getCampLink() {
		return campLink;
	}
	
	public WebElement getMoreLink()	{
		return moreLink;
	}
	
	public WebElement getAdminIcon()
	{
		return adminIcon;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
//******************************************************************************
	//Business Library 
	public void navigateToCampLink(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campLink.click();
	}
	
	public void signOutOfApplication(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminIcon).perform();
		signOutLink.click();
		
	}
	

//******************************************************************************	
}
