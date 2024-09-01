package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	//Initialization
		WebDriver driver = null;
		public CreateNewContactPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//Declaration
		@FindBy(name="lastname")
		private WebElement contLastNameField;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement orgNameInContPlusIcon;
		
		@FindBy(name="support_start_date")
		private WebElement suppStartDateField;
		
		@FindBy(name="support_end_date")
		private WebElement suppEndDateField;
		
		@FindBy(xpath="(//input[@type='submit'])[2]")
		private WebElement saveContactButton;
		
	//Getters	
		public WebElement getContLastNameField() {
			return contLastNameField;
		}

		public WebElement getOrgNameInContPlusIcon() {
			return orgNameInContPlusIcon;
		}

		public WebElement getSuppStartDateField() {
			return suppStartDateField;
		}

		public WebElement getSuppEndDateField() {
			return suppEndDateField;
		}

		public WebElement getSaveContactButton() {
			return saveContactButton;
		}
		
		
		
}
