package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerUpdatePage extends TestBasePage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "//div[@class='hor-scroll']/table[1]/tbody/tr[1]/td[12]/a")
    WebElement editLink;
    //ul[@id='customer_info_tabs']/li[4]/a/span
    //a[@id='customer_info_tabs_account']
    //span[text()='Account Information']
    @FindBy(xpath = "span[text()='Account Information']")
    WebElement accountInformationLink;
    @FindBy(xpath = "input[@name='account[taxvat]']")
    WebElement TaxVatNumberTextField;
    @FindBy(xpath = "span[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(linkText = "*[contains(text(),'The customer has been saved.')]")
    WebElement SuccessMessage;


    public CustomerUpdatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickEditLink() {
        utility.waitForElementPresent(editLink);
        editLink.click();
    }

    public void clickWithJSAccountLink() {
        utility.waitForElementPresent(accountInformationLink);

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", accountInformationLink);
        } catch (NoSuchElementException e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
        }
    }

    String TaxVatNum = ApplicationConfig.readConfigProperties(ConfigFile, "TaxVatNum");

    public void typeTaxVat() {
        utility.waitForElementPresent(TaxVatNumberTextField);
        TaxVatNumberTextField.sendKeys(TaxVatNum);
    }

    public void clickSaveCustomerButton() {
        utility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
    }

    public boolean displaySuccessMessage() {
        utility.waitForElementPresent(SuccessMessage);
        return SuccessMessage.isDisplayed();

    }


    public boolean updateCustomerInformation() {

        clickEditLink();
        clickWithJSAccountLink();
        typeTaxVat();
        clickSaveCustomerButton();
        return SuccessMessage.isDisplayed();
    }
}











//    WebDriver driver;
//    String ConfigFile = "config.properties";
//    TestUtility utility;
//    //span[text()='Account Information']
//    //a[@id='customer_info_tabs_customer_edit_tab_view']
//    //a[@id='customer_info_tabs_account']
//    //ul[@id="customer_info_tabs"]/li[4]
//    //ul[@id="customer_info_tabs"]/li[4]/a
//    @FindBy(xpath = "ul[@id=\"customer_info_tabs\"]/li[4]/a")
//    WebElement accountInformationLink;
//    @FindBy(xpath = "input[@name='account[taxvat]']")
//    WebElement TaxVatNumberTextField;
//    @FindBy(xpath = "span[text()='Save Customer']")
//    WebElement saveCustomerButton;
//    @FindBy(xpath = "*[contains(text(),'The customer has been saved.')]")
//    WebElement SuccessMessage;
//    @FindBy(xpath = "//option[contains(@value,'200')]")
//    WebElement Option200;
//
//    public CustomerUpdatePage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        utility = new TestUtility(driver);
//
//    }
//
//    public void selectOption() {
//        utility.waitForElementPresent(Option200);
//
//        Select viewDroplist = new Select(driver.findElement(By.name("limit")));
//
//        viewDroplist.selectByValue("200");
//
//    }
//
//    public void clickWithJSAccountLink() {
//        utility.waitForElementPresent(accountInformationLink);
//        jse.executeScript("window.scrollBy(0,1000)", accountInformationLink);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", accountInformationLink);
////        try {
////            accountInformationLink.click();
////        } catch (NoSuchElementException noSuchElementException){
////            System.out.println("Account Link");
////        }
//    }
//
//    public boolean displaySuccessMessage() {
//        utility.waitForElementPresent(SuccessMessage);
//        return SuccessMessage.isDisplayed();
//    }
//
//    String CustomerNAME = ApplicationConfig.readConfigProperties(ConfigFile, "customerName");
//    String TaxVatNum = ApplicationConfig.readConfigProperties(ConfigFile, "TaxVatNum");
//
//    public boolean updateCustomerInformation() {
//        selectOption();
//        List<WebElement> CustomerNameList = driver.findElements(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr"));
//        for (int i = 1; i <= CustomerNameList.size(); i++) {
////            WebDriverWait wait = new WebDriverWait(driver, 100);
////            WebElement CustomersName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr[\"+i+\"]/td[3]")));
//            //CustomersName.click();
//            WebElement CustomersName = driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr[" + i + "]/td[3]"));
//            if (CustomersName.getText().equals(CustomerNAME)) {
//                WebElement teamOneCheckBox = driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr[" + i + "]/td/input"));
//                teamOneCheckBox.click();
//                WebElement EditLink = driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr[" + i + "]/td[12]/a"));
//                EditLink.click();
//                clickWithJSAccountLink();
////                try {
////                    Thread.sleep(2000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//
//                utility.waitForElementPresent(TaxVatNumberTextField);
//                TaxVatNumberTextField.sendKeys(TaxVatNum);
//                saveCustomerButton.click();
//
//            }
//        }
//        return displaySuccessMessage();
//    }

