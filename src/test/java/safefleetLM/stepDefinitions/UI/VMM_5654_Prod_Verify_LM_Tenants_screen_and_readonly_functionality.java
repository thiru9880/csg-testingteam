package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;


public class VMM_5654_Prod_Verify_LM_Tenants_screen_and_readonly_functionality extends BaseTest {

  TestSetup testSetup;
  List<String> expListOfDeviceTypes;
  String env = getProperty("Environment");

  public VMM_5654_Prod_Verify_LM_Tenants_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
    this.testSetup = testSetup;
  }

  @Then("I store the device types list to verify in assign devices table")
  public void i_verify_and_store_the_device_types_to_verify_in_assign_devices_table() {
    try {
      if (!env.equals("PROD")) {
        test = logInfo.get().createNode("I verify and store the device types to verify in assign devices table");
        testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
        testSetup.pageObjectManager.getHomePage().navigateToDeviceTypeTab();
        expListOfDeviceTypes = testSetup.pageObjectManager.getDeviceTypesPage().getAllDeviceTyps();
        reportScreenshot(testSetup.driver);
        if (!expListOfDeviceTypes.isEmpty())
          reportInfo("The list of device types are stored successfully");
        else
          reportFail("DeviceType", "", "Fetching the list of device types failed");
      }

      } catch(Exception e){
        testStepHandle("FAIL", testSetup.driver, test, e);
      }

  }


  @Then("I click on NEW and verify new Tenant creation screen")
  public void i_click_on_new_and_verify_new_tenant_creation_screen() {

    try {
      test = logInfo.get().createNode("I click on NEW and verify mandatory fields in new Tenant creation screen");
      test.assignCategory("Production");
      testSetup.pageObjectManager.getTenantsPage().clickOnNew();
      boolean result = testSetup.pageObjectManager.getTenantsPage().verifyMandatoryFieldsInNewTenantScreen();
      reportScreenshot(testSetup.driver);
      if (result) {
        reportPass("Verification of mandatory fields in new Tenant creation screen", "Pass", "Pass");
      } else {
        reportFail("Verification of mandatory fields in new Tenant creation screen", "Fail", "Fail");
      }

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify all the device types are listed in the Device Type dropdown in the Available Devices section {string}")
  public void i_verify_all_the_device_types_are_listed_in_the_device_type_dropdown_in_the_available_devices_section(String tcid) {

    try {
      test = logInfo.get().createNode("I verify all the device types are listed in the Device Type dropdown in the Available Devices section");
      test.assignCategory("Production");
      if(env.equals("PROD")) {
        Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
        String deviceTypesList = testData.get("DeviceTypesList");
        expListOfDeviceTypes = Arrays.asList(deviceTypesList.split("\\s*,\\s*"));
      }

      boolean result = testSetup.pageObjectManager.getLicensesPage().verifyAvailableDevicesWithDeviceTypes(expListOfDeviceTypes);
      reportScreenshot(testSetup.driver);
      if (result) {
        reportPass("Device Type verification", "", "All the device types are listed in the Device Type dropdown in the Available Devices section");
      } else {
        reportFail("Device Type verification", "", "All the device types are not listed in the Device Type dropdown in the Available Devices section");
      }
      testSetup.pageObjectManager.getTenantsPage().clickCancelBtn();

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I search Tenant with multiple filter condition {string}")
  public void i_search_tenant_with_multiple_filter_condition(String tcid) {

    try {
      test = logInfo.get().createNode("I search Tenant with multiple filter condition details");
      test.assignCategory("Production");
      Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
      testSetup.pageObjectManager.getTenantsPage().searchTenantsWithMultiCondition(testData);
      reportScreenshot(testSetup.driver);

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I view Tenant and verify tenant details as per filter {string}")
  public void i_view_tenant_and_verify_tenant_details_as_per_filter(String tcid) {

    try {
      test = logInfo.get().createNode("I view Tenant and verify tenant details as per filter");
      test.assignCategory("Production");
      Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
      testSetup.pageObjectManager.getTenantsPage().clickOnTenantViewBtn();
      reportScreenshot(testSetup.driver);
      String actTenantID = testSetup.pageObjectManager.getTenantsPage().getTenantIDFromViewScreen();
      String actDeploymentType = testSetup.pageObjectManager.getTenantsPage().getDeploymentTypeFromViewScreen();
      String actTenantType = testSetup.pageObjectManager.getTenantsPage().getTenantTypeFromViewScreen();
      if (actTenantID.toLowerCase().contains(testData.get("FilterValue1").toLowerCase()) &&
        actDeploymentType.equals(testData.get("FilterValue2")) &&
        actTenantType.equals(testData.get("FilterValue3"))) {
        reportPass("Verified Tenant details", testData.get("FilterValue1"), actTenantID);
        reportPass("Verified Tenant details", testData.get("FilterValue2"), actDeploymentType);
        reportPass("Verified Tenant details", testData.get("FilterValue3"), actTenantType);

      } else {
        reportFail("Verified Tenant details", testData.get("FilterValue1"), actTenantID);
        reportFail("Verified Tenant details", testData.get("FilterValue2"), actDeploymentType);
        reportFail("Verified Tenant details", testData.get("FilterValue3"), actTenantType);

      }

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

}
