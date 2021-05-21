package com.unitedcoder.regressiontest.cucumber.StoreModuleSteps;

import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/CucumberStoreModule.json"},
        features = {"src/test/resources"},
        tags = "@StoreModule",
        monochrome = true)

public class StoreModuleCucumberTestRunner{
}
