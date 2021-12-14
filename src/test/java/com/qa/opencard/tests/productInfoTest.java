package com.qa.opencard.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utilities.Constants;

public class productInfoTest extends baseTest {
	
	@BeforeClass
	public void productInfoSetUp()
	{
		accountPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));	
	}
	
	@Test
	public void productHeaderTest()
	{
		searchPage  = accountPage.doSearch("MacBook");
		productInforPage= searchPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInforPage.getProductInfoHeader(), "MacBook Pro");
	}
	
	@Test
	public void productInfoImageCountTest()
	{
		searchPage  = accountPage.doSearch("MacBook");
		productInforPage= searchPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInforPage.getProductImageCount(), Constants.MACBOOKPRO_IMAGE_COUNT);
	}
	
	@Test
	public void productInfoPageTest()
	{
		searchPage  = accountPage.doSearch("MacBook");
		productInforPage= searchPage.selectProduct("MacBook Pro");
		Map<String, String> actMap= productInforPage.productInfoMap();
		actMap.forEach((k,v) -> System.out.println(k+ " : "+v));
		//Hard Assersion
		//Assert.assertEquals(actMap.get("Brand"), "Apple");
		//Soft Assersion
		softAssert.assertEquals(actMap.get("Brand"), "Apple1");
		softAssert.assertEquals(actMap.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(actMap.get("name"), "MacBook Pro");
		softAssert.assertAll();
	}
	

}
