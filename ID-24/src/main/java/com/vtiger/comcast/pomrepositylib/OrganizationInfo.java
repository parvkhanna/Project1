package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInfo {

	
		
		public OrganizationInfo(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Orgname textbox element
		@FindBy(name="accountname")
		private WebElement orgNameTab;
		
		//To click on Organization name tab
		public WebElement getorgNameTab()
		{
			return orgNameTab;
		}
		
		//To get successfull msg for Org
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement successfullMsg;
		
		public WebElement getSuccessfullMsg()
		{
		   return successfullMsg;
		}
		
		/*-----------------Elements to create Industry -----------------------*/
		
		
		//To select industry
		@FindBy(name="industry")
		private WebElement IndDropDown;
		
		public WebElement getIndustry()
		{
			return IndDropDown;
		}
		public void dropdown()
		{
		 WebElement driver = null;
		Select dropdown = new Select(driver); 
		 dropdown.selectByVisibleText("Analyst");
		}
		  
		//To get successfull msg for Industry in the organization page after creation 
		@FindBy(xpath="//td[@id='mouseArea_Industry']")
		private WebElement IndustryMsg;
		
		public WebElement getIndustryMsg()
		{
			return IndustryMsg;
		}
		
		//To get successfull msg for Type
		@FindBy(xpath="//td[@id='mouseArea_Type']")
		private WebElement TypeMsg;
		
		
		public WebElement getTypeMsg()
		{
			return TypeMsg;
		}
		
		
		//Element to select the already created organization from the list for Contacts Page
		@FindBy(id="1")
		private WebElement hdfc;
		
		//Element to create Org button 
		public WebElement getCreateOrgBtn() 
		{
			return getCreateOrgBtn();
		}
		//To save the orginfo
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		public WebElement clicksavebtn()
		{
			return saveBtn;
		}
		
		
	}


