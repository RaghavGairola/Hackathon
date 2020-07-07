package com.selenium.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;


public class BasePage {
	public static WebDriver Driver;
	public static Properties prop;
	public void invokeBrowser(String Browsername) {
		try {
			if (Browsername.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\Drivers\\chromedriver.exe");
				Driver = new ChromeDriver();

			} else {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\Drivers\\geckodriver.exe");
				Driver = new FirefoxDriver();
			}
			}
			catch (Exception e) {
				System.out.println("Error");
			}
			Driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
			Driver.manage().timeouts().pageLoadTimeout(260, TimeUnit.SECONDS);
			Driver.manage().window().maximize();

			if (prop == null) {
				prop = new Properties();
				try {
					FileInputStream file = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\propConfig.properties");
					prop.load(file);
				} catch (Exception e) {
					System.out.println("Error");		
					e.printStackTrace();
				}
			}
		}
		public void openURL(String websiteURLKey) {
			Driver.get(prop.getProperty(websiteURLKey));
		}

	public void tearDown(){
		Driver.close();
	}

	public void quitBrowser(){
		Driver.quit();
	}

}

