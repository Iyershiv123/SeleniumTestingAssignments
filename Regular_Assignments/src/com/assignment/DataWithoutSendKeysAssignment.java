package com.assignment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//Automation test to enter data without using sendkeys
public class DataWithoutSendKeysAssignment
{

	static WebDriver driver;
	String url = "http://dbankdemo.com/login";
	
	@BeforeClass
	public void setEnvironment()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	@AfterClass
	public static void closeDown()
	{
		driver.close();
	}
	@Test
	public void testDataWithoutSendKeys() throws Exception
	{
		// Initialize JS object
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		// Enter username
		JS.executeScript("document.getElementById('username').value='shiv@gmail.com'");
		// Enter password
		JS.executeScript("document.getElementById('password').value='Shiv@123'");
		Thread.sleep(5000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File("D:\\Selenium\\Assignment77.png"));
		}
		catch (IOException e) 
			{
				System.out.println("Exception message is "+e.getMessage());
			}
		finally{
			System.out.println("This has to be executed");
			
		}
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		
	}
}
