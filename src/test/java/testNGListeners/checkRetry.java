package testNGListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class checkRetry 
{
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImplementation.class)
	public void checkingRetry()
	{
		System.out.println("Hello World - 1");
		System.out.println("Hello World-1");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Hello World-3");
		System.out.println("Hello World-4");
		
		
	}
}
