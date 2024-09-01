package mock_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class compareThrowsAndTryCatch 
{
	@Test
	public void exceldata() throws Throwable
	{
	FileInputStream fisXl= new FileInputStream("./testScriptData/Test.xlsx");
	Assert.assertEquals("sds", "erferf");
	System.out.println("djvh");
	}
	
	@Test
	public void exceldata1()
	{
	try {
		FileInputStream fisXl= new FileInputStream("./testScriptData12/Test.xlsx"); //INCORRECT PATH
	//	Assert.assertEquals("sds", "erferf");  ASSERT THROWS ASSERTION ERROR EVEN WHEN USING CATCH TO HANDLE
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();  //TEST PASSES BUT ERROR LOGS ARE PRINTED
		System.out.println("Exception handled===>");
	}
	System.out.println("djvh");
	}
}

