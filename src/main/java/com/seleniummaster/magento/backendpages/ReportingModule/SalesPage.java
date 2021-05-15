package com.seleniummaster.magento.backendpages.ReportingModule;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;

    @FindBy(css = "input[title='From'][type='text']")
    WebElement fromTextBox;
    @FindBy(css = "input[title='To'][type='text']")
    WebElement toTextBox;

    @FindBy(xpath = "//h3[text()='Total Ordered Report']")
    WebElement totalOrderedReportSuccessMassage;
    @FindBy(xpath = "//h3[text()='Order Taxes Report Grouped by Tax Rate']")
    WebElement orderTaxesReportGroupedByTaxRate;
    @FindBy(xpath = "//h3[text()='Total Invoiced vs. Paid Report']")
    WebElement totalInvoicedVsPaidReport;
    @FindBy(xpath = "//h3[text()='Total Shipped Report']")
    WebElement totalShippedReport;
    @FindBy(xpath = "//h3[text()='Total Refunded Report']")
    WebElement totalRefundedReport;
    @FindBy(xpath = "//h3[text()='Coupons Usage Report']")
    WebElement couponsUsageReport;






    public SalesPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickFromTextBox(){
        utility.waitForElementPresent(fromTextBox);
        fromTextBox.sendKeys(prop.getProperty("fromDate"));
        Log.info("From DAte entered");
    }
    public void clickToTextBox(){
        utility.waitForElementPresent(toTextBox);
        toTextBox.sendKeys(prop.getProperty("toDate"));
        Log.info("To Date Entered");
    }

    public void verifyTotalOrderedReportSuccessMassage(){
        utility.waitForElementPresent(totalOrderedReportSuccessMassage);
        totalOrderedReportSuccessMassage.isDisplayed();
    }
    public void verifyOrderTaxesReportGroupedByTaxRate(){
        utility.waitForElementPresent(orderTaxesReportGroupedByTaxRate);
        orderTaxesReportGroupedByTaxRate.isDisplayed();
    }
    public void verifyTotalInvoicedVsPaidReport(){
        utility.waitForElementPresent(totalInvoicedVsPaidReport);
        totalInvoicedVsPaidReport.isDisplayed();
    }
    public void verifyTotalShippedReport(){
        utility.waitForElementPresent(totalShippedReport);
        totalShippedReport.isDisplayed();
    }
    public void verifyTotalRefundedReport(){
        utility.waitForElementPresent(totalRefundedReport);
        totalRefundedReport.isDisplayed();
    }
    public void verifyCouponsUsageReport(){
        utility.waitForElementPresent(couponsUsageReport);
        couponsUsageReport.isDisplayed();
    }



    public void totalOrderedReport(){

        clickFromTextBox();
        clickToTextBox();



    }
}
