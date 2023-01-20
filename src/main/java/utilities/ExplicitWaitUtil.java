package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtil {
	
	WebDriver driver;
	
	public void waitForElementBY(WebDriver driver, By by) {
		
		this.driver = driver;
		
		new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForWebElement(WebDriver driver, WebElement ele) {
		
		this.driver = driver;
		new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOf(ele));
		
	}
}
