package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class NewsLetterPage 
{
	public  WebDriver driver;
	public ElementUtils elUtils;
	
	public NewsLetterPage(WebDriver driver)
	{
		this.driver = driver;
		elUtils = new ElementUtils(driver);
	}
	
	
	private By newsLetterPageTitle = By.xpath("//h1[text()='Newsletter Subscription']");
	private By subscribeYes = By.xpath("//input[@name='newsletter' and @value='1']"); 
	private By subscribeNo = By.xpath("//input[@name='newsletter' and @value='0']");
	private By continuebutton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMsgNewsLetter = By.xpath("//*[@id='account-account']/div[1]");
	
	public boolean validateNewLetterPageTitle()
	{
		elUtils.doElementsVisible(newsLetterPageTitle, 5);
		String actualNewsLetterPageTitle = elUtils.getElement(newsLetterPageTitle).getText().trim();
		String expectedNewLetterPageTitle = Constants.NEWS_LETTER_PAGE_TITLE;
		if(actualNewsLetterPageTitle.equals(expectedNewLetterPageTitle))
		{
			System.out.println("PASS --- Title is expected");
			return true;
		}
		else
		{
			System.out.println("FAIL --- Unexpected Title");
			return false;
		}
	}
	
	public void validateSubscribeRadioButton()
	{
		String isChecked= elUtils.getElement(subscribeNo).getAttribute("checked");
		System.out.println(isChecked);
		
		if(Boolean.parseBoolean(isChecked))
		{
			System.out.println("User has not subscribed yet");
			elUtils.getElement(subscribeYes).click();
			System.out.println("User has subscribed the newletter successfully");
		}
		else
		{
			System.out.println("User already subscribed the newsletter");
			elUtils.getElement(subscribeYes).click();
		}
	}
	
	public void validateContinueButton()
	{
		boolean continueButtonPresent = elUtils.isDisplayed(continuebutton);
		
		if(continueButtonPresent)
		{
			System.out.println("Continue button is present on screen");
			elUtils.doClick(continuebutton);
			elUtils.doElementsVisible(successMsgNewsLetter, 5);
			System.out.println(elUtils.getElement(successMsgNewsLetter).getText());
		}
		else
		{
			System.out.println("Continue button is not present on screen");
		}
	}

}
