package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/CucumberReportingModule-Sales/salesModule.json"},
        features = {"src/test/resources"},
        tags = "@CancelOrder",
        monochrome = true
)
public class CucumberTestRunner extends TestBasePage {


}
