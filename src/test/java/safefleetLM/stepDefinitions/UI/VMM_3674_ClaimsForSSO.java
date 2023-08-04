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

public class VMM_3674_ClaimsForSSO extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3674_ClaimsForSSO(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I create user other then customer role with test data {string}")
	public void i_create_user_other_then_customer_role_with_test_data(String tcid) {
		String email=randomEmailGenerator();
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","LOGIN",email,"VMM-3674_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetUsers","LOGIN",email,"VMM-3674_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetUsers","LOGIN",email,"VMM-3674_2");

		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		testSetup.pageObjectManager.getHomePage().navigateToUserTab();
		try {
			test = logInfo.get().createNode("I create user other then customer role with test data");
			test.assignCategory("Integration with SSO");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().createNewUser(testData);
             reportInfo("Created user other then customer role");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify user claim in swagger with expected test data {string}")
	public void i_verify_user_claim_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify user claim in swagger");		
			 
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
			
			validateField("User Role", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_VALUE));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}

	@Then("I edit user by providing customer role and choose one or more tenants with test data {string}")
	public void i_edit_user_by_providing_customer_role_and_choose_one_or_more_tenants_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I edit user by providing customer role and choose one or more tenants");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().editRoleAddCustTenantForUser(testData);
             reportInfo("Edited user by providing customer role and choose one or more tenants");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	@Then("I verify user claim for customer role in swagger with expected test data {string}")
	public void i_verify_user_claim_for_customer_role_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify user claim for customer role in swagger along tenant");		
			 
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
			
			validateField("User Role", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_VALUE));
			
			validateField("User Role with tenant", testData.get("TenantID"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}

	

	@Then("I edit user by providing admin role with test data {string}")
	public void i_edit_user_by_providing_admin_role_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I edit user by providing admin role with test data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().editRoleForUser(testData);
             reportInfo("Edited user by providing admin role with test data");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	
	@Then("I verify user claim for admin role in swagger with expected test data {string}")
	public void i_verify_user_claim_for_admin_role_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify user claim for customer role in swagger along tenant and admin role");		
			 
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
			
			validateField("User Role", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_VALUE));
			
			validateField("User Role with tenant", testData.get("TenantID"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));
			
			validateField("Another User Role", testData.get("Role1"), js.getString(ResponseTags.GetUsersDetails_ADDEDVALUE));


		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}

	@Then("I verify user claim for customer and admin role in swagger with expected test data {string}")
	public void i_verify_user_claim_for_customer_and_admin_role_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify user claim for customer role and admin role in swagger along tenant and admin role");		
			 
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
			
			validateField("User Role", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_VALUE));
			
			validateField("User Role with tenant", testData.get("TenantID"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));
			
			validateField("Another User Role", testData.get("Role1"), js.getString(ResponseTags.GetUsersDetails_ADDEDVALUE));


		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}
	
}
