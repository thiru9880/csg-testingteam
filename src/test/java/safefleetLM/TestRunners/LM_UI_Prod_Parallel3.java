package safefleetLM.TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

import java.awt.*;


@CucumberOptions(features = "src\\test\\java\\safefleetLM\\features\\UI",tags = "@prod3",glue = "safefleetLM/stepDefinitions/UI", monochrome = true,plugin = {"html:target/cucumber.html"})
public class LM_UI_Prod_Parallel3 extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeCalss() throws AWTException {


	}
}

