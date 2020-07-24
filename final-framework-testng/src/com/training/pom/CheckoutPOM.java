package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPOM {
	private WebDriver driver; 
	
	public CheckoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="collapse-payment-address")
	private WebElement BillingDetailsPanel;
	
	@FindBy(id="button-payment-address")
	private WebElement BillingContinue;
	
	@FindBy(id="collapse-shipping-address")
	private WebElement DeliveryDetailsPanel; 
	
	@FindBy(id="button-shipping-address")
	private WebElement DeliveryContinue;
	
	@FindBy(name="shipping_method")
	private WebElement FreeDeliveryRadio; 
	
	@FindBy(name="comment")
	private WebElement AboutOrderTextArea;
	
	@FindBy(id="button-shipping-method")
	private WebElement DeliveryMethodContinue;
	
	@FindBy(name="agree")
	public WebElement ReadAgreeCheck;
	
	@FindBy(id="button-payment-method")
	private WebElement PaymentContinue;
	
	@FindBy(id="collapse-checkout-confirm")
	private WebElement CheckoutConfirm;
	
	@FindBy(id ="button-confirm")
	private WebElement confirmbutton;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement OrderPlacedMsg;
	
	public boolean BillingDetailPanelIsDisplayed()
	{
		return BillingDetailsPanel.isDisplayed();
	}
	public void clickBillingContinue()
	{
		BillingContinue.click();
	}
	public boolean DeliveryDetailPanelIsDisplayed()
	{
		return DeliveryDetailsPanel.isDisplayed();
	}
	public void clickDeliveryContinue()
	{
		DeliveryContinue.click();
	}
	public boolean FreeDeliveryIsChecked()
	{
		return FreeDeliveryRadio.isSelected();
	}
	
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
	public void clickDeliveryMethodContinue()
	{
		DeliveryMethodContinue.click();
	}
	
	public void CheckReadAgree() {
		ReadAgreeCheck.click(); 
	}
	public void clickPaymentMethodContinue()
	{
		PaymentContinue.click();
	}
	
	public boolean CheckoutConfirmPanelIsDisplayed()
	{
		return CheckoutConfirm.isDisplayed();
	}
	public void clickConfirmbutton()
	{
		confirmbutton.click();
	}
	
	public String OrderPlacedMsg()
	{
		return OrderPlacedMsg.getText();
	}
}
