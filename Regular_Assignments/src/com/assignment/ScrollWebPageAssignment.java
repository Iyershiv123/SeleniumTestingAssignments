package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollWebPageAssignment 
{
	static WebDriver driver;
	//URL given for Assignment
	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";
	
	
	
	@BeforeClass
	public void setEnvironment()
	{
		//Setting the browser webdriver path
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		//Invoking the ChromeDriver() obj
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void closeDown()
	{
		driver.close();
	}
	
	@Test
	public void testScroll() throws Exception
	{
		/*Selenium provides to scroll the page using the JavaScript Executor interface
		In selenium there are three ways by which we can scroll the webpage
		1. Scroll the page by Pixel.
		 * 2.Scroll the page by visibility of element
		 * 3.scroll the webpage till the bottom of the page
		 */
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
//		
		
//		WebElement ele = driver.findElement(By.linkText("Admin"));
//		js.executeScript("arguments[0].scrollIntoView();", ele);
		
//		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
//		
		
	}
}
