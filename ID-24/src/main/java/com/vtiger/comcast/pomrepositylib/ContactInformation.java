package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;
	
	public ContactInformation(WebDriver driver)
	{
		PageFactory.initElements( driver , this);
	}
	//After clicking on the contacts tab on the homepage we get to contact information page
	
	
	//To click on create contacts Icon i.e '+'
	@FindBy(xpath= "//img[@alt='Create Contact...']")
	private WebElement createcontactIcon;
	public WebElement createContact()
	{
		return createcontactIcon;
	}
	
	//Elements used to create new contact 
	
	
	//To enter the last name 
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
				
	public WebElement lastName()
	{
		return lastName;
	}
	
	//To click on the '+' organization lookup button 
	@FindBy(xpath = ("//input[@name='account_name']/following-sibling::img"))
	private WebElement orgLookUpbtn;
	
	public WebElement orgLookUp()
	{
		return orgLookUpbtn;
	}
	//After this a new window appears and we have to select the organization from the list 
	
	
	//After this the elements are on the organization page
	
	
	//To click on the org name text box in the create contact page
	@FindBy(xpath = "//input[@name='account_name']")
	private WebElement orgName;
	
	public WebElement OrganizationName()
	{
		return orgName;
	}
		
	
	
	
	//To save the contact 
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement saveContact()
	{
		return saveBtn;
	}
	
	
	


}
