package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver = null;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameField;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement orgPhoneField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement orgSaveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement orgIndustryDD;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement orgTypeDD;
	
	//Getters
	public WebElement getOrgNameField() {
		return orgNameField;
	}

	public WebElement getOrgPhoneField() {
		return orgPhoneField;
	}

	public WebElement getOrgSaveBtn() {
		return orgSaveBtn;
	}
	
	public WebElement getOrgIndustryDD()
	{
		return orgIndustryDD;
	}
	
	public WebElement getOrgTypeDD()
	{
		return orgTypeDD;
	}

	//Business Logic
	//Create Org only with Org Name
	public void createNewOrg(String orgName)
	{
		orgNameField.sendKeys(orgName);
		orgSaveBtn.click();
	}
	
	//Create Org with Org Name and Phone Number
	public void createNewOrgWithPhNo(String orgName,String phoneNo)
	{
		orgNameField.sendKeys(orgName);
		orgPhoneField.sendKeys(phoneNo);
		orgSaveBtn.click();
	}
	
	public void createNewOrg(String orgName,String industry)
	{
		orgNameField.sendKeys(orgName);
		Select sel = new Select(orgIndustryDD);
		sel.selectByVisibleText(industry);
		orgSaveBtn.click();
	}
	
	public void createNewOrg(String orgName,String industry,String type)
	{
		orgNameField.sendKeys(orgName);
		
		Select sel = new Select(orgIndustryDD);
		sel.selectByVisibleText(industry);
		
		Select sel1 = new Select(orgTypeDD);
		sel1.selectByVisibleText(type);
		
		orgSaveBtn.click();
	}
}
