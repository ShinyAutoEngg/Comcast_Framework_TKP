package POMConceptsPrgmsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.Business.ObjectRepositoryUtility.LoginPage;

public class PageFactoryUsage 
{@Test
	public void pageFactDemo()
	{
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8888");
	
	//Creating an object for LoginPage class using PageFactory
	LoginPage pf = PageFactory.initElements(driver, LoginPage.class);
	//Since the elements are declared private, we can read only using getters
	pf.getUsernameEdit().sendKeys("admin");
	pf.getPasswordEdit().sendKeys("admin");
	pf.getLoginButton().click();
	
	//If the webelements are declared public
	/* Then
	 * pf.usernameEdit.sendKeys("admin");
	 * pf.passwordEdit.sendKeys("admin");
	 * pf.loginButton.click();
	 */
	driver.quit();
	
	}
}
