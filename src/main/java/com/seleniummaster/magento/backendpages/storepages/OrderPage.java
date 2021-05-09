package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {

    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;

    @FindBy (xpath = "(//span[text()=\"Create New Order\"])[1]")
    WebElement CreateNewOrderButton;
    @FindBy(xpath = "(//input[@id=\"sales_order_create_customer_grid_filter_name\"])[1]")
    WebElement NameTextField;




	//Store Manager can create a new order

	//Store Manager can edit orders

	//Store Manager can delete orders

}
