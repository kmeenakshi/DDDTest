package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vmetry.ntltaxi.initialiser.Initialiser;

public class HomePage extends Initialiser {

	public static void loadurl(WebDriver wd)
	{
		wd.get("http://www.ntltaxi.com/");
	}
	public static void enterusername(WebDriver wd, String username)
	{
		getWebElementByXpath("HomePage_UserName_Type_Xpath").sendKeys(username);
	}
	public static void entermobilenumber(WebDriver wd, String mobilenumber)
	{
		getWebElementByXpath("HomePage_MobileNumber_Type_Xpath").sendKeys(mobilenumber);
	}
	public static void enterpickupplace(WebDriver wd, String pickupaddr)
	{
		getWebElementByXpath("HomePage_PickUpAddress_Type_Xpath").sendKeys(pickupaddr);
	}
	public static void enterdropplace(WebDriver wd, String dropaddr)
	{
		getWebElementByXpath("HomePage_DropAddress_Type_Xpath").sendKeys(dropaddr);
		
	}
	public static void selectdropdownbasic(WebDriver wd, String vehicle)
	{
		WebElement dropdown = getWebElementByXpath("HomePage_Vehicle_Select_Xpath");
		Select s = new Select(dropdown);
		s.selectByVisibleText(vehicle);
	}
	public static void clickbooklater(WebDriver wd)
	{
		getWebElementByXpath("HomePage_BookLater_Click_Xpath").click();
		
	}
	
}
