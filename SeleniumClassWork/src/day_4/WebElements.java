package day_4;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chromedriver","C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
		try
		{
			//Open the target Page.
			driver.get("http://the-internet.herokuapp.com//upload");
			
			//File to Upload
			File uploadFile = new File("C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\Knowledge is Strength Contest (ebook).pdf");
			
			WebElement fileInput =driver.findElement(By.cssSelector("input[type='file']"));
			
			fileInput.sendKeys(uploadFile.getAbsolutePath());
			
			driver.findElement(By.id("file-submit")).click();
		
			
			String resultText =driver.findElement(By.id("uploaded-files")).getText();
			
			System.out.println("Uploaded: "+resultText);
		}
		finally
		{
			driver.quit();
		};
	}
}
