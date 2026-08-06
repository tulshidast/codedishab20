package seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textarea = driver.findElement(By.cssSelector("textarea[cols='30']"));
		WebElement textarea_1 = driver.findElement(By.cssSelector("textarea[id='ta1']"));

		Actions actions = new Actions(driver);

		actions.click(textarea).keyDown(textarea, Keys.CONTROL).sendKeys(textarea, "a").keyUp(textarea, "a")
				.sendKeys(textarea, "x").click(textarea_1).keyDown(textarea_1, "v").build().perform();

		driver.navigate().to("https://jqueryui.com/droppable/");

		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));

		actions.dragAndDrop(source, target).build().perform();
	}

}