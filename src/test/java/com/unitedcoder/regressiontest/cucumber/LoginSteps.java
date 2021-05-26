package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestBasePage {
    BackEndLogin backEndLogin;

    @Given("user on login page")
    public void userOnLoginPage() {
        backEndLogin = new BackEndLogin(driver);
    }

    @When("user enter username and password click on login button")
    public void userEnterUsernameAndPasswordClickOnLoginButton() {
        backEndLogin.backEndLogin(prop.getProperty("ReportingManager"), prop.getProperty("password"));
    }

    @Then("user successfully login to the system")
    public void userSuccessfullyLoginToTheSystem() {
        backEndLogin.clickLoginSuccessfully();
    }
}
