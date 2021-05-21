package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.ReportingModule.CustomersTagsAndReviewsPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class CustomersTagsAndReviewsFefStep extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    CustomersTagsAndReviewsPage customersTagsAndReviewsPage=new CustomersTagsAndReviewsPage(driver);
    TestUtility utility=new TestUtility(driver);


    @When("click on Reports drop down list than click on New Accounts under of Customers")
    public void clickOnReportsDropDownListThanClickOnNewAccountsUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        utility.sleep(1);
        dashboardPage.clickNewAccountsLink();
    }

    @And("fill the From field and To field then click on Refresh Button\\(New Accounts Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonNewAccountsReport() {
        utility.sleep(1);
        customersTagsAndReviewsPage.chooseDateOfCustomersByOrdersTotalAndClickAndRefreshButton();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    @Then("verify New Accounts on the right up")
    public void verifyNewAccountsOnTheRightUp() {

        customersTagsAndReviewsPage.clickNewAccountsSuccessMassage();
        utility.takeScreenShot("New_Accounts",driver);
    }

    @When("click on Reports drop down list than click on Customers by Orders Total under of Customers")
    public void clickOnReportsDropDownListThanClickOnCustomersByOrdersTotalUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        utility.sleep(1);
        dashboardPage.clickCustomersByOrdersTotalLink();
    }

    @And("fill the From field and To field then click on Refresh Button\\(Customers by Orders Total Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonCustomersByOrdersTotalReport() {
        utility.sleep(1);
        customersTagsAndReviewsPage.chooseDateOfCustomersByOrdersTotalAndClickAndRefreshButton();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,4000)");

    }

    @Then("verify Customers by Orders Total on the right up")
    public void verifyCustomersByOrdersTotalOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersByOrdersTotalSuccessMassage();
        utility.takeScreenShot("Customer_By_Orders_Total",driver);
    }

    @When("click on Reports drop down list than click on Customers by number of orders Report under of Customers")
    public void clickOnReportsDropDownListThanClickOnCustomersByNumberOfOrdersReportUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        utility.sleep(1);
        dashboardPage.clickCustomersByNumberOfOrders();
    }

    @And("fill the From field and To field then click on Refresh Button\\(Customers by number of orders Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonCustomersByNumberOfOrdersReport() {
        utility.sleep(1);
        customersTagsAndReviewsPage.chooseDateOfCustomersByOrdersTotalAndClickAndRefreshButton();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,3500)");
    }

    @Then("verify Customers by number of orders Report on the right up")
    public void verifyCustomersByNumberOfOrdersReportOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersByNumberOfOrdersSuccessMassage();
        utility.takeScreenShot("Customer_By_Number_Of_Orders",driver);
    }

    @When("click on Reports drop down list than click on Customers under of Tags")
    public void clickOnReportsDropDownListThanClickOnCustomersUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        utility.sleep(2);
        dashboardPage.clickTagsCustomersLink();
    }

    @Then("verify Customers Tags on the right up")
    public void verifyCustomersTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersTagsSuccessMassage();
        utility.takeScreenShot("Tags_Customers_Report",driver);
    }

    @When("click on Reports drop down list than click on Products under of Tags")
    public void clickOnReportsDropDownListThanClickOnProductsUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        utility.sleep(2);
        dashboardPage.clickTagProductsLink();
    }

    @Then("verify Products Tags on the right up")
    public void verifyProductsTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickProductsTagsSuccessMassage();
        utility.takeScreenShot("Tags_Products_Reports",driver);
    }

    @When("click on Reports drop down list than click on Popular under of Tags")
    public void clickOnReportsDropDownListThanClickOnPopularUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        utility.sleep(2);
        dashboardPage.clickTagPopularLink();
    }

    @Then("verify Popular Tags on the right up")
    public void verifyPopularTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickPopularTagsSuccessMassage();
        utility.takeScreenShot("Tags_Popular_Reports",driver);
    }

    @When("click on Reports drop down list than click on Product Reviews under of Reviews")
    public void clickOnReportsDropDownListThanClickOnProductReviewsUnderOfReviews() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickReviewsLink();
        utility.sleep(2);
        dashboardPage.clickProductReviewsLink();
    }

    @Then("verify Product Reviews on the right up")
    public void verifyProductReviewsOnTheRightUp() {
        customersTagsAndReviewsPage.clickProductsReviewsSuccessMassage();
        utility.takeScreenShot("Products_Reviews_Reports",driver);
    }
}
