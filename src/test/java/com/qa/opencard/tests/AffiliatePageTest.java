package com.qa.opencard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AffiliatePage;
import com.qa.opencart.utilities.excelUtil;

public class AffiliatePageTest extends baseTest 
{
	public AffiliatePage affiliatePage;
	
	@BeforeClass
	public void doLoginSetUp()
	{
		loginPage.doLogin(prop.getProperty("un"),prop.getProperty("pw"));
		affiliatePage = loginPage.goAffiliatePage();
	}
	
	@Test(priority =1)
	public void doValidateAffiliatePageTitleTest()
	{
		Assert.assertTrue(affiliatePage.doValidateAffiliatePageTitle());
	}
	
	@DataProvider
	public Object[][] fatchAffiliateDate()
	{
		return excelUtil.getTestData("affiliate");
	}
	
	@Test(priority =2, dataProvider = "fatchAffiliateDate")
	public void getAffiliateDate(String company, String website,String tax,String paypal)
	{
		affiliatePage.addAffiliateDetails(company, website,tax,paypal);
	}
}
