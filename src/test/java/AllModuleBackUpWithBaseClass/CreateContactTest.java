package AllModuleBackUpWithBaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.annotations.BaseClassTest.BaseClass;
import com.comcast.crm.Business.ObjectRepositoryUtility.ContactHomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.ContactsInfoPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.CreateNewContactPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;


public class CreateContactTest extends BaseClass
{
		@Test(groups="RegressionTest")
			public void createNewContTest() throws Throwable, Throwable
		{
			//Generate the random number
			int ranNum=jlib.getRandomNumber();
			
			//Read Test Script data from Excel
			String LastName=elib.getDataFromExcel("contact", 1, 2)+ranNum;
			Reporter.log("Contact Name generated is : "+LastName);
			
			Thread.sleep(2000);
			
			//Click on Contacts from homePage
			HomePage hpPOM= new HomePage(driver);
			hpPOM.getConLink().click();
			
			//Click on create contact plus icon
			ContactHomePage contHpPOM= new ContactHomePage(driver);
			contHpPOM.getCreateNewContPlusIcon().click();
			
			//Enter the contact details and save the contact
			CreateNewContactPage cnContPOM= new CreateNewContactPage(driver);
			cnContPOM.getContLastNameField().sendKeys(LastName);
			cnContPOM.getSaveContactButton().click();
			
			Thread.sleep(2000);
			
			//Verification 
			ContactsInfoPage contInfoPOM= new ContactsInfoPage(driver);
			//Verify header infor w.r.t contact name
			String headerName=contInfoPOM.getContHeaderInfo().getText();
			if(headerName.contains(LastName))
			{
				Reporter.log("Contact detail is driven == PASS");
			}
			else
			{
				Reporter.log("Contact detail is not driven == FAIL");
			}
			
			//Verify cont last name
			String SavedLastName=contInfoPOM.getContLastNameInfo().getText();
			if(SavedLastName.equals(LastName))
			{
				Reporter.log("Contact is created and verified == PASS");
			}
			else
			{
				Reporter.log("Contact is not verified== FAIL");
			}
			
			//Step 5: Logout of the Application

			Reporter.log("Execution was successful");



	}
}
