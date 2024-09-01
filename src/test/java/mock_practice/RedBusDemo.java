package mock_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class RedBusDemo 

{
	@Test
	public void redbus()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//span[text()='Date']")).click();
		driver.findElement(By.xpath("//button[@id='search_button']")).click();
	}
}
