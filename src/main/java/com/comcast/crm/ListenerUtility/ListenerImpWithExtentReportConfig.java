package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.annotations.BaseClassTest.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;

public class ListenerImpWithExtentReportConfig implements ITestListener, ISuiteListener
{
		public ExtentReports report;
		public static ExtentTest test; //Global: to use test and take screenshot in onTestFailure()
	//above -public static : to use it in the testscript for lowlevel logs
	//problem is: making it static without threads, parallel execution is not possible	
	@Override
	public void onStart(ISuite suite) {
		//Similar to Before Suite. Executes before suite
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Test Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Edge");
		//test.log(Status.INFO,"onStart ==> Report Configuration");
	}


	@Override
	public void onTestStart(ITestResult result)
	{
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,"onTestStart==>"+result.getMethod().getMethodName()+"===STARTED===");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
				
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filePath= ts.getScreenshotAs(OutputType.BASE64);
	
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time+".png");
		
		test.log(Status.FAIL, "OnTestFailure==>"+result.getMethod().getMethodName()+"====FAILED=====");
//		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS,"onTestSuccess==>"+result.getMethod().getMethodName()+"====COMPLETED=====");
		
	}
		
	@Override
	public void onFinish(ISuite suite) {
		
		report.flush();
		test.log(Status.INFO,"onFinish==> REPORT BACKUP");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		context.getFailedButWithinSuccessPercentageTests();
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	
		String testName = result.getMethod().getMethodName();
//		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, testName+" -- skipped");
	}

}
