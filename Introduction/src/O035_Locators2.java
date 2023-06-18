import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class O035_Locators2 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String user_name = "Eva";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // add an implicit wait to make all the elements appear on the page.
		
		String password = getPassword(driver); // launch the getPassword method and assign the password to the String password
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(user_name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in."); // compare the text and return True or False		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + user_name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException{
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password_text = driver.findElement(By.cssSelector("form p")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login. - the string we need to split and get the password from it.
		String[] password_array = password_text.split("'"); // split the string by the first ' symbol into 2 pieces, and return the array with 2 elements, before the first ' and after it
		String password = password_array[1].split("'")[0]; // split the 2nd element (index=1) from the previous line into 2 pieces, before and after the ' symbol, and return the 1st into the password variable.
		return password;
		
	}

}
