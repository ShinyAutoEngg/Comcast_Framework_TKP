package testNGListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerPract implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts =(TakesScreenshot)ListUseClass.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot"+new Date().getTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
