package ExtentRepPractice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(ExtentRepPractice.ListExtRep.class)
public class ExtentReports_demo 
{
	public static WebDriver driver;
	
	@Test
	public void demo()
	{
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://www.google.com/");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.findElement(By.xpath("//textarea[@class=\"gLFd34yf\"]")).click();
	}
}
