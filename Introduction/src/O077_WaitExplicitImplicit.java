import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O077_WaitExplicitImplicit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// declaring the Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// declaring Explicit wait
		WebDriverWait expl_wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] product_names = { "Cucumber", "Banana", "Carrot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();

		addItems(driver, product_names);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// adding Explicit wait
		expl_wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] product_names) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// get from the full name of the product ("Cucumber - 1 Kg") the name of the
			// product itself, that will match with the product_names list elements
			String[] product_split_name = products.get(i).getText().split("-");
			String product_name = product_split_name[0].trim();

			// convert the product_names array into a list
			List<String> product_names_list = Arrays.asList(product_names);

			if (product_names_list.contains(product_name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// we add the j variable to interrupt the loop after we add 3 products to
				// basket. For performance optimization.
				if (j == product_names.length) {
					break;
				}
			}
		}
	}

}
