package com.vtiger.comcast.genericLibraries;

import org.testng.ITestResult;

public class RetryAnalyzer {
	int count = 0;
	int retryCount = 4;
	
	public boolean retry(ITestResult result)
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
