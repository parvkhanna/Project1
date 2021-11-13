package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	public Organization(WebDriver driver)
	{
		PageFactory.initElements( driver , this);
	}
	
	
	//to click on the Plus symbol for Org
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement 	createOrgIcon;
		
		public WebElement CreateOrgIcon() 
		{
		return createOrgIcon;
		}
		
	//After that Organization info page will open
		
	
	
	//To enter the industry name
	@FindBy(name="industryname")
	private WebElement industryName;
	
	public WebElement IndustryName()
	{
		return industryName;
	}
	
	//To select the organization while creating contact
	@FindBy(id = "search_txt")
	private WebElement searchOrg;
	
	public WebElement searchOrganization()
	{
		return searchOrg;
	}
	
	//To click on the search button or to submit the search button on the organization list page
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	
	public WebElement submitSearchButton()
	{
		return searchBtn;
	}
	
	//To click on the OrgList result 
	@FindBy(xpath = "//a[@id='1']")
	private WebElement result;
	
	public WebElement OrglistResult()
	{
		return result;
	}
	}


