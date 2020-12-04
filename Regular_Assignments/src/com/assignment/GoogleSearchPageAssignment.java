package com.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchPageAssignment 
{
	static WebDriver driver;
	String url = "https://www.google.com";
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public  static void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void testSearchPage() throws InterruptedException
	{
		
		WebElement tBox = driver.findElement(By.name("q"));
		tBox.sendKeys("Defect Life Cycle");
	
		System.out.println("Selenium Commands is etered in the textbox");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
/* This Xpath is obtained by right clicking on element in the chrome and 
 * getting the default value
 * driver.findElements(By.className("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul"));
 */
		//Here Custom xapth can be defined by using => //Custom XPath -->//tagname[@locator name]
		List <WebElement> lists =driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		
		//As we are looking for suggestions, we are using list and loops for iterating the search results
		for(int sE = 0; sE < lists.size(); sE++)
		{
			String ele = lists.get(sE).getText();
			if(ele.equalsIgnoreCase("Defect Life Cycle"))
			{
				lists.get(sE).click();
				break;
			}
		}
		Thread.sleep(5000);
		
	}
	
}
