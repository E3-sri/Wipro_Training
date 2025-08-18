//To open multiple tabs and open diff websites on them.

package day_3;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
 
 
public class SampleSearch {
    public static void main(String[] args) throws InterruptedException {
 
        
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\\");
 
        WebDriver driver = new ChromeDriver();
 
        
        driver.manage().window().maximize();
        System.out.print("hello");
 
       
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        
        System.out.print("hello");
        
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        
        driver.get("https://www.youtube.com");
        
        driver.switchTo().window("https://www.youtube.com");
 
 
        
        Thread.sleep(5000);
        driver.quit();
    }
}
 
 