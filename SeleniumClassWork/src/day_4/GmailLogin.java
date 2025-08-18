package day_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin 
{

	 public static void main(String[] args) throws IOException, InterruptedException 
	 {
		
		    Properties props = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\my.properties");
	        props.load(fis);
	        
	        String email = props.getProperty("gmail");
	        String password = props.getProperty("password");
	        String login_page=props.getProperty("login");
	        String chromeDriverPath = props.getProperty("chromedriver.path");
	        
	        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        
	        driver.get(login_page);
	        
	        driver.findElement(By.id("identifierId")).sendKeys(email);
	        Thread.sleep(3000);
	        
	        //next button
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/c-wiz/main/div[3]/div/div[1]/div/div/button/span")).click();
	       

	        //password
	        driver.findElement(By.className("whsOnd zHQkBf")).sendKeys(password);
	        Thread.sleep(5000);

	        //next
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/c-wiz/main/div[3]/div/div[1]/div/div/button/div[3]")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("Login Successful");
	        
	        driver.close();
      
	        
	 }
}
