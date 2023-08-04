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

public class VMM_3699_PATCH_endpoint_to_TM extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
	public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3699_PATCH_endpoint_to_TM(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create a tenant without Admin Email {string}")
	public void i_create_a_tenant_without_admin_email(String tcid) throws InterruptedException {
		try {

			String tenantID=randomStringGenerator();

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3699_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3699_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_3699_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_3699_1");

			test = logInfo.get().createNode("I create a tenant without Admin Email");

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			reportInfo(testData.toString());

			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);

			reportScreenshot(testSetup.driver);

			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);

			reportScreenshot(testSetup.driver);

			if(AlertMsg.contains("A new Tenant is created with identifier")) {

				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
			}
			else

				reportFail("Tenant ", "A new Tenant is created with identifier", AlertMsg);}

		catch (Exception e){

			testStepHandle("FAIL", testSetup.driver, test, e);

			testSetup.pageObjectManager.getTenantsPage().continueExecution();

			reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
		}
	}
	@Then("I Verify the tenant created above via TM swagger and validate the tenant details {string}")
	public void i_verify_the_tenant_created_above_via_tm_swagger_and_validate_the_tenant_details(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I Verify the tenant created above via TM swagger and validate the tenant details");
			
			test.assignCategory("Integration with TM");

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

			//	validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

			//	validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  	
	}

	@Then("I edit the tenant Admin Email {string}")
	public void i_edit_the_tenant_admin_email(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I edit the tenant Admin Email");

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			reportInfo(testData.toString());

			testSetup.pageObjectManager.getTenantsPage().editTenantAdminEmail(testData);

			reportScreenshot(testSetup.driver);

			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);

			if(AlertMsg.contains("A Tenant is updated with identifier")) {

				reportPass("Tenant ", "A Tenant is updated with identifier", AlertMsg);
				
				reportScreenshot(testSetup.driver);

				reportInfo("Tenant ID '"+testData.get("TenantID").toLowerCase()+"' is Edited with Admin email '"+testData.get("EditedAdminEmail")+"' successfully");
			}
			else
				reportFail("Tenant ", "A Tenant is updated with identifier", AlertMsg);}

		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}
	@Then("I verify the changes made in LM for the tenant in TM swagger {string}")
	public void i_verify_the_changes_made_in_lm_for_the_tenant_in_tm_swagger(String tcid) throws Exception {

		try {
			test = logInfo.get().createNode("I verify the changes made in LM for the tenant in TM swagger");

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

			//	validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));

			//	validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));

			validateField("TenantAdminEmail", testData.get("EditedAdminEmail"), js.getString(ResponseTags.GetTenantDetails_TENANTADMINEMAIL));

			//	validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

			//	validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  	
	}

}
