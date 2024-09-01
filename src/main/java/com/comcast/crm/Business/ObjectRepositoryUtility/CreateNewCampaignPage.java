package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	//Initialization
		WebDriver driver = null;
		public CreateNewCampaignPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		//Declaration
		@FindBy(xpath = "//input[@name='campaignname']")
		private WebElement campNameField;
		
		@FindBy(xpath="//select[@name='campaigntype']")
		private WebElement campTypeDD;
		
		@FindBy(xpath="//input[@name='closingdate']")
		private WebElement closeDateField;
		
		@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
		private WebElement selectProdPlusIcon;
		
		@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
		private WebElement saveCampButton;

		//Getters
		public WebElement getCampNameField() {
			return campNameField;
		}

		public WebElement getCampTypeDD() {
			return campTypeDD;
		}

		public WebElement getCloseDateField() {
			return closeDateField;
		}
		
		public WebElement getselectProdPlusIcon() {
			return selectProdPlusIcon;
		}

		public WebElement getSaveCampButton() {
			return saveCampButton;
		}


}
