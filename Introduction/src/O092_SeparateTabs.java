import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O092_SeparateTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// get the number of all links on the page, the <a> tags
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Limited the webdriver scope to get only the elements from the footer
		WebElement footer_driver = driver.findElement(By.id("gf-BIG"));

		WebElement column_driver = footer_driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int column_elements_num = column_driver.findElements(By.tagName("a")).size();
		System.out.println(column_elements_num);

		// open each pages without coming back to the main page
		for (int i = 1; i < column_elements_num; i++) {
			// make a click on each element with pressed "Ctrl" button to open in a new tab
			String click_on_link_tab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column_driver.findElements(By.tagName("a")).get(i).sendKeys(click_on_link_tab);
			Thread.sleep(5000L);
		}

			Set<String> opened_tabs = driver.getWindowHandles();
			Iterator<String> my_iter = opened_tabs.iterator();

			// print the title of each opened tab
			while (my_iter.hasNext()) {
				driver.switchTo().window(my_iter.next());
				System.out.println(driver.getTitle());
			}
	}
}
