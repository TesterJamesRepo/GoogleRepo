package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinkTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.unigreens.com/");
	}
	
	@Test
	public void checkBrokenLinks() throws MalformedURLException, IOException {
		
		List<WebElement> allLinksList = driver.findElements(By.tagName("a"));
		allLinksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("All links and img total count = "+ allLinksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(WebElement allLinks : allLinksList){
			
			if(!(allLinks.getAttribute("href")== null) && !(allLinks.getAttribute("href").contains("script"))){
				
				activeLinks.add(allLinks);
			}
			
		}
	  
		System.out.println("All active links and img total count = "+ activeLinks.size());
		
		for(WebElement activeLink : activeLinks){
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLink.getAttribute("href")).openConnection();
			connection.connect();
			String responseMessages = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLink.getAttribute("href")+"----->"+responseMessages);
			
			
		}
		
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
	}
	
	
}
