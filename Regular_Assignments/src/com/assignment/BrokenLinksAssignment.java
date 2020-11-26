package com.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAssignment 
{
	public static void main(String[] args) throws Exception 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver;							//Instantiating the WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();		//Maximizing the window
		driver.get("http://www.zlti.com/");			//URL of AUT
		Thread.sleep(2000);
		//Inorder to find all elements we are declaring a list and storing it in the list.
		List<WebElement> link = driver.findElements(By.tagName("a"));
		
		//To print the total number of Links
		System.out.println("Total number of Links are "+link.size());
		
		//Using for loop to iterate
		for(int l = 0; l<link.size();l++)
		{
			WebElement element = link.get(l);
			String url = element.getAttribute("href");
			verifyURLinks(url);
		}
		
		
		
}
	public static void verifyURLinks(String urlLinks) 
	{
		try {
		URL links = new URL(urlLinks);
		HttpURLConnection httpConn =(HttpURLConnection)links .openConnection();
//		httpConn.setConnectTimeout(2000);
		httpConn.connect();
		if(httpConn.getResponseCode()== 200) {	
			System.out.println(urlLinks+" - "+httpConn.getResponseMessage());
		}
		if(httpConn.getResponseCode()== 404) {
			System.out.println(urlLinks+" - "+httpConn.getResponseMessage());
		}
		}catch (Exception e) {
			//e.printStackTrace();
	}
	}
}

	