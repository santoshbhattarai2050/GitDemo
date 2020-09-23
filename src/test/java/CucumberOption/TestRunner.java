package CucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Feature file
@RunWith(Cucumber.class)
@CucumberOptions //CucumberOptions is annotation.
		(
		features = "src/test/java/features/Login.features",
		
		//Glue is Parameter to define to   stepdefination file
		glue = "stepDefinations"// Provided package name to glue
		)
public class TestRunner {

}
