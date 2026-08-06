package seleniumpractices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingCalenderControl {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/datepicker/#localization");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		HandlingCalenderControl.selectFutureDateAndLocal("English", "August", "2026", "16");
		Thread.sleep(3000);
		HandlingCalenderControl.selectPastDateAndLocal("English", "June", "2026", "26");

	}

	public static void selectFutureDateAndLocal(String local, String month, String year, String date) {

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		Select select = new Select(driver.findElement(By.cssSelector("select#locale")));
		select.selectByVisibleText(local);

		driver.findElement(By.cssSelector("input#datepicker")).click();

		while (true) {

			String monthAndYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

			if (monthAndYear.contains(month) && monthAndYear.contains(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}

		/*
		 * List<WebElement> dates = driver.findElements(By.
		 * cssSelector("table.ui-datepicker-calendar tbody tr td a"));
		 * 
		 * for (WebElement d : dates) {
		 * 
		 * if (d.getText().equals(date)) { d.click(); break; }
		 * 
		 * }
		 */
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='" + date + "']"))
				.click();
		driver.switchTo().defaultContent();

	}

	public static void selectPastDateAndLocal(String local, String month, String year, String date) {

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		Select select = new Select(driver.findElement(By.cssSelector("select#locale")));
		select.selectByVisibleText(local);

		driver.findElement(By.cssSelector("input#datepicker")).click();

		while (true) {

			String monthAndYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

			if (monthAndYear.contains(month) && monthAndYear.contains(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector("table.ui-datepicker-calendar tbody tr td a"));

		for (WebElement d : dates) {

			if (d.getText().equals(date)) {
				d.click();
				break;
			}

		}

	}

}
