package testNGListeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImplementation.class)
	public void retry()
	{
		System.out.println("-- try --");
		Assert.fail();
		System.out.println("-- try --");
	}
}
