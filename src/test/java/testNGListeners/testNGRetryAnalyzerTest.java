package testNGListeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGRetryAnalyzerTest 
{
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImplementation.class)
	public void activateSim()
	{
		System.out.println("Execute createInvoiceTest");
		Assert.fail();
		
		System.out.println("Step--1");
		System.out.println("Step--2");
		System.out.println("Step--3");
		
	}
}
