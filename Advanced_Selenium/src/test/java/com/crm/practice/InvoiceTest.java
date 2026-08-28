package com.crm.practice;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.base.BaseClass;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.listenerutility.ListImpClass;

public class InvoiceTest extends BaseClass
{
	@Test//(retryAnalyzer = com.crm.listenerutility.RetryListener.class)
	public void createInvoiceTest()
	{
		System.out.println("Execute createInvoiceTest");
		
		String expected = "Home";
		String actual = driver.getTitle();
		
		if(actual.contains(expected))
			ListImpClass.test.log(Status.PASS, expected +" verified ");
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
