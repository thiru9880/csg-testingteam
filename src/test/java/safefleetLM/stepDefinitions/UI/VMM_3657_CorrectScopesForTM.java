package safefleetLM.stepDefinitions.UI;

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

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class VMM_3657_CorrectScopesForTM extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3657_CorrectScopesForTM(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I create new tenant for VVMM3657 with test data {string}")
	public void i_create_new_tenant_for_vvmm3657_with_test_data(String tcid) throws Exception {
		try {
			 String tenantID=randomStringGenerator();

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3657_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3657_1");

		     UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3657_2");

	         UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3657_1");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM-3657_1");

			test = logInfo.get().createNode("I create new tenant with test data");

			test.assignCategory("Integration with TM");

	       testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);

		    reportScreenshot(testSetup.driver);

		    reportInfo("New tenant is created with test data ");

		    reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create APP license with test data {string}")
	public void i_create_app_license_with_test_data(String tcid) throws Exception {
		try {
		    testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();

				test = logInfo.get().createNode("I create APP license with test data ");

		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license for the license types: types:BASE_PRODUCT with test data");

				reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Publish License with test data {string}")
	public void i_publish_license_with_test_data(String tcid) throws Exception {
		try {
			  test = logInfo.get().createNode("I Publish License with test data in LM");

        //testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
		    //testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
				//testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

        testSetup.pageObjectManager.getLicensesPage().refreshPage();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().publishOneLicense(testData);

				reportScreenshot(testSetup.driver);

				testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

				reportInfo("published SF Cognition license "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify the published licenses details in TM via swagger with expected test data {string}")
	public void i_verify_the_published_licenses_details_in_tm_via_swagger_with_expected_test_data(String tcid) throws Exception {
		try {
			 test = logInfo.get().createNode("I verfiy the response for getTenant API");

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

				validateField("TenantID", testData.get("TenantID"), js.getString(ResponseTags.GetTenantDetails_TENANTID));

				validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));

		        validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));

		        validateField("TanantAlias", testData.get("TanantAlias"), js.getString(ResponseTags.GetTenantDetails_TENANTALIAS));

		        validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

		        validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

				validateField("Licenses", testData.get("Licenses"), js.getString(ResponseTags.GetTenantDetails_LICENSES));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

}
