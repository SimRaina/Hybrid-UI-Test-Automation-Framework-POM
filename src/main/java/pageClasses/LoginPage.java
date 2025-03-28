package pageClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static final Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	@FindBy(name="username")
	WebElement user;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//form/div/button")
	WebElement btn;
	
	@FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']/p")
	WebElement message;
	
	public LoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public String login(String username,String pass) {
		
	    String text="";
	    log.info("Enter Username");
	    user.sendKeys(username); 
	    log.info("Enter Password");
	    password.sendKeys(pass);
	    btn.click();
	    log.info("Clicked on Login Button");
	    text = message.getText();
	    return text;         
	}
}
	
