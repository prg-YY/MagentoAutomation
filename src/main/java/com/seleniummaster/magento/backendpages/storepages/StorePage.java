package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends TestBasePage {
    @FindBy(xpath = "(//span[text()='Create Store'])[1]")
    WebElement CreateStoreButton;

    @FindBy(xpath = "(//span[text()='Create Website'])[1]")
    WebElement CreateWebsiteButton;

    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement CreateStoreviewButton;





}
