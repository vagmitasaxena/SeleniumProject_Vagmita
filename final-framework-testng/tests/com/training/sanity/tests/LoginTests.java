package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	static Logger log = Logger.getLogger(LoginTests.class.getName());//log4j
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	static ExtentReports extent;//Extent Reports
    ExtentTest test;
    
    
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
				      
        
		}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();
        extent.close();
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		extent = new ExtentReports("C://Output//Logintest.html", true);
		test = extent.startTest("Login Test");
		test.log(LogStatus.PASS, "Application link opened successfully...");
		
		loginPOM.clickMyAccount();
		test.log(LogStatus.PASS, "My Account link is clicked");
		loginPOM.clickonLogin();
		test.log(LogStatus.PASS, "Login link is clicked");
		loginPOM.sendUserName("neha@gmail.com");
		loginPOM.sendPassword("Neha123");
		test.log(LogStatus.PASS, "Username & Password are Entered Successfully");
		log.info("Entering the Username & Password for login");
		loginPOM.clickLoginBtn(); 
		
		try {
		String ExpectedTitle="My Account";
		String ActualTitle=driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
		log.info("Login Successful");
		test.log(LogStatus.PASS, "Login is Successful");
				
		screenShot.captureScreenShot("Login");
		Thread.sleep(5000);
		}
		catch(Error e)
		{
			log.error(e);
			test.log(LogStatus.FAIL, e);
		}
	}
}
