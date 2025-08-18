package day_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookAppointment 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Properties props=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\Downloads\\homedecor.txt");
		props.load(fis);
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\hp\\\\OneDrive\\\\Desktop\\\\Selenium Web Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        
		//Go to website.
		driver.get("https://360homedecor.uk/home");
		System.out.println("opened website");
		Thread.sleep(2000);
		
		// Scroll down until "Book for an Appointment" 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement bookBtn = driver.findElement(By.xpath("//a[contains(text(),'Book Appointment')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", bookBtn);
		Thread.sleep(2000);

		// Click the button
		bookBtn.click();
		System.out.println("Clicked on Book Appointment");
		
		
		//select brand from dropdown
		
		
		WebElement dropdownElement1 = driver.findElement(By.id("dropdownId"));
	    Select dropdown1 = new Select(dropdownElement1);
	    
	    
	    List<WebElement> options1 = dropdown1.getOptions();
        System.out.println("Available options:");
        
        for (WebElement option : options1)
        {
            System.out.println(option.getText());
        }
        //to select by the text.
        dropdown1.selectByVisibleText("Option 2");
        
        System.out.println("First dropdown option is choosen.");
        
        
        WebElement dropdownElement2= driver.findElement(By.id("dropdownId"));
	    Select dropdown2= new Select(dropdownElement2);
	    
	    
	    List<WebElement> options2 = dropdown1.getOptions();
        System.out.println("Available options:");
        
        for (WebElement options : options2)
        {
            System.out.println(options.getText());
        }
        
        //To select by index.
        dropdown2.selectByIndex(2);
        
        System.out.println("First dropdown option is choosen.");

        
        //To fill the details.
        
		String FirstName=props.getProperty("FirstName");
		String LastName=props.getProperty("LastName");
		String City=props.getProperty("City");
		String Phone=props.getProperty("phone");
		String email=props.getProperty("email");
		
		
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
        
        WebElement checkbox= driver.findElement(By.id("privacyPolicy"));
        boolean result=checkbox.isSelected();
        if(result==true)
        {
        	
        	System.out.println("Privacy policy is accepted. "+result);
        	
        }
        else
        {
        	System.out.println("Privacy policy is not accepted. "+result);
        	checkbox.click();

        }
        //Book Appointment
        
        driver.findElement(By.xpath("//*[@id='appointment_form']/div[10]/button")).click();
        Thread.sleep(1000);
        System.out.println("Appointment is booked!!!");
        driver.quit();
		
	}
}
