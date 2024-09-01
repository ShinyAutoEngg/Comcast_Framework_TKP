package POMConceptsPrgmsDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutoHealing
{
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	//Use to implement OR condition - purposely failing 1st locator
	@FindAll({@FindBy(id="smitton"),@FindBy(xpath="//input[@type='submit']")})
	 private WebElement ele3;
	
	//Use to implement AND condition - purposely failing 1st locator
	@FindBys({@FindBy(id="smitton"),@FindBy(xpath="//input[@type='submit']")})
	 private WebElement ele4;
	
	@Test
	public void demo()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("http:localhost:8888");
		AutoHealing pf = PageFactory.initElements(driver, AutoHealing.class);
		
		pf.ele1.sendKeys("admin");
		pf.ele2.sendKeys("admin");
		pf.ele3.click();
	}
	
}
