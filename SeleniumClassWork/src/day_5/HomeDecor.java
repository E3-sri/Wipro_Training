package day_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeDecor 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		Properties props=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\Downloads\\homedecor.txt");
		props.load(fis);
		
		String type=props.getProperty("type");
		String FirstName=props.getProperty("FirstName");
		String LastName=props.getProperty("Surname");
		String City=props.getProperty("City");
		String Phone=props.getProperty("phone");
		String email=props.getProperty("email");
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\hp\\\\OneDrive\\\\Desktop\\\\Selenium Web Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        
		//Go to website.
		driver.get("https://360homedecor.uk/home");
		System.out.println("opened website");
		Thread.sleep(2000);
		
		// Scroll down until "Book a Free Consultation" 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement bookBtn = driver.findElement(By.xpath("//a[contains(text(),'Book a Free Consultation')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", bookBtn);
		Thread.sleep(2000);

		// Click the button
		bookBtn.click();
		System.out.println("Clicked on Book a Free Consultation");
		
		//Select Style
		driver.findElement(By.className("card-img-top")).click();
		Thread.sleep(2000);
		System.out.println("Style is choosen");
		
		String parentWindow = driver.getWindowHandle();
		
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows)
        {
            if (!window.equals(parentWindow))
            {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.id("chooseMethod")).sendKeys(type);
        Thread.sleep(1000);
        System.out.println("Choosen Type.");
        driver.findElement(By.name("firstName")).sendKeys(FirstName);
        System.out.println("Taken First name");
        Thread.sleep(1000);
        driver.findElement(By.name("lastName")).sendKeys(LastName);
        System.out.println("Taken Last name");
        Thread.sleep(1000);

        driver.findElement(By.name("city")).sendKeys(City);
        System.out.println("Taken City");
        Thread.sleep(1000);

        driver.findElement(By.id("phoneNumber")).sendKeys(Phone);
        System.out.println("Taken phone number");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys(email);
        System.out.println("Taken mail id");
        Thread.sleep(1000);

        //Checkbox
        boolean isSelected=driver.findElement(By.id("privacyPolicy")).isSelected();
        if(isSelected=true)
        {
        System.out.println("Terms & Policies is checked "+isSelected);
        }
        else {
        	System.out.println("Not Checked"+isSelected);
        }
        // Submit
        driver.findElement(By.xpath("//*[@id=\"consultation_form\"]/button")).click();
        Thread.sleep(1000);
        System.out.println("Consultation BOOKED");


        driver.quit();

	}
}
