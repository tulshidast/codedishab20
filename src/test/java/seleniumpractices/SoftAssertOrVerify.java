package seleniumpractices;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.Utilities;

public class SoftAssertOrVerify {

	WebDriver driver;
	SoftAssert verify;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		verify = new SoftAssert();
	}

	@Test
	public void verifyHomePageDetails() {

		List<String> expectedOptions = Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4");
		List<String> actualOptions = Utilities.getAllDropdownOptions(driver.findElement(By.cssSelector("#drop1")));

		verify.assertEquals(actualOptions, expectedOptions);
		verify.assertEquals(actualOptions, expectedOptions, "Dropdown not having expected options");

		verify.assertTrue(actualOptions.containsAll(expectedOptions));
		verify.assertTrue(actualOptions.containsAll(expectedOptions), "Dropdown not having expecte options");

		WebElement textField = driver.findElement(By.cssSelector("#ta1"));

		verify.assertTrue(textField.isDisplayed(), "text field is not displayed");

		System.out.println("Code after assertion failed");

		verify.assertFalse(!(textField.isDisplayed()), "Text field is not displayed");

		verify.assertNotEquals(actualOptions,
				Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4", "doc 5"));

		verify.assertNotEquals(actualOptions,
				Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4", "doc 5"), "List are equals");
		WebElement dropdownBtn = driver.findElement(By.cssSelector("button.dropbtn"));
		String str = dropdownBtn.getCssValue("background-color");
		System.out.println(str);

		assertEquals(str, "rgba(76, 175, 80, 1)", "Background color is not as expected");

		assertFalse(driver.findElement(By.cssSelector("#checkbox2")).isSelected(), "Blue checkbox is selected");

		verify.assertAll();

	}

}
