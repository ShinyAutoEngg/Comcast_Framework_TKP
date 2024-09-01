package com.comcast.annotations.BaseClassTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.Business.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.DatabaseUtility.DatabaseUtility;
import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass_mavenParameters {
	public WebDriver driver = null;
	public static WebDriver sdriver =null; //For ListenerImplementationClass
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DatabaseUtility dblib = new DatabaseUtility();

	@BeforeSuite(groups ={"SmokeTest","RegressionTest"})
	public void ConfigBS() throws Throwable {
		dblib.getDbConnectionWithDefaultparameters();
		System.out.println("Before Suite===>connect to DB, Report Config - DONE");
	}

	@BeforeClass(groups ={"SmokeTest","RegressionTest"})
	
	public void ConfigBC() throws Throwable 
	{
		//passing parameters from maven command line
		String BROWSER = System.getProperty("browser");
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		sdriver = driver; //storing the current browser sessionID in sdriver static variable
		UtilityClassObject.setDriver(driver); 
		System.out.println("Before class===>Launch the browser - DONE");
	}

	@BeforeMethod(groups ={"SmokeTest","RegressionTest"})
	public void ConfigBM() throws Throwable {
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		wlib.getUrlAndNavigateToLoginPage(URL, driver);
		LoginPage lpPOM = new LoginPage(driver);
		lpPOM.LoginToApp(USERNAME, PASSWORD);
		System.out.println("Before Method==>Login to application - DONE");
	}

	@AfterMethod(groups ={"SmokeTest","RegressionTest"})
	public void ConfigAM() {
		HomePage hpPOM = new HomePage(driver);
		hpPOM.signOutOfApplication(driver);
		System.out.println("After Method==>Logout - DONE");
	}

	@AfterClass(groups ={"SmokeTest","RegressionTest"})
	public void ConfigAC() {
		driver.quit();
		System.out.println("After Class==>Close the browser - DONE");
	}

	@AfterSuite(groups ={"SmokeTest","RegressionTest"})
	public void ConfigAS() throws SQLException {
		dblib.closeDBConnection();
		System.out.println(" After Suite==>Close the configuration - DONE");
	}

}
