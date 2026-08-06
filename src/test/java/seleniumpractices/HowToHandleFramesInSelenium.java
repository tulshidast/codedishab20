package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HowToHandleFramesInSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// driver.switchTo().frame(0);

		// driver.switchTo().frame("navbar-iframe");

		driver.switchTo().frame(driver.findElement(By.id("navbar-iframe")));

		WebElement moreOptionsDropdown = driver.findElement(By.cssSelector("select[aria-label='More options']"));

		Select select = new Select(moreOptionsDropdown);

		select.selectByVisibleText("Share by email");

		driver.switchTo().defaultContent();

		driver.findElement(By.cssSelector("#ta1")).sendKeys("Hello");

	}

}
