package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    MarketingDashBoarPage marketingDashBoarPage;

    //View Pending views Elements
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr")
    WebElement pendingRows;
    @FindBy(xpath = "//*[@id=\"reviwGrid\"]/table/tbody/tr/td[1]")
    WebElement totalViewLink;
    //method for view pending review
    public void viewPendingReviews(){
        utility.waitForElementPresent(pendingRows);
        List<WebElement> pendingViewsList=driver.findElements(By.xpath("//*[@id=\"reviwGrid_table\"]/tbody/tr"));
        if (pendingViewsList.size()>=1){
            System.out.println("Pending Reviews Test passed ");
        }else System.out.println("Pending Reviews Test Failed");
    }
    public boolean isTotalReviewsLinkDisplayed(){
        utility.waitForElementPresent(totalViewLink);
        if (totalViewLink.isDisplayed()){
            System.out.println("Test Pass");
        }else System.out.println("Test Failed");
        return true;
    }



    //view all views Elements
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr")
    WebElement allViewsRows;
    // method for view all reviews
    public void viewAllReviews(){
        utility.waitForElementPresent(allViewsRows);
        List<WebElement> allReviewsList=driver.findElements(By.xpath("//*[@id=\"reviwGrid_table\"]/tbody/tr"));
        if (allReviewsList.size()>=1){
            System.out.println("View all Reviews Test passed ");
        }else System.out.println("View all Reviews Test Failed");
    }

    // update pending Reviews
    @FindBy(id = "reviwGrid_filter_review_id")
    WebElement idSearchBox;
    @FindBy(xpath  = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[11]/a")
    WebElement pendingEditButton;
    @FindBy(xpath = "//*[@id=\"detail\"]")
    WebElement reviewTextBox;
    @FindBy(xpath = "(//span[text()='Save Review'])[1]")
    WebElement saveReviewButton;
    @FindBy(xpath = "//li[@class='success-msg']")
    WebElement successMessage;

    // methods for each actions
    public void enterIdToIdSearchBox(String idNumber){
        utility.waitForElementPresent(idSearchBox);
        idSearchBox.sendKeys(idNumber);
        Log.info("ID Number Has been Entered");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("Search Button has benn clicked");
    }
    public void clickOnPendingEditButton() {
        utility.waitForElementPresent(pendingEditButton);
        pendingEditButton.click();
        Log.info("Pending Edit Button has been clicked");
    }
    public void enterReviewToReviewTextBox(String reviewText) {
        utility.waitForElementPresent(reviewTextBox);
        reviewTextBox.sendKeys(reviewText);
        Log.info("Review Text has been Added");
    }
    public void clickOnSaveReviewButton(){
        utility.waitForElementPresent(saveReviewButton);
        saveReviewButton.click();
        Log.info("Save Review Button has been clicked");
    }
    public boolean isPendingReviewUpdate(){
        utility.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Pending Reviews test passed");
        }else System.out.println("Pending reviews test Failed");
        return true;
    }

    // update All reviews Elements
    @FindBy(id = "reviwGrid_filter_review_id")
    WebElement allReviewsIdSearchBox;
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[12]/a")
    WebElement allReviewsEdit;
    @FindBy(xpath = "//*[@id=\"detail\"]")
    WebElement allReviewsReviewTextBox;
    @FindBy(xpath = "(//*[@id=\"save_button\"]/span/span/span)[1]")
    WebElement allReviewsSaveButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li")
    WebElement allReviewSuccessMessage;

    // method for all reivews actions
    public void enterIdToAllReviewsIdSearchBox(String allReviewId){
        utility.waitForElementPresent(allReviewsIdSearchBox);
        allReviewsIdSearchBox.sendKeys(allReviewId);
        Log.info("All reviews Id Hss been Entered");
    }
    public void clickOnALLReviewsEdit(){
        utility.waitForElementPresent(allReviewsEdit);
        allReviewsEdit.click();
        Log.info("All reviews Edit Button has been clicked");
    }
    public void enterReviewToALlReviewTextBox(String allReviewsText){
        utility.waitForElementPresent(allReviewsReviewTextBox);
        allReviewsReviewTextBox.sendKeys(allReviewsText);
        Log.info("All reviews text has been added");
    }
    public void clickOnAllReviewsSaveButton(){
        utility.waitForElementPresent(allReviewsSaveButton);
        allReviewsSaveButton.click();
        Log.info("All reviews Save button Has been clicked");
    }
    public boolean isAllReviewUpdated(){
        utility.waitForElementPresent(allReviewSuccessMessage);
        if (allReviewSuccessMessage.isDisplayed()){
            System.out.println("Test passed . All reviews Updated successfully ");
        }else System.out.println("Test Failed");
        return true;
    }

}
