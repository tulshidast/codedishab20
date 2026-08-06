package seleniumpractices;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Utilities;

public class TestDataSpecificScenario {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get(Utilities.readProperty("newToursUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();

		LinkedHashMap<Integer, List<Object>> udata = Utilities
				.readExcel("src/test/resources/testcasedata/userregistration.xlsx", "urdata");

		List<Object> firstRowData = udata.get(2);

		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstRowData.get(0).toString());
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(firstRowData.get(1).toString());
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(firstRowData.get(2).toString());

		WebElement countryDropdown = driver.findElement(By.cssSelector("select[name='country']"));
		Utilities.selectValueFromDropdown(countryDropdown, firstRowData.get(3).toString());

//		for (Entry<Integer, List<Object>> s : udata.entrySet()) {
//			System.out.println(s.getKey());
//
//			for (Object us : s.getValue()) {
//				System.out.println(us.toString());
//			}
//		}

	}

}
