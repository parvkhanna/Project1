package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	public WebElement userNameEdt()
	{
		return userNameEdt;
	}
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;
	public WebElement getUserPasswordEdt()
	{
		return userPasswordEdt;
	}
	
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//inout[@id='submitButton']")})
	private WebElement loginBtn;
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//Rule4 : Declare all elements as private and Provide getters method, business methods for (utilization)
	
	
	
	public void loginToApp(String userName , String password)
	{
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}

}
