package com.vtiger.comcast.testscripts;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllRowDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\ofc\\DataPropeties.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		
		//get the last used row count
		int count=sh.getLastRowNum();
		
		for(int i=1 ; i<count; i++)
		{
			Row row = sh.getRow(i);
			String firstColData = row.getCell(0).getStringCellValue();
			String secondColData = row.getCell(1).getStringCellValue();
			System.out.println(firstColData + "\t" + secondColData);
			
			
		}

	}

}
