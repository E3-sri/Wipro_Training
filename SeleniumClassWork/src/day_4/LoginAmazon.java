package day_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAmazon
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\my.properties");
        props.load(fis);
        
        
        String email = props.getProperty("Amazon.email");
        String pwd = props.getProperty("Amazon.password");
        String loginPage=props.getProperty("login.page");
        String chromeDriverPath = props.getProperty("chromedriver.path");
        
        
        //creating web driver
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Obtaining login path
        driver.get(loginPage);
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap-password")).sendKeys(pwd);
        driver.findElement(By.xpath("//*[@id='continue])")).click();
        Thread.sleep(5000);

        
        System.out.println("Amazon login Successful!!!");
        Thread.sleep(5000);
        driver.quit();

		
	}
}
