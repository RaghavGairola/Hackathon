package com.selenium.tests;


//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.apache.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.pages.BasePage;
import com.selenium.pages.HomePage;
import com.selenium.pages.SearchResultPage;
import com.selenium.setup.ExcelUtils;


public class PositiveTestCases extends BasePage {

	public static WebDriver driver;
	HomePage HomePage;
	SearchResultPage SearchResultPage;
	
	public static String[] getExcelData() throws Exception {        
	    //Call the method 'readExcelData' in class 'ExcelUtils' using sheet name 'user_valid'
	    //Return the value
		return ExcelUtils.readExcelData("user_valid");
	}
	
	@Test
	public void test1() throws Exception {

//		logger = report.createTest("Test One");
		
		String[] array = getExcelData();

		invokeBrowser("Chrome");
		openURL("websiteURL");
		
		driver = BasePage.Driver;
		HomePage = new HomePage(driver);
		SearchResultPage = new SearchResultPage(driver);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div[1]/div/div[2]/a[1]")).click();
		HomePage.setSearch(array[0]);
		
//		SearchResultPage.setCategory(array[1]);
		System.out.println(Integer.parseInt(array[2]));
		SearchResultPage.setPriceRangeUL(Integer.parseInt(array[2]));
		SearchResultPage.setSorageType(array[3]);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		quitBrowser();

	}
}