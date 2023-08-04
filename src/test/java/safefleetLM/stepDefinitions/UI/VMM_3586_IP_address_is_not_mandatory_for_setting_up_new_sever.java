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

public class VMM_3586_IP_address_is_not_mandatory_for_setting_up_new_sever extends BaseTest {

	TestSetup testSetup;

	public VMM_3586_IP_address_is_not_mandatory_for_setting_up_new_sever(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I click on system admin to navigate servers")
	public void i_click_on_system_admin_to_navigate_servers() {
		try {
			test = logInfo.get().createNode("I click on system admin to navigate servers");
			test.assignCategory("Servers");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToServersTab();
			Thread.sleep(1000);
			reportScreenshot(testSetup.driver);
			reportInfo("Navigate to Servers page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I create a New server without IP adress {string}")
	public void i_create_a_new_server_without_ip_adress(String tcid) throws Exception {
		try {

String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ServerPage","Name",tenantID,"VMM_3586_1");



			test = logInfo.get().createNode("I create a New server without IP adress");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			reportInfo(testData.toString());
			String AlertMsg = testSetup.pageObjectManager.getServersPage().createServerWithoutIpAdress(testData);
			reportScreenshot(testSetup.driver);
			System.out.println(AlertMsg);
			if(AlertMsg.contains("A new Server is created with identifier")) {
				reportPass("Create Alert Message", "A new Server is created with identifier", AlertMsg);
				reportInfo("NEW server "+testData.get("Name")+" created without IP adress successfully");
			}
			else {
				reportFail("Create Alert Message", "A new Server is created with identifier", AlertMsg);
				reportFail("", "", "Server "+testData.get("Name")+" is already exists or Server unable to create without IP adress");
				//reportInfo("Server "+testData.get("Name")+" is already exists or Server unable to create without IP adress");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I edit the server {string}")
	public void i_edit_the_server(String tcid) throws Exception {
		try {

String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ServerPage","EditName",tenantID,"VMM_3586_1");




			test = logInfo.get().createNode("I edit the server");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getServersPage().searchServer(testData);
			String AlertMsg = testSetup.pageObjectManager.getServersPage().editServer(testData);
			reportScreenshot(testSetup.driver);

			if(AlertMsg.contains("A Server is updated with identifier")){
				reportPass("Edit Alert Message", "A Server is updated with identifier", AlertMsg);
				reportInfo("Server "+testData.get("Name")+" edited successfully");
			}
			else {
				reportFail("Server", "A Server is updated with identifier", AlertMsg);
				reportFail("","", "Server "+testData.get("Name")+" is NOT updated");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I view the Server created above and Validate the IP Address field value {string}")
	public void i_view_the_server_created_above_and_validate_the_ip_address_field_value(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I view the Server created above and Validate the IP Address field value");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getServersPage().searchEditedServer(testData);
			String IPAddress = testSetup.pageObjectManager.getServersPage().validateIpAddress(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getServersPage().cancelButton();

			if(IPAddress.isEmpty()) {
				reportPass("IP Address", "IP Address field value null", "IP Address field value null");
				reportInfo("Server "+testData.get("Name")+" IP Address is null so that server created without IP adress successfully");
			}
			else {
				reportFail("IP Address", "IP Address field value null", "IP Address field value NOT null");
				reportInfo("Server "+testData.get("Name")+" IP Address is "+IPAddress+", server created with IP adress successfully");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	@Then("I delete the server {string}")
	public void i_delete_the_server(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the server");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getServersPage().searchEditedServer(testData);
			String AlertMsg = testSetup.pageObjectManager.getServersPage().deleteUpdatedServer(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A Server is deleted with identifier")) {
				reportPass("Delete message", "A Server is deleted with identifier", AlertMsg);
				reportInfo("Server "+testData.get("Name")+" deleted successfully");
			}
			else {
				reportFail("Delete message", "A Server is deleted with identifier", AlertMsg);
				reportFail("", "","Server "+testData.get("Name")+" NOT deleted successfully" );
			}

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("", "","Server NOT deleted successfully" );
		}
	}
}
