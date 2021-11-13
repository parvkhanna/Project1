package com.vtiger.comcast.testscripts;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibraries.BaseAnnotationClass;
@Listeners(com.vtiger.comcast.genericLibraries.ListnerImpl.class)
public class ListenerPractice extends BaseAnnotationClass{

	@Test
	public void ListenerPractice()
	{
		System.out.println("test script failed");
		Assert.fail();
	}
}
