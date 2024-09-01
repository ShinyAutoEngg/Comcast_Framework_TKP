package com.comcast.crm.Business.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Rule 1: Create a separate java class
	
	//Rule 3: Create a constructor and initialize
	public LoginPage(WebDriver driver) // takes care of initialization
	{
		PageFactory.initElements(driver, this); //this means current object reference
	}
	
	//Rule 2: Object Creation - Identify all the elements
	@FindBy(name="user_name")
	private WebElement usernameEdit; //Rule 4: private access specifier - Encapsulation
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	//Rule 4: Object Encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	// Rule 5: Object Utilization / Business Library
	
	public void LoginToApp(String username, String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
	}
	

}
