package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerUpdatePage {
    WebDriver driver;
    String ConfigFile="config.properties";
    TestUtility utility;
    @FindBy(xpath= "a[@id='customer_info_tabs_account']")  ////input[@name="account[taxvat]"]
    WebElement accountInformationLink;
    @FindBy(xpath = "input[@name='account[taxvat]']")
    WebElement TaxVatNumberTextField;
    @FindBy(xpath = "span[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(linkText = "span[text()='The customer has been saved.")
    WebElement SuccessMessage;
    public CustomerUpdatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickAccountInformationLink(){
        utility.waitForElementPresent(accountInformationLink);
    }

    String CustomerNAME = ApplicationConfig.readConfigProperties(ConfigFile, "customerName");
    String TaxVatNum=ApplicationConfig.readConfigProperties(ConfigFile,"TaxVatNum");

    public boolean updateCustomerInformation() {
        List<WebElement> CustomerNameList = driver.findElements(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr"));
        for (int i = 1; i <=CustomerNameList.size(); i++) {
            WebElement CustomersName=driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr["+i+"]/td[3]"));
            if(CustomersName.getText().equals(CustomerNAME)){
                WebElement teamOneCheckBox=driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr["+i+"]/td/input"));
                teamOneCheckBox.click();
                WebElement EditLink=driver.findElement(By.xpath("//div[@class='hor-scroll']/table[1]/tbody/tr["+i+"]/td[12]/a"));
                EditLink.click();
                clickAccountInformationLink();
                utility.waitForElementPresent(TaxVatNumberTextField);
                TaxVatNumberTextField.sendKeys(TaxVatNum);
                saveCustomerButton.click();
                Alert alert=driver.switchTo().alert();
                alert.accept();
            }
        }
        return SuccessMessage.isDisplayed();
    }
}
