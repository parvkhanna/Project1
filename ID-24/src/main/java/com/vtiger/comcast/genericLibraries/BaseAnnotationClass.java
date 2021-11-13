package com.vtiger.comcast.genericLibraries;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class BaseAnnotationClass {
	public WebDriver driver;
	
	//includes method for login and logout
	//TS will extends the base class
	
	/*Object creation for Lib*/
	
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DataBaseUtilities  dbLib = new DataBaseUtilities();
	@BeforeSuite
	public void configBS()
	{
		System.out.println("===Connect to Database===");
	}
	//String randomInt = jLib.getRandomNumber();
	
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("===Launch the Browser===");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void confiBM() throws Throwable
	//Common Data
	{
	String USERNAME = flib.getPropertyKeyValue("username");
	String PASSWORD = flib.getPropertyKeyValue("password");
	String URL = flib.getPropertyKeyValue("url");
	String BROWSER = flib.getPropertyKeyValue("browser");
	/*Navigate to App*/
	driver.get(URL);
	/* login*/
	Login loginPage = new Login(driver);
	loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod
	public void configAM()
	{
		/*Step to logout*/
		Home homePage = new Home(driver);
		homePage.logout();
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("===discconect from db===");
	}

}
