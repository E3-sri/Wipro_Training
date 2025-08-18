package day_3;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PageFirefox
{  
	public static void main(String[] args) 
	{
		
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\geckodriver.exe");

	 FirefoxOptions  Options = new FirefoxOptions();
     Options.setPageLoadStrategy(PageLoadStrategy.NONE);
     WebDriver driver = new FirefoxDriver(Options);

    // 4) Open first page
    driver.get("https://www.facebook.com");
    
    System.out.println("Get Title: "+driver.getTitle());
    
    driver.quit();
	}
}
