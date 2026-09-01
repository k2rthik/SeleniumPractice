package com.crm.practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.base.BaseClass;
import com.crm.generic.webdriverutility.UtilityClassObject;

public class InvoiceTest2 extends BaseClass
{
	@Test//(retryAnalyzer = com.crm.listenerutility.RetryListener.class)
	public void createInvoiceTest()
	{
		System.out.println("Execute createInvoiceTest");
		
		String expected = "Homek";
		String actual = driver.getTitle();
		
		if(actual.contains(expected))
			UtilityClassObject.getTest().log(Status.PASS, expected +" verified ");
		else
			Assert.fail(expected+" not verified");
		UtilityClassObject.getTest().log(Status.INFO,"Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("Execute createInvoiceWithContactTest");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
}
