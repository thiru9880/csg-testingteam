package safefleetLM.TestRunners;

  import java.awt.AWTException;

  import org.testng.annotations.BeforeClass;

  import io.cucumber.java.Before;
  import io.cucumber.java.Scenario;
  import io.cucumber.testng.AbstractTestNGCucumberTests;
  import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"${cucumber.features}"},tags = "@VMM-5527 or @VMM-5532 or @VMM-5540",glue = "safefleetLM/stepDefinitions/UI", monochrome = true,plugin = {"json:target/cucumber.json","html:target/cucumber.html"})
public class LM_UI_Runner_check extends AbstractTestNGCucumberTests{
  @BeforeClass
  public void beforeCalss() throws AWTException {


  }
}


