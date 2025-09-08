package com.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    
    public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutSeconds)
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    
    public static void waitForElementClickable(WebDriver driver, WebElement element, int timeoutSeconds) 
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

  
    public static void waitForUrlContains(WebDriver driver, String text, int timeoutSeconds)
    {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.urlContains(text));
    }
}
