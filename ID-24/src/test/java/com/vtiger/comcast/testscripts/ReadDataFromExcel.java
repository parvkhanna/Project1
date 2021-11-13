package com.vtiger.comcast.testscripts;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\ofc\\DataPropeties.xlsx");
		
		//Step1 Open WorkBook in read mode
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step2 get the control of the sheet1
		Sheet sh = wb.getSheet("Sheet1");
		//Step3 get the control of the 1st Row
		Row row = sh.getRow(1);
		//Step4 get the control of the 2nd Cell and copy the data
		Cell cel = row.getCell(2);
		String data = cel.getStringCellValue();
		System.out.println(data);
		//Step5 close the WorkBook
		wb.close();

	}

}
