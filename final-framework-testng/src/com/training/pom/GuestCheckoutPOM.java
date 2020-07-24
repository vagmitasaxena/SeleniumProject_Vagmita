package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GuestCheckoutPOM {
	private WebDriver driver; 
	
	public GuestCheckoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Checkout Options Panel
	@FindBy(xpath="//div[@id='collapse-checkout-option']")
	private WebElement CheckoutOptionsPanel;
	public boolean CheckoutOptionsPanelIsDisplayed()
	{
		return CheckoutOptionsPanel.isDisplayed();
	}
	
	@FindBy(xpath="//input[@value='guest' and @type='radio']")
	private WebElement GuestRadio;
	public void clickGuestRadio() throws InterruptedException {
		GuestRadio.click();
	}
	
	@FindBy(id="button-account")
	private WebElement Continue;
	public void clickContinue() {
		Continue.click();
	}
	
	//BILLING DETAILS PANEL
	
	@FindBy(id="collapse-payment-address")
	private WebElement BillingDetailsPanel; 
	public boolean BillingDetailPanelIsDisplayed()
	{
		return BillingDetailsPanel.isDisplayed();
	}
	
	@FindBy(id="input-payment-firstname")
	private WebElement Firstname; 
	public void sendFirstname(String Firstname) {
		this.Firstname.sendKeys(Firstname);
	}
	
	@FindBy(id="input-payment-lastname")
	private WebElement Lastname;
	public void sendLastname(String Lastname) {
		this.Lastname.sendKeys(Lastname);
	}
	
	@FindBy(id="input-payment-email")
	private WebElement Email; 
	public void sendEmail(String Email) {
		this.Email.sendKeys(Email);
	}
	
	@FindBy(id="input-payment-telephone")
	private WebElement Telephone;
	public void sendTelephone(String Telephone) {
		this.Telephone.sendKeys(Telephone);
	}
	
	@FindBy(id="input-payment-company")
	private WebElement Company;
	public void sendCompany(String Company) {
		this.Company.sendKeys(Company);
	}
	
	@FindBy(id="input-payment-address-1")
	private WebElement Address;
	public void sendAddress(String Address) {
		this.Address.sendKeys(Address);
	}
	
	@FindBy(id="input-payment-city")
	private WebElement City;
	public void sendCity(String City) {
		this.City.sendKeys(City);
	}
	
	@FindBy(id="input-payment-postcode")
	private WebElement Postcode;
	public void sendPostcode(String Postcode) {
		this.Postcode.sendKeys(Postcode);
	}
	
	@FindBy(id="input-payment-country")
	private WebElement Country;
	public void sendCountry(String Country) {
		Select sel=new Select(this.Country);
		sel.selectByVisibleText(Country);
	}
	
	@FindBy(id="input-payment-zone")
	private WebElement Region;
	public void sendRegion(String Region) {
		Select sel1=new Select(this.Region);
		sel1.selectByVisibleText(Region);
	}
	
	@FindBy(id="button-guest")
	private WebElement GuestContinue;
	public void clickGuestContinue()
	{
		GuestContinue.click();
	}
	
	//DELIVERY METHOD ***********************
	@FindBy(id="collapse-shipping-method")
	private WebElement DeliveryMethodPanel; 
	@FindBy(xpath="//div[@id='collapse-shipping-method']//div//p")
	private WebElement PanelHeading;
	public boolean DeliveryMethodPanelIsDisplayed()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",PanelHeading );
		
		return DeliveryMethodPanel.isDisplayed();
	}
	
	@FindBy(name="shipping_method")
	private WebElement FreeDeliveryRadio; 
	public boolean FreeDeliveryIsChecked()
	{
		return FreeDeliveryRadio.isSelected();
	}
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement AboutOrderTextArea;
	public boolean AboutOrderIsDisplayed()
	{
		return AboutOrderTextArea.isDisplayed();
	}
	
	public void sendAboutOrder(String Details) {
		this.AboutOrderTextArea.clear();
		this.AboutOrderTextArea.sendKeys(Details);
	}
	public String AboutOrderVerification()
	{
		String Actual = AboutOrderTextArea.getAttribute("value");
		return Actual;
	}
	
	@FindBy(id="button-shipping-method")
	private WebElement DeliveryMethodContinue;
	public void clickDeliveryMethodContinue()
	{
		DeliveryMethodContinue.click();
	}
	
	@FindBy(name="agree")
	public WebElement ReadAgreeCheck;
	public void CheckReadAgree() {
		ReadAgreeCheck.click(); 
	}
	
	@FindBy(id="button-payment-method")
	private WebElement PaymentContinue;
	public void clickPaymentMethodContinue()
	{
		PaymentContinue.click();
	}
		
	@FindBy(id="collapse-checkout-confirm")
	private WebElement CheckoutConfirm;
	public boolean CheckoutConfirmPanelIsDisplayed()
	{
		return CheckoutConfirm.isDisplayed();
	}
	
	@FindBy(id ="button-confirm")
	private WebElement confirmbutton;
	public void clickConfirmbutton()
	{
		confirmbutton.click();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement OrderPlacedMsg;
	public String OrderPlacedMsg()
	{
		return OrderPlacedMsg.getText();
	}
	
	
}
