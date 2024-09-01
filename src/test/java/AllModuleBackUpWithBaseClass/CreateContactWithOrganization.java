package AllModuleBackUpWithBaseClass;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.comcast.crm.Business.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.OrgWithinContactPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.Business.ObjectRepositoryUtility.OrganizationsHomePage;
import com.comcast.crm.generic.ExcelUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class CreateContactWithOrganization extends BaseClass {
	@Test
	public void createNewContWithOrgTest() throws Throwable, Throwable {
		// Generate the random number
		int ranNum = jlib.getRandomNumber();

		// Read Test Script data from Excel
		String ConLastName = elib.getDataFromExcel("contact", 7, 3) + ranNum;
		System.out.println("Contact Name generated is : " + ConLastName);

		String orgName = elib.getDataFromExcel("contact", 7, 2) + ranNum;
		System.out.println("Org Name generated is : " + orgName);

		String OrgWindowUrl = elib.getDataFromExcel("contact", 7, 4);
		String ContWindowUrl = elib.getDataFromExcel("contact", 7, 5);

		Thread.sleep(2000);

		// Create an organization
		HomePage homePagePOM = new HomePage(driver);
		homePagePOM.getOrgLink().click();

		// Step 3: Click on "Create Organization" Button
		OrganizationsHomePage OrgPOM = new OrganizationsHomePage(driver);
		OrgPOM.getCreateOrgIcon().click();

		// Step 4: Enter all the details and create an organization
		CreateNewOrganizationPage cnOrgPOM = new CreateNewOrganizationPage(driver);
		cnOrgPOM.createNewOrg(orgName);

		// Verification of organization
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

		Thread.sleep(3000);

		// Creating a contact
		// Click on contacts link
		homePagePOM.getConLink().click();

		// Click on create new contact
		ContactHomePage contHpPOM = new ContactHomePage(driver);
		contHpPOM.getCreateNewContPlusIcon().click();

		// Enter the contact LastName
		CreateNewContactPage cnContPOM = new CreateNewContactPage(driver);
		cnContPOM.getContLastNameField().sendKeys(ConLastName);

		// Selecting organization within contact
		cnContPOM.getOrgNameInContPlusIcon().click();

		// switch to child window
		wlib.switchToBrowserTabBasedOnURL(driver, OrgWindowUrl);

		// Select the organization name from child window
		OrgWithinContactPage orgInContPOM = new OrgWithinContactPage(driver);
		orgInContPOM.getSearchOrgField().sendKeys(orgName);
		orgInContPOM.getSearchOrgNowButton().click();

		// Selecting the Org - dynamic element
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch back to parent window
		wlib.switchToBrowserTabBasedOnURL(driver, ContWindowUrl);

		// save the contact
		cnContPOM.getSaveContactButton().click();

		Thread.sleep(2000);

		// Verification of contact
		ContactsInfoPage contInfoPOM = new ContactsInfoPage(driver);
		// Verifying header info w.r.t contact name
		String headerName = contInfoPOM.getContHeaderInfo().getText();
		if (headerName.contains(ConLastName)) {
			System.out.println("Contact detail is driven == PASS");
		} else {
			System.out.println("Contact detail is not driven == FAIL");
		}

		// Verify contact Last name created w.r.t contact name
		String SavedLastName = contInfoPOM.getContLastNameInfo().getText();
		if (SavedLastName.equals(ConLastName)) {
			System.out.println("Contact is created and verified == PASS");
		} else {
			System.out.println("Contact is not verified== FAIL");
		}

		// Verify org name within contact
		String orgNameSavedInCont = contInfoPOM.getOrgSavedInConDtlView().getText();
		if (orgNameSavedInCont.trim().equals(orgName)) {
			System.out.println("Org within contact is verified == PASS");
		} else {
			System.out.println("Org within contact is verified == FAIL");
		}

		System.out.println("Execution was successful");

	}

}
