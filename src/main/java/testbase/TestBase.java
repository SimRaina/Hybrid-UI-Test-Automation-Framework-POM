package testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import datamanager.ConfigReader;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url=ConfigReader.getValueFromPropertyFile("AppUrl");
	String browser_path=ConfigReader.getValueFromPropertyFile("Chrome_Path");
	String browser_type = "chrome";
	
	public void init() {
		selectBrowser(browser_type, browser_path);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	public void selectBrowser(String browser_type, String browser_path) {
		if(browser_type.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+browser_path);
		    driver = new ChromeDriver();
		    log.info("Inside Select Browser");
		}
	}
	
	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Inside Get URL");
	}

}
