import java.io.IOException;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class O109_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);

		// Task: get all the links and check is there any broken link
		// Get all the links from the page into List to iterate over them
		List<WebElement> page_links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		// Add SoftAssert. The check will not stop after found the first non-working
		// link. It will check all the links and throw the broken links as an Exception.
		SoftAssert soft_ass = new SoftAssert();

		// Iterate over all links to find the non-working one
		for (WebElement link : page_links) {
			String page_url = link.getAttribute("href");

			HttpURLConnection my_conn = (HttpURLConnection) new URL(page_url).openConnection();
			my_conn.setRequestMethod("HEAD");
			my_conn.connect();
			// get the Network response code to find the code over 400
			int resp_code = my_conn.getResponseCode();
			System.out.println(resp_code);
			// if you don't need the SoftAssert and need to stop the iteration after you
			// find the first non-working link, than use this code.
//			if (resp_code > 400) {
//				System.out.println("The link with Text \"" + link.getText() + "\" is broken with code " + resp_code);
//				Assert.assertTrue(false);
//			}
			// Create a message that we will get after SoftAssert
			soft_ass.assertTrue(resp_code < 400,
					"The link with Text \"" + link.getText() + "\" is broken with code " + resp_code);
		}
		// This will iterate over all links using SoftAssert
		soft_ass.assertAll();

	}

}
