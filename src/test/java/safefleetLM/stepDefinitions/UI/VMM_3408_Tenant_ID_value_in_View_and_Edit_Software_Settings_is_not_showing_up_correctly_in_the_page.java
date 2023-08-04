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

public class VMM_3408_Tenant_ID_value_in_View_and_Edit_Software_Settings_is_not_showing_up_correctly_in_the_page extends BaseTest {

	TestSetup testSetup;

	public VMM_3408_Tenant_ID_value_in_View_and_Edit_Software_Settings_is_not_showing_up_correctly_in_the_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

@Then("I create Ecosystem setting with Test data {string}")
public void i_create_ecosystem_setting_with_test_data(String tcid) throws Exception {
	try {
	 test = logInfo.get().createNode("I create a Ecosystem setting with Test data"+tcid);
	    Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid);
	    reportInfo("Test Data "+testData);
	    testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings2(testData);
	    String AlertMsg = testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingSave(testData);
		reportScreenshot(testSetup.driver);
		if(AlertMsg.contains("A new Settings is created with identifier"))
		{
		 reportPass("EcoSystem Setting ", "A new Settings is created with identifier", AlertMsg);
		 reportInfo("Create a Ecosystem setting with Test data successfully ");
		}
		else {
		reportFail("EcoSystem Setting ", "A new Settings is created with identifier", AlertMsg);
		testSetup.pageObjectManager.getEcosystemSettingsPage().continueExecutionSetting();
		 reportInfo("Create a Ecosystem setting with Test data Not Created ");
		}
		}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);

		reportFail("","EcoSystem setting Already exist," ,"EcoSystem setting to be Unique" );
	}


	}


	@Then("I create new Tenant for VMM3408 with test data {string}")
	public void i_create_new_tenant_for_VMM3408_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create new Tenant with test data  "+tcid);
			test.assignCategory("Ecosystem Settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			//testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
      testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
      testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
			reportScreenshot(testSetup.driver);
			String ActualId = testSetup.pageObjectManager.getTenantsPage().saveConfirmation(testData);
			reportScreenshot(testSetup.driver);
			if(ActualId.equalsIgnoreCase(testData.get("TenantID"))) {
				reportPass("Tenant Created ID:", testData.get("TenantID").toLowerCase(), ActualId);
				reportInfo("New Tenant created successfully");}
			else {
				reportFail("Tenant Created ID:", testData.get("TenantID").toLowerCase(), ActualId);
			reportInfo("New Tenant NOT created successfully");}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution();
			reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
		}
	}

@Then("I view Ecosetting with test data {string}")
public void i_view_ecosetting_with_test_data(String tcid) throws Exception {
	try {
	 test = logInfo.get().createNode("I view Ecosetting");
	 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
	 testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	 testSetup.pageObjectManager.getEcosystemSettingsPage().viewmetadata();
	 reportScreenshot(testSetup.driver);
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Verify the tenantid field and label with testdata {string}")
public void i_verify_the_tenantid_field_and_label_with_testdata(String tcid) throws Exception {
	try {
	 test = logInfo.get().createNode("I Verify the tenantid field and label");
	 String label = testSetup.pageObjectManager.getEcosystemSettingsPage().verifytenantIDlabel();
	 if(label.equalsIgnoreCase("* Tenant ID"))
	 {
	reportPass("TenantID label " ,"* Tenant ID", label);
    reportScreenshot(testSetup.driver);
    reportInfo("Tenant ID lable Displyed successfully ");
	 }
	 else
	 {
		 reportFail("TenantID label" ,"* Tenant ID", label);
		 reportScreenshot(testSetup.driver);
		 reportInfo("Tenant ID lable not Displyed");

	 }

	 Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
	 String text= testSetup.pageObjectManager.getEcosystemSettingsPage().verifytenantIDfield();
	 if (text.equalsIgnoreCase(testData.get("TenantID"))) {
		 reportPass("TenantID field " ,testData.get("TenantID"), text);
		    reportScreenshot(testSetup.driver);
		    reportInfo("Tenant ID  Displyed successfully ");
	} else {
		 reportFail("TenantID field " ,testData.get("TenantID"), text);
		 reportScreenshot(testSetup.driver);
		 reportInfo("Tenant ID  not Displyed");

	}


	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}



}

@Then("I Click Back button")
public void i_click_back_button() {
	try {
	 test = logInfo.get().createNode("I Click Back button");
	 testSetup.pageObjectManager.getEcosystemSettingsPage().clickecosettingbackBtn();
	 reportInfo("Click Back button Successful");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Click the edit button with test data {string}")
public void i_click_the_edit_button_with_test_data(String tcid) {
	try {
	 test = logInfo.get().createNode("I Click the edit button");
	 Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid );
	  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
	  testSetup.pageObjectManager.getEcosystemSettingsPage().clickecosettingeditbtn();
	  reportScreenshot(testSetup.driver);
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}



}
