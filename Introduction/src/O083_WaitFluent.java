import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class O083_WaitFluent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("[id='start'] button")).click();

		// Example of using. After payment you get 2 messages: 1st after 3 seconds, that
		// your card is accepted and 2nd after 15 seconds, that the payment was success.
		// You need to catch both these massages to be sure that payment works properly.

		// declare Fluent wait. It will wait for an element for 30 seconds and check if
		// the element is present every 3 seconds and will not throw any exception.
		Wait<WebDriver> fl_wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		// uinfg the Fluent Wait
		WebElement wait_for_hello = fl_wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else {
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
