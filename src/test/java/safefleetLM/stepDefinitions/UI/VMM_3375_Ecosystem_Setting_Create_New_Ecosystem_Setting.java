package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3375_Ecosystem_Setting_Create_New_Ecosystem_Setting extends BaseTest {


	TestSetup testSetup;


	public VMM_3375_Ecosystem_Setting_Create_New_Ecosystem_Setting(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
@Then("I navigate to the Operations")
public void i_navigate_to_the_operations_ecosystem_settings() throws IOException {
	test = logInfo.get().createNode("I navigate to the Operations");
	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	 reportInfo("I navigate to the Operations is successfully");
	}

@Then("I create new tenant for VMM3375 with test data {string}")
public void i_create_new_tenant_for_vmm3375_with_test_data(String tcid) throws Exception {
	try {

		String tenantID=randomStringGenerator();

		System.out.println(tenantID);

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3375_1");
		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3375_1");
	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3375_1");






		test = logInfo.get().createNode("I create the Tenant with Deployment type is onsite");
		test.assignCategory("Ecosystem Settings");
		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		reportInfo(testData.toString());
		//testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
    testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
		reportScreenshot(testSetup.driver);
		String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
		reportScreenshot(testSetup.driver);
		if(AlertMsg.contains("A new Tenant is created with identifier")) {
			reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
			reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created with Deployment type is onsite successfully");
		}
		else
			reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
		testSetup.pageObjectManager.getTenantsPage().continueExecution();
		reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
	}
}


@Then("I create a Ecosystem setting with Test data {string}")
public void i_create_a_ecosystem_setting_with_test_data(String tcid) throws Exception {
	try {
	 test = logInfo.get().createNode("I create a Ecosystem setting with Test data"+tcid);
	    Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
	    reportInfo("Test Data "+testData);
	    testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData);
	    testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	    reportScreenshot(testSetup.driver);
	    reportInfo("I create a Ecosystem setting with Test data and verify is  successfully ");
	}

	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);

	}

}
@Then("I view metadata and verify")
public void i_view_metadata_and_verify() throws Exception {
	try {
	 test = logInfo.get().createNode("I view metadata and verify");
	 testSetup.pageObjectManager.getEcosystemSettingsPage().viewmetadata();
	  reportScreenshot(testSetup.driver);

	 String text1=testSetup.pageObjectManager.getEcosystemSettingsPage().metadataverify();
	 reportPass("EcoSystem Setting page" , "View Ecosystem Settings", text1);
	 testSetup.pageObjectManager.getEcosystemSettingsPage().backtoecosetting();

	    reportInfo("I view metadata and verify metadata successfully ");
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);

	}
}


@Then("I edit metadata with {string}and SAVE")

public void i_edit_metadata_with_vmm3375_and_save1(String tcid) throws Exception {
	try {
	  test = logInfo.get().createNode("I edit metadata with {string}and SAVE");
	  Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid );
	  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	 // Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid );
	  testSetup.pageObjectManager.getEcosystemSettingsPage().editmetadata(testData);
	  reportScreenshot(testSetup.driver);
	  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	  testSetup.pageObjectManager.getEcosystemSettingsPage().viewmetadata();
	  String text2=testSetup.pageObjectManager.getEcosystemSettingsPage().verifyedit();
	  testSetup.pageObjectManager.getEcosystemSettingsPage().backtoecosetting();
	  reportPass("EcoSystem Setting page" , testData.get("Distance_Measurement"), text2);

	 reportInfo("I edit metadata  and verify successfully");


}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}
@Then("I delete the Ecosystem Setting and verify with testdata {string}")
public void i_delete_the_ecosystem_setting_and_verify_with_testdata(String tcid) {
	try {
	  test = logInfo.get().createNode("I delete the Ecosystem Setting and verify");
	  Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid );
	  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	  testSetup.pageObjectManager.getEcosystemSettingsPage().deletedata();
	  reportScreenshot(testSetup.driver);
	 // reportInfo("I delete the Ecosystem Setting verify successfully");
	  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	  reportScreenshot(testSetup.driver);

	reportInfo("I delete the Ecosystem Setting and verify successfully");
}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}



}
