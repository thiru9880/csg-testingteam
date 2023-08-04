package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3740_BulkCreateBulkEdit extends BaseTest{

	TestSetup testSetup;
	public VMM_3740_BulkCreateBulkEdit(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I click on bulk upload button, select upload spreadsheet and click on upload button")
	public void i_click_on_bulk_upload_button_select_upload_spreadsheet_and_click_on_upload_button() {
		try
        { 
			 String tenantID1=randomStringGenerator();
			 String tenantID2=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_3740.xlsx","DevicesSpreadSheet","Serial #",tenantID1,"VMM-3740_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_3740.xlsx","DevicesSpreadSheet","Device ID",tenantID1,"VMM-3740_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_3740.xlsx","DevicesSpreadSheet","Serial #",tenantID2,"VMM-3740_2");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_3740.xlsx","DevicesSpreadSheet","Device ID",tenantID2,"VMM-3740_2");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getDevicePage().navigateToDevices();
    		test = logInfo.get().createNode("I click on bulk upload button, select upload spreadsheet and click on upload button");
    		test.assignCategory("Devices");
    		testSetup.pageObjectManager.getDevicePage().clickOnBulkUploadAndUploadSpreadheet();
    		testSetup.pageObjectManager.getBulkDeviceUploadPage().uploadFile(System.getProperty("user.dir")+"\\upload\\VMM_3740.xlsx");
    		testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnUploadButton();
    		reportInfo("I clicked on upload button successfully");
			reportScreenshot(testSetup.driver);
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}

	@Then("I verify Customer Provided column and Device status column is displayed in UI with test data {string}")
	public void i_verify_customer_provided_column_and_device_status_column_is_displayed_in_ui_with_test_data(String tcid) {
		try
        {
			test = logInfo.get().createNode("I verify Customer Provided column and Device status column is displayed in UI");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			testSetup.pageObjectManager.getBulkDeviceUploadPage().bulkDeviceUploadDropdown();
			reportScreenshot(testSetup.driver);
    		reportInfo("Verified Customer Provided column and Device status column is displayed in UI");

        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}
	
	@Then("I select device for bulk edit with test data {string}")
	public void i_select_device_for_bulk_edit_with_test_data(String tcid) {
		try
        {		
			test = logInfo.get().createNode("I select device for bulk edit with test data ");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
            testSetup.pageObjectManager.getDevicePage().SearchCreatedDeviceByContains(testData);
            testSetup.pageObjectManager.getDevicePage().selectTwoDeviceForBulkEdit(testData);
    		reportInfo("I selected device for bulk edit  ");
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}
		
	@Then("I click on bulk edit")
	public void i_click_on_bulk_edit() {
		try
        {		
			test = logInfo.get().createNode("I click on bulk edit");
            testSetup.pageObjectManager.getDevicePage().clickOnBulkEdit(null);
    		reportInfo("I clicked on bulk edit ");
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}
	
	@Then("i click on device manually selsected")
	public void i_click_on_device_manually_selsected() {
		try
        {		
			test = logInfo.get().createNode("I click on device manually selsected");
            testSetup.pageObjectManager.getDevicePage().clickOnDevicesManuallySelected();
    		reportInfo("I clicked on bulk edit ");
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	   
	}

	@Then("i edit device type with test data {string}")
	public void i_edit_device_type_with_test_data(String tcid) {
		try
        {		
			test = logInfo.get().createNode("i edit device type ");
            testSetup.pageObjectManager.getDevicePage().editDeviceType();
    		reportInfo("I edited device type");
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}


	@Then("I verify device type is updated")
	public void i_verify_device_type_is_updated() {
		try
        {
			test = logInfo.get().createNode("I verify device type is updated");
			testSetup.pageObjectManager.getBulkDeviceUploadPage().bulkDeviceUploadDropdown();
			reportScreenshot(testSetup.driver);
    		reportInfo("Verified device type is updated");

        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}
	@Then("I delete all Device {string}")
	public void i_delete_all_device(String tcid) {
		try
        {		
			test = logInfo.get().createNode("I delete all Device");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
            testSetup.pageObjectManager.getDevicePage().SearchCreatedDeviceByContains(testData);
            testSetup.pageObjectManager.getDevicePage().deleteTheDevice();
            testSetup.pageObjectManager.getDevicePage().SearchCreatedDeviceByContains(testData);
            testSetup.pageObjectManager.getDevicePage().deleteTheDevice();
    		reportInfo("I deleted all Device");
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
	}

}

