package com.assignment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakeScreenShotAssignment 
{
	
	static WebDriver driver;
	String url = "https://api.jquery.com/dblclick/";
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	/*To capture a screenshot in Selenium, we can make use of an interface, called TakesScreenshot.*/
	@Test
	public void testScreenShot()
	{
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//TakesScreenShot interface 
		try {																			//is provided by Slenium
			FileHandler.copy(screenShot, new File("D:\\Selenium\\screenshot001.png"));//Using this statement, we can store the file 
			System.out.println("Screenshot has been captured.");
		
		} catch (IOException e) {														//in our system
			System.out.println("exception caught is"+e.getMessage());
		
			}
		}
	
	@AfterClass
	public static void tearDown()
	{
		driver.close();
	}
		
	}

