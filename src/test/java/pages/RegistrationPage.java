package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Add methods to interact with the registration page elements here
	@FindBy(css = "select[name='country']")
	WebElement countryDropdown;

	public List<String> getAllOtionsFromCountryDropdown() {

		return utillities.FrameworkUtil.getAllDropdownOptions(countryDropdown);
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

}
