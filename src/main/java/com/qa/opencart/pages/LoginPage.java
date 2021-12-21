package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ElementUtils;

public class LoginPage {

	//1.Declare private driver
	private WebDriver driver;
	private ElementUtils eleUtil;

	
	//2.Create custructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtils(driver);

	}
	//3.Create private locator of login page
	private By emailId = By.xpath("//input[@name = 'email']");
	private By password = By.xpath("//input[@name = 'password']");
	private By loginbtn = By.xpath("//input[@value= 'Login']");
	private By forgetlink = By.xpath("//input[@name='password']//following-sibling::a");
	private By errorMsg = By.xpath("//*[@id='account-login']/div[1]/i");
	private By registerlink = By.xpath("//*[@id='column-right']/div/a[2]");
	
	//4.Page Action
	public String getLoginPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgetPasswordLinkExist()
	{
		return driver.findElement(forgetlink).isDisplayed();
	}
	
	public AccountPage doLogin(String un, String pw)
	{
		eleUtil.getElement(emailId).sendKeys(un);
		
		//driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginbtn).click();
		return new AccountPage(driver);
	}
	
	public boolean doLoginWithWrongCredentials(String un , String pw)
	{
		System.out.println("Logging with wrong credentials "+un+ " : "+pw);
		eleUtil.getElement(emailId).sendKeys(un);
		eleUtil.getElement(password).sendKeys(un);
		eleUtil.doClick(loginbtn);
		String errorMessage= eleUtil.getElement(errorMsg).getText();
		System.out.println("error msg is" +errorMessage);
		if(errorMessage.contains(Constants.LOGIN_ERROR_MESSAGE))
		{
			System.out.println("Login is not successful");
			return false;
		}
		return true;
		}
	
	public RegistrationPage goToRegistrationPage()
	{
		eleUtil.doClick(registerlink);
		return new RegistrationPage(driver);
	}
	
}
