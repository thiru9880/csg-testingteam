package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3272_Terminate_and_Returned_license extends BaseTest {


  TestSetup testSetup;
  Response response = null;
  Response response2 = null;

  public VMM_3272_Terminate_and_Returned_license(TestSetup testSetup) throws IOException {
    this.testSetup = testSetup;

  }

  @Then("I create new tenant for VMM3272 {string}")
  public void i_create_new_tenant_for_vmm3272(String tcid) throws Exception {
    try {
      String tenantID = randomStringGenerator();

      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "TenantPage", "TenantID", tenantID, "VMM_3272_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_3272_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_3272_2");

      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_3272_3");

      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "EcosytemSetting", "TenantID", tenantID, "VMM_3272_1");

      test = logInfo.get().createNode("I create new tenant with test data");

      test.assignCategory("Licenses");

      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

      testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

      testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
      reportScreenshot(testSetup.driver);

      reportInfo("New tenant is created with test data");

      reportInfo("Test data " + testData);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }


  @Then("I create multiple licences for the tenant created with Sync to TM ON")
  public void i_create_multiple_licences_for_the_tenant_created_with_sync_to_tm_on() throws Exception {
    testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

    try {
      test = logInfo.get().createNode("I create multiple licences for the tenant created with Sync to TM ON");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");


      testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData2);

      testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData3);

      testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData4);

      testSetup.pageObjectManager.getLicensesPage().searchLicense(testData3);

      reportScreenshot(testSetup.driver);

      //testSetup.pageObjectManager.getLicensesPage().licenseExpand();

      reportInfo("App, User & Vehicle license for the tenantID: " + testData2.get("TenantID") + " created successfully");
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("publish all of the licenses created")
  public void publish_all_of_the_licenses_created() throws Exception {
    try {
      test = logInfo.get().createNode("publish all of the licenses created");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

      testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData2.get("TenantID"));

      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();

      testSetup.pageObjectManager.getLicensesPage().publishAppLicense(testData2);

      testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

      testSetup.pageObjectManager.getLicensesPage().publishVehicleLicense();

      testSetup.pageObjectManager.getLicensesPage().publishUserLicense();

      testSetup.pageObjectManager.getLicensesPage().clickMenu();

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().clickMenu();
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify on TM Swagger that the published license is adding up and showing in TM")
  public void i_verify_on_tm_swagger_that_the_published_license_is_adding_up_and_showing_in_tm() throws Exception {
    try {
      test = logInfo.get().createNode("I verify on TM Swagger that the published license is active");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      String BearerToken = GenerateBearerToken.tenantManagerApi();

      //GenerateBearerToken.licenseManagerApi();

      response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData2.get("TenantID")).then().extract().response();

      if (response != null) {
        reportInfo("API triggered Successfully");
      }

      String resString = response.then().extract().asPrettyString();

      test = logInfo.get().createNode("I verify the status code ");

      validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));

      test = logInfo.get().createNode("I verfiy the response for getTenant API");

      JsonPath js = new JsonPath(resString);

      reportPayload(response.getBody().asPrettyString());

      validateField("Status", "ACTIVE", js.getString(ResponseTags.getTenantDetails_STATUS));

      validateField("Vehicle License", testData2.get("QTY"), js.getString(ResponseTags.getTenantDetails_VEHICLELICENSE));

      validateField("Feature APP License", testData3.get("QTY"), js.getString(ResponseTags.getTenantDetails_STUDENTTRACKINGLICENSE));
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I terminate the licenses and verify if the count is decreasing in TM")
  public void i_terminate_the_licenses_one_by_one_and_verify_if_the_count_is_decreasing_in_tm() throws Exception {
    try {
      test = logInfo.get().createNode("I terminate the licenses and verify if the count is decreasing in TM");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      testSetup.pageObjectManager.getLicensesPage().terminateVehicleLicense();

      testSetup.pageObjectManager.getLicensesPage().terminateUserLicense(testData3);

      testSetup.pageObjectManager.getLicensesPage().terminateAppLicense(testData4);

      testSetup.pageObjectManager.getLicensesPage().searchLicense(testData4);

      testSetup.pageObjectManager.getLicensesPage().clickMenu();

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().clickMenu();

      String BearerToken = GenerateBearerToken.tenantManagerApi();


      response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData2.get("TenantID")).then().extract().response();

      if (response != null) {
        reportInfo("API triggered Successfully");
      }

      String resString = response.then().extract().asPrettyString();

      test = logInfo.get().createNode("I verify the status code ");

      validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));

      test = logInfo.get().createNode("I verfiy the response for getTenant API");

      JsonPath js = new JsonPath(resString);

      reportPayload(response.getBody().asPrettyString());

      validateField("Status", "EXPIRED", js.getString(ResponseTags.getTenantDetails_STATUS));

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

  @Then("I return the license and delete the licenses {string}")
  public void i_return_the_license_and_delete_the_licenses(String tcid) throws Exception {

    try {
      test = logInfo.get().createNode("I return the license & delete the licenses");
      Map<String, String> testData4 = null;
      if(tcid.contains("5419") || tcid.contains("3331"))
      testData4 = ExcelFileReader.getDataInMap("LicensePage", tcid);
      else
      testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      testSetup.pageObjectManager.getLicensesPage().clickReturnLicenses(testData4);

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().returnLicensesNew(testData4);

      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
      testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
      reportInfo("Draft License deleted Successfully");

      Map<String, String> testData1 = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData1);
      testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
      reportInfo("Return License deleted Successfully");
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify on TM swagger that the returned license is also removed from the licenses count in TM")
  public void i_verify_on_tm_swagger_that_the_returned_license_is_also_removed_from_the_licenses_count_in_tm() throws Exception {

    try {
      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      String BearerToken = GenerateBearerToken.tenantManagerApi();

      response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData2.get("TenantID")).then().extract().response();

      if (response != null) {
        reportInfo("API triggered Successfully");
      }

      String resString = response.then().extract().asPrettyString();

      test = logInfo.get().createNode("I verify the status code ");

      validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));

      test = logInfo.get().createNode("I verfiy the response for getTenant API");

      JsonPath js = new JsonPath(resString);

      reportPayload(response.getBody().asPrettyString());

      validateField("Status", "EXPIRED", js.getString(ResponseTags.getTenantDetails_STATUS));

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

  @Then("I return the vehicle license and delete the licenses {string}")
  public void i_return_the_vehicle_license_and_delete_the_licenses(String tcid) throws Exception {

    try {
      test = logInfo.get().createNode("I return the vehicle license and delete the licenses");
      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      testSetup.pageObjectManager.getLicensesPage().clickReturnLicenses(testData4);

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().returnLicensesNew(testData4);

      testSetup.pageObjectManager.getLicensesPage().assignDeviceBackBtn();

      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
      testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
      reportInfo("Draft License deleted Successfully");

      Map<String, String> testData1 = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData1);
      testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
      reportInfo("Return License deleted Successfully");
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I create all three different licences for the tenant created using licensetype {string}")
  public void i_create_multiple_licences_for_the_tenant_created_using_licensetype(String string) throws Exception {
    try {
      test = logInfo.get().createNode("I create multiple licences for the tenant created using licensetype " + string);

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

      testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData2);

      testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData3);

      //testSetup.pageObjectManager.getLicensesPage().searchLicense(testData3);

      reportScreenshot(testSetup.driver);

      reportInfo("User license & Vehicle license for the tenantID: " + testData2.get("TenantID") + " created successfully");

      //testSetup.pageObjectManager.getLicensesPage().licenseExpand();
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify on publishing the vehicle and add-on license created, warning pop up message is shown")
  public void i_verify_on_publishing_the_vehicle_license_created_pop_up_message_is_shown() throws Exception {
    try {
      test = logInfo.get().createNode("I verify on publishing the vehicle license created, pop up message is shown");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      testSetup.pageObjectManager.getLicensesPage().viewLicenseWarning(testData2);

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().closeWarning();

      reportInfo("License warning on publish is validated");
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify on TM Swagger that the vehicle & add-on published license is not active")
  public void i_verify_on_tm_swagger_that_the_published_license_is_not_active() throws Exception {


    try {
      test = logInfo.get().createNode("I verify on TM Swagger that the published license is not active");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      String BearerToken = GenerateBearerToken.tenantManagerApi();

      response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData2.get("TenantID")).then().extract().response();

      if (response != null) {
        reportInfo("API triggered Successfully");
      }

      String resString = response.then().extract().asPrettyString();

      test = logInfo.get().createNode("I verify the status code ");

      validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));

      test = logInfo.get().createNode("I verfiy the response for getTenant API");

      JsonPath js = new JsonPath(resString);

      reportPayload(response.getBody().asPrettyString());

      validateField("Status", "DRAFT", js.getString(ResponseTags.getTenantDetails_STATUS));

      validateField("Vehicle License", testData2.get("QTY"), js.getString(ResponseTags.getTenantDetails_VEHICLELICENSE));

      validateField("Feature APP License", testData3.get("QTY"), js.getString(ResponseTags.getTenantDetails_STUDENTTRACKINGLICENSE));

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I create app licence in draft status for the tenant created")
  public void i_create_app_licences_for_the_tenant_created() throws Exception {
    try {
      test = logInfo.get().createNode("I create app licences for the tenant created");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData4);

      //testSetup.pageObjectManager.getLicensesPage().searchLicense(testData4);

      reportScreenshot(testSetup.driver);

      reportInfo("App license for the tenant with TenantID: " + testData4.get("TenantID") + " is created successfully");

      //testSetup.pageObjectManager.getLicensesPage().licenseExpand();
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }


  @Then("I verify on publishing the app license, warning pop up message is not shown")
  public void i_verify_on_publishing_the_vehicle_license_created_pop_up_message_is_not_shown() throws Exception {
    try {
      test = logInfo.get().createNode("I verify on publishing the vehicle license created, pop up message is not shown");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

      testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData2.get("TenantID"));

      testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

      testSetup.pageObjectManager.getLicensesPage().publishAppLicense(testData4);

      reportScreenshot(testSetup.driver);

      testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

      reportInfo("App license for the tenant with TenantID: " + testData4.get("TenantID") + " is published successfully");
    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify on TM swagger that app published license is in active state")
  public void i_verify_on_tm_swagger_that_the_published_license_is_in_active_state() throws Exception {
    try {
      test = logInfo.get().createNode("I verify on TM swagger that the published license is in active state ");

      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_1");

      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_2");

      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3272_3");

      String BearerToken = GenerateBearerToken.tenantManagerApi();


      response2 = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData2.get("TenantID")).then().extract().response();

      if (response2 != null) {
        reportInfo("API triggered Successfully");
      }

      String resString2 = response2.then().extract().asPrettyString();

      test = logInfo.get().createNode("I verify the status code ");

      validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));

      test = logInfo.get().createNode("I verfiy the response for getTenant API");

      JsonPath js = new JsonPath(resString2);

      reportPayload(response2.getBody().asPrettyString());

      validateField("Status", "ACTIVE", js.getString(ResponseTags.getTenantDetails_STATUS));

      validateField("App License", testData4.get("QTY"), js.getString(ResponseTags.getTenantDetails_APPLICENSE));

      validateField("Vehicle License", testData2.get("QTY"), js.getString(ResponseTags.getTenantDetails_VEHICLELICENSE));

      validateField("Feature APP License", testData3.get("QTY"), js.getString(ResponseTags.getTenantDetails_STUDENTTRACKINGLICENSE));

    } catch (AssertionError | Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

}
