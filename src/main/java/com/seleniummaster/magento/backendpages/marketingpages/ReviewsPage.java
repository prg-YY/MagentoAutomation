package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    MarketingDashBoarPage marketingDashBoarPage;

    @FindBy(xpath = "(//td[@class=\" last\"])[1]")//valid pending reviews page and all reviews page
    WebElement editButton;


    public ReviewsPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

   public void clickAnyEditButton(){
        utility.waitForElementPresent(editButton);
        editButton.click();
       Log.info("Edit Button Clicked");
   }
}
