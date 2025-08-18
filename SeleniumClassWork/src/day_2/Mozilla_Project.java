// Manual (explicit driver path)
	package day_2;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;

	import java.io.File;

	public class Mozilla_Project {
	    public static void main(String[] args) {
	        String driverPath = "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\geckodriver.exe"; // <<< update this

	        File f = new File(driverPath);
	        if (!f.exists()) {
	            System.err.println("GeckoDriver not found at: " + driverPath);
	            return;
	        }

	        System.setProperty("webdriver.gecko.driver", driverPath);

	        FirefoxOptions options = new FirefoxOptions();
	        options.setAcceptInsecureCerts(true);

	        WebDriver driver = null;
	        try {
	            driver = new FirefoxDriver(options);

	            driver.get("https://www.geeksforgeeks.org/");
	            System.out.println("Page Title: " + driver.getTitle());
	        } finally {
	            if (driver != null) driver.quit();
	        }
	    }
	}

