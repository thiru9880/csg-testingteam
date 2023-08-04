package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3654StatusOfLicense extends BaseTest{
  private static final String String = null;
  TestSetup testSetup;

  Response response = null;
  public static String resString=null;
    public static RequestSpecification req = null;
  public static ResponseSpecification res = null;

  public VMM_3654StatusOfLicense(TestSetup testSetup) throws IOException {
    this.testSetup=testSetup;
  }


  @Then("I create new tenant for VMM3654 with test data {string}")
public void i_create_new_tenant_for_vmm3654_with_test_data(String tcid) {
    try {
      String tenantID=randomStringGenerator();

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3654_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3654_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3654_2");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3654_1");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3654_1");

        UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3654_2");

      test = logInfo.get().createNode("I create new tenant with test data");

      test.assignCategory("Licenses");

      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

      testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

      testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);;

      reportInfo("New tenant is created with test data ");

      reportInfo("Test data "+testData);

      reportScreenshot(testSetup.driver);
    } catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
}

@Then("I create APP license for DES CLOUD COURIER with test data {string}")
public void i_create_app_license_for_des_cloud_courier_with_test_data(String tcid) {

  testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

  try {
    test = logInfo.get().createNode("I create APP license for DES CLOUD COURIER with test data");

    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);

    reportInfo("Created APP license for DES CLOUD COURIER with test data");

    reportInfo("Test data "+testData);
    reportScreenshot(testSetup.driver);
  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

@Then("I create FEATURE license for DES CLOUD COURIER with test data {string}")
public void i_create_feature_license_for_des_cloud_courier_with_test_data(String tcid) {
  try {
    test = logInfo.get().createNode("I create FEATURE license for DES CLOUD COURIER with test data ");

    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);

    reportInfo("Created FEATURE license for DES CLOUD COURIER with test data");

    reportInfo("Test data "+testData);
    reportScreenshot(testSetup.driver);
  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

@Then("I Publish Both License with test data {string}")
public void i_publish_both_license_with_test_data(String tcid) {
  testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
  try {
    test = logInfo.get().createNode("I Publish Both License with test data");

    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    testSetup.pageObjectManager.getLicensesPage().publishTwoLicense(testData);

    reportInfo("Published Both License ");

    reportScreenshot(testSetup.driver);

    testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

@Then("I verify the published license Active Status in TM via swagger with expected test data {string}")
public void i_verify_the_published_license_active_status_in_tm_via_swagger_with_expected_test_data(String tcid) {
  try {
    test = logInfo.get().createNode("I verify the published license Active Status in TM via swagger");
    Map<String, String> testData = ExcelFileReader.getDataInMap("GetTenant", tcid);
    String BearerToken = GenerateBearerToken.tenantManagerApi();

    response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/" + testData.get("TenantID")).then().extract().response();
    if (response != null) {
      reportInfo("API triggered Successfully");
    }

    String resString = response.then().extract().asPrettyString();
    validateField("Staus Code ", "200", String.valueOf(response.getStatusCode()));
    JsonPath js = new JsonPath(resString);
    reportPayload(response.getBody().asPrettyString());
    validateField("License Status", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));

  } catch (Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

@Then("I terminate APP license with test data {string}")
public void i_terminate_app_license_with_test_data(String tcid) {
  testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
  try {
    test = logInfo.get().createNode("I terminate APP license with test data");

    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    testSetup.pageObjectManager.getLicensesPage().terminateLicense(testData);

    reportInfo("Terminated APP license ");

    reportScreenshot(testSetup.driver);

    testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

@Then("I verify the published license Expired Status in TM via swagger with expected test data {string}")
public void i_verify_the_published_license_expired_status_in_tm_via_swagger_with_expected_test_data(String tcid) {
  try {
    test = logInfo.get().createNode("I verify the published license Expired Status in TM via swagger with expected test data");

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

    validateField("License Status", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));
  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}

}
