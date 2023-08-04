package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
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

public class VMM_5655_Prod_Verify_LM_Devices_screen_and_readonly_functionality extends BaseTest {
	
	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;

	public VMM_5655_Prod_Verify_LM_Devices_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify that the Devices screen loads successfully with all the details")
	public void i_verify_that_the_device_screen_loads_successfully_with_all_the_details() {
		try {
			test = logInfo.get().createNode("I verify that the Devices screen loads successfully with all the details");
			boolean result = testSetup.pageObjectManager.getDevicePage().verifyAllColumnsAvailableInDevicesScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Devices screen verification","" , "All column header available in the Devices dashboard screen");
			}
			else {
				reportFail("Devices screen verification", "", "All column header not available in the Devices dashboard screen");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

 
	@Then("I click on NEW Device button")
	public void i_click_on_new_device_button() {
		
		try {
			test = logInfo.get().createNode("I click on NEW Device button");
			testSetup.pageObjectManager.getDevicePage().clickOnNewDevice();
			reportScreenshot(testSetup.driver);
						 
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I select Device Type as DH6 and verify that the Device ID, Mac Address & Serial Number fields are mandatory {string}")
	public void i_verify_the_device_id_mac_address_serial_number_fields_are_mandatory(String tcid) {
		
		try {
			test = logInfo.get().createNode("I select Device Type as DH6 and verify that the Device ID, Mac Address & Serial Number fields are mandatory");
			test.assignCategory("Production");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			boolean result = testSetup.pageObjectManager.getDevicePage().verifyMandatoryFieldsForDeviceType1(testData);
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for DH6 device type", "The Device ID, Mac Address & Serial Number fields are mandatory" , "The Device ID, Mac Address & Serial Number fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for DH6 device type", "The Device ID, Mac Address & Serial Number fields are mandatory" , "Either Device ID, Mac Address & Serial Number fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I select Device Type as DigiRouter and verify that the Device ID & Mac Address fields are mandatory {string}")
	public void i_verify_the_device_id_mac_address_fields_are_mandatory(String tcid) {
		
		try {
			test = logInfo.get().createNode("I select Device Type as DigiRouter and verify that the Device ID & Mac Address fields are mandatory");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			boolean result = testSetup.pageObjectManager.getDevicePage().verifyMandatoryFieldsForDeviceType2(testData);
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for DigiRouter device type", "The Device ID, Mac Address fields are mandatory" , "The Device ID, Mac Address fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for DigiRouter device type", "The Device ID, Mac Address fields are mandatory" , "Either Device ID, Mac Address fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I select Device Type as H1 and verify that the Device ID field is mandatory {string}")
	public void i_verify_the_device_id_fields_is_mandatory(String tcid) {
		
		try {
			test = logInfo.get().createNode("I select Device Type as H1 and verify that the Device ID field is mandatory");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			boolean result = testSetup.pageObjectManager.getDevicePage().verifyMandatoryFieldsForDeviceType3(testData);
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for H1 device type", "The Device ID field is mandatory" , "The Device ID field is mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for H1 device type", "The Device ID field is mandatory" , "The Device ID fields is not mandatory");
			}
			testSetup.pageObjectManager.getDevicePage().clickOnCancelBtn();

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I search Devices with Device Status as Assigned & Device Type having Settings enabled {string}")
	@Then("I search Devices with Device Status as Not Assigned & Device Type having Settings enabled {string}")
	@Then("I search Devices with Device Status as Assigned & Device Type having Settings disabled {string}")
	public void i_search_devices_with_two_filter_condition(String tcid) {
		
		try {
			test = logInfo.get().createNode("I search Devices with Device Status & Device Type ");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDevicePage().clickOnShowFilter();
			testSetup.pageObjectManager.getDevicePage().searchDevicesWithTwoCondition(testData);
			reportScreenshot(testSetup.driver);

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I verify Settings Icon is enabled")
	public void i_verify_settings_icon_is_enabled() {
		
		try {
			test = logInfo.get().createNode("I verify Settings Icon is enabled");
			boolean isEnabled = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconEnabled();
			reportScreenshot(testSetup.driver);
			if(isEnabled==true) {
				reportPass("Verification of Settings Icon", "Settings Icon is enabled" , "Settings Icon is enabled");
			}
			else {
				reportFail("Verification of Settings Icon", "Settings Icon is enabled" , "Settings Icon is not enabled");
			}
			testSetup.pageObjectManager.getDevicePage().clickOnClearr();
			testSetup.pageObjectManager.getDevicePage().ClickHideFilter();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I verify Settings Icon is disabled")
	public void i_verify_settings_icon_is_disabled() {
		
		try {
			test = logInfo.get().createNode("I verify Settings Icon is disabled");
			String isDisabled = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconDisabled();
			reportScreenshot(testSetup.driver);
			if(isDisabled.equalsIgnoreCase("true")) {
				reportPass("Verification of Settings Icon", "Settings Icon is enabled" , "Settings Icon is enabled");
			}
			else {
				reportFail("Verification of Settings Icon", "Settings Icon is enabled" , "Settings Icon is not enabled");
			}
			testSetup.pageObjectManager.getDevicePage().clickOnClearr();
			testSetup.pageObjectManager.getDevicePage().ClickHideFilter();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I view Device and verify Device details as per filter {string}")
	public void i_view_tenant_and_verify_tenant_details_as_per_filter(String tcid) {
		
		try {
			test = logInfo.get().createNode("I view Device and verify Device details as per filter");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDevicePage().clickOnDeviceViewBtn();
			reportScreenshot(testSetup.driver);
			String actDeviceType=testSetup.pageObjectManager.getDevicePage().getDeviceTypeFromViewScreen();
			String actDeviceStatus=testSetup.pageObjectManager.getDevicePage().getDeviceStatusFromViewScreen();
			
			if(actDeviceType.toLowerCase().contains(testData.get("FilterValue1").toLowerCase()) &&
					actDeviceStatus.equals(testData.get("FilterValue2")))    
			{
				reportPass("Verified Device details", testData.get("FilterValue1"), actDeviceType);
				reportPass("Verified Device details", testData.get("FilterValue2"), actDeviceStatus);
				

			}
			else {
				reportFail("Verified Device details", testData.get("FilterValue1"), actDeviceType);
				reportFail("Verified Device details", testData.get("FilterValue2"), actDeviceStatus);

			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	}