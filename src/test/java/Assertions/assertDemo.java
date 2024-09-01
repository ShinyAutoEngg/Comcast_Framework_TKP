package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class assertDemo 
{
	@Test
	public void checkAssert()
	{
		String a="Shiny";
		String b="Ingrid";
		String c="Shiny";
		String d=null;
		boolean flag=true;
		boolean flag2=false;
		Assert.assertEquals(a, c);
		Assert.assertNotEquals(a, b);
		Assert.assertTrue(flag);
		Assert.assertFalse(flag2);
		Assert.assertNotNull(c);
		Assert.assertNull(d);
		Assert.assertSame(a, c);
		Assert.assertNotSame(c, d);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(flag, flag2);
		sa.assertTrue(flag);
		sa.assertNull(c);
	    sa.assertAll();
		Assertion hardAssert = new Assertion();
		hardAssert.assertEquals(flag, flag);
		Assertion softAssert = new SoftAssert();
		softAssert.assertEquals(flag, flag2);  //doesnt have assert all method
		
	}
}
