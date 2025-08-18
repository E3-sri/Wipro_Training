package day_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMultipleItems 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\flipkart.txt");
        props.load(fis);

        String email = props.getProperty("email");

        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\hp\\\\OneDrive\\\\Desktop\\\\Selenium Web Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Flipkart login
        driver.get("https://www.flipkart.com/account/login?ret=/");

        // phonenumber
        driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys(email);
        Thread.sleep(2000);

        // OTP button
        driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(20000); // Wait for manual OTP entry
        
        //verify
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/form/button")).click();


        System.out.println("Login Successful");

        try {
            WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
            addToCartBtn.click();
           
            System.out.println("Item added to cart.");
        } catch (Exception e) {
            System.out.println("Add to cart button not found.");
        }

        // List of items to add
        List<String> searchItems = new ArrayList<>();
        searchItems.add("Ladies Watches");
        searchItems.add("Ladies shoes");
        
        String mainWindow = driver.getWindowHandle();

        for (String item : searchItems) {
            // 1. Search item
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(item, Keys.ENTER);
            Thread.sleep(2000);

            // 2. Click first product
            List<WebElement> products = driver.findElements(By.cssSelector("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[2]/div/a/div[1]/div/div/div/img")); // Flipkart uses multiple classes
            if (products.size() > 0) {
                products.get(0).click();// open the second item
                products.get(1).click();// open the second item
            } else {
                System.out.println("No products found for: " + item);
                continue;
            }

            // 3. Switch to new tab
            for (String winHandle : driver.getWindowHandles())
            {
                if (!winHandle.equals(mainWindow)) 
                {
                    driver.switchTo().window(winHandle);
                }
            }

            // 4. Add to cart
            try {
                WebElement addToCartBtn = driver
                        .findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
                addToCartBtn.click();
                System.out.println(item + " added to cart.");
            } 
            catch (Exception e) 
            {
                System.out.println("Add to cart button not found for " + item);
            }
            driver.close();
            driver.switchTo().window(mainWindow);
        }
        
        // Fetch cart item names
        List<WebElement> cartItems = driver.findElements(By.cssSelector("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[2]/div/div[2]/div/a/div[1]/div/div/div/img"));
        System.out.println("\nItems in cart:");
        for (WebElement cartItem : cartItems) {
            System.out.println("- " + cartItem.getText());
        }

        Thread.sleep(5000);
        driver.quit();
        driver.close();
            
            

        
        
	}

}
