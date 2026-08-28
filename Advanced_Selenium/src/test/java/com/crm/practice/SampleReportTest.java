package com.crm.practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest
{
	public ExtentReports report;

	@BeforeSuite
	public void configBS()
	{
		// Spark report configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("Test Suite Results");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);

		// add ENV info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win 11");
		report.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
	@Test
	public void createConTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createConTest");

		test.log(Status.INFO, "Step 1");
		test.log(Status.INFO, "Step 2");
		test.log(Status.INFO, "Step 3");
		if ("A".equals("Ab"))
			test.log(Status.PASS, "Contact created");
		else
			test.addScreenCaptureFromBase64String(filepath, "Error");
		test.log(Status.INFO, "Step 4");
	}

	@Test
	public void createConWithNumTest()
	{
		ExtentTest test = report.createTest("createConWithNumTest");

		test.log(Status.INFO, "Step 1");
		test.log(Status.INFO, "Step 2");
		test.log(Status.INFO, "Step 3");
		if ("A".equals("A"))
			test.log(Status.PASS, "Contact created");
		else
			test.log(Status.FAIL, "Contact not created");
		test.log(Status.INFO, "Step 4");
	}

	@Test
	public void createConWithMailTest()
	{
		ExtentTest test = report.createTest("createConWithMailTest");

		test.log(Status.INFO, "Step 1");
		test.log(Status.INFO, "Step 2");
		test.log(Status.INFO, "Step 3");
		if ("A".equals("A"))
			test.log(Status.PASS, "Contact created");
		else
			test.log(Status.FAIL, "Contact not created");
		test.log(Status.INFO, "Step 4");
	}
}
