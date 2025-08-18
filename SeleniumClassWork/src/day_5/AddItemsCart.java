package day_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemsCart
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\flipkart.txt");
        props.load(fis);   
        
        String email=props.getProperty("email");
        
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\hp\\\\OneDrive\\\\Desktop\\\\Selenium Web Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //flipkart login
        driver.get("https://www.flipkart.com/account/login?ret=/");
        
        
        //email
        driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys(email);
        Thread.sleep(2000);
        //OTP
        driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(20000);
        
        //Verify
        
        
        
        
        System.out.println("Login Successful");
        
        
        try {
            WebElement closeBtn = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeBtn.click();
        } 
        catch (Exception e)
        {
            System.out.println("No login popup displayed.");
        }
        
        // 1. Search for Jewellery
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("jewellery", Keys.ENTER);
        
     // 2. Click on the first product from search results
        List<WebElement> products = driver.findElements(By.cssSelector("a.IRpwTa")); // product links
        if (products.size() > 0) 
        {
            products.get(0).click(); // open the first jewellery item
        }
        
        // Switch to new tab (Flipkart opens product in a new tab)
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 3. Click "Add to Cart"
        try {
            WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
            addToCartBtn.click();
           
            System.out.println("Item added to cart.");
        } catch (Exception e) {
            System.out.println("Add to cart button not found.");
        }

        // 4. Open cart and show items
        WebElement cartBtn = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        cartBtn.click();

        // Fetch cart item names
        List<WebElement> cartItems = driver.findElements(By.cssSelector("a._2Kn22P"));
        System.out.println("Items in cart:");
        for (WebElement item : cartItems) {
            System.out.println("- " + item.getText());
        }

        // Close browser
        Thread.sleep(3000);
        
        
        driver.quit();

	}
}
