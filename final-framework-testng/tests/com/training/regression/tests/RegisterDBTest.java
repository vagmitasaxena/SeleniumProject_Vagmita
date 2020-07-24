package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterDBPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest {
	private WebDriver driver;
	private String baseUrl;
	private RegisterDBPOM registerDBPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerDBPOM=new RegisterDBPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void RegisterDB(String firstName, String lastName,String email,String telephone, String address1,String address2, String city, String postcode, String country, String region, String password, String passwordconfirm ) throws InterruptedException 
	{
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		registerDBPOM.clickMyAccount();
		registerDBPOM.clickonRegister();
		registerDBPOM.sendfirstname("Neha");
		registerDBPOM.sendlastname("B");
		registerDBPOM.sendemail("neha12@gmail.com");
		registerDBPOM.sendtelephone("9241835892");
		screenShot.captureScreenShot();
		//registerDBPOM.sendcompany("");
		registerDBPOM.sendaddress1("4th block");
		registerDBPOM.sendaddress2("Jayanagar");
		registerDBPOM.sendcity("Bangalore");
		registerDBPOM.sendpostcode("560082");
		screenShot.captureScreenShot();
		registerDBPOM.selectCountry("India");
		registerDBPOM.selectState("Karnataka");
		registerDBPOM.sendPassword("Neha123");
		registerDBPOM.confirmPassword("Neha123");
		registerDBPOM.clickSubscribe();
		registerDBPOM.checkprivacypolicy();
		screenShot.captureScreenShot();
			
		
		Assert.assertEquals(registerDBPOM.getfirstname(), firstName);
		Assert.assertEquals(registerDBPOM.getlastname(), lastName);
		Assert.assertEquals(registerDBPOM.getemail(), email);
		Assert.assertEquals(registerDBPOM.gettelephone(), telephone);
		Assert.assertEquals(registerDBPOM.getaddress1(), address1);
		Assert.assertEquals(registerDBPOM.getaddress2(), address2);
		Assert.assertEquals(registerDBPOM.getcity(), city);
		Assert.assertEquals(registerDBPOM.getpostcode(), postcode);
		Assert.assertEquals(registerDBPOM.getCountry(), country);
		Assert.assertEquals(registerDBPOM.getState(), region);
		Assert.assertEquals(registerDBPOM.getPassword(), password);
		Assert.assertEquals(registerDBPOM.getconfirmPassword(), passwordconfirm);
		
		
		Thread.sleep(2000);	
		
		registerDBPOM.clickContinueBtn();
				
		
		String ExpectedMsgText="Congratulations! Your new account has been successfully created!";
		String ActualMsgText= registerDBPOM.alertmsgtext();
		
		Assert.assertEquals(ActualMsgText, ExpectedMsgText);
		Assert.assertEquals(registerDBPOM.ContinueDisplayed(), true);
		screenShot.captureScreenShot("RegisterSuccess");

	}
}

