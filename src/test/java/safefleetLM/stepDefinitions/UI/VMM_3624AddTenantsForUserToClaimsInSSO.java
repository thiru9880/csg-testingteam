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

public class VMM_3624AddTenantsForUserToClaimsInSSO extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3624AddTenantsForUserToClaimsInSSO(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I create user with customer role and tenant with test data {string}")
	public void i_create_user_with_customer_role_and_tenant_with_test_data(String tcid) {
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		testSetup.pageObjectManager.getHomePage().navigateToUserTab();
		try {
			String email=randomEmailGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","LOGIN",email,"VMM-3624_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetUsers","LOGIN",email,"VMM-3624_1");
			test = logInfo.get().createNode("I create user with customer role and tenant");
			test.assignCategory("Integration with SSO");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().createNewUserWithTenant(testData);
             reportInfo("Created user with customer role and tenant");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify tenants exist for user in swagger with expected test data {string}")
	public void i_verify_tenants_exist_for_user_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify tenants exist for user in swagger");		
			 
			Map<String, String> testData = ExcelFileReader.getDataInMap("GetUsers", tcid);
		
			String BearerToken = GenerateBearerToken.singleSignOnApi();				
			
			response = given().header("Authorization", BearerToken).baseUri(safeFleetID_baseURI).and().when().get("/api/users?email="+testData.get("LOGIN")).then().extract().response();
			
			if (response!=null) {
				reportInfo("API triggered Successfully");
			}
			
			String resString = response.then().extract().asPrettyString();
			
			validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));
					
			JsonPath js = new JsonPath(resString);
			
			reportPayload(response.getBody().asPrettyString());
			
			validateField("Value", testData.get("Value"), js.getString(ResponseTags.GetUsersDetails_TYPE));
			
			validateField("Tenand ID", testData.get("TenantID"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}


	@Then("I remove tenant from created user with test data {string}")
	public void i_remove_tenant_from_created_user_with_test_data(String tcid) {

		try {
			test = logInfo.get().createNode("I remove tenant from created user");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().removeTenatFromUser(testData);
             reportInfo("I removed tenant from created user ");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	
	@Then("I verify tenants exist for user after removing tenant in swagger with expected test data {string}")
	public void i_verify_tenants_exist_for_user_after_removing_tenant_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify tenants exist for user even after removing tenant in swagger");		
			 
			Map<String, String> testData = ExcelFileReader.getDataInMap("GetUsers", tcid);
		
			String BearerToken = GenerateBearerToken.singleSignOnApi();				
			
			response = given().header("Authorization", BearerToken).baseUri(safeFleetID_baseURI).and().when().get("/api/users?email="+testData.get("LOGIN")).then().extract().response();
			
			if (response!=null) {
				reportInfo("API triggered Successfully");
			}
			
			String resString = response.then().extract().asPrettyString();
			
			validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));
					
			JsonPath js = new JsonPath(resString);
			
			reportPayload(response.getBody().asPrettyString());
			
			validateField("Value", testData.get("Value"), js.getString(ResponseTags.GetUsersDetails_TYPE));
			
			validateField("Tenand ID", testData.get("TenantID"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}
	
	@Then("I delete created user with test data {string}")
	public void i_delete_created_user_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I delete created user");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().deleteUser(testData.get("LOGIN"));
             reportInfo("I delete created user  ");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	
}
