package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3285_Only_certain_license_types_will_require_servers_managed_in_license_type extends BaseTest {

	TestSetup testSetup;

	public VMM_3285_Only_certain_license_types_will_require_servers_managed_in_license_type(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I verify Server data is mandatory for only certain license types")
	public void i_verify_server_data_is_mandatory_for_only_certain_license_types() throws Exception {
		try {
		test = logInfo.get().createNode("I verify Server data is mandatory for only certain license types"); // License Types
		test.assignCategory("License Types");
		reportScreenshot(testSetup.driver);
		 reportInfo("Verify Server data is mandatory for only certain license types is successful");
	}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create new tenant for VMM3285 with test data {string}")
	public void i_create_new_tenant_for_vmm3285_with_test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I create new tenant for VMM3285 with test data");

String tenantID=randomStringGenerator();

		System.out.println(tenantID);

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3285_1");

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3285_1");





	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
        testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();

		    reportInfo("New tenant is created with test data ");

		    reportInfo("Test data "+testData);

		    reportScreenshot(testSetup.driver);
		// reportScreenshot(testSetup.driver);
		 //reportInfo("I create new tenant for VMM3285 with test data is successfully");
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Verify that when creating licenses with test data {string},Server data is mandatory for only certain license types")
	public void i_verify_that_when_creating_licenses_with_test_data_server_data_is_mandatory_for_only_certain_license_types(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Verify that when creating licenses with test data,Server data is mandatory for only certain license types");
		 Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		testSetup.pageObjectManager.getLicensesPage().verifyserver(testData);


		 String text=testSetup.pageObjectManager.getLicensesPage().verifyserverlabel();
		 if(text.equalsIgnoreCase("* Server"))
		 {
		reportPass("License page" ,"* Server", text);
	    reportScreenshot(testSetup.driver);
	    reportInfo("Server lable Displyed successfully ");
		 }
		 else
		 {
			 reportFail("License page" ,"* Server", text);
			 reportScreenshot(testSetup.driver);
			 reportInfo("Server lable not Displyed");

		 }
		 reportInfo("Verify that when creating licenses with test data,Server data is mandatory for only certain license types is succesful");

		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}


}
