package AllModuleBackUpWithoutBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class DeleteProductTest 
{
	@Test
	public void delProdTest() throws Throwable
	{
		//Creating object for Generic Utilities
				FileUtility flib = new FileUtility();
				ExcelUtility elib = new ExcelUtility();
				JavaUtility jlib = new JavaUtility();
				WebDriverUtility wlib = new WebDriverUtility();
				
				//Get common data from Properties File
				String BROWSER=flib.getDataFromPropertiesFile("browser");
				String URL=flib.getDataFromPropertiesFile("url");
				String USERNAME=flib.getDataFromPropertiesFile("username");
				String PASSWORD=flib.getDataFromPropertiesFile("password");
				
				//Get browser data and launch
				WebDriver driver = null;
				if(BROWSER.equals("edge"))
				{
					driver = new EdgeDriver();
				}
				else if(BROWSER.equals("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(BROWSER.equals("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					driver = new EdgeDriver();
				}
				
				//Handle the browser 
				wlib.maximizeWindow(driver);
				wlib.waitForPageToLoad(driver);
				
				//Login to the application
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB+PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(2000);
				
				//Creating a product first
				//String ExpProdName="Dell_4562";
				driver.findElement(By.linkText("Products")).click();
				//driver.findElement(By.xpath("//table[@class='lvt small']/parent::div/descendant::tr[*]/td[*]/a[text()='Dell_4562']")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/parent::div/descendant::a[text()='Dell_2253']/parent::td/following-sibling::td/child::a[text()='del']")).click();
				
				wlib.switchToAlertAndAccept(driver);
				
	}
}
