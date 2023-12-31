import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class O116_CheckWebTablesSorting {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Task: check if the elements in first column sorted
		// click on first column to sort elements. This is only the step for
		// demonstration.
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// capture all elements into a list
		List<WebElement> elements_list = driver.findElements(By.xpath("//tr/td[1]"));
		// capture text from all web elements into new list
		List<String> original_list = elements_list.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort a list into another list
		List<String> sorted_list = original_list.stream().sorted().collect(Collectors.toList());
		// compare original list with the sorted list
		Assert.assertTrue(original_list.equals(sorted_list));

		// Find the product through multiple pages and get the price of the current
		// product
		// scan the name column and get text -> Rice -> get the price of the Rice
		List<String> elem_price;
		do {
			List<WebElement> table_rows = driver.findElements(By.xpath("//tr/td[1]"));
			elem_price = table_rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			elem_price.forEach(a -> System.out.println(a));
			if (elem_price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (elem_price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		String price_value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price_value;

	}
}
