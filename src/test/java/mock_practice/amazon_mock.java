package mock_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class amazon_mock
{
	@Test
	public void iphone()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
//		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14 pro");
//		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//		String data = driver.findElement(By.xpath("(//div[@class='a-section'])[2]/div/div[2]/div/div/div[3]/div/div/div[1]/div[1]/div[1]")).getText();
//		System.out.println(data);
	}
}
