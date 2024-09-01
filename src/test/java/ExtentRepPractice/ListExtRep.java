package ExtentRepPractice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListExtRep implements ITestListener,ISuiteListener
{
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) 
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentPract.html");
		spark.config().setDocumentTitle("DemoDocTitle");
		spark.config().setReportName("DemoReportTitle");
		spark.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports(); 
		reports.attachReporter(spark);
		reports.setSystemInfo("OS","WINDOWS");
		reports.setSystemInfo("BROWSER","CHROME");
				
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "OnTestStart==>config,systeminfo,testcreation :DONE");
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		String tname=result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot)ExtentReports_demo.driver; 
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath);
		test.log(Status.FAIL,tname+" failed : Screenshot captured");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		test.log(Status.INFO, "Report flushed");
	}
}
