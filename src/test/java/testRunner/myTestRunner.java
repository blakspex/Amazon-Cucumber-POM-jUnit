package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:/THE OTHER DRIVE/worrkbench/CucumberPom/src/test/resources/features"},
		glue = {"stepDefinitions","AppHooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
	)


public class myTestRunner {
	
}
 