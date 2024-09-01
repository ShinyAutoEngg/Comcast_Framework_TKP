package AllModuleBackUpWithBaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class DeleteOrgTest extends BaseClass
{
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
		
		System.out.println("delOrgTest: EXECUTION SUCCESS");

	}
}
