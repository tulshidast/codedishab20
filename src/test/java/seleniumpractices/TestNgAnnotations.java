package seleniumpractices;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test plan");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		System.out.println("Before method");
	}

	@Test
	public void verifyHomePageUrl() {
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://omayo.blogspot.com/", "Url not matched");
		System.out.println("Verify home page title test case");
	}

	@Test
	public void verifyHomePageTitle() {
		String title = driver.getTitle();
		assertEquals(title, "omayo (QAFox.com)", "Title not matched");
		System.out.println("Verify home page title");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}

	@AfterTest
	public void afterTestPlan() {
		System.out.println("After test plan");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}

}
