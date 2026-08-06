package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvancedActionsInSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		WebElement googleAppsLogo = driver.findElement(By.cssSelector("a[aria-label='Google apps']"));

		Actions actions = new Actions(driver);

		// actions.moveToElement(googleAppsLogo).build().perform();

		// actions.contextClick(googleAppsLogo).build().perform(); // Right click on the
		// element

		// actions.doubleClick(googleAppsLogo).build().perform(); // Double click on the
		// element

		WebElement searchTextField = driver.findElement(By.cssSelector("textarea[name='q']"));

		// actions.click(searchTextField);

		actions.keyDown(searchTextField, "a").keyUp(searchTextField, "a").keyDown(searchTextField, Keys.SHIFT)
				.keyDown(searchTextField, "p").keyUp(searchTextField, Keys.SHIFT).keyUp(searchTextField, "p").build()
				.perform(); // Press
		// and
		// release
		// the
		// 'a'
		// key
		// on
		// the
		// search
		// text
		// field

	}

}
