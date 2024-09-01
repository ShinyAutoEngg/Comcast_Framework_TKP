package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage
{
	//Initialization
	WebDriver driver = null;
	public CreateNewProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewProdPlusIcon;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prodNameField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveProdButton;

	//Getters
	public WebElement getCreateNewProdPlusIcon() {
		return createNewProdPlusIcon;
	}

	public WebElement getProdNameField() {
		return prodNameField;
	}

	public WebElement getSaveProdButton() {
		return saveProdButton;
	}
	
	
}
