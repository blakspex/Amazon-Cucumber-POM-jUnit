package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:/THE OTHER DRIVE/worrkbench/CucumberPom/src/test/resources/features"},
		glue = {"stepDefinitions","AppHooks"},
		plugin = {"pretty", "html:target/report2"},
		monochrome = true
	)


public class myTestRunner {
	
}
 
