package AllModuleBackUpWithBaseClass;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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


public class CreateContactWithSupportDateTest extends BaseClass
{
		@Test
			public void createNewContWithSuppTest() throws Throwable, Throwable
		{
									
			//Generate the random number
			int ranNum=jlib.getRandomNumber();
			
			//Read Test Script data from Excel
			String LastName=elib.getDataFromExcel("org", 1, 2)+ranNum;
			System.out.println("Contact Name generated is : "+LastName);
			
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
			
			//Generating the support date
			String SupportStartDate=jlib.getSystemDateAsYYYYMMDD();
			String SupportEndDate = jlib.getRequiredDateAsYYYYMMDD(30);
			cnContPOM.getSuppStartDateField().clear();
			cnContPOM.getSuppStartDateField().sendKeys(SupportStartDate);
			cnContPOM.getSuppEndDateField().clear();
			cnContPOM.getSuppEndDateField().sendKeys(SupportEndDate);
			
			//save the contact created	
			cnContPOM.getSaveContactButton().click();
			Thread.sleep(2000);
			
			//Verification 
			ContactsInfoPage contInfoPOM= new ContactsInfoPage(driver);
			
			//Verify header info w.r.t contact name
			String headerName=contInfoPOM.getContHeaderInfo().getText();
			if(headerName.contains(LastName))
			{
				System.out.println("Contact detail is driven == PASS");
			}
			else
			{
				System.out.println("Contact detail is not driven == FAIL");
			}
			
			//Verify contact last name
			String SavedLastName=contInfoPOM.getContLastNameInfo().getText();
			if(SavedLastName.equals(LastName))
			{
				System.out.println("Contact is created and verified == PASS");
			}
			else
			{
				System.out.println("Contact is not verified== FAIL");
			}
			
			//Verify the support start date 
			String SupportSDCreated=contInfoPOM.getSuppSDCreatedDtlView().getText();
			if(SupportSDCreated.contains(SupportStartDate))
			{
				System.out.println("Support start date is verified == PASS");
			}
			else
			{
				System.out.println("support start date is incorrect == FAIL");
			}
			
			//Verify the support end date 
			String SupportEDCreated=contInfoPOM.getSuppEDCreatedDtlView().getText();
			if(SupportEDCreated.contains(SupportEndDate))
			{
				System.out.println("Support End date is verified == PASS");
			}
			else
			{
				System.out.println("support End date is incorrect == FAIL");
			}
			
			System.out.println("Execution was successful");



	}
}
