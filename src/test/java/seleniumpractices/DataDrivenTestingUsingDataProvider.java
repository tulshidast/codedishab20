package seleniumpractices;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingUsingDataProvider {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "dataProvider")
	public void userLogin(String uname, String password, String loginSuMsg) {

		driver.findElement(By.cssSelector("input[name='userName']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[name='submit']")).click();

		String loginSuccessMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();

		assertEquals(loginSuccessMsg, loginSuMsg, "User unable to login");

	}

	@DataProvider(name = "dataProvider")
	public String[][] userData() {

		String[][] udata = { { "admin", "admin@123", "Login Successfully" },
				{ "user", "user@123", "Login Successfully" }, { "suser", "suser@123", "Login Successfully" } };
		return udata;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
