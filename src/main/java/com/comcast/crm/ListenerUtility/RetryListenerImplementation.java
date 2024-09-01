package com.comcast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation implements IRetryAnalyzer{

	int count =0;
	int limitcount=10;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<limitcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
