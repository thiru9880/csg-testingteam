package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.List;
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

public class VMM_3284_Server_Should_be_removed_from_Tenants_and_moved_into_Licenses extends BaseTest {

	TestSetup testSetup;

	public VMM_3284_Server_Should_be_removed_from_Tenants_and_moved_into_Licenses(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

List<String> BaseProductServer;

	List<String> LicensesServer;

	@Then("I click Edit Base Product with {string}")
	public void i_click_edit_base_product_with(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Edit Base Product with test data  "+tcid);
		Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
		testSetup.pageObjectManager.getBaseProductPage().viewbaseproduct(testData);
		BaseProductServer=testSetup.pageObjectManager.getBaseProductPage().baseProductservers(testData);
		String ServerofbaseProduct=BaseProductServer.toString();
		reportInfo("The servers selected in base product are= "+ServerofbaseProduct);
		reportScreenshot(testSetup.driver);
		reportInfo("verify servers Selected exist Successful");
		reportScreenshot(testSetup.driver);
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
@Then("I create new Tenant for VMM3284 with test data {string}")
public void i_create_new_tenant_for_vmm3284_with_test_data(String tcid) throws Exception {
	try {
		test = logInfo.get().createNode("I create new Tenant with test data  "+tcid);
		test.assignCategory("Licenses");
		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		reportInfo(testData.toString());
		//testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
    testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
    testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
		reportScreenshot(testSetup.driver);
		//testSetup.pageObjectManager.getTenantsPage().tenantSave();
		//reportScreenshot(testSetup.driver);
		String ActualId = testSetup.pageObjectManager.getTenantsPage().saveConfirmation(testData);
		reportScreenshot(testSetup.driver);
		//Thread.sleep(3000);
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

@Then("I Navigate to Tenants tab")
public void i_navigate_to_tenants_tab() {
	try {
		test = logInfo.get().createNode("I Navigate to Tenants tab");
	testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
	reportInfo("Navigate to Tenants tab successfully");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I create new Licenses with testdata {string}")
public void i_create_new_licenses_with_testdata(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I create new Licenses");// fillAddLicenses
	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	reportInfo(testData.toString());
	LicensesServer=testSetup.pageObjectManager.getLicensesPage().clickcreateLicense(testData);
	reportScreenshot(testSetup.driver);
	//testSetup.pageObjectManager.getLicensesPage().licensesServers(testData);
	String ServerofLicenses=LicensesServer.toString();
	reportInfo("The servers selected in base product are= "+ServerofLicenses);
	reportScreenshot(testSetup.driver);

	boolean result=testSetup.pageObjectManager.getLicensesPage().compareServer(BaseProductServer,LicensesServer);
	if(result==true)
	{
		reportPass("Base Server Data and Licenses Server Data Matches", "Servers Selected in Software Matches with Servers Selected in licenses", "Servers in Licenses Server TextBox matches with Servers in Software");
		reportInfo("Verifying servers are available in the servers dropdown Successful");
	}
	else
	{
		reportFail("Base Server Data and Licenses Server Data Not Matches", "Servers Selected in Software Not Matches with Servers Selected in licenses", "Servers in Licenses Server TextBox Not matches with Servers in Software");
		reportInfo("Verifying servers are available in the servers dropdown Successful");
	}
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}


}





}
