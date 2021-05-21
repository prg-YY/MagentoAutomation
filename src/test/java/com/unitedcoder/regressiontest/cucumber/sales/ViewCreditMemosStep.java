package com.unitedcoder.regressiontest.cucumber.sales;

import com.seleniummaster.magento.backendpages.salespages.CreditMemosPage;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ViewCreditMemosStep extends TestBasePage {
    SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
    CreditMemosPage creditMemosPage=new CreditMemosPage(driver);

    @When("sales manager already on the  credit memos page")
    public void salesManagerAlreadyOnTheCreditMemosPage() {
        dashboardPage.clickOnSalesLink();
        dashboardPage.clickCreditMemosLink();
    }

    @Then("Sales manager can view credit memos")
    public void salesManagerCanViewCreditMemos() {
        Assert.assertTrue(creditMemosPage.viewCreditMemos());
    }
}
