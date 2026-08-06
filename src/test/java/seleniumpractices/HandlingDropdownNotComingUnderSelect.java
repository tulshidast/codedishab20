package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDropdownNotComingUnderSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		selectOptionFromDropdown("Facebook");

		System.out.println("Facebook option is selected from dropdown = " + driver.getTitle());

		driver.navigate().back();

		selectOptionFromDropdown("Gmail");

		System.out.println("Gmail option is selected from dropdown = " + driver.getTitle());

		driver.navigate().back();

		selectOptionFromDropdown("flipkart");

		System.out.println("Flipkart option is selected from dropdown = " + driver.getTitle());

	}

	public static void selectOptionFromDropdown(String option) throws InterruptedException {

		driver.findElement(By.cssSelector("button.dropbtn")).click();

		Thread.sleep(4000);

		List<WebElement> allOptionsFromDropdown = driver.findElements(By.cssSelector("#myDropdown a"));

		for (WebElement opt : allOptionsFromDropdown) {
			if (opt.getText().equalsIgnoreCase(option)) {
				opt.click();
				break;
			}
		}
	}

}
