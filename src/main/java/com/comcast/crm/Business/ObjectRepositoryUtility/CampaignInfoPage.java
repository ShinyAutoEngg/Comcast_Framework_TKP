package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	//Initialization
	WebDriver driver = null;
	public CampaignInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//td[@id='mouseArea_Campaign Name']")
	private WebElement campDtlView;
	
	@FindBy(xpath="//td[@id='mouseArea_Product']")
	private WebElement prodInCampDtlView;
	
	//Getters
	public WebElement getCampDtlView() {
		return campDtlView;
	}

	public WebElement getProdInCampDtlView() {
		return prodInCampDtlView;
	}

	
}
