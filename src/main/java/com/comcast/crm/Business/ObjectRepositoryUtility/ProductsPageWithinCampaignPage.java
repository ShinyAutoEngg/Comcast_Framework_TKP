package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPageWithinCampaignPage {

	//Initialization
			WebDriver driver = null;
			public ProductsPageWithinCampaignPage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
			//Declaration
			@FindBy(xpath="//input[@name='search_text']")
			private WebElement searchProdField;
			
			@FindBy(xpath="//input[@type='button']")
			private WebElement searchProdNowButton;
			
			//Getters
			public WebElement getSearchProdField() {
				return searchProdField;
			}

			public WebElement getSearchProdNowButton() {
				return searchProdNowButton;
			}
			
			
			
	}
