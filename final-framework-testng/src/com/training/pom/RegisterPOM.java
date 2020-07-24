package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Defining the Locators
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	private WebElement registerLink;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone; 
	
	@FindBy(id="input-fax")
	private WebElement fax; 
	
	@FindBy(id="input-company")
	private WebElement company; 
	
	@FindBy(id="input-address-1")
	private WebElement address1; 
	
	@FindBy(id="input-address-2")
	private WebElement address2; 
	
	@FindBy(id="input-city")
	private WebElement city; 
	
	@FindBy(id="input-postcode")
	private WebElement postcode; 
	
	@FindBy(name="country_id")
	private WebElement Country;
	
	@FindBy(id="input-zone")
	private WebElement state;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement passwordconfirm;
	
	@FindBy(name="newsletter")
	private List<WebElement> subscribe;
	
	@FindBy(name="agree")
	private WebElement policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Continue;
	
	@FindBy(xpath="//*[@id=\"content\"]/p[1]")
	private WebElement MsgText;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errorMsgText1;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement errorMsgText2;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement Continuebutton;
	
		
	//Defining functions for the Fields on Register Page
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void clickonRegister()
	{
		registerLink.click();
	}
	
	public void sendfirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void sendlastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendtelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void sendfax(String fax) {
		this.fax.clear();
		this.fax.sendKeys(fax);
	}
	
	public void sendcompany(String company) {
		this.company.clear();
		this.company.sendKeys(company);
	}
	
	public void sendaddress1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	public void sendaddress2(String address2) {
		this.address2.clear();
		this.address2.sendKeys(address2);
	}
	
	public void sendcity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void sendpostcode(String postcode) {
		this.postcode.clear();
		this.postcode.sendKeys(postcode);
	}
	
	public void selectCountry(String Country) {
		Select sel = new Select(this.Country);
		sel.selectByVisibleText(Country);
	}
	
	public void selectState(String State) {
		Select sel1 = new Select(this.state);
		sel1.selectByVisibleText(State);
	}
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void confirmPassword(String password1) {
		this.passwordconfirm.clear();
		this.passwordconfirm.sendKeys(password1);
	}
	
	public void clickSubscribe() {
		subscribe.get(1).click(); //Clicking on NO for Subscribe
	}
	
	public void checkprivacypolicy() {
		policy.click();
	}
	
	public void clickContinueBtn()
	{
		Continue.click();
	}
	
	public String alertmsgtext() {
		String msgtext =MsgText.getText();
		return msgtext;
	}
	
	public String errormsgtext() {
		String errormsgtext =MsgText.getText();
		return errormsgtext;
	}
	
	public boolean ContinueDisplayed() {
		return Continuebutton.isDisplayed();
		 
	}
	
}
