package day_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLogin 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\flipkart.txt");
        props.load(fis);
        
        
       // String Phone = props.getProperty("Flipkart.phone");
        String loginPage=props.getProperty("Flipkart.login");
        String chromeDriverPath = props.getProperty("chromedriver.path");
        
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        driver.get(loginPage); 
        driver.findElement(By.id("container"));
        //driver.findElement(By.className("r4vIwl mYpCuj BV+Dqf"));//phone
        //driver.findElement(By.className("QqFHMw twnTnD _7Pd1Fp")).click();//Request OTP
 
        Thread.sleep(5000);
        

	     System.out.println("Login Successful!!!");
	     Thread.sleep(5000);
	     driver.quit();

        
	}
}
