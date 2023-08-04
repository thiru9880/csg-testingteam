package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3406_FeatureAppsCombinedIntoOneLicense extends BaseTest{

	TestSetup testSetup;

	public VMM_3406_FeatureAppsCombinedIntoOneLicense(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I create new tenant for VMM3406 with test data {string}")
	public void i_create_new_tenant_for_vmm3406_with_test_data(String tcid) {
		try {
			String tenantID=randomStringGenerator();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","TenantPage","TenantID",tenantID,"VMM-3406_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","LicensePage","TenantID",tenantID,"VMM-3406_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","LicensePage","TenantID",tenantID,"VMM-3406_2");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","LicensePage","TenantID",tenantID,"VMM-3406_3");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","LicensePage","TenantID",tenantID,"VMM-3406_4");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\TEST\\TestData.xlsx","LicensePage","TenantID",tenantID,"VMM-3406_5");

			test = logInfo.get().createNode("I create new tenant with test data");

			 test.assignCategory("Licenses");

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
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create APP license for SF Live+ with test data {string}")
	public void i_create_app_license_for_sf_live_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create APP license for SF Live+ with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I create FEATURE APP Zonar integration license for SF Live+ with test data {string}")
	public void i_create_feature_app_zonar_integration_license_for_sf_live_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create FEATURE APP Zonar integration license for SF Live+");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithoutOTY(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I create FEATURE APP Transfinder integration license for SF Live+ with test data {string}")
	public void i_create_feature_app_transfinder_integration_license_for_sf_live_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create FEATURE APP Transfinder integration license for SF Live+ ");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithoutOTY(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I create FEATURE APP Student Tracking license for SF Live+ with test data {string}")
	public void i_create_feature_app_student_tracking_license_for_sf_live_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create FEATURE APP Student Tracking license for SF Live+");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I create FEATURE APP DVR Health license for SF Live+ with test data {string}")
	public void i_create_feature_app_dvr_health_license_for_sf_live_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create FEATURE APP DVR Health license for SF Live+");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithoutOTY(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I verify grouping of FEATURE APP in license table with test data {string}")
	public void i_verify_grouping_of_feature_app_in_license_table_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify grouping of FEATURE APP in license table with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().viewAllLicenses(testData);

			reportInfo("Verified grouping of FEATURE APP in license table with test data");

			reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().refreshPage();
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}


@Then("I delete all the license created {string}")
public void i_delete_all_the_license_created(String tcid) {

	try {
		test = logInfo.get().createNode("I verify delete all the license created with test data");

    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    testSetup.pageObjectManager.getLicensesPage().deleteVehicleLicense(testData);

		reportInfo("Verified deleting all the license created with test data");

		reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
}


}
