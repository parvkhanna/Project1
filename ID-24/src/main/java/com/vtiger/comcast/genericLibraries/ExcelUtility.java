package com.vtiger.comcast.genericLibraries;


import java.io.FileInputStream;
/**
 * 
 * @author Asus
 * 
 */
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ExcelUtility 
{  
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	//@SuppressWarnings("rawtypes")
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("G:\\\\Data\\\\DataPropeties.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		//String data=WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("G:\\Data\\DataPropeties.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis = new FileInputStream("G:\\Data\\DataPropeties.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
	
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCellValue(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("G:\\Data\\DataPropeties.xlsx");
		wb.write(fos);
		wb.close();
		
	}


	
}


