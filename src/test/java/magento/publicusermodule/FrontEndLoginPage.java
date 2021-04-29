package magento.publicusermodule;

import configutiity.ApplicationConfig;
import magento.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndLoginPage {
    WebDriver driver;
    String configFile="config.properties";
    TestUtility utility;
    @FindBy(name="login[username]")
    WebElement emailAddressField;
    @FindBy(id="pass")
    WebElement passwordField;
    @FindBy(name = "send")
    WebElement loginbutton;
//    @FindBy(xpath = "a[@class='label']")
//    WebElement accountDropDownList;
//    @FindBy(xpath = "a[@title=\"My Account\"]")
//    WebElement myAccountLink;
//    @FindBy(xpath = "a[@title=\"My Wishlist\"]")
//    WebElement myWishListLink;
//    @FindBy(xpath = "a[@title=\"My Cart\"]")
//    WebElement myCartLink;
//    @FindBy(xpath = "a[@title=\"Checkout\"]")
//    WebElement checkOutLink;
//    @FindBy(xpath = "//a[@title=\"Register\"]")
//    WebElement registerLink;
//    @FindBy(xpath = "//a[@title=\"Log In\"]")
//    WebElement loginLink;

    public FrontEndLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    public void  enterEmail(String EmailAddress){
        utility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(EmailAddress);
    }
    public void  enterPassword(String Password){
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(Password);
    }
    public void  clickloginbutton(){
        utility.waitForElementPresent(loginbutton);
        loginbutton.click();
    }
    public void LoginforUser(){
        enterEmail(ApplicationConfig.readConfigProperties(configFile,"EmailPrefix"));
        enterPassword(ApplicationConfig.readConfigProperties(configFile,"PasswordPrefix"));
        clickloginbutton();
    }
    
}

