package safefleetLM.TestRunners;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\java\\safefleetLM\\features\\UI",tags = "@smoke",glue = "safefleetLM/stepDefinitions/UI", monochrome = true,plugin = {"json:target/cucumber.json","html:target/cucumber.html"})
public class LM_UI_Runner_Smoke extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeCalss() throws AWTException {


	}
}

