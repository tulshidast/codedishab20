package seleniumpractices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Utilities;

public class HowToHandleAlerts {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get(Utilities.readProperty("url"));
		driver.manage().window().maximize();

		// if alert is not present then it will throw NoAlertPresentException
		// driver.switchTo().alert();

		driver.findElement(By.xpath("//input[@id='prompt']")).click();

		Alert alt = driver.switchTo().alert();

		alt.sendKeys("Welcome to codedisha");

		String msg = alt.getText();
		System.out.println(msg);

		alt.accept();
		// alt.dismiss();

		driver.findElement(By.cssSelector("#ta1")).sendKeys("Welcome to codedisha");

	}

}
