package day_5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingAlerts 
{

	public static void main(String[] args)
	{
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://360homedecor.uk");
		
		driver.findElement(By.className("fa fa-user icon-user")).click();
		
		
		
		Alert alrt =driver.switchTo().alert();
		alrt.sendKeys("Hi Lakshmi");
		
		System.out.println(alrt.getText());
		
		alrt.accept();
		
		driver.quit();
		
	}
}
