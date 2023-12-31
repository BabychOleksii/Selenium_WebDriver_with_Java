import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class O085_ActionsMouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");		
		
		Actions my_act = new Actions(driver);
		my_act.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		
		// keyDown() - keep the key pressed - capital letters will be printed as a result. 
		my_act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("lenovo").doubleClick().build().perform();
		// contextClick() - mouse right button click
		my_act.moveToElement(driver.findElement(By.id("nav-orders"))).contextClick().build().perform();
		
	}

}
