import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",strict = true,plugin = { "pretty","json:target/cucumber.json" })
public class RunCucumberTest {
}
