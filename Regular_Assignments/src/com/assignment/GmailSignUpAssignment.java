package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailSignUpAssignment 
{
	static WebDriver wDriver;
	String url = "https://accounts.google.com/signup";
	
	@BeforeClass
	public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			wDriver = new ChromeDriver();
			wDriver.get(url);
			wDriver.manage().window().maximize();
		}
		
		@AfterClass
		public  static void tearDown()
		{
			wDriver.close();
		}
		
		@Test
		public void testAccountCreation() throws InterruptedException
		{
			WebElement fName = wDriver.findElement(By.id("firstName"));
			fName.sendKeys("Srikrishna");
			String fname = fName.getAttribute("value");
			System.out.println(fname);
			
			WebElement lName = wDriver.findElement(By.id("lastName"));
			lName.sendKeys("Damle");
			String lname = lName.getAttribute("value");
			System.out.println(lname);
			
			WebElement uName = wDriver.findElement(By.id("username"));
			uName.sendKeys("Sr09faser");
			String uname = uName.getAttribute("value");
			System.out.println(uname);
			
			WebElement passWord = wDriver.findElement(By.name("Passwd"));
			passWord.sendKeys("Drdo@123");
			String pass = passWord.getAttribute("value");
			System.out.println(pass);
			
			WebElement cPassWd = wDriver.findElement(By.name("ConfirmPasswd"));
			cPassWd.sendKeys("Drdo@123");
			String cPAss = cPassWd.getAttribute("value");
			System.out.println(cPAss);
			
			//Next button
			wDriver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
//			
			
			
			
			
			
			Thread.sleep(2000);
			
			String actual= wDriver.findElement(By.id("headingText")).getText();
			String expected="Verifying your phone number";
			Assert.assertTrue(actual.equals(expected));
			//wDriver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
			
//			WebElement Code = wDriver.findElement(By.xpath("//input[@id='code']")).sen
			
			
			
			
		
	}
}
