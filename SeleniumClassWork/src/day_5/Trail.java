package day_5;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;

public class Trail
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//get web page.
		//driver.get("https://www.google.com");
		
		
		//getTitle()
//	    String Page_Title = driver.getTitle();
//	    driver.get("https://www.google.com");
//		System.out.println("Page Title: "+Page_Title);
		
//		String expected_url="https://www.google.com/";
//		String actual_url=driver.getCurrentUrl();
//		
//		if(expected_url.equals(actual_url))
//		{
//			System.out.println("Navigation Successful! "+ actual_url);
//		}
//		else
//		{
//			System.out.println("Unexpected URL: "+actual_url);
//		}
		
		//using navigate to get page.
//		
//		driver.navigate().to("https://www.google.com/");
//		Thread.sleep(2000);
//		
//		System.out.println("Naviagated to google web page.");
		
		// To navigate ,back,forward from current page.
		
//		driver.navigate().to("https://www.google.com/");
//		Thread.sleep(2000);
//		System.out.println("navigated to site");
//
//		driver.navigate().back();
//		Thread.sleep(2000);
//		System.out.println("navigated back!!!");
//
//		driver.navigate().forward();
//		Thread.sleep(2000);
//		System.out.println("navigated forward!!!");
//		
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		System.out.println("Page Refreshed!!!");

		
		//Orientation
		
			driver.get("https://www.selenium.dev/");
	        PrintOptions printOptions = new PrintOptions();
	        
	        //for PORTRAIT
	        printOptions.setOrientation(PrintOptions.Orientation.PORTRAIT);
	       // PrintOptions.Orientation current_orientation = printOptions.getOrientation();
	        Thread.sleep(2000);
	       // System.out.println("Orientation is 'PORTRAIT'"+current_orientation);
	        
	        //Using LANDSCAPE
	        
//	        printOptions.setOrientation(PrintOptions.Orientation.LANDSCAPE);
//	        PrintOptions.Orientation current_orientation = printOptions.getOrientation();
//	        Thread.sleep(2000);
//	        System.out.println("Orientation is: "+current_orientation);
	        
	        //Trying to print range
	        
//	        printOptions.setPageRanges("1-2,4-5");
//	        String[] current_range = printOptions.getPageRanges();
//	        
//	        System.out.println(Arrays.toString(current_range));
//	        
//	        //To set the page size and print it.
//	        
//	        printOptions.setPageSize(new PageSize(30.02, 21.59)); // A4 size in cm
//	        double currentHeight = printOptions.getPageSize().getHeight();
//	        
//	        System.out.println(currentHeight);
	        
	        
	        driver.quit();
		
		
		
	}
}
