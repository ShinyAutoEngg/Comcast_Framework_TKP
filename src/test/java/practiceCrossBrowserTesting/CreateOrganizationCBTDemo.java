package practiceCrossBrowserTesting;

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

import com.comcast.annotations.BaseClassTest.BaseClass;
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

public class CreateOrganizationCBTDemo extends BaseClass_CBT {
	
//TEST CASE : Create Org with mandatory fields
	
	@Test(groups="SmokeTest")
	public void createOrgTest() throws Throwable, Throwable {

		// Navigate to Organization Module
		HomePage homePagePOM = new HomePage(driver);
		homePagePOM.getOrgLink().click();

		// Click on "Create Organization" Button
		OrganizationsHomePage OrgPOM = new OrganizationsHomePage(driver);
		OrgPOM.getCreateOrgIcon().click();

		// Generate the random number
		int ranNum = jlib.getRandomNumber();

		// Read Test Script data from Excel
		String orgName = elib.getDataFromExcel("org", 1, 2) + ranNum;
		System.out.println("Org Name generated is : " + orgName);

		// Enter all the details and create an organization
		CreateNewOrganizationPage cnOrgPOM = new CreateNewOrganizationPage(driver);
		cnOrgPOM.createNewOrg(orgName);

		// OrgInfoPOMPage object creation
		OrganizationInfoPage orgInfoPOM = new OrganizationInfoPage(driver);

		// Verify Header Detail with respect to Expected Result
		String HeaderDetails = orgInfoPOM.getOrgHeaderField().getText();
		System.out.println("Details of Header is : " + HeaderDetails);
		if (HeaderDetails.contains(orgName)) {
			System.out.println("****OrgName is found in Header****: PASS");
		} else {
			System.out.println("****OrgName is NOT found in Header****: FAIL");
		}

		// Verify Header orgName info w.r.t Expected Result
		String orgNameCreated = orgInfoPOM.getOrgNameDtlView().getText();
		if (orgNameCreated.equals(orgName)) {
			System.out.println(orgName + " is created successfully==PASS");
		} else {
			System.out.println(orgName + " is NOT created== FAIL");
		}

		System.out.println("createOrgTest : EXECUTION SUCCESS");
	}
	
	
//**************************************************************************	
	//TEST CASE : Create Org with Industry
	
	@Test(groups="RegressionTest")
	public void createOrgWithIndTest() throws Throwable, Throwable {

		// Generate the random number
		int ranNum = jlib.getRandomNumber();

		// Read Test Script data from Excel
		String ExporgName = elib.getDataFromExcel("org", 1, 2) + ranNum;
		System.out.println("Org Name generated is : " + ExporgName);
		String ExpindName = elib.getDataFromExcel("org", 5, 3);
		System.out.println("Industry name to be selected is : " + ExpindName);
		String ExptypeName = elib.getDataFromExcel("org", 5, 4);
		System.out.println("Type to be selected is : " + ExptypeName);

		// Navigate to Organization Module
		HomePage homePagePOM = new HomePage(driver);
		homePagePOM.getOrgLink().click();

		// Click on "Create Organization" Button
		OrganizationsHomePage OrgPOM = new OrganizationsHomePage(driver);
		OrgPOM.getCreateOrgIcon().click();

		// Enter all the details and create an organization
		CreateNewOrganizationPage cnoPOM = new CreateNewOrganizationPage(driver);
		cnoPOM.createNewOrg(ExporgName, ExpindName, ExptypeName);

		// Object creation for Organization Info POM page
		OrganizationInfoPage orgInfoPOM = new OrganizationInfoPage(driver);
		// Verify Industry created Detail with respect to Expected Result
		String ActIndName = orgInfoPOM.getOrgIndDtlView().getText();
		if (ActIndName.equals(ExpindName)) {
			System.out.println();
			System.out.println(ExpindName + " is selected : PASS");
		} else {
			System.out.println();
			System.out.println(ExpindName + " is not selected : FAIL");
		}

		// Verify Type created Detail with respect to Expected Result
		String ActTypeName = orgInfoPOM.getOrgTypeDtlView().getText();
		if (ActTypeName.equals(ExptypeName)) {
			System.out.println();
			System.out.println(ExptypeName + " is selected : PASS");
		} else {
			System.out.println();
			System.out.println(ExptypeName + " is not selected : FAIL");
		}

		System.out.println("createOrgWithIndTest : EXECUTION SUCCESS");
	}

//*************************************************************
	//TEST CASE : Create Org with PhoneNumber
	
	@Test(groups="SmokeTest")
	public void createOrgWithPhNoTest() throws Throwable, Throwable {

		// Generate the random number
		int ranNum = jlib.getRandomNumber();

		// Read Test Script data from Excel
		String ExporgName = elib.getDataFromExcel("org", 9, 2) + ranNum;
		System.out.println("Org Name generated is : " + ExporgName);
		String ExpPhNo = elib.getDataFromExcel("org", 9, 3) + ranNum;
		System.out.println("Phone number generated is : " + ExpPhNo);

		// Navigate to Organization Module
		HomePage homePagePOM = new HomePage(driver);
		homePagePOM.getOrgLink().click();

		// Click on "Create Organization" Button
		OrganizationsHomePage OrgPOM = new OrganizationsHomePage(driver);
		OrgPOM.getCreateOrgIcon().click();

		// Enter all the details and create an organization
		CreateNewOrganizationPage cnOrgPOM = new CreateNewOrganizationPage(driver);
		cnOrgPOM.createNewOrgWithPhNo(ExporgName, ExpPhNo);

		// Verify Header Detail with respect to Expected Result
		OrganizationInfoPage orgInfoPOM = new OrganizationInfoPage(driver);

		// Verify Header Detail with respect to OrgName
		String HeaderDetails = orgInfoPOM.getOrgHeaderField().getText();
		System.out.println("Details of Header is : " + HeaderDetails);
		if (HeaderDetails.contains(ExporgName)) {
			System.out.println("****OrgName is found in Header****: PASS");
		} else {
			System.out.println("****OrgName is NOT found in Header****: FAIL");
		}

		// Verify OrgCreated Details with respect to Phone
		String ActPhNo = orgInfoPOM.getOrgPhoneNoDtlView().getText();
		if (ActPhNo.contains(ExpPhNo)) {
			System.out.println("Phone Number is verified == PASS");
		} else {
			System.out.println("Phone Number is NOT verified == FAIL");
		}

		System.out.println("createOrgWithPhNoTest : EXCUTION SUCCESS");

	}

//***************************************************************************
	//TEST CASE 4: Create Org and Delete the same
	
	@Test
	public void CreateAnddelOrgTest() throws Throwable, Throwable
	{
				
		//Generate the random number
		int ranNum=jlib.getRandomNumber();
		
		//Read Test Script data from Excel
		String orgName=elib.getDataFromExcel("org", 12, 2)+ranNum;
		System.out.println("Org Name generated is : "+orgName);
		String orgSearchBy=elib.getDataFromExcel("org", 12, 4);
		
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
		
		
		//Go to organizations page,select the org created and delete
		homePagePOM.getOrgLink().click();
		OrgPOM.getSearchForOrgField().sendKeys(orgName);
		WebElement orgSearchByDD = OrgPOM.getOrgSearchByDD();
		wlib.selectDropDown(orgSearchByDD, orgSearchBy);
		OrgPOM.getSearchNowButton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		wlib.switchToAlertAndAccept(driver);
		
		System.out.println("CreateAnddelOrgTest: EXECUTION SUCCESS");

	}


}
