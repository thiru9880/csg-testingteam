package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3411_TrackingExpiryDates extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	public VMM_3411_TrackingExpiryDates(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I create new tenant for VMM3411 with test data {string}")
	public void i_create_new_tenant_for_vmm3411_with_test_data(String tcid) throws Exception {


	    try {
	         String tenantID=randomStringGenerator();

	 		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3411_1");

	 		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3411_1");

	 	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3411_2");

	 	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3411_3");

	 	      test = logInfo.get().createNode("I create new tenant with test data");

	 	     test.assignCategory("Licenses");

	         testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

	 	    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

	 	    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

	 	    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
        testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
	 	    reportScreenshot(testSetup.driver);

	 	    reportInfo("New tenant is created with test data ");

	 	    reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I create licenses for SF Vehicle inspection base product with test data {string}")
	public void i_create_licenses_for_sf_vehicle_inspection_base_product_with_test_data(String tcid) throws Exception {
		try {
		     testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

				test = logInfo.get().createNode("I create licenses for SF Vehicle inspection base product with test data");

		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProductWithExpiryDate(testData);
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license for SF Vehicle inspection base product with test data ");

				reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I create licenses for MobileDeviceManager  base product with test data {string}")
	public void i_create_licenses_for_mobile_device_manager_base_product_with_test_data(String tcid) throws Exception {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

			test = logInfo.get().createNode("I create licenses for MobileDeviceManager  base product with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().addFeatureLicenseWithExpiryDate(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("Created new license for MobileDeviceManager  base product with test data ");

			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I create licenses for School Bus Hub  base product with test data {string}")
	public void i_create_licenses_for_school_bus_hub_base_product_with_test_data(String tcid) throws Exception {
		try {
			 test = logInfo.get().createNode("I create licenses for School Bus Hub  base product with test data ");

		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().addFeatureLicenseWithExpiryDate(testData);
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license for School Bus Hub  base product with test data  ");

				reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

@Then("I verify expiration date for all licenses have been added to Licenses table with test data {string}")
public void i_verify_expiration_date_for_all_licenses_have_been_added_to_licenses_table_with_test_data(String tcid) throws Exception {

	 //testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
try {
	test = logInfo.get().createNode("I verify expiration date for all licenses have been added to Licenses table");

	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

	testSetup.pageObjectManager.getLicensesPage().viewAllLicenses(testData);

	reportInfo("Expiry date for all licenses is listed in license table ");

	reportScreenshot(testSetup.driver);
  testSetup.pageObjectManager.getLicensesPage().refreshPage();
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}




}


}
