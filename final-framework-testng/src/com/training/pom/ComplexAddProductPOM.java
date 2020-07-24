package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplexAddProductPOM {
	private WebDriver driver; 
	
	public ComplexAddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Logging as Admin
	@FindBy(id="input-username")
	private WebElement userName; 
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Catalogue
		
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement CatalogueIcon;
	public void MouseOverCatalogueIcon()
	{
		Actions action =new Actions(driver);
		action.moveToElement(CatalogueIcon).build().perform();
	}
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement Products;
	public void MouseOverProducts()
	{
		Actions action =new Actions(driver);
		action.moveToElement(Products).click().build().perform();
	}
	@FindBy(xpath="//div[@class='panel panel-default']")
	private WebElement ProductsPanel;
	public boolean ProductsPanelIsDisplayed()
	{
		return ProductsPanel.isDisplayed();
	}
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement AddNewIcon;
	public void ClickAddNewIcon()
	{
		AddNewIcon.click();
	}
	
	//***********General Tab*******
	
	@FindBy(xpath="//div[@class='panel panel-default']")
	private WebElement AddProductPanel;
	public boolean AddProductIsDisplayed()
	{
		return AddProductPanel.isDisplayed();
	}
	@FindBy(id="input-name1")
	private WebElement ProductName;
	public void sendProductName(String Name)
	{
		ProductName.sendKeys(Name);
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTitle;
	public void sendMetaTitle(String Title)
	{
		MetaTitle.sendKeys(Title);
	}
	
	//***********Data Tab*******
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement DataTab;
	public void ClickDataTab()
	{
		DataTab.click();
	}
	
	@FindBy(id="input-model")
	private WebElement Model;
	public void sendModel(String Model)
	{
		this.Model.sendKeys(Model);
	}
	
	@FindBy(id="input-price")
	private WebElement Price;
	public void sendPrice(String Price)
	{
		this.Price.sendKeys(Price);
	}
	
	@FindBy(id="input-quantity")
	private WebElement Quantity;
	public void sendQuantity(String Quantity)
	{
		this.Quantity.clear();
		this.Quantity.sendKeys(Quantity);
	}
	
	//***********Links Tab*******
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement LinksTab;
	public void ClickLinksTab()
	{
		LinksTab.click();
	}
	
	@FindBy(id="input-category")
	private WebElement Category;
	@FindBy(xpath="//input[@id='input-category']/following-sibling::ul//li[2]//a")
	private WebElement Uniform;
	public void selectCategory(String Category)
	{
		//Select sel = new Select(this.Category);
		Actions action =new Actions(driver);
		action.moveToElement(this.Category).click().build().perform();
		action.moveToElement(Uniform).click().build().perform();
	}
	
					
			//Click on Save Icon**************
			@FindBy(xpath="//button[@type='submit']")
			private WebElement SaveIcon;
			public void ClickSaveIcon()
			{
				SaveIcon.click();
			}
			
			//Verify the Success Message
			@FindBy(xpath="//div[@class='alert alert-success']")
			private WebElement SuccessMsg;
			public String GetSuccessMsg()
			{
				return SuccessMsg.getText();
			}
			//Success: You have modified products!
			
			//Logout
			@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
			private WebElement Logout;
			public void Logout()
			{
				Logout.click();
			}
			
}
