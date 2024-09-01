package AdditionalConcepts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ExcelUtility.ExcelUtility_Advanced;

public class dummy 
{
	@Test
	public void dum() throws Throwable, IOException
	{
//		WebDriver driver = new EdgeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.google.com/");
//		String title=driver.getTitle();
//		System.out.println(title);
//		
	
			FileInputStream fis = new FileInputStream("./src/test/resources/dummy.xlsx");
			
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("hello");
			FileOutputStream fos = new FileOutputStream("./src/test/resources/dummy.xlsx");
			book.write(fos);
			book.close();
			System.out.println("DONE");
		
		
	}
}
