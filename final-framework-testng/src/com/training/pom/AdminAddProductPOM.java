package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddProductPOM {
	private WebDriver driver; 
	
	public AdminAddProductPOM(WebDriver driver) {
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
	
	//***********Discount Tab*******
	
		@FindBy(xpath="//a[contains(text(),'Discount')]")
		private WebElement DiscountTab;
		public void ClickDiscountTab()
		{
			DiscountTab.click();
		}
		
		@FindBy(xpath="//button[@onclick='addDiscount();']")
		private WebElement AddDiscountIcon;
		public void ClickAddDiscountIcon()
		{
			Actions action =new Actions(driver);
			action.moveToElement(this.AddDiscountIcon).click().build().perform();
		}
		
		
		@FindBy(name="product_discount[0][quantity]")
		private WebElement DisQuantity;
		public void sendDisQuantity(String Quantity)
		{
			this.DisQuantity.sendKeys(Quantity);
		}
		@FindBy(xpath="//input[@name='product_discount[0][price]']")
		private WebElement DisPrice;
		public void sendDisPrice(String Price)
		{
			this.DisPrice.sendKeys(Price);
		}
		
		@FindBy(xpath="//input[@name='product_discount[0][date_start]']/following-sibling::span//button//i")
		private WebElement StartDateWidget;
		@FindBy(xpath="//div[@class='datepicker']//tbody//tr[1]//td[@class='day active today']")
		public WebElement StartDate;
		public void selectStartDate()
		{
			StartDateWidget.click();
			Actions action =new Actions(driver);
			action.moveToElement(this.StartDate).click().build().perform();
			
			//StartDate.click();
		}
		@FindBy(xpath="//input[@name='product_discount[0][date_end]']/following-sibling::span//button//i")
		private WebElement EndDateWidget;
		//@FindBy(xpath="//div[@class='datepicker']//tbody//tr[1]//td[@class='day active today']/following-sibling::td")
		@FindBy(xpath="/html/body/div[6]/div/div[1]/table/tbody/tr[1]/td[7]")
		public WebElement EndDate;
		
		
		public void selectEndDate() throws InterruptedException
		{
			EndDateWidget.click();
			
			Thread.sleep(2000);
			Actions action =new Actions(driver);
			//WebElement EndDate=driver.findElement(By.cssSelector("button[datepicker-years='2019'][datepicker-months='07'][datepicker-days='06']"));
			action.moveToElement(EndDate).doubleClick().build().perform();
		}
		
		//***********Reward Points Tab*******
		
			
			@FindBy(xpath="//div[@class='panel-body']//form//ul/li[10]")
			private WebElement RewardPointsTab;
			public void ClickRewardPointsTab() throws InterruptedException
			{
				RewardPointsTab.click();
				
			}
			@FindBy(id="input-points")
			private WebElement Points;
			public void sendPoints(String Points)
			{
				this.Points.sendKeys(Points);
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
			
}
