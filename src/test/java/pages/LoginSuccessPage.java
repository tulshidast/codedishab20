package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSuccessPage extends BasePage {

	public LoginSuccessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h3[text()='Login Successfully']")
	WebElement loginSuccessMessage;

	public String getLoginSuccessMessage() {
		return loginSuccessMessage.getText();
	}

}
