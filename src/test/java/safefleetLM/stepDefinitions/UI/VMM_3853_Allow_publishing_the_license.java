package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
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

import static io.restassured.RestAssured.given;

public class VMM_3853_Allow_publishing_the_license extends BaseTest {


TestSetup testSetup;
public static String resString = null;
Response response = null;
Response response2 = null;



public static RequestSpecification req = null;
    public static ResponseSpecification res = null;


	public VMM_3853_Allow_publishing_the_license(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}


	@Then("I create a tenant for the customer created {string}")
	public void i_create_a_tenant_for_the_customer_created(String tcid) throws Exception {

   try {
	test = logInfo.get().createNode("I create a tenant for the customer created");
	 test.assignCategory("Licenses");

	String tenantID = randomStringGenerator();

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3853_1");

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3853_1");

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3853_2");

	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3853_3");

  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3853_1");

	 testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

	testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

	Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage",tcid);

    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);

    reportScreenshot(testSetup.driver);

    reportInfo("New Tenant created successfully with TenantID " + testData.get("TenantID")  );

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I navigate to the licences tab")
	public void i_navigate_to_the_licences_tab() {
    try {
	test = logInfo.get().createNode("I navigate to the licences tab");

	 testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

	 reportInfo("User successfully navigated to the licenses tab"   );
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I create multiple licences for the tenant created using licensetype {string}")
	public void i_create_multiple_licences_for_the_tenant_created_using_licensetype(String string) throws Exception {
try {
	test = logInfo.get().createNode("I create multiple licences for the tenant created using licensetype " + string);

	Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_1");

	Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_2");

	testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

	testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData2);

	testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData3);

	//testSetup.pageObjectManager.getLicensesPage().searchLicense(testData3);

	reportScreenshot(testSetup.driver);

	reportInfo("User license & Vehicle license for the tenantID: " + testData2.get("TenantID") + " created successfully"   );

	//testSetup.pageObjectManager.getLicensesPage().licenseExpand();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
		}

	@Then("I verify on publishing the vehicle license created, pop up message is shown")
	public void i_verify_on_publishing_the_vehicle_license_created_pop_up_message_is_shown() throws Exception {
    try {
	test = logInfo.get().createNode("I verify on publishing the vehicle license created, pop up message is shown");

	Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_1");

	testSetup.pageObjectManager.getLicensesPage().viewLicenseWarning(testData2);

	reportScreenshot(testSetup.driver);

	testSetup.pageObjectManager.getLicensesPage().closeWarning();

	reportInfo("License warning on publish is validated"   );
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify on TM Swagger that the published license is not active")
	public void i_verify_on_tm_swagger_that_the_published_license_is_not_active() throws Exception {


   try {
	test = logInfo.get().createNode("I verify on TM Swagger that the published license is not active");

	Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_1");

	Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_2");

	Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_3");

	String BearerToken = GenerateBearerToken.tenantManagerApi();

	response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData2.get("TenantID")).then().extract().response();

	if (response!=null) {
		reportInfo("API triggered Successfully");
	}

	String resString = response.then().extract().asPrettyString();

	test = logInfo.get().createNode("I verify the status code ");

	validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

	test = logInfo.get().createNode("I verfiy the response for getTenant API");

	JsonPath js = new JsonPath(resString);

	reportPayload(response.getBody().asPrettyString());

	validateField("Status", "DRAFT", js.getString(ResponseTags.getTenantDetails_STATUS));

	validateField("Vehicle License", testData2.get("QTY"), js.getString(ResponseTags.getTenantDetails_VEHICLELICENSE));

	validateField("Feature APP License", testData3.get("QTY"), js.getString(ResponseTags.getTenantDetails_STUDENTTRACKINGLICENSE));

			}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I create app licences for the tenant created")
	public void i_create_app_licences_for_the_tenant_created() throws Exception {
try {
	test = logInfo.get().createNode("I create app licences for the tenant created");

	Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_3");

	testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData4);

	//testSetup.pageObjectManager.getLicensesPage().searchLicense(testData4);

	reportScreenshot(testSetup.driver);

	reportInfo("App license for the tenant with TenantID: " +testData4.get("TenantID") + " is created successfully"   );

	//testSetup.pageObjectManager.getLicensesPage().licenseExpand();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}



	@Then("I verify on publishing the app license created, pop up message is not shown")
	public void i_verify_on_publishing_the_vehicle_license_created_pop_up_message_is_not_shown() throws Exception {
    try {
	test = logInfo.get().createNode("I verify on publishing the vehicle license created, pop up message is not shown");

	Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_1");

	Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_3");

	testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();

	testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData2.get("TenantID"));

	testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();

	testSetup.pageObjectManager.getLicensesPage().publishAppLicense(testData4);

	reportScreenshot(testSetup.driver);

	testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

	reportInfo("App license for the tenant with TenantID: " +testData4.get("TenantID") + " is published successfully"   );
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify on TM swagger that the published license is in active state")
	public void i_verify_on_tm_swagger_that_the_published_license_is_in_active_state() throws Exception {
    try {
	test = logInfo.get().createNode("I verify on TM swagger that the published license is in active state ");

	Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_1");

	Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_2");

	Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicensePage", "VMM_3853_3");

	String BearerToken = GenerateBearerToken.tenantManagerApi();


	response2 = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData2.get("TenantID")).then().extract().response();

	if (response2!=null) {
		reportInfo("API triggered Successfully");
	}

	String resString2 = response2.then().extract().asPrettyString();

	test = logInfo.get().createNode("I verify the status code ");

	validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

	test = logInfo.get().createNode("I verfiy the response for getTenant API");

	JsonPath js = new JsonPath(resString2);

	reportPayload(response2.getBody().asPrettyString());

	validateField("Status", "ACTIVE", js.getString(ResponseTags.getTenantDetails_STATUS));

	validateField("App License", testData4.get("QTY"), js.getString(ResponseTags.getTenantDetails_APPLICENSE));

	validateField("Vehicle License", testData2.get("QTY"), js.getString(ResponseTags.getTenantDetails_VEHICLELICENSE));

	validateField("Feature APP License", testData3.get("QTY"), js.getString(ResponseTags.getTenantDetails_STUDENTTRACKINGLICENSE));

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}



}
