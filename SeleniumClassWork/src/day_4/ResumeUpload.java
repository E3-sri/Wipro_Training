//Use Case: Resume Upload on a Job Application Website

package day_4;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResumeUpload
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chromedriver","C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
		try
		{
			//Open the target Page.
			driver.get("https://www.naukri.com/nlogin/login");
			
			
			driver.findElement(By.id("usernameField")).sendKeys("lakshmihymavathichaturvedula@gmail.com");
            driver.findElement(By.id("passwordField")).sendKeys("Hyma@2002");
            driver.findElement(By.xpath("//button[text()='Login']")).click();
            
            Thread.sleep(5000);
            
            driver.get("https://www.naukri.com/mnjuser/profile");
            
            Thread.sleep(5000);
  
			//File to Upload
			File Resume = new File("C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\resume.pdf");
			
			//WebElement uploadElement =driver.findElement(By.cssSelector("#attachCV")); //by id
			//WebElement uploadElement =driver.findElement(By.id("attachCV"));
			WebElement uploadElement=driver.findElement(By.cssSelector("input[id='attachCV']"));  //by attribute.

			uploadElement.sendKeys(Resume.getAbsolutePath());
			
			Thread.sleep(7000);
			
			System.out.println("Resume Upload Successfully!!!");
			
		}
		finally
		{
			driver.quit();
		}
	}
		
}
