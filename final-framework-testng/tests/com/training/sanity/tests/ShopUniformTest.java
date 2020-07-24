package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ShopUniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class ShopUniformTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ShopUniformPOM shopuniformPOM;
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
		shopuniformPOM= new ShopUniformPOM(driver);
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
	public void ShopUniform() throws InterruptedException {
		
		shopuniformPOM.clickonShopUniform();
	
		shopuniformPOM.AddToCart();
		
		shopuniformPOM.selectChestSize("42");
		screenShot.captureScreenShot("OrderPlacing");
		shopuniformPOM.ClickAddToCart();
		String ExpectedMsg="Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!";
		String ActualMsg = shopuniformPOM.SuccessMsg();
		//Verifying the Success Message through Contains
		boolean assertioncheck=ActualMsg.contains(ExpectedMsg);
		assertTrue(assertioncheck);	
		
		shopuniformPOM.ClickCartIcon();
		
		//Verifying View Cart Page Items
		shopuniformPOM.ClickViewCart();
		Thread.sleep(5000);
		assertEquals(shopuniformPOM.thumbnailimgDisplayed(), true, "Fail:Thumbnail not displayed");
		assertEquals(shopuniformPOM.ProductNameDisplayed(), true, "Fail:Product Name not displayed");
		assertEquals(shopuniformPOM.ModelDisplayed(), true, "Fail:ModelName not displayed");
		assertEquals(shopuniformPOM.QuantityDisplayed(), true, "Fail:Quantity not displayed");
		assertEquals(shopuniformPOM.UnitPriceDisplayed(), true, "Fail:Unit Price not displayed");
		assertEquals(shopuniformPOM.TotalDisplayed(), true, "Fail:Total not displayed");
		
		screenShot.captureScreenShot("ViewCart");
		shopuniformPOM.ClickCheckout();
		Thread.sleep(3000);
		assertEquals(shopuniformPOM.UsernameIsDisplayed(),true,"FAIL: Login is not displayed at Checkout");
		assertEquals(shopuniformPOM.PasswordIsDisplayed(),true,"FAIL: Login is not displayed at Checkout");
		
		screenShot.captureScreenShot("Login@Checkout");
		
		
		String ExpectedTitle="Checkout";
		String ActualTitle=driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
			
		
		Thread.sleep(5000);
		
		}
}
