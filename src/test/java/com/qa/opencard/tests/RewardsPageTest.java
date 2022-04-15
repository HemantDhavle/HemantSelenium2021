package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.pages.RewardsPage;

public class RewardsPageTest extends baseTest
{
	public RewardsPage rewardsPage;
	@BeforeClass
	public void doLoginSetUp()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		rewardsPage = loginPage.goRewardsPage();
	}
	
	@Test
	public void validateRewardsPageTitleTest()
	{
		Assert.assertTrue(rewardsPage.validateRewardsPageTitle());
	}
	

}
