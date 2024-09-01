package AdditionalConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.Business.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.OrganizationsHomePage;
import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

public class ReporterLogs
{
	@Test
	public void createOrgTest() throws Throwable, Throwable
	{
		//Creating object for utility classes
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		//Read common data from Properties File
		String BROWSER =flib.getDataFromPropertiesFile("browser");
		String URL =flib.getDataFromPropertiesFile("url");
		String USERNAME =flib.getDataFromPropertiesFile("username");
		String PASSWORD =flib.getDataFromPropertiesFile("password");
				
		//Generate the random number
		
		int ranNum=jlib.getRandomNumber();
		
		//Read Test Script data from Excel
		String orgName=elib.getDataFromExcel("org", 1, 2)+ranNum;
		System.out.println("Org Name generated is : "+orgName);
		
		//Polymorphism concept implementation
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
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		//Step 1: Login to app
		driver.get(URL);
		LoginPage loginPOM = new LoginPage(driver);
		loginPOM.LoginToApp(USERNAME, PASSWORD);
		
		//Step 2: Navigate to Organization Module
		HomePage homePagePOM= new HomePage(driver);
		homePagePOM.getOrgLink().click();
				
		//Step 3: Click on "Create Organization" Button
		OrganizationsHomePage OrgPOM = new OrganizationsHomePage(driver);
		OrgPOM.getCreateOrgIcon().click();
					
		//Step 4: Enter all the details and create an organization
		CreateNewOrganizationPage cnOrgPOM= new CreateNewOrganizationPage(driver);
		cnOrgPOM.createNewOrg(orgName);
		
		//OrgInfoPOMPage object creation
		OrganizationInfoPage orgInfoPOM= new OrganizationInfoPage(driver);
		
		//Verify Header Detail with respect to Expected Result
		String HeaderDetails=orgInfoPOM.getOrgHeaderField().getText();
		System.out.println("Details of Header is : "+HeaderDetails);
		if(HeaderDetails.contains(orgName))
		{
			System.out.println("****OrgName is found in Header****: PASS");
		}
		else
		{
			System.out.println("****OrgName is NOT found in Header****: FAIL");
		}
		
		//Verify Header orgName info w.r.t Expected Result
		String orgNameCreated =orgInfoPOM.getOrgNameDtlView().getText();
		if(orgNameCreated.equals(orgName))
		{
			System.out.println(orgName+" is created successfully==PASS");
		}
		else
		{
			System.out.println(orgName+" is NOT created== FAIL");
		}
		
		
		//Step 5: Logout of the Application
		Thread.sleep(2000);
		homePagePOM.signOutOfApplication(driver);
		driver.quit();
		
		System.out.println("Execution was successful");

	}

}
