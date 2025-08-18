//PageLoadStrategy tells Selenium how long to wait for a page to finish loading before moving to the next command.
//Selenium waits until the entire page (HTML + CSS + images + scripts) finishes loading.
//Selenium does not wait at all — it continues immediately after the initial request.
package day_3;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOptions
{
	
	public static ChromeOptions getDefaultChromeOptions() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return options;
	}	
    public static void main(String[] args)
    {
		
	
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	     
	     
//	     //Normal
//    	 ChromeOptions chromeOptions = getDefaultChromeOptions();
//         chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//         WebDriver driver = new ChromeDriver(chromeOptions);
//	     driver.get("https://www.google.com");
//		    
//         System.out.println("Page title is: " + driver.getTitle());
//
//     	 
     	 
     	 //Eager
//	     
//	     ChromeOptions chromeOptions = getDefaultChromeOptions();
//	     chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//	     WebDriver driver = new ChromeDriver(chromeOptions);
//	 
//	     driver.get("https://www.google.com");
//	    
//         System.out.println("Page title is: " + driver.getTitle());
         
         
         //None
         
         ChromeOptions chromeOptions = getDefaultChromeOptions();
         chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
         WebDriver driver = new ChromeDriver(chromeOptions);
	     driver.get("https://www.google.com");
		    
         System.out.println("Page title is: " + driver.getTitle());
    	 driver.quit();
    }
		
}
