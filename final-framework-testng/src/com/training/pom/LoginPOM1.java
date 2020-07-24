package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPOM1 {
private WebDriver driver;
    
    public LoginPOM1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id="input-username")
    private WebElement customerName;
    
    @FindBy(id="input-password")
    private WebElement password;
    
    @FindBy(xpath="//button[@type='submit']")    
    private WebElement login;
    
    @FindBy(xpath="//*[@class='fa fa-tags fw']")
    private WebElement catlog;
    
    @FindBy(xpath="//a[text()='Categories']")
    private WebElement categories;
    
    @FindBy(xpath="//input[@type='checkbox'][@value='665']")
    private WebElement catalogueCheck;
    
    @FindBy(xpath="//button[@class='btn btn-danger']")
    private WebElement deleteCatalogue;
    
    
    
    public void sendCustomerName(String customerName) {
        this.customerName.clear();
        this.customerName.sendKeys(customerName);
    }
    
    public String getCustomeName() {
        return this.customerName.getAttribute("value");
    }
    
    public String getPassword() {
        return this.password.getAttribute("value");
    }
    
    public void sendPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }
    
    public void clickLogin() {
        this.login.click();
    }
    public void catalogue() {
        Actions act=new Actions(driver);
        act.moveToElement(catlog).build().perform();
    }
    
    public String catalogueCheck() {
        return this.categories.getText();
    }
    
    public void selectcategory() {
        this.categories.click();
        
    }
    public void selectCatalogue() {
        this.catalogueCheck.click();
     }
   public void deleteCatalogue() {
        this.deleteCatalogue.click();
        
   Alert popupHandle=driver.switchTo().alert();
        popupHandle.accept();    
    }
}