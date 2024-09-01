package Headless_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class headlessBrowserLaunch 
{
	@Test
	public void mtd3()
	{
		WebDriver  driver = new HtmlUnitDriver();
		driver.get("https://www.google.com/");
		System.out.println("============without browser: done==========");
	}
	
	@Test
	public void mtd1()
	{
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--headless=new");
		WebDriver  driver1 =  new EdgeDriver(opt);
		driver1.get("https://www.google.com/");
		System.out.println("============EDGE | with browser at backend: done==========");
	}
	
	@Test
	public void mtd2()
	{
		FirefoxOptions opt = new FirefoxOptions();
		opt.addArguments("--headless=new");
		WebDriver  driver1 =  new FirefoxDriver(opt);
		driver1.get("https://www.google.com/");
		System.out.println("============EDGE | with browser at backend: done==========");
	}
	
	@Test
	public void mtd4()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver  driver2 = new ChromeDriver(options);
		driver2.get("https://www.google.com/");
		System.out.println("=========CHROME | with browser at backend: done==========");
		
	}	
	

	

	
}
