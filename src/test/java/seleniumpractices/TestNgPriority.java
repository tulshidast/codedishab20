package seleniumpractices;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgPriority {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		System.out.println("Before method");
	}

	@Test(priority = 1)
	public void b() {
		WebElement pageOneLink = driver.findElement(By.linkText("Page One"));
		assertTrue(pageOneLink.isEnabled(), "Link is not enabled");
		System.out.println("Verify home page title");
	}

	@Test(priority = 2)
	public void a() {
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://omayo.blogspot.com/", "Url not matched");
		System.out.println("Verify home page title test case");
	}

	@Test(priority = -3)
	public void d() {
		String title = driver.getTitle();
		assertEquals(title, "omayo (QAFox.com)", "Title not matched");
		System.out.println("Verify home page title");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		driver.quit();
	}

}
