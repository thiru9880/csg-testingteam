package safefleetLM.stepDefinitions.UI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class VMM_5658_Prod_Verify_LM_Bulk_device_upload_options_in_Devices_screen extends BaseTest {
	
	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;

	public VMM_5658_Prod_Verify_LM_Bulk_device_upload_options_in_Devices_screen(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify that Download Spreadsheet & Upload Spreadsheet options are displayed under Bulk Upload")
	public void i_verify_the_bulk_upload_options() {
		try {
			test = logInfo.get().createNode("I verify that Download Spreadsheet & Upload Spreadsheet options are displayed under Bulk Upload");

			testSetup.pageObjectManager.getDevicePage().clickOnBulkUpload();
			boolean result = testSetup.pageObjectManager.getDevicePage().verifyBulkUploadOptions();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Bulk Upload options verification","Pass" , "Pass");
			}
			else {
				reportFail("Bulk Upload options verification","Fail" , "Fail");

			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

 
	@Then("I click on Download Spreadsheet option and verify that Bulk Device Upload template is getting downloaded")
	public void i_click_on_new_and_verify_new_ecosystem_settings_creation_screen() {
		String filePath = System.getProperty("user.dir") + File.separator + "Downloads";
		try {
			test = logInfo.get().createNode("I click on Download Spreadsheet option and verify that Bulk Device Upload template is getting downloaded");
			test.assignCategory("Production");
			testSetup.pageObjectManager.getDevicePage().clickBulkDownloadSpreadsheet();
			reportScreenshot(testSetup.driver);
			String actualFile= null;
			File file = new File(filePath);
			String[] files = file.list();
			List<String> xlsxFiles = new ArrayList<>();
			if (files != null) {
	            for (String fileName : files) {
	                if (fileName.toLowerCase().endsWith(".xlsx")) {
	                    xlsxFiles.add(fileName);
	                }
	            }
	        }
			if (!xlsxFiles.isEmpty()) {
	            
	            for (String xlsxFile : xlsxFiles) {
	                System.out.println(xlsxFile);
	                
	            }
	            actualFile = xlsxFiles.get(0);
	            System.out.println(actualFile);
	        } else {
	            System.out.println("No XLSX files found in the directory.");
	        }
			if(actualFile.contains("Template-v1")) {
				reportPass("Verification of Bulk Device Upload template", "Template-v1" , actualFile);
			}
			else {
				reportFail("Verification of Bulk Device Upload template", "Template-v1" , actualFile);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	

	
	}