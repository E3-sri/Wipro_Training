package day_5;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonItems 
{
	public static void main(String[] args)
				throws IOException, InterruptedException
		{
			Properties props = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\Amazon.txt");
	        props.load(fis);  
	        
	        
	        String phone = props.getProperty("phone");
	        String password=props.getProperty("password");
	        String chromeDiverPath=props.getProperty("chromedriver.path");
	        
	        String searchItem1 = props.getProperty("searchItem1"); 
	        
	        
	        System.setProperty("webdriver.chrome.driver", chromeDiverPath );
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	        
	        
	        driver.get("https://www.amazon.in");   
	        driver.findElement(By.id("nav-link-accountList")).click();
	        driver.findElement(By.id("ap_email_login")).sendKeys(phone);
	    
	        
	        driver.findElement(By.id("continue")).click();
	        
	        
	        driver.findElement(By.id("ap_password")).sendKeys(password);
	        
	        
	        driver.findElement(By.id("signInSubmit")).click();
	        
	        System.out.println("Login Successful!!!");
	        
	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	        searchBox.sendKeys(searchItem1);//searching for watches
	        
	        
	        driver.findElement(By.id("nav-search-submit-button")).click(); 
	        System.out.println("Searching for : "+searchItem1);
	        
	        
	        List<WebElement> products = driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a"));
	        if (products.size() > 0) {
	            products.get(0).click();
	        } 
	        else
	        {
	            System.out.println("No products found.");
	            driver.quit();
	            return;
	        }
	        
	        String parentWin = driver.getWindowHandle();
	        for (String winHandle : driver.getWindowHandles()) 
	        {
	            if (!winHandle.equals(parentWin))
	            {
	                driver.switchTo().window(winHandle);
	                break;
	            }
	        }
	     // 5. Add to cart
	        try {
	            WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
	            addToCartBtn.click();
	            System.out.println("Item added to cart.");
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Add to Cart button not found.");
	        }
	        
	        
	        //Go to cart
	        driver.findElement(By.id("nav-cart")).click();
	          
	        
	     // 7. Fetch cart item names
	        List<WebElement> cartItems = driver.findElements(By.cssSelector("span.a-truncate-cut"));
	        System.out.println("\nItems in cart:");
	        for (WebElement item : cartItems) {
	            System.out.println("- " + item.getText());
	        }

	        Thread.sleep(5000);
	        driver.quit();
	        
	       
	      
		}

	}
