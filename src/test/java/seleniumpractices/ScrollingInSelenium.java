package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 300)");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0, -200)");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(100, 0)");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(-100, 0)");

		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(2000);

		js.executeScript("window.scrollTo(document.body.scrollWidth, 0)");

		Thread.sleep(2000);

		js.executeScript("window.scrollTo(document.body.scrollWidth, document.body.scrollHeight)");

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.cssSelector("input#checkbox2"));

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);

		js.executeScript("arguments[0].click();", element);

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("button.dropbtn")));

		String bgColor = driver.findElement(By.cssSelector("button.dropbtn")).getCssValue("background-color");

		System.out.println("Background color of the button is: " + bgColor);

	}

}
