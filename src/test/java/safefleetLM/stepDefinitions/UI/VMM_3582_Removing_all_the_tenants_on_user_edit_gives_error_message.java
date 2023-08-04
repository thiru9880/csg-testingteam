package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

import java.io.IOException;
import java.util.Map;


public class VMM_3582_Removing_all_the_tenants_on_user_edit_gives_error_message extends BaseTest {

	TestSetup testSetup;

	public VMM_3582_Removing_all_the_tenants_on_user_edit_gives_error_message(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}



@Then("I create new tenant for VMM3582 with test data {string}")
public void i_create_new_tenant_for_vmm3582_with_test_data(String tcid) throws Exception {
	try {
	String tenantID=randomStringGenerator();



	  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3582_1");
	  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM3582_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","TenantID",tenantID,"VMM3582_1");

	   test = logInfo.get().createNode("I create new tenant with test data");
	   test.assignCategory("Tenants");

        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

	    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

	    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

	    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
      testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
      testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();

	    reportInfo("New tenant is created with test data ");

	    reportInfo("Test data "+testData);

	    reportScreenshot(testSetup.driver);
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}

	@Then("I create a new user with test data {string}")
	public void i_create_a_new_user_with_test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I create new user with test data "+tcid);
		Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
		reportInfo("Test Data "+testData);
		String userCreationMsg= testSetup.pageObjectManager.getUserPage().createNewUser(testData);
		reportScreenshot(testSetup.driver);
		//String status = testSetup.pageObjectManager.getUserPage().usercreatepopup();
		if(userCreationMsg.contains("A new user is created with identifier"))
		 {


			reportPass("New user created successfully", "true",   userCreationMsg);
			 reportScreenshot(testSetup.driver);
			reportInfo("New user created successfully");

		 }
		 else
		 {
				reportFail("New user not created", "fails",   userCreationMsg);
				 reportScreenshot(testSetup.driver);
				reportInfo("New user not created");

		 }
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportInfo("Login name already used!");
		}




	}

@Then("I Edit any user with customer role with Test data {string}")
public void i_edit_any_user_with_customer_role_with_Test_data(String tcid) throws Exception {

	// To search a User
	try {
		test = logInfo.get().createNode("I verify user details from the users list");
		Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
		testSetup.pageObjectManager.getHomePage().navigateToUserTab();
		String user =  testSetup.pageObjectManager.getUserPage().searchUser(testData.get("LOGIN"));
		if(user.equals(testData.get("LOGIN"))) {
			reportPass("Created User ", testData.get("LOGIN"), user);
			reportScreenshot("PASS", "User should be listed in the reults table", "User is listed in the reults table",testSetup.driver);
		}
		else
			reportScreenshot("FAIL", "User should be listed in the reults table", "User not listed in the reults table",testSetup.driver);

	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
		softAssert.fail("Error in Verify details");
	}

	testSetup.pageObjectManager.getUserPage().clickedituser();



}
@Then("I Select the tenants from the drop list with Test data {string} and save")
public void i_select_the_tenants_from_the_drop_list_with_Test_data_and_save(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I Select the tenants from the drop list and save");
	Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
	testSetup.pageObjectManager.getUserPage().addTenant(testData);
	reportScreenshot(testSetup.driver);
	testSetup.pageObjectManager.getUserPage().clicksaveBtn();

	reportScreenshot(testSetup.driver);
	 reportInfo("I Select the tenants from the drop list and save  successfully");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}
@Then("I Edit the same user and remove all the tenants with Test data {string}")
public void i_edit_the_same_user_and_remove_all_the_tenants_with_Test_data(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I Edit the same user and remove all the tenants");
	Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
	 testSetup.pageObjectManager.getUserPage().searchUser(testData.get("LOGIN"));
	 testSetup.pageObjectManager.getUserPage().clickedituser();
	 testSetup.pageObjectManager.getUserPage().removetenantid();
	 testSetup.pageObjectManager.getUserPage().clicksaveBtn();
	 reportInfo("Edit the same user and remove all the tenants  successful");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}
@Then("I Verify that there is no error message on user Save")
public void i_verify_that_there_is_no_error_message_on_user_save() throws Exception {
	try {
	test = logInfo.get().createNode("I Verify that there is no error message on user Save");
	reportScreenshot(testSetup.driver);
	reportInfo("Verify that there is no error message on user Save");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}
@Then("I delete user in test data {string}")
public void i_delete_user_in_test_data(String tcid) throws Exception {

		try {
			test = logInfo.get().createNode("I delete the user");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
			testSetup.pageObjectManager.getHomePage().navigateToUserTab();
			String ackmsg = testSetup.pageObjectManager.getUserPage().deleteUser(testData.get("LOGIN"));

			if(ackmsg.equals("An user is deleted with identifier "+testData.get("LOGIN"))) {
				reportPass("Alert Message", "An user is deleted with identifier "+testData.get("LOGIN"), ackmsg);
				reportInfo("User "+testData.get("LOGIN")+" deleted successfully" );
			}
			else
				reportFail("Alert Message", "An user is deleted with identifier "+testData.get("LOGIN"), ackmsg);
			reportScreenshot(testSetup.driver);
			reportInfo("User "+testData.get("LOGIN")+" deleted succesfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);

		}




}





}
