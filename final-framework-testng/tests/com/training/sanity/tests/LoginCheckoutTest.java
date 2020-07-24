package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckoutPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ShopUniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class LoginCheckoutTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ShopUniformPOM shopuniformPOM;
	private CheckoutPOM checkoutPOM;
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
		checkoutPOM = new CheckoutPOM(driver);
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
	public void LoginCheckout() throws InterruptedException {
		
		//Placing an Order 
		shopuniformPOM.clickonShopUniform();
		shopuniformPOM.AddToCart();
		
		shopuniformPOM.selectChestSize("40");
		screenShot.captureScreenShot("OrderPlacing");
		shopuniformPOM.ClickAddToCart();
		String ExpectedMsg="Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!";
		String ActualMsg = shopuniformPOM.SuccessMsg();
		
		//Verifying the Success Message through Contains
		boolean assertioncheck=ActualMsg.contains(ExpectedMsg);
		assertTrue(assertioncheck);	
		
		//Logging in the Application
				loginPOM.clickMyAccount();
				loginPOM.clickonLogin();
				loginPOM.sendUserName("neha@gmail.com");
				loginPOM.sendPassword("Neha123");
				loginPOM.clickLoginBtn(); 
				
				
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
				
		screenShot.captureScreenShot("Checkout");
		String ExpectedTitle="Checkout";
		String ActualTitle=driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
		
		//CHECKOUT**********************
		//Verify Billing Details Panel is Displayed 
		assertEquals(checkoutPOM.BillingDetailPanelIsDisplayed(), true); 
		checkoutPOM.clickBillingContinue();
		Thread.sleep(1000);
		//Verify Delivery Details Panel is Displayed
		assertEquals(checkoutPOM.DeliveryDetailPanelIsDisplayed(),true);
		checkoutPOM.clickDeliveryContinue();
		Thread.sleep(1000);
		//Verify Free Delivery is checked
		assertEquals(checkoutPOM.FreeDeliveryIsChecked(), true);
		//Verify About Order Textarea is displayed
		assertEquals(checkoutPOM.AboutOrderIsDisplayed(),true);
		
		String Expected="Please Deliver between 7am to 10 am";
		//Enter Text in TextArea
		checkoutPOM.sendAboutOrder(Expected); 
		String Actual = checkoutPOM.AboutOrderVerification();
		//Verify the Entered Text
		assertEquals(Actual,Expected);
		Thread.sleep(1000);
		checkoutPOM.clickDeliveryMethodContinue();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",checkoutPOM.ReadAgreeCheck );
		Thread.sleep(1000);
		//Read & Agree Checkbox is checked
		checkoutPOM.CheckReadAgree();
		Thread.sleep(1000);
		//Payment Method Continue is clicked
		checkoutPOM.clickPaymentMethodContinue();
		Thread.sleep(2000);
		//Verify that Checkout Confirm Panel is displayed
		assertEquals(checkoutPOM.CheckoutConfirmPanelIsDisplayed(),true);
		checkoutPOM.clickConfirmbutton();
		
		Thread.sleep(5000);
		String ActualOrderPlacedmsg= checkoutPOM.OrderPlacedMsg();
		String ExpectedOrderPlacedmsg= "YOUR ORDER HAS BEEN PLACED!";
		//Verify Order Placed message
		assertEquals(ActualOrderPlacedmsg,ExpectedOrderPlacedmsg);
		
		Thread.sleep(3000);
		
		}
}
