package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RecoverPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ForgottenPasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private RecoverPasswordPOM recoverpasswordPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		recoverpasswordPOM = new RecoverPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validPasswordRecoverTest() throws InterruptedException {
		//loginPOM.clickonRegister();
		
		recoverpasswordPOM.clickMyAccount();
		recoverpasswordPOM.clickonLogin();
		recoverpasswordPOM.sendUserName("neha@gmail.com");
		recoverpasswordPOM.sendPassword("Neha1234");
		recoverpasswordPOM.clickLoginBtn(); 
		recoverpasswordPOM.clickForgottenPassword();
		recoverpasswordPOM.sendemail("neha@gmail.com");
		recoverpasswordPOM.clickContinueBtn();
		
		String expectedmsg="An email with a confirmation link has been sent your email address.";
		String actualmsg=recoverpasswordPOM.alertmsgtext();
		
		assertEquals(actualmsg, expectedmsg);
		
		screenShot.captureScreenShot("First");
		Thread.sleep(5000);
	}
}
