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

public class VMM_3571_RemovingRoleIsNotRemovingSSOClaim extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3571_RemovingRoleIsNotRemovingSSOClaim(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I create user with customer role with test data {string}")
	public void i_create_user_with_customer_role_with_test_data(String tcid) {
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		testSetup.pageObjectManager.getHomePage().navigateToUserTab();
		try {
			String email=randomEmailGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","LOGIN",email,"VMM-3571_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","LOGIN",email,"VMM-3571_2");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetUsers","LOGIN",email,"VMM-3571_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetUsers","LOGIN",email,"VMM-3571_2");
			test = logInfo.get().createNode("I create user with customer role");
			 test.assignCategory("Integration with SSO");			
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().createNewUser(testData);
             reportInfo("Created user with customer role");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify customer role for user in swagger with expected test data {string}")
	public void i_verify_customer_role_for_user_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify customer role for user in swagger");		
			 
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

	@Then("I edit role for created user with test data {string}")
	public void i_edit_role_for_created_user_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I edit role for created user");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
             testSetup.pageObjectManager.getUserPage().editRoleForUser(testData);
             reportInfo("I removed tenant from created user ");
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify new role updated for user in swagger with expected test data {string}")
	public void i_verify_new_role_updated_for_user_in_swagger_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify new role updated for user in swagger");		
			 
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
			
			validateField("User Role", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_TENANTVALUE));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}
}
