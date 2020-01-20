package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	String url = "http://thedemosite.co.uk/login.php";
	String browser_type = "chrome";
	
	public void init() {
		selectBrowser(browser_type);
		getUrl(url);
	}
	
	public void selectBrowser(String browser_type) {
		if(browser_type.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe\\");
		    driver = new ChromeDriver();
		}
	}
	
	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
