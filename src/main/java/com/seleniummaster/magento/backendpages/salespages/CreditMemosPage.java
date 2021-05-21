package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreditMemosPage {
    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";

    //Sales Manager should be able to view and add  credit memos
    @FindBy(xpath = "//table[@class=\"data\"]/tbody/tr")
    List <WebElement> CreditMemosList;

    public CreditMemosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public boolean viewCreditMemos(){
        for (int i=1;i<=CreditMemosList.size();i++){
            if (i>=1){
                System.out.println("test past");
            }
        }
        return true;
    }

    //Sales Manager should be able to view creditmemos by filters and change
    // columns to display and export)

    @FindBy(xpath = "//span[text()=\"Order Date\"]")
    WebElement OrderDateLink;
    @FindBy(xpath = "//select[@name=\"sales_creditmemo_grid_export\"]")
    WebElement ExportToDropDownList;
    @FindBy(xpath = "//span[text()=\"Export\"]")
    WebElement ExportButton;



}
