package com.selenium.setup;        //Do not change the package name

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {        //Do not change the class name

	public static String[] readExcelData(String sheetName) throws Exception {
	   //Get the excel file path
	   //Using the sheet name passed to this method, read the data and store it in a string array.
	   //Return the array. Only one row in the excel sheet so keep 'row' as 0.
	   //Store only the column value in the array.
		
//		System.getProperty("user.dir") + "\\src\\Drivers\\chromedriver.exe"
//		C:\\Users\\500052384\\git\\Hackathon\\src\\FormRegistration.xlsx
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\FormRegistration.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row;
		XSSFCell cell;
		row=sheet.getRow(0);
		String[] userData = new String[1];
		for(int i=0;i<1;i++)
		{
			cell = row.getCell(i);
			userData[i] = cell.toString();
		}
		System.out.println(userData[0]);
		return userData;
	}

}
