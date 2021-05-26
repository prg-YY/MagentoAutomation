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


    public void tearDown() {
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickLogOutLink();
        driver.close();
        driver=null;
    }

}
