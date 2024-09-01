package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Initialization
			WebDriver driver = null;
			public ContactsInfoPage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	//Declaration
			@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement contHeaderInfo;
			
			@FindBy(id="dtlview_Last Name")
			private WebElement contLastNameInfo;
			
			@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
			private WebElement orgSavedInConDtlView;
			
			@FindBy(xpath="//span[@id='dtlview_Support Start Date']")
			private WebElement suppSDCreatedDtlView;
			
			@FindBy(xpath="//span[@id='dtlview_Support End Date']")
			private WebElement suppEDCreatedDtlView;
			
	//Getters	
			public WebElement getContHeaderInfo() {
				return contHeaderInfo;
			}

			public WebElement getContLastNameInfo() {
				return contLastNameInfo;
			}

			public WebElement getOrgSavedInConDtlView() {
				return orgSavedInConDtlView;
			}

			public WebElement getSuppSDCreatedDtlView() {
				return suppSDCreatedDtlView;
			}

			public WebElement getSuppEDCreatedDtlView() {
				return suppEDCreatedDtlView;
			}
			
			
}
