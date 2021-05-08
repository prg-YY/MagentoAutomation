package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsitePage extends TestBasePage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;

    @FindBy(xpath = "(//button[@title=\"Create Website\"])[1]")
    WebElement createWebsite;
    @FindBy()
    WebElement X;

   // Store Manager can create a website (@Abdukahar)
    // Store Manager can edit a website (@Sofia)
}
