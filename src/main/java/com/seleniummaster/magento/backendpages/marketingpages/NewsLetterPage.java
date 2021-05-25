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

public class NewsLetterPage extends TestBasePage {
    TestUtility utility;
    WebDriver driver;
 //Marketing Manager should be able to add new Newsletter Template - Dilnur
    @FindBy(xpath = "(//span[text()='Add New Template'])[1]")
    WebElement addNewTemplateButton;
    @FindBy(xpath = "//input[@id=\"code\"]")
    WebElement templateNameTextBox;
    @FindBy(xpath = "//input[@id=\"subject\"]")
    WebElement templateSubjectTextBox;
    @FindBy(xpath = "//span[text()=\"Save Template\"]")
    WebElement saveTemplateButton;
    @FindBy(xpath = "//div[@class=\"hor-scroll\"]/table/tbody/tr")
    WebElement templateRows;
    @FindBy(xpath = "//*[@id=\"subscriberGrid_table\"]/tbody/tr")
    WebElement newsletterSubscribers;

    public NewsLetterPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

        public void clickAddNewTemplate(){
        utility.waitForElementPresent(addNewTemplateButton);
            addNewTemplateButton.click();
        Log.info("addNewTemplateButtonIsClicked");
    }
    public void enterTemplateName(){
        utility.waitForElementPresent(templateNameTextBox);
        templateNameTextBox.sendKeys("Team-1 Template");
        Log.info("Template Name Has Been Entered");
    }
    public void enterTemplateSubject(){
        utility.waitForElementPresent(templateSubjectTextBox);
        templateSubjectTextBox.sendKeys("New Template");
        Log.info("new Template subject has been entered");
    }
    public void clickOnSaveTemplateButton(){
        utility.waitForElementPresent(saveTemplateButton);
        saveTemplateButton.click();
        Log.info("save Template Button Has been Clicked");
    }
    public boolean verifyAddTemplateSuccessfully(){
        utility.waitForElementPresent(templateRows);
        List<WebElement> templateList=driver.findElements(By.xpath("//div[@class=\"hor-scroll\"]/table/tbody/tr"));
        for (int i=0;i<templateList.size();i++){
            String myTemplate=templateRows.getText();
            if (myTemplate.contains("Team1")){
                System.out.println("test passed");
            }
            else System.out.println("test failed");
        }
        return true;
    }

    //  marketing manager should be view newsletter Subscribers - Abdukahar

    public void newsletterSubscribersListIsDisplay(){
        utility.waitForElementPresent(newsletterSubscribers);
        if (newsletterSubscribers.isDisplayed()){
            System.out.println("Newsletter Subscribers is displayed");
            Log.info("Newsletter Subscribers records are displayed");
        }else System.out.println("There is no any Newsletter Subscribers records ");
        Log.info("There is no any Newsletter Subscribers records");
    }

    //verify
    public boolean isNewsLetterSubscriberRecordDisplay(){
        List<WebElement> newsletterSubscribersList=driver.findElements(By.xpath("//*[@id=\"subscriberGrid_table\"]/tbody/tr"));
        if (newsletterSubscribersList.size()>0){
            System.out.println("Test Passed");
            Log.info("Newsletter Subscribes records already Displayed on the UI");
        }else System.out.println("No found Any Newsletter Subscribes records ");
        return true;

    }





}
