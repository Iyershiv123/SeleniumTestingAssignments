package com.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DaataProviderAssignment1 
{
	WebDriver driver;
	String url = "https://www.google.com/";
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@Test(dataProvider ="getDataFromProvider")
	public void testMethod(String author, String searchKey) throws InterruptedException
	{
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome " +author +" Your SearchKey is "+searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
		
	}
			


@DataProvider
public Object[][] getDataFromProvider()
{
	return new Object[][]
			{
				{"Shiva", "India"},
				{"Krishna", "USA"},
				{"Feroz", "Serbia"}
			};
	}
}
