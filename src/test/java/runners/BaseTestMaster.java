package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumber", "json:target/report.json"},
        features = "src/test/resources/features",
        glue = ("WebAssessment/src/test/java/steps_defentions"),
        tags = "@test",
        dryRun = false
)

public class BaseTestMaster {

}
