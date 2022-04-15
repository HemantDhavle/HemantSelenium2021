package com.qa.opencard.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConceptTest 
{
public static WebDriver driver;

@Test
public static void validatePagination()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("http://www.babynames.merschat.com/popular.cgi");
	driver.manage().window().maximize();
	By nextbutton = By.xpath("//font[text()='Next']/..");
	List<WebElement> name = driver.findElements(By.xpath("//a[contains(@title,'Amoora')]"));
	while(true)
	{
		if(!(name.size()==1))
		{
			driver.findElement(nextbutton).click();
			name = driver.findElements(By.xpath("//a[contains(@title,'Amoora')]"));
			
		}
		else
		{
			System.out.println("we found the name");
			String title = driver.findElement(By.xpath("//a[contains(@title,'Amoora')]")).getAttribute("title");
			System.out.println(title);
			break;
		}
	}


}
	
	
}
