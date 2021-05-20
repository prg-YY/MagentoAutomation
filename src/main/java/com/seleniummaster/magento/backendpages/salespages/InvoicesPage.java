package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InvoicesPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    public InvoicesPage(WebDriver driver) {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    @FindBy(xpath = "//*[@id=\"sales_invoice_grid_table\"]/tbody/tr")
    WebElement ordersTr;
    @FindBy(xpath = "//*[@id=\"sales_invoice_grid\"]/table/tbody/tr/td[1]/span[2]")
    WebElement totalInvoiceRecord;
    @FindBy(name = "order_increment_id")
    WebElement orderIdSearchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_invoice_grid_table\"]/tbody/tr/td[9]/a")
    WebElement viewButton;
    @FindBy(xpath = "//strong[text()='Grand Total']")
    WebElement grandTotalInvoicesLink;
    @FindBy(name = "comment[comment]")
    WebElement commentTextBox;
    @FindBy(id = "history_notify")
    WebElement notifyCheckBox;
    @FindBy(xpath = "//span[text()='Submit Comment']")
    WebElement submitCommentButton;
    @FindBy(xpath = "//*[@id=\"comments_block\"]/ul/li")
    WebElement commentBlock;

    // element for review refund
    @FindBy(xpath = "//*[@id=\"sales_creditmemo_grid_table\"]/tbody/tr/td[9]/a")
    WebElement creditMemoViewLink;
    @FindBy(xpath = "//span[text()='Row Total']")
    WebElement totalRefundsRow;

    //Method for view invoice
    public void viewAllInvoice(){
        List<WebElement> invoicesList=driver.findElements(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/tbody/tr"));
        utility.sleep(2);
        if (invoicesList.size()>=1){
            System.out.println("Test Passed All invoices has been seen");
            utility.takeScreenShot("sales-invoices-record.png",driver);
        }else System.out.println("There are no any invoices record");
    }
    public boolean totalInvoicesRecordDisplay(){
        utility.waitForElementPresent(totalInvoiceRecord);
        String totalInvoiceResult=totalInvoiceRecord.getText();
        System.out.println(totalInvoiceResult);
        if (totalInvoiceRecord.isDisplayed()){
            System.out.println("Test Passed ");
        }else System.out.println("Test Failed");
        /*String totalInvoices=totalInvoiceRecord.getText();
        utility.sleep(2);
        System.out.println(totalInvoices);//Total 120 records found
        totalInvoices=totalInvoices.replace("Total","")
                .replace("records found","").trim();
        int actualResult=Integer.parseInt(totalInvoices);
        System.out.println(actualResult);
        if (actualResult>=1){
            System.out.println("Test Passed,Total "+actualResult+" invoices record Found");
        }else System.out.println("There are 0 record found");*/
        return true;
    }
    public void enterOrderId(String orderId){
        utility.waitForElementPresent(orderIdSearchBox);
        orderIdSearchBox.sendKeys(orderId);
        utility.sleep(2);
        Log.info("Order Id"+orderId+"has been entered for search order");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        utility.sleep(2);
        Log.info("Search order Button has been clicked");
    }
    public void clickViewButton(){
        utility.waitForElementPresent(viewButton);
        viewButton.click();
        utility.sleep(2);
        Log.info("View button has been clicked");
    }
    public boolean isGrandTotalDisplayed(){
        utility.waitForElementPresent(grandTotalInvoicesLink);
        grandTotalInvoicesLink.isDisplayed();
        Log.info("Grand Total Invoice Link displayed");
        return grandTotalInvoicesLink.isDisplayed();
    }
    public void enterComment(String myComments){
        utility.waitForElementPresent(commentTextBox);
        commentTextBox.sendKeys(myComments);
        Log.info("The My comments has been entered");
    }
    public void clickNotifyToEmailCheckBox(){
        utility.waitForElementPresent(notifyCheckBox);
        notifyCheckBox.click();
        Log.info("Notify to Email Check box has been checked");
    }
    public void clickOnSubmitCommentButton(){
        utility.waitForElementPresent(submitCommentButton);
        submitCommentButton.click();
        Log.info("submit Comment Button has been clicked");
    }
    public boolean isCommentDisplay(){
        utility.waitForElementPresent(commentBlock);
        commentBlock.isSelected();
        return commentBlock.isDisplayed();
    }

    // Methods for review Refunds
    public void clickOnCreditMemosViewLink(){
        utility.waitForElementPresent(creditMemoViewLink);
        creditMemoViewLink.click();
        Log.info("Credit Memos Link has been clicked");
    }
    public void totalRefundRecordIsDisplayed(){
        utility.waitForElementPresent(totalRefundsRow);
        totalRefundsRow.isDisplayed();
    }
    public boolean isTotalRefundsDisplayed(){
        utility.waitForElementPresent(totalRefundsRow);
        totalRefundsRow.isDisplayed();
        Log.info("Total Refunds is Displayed");
        return totalRefundsRow.isDisplayed();
    }
}
