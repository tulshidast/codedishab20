package seleniumpractices;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindBrokenLinks {

	@Test
	public void findBrokenLinks() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

		driver.get("https://www.google.com/");

		// Step 1: Extract all link elements
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + links.size());

		List<String> brokenLinks = new ArrayList<>();

		// Step 2: Loop through links and check HTTP status
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Filter out empty, null, or non-HTTP links
			if (url == null || url.isEmpty() || !url.startsWith("http")) {
				continue;
			}

			int statusCode = getHttpStatusCode(url);

			if (statusCode >= 400) {
				System.out.println("Broken Link: " + url + " | Status Code: " + statusCode);
				brokenLinks.add(url);
			} else {
				System.out.println("Valid Link: " + url + " | Status Code: " + statusCode);
			}

		}

	}

	/**
	 * Helper method to send a HEAD request and check HTTP response code.
	 */
	private static int getHttpStatusCode(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD"); // Use HEAD for speed
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.connect();

			int responseCode = connection.getResponseCode();

			// Some servers return 405 (Method Not Allowed) for HEAD requests; fallback to
			// GET
			if (responseCode == HttpURLConnection.HTTP_BAD_METHOD) {
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				connection.connect();
				responseCode = connection.getResponseCode();
			}

			return responseCode;
		} catch (Exception e) {
			// Unresolvable domain, SSL error, or connection timeout
			return 500;
		}
	}

}
