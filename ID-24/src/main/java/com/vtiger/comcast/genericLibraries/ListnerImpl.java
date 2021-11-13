package com.vtiger.comcast.genericLibraries;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListnerImpl implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
String method = result.getMethod().getMethodName();
		
		Object obj = result.getInstance();
		WebDriver driver = null;
		 try 
		 {
			driver =(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+method+".PNG");
		try 
		{
	Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

				

		
	public void onTestSkipped(ITestResult result) 
{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}