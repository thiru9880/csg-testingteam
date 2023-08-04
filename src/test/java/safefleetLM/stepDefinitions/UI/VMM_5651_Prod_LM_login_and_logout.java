package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_5651_Prod_LM_login_and_logout extends BaseTest {

	TestSetup testSetup;

	public VMM_5651_Prod_LM_login_and_logout(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}


	@Then("I verify the user name and LM app version")
	public void i_verify_the_user_details_and_lm_app_version() {

		try {
			String env = getProperty("Environment");
			String version = prop.getProperty("LMVersion");
			test = logInfo.get().createNode("I verify the user name and LM app version");
			test.assignCategory("Production");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Login", env);
			String currentUN = testSetup.pageObjectManager.getHomePage().currentUserText();
			String lmAppVersion = testSetup.pageObjectManager.getHomePage().getLMAPPVersionTxt();
			reportScreenshot(testSetup.driver);
			if(currentUN.equalsIgnoreCase(testData.get("CURRENT_USERNAME")) && lmAppVersion.contains(version)) {
				reportPass("User name and LM app version verification", "User name: "+ testData.get("CURRENT_USERNAME") +" LM version: "+ version, "User name: "+ currentUN +" LM version: "+ lmAppVersion);
			}
			else {
				reportFail("User name and LM app version verification", "User name: "+ testData.get("CURRENT_USERNAME") +" LM version: "+ version, "User name: "+ currentUN +" LM version: "+ lmAppVersion);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}



	}
