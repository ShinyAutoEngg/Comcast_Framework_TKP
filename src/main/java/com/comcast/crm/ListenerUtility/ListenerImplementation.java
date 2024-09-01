package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.annotations.BaseClassTest.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;

public class ListenerImplementation implements ITestListener, ISuiteListener
{

	@Override
	public void onFinish(ISuite suite) {
		
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestStart==>"+result.getMethod().getMethodName()+"===STAR===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess==>"+result.getMethod().getMethodName()+"====END=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testName = result.getMethod().getMethodName();
		try {
			//JavaUtility jlib = new JavaUtility();
		//	String time =jlib.getTimeStampDetailsforScreenshot();
			TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
//		String path = "./screenshot/"+testName+".png";
		File dst = new File("./screenshot/"+testName+new JavaUtility().getTimeStampDetailsforScreenshot()+".png");
			FileUtils.copyFile(srcFile, dst );
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart ==> Report Configuration");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("OnFinish==>Report Backup");
	}
	
}
