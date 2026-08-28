package com.crm.hometest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class HomePageVerification
{
	@Test
	public void homePageTest(Method m) throws Exception
	{
		
		Reporter.log(m.getName()+" starts");
		String expectedPage = "Home";
		WebDriverUtility wu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
				
		String url = fu.getDataFromProperties("url");
		String un = fu.getDataFromProperties("un");
		String pw = fu.getDataFromProperties("pw");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		wu.waitForPageToLoad(driver);
		wu.maximize(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		String home = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		 
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(home, expectedPage);
		
		
		Reporter.log(m.getName()+" ends");
		driver.quit();
		sa.assertAll();
	}
	
	@Test
	public void verifyLogo(Method m) throws Exception
	{
		Reporter.log(m.getName()+" starts");
		
		WebDriverUtility wu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
				
		String url = fu.getDataFromProperties("url");
		String un = fu.getDataFromProperties("un");
		String pw = fu.getDataFromProperties("pw");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		wu.waitForPageToLoad(driver);
		wu.maximize(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		boolean check = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();			
		
		Assert.assertTrue(check);
		
		Reporter.log(m.getName()+" ends");
		driver.quit();
	}
}
