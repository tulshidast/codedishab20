package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LoginSuccessPage;

public class LoginTest extends BaseTest {

	@Test(groups = { "smoke",
			"regression" }, description = "Verify that user can login successfully with valid credentials")
	public void testLogin() {

		LoginPage loginPage = new LoginPage(driver);
		LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);

		loginPage.login("Admin", "admin@123");
		String actualLoginSuccessMsg = loginSuccessPage.getLoginSuccessMessage();
		assertEquals(actualLoginSuccessMsg, "Login Successfully",
				"Login success message does not match expected value");

	}

}
