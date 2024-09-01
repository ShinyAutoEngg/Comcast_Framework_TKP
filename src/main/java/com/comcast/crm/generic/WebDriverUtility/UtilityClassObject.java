package com.comcast.crm.generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{  
	/*UtilityClassObject: This class helps to share the static variable by multiple threads
 in case of parallel execution */
	
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver)
	{
		driver.set(actDriver);
	}
	
	public static ExtentTest getTest()
	{
		return test.get();
	}
	
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
}
