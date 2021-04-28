package com.unitedcoder.magento.testngframework;

import com.seleniummaster.configutiity.ApplicationConfig;
import com.unitedcoder.magento.TestUtility;
import com.unitedcoder.magento.publicusermodule.CreateAccountPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccount {

    String configFile="config.properties";
    WebDriver driver;
    String url= ApplicationConfig.readConfigProperties(configFile,"create_url");
    TestUtility utility;

    @BeforeClass
    public void setup(ITestContext context){
        //TestBase.setUpBrowser();
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://magentoqa.unitedcoder.com/customer/account/create/");
        context.setAttribute("driver",driver);
        utility=new TestUtility(driver);
    }
    @Test
  public void createAnAccount(){
        CreateAccountPage accountPage=new CreateAccountPage(driver);
        accountPage.userCreateAccount("Abdusamad","Mejid",
                "abdusamad"+System.currentTimeMillis()+"@gmail.com","magento123");

    }

    @AfterClass
    public void tearDown(){
        //TestBase.closeBrowser();

    }

}
