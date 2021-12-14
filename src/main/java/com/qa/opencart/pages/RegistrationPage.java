package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class RegistrationPage 
{
	private WebDriver driver;
	private ElementUtils el;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		el = new ElementUtils(driver);
	}
	
	private By firstName = By.xpath("//*[@id='input-firstname']");
	private By lastName = By.xpath("//*[@id='input-lastname']");
	private By eMail = By.xpath("//*[@id='input-email']");
	private By telePhone = By.xpath("//*[@id='input-telephone']");
	private By passWord = By.xpath("//*[@id='input-password']");
	private By confirmPassWord = By.xpath("//*[@id='input-confirm']");
	private By subscribeYes = By.xpath("//*[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//*[@class='radio-inline'][position()=2]/input");
	private By agreeCheckBox = By.xpath("//*[@id='content']/form/div/div/input[1]");
	private By continueButton = By.xpath("//input[@value ='Continue']");
	private By successMsg = By.xpath("//div[@id='content']/h1");
	private By logoutButton = By.xpath("//*[@id='column-right']/div/a[13]");
	private By registerlink = By.xpath("//*[@id='column-right']/div/a[2]");
	
	public boolean accountRegistration(String firstName, String lastName, String eMail, String telePhone, String password, String subscribe)
	{
		el.doSend(this.firstName, firstName);
		el.doSend(this.lastName, lastName);
		el.doSend(this.eMail, eMail);
		el.doSend(this.telePhone, telePhone);
		el.doSend(this.passWord, password);
		el.doSend(this.confirmPassWord, password);
		if(subscribe.equals("yes"))
		{
			el.doClick(subscribeYes);
		}
		else
		{
			el.doClick(subscribeNo);
		}
		el.doClick(agreeCheckBox);
		el.doClick(continueButton);
		
		String successMessage = el.doElementVisible(successMsg, 4, 2000).getText();
		
		if(successMessage.contains(Constants.REGISTRATION_SUCCESS_MESSAGE))
		{
			el.doClick(logoutButton);
			el.doClick(registerlink);
			return true;
			
		}
		return false;
	}
	
}
