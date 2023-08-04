package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class VMM_4330_NewDevicesAvailableInDeviceTypeAndLicenseTypeForDVRFirmware extends BaseTest {

	TestSetup testSetup;
	public VMM_4330_NewDevicesAvailableInDeviceTypeAndLicenseTypeForDVRFirmware(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I verify Devices TH8, TH12, NH16, DH4v2 with test data {string}{string}{string}{string}")
	public void i_verify_devices_th8_nh16k_nh16_th12_with_test_data(String tcid,String tcid2,String tcid3,String tcid4) {

		try {
			test = logInfo.get().createNode("I verify Devices TH8, TH12, NH16, DH4v2 with test data");
			//test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
      Map<String, String> testData2 = ExcelFileReader.getDataInMap("DeviceType", tcid2);
      Map<String, String> testData3 = ExcelFileReader.getDataInMap("DeviceType", tcid3);
      Map<String, String> testData4 = ExcelFileReader.getDataInMap("DeviceType", tcid4);
      testSetup.pageObjectManager.getDeviceTypesPage().scrollDown(3);
      String deviceTypeName = testSetup.pageObjectManager.getDeviceTypesPage().getDeviceTypeName(testData);
      reportScreenshot(testSetup.driver);
      if(deviceTypeName.equalsIgnoreCase(testData.get("Name"))) {
        reportPass("Device Type exits", testData.get("Name"),deviceTypeName);
      }
      else
      {
        reportFail("Device Type does not exits", testData.get("Name"),deviceTypeName);
      }
      deviceTypeName = testSetup.pageObjectManager.getDeviceTypesPage().getDeviceTypeName(testData2);
      reportScreenshot(testSetup.driver);
      if(deviceTypeName.equalsIgnoreCase(testData2.get("Name"))) {
        reportPass("Device Type exits", testData2.get("Name"),deviceTypeName);
      }
      else
      {
        reportFail("Device Type does not exits", testData2.get("Name"),deviceTypeName);
      }
      deviceTypeName = testSetup.pageObjectManager.getDeviceTypesPage().getDeviceTypeName(testData3);
      reportScreenshot(testSetup.driver);
      if(deviceTypeName.equalsIgnoreCase(testData3.get("Name"))) {
        reportPass("Device Type exits", testData3.get("Name"),deviceTypeName);
      }
      else
      {
        reportFail("Device Type does not exits", testData3.get("Name"),deviceTypeName);
      }
      deviceTypeName = testSetup.pageObjectManager.getDeviceTypesPage().getDeviceTypeName(testData4);
      reportScreenshot(testSetup.driver);
      if(deviceTypeName.equalsIgnoreCase(testData4.get("Name"))) {
        reportPass("Device Type exits", testData4.get("Name"),deviceTypeName);
      }
      else
      {
        reportFail("Device Type does not exits", testData4.get("Name"),deviceTypeName);
      }

      reportInfo("verified Devices TH8, TH12, NH16 and DH4v2 exits");

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I Verify Table Name device_type in DB with test data {string}")
	public void i_verify_table_name_device_type_in_db_with_test_data(String tcid) throws SQLException {
		try {

			test = logInfo.get().createNode("I Verify Table Name device_type in DB with test data");
			 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			List<Map<String, ?>> res1 = DBConnection.getData("SELECT * FROM test_license_manager.device_type where name='DH6';");
			List<Map<String, ?>> res2 = DBConnection.getData("SELECT * FROM test_license_manager.device_type where name='TH8';");
			List<Map<String, ?>> res3 = DBConnection.getData("SELECT * FROM test_license_manager.device_type where name='TH12';");
			List<Map<String, ?>> res4 = DBConnection.getData("SELECT * FROM test_license_manager.device_type where name='NH16';");
			List<Map<String, ?>> res5 = DBConnection.getData("SELECT * FROM test_license_manager.device_type where name='DH4v2';");

			System.out.println(res1);
			System.out.println(res1.get(0).get("NAME"));
			String DeviceType1  = res1.get(0).get("NAME").toString();
			String DeviceType2  = res2.get(0).get("NAME").toString();
			String DeviceType3  = res3.get(0).get("NAME").toString();
			String DeviceType4  = res4.get(0).get("NAME").toString();
			String DeviceType5  = res5.get(0).get("NAME").toString();


			if(DeviceType1.equalsIgnoreCase("DH6")) {
				reportPass("License status", "DH6", DeviceType1);
				reportInfo("verified device in Data Base is "+DeviceType1);
			}
			else {
				reportFail("License status", "DH6", DeviceType1);

			}

			if(DeviceType2.equalsIgnoreCase("TH8")) {
				reportPass("License status", "TH8", DeviceType2);
				reportInfo("verified device in Data Base is "+DeviceType2);
			}
			else {
				reportFail("License status", "TH8", DeviceType2);

			}

			if(DeviceType3.equalsIgnoreCase("TH12")) {
				reportPass("License status", "TH12", DeviceType3);
				reportInfo("verified device in Data Base is "+DeviceType3);
			}
			else {
				reportFail("License status", "TH12", DeviceType3);

			}
			if(DeviceType4.equalsIgnoreCase("NH16")) {
				reportPass("License status", "NH16", DeviceType4);
				reportInfo("verified device in Data Base is "+DeviceType4);
			}

			else {
				reportFail("License status", "NH16", DeviceType4);

			}

			if(DeviceType5.equalsIgnoreCase("DH4v2")) {
				reportPass("License status", "DH4v2", DeviceType5);
				reportInfo("verified device in Data Base is "+DeviceType5);
			}

			else {
				reportFail("License status", "DH4v2", DeviceType5);

			}
		}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I verify Licenses Sub Type TH8, TH12, NH16, DH4v2 in License Type Page with test data {string}{string}{string}{string}")
	public void i_verify_licenses_sub_type_th8_nh16k_nh16_th12_in_license_type_page_with_test_data(String tcid,String tcid2,String tcid3,String tcid4) {
		try {
			test = logInfo.get().createNode("I verify Licenses Sub Type TH8, TH12, NH16, DH4v2 in License Type Page with test data");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
      Map<String, String> testData2 = ExcelFileReader.getDataInMap("LicenseTypePage", tcid2);
      Map<String, String> testData3 = ExcelFileReader.getDataInMap("LicenseTypePage", tcid3);
      Map<String, String> testData4 = ExcelFileReader.getDataInMap("LicenseTypePage", tcid4);
      testSetup.pageObjectManager.getDeviceTypesPage().scrollDown(3);
      testSetup.pageObjectManager.getLicenseTypePage().verifyLicenseType(testData);
      testSetup.pageObjectManager.getLicenseTypePage().verifyLicenseType(testData2);
      testSetup.pageObjectManager.getLicenseTypePage().verifyLicenseType(testData3);
      testSetup.pageObjectManager.getLicenseTypePage().verifyLicenseType(testData4);
      reportScreenshot(testSetup.driver);
      reportInfo("verified Licenses Sub Type TH8, TH12, NH16, DH4v2 in License Type Page");

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I Verify Table Name license_type in DB with test data {string}")
	public void i_verify_table_name_license_type_in_db_with_test_data(String tcid) {
		try {

			test = logInfo.get().createNode("I Verify Table Name license_type in DB with test data");
			 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			List<Map<String, ?>> res1 = DBConnection.getData("SELECT * FROM test_license_manager.slot_type where software_id='33';");

			String DeviceType1  = res1.get(0).get("SOFTWARE_ID").toString();
			if(DeviceType1.equalsIgnoreCase("33")) {
				reportPass("Software_ID", "33", DeviceType1);
				reportInfo("verified Software_ID for DVR Firmware in Data Base is "+DeviceType1);
			}
			else {
				reportFail("Software_ID", "33", DeviceType1);

			}
		}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I create new tenant for VMM4330 with test data {string}")
	public void i_create_new_tenant_for_vmm4330_with_test_data(String tcid) {
		try {
			  String tenantID=randomStringGenerator();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-4330_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_1");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_2");

              UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_3");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_4");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_5");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-4330_6");



			   test = logInfo.get().createNode("I create new tenant with test data");

			   test.assignCategory("Licenses");

			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
          testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
          testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();

			    reportInfo("New tenant is created with test data ");

			    reportInfo("Test data "+testData);

			    reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}


	@Then("I verify integration and j1939 field not present for other than DVR Firmware Base Product with test data {string}")
	public void i_verify_integration_and_j1939_field_not_present_for_other_than_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify integration and j1939 field not present for other than DVR Firmware Base Product");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license DH6 for DVR Firmware Base Product with test data "+testData);

				}
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}
	@Then("I create DH6 for DVR Firmware Base Product with test data {string}")
	public void i_create_dh6_for_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new license DH6 for DVR Firmware Base Product with test data");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);
				String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
				reportScreenshot(testSetup.driver);

				reportInfo("Created new license DH6 for DVR Firmware Base Product with test data "+testData);

				}
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}

	@Then("I create TH8 for DVR Firmware Base Product with test data {string}")
	public void i_create_th8_for_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new license  TH8 for DVR Firmware Base Product with test data");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);
				String alertMsg = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
				reportScreenshot(testSetup.driver);
      if(alertMsg.equals("Vmaxmanager App license.updated"))
      {
        reportPass("license", "Vmaxmanager App license.updated", alertMsg);
        reportInfo("License Created successfully");
      }
      else
        reportFail("App license ", "Vmaxmanager App license.updated", alertMsg);

				}
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}

	@Then("I create TH12 for DVR Firmware Base Product with test data {string}")
	public void i_create_th12_for_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new license TH12 for DVR Firmware Base Product with test data");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);
				reportInfo("Verified default option as DIASABLED for integration and j1939 field for DVR Firmware Base Product");
				String alertMsg = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
				reportScreenshot(testSetup.driver);
      if(alertMsg.equals("Vmaxmanager App license.updated"))
      {
        reportPass("license", "Vmaxmanager App license.updated", alertMsg);
        reportInfo("License Created successfully");
      }
      else
        reportFail("App license ", "Vmaxmanager App license.updated", alertMsg);

				}
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}

	@Then("I create NH16 for DVR Firmware Base Product with test data {string}")
	public void i_create_nh16_for_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new license NH16 for DVR Firmware Base Product with test data");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);
				String alertMsg = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
				reportScreenshot(testSetup.driver);

      if(alertMsg.equals("Vmaxmanager App license.updated"))
      {
        reportPass("license", "Vmaxmanager App license.updated", alertMsg);
        reportInfo("License Created successfully");
      }
      else
        reportFail("App license ", "Vmaxmanager App license.updated", alertMsg);


    }
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}

	@Then("I create DH4v2 for DVR Firmware Base Product with test data {string}")
	public void i_create_dh4v2_for_dvr_firmware_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new license DH4v2 for DVR Firmware Base Product with test data");

				Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

				testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
				reportScreenshot(testSetup.driver);
				String alertMsg = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
				reportScreenshot(testSetup.driver);

      if(alertMsg.equals("Vmaxmanager App license.updated"))
      {
        reportPass("license", "Vmaxmanager App license.updated", alertMsg);
        reportInfo("License Created successfully");
      }
      else
        reportFail("App license ", "Vmaxmanager App license.updated", alertMsg);


    }
				catch(Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
	}
}
