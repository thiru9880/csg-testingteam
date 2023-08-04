package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.And;
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

public class VMM_4756_Device_Multiple_devices_are_assigned_to_new_Tenant_and_synced_to_TM extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_4756_Device_Multiple_devices_are_assigned_to_new_Tenant_and_synced_to_TM(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

    @Then("I click on new and enter all the required details with Tenant ID {string}")
    public void i_click_on_new_and_enter_all_the_required_details_with_tenant_id(String tcid) throws Throwable 
    {
    	try
        {
    		String tenantID=randomStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4756_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM4756_1");
    		test = logInfo.get().createNode("I click on new and enter all the required details with Tenant ID");
    		test.assignCategory("Integration with TM");
    		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
    		testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
    		reportInfo("I click on new and enter all the required details with Tenant ID successfully");
    		reportScreenshot(testSetup.driver);
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
    }

    @Then("I assign Device or multiple Devices to the Tenant and save")
    public void i_assign_device_or_multiple_devices_to_the_tenant_and_save() throws Throwable 
    {
    	try
        {
    		test = logInfo.get().createNode("I assign Device or multiple Devices to the Tenant and save");
        	testSetup.pageObjectManager.getTenantsPage().createNewTenantWithAssigningOfDevice();
        	testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
    		reportInfo("I assign Device or multiple Devices to the Tenant and save successfully");
    		reportScreenshot(testSetup.driver);
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
    }

    @And("I verify that the Tenant and Devices details are synced to TM {string}")
    public void i_verify_that_the_tenant_and_devices_details_are_synced_to_tm(String tcid) throws Throwable
    {
    	try {
    			test = logInfo.get().createNode("I verify the response for GetTenant API");
    			
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
    			
    		}
    		catch(Exception e) {
    			testStepHandle("FAIL", testSetup.driver, test, e);
    		}  

    	
    	
    }

	
}
