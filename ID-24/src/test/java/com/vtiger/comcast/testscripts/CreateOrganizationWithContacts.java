package com.vtiger.comcast.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibraries.DataBaseUtilities;
import com.vtiger.comcast.genericLibraries.ExcelUtility;
import com.vtiger.comcast.genericLibraries.FileUtility;
import com.vtiger.comcast.genericLibraries.JavaUtility;
import com.vtiger.comcast.genericLibraries.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.ContactInformation;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Organization;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;

/**
 * 
 * @author Asus
 *
 */

public class CreateOrganizationWithContacts {
	@Test
	public void confiBC() throws Throwable	{ 
		 JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			FileUtility flib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			DataBaseUtilities  dbLib = new DataBaseUtilities();
			wL
			WebDriver driver =null;
			
			String USERNAME = flib.getPropertyKeyValue("username");
			String PASSWORD = flib.getPropertyKeyValue("password");
			String URL = flib.getPropertyKeyValue("url");
			String BROWSER = flib.getPropertyKeyValue("browser");
		
		
		//Read test Script Data
		String orgName = eLib.getDataFromExcel("Org",1,2) + "_"+jLib.getRandomNumber();
		
				
				
		//Launch browser
		if (BROWSER.equals("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}

		  wLib.waitUntilPageLoad(driver);//Implicitly
		  driver.manage().window().maximize();
		  driver.get(URL);
		 
		  //Enter URL
		  driver.get(URL);
		  //Step to login 
		  Login loginPage = new Login(driver);
		  loginPage.loginToApp(USERNAME,PASSWORD);
		 
		  //After login the homePage appears
		  
		  //reference of homePage
		  Home homePage = new Home(driver); 
		  wLib.waitUntilPageLoad(driver);
		  
		  //navigate to organization Tab from the homepage
		  homePage.organizationTab().click();
		  
		  /* Organization page appears */
		  
		  //clicking on the '+' icon to create new organization
		  Organization org = new Organization(driver);
		  org.CreateOrgIcon().click();
		  
		  
		  /* Organization info page appears */
		  
		  //reference of organization Page
		  OrganizationInfo orginfoPage = new OrganizationInfo(driver); 
		  
		//To enter org name in the text box from the getDatafromexcel file
		  orginfoPage.getorgNameTab().sendKeys(orgName);
		  
		  
		  orginfoPage.clicksavebtn();
		  
/* # Scenario 2 */
		  
		  
		  //To click on contacts tab
		  homePage.getcontactsLnk().click();	
		
		  
		  //Creating the reference of contact page
		  ContactInformation cp = new ContactInformation(driver);
		  
   		  //2.Click on '+' icon to create new contact
		  cp.createContact().click();
		  
		  cp.lastName().sendKeys(USERNAME);
		  
		 cp.orgLookUp().click();
		 
		wLib.switchToWindow(driver,"Accounts&action");
		
		//OrganizationInfo op=new OrganizationInfo(driver);
		org.searchOrganization().sendKeys(orgName);
		
		//click on submit button
		org.submitSearchButton().click();
		
		Thread.sleep(3000);
	
		int Count=0;
	while (Count<20) {
		try {
			driver.findElement(By.xpath("//a[text()='+orgName+']")).click();
			break;
		} catch (Exception e) {
Count++;

Thread.sleep(500);
}
	}
		
	cp.saveContact().click();
	//logout
	  homePage.logout();
	  //close browser
	  driver.close();

	}
} 


