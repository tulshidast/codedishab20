package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectionDropdwonCommingUnderSelect {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement dropDown = driver.findElement(By.cssSelector("select#multiselect1"));

		Select select = new Select(dropDown);

		select.selectByContainsVisibleText("Vo");

		Thread.sleep(2000);

		select.selectByIndex(1);

		Thread.sleep(2000);

		select.selectByValue("Hyundaix");

		Thread.sleep(2000);

		select.selectByVisibleText("Audi");

		// All selected options belonging to this select tag
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

		for (WebElement option : allSelectedOptions) {
			System.out.println("Selected option: " + option.getText());
		}

		// The first selected option in this select tag (or the currently selected
		// option in a normal select)
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("First selected option: " + firstSelectedOption.getText());

		// All options belonging to this select tag
		List<WebElement> allOptions = select.getOptions();

		for (WebElement option : allOptions) {
			System.out.println("Option: " + option.getText());
		}

		// Whether this select element support selecting multiple options at the same
		// time? This is done by checking the value of the "multiple" attribute.
		boolean b = select.isMultiple();
		System.out.println("Is multiple selection allowed: " + b);

		select.deselectAll();

		Thread.sleep(2000);

		select.selectByContainsVisibleText("Vo");

		Thread.sleep(2000);

		select.selectByIndex(1);

		Thread.sleep(2000);

		select.selectByValue("Hyundaix");

		Thread.sleep(2000);

		select.selectByVisibleText("Audi");

		select.deSelectByContainsVisibleText("Vo");

		Thread.sleep(2000);

		select.deselectByIndex(1);

		Thread.sleep(2000);

		select.deselectByValue("Hyundaix");

		Thread.sleep(2000);

		select.deselectByVisibleText("Audi");

	}

}
