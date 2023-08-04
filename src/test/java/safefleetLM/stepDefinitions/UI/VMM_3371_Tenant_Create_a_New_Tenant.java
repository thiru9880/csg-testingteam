package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.PageObjectManager;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3371_Tenant_Create_a_New_Tenant extends BaseTest {

	TestSetup testSetup;


	public VMM_3371_Tenant_Create_a_New_Tenant(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@When("I click on System Admin to navigate Tenant types tab")
	public void i_click_on_system_admin_to_navigate_tenant_type() throws IOException {
		try {
			test = logInfo.get().createNode("I click on System Admin to navigate Tenant types tab");
			test.assignCategory("Tenants");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantTypesTab();
			reportScreenshot(testSetup.driver);
			reportInfo("I navigate to Tenant types tab successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I verify the Commercial vehicle {string}")
	public void i_verify_the_commercial_vehicle(String tcid) throws Exception {
		try{
			test = logInfo.get().createNode("I verify the Commercial vehicle in Tenant types tab");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			boolean status=testSetup.pageObjectManager.getTenantTypesPage().verifyCommercialVehicle(testData);
			reportScreenshot(testSetup.driver);
			if(status==true)
				reportPass("Tenant Type", "Commercial", testData.get("VerifyTypes"));
			else
				reportFail("Tenant Type","Commercial",testData.get("VerifyTypes"));
			reportInfo("I verify the Commercial vehicle in Tenant types tab successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	@Then("I click on operations to navigate Tenants tab")
	public void i_click_on_operations_to_navigate_tenants_tab() throws IOException {
		try {
			test = logInfo.get().createNode("I click on operations to navigate Tenants tab");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			reportScreenshot(testSetup.driver);
			reportInfo("I navigate to Tenants tab successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I click on CREATE A NEW TENANT and verify Commercial Vehicle in Tenant Type picklist {string}")
	public void i_click_on_create_a_new_tenant_and_verify_commercial_vehicle_in_tenant_type_picklist(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I click on CREATE A NEW TENANT and verify Commercial Vehicle in Tenant Type picklist");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			String ActualType = testSetup.pageObjectManager.getTenantsPage().verifyTenantType(testData);
			reportScreenshot(testSetup.driver);
			if(ActualType.equals(testData.get("VerifyTypes")))
				reportPass("Tenant Type", testData.get("VerifyTypes"), ActualType);
			else
				reportFail("Tenant Type", testData.get("VerifyTypes"), ActualType);
			testSetup.pageObjectManager.getTenantsPage().clickCancelBtn();
			reportInfo("I verified the option "+testData.get("VerifyTypes")+" in Tenant Type picklist successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I create new Tenant with test data {string}")
	public void i_create_new_tenant_with_test_data(String tcid) throws Exception {
		try {

			String tenantID=randomStringGenerator();

			if(tcid.equals("VMM_3371_1"))
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3371_1");
			else if(tcid.equals("VMM_3409_1")) {
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3409_1");
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3409_1");
				}
			else if(tcid.equals("VMM_3848_1")) {
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3848_1");
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3848_1");
				}
			test = logInfo.get().createNode("I create new Tenant with test data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
			}
			else
				reportFail("Tenant ", "A new Tenant is created with identifier", AlertMsg);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution();
			reportFail("","Tenant id exist," ,"Tenant id must be unique" );
		}
	}


	@Then("I verify the Tenant Information in Tenant metadata {string}")
	public void i_verify_the_tenant_information_in_tenant_metadata(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify the Tenant Information in Tenant metadata");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			String ActualId = testSetup.pageObjectManager.getTenantsPage().verifyTenantInformation(testData);
			reportScreenshot(testSetup.driver);

			if(ActualId.equalsIgnoreCase(testData.get("TenantID"))) {
				reportPass("Tenant ID", testData.get("TenantID"), ActualId);
				reportInfo("Verify the Tenant Information in Tenant metadata successfully");}
			else
				reportFail("Tenant ID", testData.get("TenantID"), ActualId);

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Tenant ID" ,"Tenant id is NOT exist");
		}
	}
	@Then("I Verify Tenant ID should be converted to lower case {string}")
	public void i_verify_tenant_id_should_be_converted_to_lower_case(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify Tenant ID should be converted to lower case");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			String ActualID = testSetup.pageObjectManager.getTenantsPage().verifyIdCase(testData);
			reportScreenshot(testSetup.driver);
			if(ActualID.equals(testData.get("TenantID").toLowerCase())) {
				reportPass("Tenant ID", testData.get("TenantID").toLowerCase(), ActualID);
				reportInfo("I verified that Tenant ID converted to lower case successfully");
			}
			else
				reportFail("Tenant ID", testData.get("TenantID").toLowerCase(), ActualID);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Tenant ID converted to lower case" ,"Tenant id is NOT exist");
		}
	}
	@Then("I edit Tenant metadata and verify in Tenant table {string}")
	public void i_edit_tenant_metadata_and_verify_in_tenant_table(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3371_1");

			test = logInfo.get().createNode("I edit Tenant metadata and verify in Tenant table");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().editTenantUserData(testData);
			String EditedID = testSetup.pageObjectManager.getTenantsPage().verifyEditedTenant(testData);
			reportScreenshot(testSetup.driver);
			if(EditedID.equalsIgnoreCase(testData.get("EditedTenantID"))) {
				reportPass("Edited Tenant ID", testData.get("EditedTenantID"), EditedID);
				reportInfo("Tenant metadata edited and verified successfully");
			}
			else {
				reportFail("Edited Tenant ID", testData.get("EditedTenantID"), EditedID);
				reportInfo("Tenant metadata NOT edited");}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution2();
			reportFail("","Tenant ID edit" ,"TENANT ID IS NOT ABLE TO EDIT");
		}
	}

	@Then("I delete the edited Tenant {string}")
	public void i_delete_the_tenant(String tcid) throws Exception {
		try{
			test = logInfo.get().createNode("I delete the Tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			boolean result = testSetup.pageObjectManager.getTenantsPage().deleteEditedTenant(testData);
			reportScreenshot(testSetup.driver);
			if(result==true) {
				String AlertMsg = testSetup.pageObjectManager.getTenantsPage().deleteConfirmation();
				reportScreenshot(testSetup.driver);
				reportPass("Delete Message", "A Tenant is deleted with identifier", AlertMsg);
				reportInfo("Tenant ID '"+testData.get("TenantID")+"' deleted successfully");
			}
			else {
				reportFail("FAIL", "Delete Tenent", "Not Deleted");
				reportInfo("Tenant ID "+testData.get("TenantID")+" NOT deleted successfully");
			}
		}
		catch(Exception e)
		{
			testStepHandle("Fail", testSetup.driver, test, e);
			reportFail("","Delete Tenant" ,"Tenant id is NOT exist for Delete");
		}
	}

	@Then("I click on SHOW FILTERS to verify Customer id filter")
	public void i_click_on_show_filters_to_verify_customer_id_filter()
	{
		try {
			test = logInfo.get().createNode("I click on SHOW FILTERS to verify Customer id filter");
			String filterType = testSetup.pageObjectManager.getTenantsPage().checkCustomerFilter();
			reportScreenshot(testSetup.driver);
			if(filterType.equals("Customer")) {
				reportPass("Filter Type", "Customer", filterType);
				reportInfo("I verify the Customer filter by clicking the SHOW FILTER is successful");
			}
			else {
				reportFail("Filter Type", "Customer", filterType);
			}
		}
		catch(Exception e)
		{
			testStepHandle("Fail", testSetup.driver, test, e);
		}
	}

}
