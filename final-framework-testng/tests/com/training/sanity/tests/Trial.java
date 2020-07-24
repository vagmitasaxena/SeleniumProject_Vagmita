/*package com.training.sanity.tests;

public class Trial {
	
	Simple test case 1:
	package com.training.sanity.tests;
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
	import com.training.pom.LoginPOM1;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;
	public class SimpleTC1 {
	 
	    private WebDriver driver;
	    private String baseUrl;
	    private LoginPOM1 loginPOM1;
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
	        loginPOM1 = new LoginPOM1(driver);
	        baseUrl = properties.getProperty("baseURL");
	        screenShot = new ScreenShot(driver);
	        // launching the application
	        driver.get(baseUrl);
	    }
	    
	    @AfterMethod
	    public void tearDown() throws Exception {
	        Thread.sleep(1000);
	        //driver.quit();
	    }
	    
	    @Test
	    public void validLoginTest() throws InterruptedException {
	        loginPOM1.sendCustomerName("admin");
	        loginPOM1.sendPassword("admin@123");
	        //Customer name and password is supplied to the text boxes
	        Thread.sleep(1000);
	        String actualCustomername=loginPOM1.getCustomeName();
	        String expectedUsername="admin";
	        //Validate if entered Customer name is getting displayed in Customername textbox
	        Assert.assertEquals(actualCustomername, expectedUsername);
	        String actualPassword=loginPOM1.getPassword();
	        String expectedPassword="admin@123";
	        //Validate if entered password is getting displayed in password textbox
	        Assert.assertEquals(actualPassword, expectedPassword);
	        //below method clicks the login
	        loginPOM1.clickLogin();
	        screenShot.captureScreenShot("Login_Success");
	        loginPOM1.catalogue();
	        loginPOM1.selectcategory();
	           screenShot.captureScreenShot("Capturing Catalogue");
	           loginPOM1.selectCatalogue();
	           loginPOM1.deleteCatalogue();
	           
	    }
	 
	}

	----------------
	Login POM file:
	package com.training.pom;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	public class LoginPOM1 {
	private WebDriver driver;
	    
	    public LoginPOM1(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(id="input-username")
	    private WebElement customerName;
	    
	    @FindBy(id="input-password")
	    private WebElement password;
	    
	    @FindBy(xpath="//button[@type='submit']")    
	    private WebElement login;
	    
	    @FindBy(xpath="//*[@class='fa fa-tags fw']")
	    private WebElement catlog;
	    
	    @FindBy(xpath="//a[text()='Categories']")
	    private WebElement categories;
	    
	    @FindBy(xpath="//input[@type='checkbox'][@value='665']")
	    private WebElement catalogueCheck;
	    
	    @FindBy(xpath="//button[@class='btn btn-danger']")
	    private WebElement deleteCatalogue;
	    
	    
	    
	    public void sendCustomerName(String customerName) {
	        this.customerName.clear();
	        this.customerName.sendKeys(customerName);
	    }
	    
	    public String getCustomeName() {
	        return this.customerName.getAttribute("value");
	    }
	    
	    public String getPassword() {
	        return this.password.getAttribute("value");
	    }
	    
	    public void sendPassword(String password) {
	        this.password.clear();
	        this.password.sendKeys(password);
	    }
	    
	    public void clickLogin() {
	        this.login.click();
	    }
	    public void catalogue() {
	        Actions act=new Actions(driver);
	        act.moveToElement(catlog).build().perform();
	    }
	    
	    public String catalogueCheck() {
	        return this.categories.getText();
	    }
	    
	    public void selectcategory() {
	        this.categories.click();
	        
	    }
	    public void selectCatalogue() {
	        this.catalogueCheck.click();
	     }
	   public void deleteCatalogue() {
	        this.deleteCatalogue.click();
	        
	   Alert popupHandle=driver.switchTo().alert();
	        popupHandle.accept();    
	    }
	}
	 

}
*/