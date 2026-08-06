package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorStrategiesInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		

		// Using name locator strategy to locate the search box and enter text
		WebElement searchTextField = driver.findElement(By.name("q"));
		searchTextField.sendKeys("Codedisha");
		Thread.sleep(2000); // Wait for 2 seconds to see the entered text
		searchTextField.clear();

		// Using class name locator strategy to locate the heading and get its text
		WebElement heading2 = driver.findElement(By.className("title"));
		String headingText = heading2.getText();
		System.out.println("Heading text: " + headingText);

		// Using id locator strategy to locate the male radio button
		WebElement maleRadioButton = driver.findElement(By.id("radio1"));
		maleRadioButton.click();

		// Using tagname locator strategy to locate the images and print their count
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of images on the page: " + images.size());

		// Using link text locator strategy to locate the link and click it
		WebElement pageOneLink = driver.findElement(By.linkText("Page One"));
		String url = pageOneLink.getAttribute("href");
		System.out.println("URL of Page One link: " + url);

		// Using partial link text locator strategy to locate the link and click it
		WebElement commentsLink = driver.findElement(By.partialLinkText(" (Atom)"));
		commentsLink.click();
		

	}

}
