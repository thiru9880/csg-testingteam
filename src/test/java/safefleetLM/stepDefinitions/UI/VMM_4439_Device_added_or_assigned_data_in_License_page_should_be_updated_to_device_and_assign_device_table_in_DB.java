package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_4439_Device_added_or_assigned_data_in_License_page_should_be_updated_to_device_and_assign_device_table_in_DB extends BaseTest {

	TestSetup testSetup;

	ArrayList<String> listOfDeviceTypes;

	String LicenseId;

	public VMM_4439_Device_added_or_assigned_data_in_License_page_should_be_updated_to_device_and_assign_device_table_in_DB(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I verify and store the device types to verify in assign devices table")
	public void i_verify_and_store_the_device_types_to_verify_in_assign_devices_table() {
		try {
			test = logInfo.get().createNode("I verify and store the device types to verify in assign devices table");
			listOfDeviceTypes = testSetup.pageObjectManager.getDeviceTypesPage().getAllDeviceTyps();
			reportScreenshot(testSetup.driver);
			if(listOfDeviceTypes.isEmpty()==false)
				reportInfo("verify and store the device types to verify in assign devices table successfully");
			else
				reportFail("DeviceType","", "verify and store the device types is Failure");

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I add or assign the new devices in License page under Actions {string}")
	public void i_add_or_assign_the_new_devices_in_license_page_under_actions(String tcid) {
		try {
			test = logInfo.get().createNode("I add or assign the new devices in License page under Actions");
			test.assignCategory("Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String[] Result = testSetup.pageObjectManager.getLicensesPage().assignDeviceToVerifyInDB(testData);
			reportScreenshot(testSetup.driver);
			LicenseId=Result[1];
			if(Result[0].equalsIgnoreCase("ASSIGNED"))
				reportInfo("Device assigned successfully");
			else
				reportFail("","", "Device NOT found or Unable to Assign");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}
	@Then("I verify that a list of available devices are retrieved from device table {string}")
	public void i_verify_that_a_list_of_available_devices_are_retrieved_from_device_table(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that a list of available devices are retrieved from device table");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			boolean Result = testSetup.pageObjectManager.getLicensesPage().verifyAvailableDevicesWithDeviceTypes(listOfDeviceTypes);
			reportScreenshot(testSetup.driver);
			if(Result==true) {
				reportPass("Device Type","list of available device Types should retrieved from device table" , "list of available device Types retrieved from device table");
				reportInfo("verify that a list of available device Types are retrieved from device Types table successfully");
			}
			else
				reportFail("Device Type","list of available device Types should retrieved from device table" , "list of available device Types are NOT retrieved from device table");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I verify that new devices assigned data in License page should be updated to device and assign_device table in DB {string}")
	public void i_verify_that_new_devices_assigned_data_in_license_page_should_be_updated_to_device_and_assign_device_table_in_db(String string) throws SQLException {
		try {

			test = logInfo.get().createNode("I verify that new devices assigned data in License page should be updated to device and assign_device table in DB");
			System.out.println(LicenseId);
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.assing_device where license_id='"+LicenseId+"';");
			//	System.out.println(res);
			Object ID = res.get(0).get("LICENSE_ID");
			String LID = ID.toString();
			if(LicenseId.equalsIgnoreCase(LID))
			{
				reportPass("assign_device", "Assigned data in License page should be updated in assign_device table in DB for License ID "+LicenseId+"", "Assigned data in License page updated in assign_device table in DB for License ID "+res.get(0).get("LICENSE_ID"));
				reportInfo("For License Id "+res.get(0).get("LICENSE_ID")+" Updated in Data Base assign_device table successfully");
			}
			else {
				reportFail("assign_device", "Assigned data in License page should be updated in assign_device table in DB for License ID "+LicenseId+"", "Assigned data in License page updated in assign_device table in DB for License ID "+res.get(0).get("LICENSE_ID"));
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	@Then("I verify that license_id column should be removed from the fleet_device_assign table {string}")
	public void i_verify_that_license_id_column_should_be_removed_from_the_fleet_device_assign_table(String string) throws SQLException {
		try {
			test = logInfo.get().createNode("I verify that license_id column should be removed from the fleet_device_assign table");
			System.out.println(LicenseId);
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.fleet_device_assign;");
			//	System.out.println(res);

			if(res.toString().contains("LICENSE_ID")) {
				reportFail("fleet_device_assign", "license_id column should be removed from the fleet_device_assign table", "license_id column NOT removed from the fleet_device_assign table");
			}
			else {
				reportPass("fleet_device_assign", "license_id column should be removed from the fleet_device_assign table", "license_id column removed from the fleet_device_assign table");
				reportInfo("verify license_id column removed in fleet_device_assign table successfully");
			}
			testSetup.pageObjectManager.getLicensesPage().unAssignTheDevice();
			reportScreenshot(testSetup.driver);
			reportInfo("unassign the device i assigned successfully");
		}

		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I unassign the device i assigned")
	public void i_unassign_the_device_i_assigned(String string) throws SQLException {
		try {
			test = logInfo.get().createNode("I unassign the device i assigned");

			testSetup.pageObjectManager.getLicensesPage().unAssignTheDevice();
			reportScreenshot(testSetup.driver);
			reportInfo("unassign the device i assigned successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

}
