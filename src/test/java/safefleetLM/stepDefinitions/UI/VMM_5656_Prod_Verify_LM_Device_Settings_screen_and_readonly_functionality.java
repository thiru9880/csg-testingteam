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

public class VMM_5656_Prod_Verify_LM_Device_Settings_screen_and_readonly_functionality extends BaseTest {
	
	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;

	public VMM_5656_Prod_Verify_LM_Device_Settings_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify that the Devices Settings screen loads successfully with all the details")
	public void i_verify_that_the_device_settings_screen_loads_successfully_with_all_the_details() {
		try {
			test = logInfo.get().createNode("I verify that the Devices Settings screen loads successfully with all the details");
			boolean result = testSetup.pageObjectManager.getDeviceSettingsPage().verifyColumnsInDeviceSettingsScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Devices Settings screen verification","" , "All columns are available in the Device Settings dashboard screen");
			}
			else {
				reportFail("Devices Settings screen verification", "", "All column are not available in the Device Settings dashboard screen");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

 
	@Then("I click on NEW and verify new Device Settings creation screen")
	public void i_click_on_new_and_verify_new_device_settings_creation_screen() {
		
		try {
			test = logInfo.get().createNode("I click on NEW and verify mandatory fields in new Device Settings creation screen");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getDeviceSettingsPage().clickOnNewDeviceSettingsBtn();
			boolean result = testSetup.pageObjectManager.getDeviceSettingsPage().verifyMandatoryFieldsInNewDeviceSettingsScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields in new Device Settings creation screen", "Pass" , "Pass");
			}
			else {
				reportFail("Verification of mandatory fields in new Device Settings creation screen", "Fail", "Fail");
			}
			testSetup.pageObjectManager.getDeviceSettingsPage().clickCancelAfterEdit();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	

	
	@Then("I search Device Type, view and verify Device Type details as per filter {string}")
	public void i_search_device_type_view_and_verify_device_settings_details(String tcid) {
		
		try {
			test = logInfo.get().createNode("I verify Device Type details as per filter");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter1(testData);
			
			testSetup.pageObjectManager.getDeviceSettingsPage().clickDeviceSettingviewBtn();
			reportScreenshot(testSetup.driver);

			String actDeviceType=testSetup.pageObjectManager.getDeviceSettingsPage().getDeviceTypeFromViewScreen();
			if(	actDeviceType.equals(testData.get("DeviceType")))    
			{
				reportPass("Verified Tenant details", testData.get("DeviceType"), actDeviceType);

			}
			else {
				reportFail("Verified Tenant details", testData.get("DeviceType"), actDeviceType);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	}