package com.vtiger.comcast.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DeleteOrg {
	@Test
	public void delete_org()
	{
		String orgName = "TestYantra_761";
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		try
		{
			driver.findElement(By.xpath("//table/tbody/tr[1]/td/div/table/tbody/tr[*]/td[3]/a[.='"+orgName+"']/../..//td[*]/a[.='del']")).click();
			driver.switchTo().alert().accept();
			
		}
		catch(Exception e)
		{
			System.out.println("Organization Name not found");
		}
		
		finally
		{
			WebElement user = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wait.until(ExpectedConditions.visibilityOf(user));
			Actions a = new Actions(driver);
			a.moveToElement(user).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
			
		}
	
	}

}
