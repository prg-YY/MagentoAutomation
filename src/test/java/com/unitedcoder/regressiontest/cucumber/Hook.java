package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends TestBasePage {

    @Before
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
    }

    @After(order = 1)
    public void logOut(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickLogOutLink();
    }


    @After(order = 0)
    public void tearDown() {
        driver.close();
        driver=null;
    }

}
