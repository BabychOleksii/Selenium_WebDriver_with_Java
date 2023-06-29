import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O127_HeightAndWidthOfWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name_input_field = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(name_input_field.getRect().getDimension().getHeight());
		System.out.println(name_input_field.getRect().getDimension().getWidth());

	}

}
