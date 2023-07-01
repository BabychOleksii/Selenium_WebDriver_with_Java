package JavaAutomationTesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import JavaAutomationTesting.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		// send the driver object from child class LandingPage to the parent class
		// AbstractComponent
		super(driver);

		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
	}

}
