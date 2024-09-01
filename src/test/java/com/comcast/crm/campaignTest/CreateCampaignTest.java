package com.comcast.crm.campaignTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.annotations.BaseClassTest.BaseClass;
import com.comcast.crm.Business.ObjectRepositoryUtility.CampaignHomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.CampaignInfoPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.CreateNewCampaignPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.CreateNewProductPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.ProductsPageWithinCampaignPage;
import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

public class CreateCampaignTest extends BaseClass {
	@Test
	public void createNewCampTest() throws Throwable {
		int day = 5;

		// Generate Random Number
		int ranNum = jlib.getRandomNumber();

		// Get TestData from Excel File
		String ExpCampName = elib.getDataFromExcel("campaign", 1, 3) + ranNum;
		String ExpProdName = elib.getDataFromExcel("campaign", 1, 2) + ranNum;
		String CampType = elib.getDataFromExcel("campaign", 1, 4);
		String CampPageUrl = elib.getDataFromExcel("campaign", 1, 5);
		String ProdPageUrl = elib.getDataFromExcel("campaign", 1, 6);

		Thread.sleep(2000);

		// Creating a product first
		HomePage homePagePOM = new HomePage(driver);
		homePagePOM.getProdLink().click();

		// Create New Product
		CreateNewProductPage cnpPOM = new CreateNewProductPage(driver);
		cnpPOM.getCreateNewProdPlusIcon().click();
		cnpPOM.getProdNameField().sendKeys(ExpProdName);
		cnpPOM.getSaveProdButton().click();

		// click on campaigns from more
		homePagePOM.navigateToCampLink(driver);

		// Click create new Campaign icon in Campaigns Home Page
		CampaignHomePage camphpPOM = new CampaignHomePage(driver);
		camphpPOM.getcreateNewCampPlusIcon().click();

		// Enter the details and create a campaign
		CreateNewCampaignPage cncampPOM = new CreateNewCampaignPage(driver);
		cncampPOM.getCampNameField().sendKeys(ExpCampName);

		// select campaign type from dropdown
		WebElement CampTypeDD = cncampPOM.getCampTypeDD();
		wlib.selectDropDown(CampTypeDD, CampType);

		// select closing date
		String ExpCloseDate = jlib.getRequiredDateAsYYYYMMDD(30);
		WebElement ExpCloseDateField = cncampPOM.getCloseDateField();
		ExpCloseDateField.clear();
		ExpCloseDateField.sendKeys(ExpCloseDate);

		// click the product selection icon within campaign
		cncampPOM.getselectProdPlusIcon().click();
		// Switch to Product window
		wlib.switchToBrowserTabBasedOnURL(driver, ProdPageUrl);
		// Search for the product created
		ProductsPageWithinCampaignPage prodInCampPOM = new ProductsPageWithinCampaignPage(driver);
		prodInCampPOM.getSearchProdField().sendKeys(ExpProdName);
		prodInCampPOM.getSearchProdNowButton().click();
		// dynamic element handling
		driver.findElement(By.xpath("//a[text()='" + ExpProdName + "']")).click();

		// switch back to campaign window
		wlib.switchToBrowserTabBasedOnURL(driver, CampPageUrl);

		// save the campaign
		cncampPOM.getSaveCampButton().click();
		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		// Verification
		CampaignInfoPage campInfoPOM = new CampaignInfoPage(driver);
		// Verification of campaign
		String CampCreated = campInfoPOM.getCampDtlView().getText();
		if (CampCreated.trim().equals(ExpCampName)) {
			System.out.println("CampaignName is verified from list==PASS");
		} else {
			System.out.println("CampaignName is incorrectly selected==FAIL");
		}

		// Verification of product
		String ProdSelected = campInfoPOM.getProdInCampDtlView().getText();
		if (ProdSelected.trim().equals(ExpProdName)) {
			System.out.println("ProductName is verified==PASS");
		} else {
			System.out.println("Product is incorrectly selected==FAIL");
		}

		System.out.println("createNewCampTest: EXECUTION SUCCESS");

	}
}
