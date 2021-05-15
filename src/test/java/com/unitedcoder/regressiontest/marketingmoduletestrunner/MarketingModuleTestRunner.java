package com.unitedcoder.regressiontest.marketingmoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MarketingModuleTestRunner extends TestBasePage {

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin1(prop.getProperty("marketingmanager"), prop.getProperty("password"));
    }
    @Test(description = "Marketing Manager can add new Catalog Price Rule - DilNur")
    public void addNewCatalogPriceRule(){

    }
    @Test(description = "Marketing Manager can update existing Catalog Price Rule -ZuhRa")
    public void updateCatalogPriceRUle(){

    }
    @Test(description = "Marketing Manager can search Catalog Pricing Rule By Id and Rule - MeLike")
    public void searchPricingRule(){

    }
    @Test(description = "Marketing Manager can add new Cart Price Rule - AbDuSeMed")
    public void addCartPriceRule(){

    }
    @Test(description = "Marketing Manager can filter Cart Pricing Rule by Id and Rule - SoFia")
    public void filterCartPricingRUle(){

    }
    @Test(description = "Marketing Manager can update existing Cart Price Rule - KemBerNiSa")
    public void updateCartPriceRule(){

    }
    @Test(description = "Marketing Manager can view all Reviews - AbDuKaHar")
    public void viewAllReviews(){

    }
    @Test(description = "Marketing Manager can update existing reviews - AyPer")
    public void updateReviews(){

    }
    @Test(description = "Marketing Manager can view pending Reviews - Yusuf")
    public void viewPendingReviews(){

    }
    @Test(description = "Marketing Manager can update pending Reviews - Leila")
    public void updatePendingReviews(){

    }
    @Test(description = "Marketing Manager can add new Newsletter template - AbDuSeMed")
    public void addLetterTemplate(){

    }
    @Test(description = "Marketing Manager can view newsletter subscribers - AbDuKaHar")
    public void viewNewsLetterSubscribers(){

    }

    @AfterClass
    public void tearDown(){

    }
}
