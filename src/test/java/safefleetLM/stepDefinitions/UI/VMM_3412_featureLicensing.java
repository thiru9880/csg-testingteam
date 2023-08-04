package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3412_featureLicensing extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	public VMM_3412_featureLicensing(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}



	@Then("I create new tenant for VMM3412 with test data {string}")
	public void i_create_new_tenant_for_vmm3412_with_test_data(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3412_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3412_1");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3412_2");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3412_3");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3412_4");

			test = logInfo.get().createNode("I create new tenant with test data");

			 test.assignCategory("Licenses");

	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    //testSetup.pageObjectManager.getTenantsPage().createNewTenantWithAdminMail(testData);
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


	@Then("I create licenses for SF Live base product for the license types:BASE_PRODUCT with test data {string}")
	public void i_create_licenses_for_sf_live_base_product_for_the_license_types_base_product_with_test_data(String tcid) throws Exception {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

			test = logInfo.get().createNode("I create licenses for SF Live base product for the license types:BASE_PRODUCT with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("Created new license for the license types: types:BASE_PRODUCT with test data ");

			reportInfo("Test data "+testData);

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I create licenses for SF Live base product for the license types:STUDENT_TRACKING with test data {string}")
	public void i_create_licenses_for_sf_live_base_product_for_the_license_types_student_tracking_with_test_data(String tcid) throws Exception {
		try {

			testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

			test = logInfo.get().createNode("I create licenses for SF Live base product for the license types:STUDENT_TRACKING with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithAddAnother3412(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("Created new license for the license types: types:STUDENT_TRACKING with test data ");

			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}



	}

	@Then("I create licenses for SF Live base product for the license types:ZONAR_INTEGRATION with test data {string}")
	public void i_create_licenses_for_sf_live_base_product_for_the_license_types_zonar_integration_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create licenses for SF Live base product for the license types:ZONAR_INTEGRATION with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithAddAnother2(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("Created new license for the license types: types:ZONAR_INTEGRATION with test data ");

			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}



}


	@Then("I create licenses for SF Live base product for the license types:TRANSFINDER with test data {string}")
	public void i_create_licenses_for_sf_live_base_product_for_the_license_types_transfinder_with_test_data(String tcid) throws Exception {
		try {
		      test = logInfo.get().createNode("I create licenses for SF Live base product for the license types:TRANSFINDER with test data");

		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithAfterAddLast(testData);
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license for the license types: types:TRANSFINDER with test data ");

				reportInfo("Test data "+testData);

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}

	@Then("I Verify that the vMax APP and the features licensed have been added to Licenses table with test data {string}")
	public void i_verify_that_the_v_max_app_and_the_features_licensed_have_been_added_to_licenses_table_with_test_data(String tcid) throws Exception {
		try {
	        testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

			test = logInfo.get().createNode("I Verify that the vMax APP and the features licensed have been added to Licenses table with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().checkLicenseFeatures(testData);

			reportInfo("APP License verified ");

			reportInfo("STUDENT_TRACKING License verified ");

			reportInfo("ZONAR_INTEGRATION ");

			reportInfo("TRANSFINDER_INTEGRATION ");

			reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().refreshPage();
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}



	}

}
