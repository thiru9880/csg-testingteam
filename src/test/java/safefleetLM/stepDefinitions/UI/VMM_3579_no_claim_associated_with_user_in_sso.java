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

public class VMM_3579_no_claim_associated_with_user_in_sso extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3579_no_claim_associated_with_user_in_sso(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I navigate to User Page")
	public void i_navigate_to_user_page() throws InterruptedException {
		try {
			test = logInfo.get().createNode("I navigate to Users tab");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager. getHomePage().navigateToUserTab();
			reportInfo("User navigated to Users Tab successfully");
			Thread.sleep(5000);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}
	
	@Then("I search user with test data {string}")
	public void i_search_user_with_test_data(String tcid) throws Exception {		
		try {
			test = logInfo.get().createNode("I search user with test data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);	
	        testSetup.pageObjectManager.getUserPage().searchUser(testData.get("LOGIN"));
			reportInfo("User with Multiple Roles");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}
	@Then("I verify User with only one role with higher ranking in swagger with expected test data {string}")
	public void i_verify_user_with_only_one_role_with_higher_ranking_in_swagger_with_expected_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify User with only one role with higher ranking in swagger");	
			
			 test.assignCategory("Integration with SSO");
			 
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
			
			validateField("Role with Higher Ranking", testData.get("Role"), js.getString(ResponseTags.GetUsersDetails_VALUE));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}

}
