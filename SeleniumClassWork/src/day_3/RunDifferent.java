package day_3;
import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RunDifferent
{
	
	    public static void main(String[] args) throws InterruptedException 
	    {
	 
	        
	    	
	        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
	 
//	        WebDriver driver = new ChromeDriver();
//	 
//	        
//	        driver.manage().window().maximize();
//	        System.out.print("hello");
//	 
//	       
//	        driver.get("https://www.google.com");
//	        Thread.sleep(2000);  
	    	//driver.quit();
	    	
	    	String driverPath = "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\edgedriver_win64\\msedgedriver.exe"; // <<< update this to where you put msedgedriver.exe

	        
	        File f = new File(driverPath);
	        if (!f.exists()) {
	            System.err.println("EdgeDriver not found at: " + driverPath);
	            return;
	        }


	        //Microsoft Edge
	        
	       /* System.setProperty("webdriver.edge.driver", driverPath);

	     
	        EdgeOptions options = new EdgeOptions();
	        options.setAcceptInsecureCerts(true);

	        WebDriver driver = null;
	        try 
	        {
	            driver = new EdgeDriver(options);

	         
	            driver.get("https://www.geeksforgeeks.org/");
	            System.out.println("Page Title: " + driver.getTitle());
	        } 
	        finally 
	        {
	            if (driver != null) {
	                driver.quit();
	            }
	        }*/
	        
	        
	        //Mozilla Firefox
	        
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\geckodriver.exe");

	        // 2) Create instance of Firefox driver
	        WebDriver driver = new FirefoxDriver();

	        // 3) Maximize window
	        driver.manage().window().maximize();

	        // 4) Open first page
	        driver.get("https://www.facebook.com");
	        
	        System.out.println("Get Title: "+driver.getTitle());
	        
	        try {
	            Thread.sleep(5000); // wait for 5 sec to see result
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        driver.quit();

	    }
}

