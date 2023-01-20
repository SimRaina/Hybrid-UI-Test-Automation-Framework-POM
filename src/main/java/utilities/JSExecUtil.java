package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecUtil {

	
	WebDriver driver;
	
	public void JSExecScrollView(WebDriver driver, WebElement ele) {
		
		this.driver = driver;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView();", ele);	
	}
}
