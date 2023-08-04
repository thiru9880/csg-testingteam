package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;


public class VMM_5664_Prod_Verify_LM_Expire_and_Terminate_options_availability_and_Assign_Devices_option_disabled_for_Video_Device_Management_License extends BaseTest {

	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;
	String env = getProperty("Environment");

	public VMM_5664_Prod_Verify_LM_Expire_and_Terminate_options_availability_and_Assign_Devices_option_disabled_for_Video_Device_Management_License(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}




	@Then("I verify that Assign Devices option is disabled for Video Device Management License")
	public void i_verify_assign_devices_option_is_enabled_for_Video_Device_Management_License() {

		try {
			test = logInfo.get().createNode("I verify that Assign Devices option is disabled for Video Device Management License");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getLicensesPage().licenseExpand();
			testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();
			String result = testSetup.pageObjectManager.getLicensesPage().verifyAssignDevicesOptionEnabledOrDisabled();
			reportScreenshot(testSetup.driver);
			if(result.equals("true")) {
				reportPass("Assign Device", "Assign Device option should be disabled for Video Device Management license", "Assign Device option is disabled for Video Device Management license");
			}
			else {
				reportFail("Assign Device", "Assign Device option should be disabled for Video Device Management license", "Assign Device option is not disabled for Video Device Management license");
			}
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify that the Expire and Terminate options are available for the License")
	public void i_search_licenses_with_multiple_filter_condition() {

		try {
			test = logInfo.get().createNode("I verify that the Expire and Terminate options are available for the License");
			test.assignCategory("Production");
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyExpireAndTerminateOptionsAvailability();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Expire and Terminate options availability", "The Expire and Terminate options should be available for the License", "The Expire and Terminate options are available for the License");
			}
			else {
				reportFail("Expire and Terminate options availability", "The Expire and Terminate options should be available for the License", "The Expire and Terminate options are not available for the License");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	}
