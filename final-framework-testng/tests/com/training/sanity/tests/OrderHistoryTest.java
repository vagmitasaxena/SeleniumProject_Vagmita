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
import com.training.pom.OrderHistoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderHistoryTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private OrderHistoryPOM orderhistoryPOM;
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
		orderhistoryPOM = new OrderHistoryPOM(driver); 
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
	public void validOrderHistoryTest() throws InterruptedException {
		
		//Login the Account
		loginPOM.clickMyAccount();
		loginPOM.clickonLogin();
		loginPOM.sendUserName("neha@gmail.com");
		loginPOM.sendPassword("Neha123");
		loginPOM.clickLoginBtn(); 
		
		//Order History
		orderhistoryPOM.clickUserIcon();
		orderhistoryPOM.clickOrderHistory();
		
		//Verify Order Details are displayed
		assertEquals(orderhistoryPOM.OrderIdDisplayed(), true);
		assertEquals(orderhistoryPOM.CustomerDisplayed(), true);
		assertEquals(orderhistoryPOM.NoofProductDisplayed(), true);
		assertEquals(orderhistoryPOM.StatusDisplayed(), true);
		assertEquals(orderhistoryPOM.TotalDisplayed(), true);
		assertEquals(orderhistoryPOM.DateAddedDisplayed(), true);
		screenShot.captureScreenShot("OrderHistory");
		//Click View Icon
		orderhistoryPOM.clickViewIcon();
		
		//Verify Ordered Product Details
		assertEquals(orderhistoryPOM.OrderHistoryTableDisplayed(), true);
		assertEquals(orderhistoryPOM.ProductDetailsDisplayed(), true);
		
		screenShot.captureScreenShot("OrderHistorySuccess");
		Thread.sleep(5000);
	}
}
