package day_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooLogin 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\yahoo.txt");
        props.load(fis);
        
        
        String username=props.getProperty("yahoo.username");
        String password=props.getProperty("yahoo.password");
        String login_page=props.getProperty("login.page");
       // String chromeDriverPath = props.getProperty("chromedriver.path");
        
        
       // System.setProperty("webdriver.chrome.driver", "chromeDriverPath");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        driver.get(login_page); 
        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-signin")).click();
        driver.findElement(By.id("login-passwd")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();
   
        System.out.println("Login Successful!!!");
	    Thread.sleep(5000);
	    driver.quit();

        
	}
}
