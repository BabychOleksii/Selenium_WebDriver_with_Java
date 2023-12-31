import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIElements2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// choose the "from" and "to" destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// choose the today date
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// make sure that the return date calendar is disabled, because we choose one
		// way trip (by default)
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("its enable");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}

		// check the "Senior Citizen" checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		// make the passengers amount equal to 5
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // click 4 times to get the adults = 5
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// change the currency to USD
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("USD");

		// click on the "Search" button
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

	}

}
