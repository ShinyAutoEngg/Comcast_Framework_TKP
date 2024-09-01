package AllModuleBackUpWithBaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustriesTest extends BaseClass {
	@Test
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
}
