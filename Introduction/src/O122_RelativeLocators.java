import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class O122_RelativeLocators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// above() - element located above with the respect to the specified element
		// below() - element located below with the respect to the specified element
		// toLeftOf() - element located to the left to the specified element
		// toRightOf() - element located to the right to the specified element

		WebElement name_input_box = driver.findElement(By.cssSelector("[name = 'name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(name_input_box)).getText());

		WebElement date_of_birth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(date_of_birth)).click();

		WebElement iceCream_label = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCream_label)).click();

		WebElement radiobutton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText());

	}
}
