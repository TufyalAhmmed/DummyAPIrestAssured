package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
@CucumberOptions(features = "src/test/java/Feature", glue = "steps",
        monochrome = true,
//        tags = "@Android",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:allure-results/cucumber.html", "json:allure-results/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:failedTests/failed_scenarios.txt"}
)
public class TestNGTestRunner  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
