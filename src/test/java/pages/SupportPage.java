package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportPage extends BasePage {

	public SupportPage(WebDriver driver) {
		super(driver);
	}

	// Add methods specific to the Support page here
	@FindBy(css = "img[src='images/home.gif']")
	WebElement backToHomeButton;

	/**
	 * Clicks the "Back to Home" button on the Support page.
	 */
	public void clickBackToHome() {
		backToHomeButton.click();
	}

}
