package safefleetLM.TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/safefleetLM/features",glue="safefleetLM/stepDefinitions",
monochrome=true,tags="@Regression",plugin= {"pretty","html:target/cucumber.html","html:target/cucumber.json", 
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}

//Cmd to run in terminal
//mvn test -Dcucumber.filter.tags="@Regression"