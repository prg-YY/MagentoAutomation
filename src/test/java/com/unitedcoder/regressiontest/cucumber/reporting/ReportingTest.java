package com.unitedcoder.regressiontest.cucumber.reporting;

import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/CucumberReportingModule-Sales/reportingModule.json"},
        features = {"src/test/resources"},
        tags = "@SeeCustomersNewAccountsReports,@SeeCustomersByOrdersTotalReport,@SeeCustomersByNumberOfOrdersReport," +
                "@SeeTagsCustomersReport,@SeeTagsProductsReport,@SeeTagsPopularReport,@SeeProductReviewsReport",
        monochrome = true
)
public class ReportingTest extends TestBasePage {


}
