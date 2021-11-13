package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraT1 {

	public static void main(String[] args) throws Throwable {
		
		
		// TODO Auto-generated method stub
		 
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("Amazon");
		
		driver.findElement(By.name("createdBy")).sendKeys("Parv Khanna");
		
		WebElement ele = driver.findElement(By.name("status"));
		
		Select S=new Select(ele);
		
		S.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Connection con = null;
      try {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Connect to DB
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		// Create/Issue SQL Statement
		
		Statement stat = con.createStatement();
		
		//Execute the query
		
		ResultSet set = stat.executeQuery("select * from project");
		while(set.next())
		{
			System.out.println(set.getString(1) + "\t"  + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getString(4));
			if(set.getString("project_name").equals("Amazon"))
			{
			System.out.println("Exixting in DB");
			}
		}
      }
      catch(Exception e)
      {
    	  
      }
      finally
      {
    	  con.close(); 
      }
		
		
		
	}

}


		
		
		




