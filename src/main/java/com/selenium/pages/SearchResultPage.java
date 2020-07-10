package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPage {
	public WebDriver driver;

    //Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public SearchResultPage(){}
    
	public SearchResultPage(WebDriver driver) { 
		this.driver= driver;
	}
	
	public void setCategory(String keyword) {
        //locate and fill the input box of the 'search' with 'keyword'
		String xpathCategory = BasePage.prop.getProperty("categoryLocator");
		//input[@value='Bookshelves']
		String xpathCategoryValue = "//input[@value=" + keyword + "]";
		System.out.println(xpathCategory);
		System.out.println(xpathCategoryValue);
		driver.findElement(By.xpath(xpathCategory)).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(xpathCategoryValue)).click();
	}
	
	public void setPriceRangeUL(int keyword) {
        //locate and fill the input box of the 'search' with 'keyword'
		String xpath1 = BasePage.prop.getProperty("priceRangeLocator");
		driver.findElement(By.xpath(xpath1)).click();
		driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']")).click();
		
		WebElement dragAble = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));

		Actions action = new Actions(driver);
		int xOffset = -(41399 - keyword)*100/12769;
		action.dragAndDropBy(dragAble, xOffset, 0).build().perform();
	}
	
	public void setSorageType(String keyword) {
        //locate and fill the input box of the 'search' with 'keyword'
		String xpathStorageType = BasePage.prop.getProperty("storeTypeLocator");
		//input[@value='Open']
		String xpathStorageTypeValue = "//input[@value=" + keyword + "]";
		
		System.out.println(xpathStorageType);
		System.out.println(xpathStorageTypeValue);
		
		driver.findElement(By.xpath(xpathStorageType)).click();
		driver.findElement(By.xpath(xpathStorageTypeValue)).click();
	}

}
