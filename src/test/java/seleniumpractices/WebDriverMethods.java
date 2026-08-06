package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// Load a new web page in the current browser window
		driver.get("https://omayo.blogspot.com/");

		// Get a string representing the current URL that the browser is looking at.
		String url = driver.getCurrentUrl();
		System.out.println("Current URL: " + url);

		// The title of the current page
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		// Get the source of the last loaded page.
		String pageSource = driver.getPageSource();
		System.out.println("Page Source: " + pageSource);

		driver.navigate().to("https://www.flipkart.com/");

		Thread.sleep(4000);
		
		driver.navigate().to("https://www.amazon.in/");
		
		Thread.sleep(4000);
		
		driver.navigate().back();

		Thread.sleep(4000);

		driver.navigate().forward();

		Thread.sleep(4000);

		driver.navigate().refresh();
		
		Thread.sleep(4000);

		// Quits this driver, closing every associated window.
		//driver.quit();

	}

}
