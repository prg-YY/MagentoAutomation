package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","json:target/CucumberReportingModule-Sales/reportingModule.json"},
        features = {"src/test/resources/StoreModule"},
        tags = "@CreateWebsite",
        monochrome = true
)
public class CucumberTestRunner extends TestBasePage {


}
