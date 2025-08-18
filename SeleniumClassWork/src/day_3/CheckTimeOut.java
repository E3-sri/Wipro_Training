//timeouts
/*A WebDriver session is imposed with a certain session timeout interval, 
 * during which the user can control the behaviour of executing scripts 
 * or retrieving information from the browser.
Each session timeout is configured with combination of different 
timeouts as described below:
*/

package day_3;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.chrome.ChromeOptions;

public class CheckTimeOut 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Web Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions chromeOptions = getDefaultChromeOptions();
		Duration duration = Duration.of(5, ChronoUnit.SECONDS);
		chromeOptions.setScriptTimeout(duration);
		
		
	}

	public static ChromeOptions getDefaultChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return options;
	}
}
