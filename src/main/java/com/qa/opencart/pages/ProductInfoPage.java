package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtils;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtils el;
	private By productName = By.xpath("//*[@id='content']/div/div[2]/h1");
	private By imageCount = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quntity = By.name("quantity");
	private By addToCartBtn = By.cssSelector("button#button-cart");
	private Map<String, String> productInfoMap;
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		el = new ElementUtils(driver);
	}
	
	public String getProductInfoHeader()
	{
		return driver.findElement(productName).getText();
		
	}
	
	public int getProductImageCount()
	{
		int totalImage = driver.findElements(imageCount).size();
		System.out.println("Total Images present on page is "+totalImage);
		return totalImage;
	}
	
	public Map<String, String> productInfoMap()
	{
		productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getProductInfoHeader());
		getProductMetaData();
		getProductPrice();
		return productInfoMap;
	}
	
	private void getProductMetaData() 
	{
		List<WebElement> metaDataList  = driver.findElements(productMetaData);
		
//		Brand: Apple
//		Product Code: Product 18
//		Reward Points: 800
//		Availability: Out Of Stock
		for(WebElement e : metaDataList)
		{
			String text  = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
			System.out.println();
		}
	}
	
	private void getProductPrice()
	{
		List<WebElement> metaPriceList  = driver.findElements(productPriceData);
		String price = metaPriceList.get(0).getText().trim();
		String extPrice =metaPriceList.get(1).getText().trim();
		productInfoMap.put("Price", price);
		productInfoMap.put("Ext-Price", extPrice);
	}

}
