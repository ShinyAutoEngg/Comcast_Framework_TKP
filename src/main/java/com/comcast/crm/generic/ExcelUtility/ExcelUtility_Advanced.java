package com.comcast.crm.generic.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtility_Advanced 
{
	public FileInputStream fis;
	public FileOutputStream fos;
	public Workbook workbook;
	public WorkbookFactory workBookFact;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	String path;
	
	//Constructor for Passing Path
	public ExcelUtility_Advanced(String pathP)
	{
		this.path=pathP;
	}
	
	
	//Generic Method to get Last Row Number
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		Workbook book = workBookFact.create(fis);
		int lrn = book.getSheet(sheetName).getLastRowNum();
		book.close();
		return lrn;
	}
	
	//Generic Method to get Last Cell Number
	public int getLastCellNum(String sheetName,int rowNum) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		Workbook book = workBookFact.create(fis);
		int lcn=book.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		book.close();
		return lcn;
	}
	
	//Generic Method to Read Data From Excel
	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		Workbook book = workBookFact.create(fis);
		String data = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue().toString();
		book.close();
		return data;
	}
	
	//Generic Method to Set Data to Excel
	public void setDataToExistingSheetExcel(String sheetName, int rowNum, int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		Workbook book = workBookFact.create(fis);
		Cell cell=book.getSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		book.close();
	}
	
	//Generic Method to Set Data to Excel - new sheet
	public void setDataToNewSheetExcel(String sheetName, int rowNum, int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		fis=new FileInputStream(path);
		Workbook book = workBookFact.create(fis);
		Cell cell=book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		book.close();
	}
	
}
