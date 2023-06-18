import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O071_ArrayOfProducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();

		String[] product_names = { "Cucumber", "Banana", "Carrot" };
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// if you need to choose only 1 product
//		for (int i = 0; i < products.size(); i++) {
//			String product_name = products.get(i).getText();
//
//			if (product_name.contains("Cucumber")) {
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				break;
//			}
//		}

		// if you want to choose all the products from the product_names array
		int j = 0;
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

				// we add the j variable to interrupt the loop after we add 3 products to basket. For performance optimization.
				if (j == product_names.length) {
					break;
				}
			}
		}
	}
}
