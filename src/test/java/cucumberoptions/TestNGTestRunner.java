package cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepdefinitions",
monochrome = true, tags="@Offer or @Checkout",
plugin = {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedScenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	//How will you run parallel scenarios in cucumber
	// call the scenarios method from AbstractTestNGCucumberTests (parent class) class using super keywork and keep DataProvider tag with Parallel = true
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}
