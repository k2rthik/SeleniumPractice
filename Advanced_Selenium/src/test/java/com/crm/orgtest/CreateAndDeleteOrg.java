package com.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateAndDeleteOrg
{
	public static void main(String[] args) throws Exception
	{
		//Create Objects
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		
		
		//Load properties
		String browser = fu.getDataFromProperties("browser");
		String url = fu.getDataFromProperties("url");
		String un = fu.getDataFromProperties("un");
		String pw = fu.getDataFromProperties("pw");
		
		//Read test script data from excel
		String orgName = eu.readFromExcel("tsData", 4, 0)+ju.getRandom();
		
		WebDriver driver = null;

		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		wdu.goToPage(driver, url);
		wdu.maximize(driver);
		wdu.waitForPageToLoad(driver);
		
		driver.findElement(By.xpath("user_name")).sendKeys(un);
		driver.findElement(By.xpath("user_password")).sendKeys(pw);

		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		Select select = new Select(driver.findElement(By.id("bas_searchfield")));
		select.selectByIndex(1);
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../descendant::a[text()='del']")).click();
		
		driver.switchTo().alert().accept();
		
		driver.quit();
		
	}
}
