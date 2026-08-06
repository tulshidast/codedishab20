package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Utilities;

public class HowToHandleTebularData {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get(Utilities.readProperty("url"));
		driver.manage().window().maximize();

		List<WebElement> allTableData = driver.findElements(By.cssSelector("table#table1 tbody tr td"));

		// allTableData.forEach(e -> System.out.println(e.getText()));

		for (WebElement elm : allTableData) {
			System.out.println(elm.getText());
		}

		System.out.println("#############################################################");
		allTableData.clear();

		allTableData = driver.findElements(By.cssSelector("table#table1 tbody tr:nth-of-type(3) td"));
		for (WebElement elm : allTableData) {
			System.out.println(elm.getText());
		}

		System.out.println("#############################################################");
		allTableData.clear();

		allTableData = driver.findElements(By.cssSelector("table#table1 tbody tr td:nth-of-type(3)"));
		for (WebElement elm : allTableData) {
			System.out.println(elm.getText());
		}

		System.out.println("#############################################################");
		WebElement cellData = driver
				.findElement(By.cssSelector("table#table1 tbody tr:nth-of-type(2) td:nth-of-type(1)"));
		System.out.println(cellData.getText());

	}

}
