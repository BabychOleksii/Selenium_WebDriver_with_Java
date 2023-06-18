import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class O97_CalendarHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(3000);

		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form-field-travel_comp_date']")).click();

		// Task - get the 23 January day of the next year
		// first get the month you need
//		System.out.println(driver.findElement(By.cssSelector(".cur-month")).getAttribute("innerHTML"));
		while (!driver.findElement(By.cssSelector(".cur-month")).getAttribute("innerHTML").contains("January")) {
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
			Thread.sleep(500);
		}
//		System.out.println(driver.findElement(By.cssSelector(".cur-month")).getAttribute("innerHTML"));
		
		// get the 23 day of the current month, which is displayed on the opened calendar tab
		int days_count = driver.findElements(By.cssSelector(".flatpickr-day")).size();
		for (int i = 0; i < days_count; i++) {
			String day_text = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getAttribute("innerHTML");
			if (day_text.equalsIgnoreCase("23")) {
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}
		}
	}
}
