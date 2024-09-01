package com.comcast.crm.generic.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, IOException
	{
		FileInputStream fisXl= new FileInputStream("./testScriptData/Test.xlsx");
		Workbook book = WorkbookFactory.create(fisXl);
		String data = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		book.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fisXl= new FileInputStream("./testScriptData/Test.xlsx");
		Workbook book = WorkbookFactory.create(fisXl);
		int lastRowNum = book.getSheet(sheetName).getLastRowNum();
		book.close();
		return lastRowNum;
	}
	
	public void setDataIntoNewSheetExcel(String sheetName,int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fisXl= new FileInputStream("./testScriptData/Test.xlsx");
		Workbook book = WorkbookFactory.create(fisXl);
		Cell cell = book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testScriptData/Test.xlsx");
		book.write(fos);
		book.close();
		System.out.println(data+" is passed successfully");
	}
	
	public void setDataIntoExistingSheetExcel(String sheetName,int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fisXl= new FileInputStream("./testScriptData/Test.xlsx");
		Workbook book = WorkbookFactory.create(fisXl);
		Cell cell = book.getSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testScriptData/Test.xlsx");
		book.write(fos);
		book.close();
		System.out.println(data+" is passed successfully");
	}
	
}
