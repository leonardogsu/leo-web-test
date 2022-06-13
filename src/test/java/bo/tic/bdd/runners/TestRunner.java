package bo.tic.bdd.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/stories/functional/suite_a/rest",
		glue = "bo.tic.bdd.stepdefinitions",
		strict = true

)
public class TestRunner {


}
