package com.unitedcoder.regressiontest.reportingmoduletestrunner;


import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cubecart-cucumber",
        "json:target/magento.json"},
features = {"src/test/resources"},
        tags = "@SeeCustomersNewAccountsReports"
        ,monochrome = true
)
public class ReportingModuleTestRunner extends TestBasePage {


}
