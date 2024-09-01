package com.comcast.crm.generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	//***********************************************************************
	//MAXIMIZE
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	//***********************************************************************
	//IMPLICIT WAIT
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	//*********************************************************************
	//EXPLICIT WAIT
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisappear(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	//**************************************************************
	//To get the URL and handle the window
	public void getUrlAndNavigateToLoginPage(String url,WebDriver driver)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	//****************************************************************
	//WINDOW HANDLING
	public void switchToBrowserTabBasedOnURL(WebDriver driver, String partialURL)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			String windowID = iterator.next();
			driver.switchTo().window(windowID);
			String currentURL = driver.getCurrentUrl();
			if(currentURL.contains(partialURL))
			{
				break;
			}
		}
	}
		
	//**************************************************************************
	
	public void switchToBrowserTabBasedOnTitle(WebDriver driver, String PartialTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			String windowID = iterator.next();
			driver.switchTo().window(windowID);
			
			String CurrentWindowTitle = driver.getTitle();
			if(CurrentWindowTitle.contains(PartialTitle))
			{
				break;
			}
		}
	}
	
	//****************************************************************************
	//METHOD OVERLOADING  : FRAMES
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	//***************************************************************************
	//ALERTS
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{ 
		driver.switchTo().alert().dismiss();
	}
	
	//***********************************************************************
	//SELECT CLASS
	public void selectDropDown(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectDropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	   
	}
	
	public void deSelectDropDown(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	
	}
	
	//***************************************************************************
	//ACTIONS CLASS
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	
	//***************************************************************************
}
