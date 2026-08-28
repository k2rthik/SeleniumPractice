package com.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.base.BaseClass;
import com.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener
{
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite)
	{
		// TODO Auto-generated method stub
		System.out.println("Report Config");
		// Spark report configuration
		String time = new Date().toString().replace(" ", "_").replace(":", "-").substring(4, 19);
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report_"+time+".html");
		spark.config().setDocumentTitle("Test Suite Results");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);

		// add ENV info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite)
	{
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + "===> START");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===> Started");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + "===> END");
		//test.log(Status.INFO,result.getMethod().getMethodName()+"===> Completed");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		test.pass("Test Passed: " + result.getThrowable(),
	              MediaEntityBuilder.createScreenCaptureFromBase64String(file).build());
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "-").substring(4, 16);
		String report = testName+"_"+time;
		
//		test.addScreenCaptureFromBase64String(file,report);
//		test.log(Status.FAIL,result.getMethod().getMethodName()+"===> Failed");
		test.fail("Test Failed: " + result.getThrowable(),
	              MediaEntityBuilder.createScreenCaptureFromBase64String(file).build());
	}

}
