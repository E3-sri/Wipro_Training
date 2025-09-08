package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.utils.ConfigReader;

public class DriverFactory 
{
    private static WebDriver driver;

    public static WebDriver initDriver()
    {
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            
        }
        else if(browser.equalsIgnoreCase("edge")) {
        	driver=new EdgeDriver();
        }
        	
        
        else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver()
    {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
        }
        return driver;
    }
    
    public static void quitDriver() 
    {
        if (driver != null) {
            driver.quit();
            driver = null;  
        }
    }
}
