package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgWithinContactPage {
	//Initialization
			WebDriver driver = null;
			public OrgWithinContactPage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
	//Declaration
			@FindBy(xpath="//input[@name='search_text']")
			private WebElement searchOrgField;
			
			@FindBy(xpath="//input[@type='button']")
			private WebElement searchOrgNowButton;
			
	//Getters		
			public WebElement getSearchOrgField() {
				return searchOrgField;
			}

			public WebElement getSearchOrgNowButton() {
				return searchOrgNowButton;
			}
		
}
