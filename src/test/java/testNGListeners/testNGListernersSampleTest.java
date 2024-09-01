package testNGListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.annotations.BaseClassTest.BaseClass;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementation.class)
public class testNGListernersSampleTest extends BaseClass
{
	@Test
	public void createInvoiceTest()
	{
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "LogIn");
		System.out.println("Step -1");
		System.out.println("Step -2");
		System.out.println("Step -3");
		System.out.println("Step -4");
		System.out.println("Step -5");
		System.out.println("Execute createInvoiceTest ");
	}
	
	@Test
	public void createInvoiceWithContact()
	{
		System.out.println("======================================");
		System.out.println("Step -1");
		System.out.println("Step -2");
		System.out.println("Step -3");
		System.out.println("Step -4");
		System.out.println("Step -5");
		System.out.println("Execute createInvoiceWithContact");
	}
}
