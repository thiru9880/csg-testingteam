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

public class VMM_5657_Prod_Verify_LM_Ecosystem_Settings_screen_and_readonly_functionality extends BaseTest {
	
	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;

	public VMM_5657_Prod_Verify_LM_Ecosystem_Settings_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify that the Ecosystem Settings screen loads successfully with all the details")
	public void i_verify_that_the_ecosystem_settings_screen_loads_successfully_with_all_the_details() {
		try {
			test = logInfo.get().createNode("I verify that the Ecosystem Settings screen loads successfully with all the details");
			boolean result = testSetup.pageObjectManager.getEcosystemSettingsPage().verifyColumnsInEcosystemSettingsScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Ecosystem Settings screen verification","" , "All columns are available in the Ecosystem Settings dashboard screen");
			}
			else {
				reportFail("Ecosystem Settings screen verification", "", "All column are not available in the Ecosystem Settings dashboard screen");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

 
	@Then("I click on NEW and verify new Ecosystem Settings creation screen")
	public void i_click_on_new_and_verify_new_ecosystem_settings_creation_screen() {
		
		try {
			test = logInfo.get().createNode("I click on NEW and verify mandatory fields in new Ecosystem Settings creation screen");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnEcosystemNewbtn();
			boolean result = testSetup.pageObjectManager.getEcosystemSettingsPage().verifyMandatoryFieldsInNewEcosystemSettingsScreen();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields in new Ecosystem Settings creation screen", "Pass" , "Pass");
			}
			else {
				reportFail("Verification of mandatory fields in new Ecosystem Settings creation screen", "Fail", "Fail");
			}
			testSetup.pageObjectManager.getEcosystemSettingsPage().ecosysCancleBtn();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	

	
	@Then("I search PTLW, view and verify PTLW details as per filter {string}")
	public void i_search_device_type_view_and_verify_device_settings_details(String tcid) {
		
		try {
			test = logInfo.get().createNode("I search PTLW, view and verify PTLW details as per filter");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnShowFilter();
			testSetup.pageObjectManager.getEcosystemSettingsPage().searchEcosystem(testData);
			testSetup.pageObjectManager.getEcosystemSettingsPage().clickEcosystemSettingsviewBtn();
			reportScreenshot(testSetup.driver);

			String actEcosystem=testSetup.pageObjectManager.getEcosystemSettingsPage().getEcosystemValueFromViewScreen();
			if(	actEcosystem.equals(testData.get("Ecosystem")))    
			{
				reportPass("Verified Tenant details", testData.get("DeviceType"), actEcosystem);

			}
			else {
				reportFail("Verified Tenant details", testData.get("DeviceType"), actEcosystem);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	}