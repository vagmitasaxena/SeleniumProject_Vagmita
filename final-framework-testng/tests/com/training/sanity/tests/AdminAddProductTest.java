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
import com.training.pom.AdminAddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddProductTest {

	private WebDriver driver;
	private String adminUrl;
	private AdminAddProductPOM adminaddproductPOM;
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
		adminaddproductPOM = new AdminAddProductPOM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void AdminAddProduct() throws InterruptedException {
		
		//Logging in as Admin
		adminaddproductPOM.sendUserName("admin");
		adminaddproductPOM.sendPassword("admin@123");
		adminaddproductPOM.clickLoginBtn();
		screenShot.captureScreenShot("LoginAdmin");
		
		//Catalogue Operations
		adminaddproductPOM.MouseOverCatalogueIcon();
		adminaddproductPOM.MouseOverProducts();
		
		//Verify Products Panel is displayed
		assertTrue(adminaddproductPOM.ProductsPanelIsDisplayed());
		screenShot.captureScreenShot("ProductPanel");
		
		//Click on Add New Icon
		adminaddproductPOM.ClickAddNewIcon();
		//Verify Add Product Panel is displayed
		assertTrue(adminaddproductPOM.AddProductIsDisplayed());
		screenShot.captureScreenShot("AddProductPanel");
		
		//***********General Tab*******
		adminaddproductPOM.sendProductName("Blazer Girls(7-8)");
		adminaddproductPOM.sendMetaTitle("Blazer for Girls");
		screenShot.captureScreenShot("GeneralTab");
		
		//***********Data Tab*******
		adminaddproductPOM.ClickDataTab();
		adminaddproductPOM.sendModel("BLG-112");
		adminaddproductPOM.sendPrice("3000");
		adminaddproductPOM.sendQuantity("100");
		screenShot.captureScreenShot("DataTab");
		
		//***********Links Tab*******
		adminaddproductPOM.ClickLinksTab();
		adminaddproductPOM.selectCategory("Uniforms");
		screenShot.captureScreenShot("LinksTab");
		
		//***********Discount Tab*******
		adminaddproductPOM.ClickDiscountTab();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		adminaddproductPOM.ClickAddDiscountIcon();
		adminaddproductPOM.sendDisQuantity("5");
		adminaddproductPOM.sendDisPrice("200");
		adminaddproductPOM.selectStartDate();
		adminaddproductPOM.selectEndDate();
		screenShot.captureScreenShot("DiscountTab");
		
		//***********Reward Points Tab*******
		adminaddproductPOM.ClickRewardPointsTab();
		adminaddproductPOM.sendPoints("20");
		screenShot.captureScreenShot("RewardTab");
		
		//Click on Save Icon**************
		adminaddproductPOM.ClickSaveIcon();
		screenShot.captureScreenShot("SaveSuccess");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		//Verify the Success Message
		String ExpectedMsg="Success: You have modified products!";
		String ActualMsg= adminaddproductPOM.GetSuccessMsg();
		boolean check=ActualMsg.contains(ExpectedMsg);
		assertTrue(check);
		}
}
