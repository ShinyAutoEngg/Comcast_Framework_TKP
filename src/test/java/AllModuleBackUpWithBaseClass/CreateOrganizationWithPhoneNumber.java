package AllModuleBackUpWithBaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
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

public class CreateOrganizationWithPhoneNumber extends BaseClass {
	@Test
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

}
