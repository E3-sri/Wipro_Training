package day_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Automate_Edge {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = null;
        try {
            driver = new EdgeDriver(options);

            driver.get("https://www.geeksforgeeks.org/");
            System.out.println("Page Title: " + driver.getTitle());
        } finally {
            if (driver != null) driver.quit();
        }
    }
}
