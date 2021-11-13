package com.vtiger.comcast.testscripts;


import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibraries.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Organization;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;

public class smokeTest extends BaseAnnotationClass 
{
	@Test
	 public void createOrg() throws Throwable
	{
		String orgName = flib.getPropertyKeyValue("orgname")+jLib.getRandomNumber();
	 System.out.println(orgName);
	 
	 
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


