package JavaAutomationTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");

		// login into account
		driver.findElement(By.id("userEmail")).sendKeys("babych.oleksii@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("babych.oleksii@gmail.comM1");
		driver.findElement(By.id("login")).click();

		// find the item and add to cart
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		

	}

}
