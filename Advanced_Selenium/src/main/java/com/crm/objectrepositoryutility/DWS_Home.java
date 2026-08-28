package com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_Home
{
	public DWS_Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "small-searchterms")
		private WebElement search;
	
	public WebElement getSearch()
	{
		return search;
	}
}
