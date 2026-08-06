package seleniumpractices;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.Utilities;

public class HardAssertOrAssert {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyHomePageDetails() {

		List<String> expectedOptions = Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4");
		List<String> actualOptions = Utilities.getAllDropdownOptions(driver.findElement(By.cssSelector("#drop1")));

		assertEquals(actualOptions, expectedOptions);
		assertEquals(actualOptions, expectedOptions, "Dropdown not having expected options");

		assertTrue(actualOptions.containsAll(expectedOptions));
		assertTrue(actualOptions.containsAll(expectedOptions), "Dropdown not having expecte options");

		WebElement textField = driver.findElement(By.cssSelector("#ta1"));

		assertTrue(textField.isDisplayed(), "text field is not displayed");

		System.out.println("Code after assertion failed");

		assertFalse(!(textField.isDisplayed()), "Text field is not displayed");

		assertNotEquals(actualOptions, Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4", "doc 5"));

		assertNotEquals(actualOptions, Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4", "doc 5"),
				"List are equals");

	}

}
