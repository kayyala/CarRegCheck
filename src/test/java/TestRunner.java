import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/CarRegistrationcheck.feature"},
        glue = {"stefDef"},
        plugin = { "pretty","json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html" },
        tags = "@Sanity"
        )
public class TestRunner {
}