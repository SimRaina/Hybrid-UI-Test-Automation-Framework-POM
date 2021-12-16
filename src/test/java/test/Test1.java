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
import screenshot.ScreenShot;
import testbase.TestBase;

@Listeners(listeners.ListenerTest.class)
public class Test1 extends TestBase{
	public static final Logger log = Logger.getLogger(Test1.class.getName());
	ScreenShot ss;
	ArrayList<String> login_cred = new ArrayList<String>();
    String email_id="";
    String password="";
	String filepath=System.getProperty("user.dir") + "\\src\\main\\java\\datamanager\\";
	FilloReader fillo;
	@BeforeTest
	public void setup() {
		//init();
	}
	
	@Test(enabled=false)
	public void testLoginPositive() throws FilloException {
		log.info("This is a test. Don't worry.");
		ss = new ScreenShot();
		fillo = new FilloReader();
		login_cred=fillo.getData(filepath,"loginData.xlsx", "login",1); 
		email_id=login_cred.get(0);
		log.info(email_id);
		password=login_cred.get(1);
		log.info(password);
		ss.CaptureScreenShot(driver, "Test_01_Screenshot test");
		
	}
	
	@Test
	public void test1() {
		
		Assert.assertEquals(true, true);
	}
	
	@AfterTest
	public void cleanup() {
		//driver.close();
	}
}
