package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;

    //Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public HomePage(){}
    
	public HomePage(WebDriver driver) { 
		this.driver= driver;
	}
	
	public void setSearch(String keyword) {
        //locate and fill the input box of the 'search' with 'keyword'
		driver.findElement(By.id(BasePage.prop.getProperty("searchLocator"))).clear();
		driver.findElement(By.id(BasePage.prop.getProperty("searchLocator"))).sendKeys(keyword);
		driver.findElement(By.id(BasePage.prop.getProperty("searchButton"))).click();
	}

}
