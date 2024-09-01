package mock_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ExcelUtility.ExcelUtility;

public class DataProvider_Mock 
{
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		int rowCount=elib.getRowCount("MockData");
	Object[][] obj = new Object[rowCount][2];
	for (int i=0;i<rowCount;i++)
	{
		obj[i][0] = elib.getDataFromExcel("MockData", i+1, 0);
		obj[i][1] = elib.getDataFromExcel("MockData", i+1, 1);
	}
	
		
		return obj;
	}
	
	@Test(dataProvider="getData")
	public void test(String fn, String ln)
	{
		System.out.println("First Name :"+fn+"/t"+"LastName :"+ln);
	}	
}
