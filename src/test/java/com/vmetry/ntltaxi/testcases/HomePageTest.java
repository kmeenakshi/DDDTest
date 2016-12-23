package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initialiser.Initialiser;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.HomePage;
import com.vmetry.ntltaxi.reports.ScreenshotGenerator;

public class HomePageTest extends Initialiser {
	@BeforeTest
	public void setup() throws IOException {
		initialise();
	}

	@Test(dataProvider = "HomePageTest")
	public void validateHomePage(String data, String username,
			String mobilenumber, String pickupaddress, String dropaddress,
			String basic) throws IOException {
		log = report.startTest(data);
		wd.get(envProp.getProperty("URL"));
		/*
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]"
		 * )).sendKeys("vmetry");
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]"
		 * )).sendKeys("123");
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[5]"
		 * )).sendKeys("Adyar");
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[6]"
		 * )).sendKeys("Guindy");
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/select"
		 * )).sendKeys("Sedan");
		 * wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[7]"
		 * )).click();
		 */
		HomePage.enterusername(wd, username);
		HomePage.entermobilenumber(wd, mobilenumber);
		HomePage.enterpickupplace(wd, pickupaddress);
		HomePage.enterdropplace(wd, dropaddress);
		HomePage.selectdropdownbasic(wd, basic);
		HomePage.clickbooklater(wd);

	}

	@DataProvider(name = "HomePageTest")
	public static Object[][] gethomepagedata() throws Exception {
		if (inputReader.RunModeVerification("HomePageTest")) {

			Object[][] data = inputReader
					.selectSingleDataOrMulitiData("HomePageTest");

			return data;
		}
		return null;

	}

	@AfterMethod
	public void teardown(ITestResult it) throws IOException {

		if (it.isSuccess()) {
	
			ScreenshotGenerator.attachscreenshot(it);
		} else{
			ScreenshotGenerator.attachscreenshot(it);			
		}
	}

}
