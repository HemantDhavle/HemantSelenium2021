package com.qa.opencard.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.utilities.Constants;

public class accountPageTest extends baseTest
{
	public AccountPage accountPage;
	public ProductInfoPage productinfo;
	@BeforeClass
	public void accountPageSetUp()
	{
		accountPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));	
	}
	
	
	@Test
	public void accountPageTitleTest()
	{
		String actTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void accountPageSectionHeaderTest()
	{
		List<String> actList= accountPage.getAccountPageSectionHeader();
		Assert.assertEquals(actList, Constants.accountSectionHeaderList());
	}
	
	@Test
	public void searchDisplayedTest()
	{
		boolean searchbox= accountPage.isSearchDisplay();
		Assert.assertTrue(searchbox);
	}
	@DataProvider
	public Object[][] productList()
	{
		return new Object[][]
		{
			{"Macbook"},
			{"iphone"},
			{"Samsung"},
		}; 	
		
	}
	
	@Test(dataProvider = "productList")
	public void doSearchTest(String productName)
	{
		searchPage= accountPage.doSearch(productName);
		Assert.assertTrue(searchPage.getProductsListCount()>0);
		
	}
	
	
	@DataProvider
	public Object[][] productSelectData()
	{
		return new Object[][]
		{
			{"Macbook", "MacBook Pro"},
			{"iMac", "iMac"},
			{"Samsung", "Samsung Galaxy Tab 10.1"}
		}; 	
		
	}

	@Test(dataProvider = "productSelectData" )
	public void selectProductTest(String mainProd , String prod)
	{
		searchPage= accountPage.doSearch(mainProd);
		productinfo= searchPage.selectProduct(prod);
		
		Assert.assertEquals(productinfo.getProductInfoHeader(), prod);
		
	}
}
