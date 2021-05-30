package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StoreViewPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";
    @FindBy(xpath = "(//span[text()='System'])[1]")
    WebElement SystemButton;
    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement CreateStoreViewButton;
    @FindBy(xpath = "//select[@id=\"store_group_id\"]")
    WebElement StoreDropdown;
    @FindBy(xpath = "//input[@id=\"store_name\"]")
    WebElement NameTextBox;
    @FindBy(xpath = "//input[@id=\"store_code\"]")
    WebElement CodeTextBox;
    @FindBy(xpath = "//select[@id=\"store_is_active\"]")
    WebElement StatusDropdown;
    @FindBy(xpath = "(//span[text()='Save Store View'])[1]")
    WebElement SaveStoreViewButton;
    @FindBy(xpath = "//span[text()=\"The store view has been saved\"]")
    WebElement ConfirmationMessage;

    public StoreViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void selectStore() {
        utility.waitForElementPresent(StoreDropdown);
        Select StoreDropDownList=new Select(StoreDropdown);
        StoreDropDownList.selectByValue("94");
    }
    String Name= ApplicationConfig.readConfigProperties(ConfigFile,"Name");
    public void enterName(String Name) {
        utility.waitForElementPresent(NameTextBox);
        NameTextBox.sendKeys(Name);
    }
    String Code= ApplicationConfig.readConfigProperties(ConfigFile,"Code");
    public void enterCode(String Code) {
        utility.waitForElementPresent(CodeTextBox);
        CodeTextBox.sendKeys(Code);
    }
    public void selectStatus() {
        utility.waitForElementPresent(StatusDropdown);
        Select StatusDropdownList= new Select(StatusDropdown);
        StatusDropdownList.selectByValue("1");
    }
    public void clickSaveStoreViewButton() {
        utility.waitForElementPresent(SaveStoreViewButton);
        SaveStoreViewButton.click();
    }
    public boolean verifySuccess(){
        utility.waitForElementPresent(ConfirmationMessage);
        return ConfirmationMessage.isDisplayed();
    }
    public void createStoreView(){
        selectStore();
        enterName(prop.getProperty("Name"));
        enterCode(prop.getProperty("Code")+System.currentTimeMillis());
        selectStatus();
        clickSaveStoreViewButton();
        verifySuccess();
    }
    //Store Manager can edit a store view
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[3]/div/table/tbody/tr[1]/td[3]/a")
    WebElement StoreViewName;
    @FindBy(xpath = "//td[@class=\"a-left last\"][\"+i+\"]")
    List<WebElement> storeViewList;
    public void editStoreView() {
        StoreViewName.click();
        selectStatus();
        clickSaveStoreViewButton();
        verifySuccess();
        verifySuccess();
    }
//    public boolean editStoreView() {
//        String StoreViewNAME = ApplicationConfig.readConfigProperties(ConfigFile, "Name");
////            JavascriptExecutor js = (JavascriptExecutor) driver;
////            js.executeScript("window.scrollBy(0,1000)");
//            for (int i = 1; i <= storeViewList.size(); i++) {
//                utility.sleep(3);
//                WebElement StoreviewName = driver.findElement(By.xpath("//td[@class=\"a-left last\"][\"+i+\"]/a"));
//                if ( StoreviewName.getText().contains(StoreViewNAME)) {
//                    StoreviewName.click();
//                    utility.sleep(3);
//                    selectStatus();
//                    clickSaveStoreViewButton();
//                    verifySuccess();
//
//                }
//
//            }
//
//            return verifySuccess();
//
//        }


        //Store Manager can view all stores
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr")
        List<WebElement> orderList;
    public boolean viewOrder(){
        for (int i=1;i<=orderList.size();i++){
            if (i>=1){
                System.out.println("test past");
            }
        }
        return true;
    }
    }



