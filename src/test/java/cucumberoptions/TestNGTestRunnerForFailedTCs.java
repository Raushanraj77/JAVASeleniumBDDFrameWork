package cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failedScenarios.txt", glue = "stepdefinitions",
monochrome = true,
plugin = {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNGTestRunnerForFailedTCs extends AbstractTestNGCucumberTests {

	//How will you run parallel scenarios in cucumber
	// call the scenarios method from AbstractTestNGCucumberTests (parent class) class using super keywork and keep DataProvider tag with Parallel = true
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}
