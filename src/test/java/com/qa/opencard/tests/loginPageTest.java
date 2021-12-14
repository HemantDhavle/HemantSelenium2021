package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.AllureListener;
import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Story("USD-123489 -> Login Page Functionality")
@Listeners(AllureListener.class)
public class loginPageTest extends baseTest
{
	@Description("Validating title of login page")
	@Test
	
	public void loginPageTitleTest()
	{
		String pageTitle = loginPage.getLoginPageTitle();
		System.out.println("Title of the page is "+pageTitle);
		Assert.assertEquals(pageTitle, Constants.LOGIN_PAGE_TITLE,Errors.LOGIN_PAGE_TITLE_IS_NOT_EXPECTED);
	}
	
	@Description("Validating URL of login page")
	@Test (enabled = false)
	public void loginPageURLTest()
	{
		String pageURL= loginPage.getLoginPageURL();
		System.out.println("Current login page URL is "+pageURL);
		Assert.assertTrue(pageURL.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validating user is able to login with correct user name and password")
	@Step("Do Login with username  : {0} and password  : {1}")
	@Test
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}
	
	@Test
	public void isForgetPasswordLinkExistTest()
	{
		boolean linkExist= loginPage.isForgetPasswordLinkExist();
		Assert.assertTrue(linkExist);
	}
	
	
}
