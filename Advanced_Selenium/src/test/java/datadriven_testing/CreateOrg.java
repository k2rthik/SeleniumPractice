package datadriven_testing;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrg
{
	@Test
	public void createOrganization(XmlTest test)
	{
		String browser = test.getParameter("browser");
		String url = test.getParameter("url");
		String un = test.getParameter("un");
		String pw = test.getParameter("pw");
		String oname = test.getParameter("oname");
		
		WebDriver driver = null;

		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);

		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Random random = new Random();
		int r = random.nextInt(1000);
		oname = oname + r;
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(oname);
		
		driver.navigate().refresh();
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//td[@class='small']/child::img"))).perform();
				
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
}
