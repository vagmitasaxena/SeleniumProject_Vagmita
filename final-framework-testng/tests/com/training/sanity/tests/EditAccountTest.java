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
import com.training.pom.LoginPOM;
import com.training.pom.EditAccountPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditAccountTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditAccountPOM editaccountPOM;
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
		loginPOM = new LoginPOM(driver); 
		editaccountPOM =new EditAccountPOM(driver);
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
	public void validEditAccountTest() throws InterruptedException {
		
		//Login Page
		loginPOM.clickMyAccount();
		loginPOM.clickonLogin();
		loginPOM.sendUserName("neha@gmail.com");
		loginPOM.sendPassword("Neha123");
		loginPOM.clickLoginBtn(); 
		
		screenShot.captureScreenShot("LoginSuccess");
		
		//Edit Account Page 
		editaccountPOM.clickEditAccount();
		editaccountPOM.sendfirstname("Neha");
		editaccountPOM.sendlastname("B");
		editaccountPOM.sendemail("neha@gmail.com");
		editaccountPOM.sendtelephone("9876543210");
		
		
		screenShot.captureScreenShot("EditAcc");
				
		editaccountPOM.clickContinueBtn();
		
			
		String ExpectedTitle="Success: Your account has been successfully updated.";
		String ActualTitle=editaccountPOM.alertmsgtext();
		assertEquals(ActualTitle, ExpectedTitle);
		
		screenShot.captureScreenShot("EditAccSuccess");
		
		Thread.sleep(5000);
	}
}
