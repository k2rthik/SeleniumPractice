package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic.webdriverutility.WebDriverUtility;

public class MultipleWindows
{
	public static void main(String[] args) throws Exception
	{
		WebDriverUtility wdu = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		
		String parent = driver.getWindowHandle();
		
		wdu.switchToTab(driver, "Facebook");
		
		driver.findElement(By.xpath("//input[@name='email' and @type='text']")).sendKeys("meh");
		Thread.sleep(3000);
		driver.close();
				
		driver.switchTo().window(parent);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		Thread.sleep(3000);
		driver.findElement(By.className("search-box-button")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
