package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.pages.NewsLetterPage;

public class NewsLetterPageTest extends baseTest
{
	public NewsLetterPage newsLetterPage;
	
	@BeforeClass
	
	public void loginPageSetUp()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		newsLetterPage = loginPage.goNewsLetterPage();
	}
	
	
	@Test(priority =1)
	public void validateNewLetterPageTitleTest()
	{
		Assert.assertTrue(newsLetterPage.validateNewLetterPageTitle());
	}
	
	@Test(priority =2)
	public void validateSubscribeRadioButtonTest()
	{
		newsLetterPage.validateSubscribeRadioButton();
	}
	
	@Test(priority =3)
	public void validateContinueButtonTest()
	{
		newsLetterPage.validateContinueButton();
	}
	
	
}
