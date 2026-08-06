package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[name='userName']")
	WebElement usernameInput;

	@FindBy(name = "password")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//a[text()='REGISTER']")
	WebElement registerLink;

	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submitBtn.click();
	}

	/**
	 * Clicks on the "REGISTER" link on the login page.
	 */
	public void clickRegisterLink() {
		registerLink.click();
	}

}
