package com.vtiger.comcast.testscripts;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibraries.DataBaseUtilities;
import com.vtiger.comcast.genericLibraries.ExcelUtility;
import com.vtiger.comcast.genericLibraries.FileUtility;
import com.vtiger.comcast.genericLibraries.JavaUtility;
import com.vtiger.comcast.genericLibraries.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Organization;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
/**
 * 
 * @author Asus
 *
 */

public class CreateOrg  {
	static {
		
		
	} 
	
	@Test
	public void confiBC() throws Throwable	{ 
	 JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		DataBaseUtilities  dbLib = new DataBaseUtilities();
		WebDriver driver =null;
		
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		//Read test Script Data
				String orgName = eLib.getDataFromExcel("Org", 1, 2) + "_" +jLib.getRandomNumber();			  
		//Launch browser	
		 if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equals("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }		 
		 //Step to login 
		  driver.get(URL);
		  Login loginPage = new Login(driver);
		  loginPage.loginToApp(USERNAME,PASSWORD);
		 
		//navigate to organization from the homepage
		  Home homePage = new Home(driver);
		  wLib.waitUntilPageLoad(driver);
		  homePage.organizationTab().click();
		  
		  
		  //click on + sign to create Org
		    /* Organization info page appears */
		  
		  Organization lookupBtn = new Organization(driver);
		  lookupBtn.CreateOrgIcon().click();
		  
		  //Create reference of OrganizationInfo class
		  
		  OrganizationInfo orginfo = new OrganizationInfo(driver);
		  
		  //To enter org name in the text box from the getDatafromexcel file
		  
		  orginfo.getorgNameTab().sendKeys(orgName);
		  
		  //To save the Organization
		  orginfo.clicksavebtn().click();
		  
		  //Verify
		  
		  //wLib.waitForElementVisibility(driver, orginfo);
		  String orgSuccessfullMsg = orginfo.getSuccessfullMsg().getText();
		  if(orgSuccessfullMsg.contains(orgName))
		  {
			  System.out.println(orgName + "==created successfully");
		  }
		  else
		  {
			  System.out.println(orgName + " ==> not created ");
			  
		  }
		  //logout
		  homePage.logout();
		  //close browser
		  driver.close();

	}
}

