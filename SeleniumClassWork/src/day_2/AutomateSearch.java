//Use Case: Automate Google Search

package day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateSearch {
    public static void main(String[] args) {
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
    	          

    	        WebDriver driver = new ChromeDriver();

    	        try {
    	            driver.get("https://www.google.com");

    	            WebElement searchBox = driver.findElement(By.name("q"));
    	            searchBox.sendKeys("Selenium WebDriver tutorial");
    	            searchBox.sendKeys(Keys.RETURN);

    	            System.out.println("Page Title: " + driver.getTitle());

    	           
    	            Thread.sleep(50000);

    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        } finally {
    	            driver.quit();
    	        }
    	    }
    	}


