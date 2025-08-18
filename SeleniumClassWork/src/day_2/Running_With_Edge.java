package day_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.File;


public class Running_With_Edge{
    public static void main(String[] args)
    {
        
        String driverPath = "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\edgedriver_win64\\msedgedriver.exe"; // <<< update this to where you put msedgedriver.exe

       
        File f = new File(driverPath);
        if (!f.exists()) {
            System.err.println("EdgeDriver not found at: " + driverPath);
            return;
        }


        
        System.setProperty("webdriver.edge.driver", driverPath);

     
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = null;
        try 
        {
            driver = new EdgeDriver(options);

         
            driver.get("https://www.geeksforgeeks.org/");
            System.out.println("Page Title: " + driver.getTitle());
        } 
        finally 
        {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}