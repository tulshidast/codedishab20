package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// webdriver initialization
		driver = DriverFactory.getInstance().getDriver();
		driver.get(utillities.FrameworkUtil.readProperty("newToursUrl"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.getInstance().quitDriver();
	}

}
