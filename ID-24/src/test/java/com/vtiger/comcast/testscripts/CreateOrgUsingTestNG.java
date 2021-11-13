package com.vtiger.comcast.testscripts;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.comcast.genericLibraries.ExcelUtility;
import com.vtiger.comcast.genericLibraries.FileUtility;

public class CreateOrgUsingTestNG 
{
	@Test
	
	public void createOrgTest(XmlTest xml) throws Throwable 
	{
	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	
	Random random = new Random();
	int randomNum = random.nextInt(1000);
	System.out.println(randomNum);
	
	String BROWSER = xml.getParameter("browser");
	String URL = xml.getParameter("url");
	String USERNAME = xml.getParameter("username");
	String PASSWORD = xml.getParameter("password");
	
	
	//Test script specific data 
	String TestID = elib.getDataFromExcel("org" , 1 , 2) + "_" + randomNum;
	
	WebDriver driver = null; 
			
	if(BROWSER.equals("chrome"))
	{
			driver = new ChromeDriver();
	}
	else if(BROWSER.equals("firefox"))
	{ 
		driver = new FirefoxDriver();
	}
	
	
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get(URL);
	
	//Step to login to apn
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	
	//Steps to create organization and Save
	driver.findElement(By.xpath("(//a[.='Organizations'][1])")).click();
	driver.findElement(By.xpath("//img[@border='0' and @alt='Create Organization...']")).click();
	
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("HDFC");
	
	driver.findElement(By.name("button")).click();
	
	driver.close();
			
		
			
	}
	

}
