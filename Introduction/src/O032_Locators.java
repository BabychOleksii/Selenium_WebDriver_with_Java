import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class O032_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // add an implicit wait to make all the elements appear on the page.
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Eva");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
				
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click(); // valid only for links, the <a> tags
		Thread.sleep(1000); // the script will sleep for 1 second to properly load new DOM elements
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); // XPath selector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@mail.eu");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); 
		// select the 2nd <input> element with type='text' in the DOM. Valid only for XPath. .clear() delete all inputed data from element.
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com"); // select the 3rd <input> element with type='text' in the DOM. Valid only for CSS selector.
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0667163346"); // parent->child selector. "//parent/child" element
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); // type*='pass' means all the types that has "pass" (like "instring") with CSS selector
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click(); // contains(@class, 'submit') means all the CSS classes that has "submit" (like "instring") with XPath selector
		
	}

}
