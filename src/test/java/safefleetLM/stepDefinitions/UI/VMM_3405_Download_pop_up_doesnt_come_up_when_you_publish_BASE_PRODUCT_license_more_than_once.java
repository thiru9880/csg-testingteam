package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3405_Download_pop_up_doesnt_come_up_when_you_publish_BASE_PRODUCT_license_more_than_once extends BaseTest {

	TestSetup testSetup;


	public VMM_3405_Download_pop_up_doesnt_come_up_when_you_publish_BASE_PRODUCT_license_more_than_once(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I create new tenant for licenses with test data {string}")
	public void i_create_new_tenant_for_licenses_with_test_data(String tcid) throws Exception
	{
String tenantID=randomStringGenerator();

		System.out.println(tenantID);

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3405_1");

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3405_1");

		    test = logInfo.get().createNode("I create new tenant with test data");

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
        testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
		    testSetup.pageObjectManager.getTenantsPage().searchTenants(testData);
		    reportInfo("New tenant is created with test data ");

		    reportInfo("Test data "+testData);
		    reportScreenshot(testSetup.driver);
		    reportInfo("New tenant is created Successfully ");
	}

	@Then("I click on new to create license for BASE_PRODUCT License Type with test data {string}")
	public void  i_click_on_new_to_create_license_for_base_product_license_type_with_test_data(String tcid) throws Exception
	{
		try {
		test = logInfo.get().createNode("I create new license for BASE_PRODUCT License Type with test data");
		test.assignCategory("Licenses");
		 reportInfo("I click on new to create license for BASE_PRODUCT License Type with test data");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();
		testSetup.pageObjectManager.getLicensesPage().createLicenses(testData);
		reportInfo("Create license for BASE_PRODUCT License Type with test data Successful");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I Verify in the license table for a BASE_PRODUCT license {string}")
	public void i_verify_in_the_license_table_for_a_base_product_license(String tcid) throws Exception
	{
		try {
		test = logInfo.get().createNode("I Verify in the license table for a BASE_PRODUCT license");
		 reportInfo("I Verify in the license table for a BASE_PRODUCT license");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		testSetup.pageObjectManager.getLicensesPage().entertheTenantID(testData);
		reportScreenshot(testSetup.driver);
		reportInfo("Verifying in the license table for a BASE_PRODUCT license Successful");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}

	@Then("I click the publish action menu for the license")
	public void i_click_the_publish_action_menu_for_the_license() throws Exception
	{
		try {
		test = logInfo.get().createNode("I click the publish action menu for the license");
		 reportInfo("I click the publish action menu for the license");
		testSetup.pageObjectManager.getLicensesPage().clickedonPublishBtn();
		 reportInfo("Clicking the publish action menu for the license Successful");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}

	@Then("I click the download license checkbox in the Pop_up")
	public void i_click_the_download_license_checkbox_in_the_pop_up() throws Exception
	{
		try {
		test = logInfo.get().createNode("I click the download license checkbox in the Pop-up");
		 reportInfo("I click the download license checkbox in the Pop_up");
		 reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getLicensesPage().verifydownloadBoxCheck();
		reportInfo("Status Chnage from Draft To Publish");
		reportScreenshot(testSetup.driver);
			reportInfo("Click the download license checkbox in the Pop_up Successful");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}

	@Then("I Verify that Download Pop up come up when you publish more than ones")
	public void i_verify_that_download_pop_up_come_up_when_you_publish_more_than_ones() throws Exception
	{
		try {
		test = logInfo.get().createNode("I Verify that Download Pop up come up when you publish more than ones");
		 reportInfo("I Verify that Download Pop up come up when you publish more than ones");
		 Thread.sleep(3000);
		testSetup.pageObjectManager.getLicensesPage().clickedonPublishBtn();
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getLicensesPage().verifydownloadBoxCheck();
		 reportInfo("Verifying that Download Pop up come up when you publish more than ones Successful");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}

}
