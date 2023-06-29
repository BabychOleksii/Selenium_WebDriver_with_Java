import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


public class O126_WebElementPartialScrrenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String my_text = "Core java for Automation Testers + Interview Programs";
		WebElement name_input_field = driver.findElement(By.cssSelector("[name='name']"));
		name_input_field.sendKeys(my_text);
		
		// before you need to add .jar file from this https://mvnrepository.com/artifact/commons-io/commons-io/2.13.0 (or from Maven package)
		File my_screenshot = name_input_field.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(my_screenshot, new File("first_screen.png"));	

	}

}
