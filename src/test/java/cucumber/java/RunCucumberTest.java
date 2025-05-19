package cucumber.java;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // adjust if needed
    glue = "cucumber.java.stepdefs",              // your actual step def package
    //plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class RunCucumberTest {

}
