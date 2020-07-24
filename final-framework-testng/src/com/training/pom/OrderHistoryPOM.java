package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPOM {
	private WebDriver driver; 
	
	public OrderHistoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Order History
	@FindBy(xpath="//li[@class='dropdown myaccount']")
	private WebElement userIcon;
	
	@FindBy(linkText="Order History")
	private WebElement OrderHistory;
	
	@FindBy(xpath="//table/tbody/tr/td[1]")
	private WebElement OrderId;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	private WebElement Customer;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	private WebElement NoofProduct;
	
	@FindBy(xpath="//table/tbody/tr/td[4]")
	private WebElement Status;
	
	@FindBy(xpath="//table/tbody/tr/td[5]")
	private WebElement Total;
	
	@FindBy(xpath="//table/tbody/tr/td[6]")
	private WebElement DateAdded;
	
	@FindBy(xpath="//table/tbody/tr/td[7]/a")
	private WebElement ViewIcon;
	
	//After clicking View Icon
	
	@FindBy(xpath="//table[3]/tbody/tr")
	private WebElement OrderHistoryTable;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[1]")
	private WebElement productdetails;
	
		
	public void clickUserIcon() {
		this.userIcon.click(); 
	}
	
	public void clickOrderHistory() {
		this.OrderHistory.click(); 
	}
	
	public boolean OrderIdDisplayed() {
		return OrderId.isDisplayed();
	}
	public boolean CustomerDisplayed() {
		return Customer.isDisplayed();
	}
	public boolean NoofProductDisplayed() {
		return NoofProduct.isDisplayed();
	}
	public boolean StatusDisplayed() {
		return Status.isDisplayed();
	}
	public boolean TotalDisplayed() {
		return Total.isDisplayed();
	}
	public boolean DateAddedDisplayed() {
		return DateAdded.isDisplayed();
	}
	public void clickViewIcon() {
		this.ViewIcon.click(); 
	}
	//After clicking View 
	
	public boolean OrderHistoryTableDisplayed() {
		return OrderHistoryTable.isDisplayed();
	}
	public boolean ProductDetailsDisplayed() {
		return productdetails.isDisplayed();
	}
	
	
}
