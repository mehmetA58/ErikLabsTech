package runners.cucumber.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"


        },
        glue = "tests/cucumber",
        dryRun = false,
        tags = "@QuickTest2",
        plugin = {"pretty","html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"

        }
)
public class CucumberRunner {
}
