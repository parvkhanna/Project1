package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericLibraries.FileUtility;

public class CreateOrganizationTest 

/*Using Property file*/
{
	 static WebDriver driver = null;


	 
	 
	 
	public static void main(String[] args) throws Throwable  {
		FileUtility file=new FileUtility();
	
		
		//Read the value using getProperty("Key")
		String BROWSER = file.getPropertyKeyValue("browser");
		String URL = file.getPropertyKeyValue("url");
		String USERNAME = file.getPropertyKeyValue("username");
		String PASSWORD = file.getPropertyKeyValue("password");
		System.out.println(BROWSER+"\n"+URL+"\n"+USERNAME+"\n"+PASSWORD);
		
		if(BROWSER.equals("chrome"))
		{
				driver = new ChromeDriver();
		} 
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		//Step to login to apn
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		//Steps to create organization and Save
		driver.findElement(By.xpath("(//a[.='Organizations'][1])")).click();
		driver.findElement(By.xpath("//img[@border='0' and @alt='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("HDFC");
		
		driver.findElement(By.name("button")).click();
	
		
		} 

}
