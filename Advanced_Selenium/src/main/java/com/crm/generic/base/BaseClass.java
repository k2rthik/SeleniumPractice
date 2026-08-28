package com.crm.generic.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.generic.databaseutility.DatabaseUtility;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass
{
	public DatabaseUtility dbu = new DatabaseUtility();
	public ExcelUtility eu = new ExcelUtility();
	public FileUtility fu = new FileUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("=== Connect to DB ===");
		dbu.getConnection();
	}

	@BeforeClass
	public void configBC() throws Exception
	{
		String browser = fu.getDataFromProperties("browser");
		System.out.println("=== Launch the browser ===");
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		sdriver = driver;
		
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod
	public void configBM() throws Exception
	{
		String url = fu.getDataFromProperties("url");
		String un = fu.getDataFromProperties("un");
		String pw = fu.getDataFromProperties("pw");
		System.out.println("=== Login ===");

		wdu.goToPage(driver, url);
		wdu.maximize(driver);
		wdu.waitForPageToLoad(driver);

		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);

		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod
	public void configAM()
	{
		System.out.println("=== Logout ===");

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//td[@class='small']/child::img"))).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	@AfterClass
	public void configAC()
	{
		System.out.println("=== Close the browser ===");
		driver.quit();
	}

	@AfterSuite
	public void configAS()
	{
		System.out.println("=== Close DB connection ===");
		dbu.closeConnection();
	}
}
