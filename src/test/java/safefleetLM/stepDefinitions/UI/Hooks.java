package safefleetLM.stepDefinitions.UI;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ReadXL;
import safefleetLM.testcomponents.TestSetup;

public class Hooks extends BaseTest {

	public Hooks() throws IOException{

	}
	
	@Before(order=0)
	public void TestConfigSetup(Scenario scenario) throws Exception {
		test = extent.createTest(scenario.getName());
	    logInfo.set(test);
	    softAssert = new SoftAssert();
	    scenarioName = scenario.getName();
	}
	@After
	public void teardown(Scenario scenario) {
		softAssert.assertAll();
		
	}
}
	

