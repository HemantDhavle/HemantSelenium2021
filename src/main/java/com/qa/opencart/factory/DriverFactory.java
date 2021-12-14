package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	public OptionManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	//1.
	public static String highlight;
	public WebDriver init_driver(Properties prop )
	{
		String browserName = prop.getProperty("browser");
		optionManager = new OptionManager(prop);
		System.out.println("Browser name is "+browserName);
		//2.
		highlight = prop.getProperty("highlight");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionManager.getChromeOption());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOption()));
		}
		else  if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionManager.getFirefoxOption());
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOption()));
		}
		else  if(browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser "+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		URL url;
		
		try {
			url = new URL(prop.getProperty("url"));
			openURL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDriver();	
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	public Properties init_prop()
	{
		prop = new Properties();
		FileInputStream fs = null;
		String envName = System.getProperty("env");
		try
		{
			if(envName ==null)
		{
			System.out.println("We are running on production environment");
			fs = new FileInputStream("./src/test/resources/config/config.properties");
		}
		else
		{
			System.out.println("We are running on "+envName+ " environment");
			switch (envName.toLowerCase()) {
			case "qa":
				fs = new FileInputStream("./src/test/resources/config/qa_config.properties");
				break;

			default:
				System.out.println("Please pass the correct environment");;
			}
			
		}
			
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	//Get Screenshot
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	/*
	 * URL 
	 */
	public void openURL(String url)
	{
		try
		{if(url==null)
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().get(url);
	}

	public void openURL(URL url)
	{
		try
		{if(url==null)
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().navigate().to(url);
	}
	public void openURL(String baseURL, String path)
	{
		try
		{if(baseURL==null)
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().get(baseURL+"/"+path);
	}
	public void openURL(String baseURL, String path, String queryParam)
	{
		try
		{if(baseURL==null)
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().get(baseURL+"/"+path+"?"+queryParam);
	}


}
