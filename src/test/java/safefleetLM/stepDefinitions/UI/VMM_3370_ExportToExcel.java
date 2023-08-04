package safefleetLM.stepDefinitions.UI;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.spire.xls.PageSetup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.PageObjectManager;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3370_ExportToExcel extends BaseTest {

	TestSetup testSetup;

	public VMM_3370_ExportToExcel(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Then("I export {string} excel")
	public void i_export_excel(String page) {
		// Write code here that turns the phrase above into concrete actions

		try {
			test = logInfo.get().createNode("I export " + page + " excel");
			test.assignCategory("Others");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

			if (page.equalsIgnoreCase("Customers")) {
				testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
			
			}

			else if (page.equalsIgnoreCase("Tenants")) {
				testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			} 
			else if (page.equalsIgnoreCase("EcoSystemSettings")) {
				testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
			} 
			else if (page.equalsIgnoreCase("DeviceSettings")) {
				testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
			}
			else if (page.equalsIgnoreCase("SalesRegion")) {
				testSetup.pageObjectManager.getHomePage().navigateToSalesRegions();
			}

			
			reportInfo("Navigated to " + page + " Page successfully");
			Thread.sleep(5000);
			reportScreenshot(testSetup.driver);
			FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + File.separator + "Downloads"));
			Thread.sleep(5000);
			testSetup.pageObjectManager.getHomePage().clickExportExcel();
			reportInfo(page + " Excel downloaded successfully");
			Thread.sleep(10000);
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}

	@Then("I verify downloaded file for {string}")
	public void i_verify_downloaded_file_for(String page) {
		// Write code here that turns the phrase above into concrete actions
		try {
			// Write code here that turns the phrase above into concrete actions
			test = logInfo.get().createNode("I verify downloaded filename for " + page);
			String expFileName = null;
			if (page.equalsIgnoreCase("Customers"))
				expFileName = "customer";
			else if (page.equalsIgnoreCase("Tenants"))
				expFileName = "tenant";
			else if (page.equalsIgnoreCase("SalesRegion"))
				expFileName = "salesRegion";
			else if (page.equalsIgnoreCase("EcoSystemSettings") || page.equalsIgnoreCase("DeviceSettings"))
				expFileName = "settings";
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm:ss aa");
			String dateString = dateFormat.format(new Date()).toString();
			String expTimestamp = dateString.substring(3, 5) + dateString.substring(0, 2) + dateString.substring(6, 10)
					+ dateString.substring(11, 13) + dateString.substring(14, 16);
			Thread.sleep(5000);
			File file = new File(System.getProperty("user.dir") + File.separator + "Downloads");

			String[] fileList = file.list();
			String actFilename = fileList[0].split("-")[0];
			String actTimestamp = fileList[0].split("-")[1].substring(0, 12);

			reportInfo("Downloaded Excel : " + "<b>" + fileList[0] + "</b>");
			validateField("File Name ", actFilename, expFileName);

			ArrayList<String> hd = ExcelFileReader.verifyExcelHeaders(fileList[0]);
			reportInfo(hd.toString());

			if (page.equalsIgnoreCase("Customers")) {
				validateField("Column ", "Customer", hd.get(0));
			} else if (page.equalsIgnoreCase("Tenants")) {
				validateField("Column 1", "Tenant ID", hd.get(0));
				validateField("Column 2", "Customer", hd.get(1));
			} else if (page.equalsIgnoreCase("EcoSystemSettings")) {
				validateField("Column 1", "Tenant ID", hd.get(0));
				validateField("Column 2", "Ecosystem", hd.get(1));
				validateField("Column 3", "Settings Type", hd.get(2));
			} else if (page.equalsIgnoreCase("DeviceSettings")) {
				validateField("Column 1", "Name", hd.get(0));
				validateField("Column 2", "Device Type", hd.get(1));
				validateField("Column 3", "Settings Type", hd.get(2));
			}
			else if (page.equalsIgnoreCase("salesRegion")) {
				validateField("Column 1", "Name", hd.get(0));
				validateField("Column 2", "Sales Representative", hd.get(1));
				validateField("Column 3", "Email", hd.get(2));
			}
			
			
			
			
			
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);

		}
	}
}
