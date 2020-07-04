package com.selenium.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.selenium.pages.BasePage;


public class PositiveTestCases extends BasePage {

	@Test
	public void test1() throws IOException {

//		logger = report.createTest("Test One");

		invokeBrowser("Chrome");
		openURL("websiteURL");
		
		quitBrowser();

	}
}