package safefleetLM.stepDefinitions.UI;

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
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_5653_Prod_Verify_LM_Customers_screen_and_readonly_functionality extends BaseTest {
	
	TestSetup testSetup;

	public VMM_5653_Prod_Verify_LM_Customers_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}


	@Then("I click on NEW and verify new Customer creation screen and cancel")
	public void i_click_on_new_and_verify_new_customer_creation_screen_and_cancle() {
		
		try {
			test = logInfo.get().createNode("I click on NEW and verify new Customer creation screen and cancel");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getCustomerPage().clicknewbutton();
			String field = testSetup.pageObjectManager.getCustomerPage().verifyCustomerFieldIsMandatory();
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getCustomerPage().clickOnCancelButton();
			if(field.equals("true")) {
				reportPass("The Customer field value is mandatory field", "True" , "True");
			}
			else {
				reportFail("The Customer field value is mandatory field", "False", "False");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
 
	@Then("I search Customer, view and verify customer details {string}")
	public void i_search_customer_view_and_verify_customer_details(String tcid) {
		
		try {
			test = logInfo.get().createNode("I search Customer, view and verify customer details");
			test.assignCategory("Production");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getCustomerPage().searchCustomer(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getCustomerPage().viewCustomer();
			String actCustName=testSetup.pageObjectManager.getCustomerPage().getCustNameFromViewScreen();
			if(actCustName.toLowerCase().contains(testData.get("Name").toLowerCase()))    
			{
				reportPass("Verified Customer details", testData.get("Name"), actCustName);

			}
			else {
				reportFail("Verified Customer details", testData.get("Name"), actCustName);

			}
			reportScreenshot(testSetup.driver); 
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	}