package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopUniformPOM {
private WebDriver driver; 
	
		
	public ShopUniformPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='banner1']")
	private WebElement imgPremiumUniform;
	
	@FindBy(xpath="//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement Frame;
	
	@FindBy(xpath="//*[@id=\"featured-grid\"]/div[2]/div/div/div[2]/div[2]/button[1]/span")
	private WebElement AddToCart;
	
	
	
	@FindBy(xpath="//select[@id='input-option376']")
	private WebElement ChestSize; 
	
	@FindBy(id="button-cart")
	private WebElement AddToCartbutton;
	
	@FindBy(xpath="//div[@class ='alert alert-success']")
	private WebElement Successmsg;
	
	@FindBy(id="cart")
	private WebElement CartIcon;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	private WebElement ViewCart;
	
	@FindBy(linkText="Checkout")
	private WebElement Checkout;
	
	@FindBy(name="email")
	private WebElement Username;
	
	@FindBy(name="password")
	private WebElement Password;
	
	public void clickonShopUniform()
	{
		Actions action = new Actions(driver);
		 
        action.moveToElement(imgPremiumUniform).build().perform(); 
        imgPremiumUniform.click();
	}
	public void AddToCart()
	{	
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Frame);
		Actions action = new Actions(driver);
		 action.moveToElement(Frame).build().perform(); 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(AddToCart, "ADD TO CART"));
				
        AddToCart.click();
	}
	public void selectChestSize(String Size) {
		Select sel = new Select(this.ChestSize);
		sel.selectByVisibleText(Size);
	}
	
	public void ClickAddToCart()
	{
		AddToCartbutton.click();
	}
	
	public String SuccessMsg()
	{
		return Successmsg.getText();
	}
	
	public void ClickCartIcon()
	{
		CartIcon.click();
	}
	public void ClickViewCart()
	{
		ViewCart.click();
	}
	//To verify View Cart Page Objects
	
	@FindBy(xpath="//div[@id='content']//tbody//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement thumbnailimg;
	
	public boolean thumbnailimgDisplayed()
	{
		return thumbnailimg.isDisplayed();
	}
	
	@FindBy(linkText="REGULAR T-SHIRTS (Rust)")
	private WebElement ProductName;
	
	public boolean ProductNameDisplayed()
	{
		return ProductName.isDisplayed();
	}
	
	@FindBy(xpath="//td[contains(text(),'TBSW-Nur-8th')]")
	private WebElement Model;
	public boolean ModelDisplayed()
	{
		return Model.isDisplayed();
	}
	@FindBy(xpath="//div[@id='content']//tbody//td[4]//input")
	private WebElement Quantity;
	public boolean QuantityDisplayed()
	{
		return Quantity.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")
	private WebElement UnitPrice;
	public boolean UnitPriceDisplayed()
	{
		return UnitPrice.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")
	private WebElement Total;
	public boolean TotalDisplayed()
	{
		return Total.isDisplayed();
	}
	
	//Click on Checkout
	public void ClickCheckout()
	{
		Checkout.click();
	}
	
	public boolean UsernameIsDisplayed()
	{
		return Username.isDisplayed();
	}
	public boolean PasswordIsDisplayed()
	{
		return Password.isDisplayed();
	}
	
}

