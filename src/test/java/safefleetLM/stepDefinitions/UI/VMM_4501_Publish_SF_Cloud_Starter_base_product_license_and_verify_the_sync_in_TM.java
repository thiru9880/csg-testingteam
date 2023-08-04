package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;

public class VMM_4501_Publish_SF_Cloud_Starter_base_product_license_and_verify_the_sync_in_TM extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
	public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_4501_Publish_SF_Cloud_Starter_base_product_license_and_verify_the_sync_in_TM(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create a App license for the Base product SF Cloud Starter {string}")
  @Then("I create a CleverIVN Asset license for the Base product SF Cloud Starter {string}")
	public void i_create_a_app_license_for_the_base_product_sf_cloud_starter(String tcid) throws IOException {
		try {
			String env = getProperty("Environment");
			test = logInfo.get().createNode("I create a App/Asset license for the Base product SF Cloud Starter");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createAppLicenseWithServer(testData, env);
			reportScreenshot(testSetup.driver);
			String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
				reportInfo("Create APP License for Base product "+testData.get("Base Product")+" successfully");
			}
			else
				reportFail("Vehicle license", "Vmaxmanager App license.updated", Alert);
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create vehicle license" );
			testSetup.baseTest.intializeDriver().close();
			Assert.fail();
		}
	}

	@Then("I create Ecosystem setting for created tenant {string}")
	public void i_create_Ecosystem_setting_for_created_tenant(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create Ecosystem setting for created tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());

			String AlertMsg = testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettingWithoutRobotClass(testData);
			reportScreenshot(testSetup.driver);

			String status=testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingcreatepopup1();
			if(status.equals("true"))
			{
				reportPass("Ecosetting created successfully", "A new Settings is created with identifier..",AlertMsg );
				//reportScreenshot(testSetup.driver);
				reportInfo("Ecosetting created for Tenant "+testData.get("TenantID")+" successful");
			}
			else
			{
				reportFail("Ecosetting created successfully", "A new Settings is created with identifier..", AlertMsg);
				reportScreenshot(testSetup.driver);
				reportInfo("Ecosetting not created");
			}
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportInfo("Unable to create Ecosystem setting");
		}
	}

  @Then("I search and publish the License {string}")
  public void i_search_and_publish_the_license(String tcid) throws Throwable
  {
    try
    {
      test = logInfo.get().createNode("I search and publish the License");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      //testSetup.pageObjectManager.getLicensesPage().clickonClear();
      testSetup.pageObjectManager.getLicensesPage().refreshPage();
      testSetup.pageObjectManager.getLicensesPage().showFilterClick();
      testSetup.pageObjectManager.getLicensesPage().searchLicenseWithTenantAndMultiCondition(testData);
      reportScreenshot(testSetup.driver);
      String tenantId = testSetup.pageObjectManager.getLicensesPage().getTenantId();

      if(tenantId.equalsIgnoreCase(testData.get("TenantID"))) {
        testSetup.pageObjectManager.getLicensesPage().publishLicense();
        reportInfo("I search and publish the License successfully");
        reportScreenshot(testSetup.driver);
      }
      else {
        reportFail("Search License failed", "Unable to publish the license", "License not found");
        reportInfo("Search License failed");
      }
    }
    catch(Exception e)
    {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

	@Then("I verify in Swagger that published licenses sync with TM and shows up correctly in TM swagger {string}")
	public void i_verify_in_swagger_that_published_licenses_sync_with_tm_and_shows_up_correctly_in_tm_swagger(String tcid) {
		try {
			test = logInfo.get().createNode("I verify in Swagger that published licenses sync with TM and shows up correctly in TM swagger");

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

			validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));

			validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));

			validateField("TenantAdminEmail", testData.get("TenantAdminEmail"), js.getString(ResponseTags.GetTenantDetails_TENANTADMINEMAIL));

			validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

			validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

      validateField("Licenses", testData.get("Licenses"), js.getString(ResponseTags.GetLicensesDetails_LICENSES));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}



  @Then("I search and expand the License with Tenant Id {string}")
  public void i_search_and_expand_the_license_with_tenant_id(String tcid) {
    try {
      test = logInfo.get().createNode("I search and expand the License with Tenant Id");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      testSetup.pageObjectManager.getLicensesPage().filterLicenseWithTenant(testData);
      testSetup.pageObjectManager.getLicensesPage().clickFilterBtn();
      testSetup.pageObjectManager.getLicensesPage().licenseExpand();
      reportScreenshot(testSetup.driver);
    }
    catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

}
