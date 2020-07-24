package com.training.regression.tests;

//import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterExcelTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void validRegisterExcelTest(String firstName,String lastName,String Email,String Telephone,String Address1, String Address2, String City, String postalCode, String Country, String Region, String password, String passwordConfirm) throws InterruptedException {
		
		registerPOM.clickMyAccount();
		registerPOM.clickonRegister();
		registerPOM.sendfirstname(firstName);
		registerPOM.sendlastname(lastName);
		registerPOM.sendemail(Email);
		registerPOM.sendtelephone(Telephone);
		screenShot.captureScreenShot();
		registerPOM.sendcompany("");
		registerPOM.sendaddress1(Address1);
		registerPOM.sendaddress2(Address2);
		registerPOM.sendcity(City);
		registerPOM.sendpostcode(postalCode);
		screenShot.captureScreenShot();
		registerPOM.selectCountry(Country);
		registerPOM.selectState(Region);
		registerPOM.sendPassword(password);
		registerPOM.confirmPassword(passwordConfirm);
		registerPOM.clickSubscribe();
		registerPOM.checkprivacypolicy();
		screenShot.captureScreenShot();
		registerPOM.clickContinueBtn();
				
		
		String ExpectedMsgText="Congratulations! Your new account has been successfully created!";
		String ActualMsgText= registerPOM.alertmsgtext();
		
		Assert.assertEquals(ActualMsgText, ExpectedMsgText);
		Assert.assertEquals(registerPOM.ContinueDisplayed(), true);
		screenShot.captureScreenShot("RegisterSuccess");	
		
		Thread.sleep(2000);	
		
	}
}
