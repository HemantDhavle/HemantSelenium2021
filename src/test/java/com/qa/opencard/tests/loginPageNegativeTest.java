package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginPageNegativeTest extends baseTest 
{
	@DataProvider
	public Object[][] loginWrongTestData()
	{
		return new Object[][]
		{
			{"test@com" , "test12313"},
			{"test" , "test12313"},
			{"@com" , "!@@$"},
			{"test@com.in" , ""}
			
		};
	}
	
	
	@Test(dataProvider = "loginWrongTestData")
	public void loginNegativeTest(String un, String pw)
	{
		Assert.assertFalse(loginPage.doLoginWithWrongCredentials(un, pw));
		
	}

}
