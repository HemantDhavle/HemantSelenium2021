package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage 
{
private WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	private By registerlink = By.xpath("//*[@id='column-right']/div/a[2]");
	private By fn = By.xpath("//*[@id='input-firstname']");
	
	public void registerlinkClick(String fName)
	{
		Boolean rlink= driver.findElement(registerlink).isDisplayed();
		Assert.assertTrue(rlink);
		driver.findElement(registerlink).click();
		System.out.println("Register link clicked successfully");
		System.out.println("First Name we are going to enter is "+fName);
		Boolean fnPresent= driver.findElement(fn).isDisplayed();
		Assert.assertTrue(fnPresent);
		driver.findElement(fn).sendKeys(fName);
		String fnEntered= driver.findElement(fn).getAttribute("value");
		System.out.println("Entered First Name is "+fnEntered);
	}
	
	public void fillRegisterForm(String fName)
	{
//		System.out.println("First Name we are going to enter is "+fName);
//		Boolean fnPresent= driver.findElement(fn).isDisplayed();
//		Assert.assertTrue(fnPresent);
//		driver.findElement(fn).sendKeys(fName);
//		String fnEntered= driver.findElement(fn).getAttribute("value");
//		System.out.println("Entered First Name is "+fnEntered);
	}

}
