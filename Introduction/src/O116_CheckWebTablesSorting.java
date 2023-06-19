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
		
//		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elements_list = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> original_list = elements_list.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sorted_list = original_list.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(original_list.equals(sorted_list));
	}
}
