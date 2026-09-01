package com.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.crm.generic.webdriverutility.UtilityClassObject;

public class RetryListener implements IRetryAnalyzer
{
	int count = 0;
	int limitCount = 3;
	@Override
	public boolean retry(ITestResult result)
	{	
		if(count<limitCount)
			{
				UtilityClassObject.getTest().log(Status.WARNING, result.getMethod().getMethodName()+" ===> Retrying");
				count++;
				return true;
			}
		return false;
	}
	
}
