package datadriven_testing;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingPropertyFile
{
	public static void main(String[] args) throws IOException
	{
		InputStream is = UsingPropertyFile.class.getClassLoader().getResourceAsStream("sample.properties");
		Properties prop = new Properties();
		prop.load(is);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String un = prop.getProperty("un");
		String pw = prop.getProperty("pw");
				
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
		driver.quit();
	}
}