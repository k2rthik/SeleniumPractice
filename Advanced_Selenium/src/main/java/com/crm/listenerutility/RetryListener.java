package com.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class RetryListener implements IRetryAnalyzer
{
	int count = 0;
	int limitCount = 3;
	@Override
	public boolean retry(ITestResult result)
	{	
		if(count<limitCount)
			{
				ListImpClass.test.log(Status.WARNING, result.getMethod().getMethodName()+" ===> Retrying");
				count++;
				return true;
			}
		return false;
	}
	
}
