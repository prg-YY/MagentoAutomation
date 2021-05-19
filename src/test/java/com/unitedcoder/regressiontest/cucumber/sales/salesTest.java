package com.unitedcoder.regressiontest.cucumber.sales;

import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/CucumberReportingModule-Sales/reportingModule.json"},
        features = {"src/test/resources"},
        tags = "@",
        monochrome = true
)
public class salesTest extends TestBasePage {


}
