package day_3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearch 
{
    public static void main(String[] args) 
    {
        // Set the path to your chromedriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.geeksforgeeks.org/");
        
        
        System.out.println("Page Title: "+driver.getTitle()); //Title of first website
        
        //driver.switchTo().newWindow(WindowType.TAB);// This help to open the website in new tab.

        
        driver.get("https://www.youtube.com/"); //If you want to open two different websites.
        
       // driver.get("https://www.geeksforgeeks.org/java/java/");// If you are using sam e website and opening different tabs then quit closes all tabs. Close() closes the active tab of the website.
        
        System.out.println("Page Title: "+driver.getTitle());  //Title of second website.
 
      
        driver.quit();
       //driver.close();
    }
}