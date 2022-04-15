package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WishListPage {
private WebDriver driver;
private ElementUtils eleUtils;
	
public WishListPage(WebDriver driver) 
	{
		this.driver = driver;
		eleUtils = new ElementUtils(driver);
	}
	
private By wishListTitle = By.xpath("//h2[text()='My Wish List']") ;	
private By productNameHeader = By.xpath("//td[text()='Product Name']");
private By actionHeader = By.xpath("//td[text()='Action']");
private By successMsg = By.xpath("//*[@id='account-wishlist']/div[1]/text()[1]");

public boolean validatewishListPageTitle()
{
	String actualTitle = driver.findElement(wishListTitle).getText();
	String expectedTitle = Constants.WISH_LIST_PAGE_TITLE;
	if(actualTitle.equals(expectedTitle))
	{
		System.out.println("PASS");
		return true;
	}
	else
	{
		System.out.println("FAIL");
		return false;
	}

}

public boolean validateProductName()
{
	String prod = driver.findElement(with(By.tagName("a")).below(productNameHeader)).getText();
	if(prod.equalsIgnoreCase(Constants.PRODUCT_NAME))
	{
		System.out.println("Yepieee we found the iMac");
		return true;
	}
	else
	{
		System.out.println("Oopes iMac is not available");
		return false;
	}
}

public void addToCart() throws InterruptedException
{
	WebElement cartButtonPresent = driver.findElement(with(By.tagName("button")).below(actionHeader));
	if(cartButtonPresent.isDisplayed())
	{
		cartButtonPresent.click();
		Thread.sleep(100000);
		System.out.println("Button is present on UI");
		System.out.println(driver.findElement(successMsg).getText());
	}
	else
	{
		System.out.println("Button not present");
	}
}


}
