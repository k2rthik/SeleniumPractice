package com.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void goToPage(WebDriver driver,String site)
	{
		driver.get(site);
	}
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTab(WebDriver driver,String tname)
	{
		Set<String> windows = driver.getWindowHandles();
		
		for (String string : windows)
		{
			driver.switchTo().window(string);
			if(driver.getTitle().trim().contains(tname))
				break;
		}
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void selectOption(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectOption(WebElement element, int id)
	{
		Select sel = new Select(element);
		sel.selectByIndex(id);
	}
	
	public void mouseOverElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void clickHold(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element);
	}
}
