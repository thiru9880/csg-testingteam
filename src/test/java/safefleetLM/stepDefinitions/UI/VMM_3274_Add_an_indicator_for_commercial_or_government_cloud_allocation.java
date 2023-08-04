package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3274_Add_an_indicator_for_commercial_or_government_cloud_allocation extends BaseTest {

	TestSetup testSetup;

	public VMM_3274_Add_an_indicator_for_commercial_or_government_cloud_allocation(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	@Then("I click on CREATE A NEW TENANT")
	public void i_click_on_create_a_new_tenant() throws IOException {
		try {
			test = logInfo.get().createNode("I click on CREATE A NEW TENANT");
			testSetup.pageObjectManager.getTenantsPage().clickOnNew();
			reportScreenshot(testSetup.driver);
			reportInfo("click on CREATE A NEW TENANT successfully");}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I check Deployment Type field has cloud deployment types {string}")
	public void i_check_deployment_type_field_has_cloud_deployment_types(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I check Deployment Type field has cloud deployment types");
			test.assignCategory("Tenants");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			boolean status = testSetup.pageObjectManager.getTenantsPage().checkCloudDeploymentType(testData);
			reportScreenshot(testSetup.driver);
			System.out.println(status);
			if(status==true)
				reportPass("Deployment Type", "CLOUD_COMMERCIAL", testData.get("DeploymentType"));
			else
				reportFail("Deployment Type", "CLOUD_COMMERCIAL", testData.get("DeploymentType"));
			reportInfo("Check Deployment Type field has cloud deployment types successfully");}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I click on System admin to navigate Users")
	public void i_click_on_system_admin_to_navigate_users() throws IOException, InterruptedException {
		try {
			test = logInfo.get().createNode("I click on System admin to navigate Users");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToUserTab();
			Thread.sleep(3000);
			reportScreenshot("PASS", "User should be navigate to Users Page", "Navigate to Users successfully",testSetup.driver);
			//reportInfo("Navigate to Users successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I Click on NEW to verify if the operations admin can create new users {string}")
	public void i_click_on_new_to_verify_if_the_operations_admin_can_create_new_users(String tcid) throws Exception {
		try {
			
			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","LOGIN",tenantID+"123@g.com","VMM_3395_1");
			
			
			test = logInfo.get().createNode("I Click on NEW to verify if the operations admin can create new users");
			test.assignCategory("System Admin");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
			reportInfo(testData.toString());
			String result = testSetup.pageObjectManager.getUserPage().createNewUser(testData);
			//reportScreenshot(testSetup.driver);
			System.out.println(result);
			if(result.equals("A new user is created with identifier "+testData.get("LOGIN"))) {
				reportPass("Alert Message ", "A new user is created with identifier "+testData.get("LOGIN"), result);
				reportInfo("User "+testData.get("LOGIN")+" created successfully" );
			}
			else
				reportFail("Alert Message ", "A new user is created with identifier "+testData.get("LOGIN"), result);

			reportScreenshot("PASS", "User should be created succefully", "User created succefully",testSetup.driver);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportInfo("User already exist or unable to create user!!" );
		}
	}
	@Then("I verify ROLE_OPERATIONS_ADMIN user able to view and edit {string}")
	public void i_verify_role_operations_admin_user_able_to_view_and_edit(String tcid) throws Exception {
		try {
			
			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"UserTest","UPDATEDLOGIN",tenantID+"456@g.com","VMM_3395_1");
			
			test = logInfo.get().createNode("I verify ROLE_OPERATIONS_ADMIN user able to view and edit");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
			reportInfo(testData.toString());
			String Aname = testSetup.pageObjectManager.getUserPage().viewUser(testData);
			if(Aname.equals(testData.get("FIRSTNAME")))
			{
				reportPass("User Name", testData.get("FIRSTNAME"), Aname);}
			else
				reportFail("User Name", testData.get("FIRSTNAME"), Aname);
			reportScreenshot("PASS", "User should be visible succefully", "User Data visible succefully",testSetup.driver);
			testSetup.pageObjectManager.getHomePage().navigateToUserTab();

			String status = testSetup.pageObjectManager.getUserPage().editUser(testData);
			//reportScreenshot(testSetup.driver);
			if(status.equals("An user is updated with identifier "+testData.get("UPDATEDLOGIN"))) {
				reportPass("Alert Message ", "An user is updated with identifier "+testData.get("UPDATEDLOGIN"), status);
				reportInfo("User "+testData.get("UPDATEDLOGIN")+" updated successfully" );
			}
			else
				reportFail("Alert Message ", "An user is updated with identifier "+testData.get("UPDATEDLOGIN"), status);

			reportScreenshot("PASS", "User should be updated succefully", "User updated succefully",testSetup.driver);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("", "","User unable to update!!!");
		}
	}
	@Then("I delete the user {string}")
	public void i_delete_the_user(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the user");
			Map<String, String> testData = ExcelFileReader.getDataInMap("UserTest", tcid);
			reportInfo(testData.toString());
			String msg = testSetup.pageObjectManager.getUserPage().deleteUser(testData.get("UPDATEDLOGIN"));
			reportScreenshot(testSetup.driver);
			System.out.println(msg);
			if(msg.equals("An user is deleted with identifier "+testData.get("UPDATEDLOGIN"))) {
				reportPass("Alert Message", "An user is deleted with identifier "+testData.get("UPDATEDLOGIN"), msg);
				//reportInfo("User "+testData.get("UPDATEDLOGIN")+" deleted successfully" );
			}
			else
				reportFail("Alert Message", "An user is deleted with identifier "+testData.get("UPDATEDLOGIN"), msg);
			reportInfo("User "+testData.get("UPDATEDLOGIN")+" deleted succesfully");}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("", "","User unable to update!!!");
		}
	}
}
