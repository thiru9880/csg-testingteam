package safefleetLM.TestRunners;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\java\\safefleetLM\\features\\UI",tags= "@VMM-3249 or @VMM-3273 or @VMM-3370 or @VMM-3409 or @VMM-3411 or @VMM-3592 or @VMM-3736 or @VMM-3846 or @VMM-3852 or @VMM-4423 or @VMM-4439"
		+ "",glue = "safefleetLM/stepDefinitions/UI", monochrome = true,plugin = {"html:target/cucumber.html"})
public class LM_UI_Failover extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeCalss() throws AWTException {
		
		
	}
}
 
