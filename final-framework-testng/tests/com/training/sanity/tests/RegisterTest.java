package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {

	static Logger log = Logger.getLogger(RegisterTest.class.getName());//log4j
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver); 
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
	public void validRegisterTest() throws InterruptedException {
		
		extent = new ExtentReports("C://Output//Registertest.html", true);
		test = extent.startTest("Login Test");
		test.log(LogStatus.PASS, "Application link opened successfully...");
		
		registerPOM.clickMyAccount();
		test.log(LogStatus.PASS, "My Account link is clicked");
		registerPOM.clickonRegister();
		test.log(LogStatus.PASS, "Register link is clicked");
		registerPOM.sendfirstname("Neha");
		test.log(LogStatus.PASS, "Firstname is Entered Successfully");
		registerPOM.sendlastname("B");
		test.log(LogStatus.PASS, "Lastname is Entered Successfully");
		registerPOM.sendemail("neha5@gmail.com");
		test.log(LogStatus.PASS, "Email is Entered Successfully");
		registerPOM.sendtelephone("9241835892");
		test.log(LogStatus.PASS, "Telephone number is Entered Successfully");
		screenShot.captureScreenShot();
		registerPOM.sendcompany("");
		test.log(LogStatus.PASS, "Company is Entered Successfully");
		registerPOM.sendaddress1("Jayanagar");
		registerPOM.sendaddress2("");
		test.log(LogStatus.PASS, "Address is Entered Successfully");
		registerPOM.sendcity("Bangalore");
		test.log(LogStatus.PASS, "City is Entered Successfully");
		registerPOM.sendpostcode("560082");
		test.log(LogStatus.PASS, "Postcode is Entered Successfully");
		screenShot.captureScreenShot();
		registerPOM.selectCountry("India");
		test.log(LogStatus.PASS, "Country is Entered Successfully");
		registerPOM.selectState("Karnataka");
		test.log(LogStatus.PASS, "State is Entered Successfully");
		registerPOM.sendPassword("Neha123");
		registerPOM.confirmPassword("Neha123");
		test.log(LogStatus.PASS, "Password is Entered Successfully");
		registerPOM.clickSubscribe();
		test.log(LogStatus.PASS, "Subscribe Radio button is clicked Successfully");
		registerPOM.checkprivacypolicy();
		test.log(LogStatus.PASS, "Privacy Policy is Checked Successfully");
		screenShot.captureScreenShot();
		registerPOM.clickContinueBtn();
		test.log(LogStatus.PASS, "Continue Button is clicked Successfully");
		
		try {
		String ExpectedMsgText="Congratulations! Your new account has been successfully created!";
		String ActualMsgText= registerPOM.alertmsgtext();
		
		assertEquals(ActualMsgText, ExpectedMsgText);
		assertEquals(registerPOM.ContinueDisplayed(), true);
		screenShot.captureScreenShot("RegisterSuccess");	
		}
		catch(Error e)
		{
			String ExpectedMsgText="Congratulations! Your new account has been successfully created!";
			String ActualMsgText= registerPOM.alertmsgtext();
			
			log.error("Failed to Register the Account.Error is : "+e);
			test.log(LogStatus.FAIL, "Failed to Register the Account.Error is : "+e);
			
			assertEquals(ActualMsgText, ExpectedMsgText);
			assertEquals(registerPOM.ContinueDisplayed(), true);
		
		}	
		Thread.sleep(5000);	
		
	}
}
