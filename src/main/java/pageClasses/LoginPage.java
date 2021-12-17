package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	

	
	@FindBy(id="txtUsername")
	WebElement user;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btn;
	
	@FindBy(xpath="//span[contains(text(), 'Invalid')]")
	WebElement message;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String login(String username,String pass) {
		
		String text="";
		log.info("Username");
	    user.sendKeys(username); 
	    log.info("Entered Username");
	    
	    log.info("Enter Password");
	    password.sendKeys(pass);
	    
	    btn.click();
	    log.info("Clicked on Login Button");
		
	    text = message.getText();
	    
	    return text;         
	}
}
	
