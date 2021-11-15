import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//C:\Users\sudhakarkayyala\Documents\Automationworkspace\CarValidation\src\test\resources\Features\CarRegistrationcheck.feature

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/CarRegistrationcheck.feature"},
        glue = {"stefDef"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        tags = "@Sanity"
        )
public class TestRunner {
}