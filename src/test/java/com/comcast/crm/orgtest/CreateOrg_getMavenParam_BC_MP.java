package com.comcast.crm.orgtest;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.annotations.BaseClassTest.BaseClass;
import com.comcast.annotations.BaseClassTest.BaseClass_mavenParameters;
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

public class CreateOrg_getMavenParam_BC_MP extends BaseClass_mavenParameters {
	
//TEST CASE : Create Org with mandatory fields
	
	@Test(groups="SmokeTest")
	public void createNewOrgTest() throws Throwable, Throwable {

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
		boolean status=HeaderDetails.contains(orgName);
		Assert.assertTrue(status);
		
		// Verify Header orgName info w.r.t Expected Result
		String orgNameCreated = orgInfoPOM.getOrgNameDtlView().getText();
		Assert.assertEquals(orgName, orgNameCreated);;
		

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
		Assert.assertEquals(ActIndName, ExpindName);

		// Verify Type created Detail with respect to Expected Result
		String ActTypeName = orgInfoPOM.getOrgTypeDtlView().getText();
		Assert.assertEquals(ExptypeName, ActTypeName);


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
		boolean status=HeaderDetails.contains(ExporgName);
		Assert.assertTrue(status);

		// Verify OrgCreated Details with respect to Phone
		String ActPhNo = orgInfoPOM.getOrgPhoneNoDtlView().getText();
		Assert.assertEquals(ExpPhNo.trim(), ActPhNo.trim());

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
		boolean status=HeaderDetails.contains(orgName);
		Assert.assertTrue(status);
		
		//Verify Header orgName info w.r.t Expected Result
		String orgNameCreated =orgInfoPOM.getOrgNameDtlView().getText();
		Assert.assertEquals(orgName, orgNameCreated);
		
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
