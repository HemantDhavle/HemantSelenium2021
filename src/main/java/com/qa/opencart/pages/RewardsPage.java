package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class RewardsPage 
{
	public WebDriver driver;
	public ElementUtils el;
	public RewardsPage(WebDriver driver)
	{
		this.driver = driver;
		el = new ElementUtils(driver);
	}
	
	
	private By rewardsPageTitle = By.xpath("//h1[text()='Your Reward Points']");

	public boolean validateRewardsPageTitle()
	{
		String actualRewardsPageTitle  = el.getElement(rewardsPageTitle).getText();
		String expectedRewardsPageTitle = Constants.REWARDS_PAGE_TITLE;
		if(actualRewardsPageTitle.equals(expectedRewardsPageTitle))
		{
			System.out.println("Hureee!!!! Title is expected");
			return true;
		}
		else
		{
			System.out.println("Ooops!!!! Invalid title");
			return false;
		}
		
	}
}
