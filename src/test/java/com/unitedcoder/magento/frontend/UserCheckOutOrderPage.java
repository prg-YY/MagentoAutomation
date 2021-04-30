package com.unitedcoder.magento.publicusermodule;

import com.unitedcoder.magento.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCheckOutOrderPage {
    WebDriver driver;
    TestUtility utility;

@FindBy(xpath = "//div[@class=\"account-cart-wrapper\"]/a")
    WebElement AccountDropdownList;

}
