package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

public class Utilities {

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

	public static void selectValueFromDropdown(WebElement dropdownSelect, String textToBeSelected) {

		Select select = new Select(dropdownSelect);
		select.selectByVisibleText(textToBeSelected);

	}

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

	public static void takeScreenshot(WebDriver driver, String scrName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File s = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s, new File("src/test/resources/screenshot/" + scrName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
