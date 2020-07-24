package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPOM {
	private WebDriver driver; 
	
	public EditAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*//a[contains(text(),'Edit Account')]")
	private WebElement EditAccount;
	
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
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Continue;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement MsgText;
	
	
	public void clickEditAccount()
	{
		EditAccount.click();
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
	
	public void clickContinueBtn() {
		this.Continue.click(); 
	}
	
	public String alertmsgtext() {
		String msgtext =MsgText.getText();
		return msgtext;
	}
}
