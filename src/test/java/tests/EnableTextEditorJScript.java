package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class EnableTextEditorJScript {
  
	WebDriver driver;
	
  @Test(priority=1)
  public void enableTextbox() {
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  WebElement  element = driver.findElement(By.id("myInput"));
	  js.executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
	  element.sendKeys("test"); 
	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	 
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("file:///D:/shital/Prognosticsoft/nilesh_html/html_task/readonly.html");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
