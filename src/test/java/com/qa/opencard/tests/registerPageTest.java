package com.qa.opencard.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.excelUtil;

public class registerPageTest extends baseTest
{

	@BeforeClass
	public void setupRegistration() {
		registrationPage = loginPage.goToRegistrationPage();
	}
	
	public String getRandomEmail() {
		Random randomGenerator = new Random();
		String email = "septautomation"+randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegisterData() {
		return excelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}

	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String telphone, 
			String password,
			String subscribe) {

		Assert.assertTrue(
				registrationPage.accountRegistration(firstName, lastName, getRandomEmail(), telphone, password, subscribe));

	}
}
