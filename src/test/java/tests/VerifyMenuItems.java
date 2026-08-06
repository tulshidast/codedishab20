package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyMenuItems extends BaseTest {

	// Implement test methods to verify menu items here
	@Test
	public void testVerifyMenuItems() {
		// Implement the test logic to verify menu items
		// For example, you can create an instance of HomePage and call its methods
		driver.navigate().to(utillities.FrameworkUtil.readProperty("url"));
		HomePage homePage = new pages.HomePage(driver);
		homePage.hoverOnBlogs();
		utillities.FrameworkUtil.waitForElementToBeVisible(driver, homePage.getBlogMenuItems());

		for (WebElement menuItem : homePage.getBlogMenuItems()) {
			assertEquals(menuItem.isDisplayed(), true, "Menu item is not displayed: " + menuItem.getText());
		}

		System.out.println("Menu item texts: " + homePage.getBlogMenuItemTexts());

		List<String> expectedList = List.of("Selenium143", "SeleniumByArun", "SeleniumOneByArun", "SeleniumTwoByArun");

		assertEquals(homePage.getBlogMenuItemTexts(), expectedList, "Mismatch in menu item texts");

	}

}
