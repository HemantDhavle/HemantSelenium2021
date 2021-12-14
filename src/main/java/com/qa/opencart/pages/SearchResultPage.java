package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtils;

public class SearchResultPage 
{
	private WebDriver driver;
	private ElementUtils el;
	
	private By productResults = By.cssSelector("div.caption a");
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver= driver;
		el = new ElementUtils(driver);
	}
		
	public int getProductsListCount()
	{
		int results=el.doElementsVisible(productResults, 10).size();
		System.out.println("No. of product present "+results);
		return results;
	}
	
	public ProductInfoPage selectProduct(String mainProductName)
	{
		System.out.println("Product Name is "+mainProductName);
		List<WebElement> searchList= el.doElementsVisible(productResults, 10, 2);
		for(WebElement e : searchList)
		{
			String text = e.getText();
				if(text.equals(mainProductName))
				{
					e.click();
					break;
				}
		}
		return new ProductInfoPage(driver);
	}

}
