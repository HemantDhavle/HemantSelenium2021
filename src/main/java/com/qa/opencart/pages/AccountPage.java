package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtils;

public class AccountPage 
{
	private WebDriver driver;
	ElementUtils el;
	public AccountPage(WebDriver driver)
	{
		this.driver= driver;
		el = new ElementUtils(driver);
	}
	
	private By pageTitle = By.cssSelector("div#logo a");
	private By sectionsHeader = By.cssSelector("div#content h2");
	private By searchBox = By.name("search");
	private By searchButton = By.xpath("//span[@class='input-group-btn']/button");
	
	
	public String getAccountPageTitle()
	{
		return driver.findElement(pageTitle).getText();
	}
	
	public List<String> getAccountPageSectionHeader()
	{
		List<WebElement> secHeaders= driver.findElements(sectionsHeader);
		List<String> headerTextList =  new ArrayList<String>();
		for(WebElement e : secHeaders)
		{
			String header = e.getText();
			headerTextList.add(header);
		}
		return headerTextList;
	}
	
	public boolean isSearchDisplay()
	{
		return driver.findElement(searchBox).isDisplayed();
	}
	
	public SearchResultPage doSearch(String product)
	{
		System.out.println("Searching the product "+product);
		   
		WebElement searBox= driver.findElement(searchBox);
			searBox.clear();
			searBox.sendKeys(product);
		    driver.findElement(searchButton).click();
		    
		    
		    return new SearchResultPage(driver);
	}
	
	


}
