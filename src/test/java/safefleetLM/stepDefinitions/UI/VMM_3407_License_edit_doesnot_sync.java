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
import safefleetLM.testcomponents.ReadXL;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3407_License_edit_doesnot_sync extends BaseTest{


TestSetup testSetup;
public static String resString = null;
Response response = null;




public static RequestSpecification req = null;
    public static ResponseSpecification res = null;


	public VMM_3407_License_edit_doesnot_sync(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I create new tenant for VMM3407 {string}")
	public void i_navigate_to_the_operations_tab(String tcid) throws Exception {
    try {
	test = logInfo.get().createNode("I navigate to the tenants page and create new tenant");

	 test.assignCategory("Licenses");

	String tenantID = randomStringGenerator();

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3407_1");

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3407_1");

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3407_2");

  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3407_1");

  testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

	testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", "VMM_3407_1");

    testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);

    reportScreenshot(testSetup.driver);

    testSetup.pageObjectManager.getTenantsPage().tenantSave();

	  reportScreenshot(testSetup.driver);

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I create a new license with syncWithTenantManager on")
	public void i_create_a_new_license_with_sync_with_tenant_manager_on() throws Exception {
    try {
      test = logInfo.get().createNode("I navigate to the license tab");

      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();

      testSetup.pageObjectManager.getLicensesPage().waitForAngularToLoad();

	test = logInfo.get().createNode("I create a new license with syncWithTenantManager on");

	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3407_1");
	testSetup.pageObjectManager.getLicensesPage().addLicenses(testData);

	//testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);

	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I publish the license")
	public void i_publish_the_license() throws Exception {
    try {
	test = logInfo.get().createNode("I publish the license");

	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3407_1");

	testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

	testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData.get("TenantID"));

	testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

	testSetup.pageObjectManager.getLicensesPage().publishOneLicense(testData);

	reportScreenshot(testSetup.driver);

	testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

	reportInfo("App License is published for TenantID " + testData.get("TenantID"));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify on Tenant Manager that the published license is displayed")
	public void i_verify_on_tenant_manager_that_the_published_license_is_displayed() throws Exception {

    try {

	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3407_1");

	String BearerToken = GenerateBearerToken.tenantManagerApi();

	//GenerateBearerToken.licenseManagerApi();

	response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData.get("TenantID")).then().extract().response();

	if (response!=null) {
		reportInfo("API triggered Successfully");
	}

	String resString = response.then().extract().asPrettyString();

	test = logInfo.get().createNode("I verify the status code ");

	validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

//	test = logInfo.get().createNode("I verfiy the response for getTenant API");

	JsonPath js = new JsonPath(resString);

	test = logInfo.get().createNode("I verify on Tenant Manager that the published license is displayed");

	reportPayload(response.getBody().asPrettyString());

	validateField("Status", "ACTIVE", js.getString(ResponseTags.getTenantDetails_STATUS));

	validateField("Base Product Name", testData.get("initialBaseProductValidation"), js.getString(ResponseTags.getTenantDetails_APPLICATIONID));

	validateField("App License", testData.get("QTY"), js.getString(ResponseTags.getTenantDetails_APPLICENSE));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
		}

	@Then("I edit the license and republish again")
	public void i_edit_the_license_and_republish_again() throws Exception {
     try {
	test = logInfo.get().createNode("I edit the license and republish again");

	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3407_2");

	testSetup.pageObjectManager.getLicensesPage().editLicense(testData);

	reportScreenshot(testSetup.driver);

	testSetup.pageObjectManager.getLicensesPage().saveLicense();

	reportInfo("License edited");

	testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);

	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify if the changes made are displayed in Tenant Manager")
	public void i_verify_if_the_changes_made_are_displayed_in_tenant_manager() throws Exception {
    try {
	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3407_2");

	String BearerToken = GenerateBearerToken.tenantManagerApi();

	response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData.get("TenantID")).then().extract().response();

	if (response!=null) {
		reportInfo("API triggered Successfully");
	}

	String resString = response.then().extract().asPrettyString();

	test = logInfo.get().createNode("I verify the status code ");

	validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

	test = logInfo.get().createNode("I verify if the changes made are displayed in Tenant Manager");

	JsonPath js = new JsonPath(resString);

	reportPayload(response.getBody().asPrettyString());

	validateField("New Status", "ACTIVE", js.getString(ResponseTags.getTenantDetails_STATUS));

	validateField("App License", testData.get("QTY"), js.getString(ResponseTags.getTenantDetails_APPLICENSE));

	validateField("Base Product Name", testData.get("BaseProductValidation"), js.getString(ResponseTags.getTenantDetails_APPLICATIONID));

	validateField("Old Status", "EXPIRED", js.getString(ResponseTags.getTenantDetails_OLDITEMSTATUS));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}


}
