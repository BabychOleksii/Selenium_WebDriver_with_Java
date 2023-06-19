import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class O104_HandingHTTPSCertificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions my_options = new ChromeOptions();
		my_options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

}
