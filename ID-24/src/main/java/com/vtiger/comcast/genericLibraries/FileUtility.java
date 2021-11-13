package com.vtiger.comcast.genericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Asus
 *
 */

public class FileUtility {

	
	/**
	 * Used to get the data from the property file based on key 
	 * @param key
	 * @return the value of the key in the form of String
	 * @throws Throwable
	 */
		
		public String getPropertyKeyValue(String key) throws Throwable
		{
			FileInputStream fis = new FileInputStream("./Data/CommonData.properties");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
		}

	}


