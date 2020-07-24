package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPOM {
	private WebDriver driver; 
	
	public RecoverPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement LoginLink;
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Forgotten Password')]")
	private WebElement ForgottenPassword;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(xpath="//input[(@type='submit')]")
	private WebElement Continue;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement MsgText;
	
	//Defining functions for the Fields on Forgotten Page
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void clickonLogin()
	{
		LoginLink.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickForgottenPassword() {
		this.ForgottenPassword.click();
	}
	
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickContinueBtn() {
		this.Continue.click(); 
	}
		
	public String alertmsgtext() {
		String msgtext =MsgText.getText();
		return msgtext;
	}
		
		
}

