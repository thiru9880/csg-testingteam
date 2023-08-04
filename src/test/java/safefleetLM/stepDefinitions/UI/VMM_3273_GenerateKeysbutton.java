package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3273_GenerateKeysbutton extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;

	public VMM_3273_GenerateKeysbutton(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I create new tenant for VMM3273 with test data {string}")
	public void i_create_new_tenant_for_vmm3273_with_test_data(String tcid) throws Exception {
		try {
		    String tenantID=randomStringGenerator();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3273_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3273_1");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3273_2");

			test = logInfo.get().createNode("I create new tenant with test data");

			 test.assignCategory("Licenses");

	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
		    reportScreenshot(testSetup.driver);

		    reportInfo("New tenant is created with test data");

		    reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}
	@Then("I verify Cloud checkbox is selected for DES Cloud Courier in Base Product page with test data {string}")
	public void i_verify_cloud_checkbox_is_selected_for_des_cloud_courier_in_base_product_page_with_test_data(String tcid) {

		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();

		testSetup.pageObjectManager. getHomePage().navigateTobaseProductTab();
		try {
			test = logInfo.get().createNode("I verify Cloud checkbox is selected for DES Cloud Courier in Base Product page with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);

            String text=testSetup.pageObjectManager.getBaseProductPage().verifyDESCloudCourierName(testData);

            reportScreenshot(testSetup.driver);

			reportPass("Base Product Text", testData.get("Name"),text );

            String cloud=testSetup.pageObjectManager.getBaseProductPage().verifyDESCloudCourierCloud(testData);

			reportPass("Base Product Cloud", testData.get("Cloud"),cloud );
}
		catch(AssertionError | Exception e) {

			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify SynctoTM checkbox is on for the license types:BASE_PRODUCT for DES Cloud Courier with test data {string}")
	public void i_verify_syncto_tm_checkbox_is_on_for_the_license_types_base_product_for_des_cloud_courier_with_test_data(String tcid) {

		testSetup.pageObjectManager. getHomePage().navigateToLicenseTypesTab();
		try {
			test = logInfo.get().createNode("I verify SynctoTM checkbox is on for the license types:BASE_PRODUCT for DES Cloud Courier with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);

            String syncToTM=testSetup.pageObjectManager.getLicenseTypePage().verifyDESCloudCourierSyncToTM1(testData);

            reportScreenshot(testSetup.driver);

			reportPass("Sync To TM ", testData.get("SyncToTM"),syncToTM);
}
		catch(AssertionError | Exception e) {

			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify SynctoTM checkbox is on for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data {string}")
	public void i_verify_syncto_tm_checkbox_is_on_for_the_license_types_add_on_product_for_des_cloud_courier_with_test_data(String tcid) {

		try {
			test = logInfo.get().createNode("I verify SynctoTM checkbox is on for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);

            String syncToTM=testSetup.pageObjectManager.getLicenseTypePage().verifyDESCloudCourierSyncToTM2(testData);

            reportScreenshot(testSetup.driver);

			reportPass("Sync To TM ", testData.get("SyncToTM"),syncToTM);
}
		catch(AssertionError | Exception e) {

			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify SHARING--CONTROLLER--API option is selected for the Resources dropdown for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data {string}")
	public void i_verify_sharing_controller_api_option_is_selected_for_the_resources_dropdown_for_the_license_types_add_on_product_for_des_cloud_courier_with_test_data(String tcid) {

		try {
			test = logInfo.get().createNode("I verify SHARING--CONTROLLER--API option is selected for the Resources dropdown for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);

            String resources=testSetup.pageObjectManager.getLicenseTypePage().verifyResourses();

            reportScreenshot(testSetup.driver);

            reportPass("Resources", testData.get("Resources"),resources);

}
		catch(AssertionError | Exception e) {

			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I create new license for license types: BASE_PRODUCT for DES Cloud Courier with test data {string}")
	public void i_create_new_license_for_license_types_base_product_for_des_cloud_courier_with_test_data(String tcid) throws Exception {
		try {
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create new license for license types: BASE_PRODUCT for DES Cloud Courier");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I create new license for license types:ADD_ON_PRODUCT for DES Cloud Courier with test data {string}")
	public void i_create_new_license_for_license_types_add_on_product_for_des_cloud_courier_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create new license for license types:ADD_ON_PRODUCT for DES Cloud Courier");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I verify Generate key option for both license in license table with test data {string}")
	public void i_verify_generate_key_option_for_both_license_in_license_table_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify Generate key option for both license in license table with test data ");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().verifyGenerateButton1(testData);

			reportInfo("I verify Generate key button is greyed out as SHARING--CONTROLLER--API option is not selected");

			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getLicensesPage().verifyGenerateButton2(testData);

			reportInfo("I verify Generate key button is enabled as SHARING--CONTROLLER--API option is selected");

			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}

	@Then("I click the blue Action dropdown menu again and click on generate keys option")
	public void i_click_the_blue_action_dropdown_menu_again_and_click_on_generate_keys_option() throws Exception
	{	try {
    String env = getProperty("Environment");
		test = logInfo.get().createNode("I click the blue Action dropdown menu again and click on generate keys option");
		testSetup.pageObjectManager.getLicensesPage().clickOnSecondGenerateButton(env);
		reportScreenshot(testSetup.driver);
		reportInfo("Click the blue Action dropdown menu again and click on generate keys option Successful");
    }
    catch (Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
	}

	@Then("I verify Tenant Manager Page able to see your newly created TENANT ID in the table")
	public void i_verify_tenant_manager_page_able_to_see_your_newly_created_tenant_id_in_the_table()
	{
    try {
		test = logInfo.get().createNode("I verify Tenant Manager Page able to see your newly created TENANT ID in the table");
		reportInfo("Verify Tenant Manager Page able to see your newly created TENANT ID in the table Successful");
    }
    catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
	}

	@And("I switch to parent tab")
    public void i_switch_to_pareent_tab() throws IOException, InterruptedException {
        try {
            test = logInfo.get().createNode("I switch to parent tab");
            reportInfo("Switched to parent tab successfully");
            testSetup.pageObjectManager.getLicensesPage().switchToParentWindow();
        }
        catch (Exception e) {
            testStepHandle("FAIL", testSetup.driver, test, e);
        }

    }

	@Then("I quit the browser")
	public void i_quit_the_browser() {
		try {
			test = logInfo.get().createNode("I quit the browser");
			Thread.sleep(3000);
			reportInfo("Browser closed successfully");
			testSetup.baseTest.intializeDriver().quit();
			}
			 catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

}
