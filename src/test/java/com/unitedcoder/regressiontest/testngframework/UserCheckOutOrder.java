package com.unitedcoder.regressiontest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.ApplicationConfig;
import com.unitedcoder.magento.TestUtility;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class UserCheckOutOrder {
    String configFile="config.properties";
    WebDriver driver;
    String url= ApplicationConfig.readConfigProperties(configFile,"create_url");
    TestUtility utility;

    @BeforeClass
    public void setup(ITestContext context){
        //TestBase.setUpBrowser();
        System.setProperty("webdriver.chrome.driver", "/Users/prg/Documents/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://magentoqa.unitedcoder.com/customer/account/create/");
        context.setAttribute("driver",driver);
        utility=new TestUtility(driver);
    }
}
