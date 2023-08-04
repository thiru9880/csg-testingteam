package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.*;

import static io.restassured.RestAssured.given;

public class VMM_3919_Offer_Device_License_type_for_SF_Cognition_Base_Product extends BaseTest{

  TestSetup testSetup;
  Response response = null;

  public VMM_3919_Offer_Device_License_type_for_SF_Cognition_Base_Product(TestSetup testSetup) throws IOException {
    this.testSetup=testSetup;
  }

  @Then("I use existing SF cognition Device License Type {string}")
    public void i_create_sf_cognition_device_license_type_something(String tcid) throws Throwable {
    try {
      test = logInfo.get().createNode("I use existing SF cognition Device License Type");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
      testSetup.pageObjectManager.getLicenseTypePage().searchLicenseTypeWhichIsCreated(testData);
      reportInfo("License Type created successfully");
      reportScreenshot(testSetup.driver);
    } catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
    }

  @Then("I create new Tenant {string}")
    public void I_create_new_Tenant_something(String tcid) throws Throwable
    {
      try {
        String tenantID=randomStringGenerator();
        if(tcid.contains("3919")) {
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "TenantPage", "TenantID", tenantID, "VMM3919_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "EcosytemSetting", "TenantID", tenantID, "VMM3919_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM3919_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM3919_2");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM3919_3");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "Devices", "TenantID", tenantID, "VMM3919_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "GetTenant", "TenantID", tenantID, "VMM3919_1");
        } else if (tcid.contains("5419")) {
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "TenantPage", "TenantID", tenantID, "VMM_5419_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "EcosytemSetting", "TenantID", tenantID, "VMM_5419_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_5419_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "GetTenant", "TenantID", tenantID, "VMM_5419_1");
          UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "GetTenant", "TenantID", tenantID, "VMM_5419_2");

        }
        test = logInfo.get().createNode("I create new Tenant");
        Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
        testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
        testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
        reportInfo("Tenant created successfully");
        reportScreenshot(testSetup.driver);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

    @Then("I create a License of Base Product SF Cognition {string}")
    public void i_create_a_license_of_base_product_sf_cognition_something(String tcid) throws Throwable
    {
      try {
        String env = getProperty("Environment");
        test = logInfo.get().createNode("I create a License of Base Product SF Cognition");
        Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
        testSetup.pageObjectManager.getLicensesPage().createAppLicenseWithServer(testData, env);
        testSetup.pageObjectManager.getLicensesPage().clickOnSave();
        reportInfo("License created successfully for Base Product SF Cognition");
        reportScreenshot(testSetup.driver);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

    @Then("I create a Asset-H2 License with provider details for SF Cognition {string}")
    public void i_create_a_asset_h2_license_for_sf_cognition_bp(String tcid) throws Throwable
    {
      try {
        test = logInfo.get().createNode("I create a Asset-H2 License with provider details for SF Cognition");
        Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
        testSetup.pageObjectManager.getLicensesPage().createLicense(testData);
        testSetup.pageObjectManager.getLicensesPage().addProviderDetails(testData);
        testSetup.pageObjectManager.getLicensesPage().LicenseSave();

        reportInfo("Asset-H2 License created successfully with provider details, for Base Product SF Cognition");
        reportScreenshot(testSetup.driver);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

    @Then("I verify Provider details and update it {string} {string}")
    public void i_verify_provider_details_and_update_it(String tcid2, String tcid3) throws Throwable
    {
      try {
        test = logInfo.get().createNode("I verify Provider details and update it");
        Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid2);
        Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", tcid3);
        testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);
        testSetup.pageObjectManager.getLicensesPage().clickOnActionsAndThenEdit();
        boolean flag = testSetup.pageObjectManager.getLicensesPage().verifyProviderDetails(testData);
        reportScreenshot(testSetup.driver);
        if(flag==true) {
          reportPass("license", "Provider Details verification", "Successful");
        } else
          reportFail("App license ", "Provider Details verification", "Failed");
        testSetup.pageObjectManager.getLicensesPage().updateProviderDetails(testData2);
        reportScreenshot(testSetup.driver);
        reportInfo("Updated Provider details");
        testSetup.pageObjectManager.getLicensesPage().LicenseSave();
        reportInfo("Asset-H2 License saved successfully with provider details");
        reportScreenshot(testSetup.driver);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

    @Then("I published the App license {string}")
    public void i_published_the_app_license(String tcid) throws Throwable
    {
      try {
        test = logInfo.get().createNode("I published the App license");
        Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
        testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);
        String AlertMsg = testSetup.pageObjectManager.getLicensesPage().publishVehicleLicense(testData);
        reportScreenshot(testSetup.driver);
        if(AlertMsg.equals("Vmaxmanager App license.updated")) {
          reportPass("license", "Vmaxmanager App license.updated", AlertMsg);
          reportInfo("License published successfully");
        } else
          reportFail("App license ", "Vmaxmanager App license.updated", AlertMsg);

      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }


    @Then("I verify updated Provider details {string} {string}")
    public void i_verify_updated_provider_details(String tcid, String tcid2) throws Throwable
    {
      try {
        test = logInfo.get().createNode("I verify updated Provider details");
        Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
        Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", tcid2);

        testSetup.pageObjectManager.getLicensesPage().clickOnActionsAndThenEdit();
        boolean flag = testSetup.pageObjectManager.getLicensesPage().verifyProviderDetails(testData2);
        reportScreenshot(testSetup.driver);
        if(flag==true) {
          reportPass("license", "Provider details verification", "Successful");
        } else
          reportFail("App license ", "Provider details verification", "Failed");

        testSetup.pageObjectManager.getLicensesPage().clickCancleBtn();
        //testSetup.pageObjectManager.getLicensesPage().conformPublish();
        testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

  @Then("I verify in Swagger that Asset licenses sync with TM along with License key {string}")
  public void i_verify_in_swagger_that_asset_licenses_sync_with_tm_along_with_license_key(String tcid) {
    try {
      test = logInfo.get().createNode("I verify in Swagger that Asset licenses sync with TM along with License key");
      Map<String, String> testData = ExcelFileReader.getDataInMap("GetTenant", tcid);
      String BearerToken = GenerateBearerToken.tenantManagerApi();
      response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData.get("TenantID")).then().extract().response();

      if (response!=null) {
        reportInfo("API triggered Successfully");
      }

      String resString = response.then().extract().asPrettyString();

      validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

      JsonPath js = new JsonPath(resString);
      reportPayload(response.getBody().asPrettyString());

      validateField("TenantID", testData.get("TenantID").toLowerCase(), js.getString(ResponseTags.GetTenantDetails_TENANTID));
      validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));
      validateField("Licenses", testData.get("Licenses"), js.getString(ResponseTags.GetLicensesDetails_LICENSES));

    }
    catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

    @Then("I create new device for SF Cognition {string}")
    public void i_create_new_device_for_sf_cognition_something(String tcid) throws Throwable
    {
      try {
        String deviceID=randomStringGenerator();
        UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM3919_1");
        test = logInfo.get().createNode("I create new device for SF Cognition");
        Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
        testSetup.pageObjectManager.getDevicePage().createDeviceForSFCognitionn(testData);
        reportInfo("Device created successfully for SF Cognition");
        reportScreenshot(testSetup.driver);
      } catch(Exception e) {
        testStepHandle("FAIL", testSetup.driver, test, e);
      }
    }

}
