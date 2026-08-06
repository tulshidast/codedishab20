package seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectOptFromDropdown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

		driver.manage().window().maximize();

		selectState("NCR");

		selectState("Uttar Pradesh");

		selectCity("Agra");

	}

	public static void selectState(String state) {

		// Locating the element
		WebElement element = driver.findElement(By.cssSelector("input#react-select-3-input"));

		// Executing scroll script
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element); //

		element.sendKeys(state);

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.TAB).build().perform();
	}

	public static void selectCity(String city) {

		// Locating the element
		WebElement element = driver.findElement(By.cssSelector("input#react-select-4-input"));

		// Executing scroll script
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element); //

		element.sendKeys(city);

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.TAB).build().perform();
	}

}
