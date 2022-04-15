package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.pages.WishListPage;

public class wishListPageTest extends baseTest
{
	public WishListPage wishListPage;
	@BeforeClass
	public void loginPageSetUp()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		wishListPage = loginPage.goWishListPage();
	}
	
	@Test(priority =1)
	public void doValidateWishListPageTitleTest()
	{
		Assert.assertTrue(wishListPage.validatewishListPageTitle());
	}
	
	@Test(priority =2)
	public void doValidateProductLinkTest()
	{
		Assert.assertTrue(wishListPage.validateProductName());
		
	}
	
	@Test(priority =3)
	public void doAddToCartTest() throws InterruptedException
	{
		wishListPage.addToCart();
	}

}
