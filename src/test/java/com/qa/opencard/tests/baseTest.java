package com.qa.opencard.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.AddressBookPage;
import com.qa.opencart.pages.AffiliatePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.NewsLetterPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.RewardsPage;
import com.qa.opencart.pages.SearchResultPage;
import com.qa.opencart.pages.WishListPage;

public class baseTest 
{
	DriverFactory df ;
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	Properties prop;
	RegistrationPage registrationPage;
	SearchResultPage searchPage;
	ProductInfoPage productInforPage;
	AddressBookPage addBookPage;
	WishListPage wishListPage;
	NewsLetterPage newsLetterPage;
	SoftAssert softAssert;
	RewardsPage rewardsPage;
	AffiliatePage affiliatePage;
	@BeforeTest
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver  = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		
	}
	 
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
