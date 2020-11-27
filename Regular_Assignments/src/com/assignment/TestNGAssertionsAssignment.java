package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGAssertionsAssignment
{
	WebDriver driver;
	String url = "https://chennaiiq.com/chennai/pincode-by-name.php";
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
	}
	
	@Test				
	public void assertionsAssignment()
	{
		WebElement pin1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[20]"));
		WebElement pin2 = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[6]"));
		
		Assert.assertNotEquals(pin1, pin2);
		System.out.println("Pincodes are different");

//		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[20]"));
//		Assert.assertEquals(600040, 600040);
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
