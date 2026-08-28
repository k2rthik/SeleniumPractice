package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class DataProviderTest
{
	@Test(dataProvider = "testData")
	public void getProductInfoTest(String brand,String product) throws Exception
	{
		WebDriverUtility wu = new WebDriverUtility();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver);
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		
		String x = "//span[contains(text(),'"+product+"')]/ancestor::div[@class='a-section']//span[@class='a-price']";
		String price = driver.findElement(By.xpath(x)).getText();
		
		System.out.println(price);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] testData() throws Exception
	{
		ExcelUtility eu = new ExcelUtility();
		int rowcount = eu.getRowCount("product");
		Object[][]data = new Object[rowcount][2];
		
		for(int i = 1; i<=rowcount;i++)
		{
			data[i-1][0]= eu.readFromExcel("product", i, 0);
			data[i-1][1]= eu.readFromExcel("product", i, 1);
		}
		return data;
	}
}
