package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//To ckick on Organization tab on the homepage
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationLnk;
	
	public WebElement organizationTab()
	{
		return organizationLnk;
	}
	
	//To click on the contacts tab on the homepage
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLnk;
	
	public WebElement getcontactsLnk()
	{
		return contactsLnk;
	}
	
	//To click on the products tab on the homepage 
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	public WebElement getProductLnk()
	{
		return productLnk;
	}
	
	//Steps to Logout 
	//To click move the cursor to admin image for logout on the homepage
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	public WebElement getAdminstatorImg()
	{
		return adminstatorImg;
	}
	
	//To click on the SignOut tab on the homepage
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLnk;
	
	public WebElement getSignOutLnk()
	{
		return signOutLnk;
	}
	
	//To click on the logout button 
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminstatorImg).perform();
		getSignOutLnk().click();
	}

}
