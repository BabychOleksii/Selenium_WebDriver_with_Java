import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class O101_WindowScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// get the sum of amounts of the items from the page
		List<WebElement> item_amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int total_sum = 0;

		for (int i = 0; i < item_amounts.size(); i++) {
			total_sum = total_sum + Integer.parseInt(item_amounts.get(i).getText());
		}

		System.out.println(total_sum);
		// compare the sum we get with the sum displayed on the page
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total_amount = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(total_sum, total_amount);
	}

}
