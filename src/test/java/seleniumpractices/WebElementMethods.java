package seleniumpractices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");

		WebElement textAreaField = driver.findElement(By.cssSelector("textarea#ta1"));

		System.out.println("Accessible name = " + textAreaField.getAccessibleName());
		System.out.println("Aria Role = " + textAreaField.getAriaRole());

		// Use this method to simulate typing into an element, which may set its value.
		textAreaField.sendKeys("Welcome to codedisha");

		Thread.sleep(3000);

		// Use this method to clear the text if it's a text entry element.
		textAreaField.clear();

		// Click this element
		WebElement clickToGetAlertButton = driver.findElement(By.cssSelector("input#alert1"));
		clickToGetAlertButton.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		// Use this method to get the value of a given attribute of the element.
		String rowsAttributeValue = textAreaField.getAttribute("rows");
		System.out.println("Rows attribute value = " + rowsAttributeValue);

		Point p = textAreaField.getLocation();
		System.out.println("X coordinate = " + p.getX());
		System.out.println("Y coordinate = " + p.getY());

		Rectangle t = textAreaField.getRect();
		System.out.println("Height = " + t.getHeight());
		System.out.println("Width = " + t.getWidth());

		File file = textAreaField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src/test/resources/screenshot/textAreaField.png"));

		String tagName = textAreaField.getTagName();
		System.out.println("Tag name = " + tagName);

		String text = driver.findElement(By.cssSelector("#but2")).getText();
		System.out.println("Text of the button = " + text);

		System.out.println("Button 2 is enabled = " + driver.findElement(By.cssSelector("#but2")).isEnabled());

		System.out.println("Button 1 is enabled = " + driver.findElement(By.cssSelector("#but1")).isEnabled());

		System.out.println("Delayed text is displayed on UI = "
				+ driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		Thread.sleep(10000);

		System.out.println("Delayed text is displayed on UI = "
				+ driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		System.out.println("Bike radio button is selected = "
				+ driver.findElement(By.cssSelector("input[value='Bike']")).isSelected());

		System.out.println("Bicycle radio button is selected = "
				+ driver.findElement(By.cssSelector("input[value='Bicycle']")).isSelected());

		System.out.println(
				"Pen checkbox is selected = " + driver.findElement(By.cssSelector("input[value='Pen']")).isSelected());

		System.out.println("Book checkbox is selected = "
				+ driver.findElement(By.cssSelector("input[value='Book']")).isSelected());

		WebElement textArea = driver.findElement(By.cssSelector("textarea[cols='30']"));
		textArea.clear();

		textArea.sendKeys("Hello, this is a test message");

		String txt = textArea.getText();

		System.out.println(txt.length());

		textArea.clear();

		textArea.sendKeys("12dfeER3#@$fG$5");

		txt = textArea.getText();

		txt = txt.replaceAll("[0-9a-z-A-Z]", "");

		if (txt.length() > 0) {
			System.out.println("Text area contains special characters");
		} else {
			System.out.println("Text area does not contain special characters");
		}

	}

}
