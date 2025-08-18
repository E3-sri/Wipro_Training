package day_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProject 
{
    public static void main(String[] args) 
    {
        // Set the path to your chromedriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.geeksforgeeks.org/");
        
        System.out.println("Page Title: "+driver.getTitle());

       /* // Wait for 5 seconds
        try {
            Thread.sleep(5000); // Simulate waiting for a few seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // Close the browser
        driver.quit();
    }
}
