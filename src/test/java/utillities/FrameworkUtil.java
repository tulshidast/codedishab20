package utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkUtil {

	/**
	 * Reads a property value from the testdata.properties file based on the
	 * provided key.
	 *
	 * @param key The key for which the property value is to be retrieved.
	 * @return The property value associated with the specified key, or null if not
	 *         found.
	 */
	public static String readProperty(String key) {

		File file = new File("src/test/resources/testdata.properties");
		Properties prop;
		String p = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInputStream);
			p = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;

	}

	/**
	 * Selects a value from a dropdown element based on the visible text.
	 *
	 * @param dropdownSelect   The WebElement representing the dropdown.
	 * @param textToBeSelected The visible text of the option to be selected.
	 */
	public static void selectValueFromDropdown(WebElement dropdownSelect, String textToBeSelected) {

		Select select = new Select(dropdownSelect);
		select.selectByVisibleText(textToBeSelected);

	}

	/**
	 * Retrieves all options from a dropdown element and returns them as a list of
	 * strings.
	 *
	 * @param dropdownSelect The WebElement representing the dropdown.
	 * @return A list of strings containing the visible text of all options in the
	 *         dropdown.
	 */
	public static List<String> getAllDropdownOptions(WebElement dropdownSelect) {

		Select select = new Select(dropdownSelect);
		List<WebElement> allOptions = select.getOptions();
		List<String> allOpt = new ArrayList<String>();
		for (WebElement elm : allOptions) {
			allOpt.add(elm.getText());
		}
		return allOpt;

	}

	/**
	 * .This method is used to read excel.
	 * 
	 * @param filePath  pass file path as String of xlsx which you wanted read
	 * @param sheetName pass sheet name as String from excel which you wanted read
	 * @return It return LinkedList
	 */
	public static LinkedHashMap<Integer, List<Object>> readExcel(String filePath, String sheetName) {

		LinkedHashMap<Integer, List<Object>> userDetails = new LinkedHashMap<Integer, List<Object>>();

		File file = new File(filePath);
		FileInputStream fileInputStream = null;
		XSSFWorkbook xssfWorkbook = null;
		try {
			fileInputStream = new FileInputStream(file);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);

			XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

			int lastRowNum = xssfSheet.getLastRowNum();

			ArrayList<Object> dt;

			for (int i = 1; i <= lastRowNum; i++) {

				XSSFRow xssfRow = xssfSheet.getRow(i);

				dt = new ArrayList<Object>();

				int lastCellNum = xssfRow.getLastCellNum();

				for (int j = 0; j < lastCellNum; j++) {

					if (CellType.STRING == xssfRow.getCell(j).getCellType()) {

						dt.add(xssfRow.getCell(j).getStringCellValue());

					}

					if (CellType.NUMERIC == xssfRow.getCell(j).getCellType()) {

						dt.add(xssfRow.getCell(j).getNumericCellValue());

					}

					if (CellType.BOOLEAN == xssfRow.getCell(j).getCellType()) {

						dt.add(xssfRow.getCell(j).getBooleanCellValue());

					}

				}

				userDetails.put(i, dt);

			}
			xssfWorkbook.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return userDetails;

	}

	/**
	 * Takes a screenshot of the current page and saves it to the specified
	 * location.
	 *
	 * @param driver  The WebDriver instance.
	 * @param scrName The name to be used for the screenshot file (without
	 *                extension).
	 */
	public static void takeScreenshot(WebDriver driver, String scrName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File s = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s, new File("src/test/resources/screenshot/" + scrName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits for the specified element to be visible on the page.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement to wait for visibility.
	 */
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits for the specified list of elements to be visible on the page.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The list of WebElements to wait for visibility.
	 */
	public static void waitForElementToBeVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	/**
	 * Hovers the mouse over the specified element.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement to hover over.
	 */
	public static void hoverOnElement(WebDriver driver, WebElement element) {
		// Implement hover functionality using Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Retrieves the text from a list of WebElements and returns it as a list of
	 * strings.
	 *
	 * @param elements The list of WebElements to extract text from.
	 * @return A list of strings containing the text of each WebElement.
	 */
	public static List<String> getElementsText(List<WebElement> elements) {
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

}
