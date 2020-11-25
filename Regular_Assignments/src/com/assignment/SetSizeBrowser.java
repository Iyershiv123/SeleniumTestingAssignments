package com.assignment;

import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetSizeBrowser 
{
	static WebDriver driver;
	//URL given for Assignment
	String url = "http://zlti.com";
	
	
	
	@BeforeClass
	public void setEnvironment()
	{
		//Setting the browser webdriver path
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		//Invoking the ChromeDriver() obj
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterClass
	public static void closeDown()
	{
		driver.close();
	}
	
	@Test
	public void setBrowserSizeAssignment() throws Exception
	{
		//Inorder to set the size of the browser window Selenium provides 
		//dimension class where we can provide the values.
		
		Dimension dimension = new Dimension(1024, 768);
//		Dimension dimension = new Dimension(500, 250);
		driver.manage().window().setSize(dimension);
		Thread.sleep(5000);
	}
	
}

