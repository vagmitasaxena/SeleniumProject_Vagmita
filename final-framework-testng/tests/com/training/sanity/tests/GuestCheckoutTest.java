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
import com.training.pom.ShopUniformPOM;
import com.training.pom.GuestCheckoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class GuestCheckoutTest {

	private WebDriver driver;
	private String baseUrl;
	private ShopUniformPOM shopuniformPOM;
	private GuestCheckoutPOM guestcheckoutPOM;
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
		shopuniformPOM= new ShopUniformPOM(driver);
		guestcheckoutPOM = new GuestCheckoutPOM(driver);
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
	@Test
	public void GuestCheckout() throws InterruptedException {
		
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
				
		screenShot.captureScreenShot("GuestCheckout");
		String ExpectedTitle="Checkout";
		String ActualTitle=driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
		
		//GUEST CHECKOUT**********************
		assertEquals(guestcheckoutPOM.CheckoutOptionsPanelIsDisplayed(), true);
		guestcheckoutPOM.clickGuestRadio();
		guestcheckoutPOM.clickContinue();
		Thread.sleep(1000);
		
		//Verify Billing Details Panel is Displayed 
		assertEquals(guestcheckoutPOM.BillingDetailPanelIsDisplayed(), true);
		guestcheckoutPOM.sendFirstname("Neha");
		guestcheckoutPOM.sendLastname("Jain");
		guestcheckoutPOM.sendEmail("nehajain@gmail.com");
		guestcheckoutPOM.sendTelephone("9576578788");
		guestcheckoutPOM.sendCompany("IBM");
		guestcheckoutPOM.sendAddress("Newcity");
		guestcheckoutPOM.sendCity("Delhi");
		guestcheckoutPOM.sendPostcode("110097");
		guestcheckoutPOM.sendCountry("India");
		guestcheckoutPOM.sendRegion("Delhi");
		guestcheckoutPOM.clickGuestContinue();
		
		//Verify Delivery Method Panel is Displayed
		assertEquals(guestcheckoutPOM.DeliveryMethodPanelIsDisplayed(),true);
		
		//Verify Free Delivery is checked
		assertEquals(guestcheckoutPOM.FreeDeliveryIsChecked(), true);
		
		//Verify About Order Textarea is displayed
		assertEquals(guestcheckoutPOM.AboutOrderIsDisplayed(),true);
				
		String Expected="Please Deliver between 7am to 10 am";
		//Enter Text in TextArea
		guestcheckoutPOM.sendAboutOrder(Expected); 
		String Actual = guestcheckoutPOM.AboutOrderVerification();
		//Verify the Entered Text
		assertEquals(Actual,Expected);
		Thread.sleep(1000);
		guestcheckoutPOM.clickDeliveryMethodContinue();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();",guestcheckoutPOM.ReadAgreeCheck );
		Thread.sleep(1000);
		//Read & Agree Checkbox is checked
		guestcheckoutPOM.CheckReadAgree();
		Thread.sleep(1000);
		//Payment Method Continue is clicked
		guestcheckoutPOM.clickPaymentMethodContinue();
		Thread.sleep(2000);
		//Verify that Checkout Confirm Panel is displayed
		assertEquals(guestcheckoutPOM.CheckoutConfirmPanelIsDisplayed(),true);
		guestcheckoutPOM.clickConfirmbutton();
		
		Thread.sleep(5000);
		String ActualOrderPlacedmsg= guestcheckoutPOM.OrderPlacedMsg();
		String ExpectedOrderPlacedmsg= "YOUR ORDER HAS BEEN PLACED!";
		//Verify Order Placed message
		assertEquals(ActualOrderPlacedmsg,ExpectedOrderPlacedmsg);
		
		Thread.sleep(3000);
		
		}
}
