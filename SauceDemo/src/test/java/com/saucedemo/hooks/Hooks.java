package com.saucedemo.hooks;

import com.saucedemo.base.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Starting scenario...");
        DriverFactory.initDriver();   
    }

    @AfterStep("@Product")
    public void addWaitAfterStep() {
        try
        { 
        	Thread.sleep(2000);
        } 
        catch (InterruptedException ignored) 
        {
        	
        }
    }

    @After
    public void tearDown(Scenario scenario)
    {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            if (scenario.isFailed()) {
                try {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "screenshot");
                } 
                catch (Exception e)
                {
                    System.out.println("Could not capture screenshot: " + e.getMessage());
                }
            }
           
            System.out.println("Closing browser...");
            DriverFactory.quitDriver();  
        }
    }
}
