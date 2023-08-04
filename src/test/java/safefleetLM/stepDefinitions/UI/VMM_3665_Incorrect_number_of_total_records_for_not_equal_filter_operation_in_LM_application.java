package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3665_Incorrect_number_of_total_records_for_not_equal_filter_operation_in_LM_application extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3665_Incorrect_number_of_total_records_for_not_equal_filter_operation_in_LM_application(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	  
	@Then("I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for device setting {string}")
	public void i_verify_if_the_record_count_for_not_equal_filter_operation_in_ui_is_correct_and_is_not_more_than_the_record_count_with_no_filters_for_device_setting(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for device setting");
			test.assignCategory("Others");
			reportInfo("I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for device setting");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().VerifyNotMoreThanRecordNotEqualDevicesetting(testData);
			testSetup.pageObjectManager.getDeviceSettingsPage().clickFilter();
			reportInfo("I Verify No CoreController Device Setting In Record After Clicking Filter");
			reportScreenshot(testSetup.driver);
		
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}
	@Then("I navigate to Software Settings")
	public void i_navigate_to_software_settings() {
		try {
			test = logInfo.get().createNode("I Navigate to Software Settings");
			reportInfo("I navigate to software setting successfully");
			testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
			
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	    
	}
	
	@Then("I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for software setting {string}")
	public void verify_if_the_record_count_for_not_equal_filter_operation_in_ui_is_correct_and_is_not_more_than_the_record_count_with_no_filters_for_software_setting(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify if the Record count for not equal filter operation in UI is correct and is not more than the record count with no filters for software setting");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getEcosystemSettingsPage().clickShowFilterAndVerifyNotEqualSoftwaresetting(testData);
			testSetup.pageObjectManager.getDeviceSettingsPage().clickFilter();
			reportInfo("I verify No Web PTLW Ecosystem In Record After Clicking Filter");
			reportScreenshot(testSetup.driver);
		
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	   
	}


}
