package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class AddressBookPage 
{
	private WebDriver driver;
	private ElementUtils el;
	
	public AddressBookPage(WebDriver driver)
	{
		this.driver = driver;
		el = new ElementUtils(driver);
	}
	
	
	private By AddBookHeader = By.xpath("//h2[text()='Address Book Entries']");
	private By NewAddressBtn = By.xpath("//a[text()='New Address']");
	private By firstName = By.xpath("*//input[@id='input-firstname']");
	private By lastName = By.xpath("*//input[@id='input-lastname']");
	private By company = By.xpath("*//input[@id='input-company']");
	private By add1 = By.xpath("*//input[@id='input-address-1']");
	private By add2 = By.xpath("*//input[@id='input-address-2']");
	private By city = By.xpath("*//input[@id='input-city']");
	//private By firstName = By.id("input-firstname");
	
	
	
	public Boolean validateAddressBookTitle()
	{
		
		String addBookHeader = el.getElement(AddBookHeader).getText();
		if(addBookHeader.equalsIgnoreCase(Constants.ADDRESS_BOOK_TITLE))
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
	
	public void validateNewAddBtn()
	{
		if(el.isDisplayed(NewAddressBtn))
		{
			el.doClick(NewAddressBtn);
		}
		else
		{
			System.out.println("Button does not exist");
		}
	}
	
	public void addAddress(String firstName, String lastName, String company, String add1, String add2, String city) throws InterruptedException
	{
		Thread.sleep(10000);
		el.doSend(this.firstName, firstName);
		el.doSend(this.lastName, lastName);
		el.doSend(this.company, company);
		el.doSend(this.add1, add1);
		el.doSend(this.add2, add2);
		el.doSend(this.city, city);	
	}
	
	
}
