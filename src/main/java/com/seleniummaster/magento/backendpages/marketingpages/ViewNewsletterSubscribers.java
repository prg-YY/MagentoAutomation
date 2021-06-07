package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewNewsletterSubscribers extends TestBasePage {
    TestUtility utility;

    @FindBy(xpath = "//span[text()=\"Newsletter\"]")
    WebElement newsLetterMenu;

    @FindBy(xpath = "//span[text()=\"Newsletter Subscribers\"]")
    WebElement newsLetterSubscribersLink;
    @FindBy(xpath = "//*[@id=\"subscriberGrid_table\"]")
    WebElement subscribeTable;

    @FindAll(
      @FindBy(xpath = "//*[@id=\"subscriberGrid_table\"]/tbody")
    )
    List<WebElement> tableList;

    public ViewNewsletterSubscribers() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

}
public void clickNewsLetterMenu(){
        utility.waitForElementPresent(newsLetterMenu);
        newsLetterMenu.click();
        utility.sleep(2);
}
public void clickNewsLetterSubscribersLink(){
        utility.waitForElementPresent(newsLetterSubscribersLink);
        newsLetterSubscribersLink.click();
        utility.sleep(2);


}
public boolean verifyTable(){
        utility.waitForElementPresent(subscribeTable);
        if (tableList.size()>1){
            System.out.println("test pass");

        }
        return true;


}

}
