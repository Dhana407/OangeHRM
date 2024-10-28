package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features",
glue= {"stepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/Html reports",
		"json:target/JSONReports/report.json",
		"junit:target/JunitReports/report.xml"},
    tags="@smoketest"
)

	

public class TestRunner {

}
