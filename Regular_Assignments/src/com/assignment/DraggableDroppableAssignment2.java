package com.assignment;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class DraggableDroppableAssignment2 
{
	static WebDriver driver;
	String url = "https://jqueryui.com/droppable/";
	
	@BeforeClass
	public void setEnvironment()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		//This site uses iframe so we need to use this, otherwise testcase will not pass
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void closeDown()
	{
		driver.close();
	}
	
	@Test
	public void testMethod1() throws Exception
	{
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDrop(source, target).perform();
		Thread.sleep(3000);

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File("D:\\Selenium\\screenshot1.png"));
		}
		catch (IOException e) 
			{
				System.out.println("Exception message is "+e.getMessage());
			}
		finally{
			System.out.println("This has to be executed");
			
		}
	}
	
	
}
