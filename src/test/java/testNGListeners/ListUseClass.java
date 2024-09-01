package testNGListeners;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(testNGListeners.ListenerPract.class)
public class ListUseClass 
{
	public static WebDriver driver;
	@Test
	public void m1()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://ide.geeksforgeeks.org/UeWewe");
		String title=driver.getTitle();
		Assert.assertEquals(title, "abc");
	}
}
