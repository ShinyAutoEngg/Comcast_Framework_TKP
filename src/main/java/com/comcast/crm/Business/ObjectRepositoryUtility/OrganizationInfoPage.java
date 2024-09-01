package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Initialization
		WebDriver driver = null;
		public OrganizationInfoPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	//******************************************************************************	
		//Object Identification / Declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderField;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameDtlView;
	
	@FindBy(id="dtlview_Industry")
	private WebElement orgIndDtlView;
	
	@FindBy(id="dtlview_Type")
	private WebElement orgTypeDtlView;
	
	@FindBy(xpath="//td[@id='mouseArea_Phone']")
	private WebElement orgPhoneNoDtlView;
	
	//Getters
	public WebElement getOrgHeaderField() {
		return orgHeaderField;
	}

	public WebElement getOrgNameDtlView() {
		return orgNameDtlView;
	}

	public WebElement getOrgIndDtlView() {
		return orgIndDtlView;
	}

	public WebElement getOrgTypeDtlView() {
		return orgTypeDtlView;
	}
	
	public WebElement getOrgPhoneNoDtlView() {
		return orgPhoneNoDtlView;
	}


	
	
}
