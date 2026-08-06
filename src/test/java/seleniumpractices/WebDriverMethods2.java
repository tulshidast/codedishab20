package seleniumpractices;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.id("ta1"));// NoSuchElementException: no such element: Unable
		// to locate element:
		// {"method":"id","selector":"ta1"}
		textAreaField.sendKeys("Welcome to codedisha");

		List<WebElement> buttons = driver.findElements(By.tagName("xyz"));
		for (WebElement b : buttons) {
			System.out.println("Button Text: " + b.getText());
		}
		
		System.out.println("Number of buttons found: " + buttons.size());

		// Get the window handle of the current focused window
		String parentWindowHandle = driver.getWindowHandle();

		System.out.println("Parent Window Handle: " + parentWindowHandle);

		driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB).navigate().to("https://www.flipkart.com/");

		// Get the window handles return set of all the open windows handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			System.out.println("Window Handle: " + windowHandle);
		}

		driver.close(); // Close the current window (Flipkart)

		driver.quit(); // Close all windows and end the WebDriver session

	}

}
