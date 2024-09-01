package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsHomePage
{
	//Initialization
	WebDriver driver = null;
	public OrganizationsHomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgIcon;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchForOrgField;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement orgSearchByDD;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	//Getter
	public WebElement getCreateOrgIcon()
	{
		return CreateOrgIcon;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchForOrgField() {
		return searchForOrgField;
	}

	public WebElement getOrgSearchByDD() {
		return orgSearchByDD;
	}
	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
}
