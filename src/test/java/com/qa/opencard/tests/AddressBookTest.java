package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AddressBookPage;
import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.excelUtil;

public class AddressBookTest extends baseTest
{
	private AddressBookPage addBookPage;
	@BeforeClass 
	public void loginPageSetUp()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		addBookPage = loginPage.goToAddressBookPage();
	}
	
	@Test
	public void validateAddressBookLinkTest()
	{
		Assert.assertTrue(addBookPage.validateAddressBookTitle());
	}
	
	@Test
	public void validateNewAddBtnTest()
	{
		addBookPage.validateNewAddBtn();
	}
	
	@DataProvider
	public Object[][] getAddressBookData()
	{
		return excelUtil.getTestData(Constants.ADDRESS_SHEET_NAME);
	}

	@Test(dataProvider ="getAddressBookData")
	public void loadAddressBookData(String firstName, String lastName, String company, String add1, String add2, String city) throws InterruptedException
	{
		addBookPage.addAddress(firstName, lastName, company, add1, add2, city);
	}
}
