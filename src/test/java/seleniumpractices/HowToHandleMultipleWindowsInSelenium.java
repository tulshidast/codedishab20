package seleniumpractices;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToHandleMultipleWindowsInSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement textField = driver.findElement(By.cssSelector("#ta1"));
		textField.sendKeys("Hello World");

		driver.findElement(By.cssSelector("#selenium143")).click();

		String parentWindowHandle = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {

			if (!windowHandle.equals(parentWindowHandle)) {

				driver.switchTo().window(windowHandle);
				break;
			}

		}

		driver.findElement(By.xpath("//a[text()='What is Selenium?']")).click();

		driver.close();

		driver.switchTo().window(parentWindowHandle);

		textField.clear();

		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
		

		allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {

			if (!windowHandle.equals(parentWindowHandle)) {

				driver.switchTo().window(windowHandle);
				break;
			}

		}

		String textFromNewWindow = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println(("Text from new window: " + textFromNewWindow));
		
		driver.close();
		
		driver.switchTo().window(parentWindowHandle);

		driver.quit();

	}

}
