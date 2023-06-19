import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class O108_Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");

		File my_src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(my_src, new File("D:\\Projects\\Selenium_WebDriver_with_Java\\my_screenshot.png"));

	}

}
