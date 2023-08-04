package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3393_Ecosystem_Settings_Tenant_ID_narrow_picklist extends BaseTest {

	TestSetup testSetup;

	public VMM_3393_Ecosystem_Settings_Tenant_ID_narrow_picklist(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create new tenant for VMM3393 with test data {string}")
	public void i_create_new_tenant_for_vmm3393_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create new tenant for VMM3393 with test data");
			test.assignCategory("Ecosystem Settings");

         String tenantID=randomStringGenerator();



		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3393_1");
		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM3393_1");


	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM3393_1");





	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
        testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();

		    //reportInfo("New tenant is created with test data ");

		    reportInfo("Test data "+testData);

		    reportScreenshot(testSetup.driver);
		    reportInfo("New tenant is created with test data is successful ");
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I navigate to Operations")
	public void i_navigate_operations() {
		try {
		test = logInfo.get().createNode("I navigate to the Operations");
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		 reportInfo("Navigate to the Operations tab is successful");

	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}
	@Then("I navigate to Ecosystem Setting")
	public void i_navigate_to_ecosystem_setting() throws Exception {
		try {
		test = logInfo.get().createNode("I navigate to ecosystem settings Tab");
		testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
		reportInfo("Navigated to Ecosystem settings tab is successful");


	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}
	@Then("I Click on NEW to create new ecosystem settings with Test data {string}")
	public void Click_on_NEW_to_create_new_ecosystem_settings_with_test_data(String tcid) throws Exception  {
		//testSetup.pageObjectManager. getHomePage().navigateToEcoSystemTab();
		try {
		 test = logInfo.get().createNode("I Click on NEW to create new ecosystem settings");
		  Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
		    reportInfo("Test Data "+testData);
		    testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData);

			reportScreenshot(testSetup.driver);


			 String status=testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingcreatepopup1();
			 if(status.equals("true"))
			 {


				reportPass("Ecosetting created successfully", "true",  testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingcreatepopup1());
				 reportScreenshot(testSetup.driver);
				reportInfo("Ecosetting created successful");

			 }
			 else
			 {
					reportFail("Ecosetting not created", "fails",  testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingcreatepopup1());
					 reportScreenshot(testSetup.driver);
					reportInfo("Ecosetting not created");

			 }



		}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
		 reportInfo("Unable to create Ecosystem setting");
	}
	}
	@Then("I Verify that Tenant ID value, the picklist should be narrowed down with Test data {string}")
	public void i_verify_that_tenant_id_value_the_picklist_should_be_narrowed_down_with_test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Verify that Tenant ID value, the picklist should be narrowed down with Test data");
		   Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
		    reportInfo("Test Data "+testData);
		    testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
		    testSetup.pageObjectManager.getEcosystemSettingsPage().newecobtn();
		testSetup.pageObjectManager.getEcosystemSettingsPage().tenanttxtfild(testData);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that Tenant ID value, the picklist should be narrowed down is successful");
	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}

	@Then("I Verify that Tenant ID filter works fine with all the equality operations with Test data {string}")
	public void i_verify_that_tenant_id_filter_works_fine_with_all_the_equality_operations_with_test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Verify that Tenant ID filter works fine with all the equality operations");
		 Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
		    reportInfo("Test Data "+testData);
		testSetup.pageObjectManager.getEcosystemSettingsPage().TenantIDcontains(testData);
		reportInfo("Verify that Tenant ID filter works fine with  'contains' equality operations is successful");
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getEcosystemSettingsPage().TenantIDnotequals(testData);
		reportInfo("Verify that Tenant ID filter works fine with 'not equal' equality operations is successful");
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getEcosystemSettingsPage().TenantIDequals(testData);
		reportInfo("Verify that Tenant ID filter works fine with  'equals' equality operations is successful");
		reportScreenshot(testSetup.driver);
		 // testSetup.pageObjectManager.getEcosystemSettingsPage().deletedata();

		reportInfo("Verify that Tenant ID filter works fine with all the equality operations is successful");

	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}
	@Then("I Click the clipboard symbol with Test data {string}")
	public void i_click_the_clipboard_symbol_with_test_data(String tcid) throws Exception{
		try {
		test = logInfo.get().createNode("I Click the clipboard symbol");
		 Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
		    reportInfo("Test Data "+testData);
		//testSetup.pageObjectManager.getEcosystemSettingsPage().TenantIDequals(testData);
		testSetup.pageObjectManager.getEcosystemSettingsPage().clipboardBtn();
		reportInfo("Click the clipboard symbol is successful");

	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}
	@Then("I Verify the Entity Audits page loads showing Changes for SettingsInstance with Test data {string}")
	public void i_verify_the_entity_audits_page_loads_showing_changes_for_settings_instance_with_test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Verify the Entity Audits page loads showing Changes for SettingsInstance");
		testSetup.pageObjectManager.getEcosystemSettingsPage().loadchangelist();
		//testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

		reportScreenshot(testSetup.driver);
		String text = testSetup.pageObjectManager.getEcosystemSettingsPage().entityAuditsverify();
		 reportPass("EcoSystem Setting page" , "Last 25 Changes for SettingsInstance", text);
		//testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

		 Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
		    reportInfo("Test Data "+testData);
	    testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
		testSetup.pageObjectManager.getEcosystemSettingsPage().TenantIDcontains(testData);
		testSetup.pageObjectManager.getEcosystemSettingsPage().deletedata();



		reportInfo("Verify the Entity Audits page loads showing Changes for SettingsInstance is successful");
	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}




}
