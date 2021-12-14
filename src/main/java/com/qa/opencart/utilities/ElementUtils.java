package com.qa.opencart.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtils {


	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	public ElementUtils(WebDriver driver) {
		this.driver= driver;
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	public By getBy(String locatorType,String locatorValue)
	{
		By Locator = null;
		switch (locatorType) {
		case "id":
			Locator = By.id(locatorValue);
			break;
		case "name":
			Locator = By.name(locatorValue);
			break;

		case "className":
			Locator = By.className(locatorValue);
			break;

		case "xpath":
			Locator = By.xpath(locatorValue);
			break;

		case "linktext":
			Locator = By.linkText(locatorValue);
			break;

		case "partiallinktext":
			Locator = By.partialLinkText(locatorValue);
			break;

		case "cssSelector":
			Locator = By.cssSelector(locatorValue);
			break;
		default:
			System.out.println("Please pass the correct locator");
			break;
		}
		return Locator;
	}
	
	public WebElement getElement(By Locator)
	{
		WebElement element = driver.findElement(Locator);
		if(Boolean.parseBoolean(DriverFactory.highlight))
		{
			
			jsUtil.flash(element);
		}
		return element;
	}
	
	public WebElement getElement(String locatorType,String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public void doClick(By Locator)
	{
		getElement(Locator).click();
	}
	public void doSend(By Locator,String value)
	{
		getElement(Locator).sendKeys(value);
	}

	public List<WebElement> getElements(By Locator)
	{
		return driver.findElements(Locator);
	}
	public List<WebElement> getElements(String locatorType,String locatorValue)
	{
		return driver.findElements(getBy(locatorType, locatorValue));
	}

	public List<String> getElementTexts(By Locator)
	{
		List<WebElement> elements= getElements(Locator);
		List<String> eleList= new ArrayList<String>();
		for(WebElement e : elements)
		{
			String elem= e.getText();
			eleList.add(elem);
		}
		return eleList;
	}
	 /*************WebElement driver wait***/
	
	public WebElement doElementPresence(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}

	public WebElement doElementPresence(By locator, int time , long interval)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time), Duration.ofSeconds(interval));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public WebElement doElementVisible(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	public WebElement doElementVisible(By locator, int time , long interval)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time), Duration.ofSeconds(interval));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public List<WebElement> doElementsVisible(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	

	public List<WebElement> doElementsVisible(By locator, int time, long interval)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time),Duration.ofSeconds(interval));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	
	public void doWaitSend(By locator, int time, String value)
	{
		doElementVisible(locator, time).sendKeys(value);
	}
	
	 /*************NonWebElement driver wait***/
	
	public Boolean doWaitForTitleFraction(String titleFraction, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	
	public Boolean doWaitForTitlePresent(String title, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	public Boolean doWaitForURLFraction(String urlFraction, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public Boolean doWaitForURLPresent(String url, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public Alert doWaitAlert(int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void doWaitAlertAccept(int time)
	{
		doWaitAlert(time).accept();
	}
	
	public void doWaitAlertDismiss(int time)
	{
		doWaitAlert(time).dismiss();
	}
	
	public void doWaitAlertDoSend(int time,String value)
	{
		doWaitAlert(time).sendKeys(value);
	}
	
	

}
