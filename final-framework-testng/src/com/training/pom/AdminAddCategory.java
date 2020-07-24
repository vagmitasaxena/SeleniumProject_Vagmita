package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddCategory {
	private WebDriver driver; 
	
	public AdminAddCategory(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement Categories;
	public void MouseOverCategories()
	{
		Actions action =new Actions(driver);
		action.moveToElement(Categories).click().build().perform();
	}
	@FindBy(xpath="//div[@class='panel panel-default']")
	private WebElement CategoriesPanel;
	public boolean CategoriesPanelIsDisplayed()
	{
		return CategoriesPanel.isDisplayed();
	}
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement AddNewIcon;
	public void ClickAddNewIcon()
	{
		AddNewIcon.click();
	}
	
	//***********General Tab*******
	
	@FindBy(xpath="//div[@class='panel panel-default']")
	private WebElement AddCategoryPanel;
	public boolean AddCategoryIsDisplayed()
	{
		return AddCategoryPanel.isDisplayed();
	}
	@FindBy(id="input-name1")
	private WebElement CategoryName;
	public void sendCategoryName(String Name)
	{
		CategoryName.sendKeys(Name);
	}
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement Description;
	public void sendDescription(String Description)
	{
		this.Description.sendKeys(Description);
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle;
	public void sendMetaTagTitle(String Title)
	{
		MetaTagTitle.sendKeys(Title);
	}
	
	@FindBy(id="input-meta-description1")
	private WebElement MetaTitleDescription;
	public void sendMetaDescription(String Title)
	{
		MetaTitleDescription.sendKeys(Title);
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
			//Success: You have modified categories!           
			
}
