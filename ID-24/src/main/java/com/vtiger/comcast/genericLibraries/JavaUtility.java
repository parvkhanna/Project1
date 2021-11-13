package com.vtiger.comcast.genericLibraries;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;



public class JavaUtility {
		
		/**
		 * 
		 * @author Asus
		 */
		
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
		public String getRandomNumber()
		{
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
			return ""+ranNum;			
		}				
		/**
		 * its used to get the current System date with YYYY-MM-DD format
		 * @return
		 */
		public String getSystemDateandTime()
		{
			Date date = new Date();
			String systemDateAndTime = date.toString();
			return systemDateAndTime;
		}
		
		/**
		 * its used to get the current system date with YYYY-MM-DD format
		 * @return
		 */
		
		public String getSystemDate_YYYY_MM_DD()
		{
			Date date = new Date();
			String systemDateAndTime=date.toString();
			System.out.println(systemDateAndTime);
			String[] arr = systemDateAndTime.split("");
			
			String DD = arr[2];
			String YYYY = arr[5];
			int MM = date.getMonth()+1;
			
			String finalFormat = YYYY+ "-" + MM + "-" + DD;
			return finalFormat;
		}
		
		/**
		 * used to pass Virtual Key to OS
		 * @throws Throwable
		 */
		public void pressVirtualEnterKey() throws Throwable
		{
			Robot rc = new Robot();
			rc.keyPress(KeyEvent.VK_ENTER);
			rc.keyRelease(KeyEvent.VK_ENTER);
		}
		 
		
}
