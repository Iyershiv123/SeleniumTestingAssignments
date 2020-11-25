package com.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinksAssignment 
{
	static WebDriver driver;
	String webPage = "https://jqueryui.com/droppable/";
	
	@BeforeClass
	public void setEnvironment()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(webPage);
	}
	@AfterClass
	public static void closeDown()
	{
		driver.close();
	}
	@Test
	public void testBrokenLinks() throws MalformedURLException, Exception
	{
		 
        List<WebElement> link = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = link.iterator();
        
        while(it.hasNext())
        {
        	String url = it.next().getAttribute("href");
        	System.out.println(url);
        
        if(url == null || url.isEmpty()){
System.out.println("URL is not configured for anchor tag or it is empty");
              continue;
          }
          
          if(!url.startsWith(webPage)){
              System.out.println("URL belongs to another domain, skipping it.");
              continue;
          }
          HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
          
          huc.setRequestMethod("HEAD");
          
          huc.connect();
          
          int respCode = huc.getResponseCode();
          
          if(respCode >= 400){
              System.out.println(url+" is a broken link");
          }
          else{
              System.out.println(url+" is a valid link");
          }
        }
        
	}
}
