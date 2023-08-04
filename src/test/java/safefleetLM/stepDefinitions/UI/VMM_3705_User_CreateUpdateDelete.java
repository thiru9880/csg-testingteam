package safefleetLM.stepDefinitions.UI;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.PageObjectManager;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3705_User_CreateUpdateDelete extends BaseTest {
		
	TestSetup testSetup;
	public static String userFirstName=null;
    
	public VMM_3705_User_CreateUpdateDelete(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@When("I navigate to User tab")
	public void i_navigate_to_users_tab() throws Exception {
		test = logInfo.get().createNode("I navigate to User tab");
		test.assignCategory("System Admin");
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		testSetup.pageObjectManager.getHomePage().navigateToUserTab();
		reportInfo("User navigated to User Page");
	}
	
	@Then("I create new user with test data {string}")
	public void i_create_new_user_with_test_data(String tcid) throws Exception {
		
		
			try {
				test = logInfo.get().createNode("I create new user with test data "+tcid);
				Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
				userFirstName=testData.get("FIRSTNAME");
				reportInfo("Test Data "+testData);
				
				
				String ackmsg= testSetup.pageObjectManager.getUserPage().createNewUser(testData); 
				if(ackmsg.equals("A new user is created with identifier "+testData.get("LOGIN"))) {
					reportPass("Alert Message ", "A new user is created with identifier "+testData.get("LOGIN"), ackmsg);
					reportInfo("User "+testData.get("LOGIN")+" created successfully" );
				}
				else
					reportFail("Alert Message ", "A new user is created with identifier "+testData.get("LOGIN"), ackmsg);
				
				reportScreenshot("PASS", "User should be created succefully", "User created succefully",testSetup.driver);
			
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
			
		
	}
	

	@Then("I verify user details for the user in test data {string}")
	public void I_verify_user_details_from_the_users_list(String tcid) throws Exception {
			try {
				test = logInfo.get().createNode("I verify user details from the users list");
				
				Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
				String user =  testSetup.pageObjectManager.getUserPage().searchUser(testData.get("LOGIN"));
				if(user.equals(testData.get("LOGIN"))) {
					reportPass("Created User ", testData.get("LOGIN"), user);
					reportScreenshot("PASS", "User should be listed in the reults table", "User is listed in the reults table",testSetup.driver);
				}
				else
					reportScreenshot("FAIL", "User should be listed in the reults table", "User not listed in the reults table",testSetup.driver);

			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
				softAssert.fail("Error in Verify details");
			}
			
		
	}

	@Then("I delete the user in test data {string}")
	public void i_delete_the_user_in_test_data(String tcid) throws Exception {
			
			try {
				test = logInfo.get().createNode("I delete the user");
				Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
				String ackmsg = testSetup.pageObjectManager.getUserPage().deleteUser(testData.get("LOGIN"));
				
				if(ackmsg.equals("An user is deleted with identifier "+testData.get("LOGIN"))) {
					reportPass("Alert Message", "An user is deleted with identifier "+testData.get("LOGIN"), ackmsg);
					reportInfo("User "+testData.get("LOGIN")+" deleted successfully" );
				}
				else
					reportFail("Alert Message", "An user is deleted with identifier "+testData.get("LOGIN"), ackmsg);
				reportScreenshot(testSetup.driver);
				reportInfo("User "+testData.get("LOGIN")+" deleted succesfully");
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
				
			}
	}
	
	
	

	@Then("I veirfy created user details in DB")
	public void i_veirfy_created_user_details_in_db() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		test = logInfo.get().createNode("I veirfy created user details in DB");
		try {
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.jhi_user where first_name = '"+userFirstName+"'");
			if(res.size()==1) {
				reportPass("", "User details should exists in DB", "User details not exists in DB");
				
			}
			else
				reportFail("", "User details should exists in DB", "User details exists in DB");
			
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			
		}
		
	}
	@Then("I veirfy deleted user details in DB")
	public void i_veirfy_deleted_user_deyails_in_db() throws SQLException {
	    
		test = logInfo.get().createNode("I veirfy deleted user details in DB");
		try {
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.jhi_user where first_name = '"+userFirstName+"'");
			if(res.size()==0) {
				reportPass("", "User details should not exists in DB", "User details not exist in DB");
				
			}
			else
				reportFail("", "User details should not exists in DB", "User details exists in DB");
			
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			
		}
		
	}


	
	
	
}
