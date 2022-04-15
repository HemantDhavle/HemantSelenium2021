package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class AffiliatePage 
{
	public WebDriver driver;
	public ElementUtils el;
	
	public AffiliatePage(WebDriver driver) 
	{
		this.driver = driver;
		el = new ElementUtils(driver);
	}
	
	private By affiliatePageTitle = By.xpath("//h1[text()='Your Affiliate Information']") ;
	private By company = By.id("input-company");
	private By website = By.id("input-website");
	private By tax = By.id("input-tax");
	private By chequeRadioBtn = By.xpath("//input[@value='cheque']");
	private By paypalRadioBtn = By.xpath("//input[@value='paypal']");
	private By bankRadioBtn = By.xpath("//input[@value='bank']");
	private By paypal = By.id("input-paypal");
	private By agree = By.xpath("//input[@name='agree']");
	
	public boolean doValidateAffiliatePageTitle()
	{
		String actualAffiliatePageTitle  = el.getElement(affiliatePageTitle).getText();
		String expectedAffiliatePageTitle = Constants.AFFILIATE_PAGE_TITLE;
		if(actualAffiliatePageTitle.equals(expectedAffiliatePageTitle))
		{
			System.out.println("PASS --- Hurray expected title");
			return true;
		}
		else
		{
			System.out.println("FAIL --- Invalid title");
			return false;
		}
	}
	
	public void addAffiliateDetails(String company, String website, String tax,String paypal)
	{
		el.doSend(this.company, company);
		el.doSend(this.website, website);
		el.doSend(this.tax, tax);
		el.doClick(bankRadioBtn);
		el.doSend(this.paypal, paypal);
		el.doClick(agree);
	}
	
	

}
