package test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import filloreader.FilloReader;
import pageClasses.LoginPage;
import screenshot.ScreenShot;
import testbase.TestBase;

@Listeners(listeners.ListenerTest.class)
public class LoginTest extends TestBase{
	public static final Logger log = Logger.getLogger(LoginTest.class.getName());
	ScreenShot ss;
	ArrayList<String> login_cred = new ArrayList<String>();
    String email_id="";
    String password="";
	String filepath=System.getProperty("user.dir") + "\\src\\main\\java\\datamanager\\";
	FilloReader fillo;
	LoginPage lp;
	@BeforeTest
	public void setup() {
		init();
	}
	
	@Test()
	public void testLoginNegative() throws FilloException {
		log.info("Test Login");
		ss = new ScreenShot();
		fillo = new FilloReader();
		login_cred=fillo.getData(filepath,"loginData.xlsx", "login",1); 
		email_id=login_cred.get(0);
		log.info(email_id);
		password=login_cred.get(1);
		log.info(password);
		
		lp = new LoginPage(driver);
		String errmsg = lp.login(email_id, password);
		log.info(errmsg);
		
		Assert.assertEquals(errmsg, "Invalid credentials");
		ss.CaptureScreenShot(driver, "Test_01_Screenshot test");
		
	}
	
	@Test
	public void test1() {
		
		Assert.assertEquals(true, true);
	}
	
	@AfterTest
	public void cleanup() {
	    driver.close();
	}
}
