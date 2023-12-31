package JavaAutomationTesting;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import JavaAutomationTesting.pageobjects.LandingPage;
import JavaAutomationTesting.pageobjects.ProductCatalogue;
import JavaAutomationTesting.pageobjects.CartPage;
import JavaAutomationTesting.pageobjects.CheckoutPage;
import JavaAutomationTesting.pageobjects.ConfirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// visit the page and log into the account
		LandingPage landingPage = new LandingPage(driver);
//		driver.get("https://rahulshettyacademy.com/client/");
		landingPage.goTo();
//		driver.findElement(By.id("userEmail")).sendKeys("anyuser@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("anyuser@gmail.comM1");
//		driver.findElement(By.id("login")).click();
		ProductCatalogue productCatalogue = landingPage.loginApplication("anyuser@gmail.com", "anyuser@gmail.comM1");

		// find the item and add to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		List<WebElement> products = productCatalogue.getProductList();

		// add the product to the cart
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
//				.orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		productCatalogue.addProductToCart(productName);

		// check the message that the item was added to the cart
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// move to the cart page
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		CartPage cartPage = productCatalogue.goToCartPage();

		// check the products in the cart page
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartProducts.stream()
//				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		// move to the checkout page
//		driver.findElement(By.cssSelector(".totalRow button")).click();
		CheckoutPage checkoutPage = cartPage.goToCheckout();

		// fill the required fields on the checkout page (choose a country from
		// dropdown)
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		// Check the confirmation message on the "thank you" page
//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
