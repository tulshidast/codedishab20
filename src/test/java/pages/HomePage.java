package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Add methods to interact with the home page elements here
	@FindBy(xpath = "//span[@id='blogsmenu']/..")
	WebElement blogs;

	@FindBy(css = "div#cssmenu ul ul li a")
	List<WebElement> blogMenuItem;

	/**
	 * Hovers over the "Blogs" menu item on the home page.
	 */
	public void hoverOnBlogs() {
		utillities.FrameworkUtil.hoverOnElement(driver, blogs);
	}

	public List<WebElement> getBlogMenuItems() {
		return blogMenuItem;
	}

	public List<String> getBlogMenuItemTexts() {
		return utillities.FrameworkUtil.getElementsText(blogMenuItem);
	}

}
