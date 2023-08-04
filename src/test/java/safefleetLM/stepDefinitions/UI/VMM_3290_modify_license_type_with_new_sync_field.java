package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3290_modify_license_type_with_new_sync_field extends BaseTest {

	TestSetup testSetup;
    
	public VMM_3290_modify_license_type_with_new_sync_field(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	@Then("I verify there is {string} coloumn exist")
	public void I_verify_there_is_something_coloumn_exist(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I verify there is coloumn exist");
		test.assignCategory("License Types");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
		testSetup.pageObjectManager.getLicenseTypePage().verifySyncToTMHeading(testData);
		reportPass("Sync To TM Heading Present", "Sync to TM", testData.get("Text"));
		reportInfo("Sync To TM verified successfully");
		reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
	@And("I make sure that there is a checkbox next to each of the License Type for types under that coloumn")
	public void I_make_sure_that_there_is_a_checkbox_next_to_each_of_the_license_type_for_types_under_that_coloumn() {
		try {
			test = logInfo.get().createNode("I make sure that there is a checkbox next to each of the License Type for types under that coloumn");
			boolean actual = testSetup.pageObjectManager.getLicenseTypePage().verifyCheckBoxesSyncToTM();
			if(actual == true)
			{
				reportPass("checkbox is present", "true", "true");
				reportInfo("checkbox next to each of the License Type for types under that coloumn is verified successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("checkbox is not present", "false", "false");
				reportInfo("checkbox next to each of the License Type for types under that coloumn is verified not successfully");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	   
	}
		

}
