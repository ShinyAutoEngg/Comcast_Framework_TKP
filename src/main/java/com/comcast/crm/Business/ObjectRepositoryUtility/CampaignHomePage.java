package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignHomePage
{
	//Initialization
	WebDriver driver = null;
	public CampaignHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewCampPlusIcon;
	
	//Getter
	public WebElement getcreateNewCampPlusIcon() {
		return createNewCampPlusIcon;
	}
}
