package bootstrapdropdownassignments;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown 
{
	WebDriver driver;
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Set-Up Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void testDropDown()
	{
		//driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[8]/a/label"));
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> firstList = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		for(int i=0;i<firstList.size();i++)
		{
			System.out.println(firstList.get(i).getText());
			if(firstList.get(i).getText().equals("Java"))
			{
				firstList.get(i).click();
				break;
			}
		}
		
	}
}
