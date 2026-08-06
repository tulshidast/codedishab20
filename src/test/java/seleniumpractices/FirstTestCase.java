package seleniumpractices;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestCase {

	@Test
	public void verifyHomePageTitle() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://omayo.blogspot.com/");

		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, "omayo (QAFox.com)", "Title is not matching");

		driver.quit();

	}

}
