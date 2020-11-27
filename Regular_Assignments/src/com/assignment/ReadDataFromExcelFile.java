package com.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile 
{
	@Test
	public void readExcelData1() throws EncryptedDocumentException, IOException
	{
		File file = new File("D:\\Selenium\\testData1.0.xlsx");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet s = wb.getSheet("Sheet1");
		int rowNo = s.getLastRowNum();
		int columnCo = s.getRow(0).getLastCellNum();
		for(int i =0; i< rowNo; i++)
		{
			XSSFRow row = s.getRow(i);
			for(int j =0; j< columnCo; j++)
			{
				String value = row.getCell(j).toString();
				System.out.println(value +" ");
				
			}
			
		}
		
	}

	}

