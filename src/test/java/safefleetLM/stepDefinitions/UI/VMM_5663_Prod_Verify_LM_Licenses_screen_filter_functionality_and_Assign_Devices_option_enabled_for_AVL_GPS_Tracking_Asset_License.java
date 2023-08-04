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


public class VMM_5663_Prod_Verify_LM_Licenses_screen_filter_functionality_and_Assign_Devices_option_enabled_for_AVL_GPS_Tracking_Asset_License extends BaseTest {

	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;
	String env = getProperty("Environment");

	public VMM_5663_Prod_Verify_LM_Licenses_screen_filter_functionality_and_Assign_Devices_option_enabled_for_AVL_GPS_Tracking_Asset_License(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I verify that the Licenses screen loads successfully with all the details")
	public void i_verify_that_the_licenses_screen_loads_successfully_with_all_the_details() {
		try {
			test = logInfo.get().createNode("I verify that the Licenses screen loads successfully with all the details");
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyAllColumnsAvailableInLicensesScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Licenses screen verification","" , "All column header available in the Licenses dashboard screen");
			}
			else {
				reportFail("Licenses screen verification", "", "All column header not available in the Licenses dashboard screen");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I search License with multiple filter condition {string}")
	public void i_search_licenses_with_multiple_filter_condition(String tcid) {

		try {
			test = logInfo.get().createNode("I search Licenses with multiple filter condition details");
			test.assignCategory("Production");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().filterLicenseWithStatusBaseAppAndLicenseType(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().hideFiltersBtn();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify that Assign Devices option is enabled for AVL GPS Tracking License")
	public void i_verify_assign_devices_option_is_enabled_for_AVL_GPS_Tracking_License() {

		try {
			test = logInfo.get().createNode("I verify that Assign Devices option is enabled for AVL GPS Tracking License");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getLicensesPage().licenseExpand();
			testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();
			String result = testSetup.pageObjectManager.getLicensesPage().verifyAssignDevicesOptionEnabledOrDisabled();
			reportScreenshot(testSetup.driver);
			if(result.equals("false")) {
				reportPass("Assign Device", "Assign Device option should be enabled for AVL Asset license", "Assign Device option is enabled for AVL Asset license");
			}
			else {
				reportFail("Assign Device", "Assign Device option should be enabled for AVL Asset license", "Assign Device option is not enabled for AVL Asset license");
			}
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	@Then("I view the filtered license and verify license details is as per the filter {string}")
	public void i_view_license_and_verify_license_details_as_per_filter(String tcid) {

		try {
			test = logInfo.get().createNode("I view the filtered license and verify license details is as per the filter");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getLicensesPage().clickOnLicenseViewBtn();
			reportScreenshot(testSetup.driver);
			String actLicenseStatus=testSetup.pageObjectManager.getLicensesPage().getLicenseStatusFromViewScreen();
			String actBaseApp=testSetup.pageObjectManager.getLicensesPage().getBaseAppFromViewScreen();
			String actLicenseType=testSetup.pageObjectManager.getLicensesPage().getLicenseTypeFromViewScreen();
			if(actBaseApp.equals(testData.get("FilterValue1")) &&
					actLicenseStatus.equals(testData.get("FilterValue2")) &&
					actLicenseType.equals(testData.get("FilterValue3")))
			{
				reportPass("Verified License details", testData.get("FilterValue1"), actLicenseStatus);
				reportPass("Verified License details", testData.get("FilterValue2"), actBaseApp);
				reportPass("Verified License details", testData.get("FilterValue3"), actLicenseType);

			}
			else {
				reportFail("Verified License details", testData.get("FilterValue1"), actLicenseStatus);
				reportFail("Verified License details", testData.get("FilterValue2"), actBaseApp);
				reportFail("Verified License details", testData.get("FilterValue3"), actLicenseType);

			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}
	}
