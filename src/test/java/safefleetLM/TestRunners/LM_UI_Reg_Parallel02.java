package safefleetLM.TestRunners;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\java\\safefleetLM\\features\\UI",tags = "@Operations or @System_Admin",glue = "safefleetLM/stepDefinitions/UI", monochrome = true,plugin = {"html:target/cucumber.html"})
public class LM_UI_Reg_Parallel02 extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeCalss() throws AWTException {
		
		
	} 
}
 
