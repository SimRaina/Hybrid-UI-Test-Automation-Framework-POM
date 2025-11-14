package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageClasses.LoginPage;
import screenshot.ScreenShot;
import testbase.TestBase;
import pojo.LoginData;

@Listeners(listeners.ListenerTest.class)
public class LoginTestJson extends TestBase{
	
	public static final Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	ScreenShot ss;
	ArrayList<String> login_cred = new ArrayList<String>();
	String email_id="";
	String password="";
	LoginPage lp;
	String filepath=System.getProperty("user.dir") + "\\Resources\\data\\logindata.json";

	@BeforeTest
	public void setup() {
		init();
	}

	@Test()
	public void testLoginNegative() throws StreamReadException, DatabindException, IOException {
		log.info("Test Login");
		
		ObjectMapper mapper = new ObjectMapper();
	    LoginData data = mapper.readValue(
	            new File(filepath),
	            LoginData.class);
		lp = new LoginPage(driver);
		lp.loginSuccess(data.username, data.password);
	}


	@AfterTest
	public void cleanup() {
		driver.close();
	}
}
