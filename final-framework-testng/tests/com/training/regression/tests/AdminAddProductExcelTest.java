package com.training.regression.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminAddCategory;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddProductExcelTest {

	private WebDriver driver;
	private String adminUrl;
	private AdminAddCategory adminaddcategoryPOM;
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
		adminaddcategoryPOM = new AdminAddCategory(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void AdminAddcategory(String CategoryName, String Description, String MetaTagTitle, String MetaTagDescription) throws InterruptedException {
		
		//Logging in as Admin
		adminaddcategoryPOM.sendUserName("admin");
		adminaddcategoryPOM.sendPassword("admin@123");
		adminaddcategoryPOM.clickLoginBtn();
		screenShot.captureScreenShot("LoginAdmin");
		
		//Catalogue Operations
		adminaddcategoryPOM.MouseOverCatalogueIcon();
		adminaddcategoryPOM.MouseOverCategories();
		
		//Verify categorys Panel is displayed
		assertTrue(adminaddcategoryPOM.CategoriesPanelIsDisplayed());
		screenShot.captureScreenShot("CategoryPanel");
		
		//Click on Add New Icon
		adminaddcategoryPOM.ClickAddNewIcon();
		//Verify Add category Panel is displayed
		assertTrue(adminaddcategoryPOM.AddCategoryIsDisplayed());
		screenShot.captureScreenShot("AddCategoryPanel");
		
		//***********General Tab*******
		adminaddcategoryPOM.sendCategoryName(CategoryName);
		adminaddcategoryPOM.sendDescription(Description);
		adminaddcategoryPOM.sendMetaTagTitle(MetaTagTitle);
		adminaddcategoryPOM.sendMetaDescription(MetaTagDescription);
		screenShot.captureScreenShot("GeneralTab");
		
				
		//Click on Save Icon**************
		adminaddcategoryPOM.ClickSaveIcon();
		screenShot.captureScreenShot("SaveSuccess");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		//Verify the Success Message
		String ExpectedMsg="Success: You have modified categories!";
		String ActualMsg= adminaddcategoryPOM.GetSuccessMsg();
		boolean check=ActualMsg.contains(ExpectedMsg);
		assertTrue(check);
		}
}
