package com.vtiger.comcast.testscripts;








import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibraries.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Organization;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;

public class createOrgTest extends BaseAnnotationClass {
	@Test
	public void createOrgTest() throws Throwable {
		
		String randomInt = jLib.getRandomNumber();
		/*test script Data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;

        /*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
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
	  
	  
	  //verify the successfull msg with orgName//
	  String actSuccessfullMsg = orginfo.getSuccessfullMsg().getText();
	  if(actSuccessfullMsg.contains(orgName))
	  {
		  System.out.println(orgName + "==created successfully");
	  }
	  else
	  {
		  System.out.println(orgName + " ==> not created ");
		  
	  }
	}

	
	//verify the successfull msg with IndustryName
      @Test
      public void createOrgWithIndustriesTest() throws Throwable
      {
      /*test script Data*/
      String randomInt = jLib.getRandomNumber();
      String orgName = eLib.getDataFromExcel("Sheet1", 4, 2);
      String industryType = eLib.getDataFromExcel("orgName", 4, 3);
      
      //Navigate to Organization click on + icon
      Home homePage = new Home(driver);
      homePage.organizationTab().click();
      
       //click on + sign to create Org
	    
	    Organization lookupBtn = new Organization(driver);
	    lookupBtn.CreateOrgIcon().click();
	  
	    /* Organization info page appears */
		  
	    //Create reference of OrganizationInfo class
	  
	  OrganizationInfo orginfo = new OrganizationInfo(driver);
	  
	  //To enter org name in the text box from the getDatafromexcel file
	  
	  orginfo.getorgNameTab().sendKeys(orgName);
	  
	  //To save the Organization
	  orginfo.clicksavebtn().click();
	  
	  //Verify
	  
	  wLib.waitForElementVisibility(driver, orginfo);
	  
	  
	  //verify the successfull msg with orgName//
	  String actSuccessfullMsg = orginfo.getSuccessfullMsg().getText();
	  if(actSuccessfullMsg.contains(orgName))
	  {
		  System.out.println(orgName + "==created successfully");
	  }
	  else
	  {
		  System.out.println(orgName + " ==> not created ");
		  
	  }
	 /* String actIndustryType = orginfo.getTypeMsg().getText();
	  if(actIndustryType.equals(industriesType)) {
      	System.out.println(industriesType + "==>industry is verified successfully");
      }else {
      	System.out.println(industriesType + "==>industry is not verified successfully");

      }*/
	}

      @Test
      public void createOrgWithRatingTest() throws Throwable
      {
    	  String randomInt = jLib.getRandomNumber();
    	  String orgName = eLib.getDataFromExcel("Sheet", 7, 2) + randomInt;
    	  String rating = eLib.getDataFromExcel("Sheet", 7,3);
    	  
    	//Navigate to Organization click on + icon
          Home homePage = new Home(driver);
          homePage.organizationTab().click();
          
        //click on + sign to create Org
    	    /* Organization info page appears */
    	  
    	    Organization lookupBtn = new Organization(driver);
    	    lookupBtn.CreateOrgIcon().click();
    	  
    	    //Create reference of OrganizationInfo class
    	  
    	  OrganizationInfo orgInfo = new OrganizationInfo(driver);
    	  
    	  //To enter org name in the text box from the getDatafromexcel file
    	  
    	  orgInfo.getorgNameTab().sendKeys(orgName);
    	  
    	  //To save the Organization
    	  orgInfo.clicksavebtn().click();
    	  

    	  //verify the successfull msg with orgName//
    	  String actSuccessfullMsg = orgInfo.getSuccessfullMsg().getText();
    	  if(actSuccessfullMsg.contains(orgName))
    	  {
    		  System.out.println(orgName + "==created successfully");
    	  }
    	  else
    	  {
    		  System.out.println(orgName + " ==> not created ");
    		  
    	  }
    	  /*
    	   * 
    	  String actRatingType = orgInfo.getRatingTypeInfo().getText();
    	   
    	  
    	  if(actRatingType.equals(rating))
    	  {
    		  System.out.println(rating + "==> industry is verified successfully");
    	  }
    	  else
    	  {
    		  System.out.println(rating +"==> industry is not verified.");
    		  
    	  }
    	  */
    	  
      }
}




