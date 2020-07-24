package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ComplexAddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexAddProductTest {

	private WebDriver driver;
	private String complexUrl;
	private ComplexAddProductPOM complexaddproductPOM;
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
		complexaddproductPOM = new ComplexAddProductPOM(driver); 
		complexUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(complexUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void complexAddProduct() throws InterruptedException {
		
		//Logging in as complex
		complexaddproductPOM.sendUserName("admin");
		complexaddproductPOM.sendPassword("admin@123");
		complexaddproductPOM.clickLoginBtn();
		screenShot.captureScreenShot("Logincomplex");
		
		//Catalogue Operations
		complexaddproductPOM.MouseOverCatalogueIcon();
		complexaddproductPOM.MouseOverProducts();
		
		//Verify Products Panel is displayed
		assertTrue(complexaddproductPOM.ProductsPanelIsDisplayed());
		screenShot.captureScreenShot("ProductPanel");
		
		//Click on Add New Icon
		complexaddproductPOM.ClickAddNewIcon();
		//Verify Add Product Panel is displayed
		assertTrue(complexaddproductPOM.AddProductIsDisplayed());
		screenShot.captureScreenShot("AddProductPanel");
		
		//***********General Tab*******
		complexaddproductPOM.sendProductName("Blazer Girls(7-8)");
		complexaddproductPOM.sendMetaTitle("Blazer for Girls");
		screenShot.captureScreenShot("GeneralTab");
		
		//***********Data Tab*******
		complexaddproductPOM.ClickDataTab();
		complexaddproductPOM.sendModel("BLG-112");
		complexaddproductPOM.sendPrice("3000");
		complexaddproductPOM.sendQuantity("100");
		screenShot.captureScreenShot("DataTab");
		
		//***********Links Tab*******
		complexaddproductPOM.ClickLinksTab();
		complexaddproductPOM.selectCategory("Uniforms");
		screenShot.captureScreenShot("LinksTab");
		
		//Click on Save Icon**************
		complexaddproductPOM.ClickSaveIcon();
		screenShot.captureScreenShot("SaveSuccess");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
				
		//Verify the Success Message
		String ExpectedMsg="Success: You have modified products!";
		String ActualMsg= complexaddproductPOM.GetSuccessMsg();
		boolean check=ActualMsg.contains(ExpectedMsg);
		assertTrue(check);
		
		complexaddproductPOM.Logout();
		
		}
}
