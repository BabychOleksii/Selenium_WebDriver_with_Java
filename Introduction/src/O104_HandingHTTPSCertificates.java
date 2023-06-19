import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class O104_HandingHTTPSCertificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions my_options = new ChromeOptions();

		// overcome the HPPS certificate
		my_options.setAcceptInsecureCerts(true);

		// add Proxy
//		Proxy my_proxy = new Proxy();
//		my_proxy.setHttpProxy("ipaddress:4444");
//		my_options.setCapability("proxy", my_proxy);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize the browser window
		driver.manage().deleteCookieNamed("sessionKey"); // delete the specific cookie
		driver.manage().deleteAllCookies(); // delete all cookies

		driver.get("https://google.com/");
	}

}
