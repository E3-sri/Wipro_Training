package day_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseEraLogin 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumSample\\src\\day_4\\My_files\\courseera.properties");
		prop.load(fis);
		
		String email=prop.getProperty("courseera.mail");
		String password=prop.getProperty("courseera.password");
		String login_page=prop.getProperty("login.page");
		//String search_Course=prop.getProperty("se")
		String chromeDriverPath=prop.getProperty("chromedriver.path");
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		//creating driver to connect with chrome driver.
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//obtain login page.
		
		driver.get(login_page);
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
	
		driver.findElement(By.className("css-1v3dqbl")).click();
		
		Thread.sleep(15000);
		System.out.println("Login Successful!!!");
		
		
//		// Wait for redirect after login
//		new WebDriverWait(driver, Duration.ofSeconds(15))
//		        .until(ExpectedConditions.urlContains("coursera.org"));
//
//		// Wait for search bar
//		new WebDriverWait(driver, Duration.ofSeconds(15))
//		        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='What do you want to learn?']")));
//
//		// Type Java in search bar
//		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("Java");
//
//		// Click Search
//		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
//
//		// Wait for results and click course
//		new WebDriverWait(driver, Duration.ofSeconds(15))
//		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Core Java')]"))).click();
//
//		// Click Enroll
//		new WebDriverWait(driver, Duration.ofSeconds(15))
//		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Enroll')]"))).click();

		
		//Search for java
		
		//driver.findElement(By.id("search-autocomplete-input")).sendKeys(search);;
		
		//driver.findElement(By.name("query")).sendKeys("Java");
		
		//to click on search
		//driver.findElement(By.xpath("//*[@id=\'rendered-content\']/div/div/span/div[1]/header/div[1]/div/div[2]/div/div/div/div/div/div[3]/div/div[2]/form/div/button[2]/div")).click();
		
		//to select a particular course
		
		//driver.findElement(By.xpath("//h2[contains(text(),'Core Java')]")).click();
		

		//Thread.sleep(3000);// to wait for sometime.
		
		
		//driver.findElement(By.xpath("//button[contains(text(),'Enroll')]")).click();

		//System.out.println("Congratulations,  Enrolled!!!");

		//driver.get("://www.coursera.org/search?query=Java");//search for java
		
		//driver.findElement(By.className("cds-119 cds-113 cds-115 cds-CommonCard-titleLink css-vflzcf cds-142")).click();//click on java
		
		//driver.findElement(By.className("cds-160 cds-button-disableElevation cds-button-primary css-1hpmqrq"));  //enroll
		
		driver.quit();

	}
}
