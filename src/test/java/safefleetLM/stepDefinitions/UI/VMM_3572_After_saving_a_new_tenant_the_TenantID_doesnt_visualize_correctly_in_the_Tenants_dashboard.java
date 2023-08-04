package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

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
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3572_After_saving_a_new_tenant_the_TenantID_doesnt_visualize_correctly_in_the_Tenants_dashboard extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
	public static RequestSpecification req = null;
	public static ResponseSpecification res = null;


	public VMM_3572_After_saving_a_new_tenant_the_TenantID_doesnt_visualize_correctly_in_the_Tenants_dashboard(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}


	@Then("I verify that system will not let to type more than 50 characters while create customer and create customer with Customer length 50 characters {string}")
	public void i_verify_that_system_will_not_let_to_type_more_than_characters_while_create_customer(String tcid) {
		try {

			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID+"123456789456123456789456123456789B12345","VMM_3572_1");

			test = logInfo.get().createNode("I verify that system will not let to type more than 50 characters while create customer");
			test.assignCategory("Tenants");
			Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
			reportInfo(testData.toString());
			String[] Result = testSetup.pageObjectManager.getCustomerPage().verifyCustomerTextLength(testData);
			reportScreenshot(testSetup.driver);
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Customer",Result[1],"VMM_3572_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",Result[1],"VMM_3572_1");
			if(Result[0].contains("A new Customer is created with identifier") && testData.get("Name").contains(Result[1])) {
				reportPass("Customer", "A new Customer is created with identifier", Result[0]);
				reportInfo("Create the Customer with Customer length 50 characters '"+testData.get("Name")+"' successfully");
				reportPass("Customer length", "Provided customer length more than 50 character "+testData.get("Name") , "Actual accepted customer length less than or equal to 50 characters "+Result[1]);
			}
			else {
				reportFail("Customer", "A new Customer is created with identifier", Result[0]);
				reportInfo("create the Customer "+testData.get("Name")+" NOT successfully");
			}

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I verify that system will not let to type more than 20 characters for tenant ID and create Tenant with length 20 characters {string}")
	public void i_verify_that_system_will_not_let_to_type_more_than_characters_for_tenant_id(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID+"123B12345","VMM_3572_1");

			test = logInfo.get().createNode("I verify that system will not let to type more than 20 characters for tenant ID");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportScreenshot(testSetup.driver);

			String ActualTenantID = testSetup.pageObjectManager.getTenantsPage().verifyTenantTextLength(testData);
			reportScreenshot(testSetup.driver);
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",ActualTenantID,"VMM_3572_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",ActualTenantID,"VMM_3572_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",ActualTenantID,"VMM_3572_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",ActualTenantID,"VMM_3572_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",ActualTenantID,"VMM_3572_1");
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Alert Message", "A new Tenant is created with identifier", AlertMsg);
				reportPass("Tenant length", "Provided Tenant length more than 20 character "+testData.get("TenantID") , "Actual accepted Tenant length less than or equal to 20 characters "+ActualTenantID);
				reportInfo("Tenant with Tenant ID length 20 character '"+testData.get("TenantID").toLowerCase()+"' created successfully");
			}
			else {
				reportFail("Tenant ", "A new Tenant is created with identifier", AlertMsg);

			}

		}

		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}


	@Then("I create a FEATURE_APP DES Cloud Courier licenses {string}")
	public void i_create_a_feature_app_des_cloud_courier_licenses(String tcid) throws IOException {
		try {
			test = logInfo.get().createNode("I create a FEATURE_APP DES Cloud Courier licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createFeatureAppDesCloudCourierLicense(testData);
			reportScreenshot(testSetup.driver);
			String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
				reportInfo("Create a FEATURE_APP DES Cloud Courier licenses successfully");
			}
			else {
				reportFail("license", "Vmaxmanager App license.updated", Alert);
				reportScreenshot(testSetup.driver);
			}

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create license" );
			testSetup.baseTest.intializeDriver().quit();
			Assert.fail();
		}
	}

	@Then("I verify in Tenant Manager via Swagger UI to make sure licenses and tenant from LM make it to TM {string}")
	public void i_verify_in_tenant_manager_via_swagger_ui_to_make_sure_licenses_and_tenant_from_lm_make_it_to_tm(String tcid) {
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

			//	validateField("TenantAdminEmail", testData.get("TenantAdminEmail"), js.getString(ResponseTags.GetTenantDetails_TENANTADMINEMAIL));

			validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

			validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

			validateField("Description", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}
}
