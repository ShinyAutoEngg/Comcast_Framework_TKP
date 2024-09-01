package mock_practice;

import java.io.IOException;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;

import com.comcast.crm.generic.ExcelUtility.ExcelUtility_Advanced;

public class DDT_dummy 
{
	public static void main(String[] args) throws Throwable, IOException
	{
		ExcelUtility_Advanced elib = new ExcelUtility_Advanced("./src/test/resources/dummy123.xlsx");
		elib.setDataToNewSheetExcel("LuckySheet", 0, 1, "Work");
		System.out.println("Done");
		
		URL url =new URL("http://www.google.com");
	}
}
