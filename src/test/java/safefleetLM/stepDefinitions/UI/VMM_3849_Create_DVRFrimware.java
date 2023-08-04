package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3849_Create_DVRFrimware extends BaseTest {

	TestSetup testSetup;


	public VMM_3849_Create_DVRFrimware(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I navigate to the System Admin Tab")
	public void i_navigate_to_the_system_admin_tab()
	{
		test = logInfo.get().createNode("I navigate to the System Admin Tab");
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		reportInfo("Navigate to the System Admin Tab Successful");
	}

	@Then("I verify the base product DVR Firmware exist {string}")
	public void i_verify_the_base_product_dvr_firmware_exist(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the base product DVR Firmware exist");
			test.assignCategory("System Admin");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductclickview(testData);
			if(text.equalsIgnoreCase(testData.get("Name"))) {
				reportPass("Base Product Name", testData.get("Name"), text);
				reportInfo("Verify the base product DVR Firmware exist Successful");
			}
			else
			{
				reportFail("Base Product Name", testData.get("Name"), text);
				reportInfo("The base product DVR Firmware dose not exist Successful");
			}
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	@Then("I verify the Base Product details with test data {string}")
	public void i_verify_the_base_product_detailse_with_test_data(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the Base Product detailse with test data");
			reportInfo("verify the Base Product detailse with test data Successful");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			reportInfo(testData.toString());

			String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductName3849(testData);
			if(text.equalsIgnoreCase(testData.get("Name")))
				reportPass("Base Product Name", testData.get("Name"), text);
			else
				reportFail("Base Product Name", testData.get("Name"), text);

			String text2=testSetup.pageObjectManager.getBaseProductPage().verifyDVRIcon(testData);
			if(text2.equalsIgnoreCase(testData.get("Icon")))
				reportPass("Base Product Icon", testData.get("Icon"), text2);
			else
				reportFail("Base Product Icon", testData.get("Icon"), text2);

			String text3=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductCloud3849(testData);
			if(text3.equalsIgnoreCase(testData.get("Cloud")))
				reportPass("Cloud", testData.get("Cloud"), text3);
			else
				reportFail("Cloud", testData.get("Cloud"), text3);

			String text4=testSetup.pageObjectManager.getBaseProductPage(). verifyBaseProductLocal3849(testData);
			if(text4.equalsIgnoreCase(testData.get("Local")))
				reportPass("Local", testData.get("Local"), text4);
			else
				reportFail("Local", testData.get("Local"), text4);

			String text5=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductEcosystem3849(testData);
			if(text5.equalsIgnoreCase(testData.get("Ecosystem")))
				reportPass("Ecosystem", testData.get("Ecosystem"), text5);
			else
				reportFail("Ecosystem", testData.get("Ecosystem"), text5);

			reportInfo(testData.toString());
			reportScreenshot(testSetup.driver);
			reportInfo("Verify the Base Product detailse with test data SuccessFull");
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify the License Type: DEVICE  License Sub Type: DH6 exist {string}")
	public void i_verify_the_license_type_device_license_sub_type_dh6_exist(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the License Type: DEVICE  License Sub Type: DH6 exist");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			String text=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProductDVRFrimwareDH6(testData);
			if(text.equalsIgnoreCase(testData.get("LicenseSubType"))) {
				reportPass("License Sub Type", testData.get("LicenseSubType"), text);
				reportInfo("Verify the License Type: DEVICE  License Sub Type: DH6 exist Successful");
			}
			else
			{
				reportFail("License Sub Type", testData.get("LicenseSubType"), text);
				reportInfo("The License Type: DEVICE  License Sub Type: DH6 dose not exist");
			}
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify the License Type details with test data of DH6 {string}")
	public void i_verify_the_license_type_detailse_with_test_data_of_dh6(String tcid) throws Exception
	{
		try {
			System.out.println("TC "+tcid);
			test = logInfo.get().createNode("I verify the License Type detailse with test data of DH6");
			reportInfo("Verify the License Type detailse with test data Successful");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			String text=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProductDH6(testData);
			if(text.equalsIgnoreCase(testData.get("LicenseType")))
				reportPass("License Type", testData.get("LicenseType"), text);
			else
				reportFail("License Type", testData.get("LicenseType"), text);

			String text2=testSetup.pageObjectManager.getLicenseTypePage().verifyDVRIcon(testData);
			if(text2.equalsIgnoreCase(testData.get("BaseProduct")))
				reportPass("Base Product", testData.get("BaseProduct"), text2);
			else
				reportFail("Base Product", testData.get("BaseProduct"), text2);

			String text3=testSetup.pageObjectManager.getLicenseTypePage().verifyLicensesubType_3849(testData);
			if(text3.equalsIgnoreCase(testData.get("LicenseSubType")))
				reportPass("License Sub Type", testData.get("LicenseSubType"), text3);
			else
				reportFail("License Sub Type", testData.get("LicenseSubType"), text3);

			String text4=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresData_3849(testData);
			if(text4.equalsIgnoreCase(testData.get("RequiresData")))
				reportPass("Require Data", testData.get("RequiresData"), text4);
			else
				reportFail("Require Data", testData.get("RequiresData"), text4);

			String text5=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresQTY1_3849(testData);
			if(text5.equalsIgnoreCase(testData.get("RequiresQTY")))
				reportPass("Require Quntity", testData.get("RequiresQTY"), text5);
			else
				reportFail("Require Quntity", testData.get("RequiresQTY"), text5);

			String text6=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresDevice_3849(testData);
			if(text6.equalsIgnoreCase(testData.get("RequiresDevice")))
				reportPass("Require Device", testData.get("RequiresDevice"), text6);
			else
				reportFail("Require Device", testData.get("RequiresDevice"), text6);
			/*
			String text7=testSetup.pageObjectManager.getLicenseTypePage().verifyrequiresEcoSystem1_3849(testData);
			if(text7.equalsIgnoreCase(testData.get("RequiresEcosystem")))
				reportPass("Require Eco System", testData.get("RequiresEcosystem"), text7);
			else
				reportFail("Require Eco System", testData.get("RequiresEcosystem"), text7);
			*/
			String text8=testSetup.pageObjectManager.getLicenseTypePage().verifyRequireserver_3849(testData);
			if(text8.equalsIgnoreCase(testData.get("RequiresServer")))
				reportPass("Require Server", testData.get("RequiresServer"), text8);
			else
				reportFail("Require Server", testData.get("RequiresServer"), text8);

			String text9=testSetup.pageObjectManager.getLicenseTypePage().verifySyncToTM1_3849(testData);
			if(text9.equalsIgnoreCase(testData.get("SyncToTM")))
				reportPass("Sync To TM", testData.get("SyncToTM"), text9);
			else
				reportFail("Sync To TM", testData.get("SyncToTM"), text9);
			reportInfo(testData.toString());
			reportInfo("Verify the License Type detailse with test data of DH6 Succefully");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicenseTypePage().clickonBackBtn();

		}
		catch(AssertionError | Exception e)
		{
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify the License Type: DEVICE  License Sub Type: DH8 exist {string}")
	public void i_verify_the_license_type_device_license_sub_type_dh8_exist(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the License Type: DEVICE  License Sub Type: DH8 exist");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			String text=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProductDVRFrimwareDH8(testData);
			if(text.equalsIgnoreCase(testData.get("LicenseSubType1"))) {
				reportPass("License Sub Type", testData.get("LicenseSubType1"), text);
				reportInfo("Verify the License Type: DEVICE  License Sub Type: DH8 Successful");
			}
			else
			{
				reportFail("License Sub Type", testData.get("LicenseSubType1"), text);
				reportInfo("The License Type: DEVICE  License Sub Type: DH8 dose not exist");
			}
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}
	@Then("I navigate to View License Type of License Sub Type: DH8")
	public void i_navigate_to_view_license_type_of_license_sub_type_dh8()
	{
		test = logInfo.get().createNode("I navigate to View License Type of License Sub Type: DH8");
		reportInfo("navigate to View License Type of License Sub Type: DH8 Successful");
	}
	@Then("I verify the License Type details with test data of DH8 {string}")
	public void i_verify_the_license_type_detailse_with_test_data_of_dh8(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the License Type detailse with test data of DH8");
			reportInfo("verify the License Type detailse with test data Successful");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			String text=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProduct_DH8(testData);
			if(text.equalsIgnoreCase(testData.get("LicenseType1")))
				reportPass("License Type", testData.get("LicenseType1"), text);
			else
				reportFail("License Type", testData.get("LicenseType1"), text);

			String text2=testSetup.pageObjectManager.getLicenseTypePage().verifyDVRIcon_2(testData);
			if(text2.equalsIgnoreCase(testData.get("BaseProduct1")))
				reportPass("Base Product", testData.get("BaseProduct1"), text2);
			else
				reportFail("Base Product", testData.get("BaseProduct1"), text2);

			String text3=testSetup.pageObjectManager.getLicenseTypePage().verifyLicensesubType_3849_2(testData);
			if(text3.equalsIgnoreCase(testData.get("LicenseSubType1")))
				reportPass("License Sub Type", testData.get("LicenseSubType1"), text3);
			else
				reportFail("License Sub Type", testData.get("LicenseSubType1"), text3);

			String text4=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresData_3849_2(testData);
			if(text4.equalsIgnoreCase(testData.get("RequiresData1")))
				reportPass("Require Data", testData.get("RequiresData1"), text4);
			else
				reportFail("Require Data", testData.get("RequiresData1"), text4);

			String text5=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresQTY1_3849_2(testData);
			if(text5.equalsIgnoreCase(testData.get("RequiresQTY1")))
				reportPass("Require Quntity", testData.get("RequiresQTY1"), text5);
			else
				reportFail("Require Quntity", testData.get("RequiresQTY1"), text5);

			String text6=testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresDevice_3849_2(testData);
			if(text6.equalsIgnoreCase(testData.get("RequiresDevice1")))
				reportPass("Require Device", testData.get("RequiresDevice1"), text6);
			else
				reportFail("Require Device", testData.get("RequiresDevice1"), text6);

			String text7=testSetup.pageObjectManager.getLicenseTypePage().verifyrequiresEcoSystem1_3849_2(testData);
			if(text7.equalsIgnoreCase(testData.get("RequiresEcosystem1")))
				reportPass("Require Eco System", testData.get("RequiresEcosystem1"), text7);
			else
				reportFail("Require Eco System", testData.get("RequiresEcosystem1"), text7);

			String text8=testSetup.pageObjectManager.getLicenseTypePage().verifyRequireserver_3849_2(testData);
			if(text8.equalsIgnoreCase(testData.get("RequiresServer1")))
				reportPass("Require Server", testData.get("RequiresServer1"), text8);
			else
				reportFail("Require Server", testData.get("RequiresServer1"), text8);

			String text9=testSetup.pageObjectManager.getLicenseTypePage().verifySyncToTM1_3849_2(testData);
			if(text9.equalsIgnoreCase(testData.get("SyncToTM1")))
				reportPass("Sync To TM", testData.get("SyncToTM1"), text9);
			else
				reportFail("Sync To TM", testData.get("SyncToTM1"), text9);
			reportInfo(testData.toString());
			reportInfo("Verify the License Type detailse with test data of DH6 Succefully");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicenseTypePage().clickonBackBtn();
		}
		catch(AssertionError | Exception e)
		{
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}
	@Then("I verify the Device Type with Name DH6 exist {string}")
	public void i_verify_the_device_type_with_name_dh6_exist(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the Device Type with Name DH6 exist");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			String text=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceName(testData);
			if(text.equalsIgnoreCase(testData.get("Name"))) {
				reportPass("Device Type", testData.get("Name"),text);
				reportInfo("verify the Device Type with Name DH6 exist Successful");
			}
			else
			{
				reportFail("Device Type", testData.get("Name"),text);
				reportInfo("The Device Type with Name DH6 dose not exist");
			}
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}

	}


	@Then("I verify the Device Type details with test data of DH6 {string}")
	public void i_verify_the_device_type_detailse_with_test_data_of_dh6(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the Device Type detailse with test data of DH6");
			reportInfo("verify the Device Type detailse with test data Successful");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			reportInfo(testData.toString());
			String text1=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceTypeDH6(testData);
			if(text1.equalsIgnoreCase(testData.get("Name")))
				reportPass("Device Type", testData.get("Name"),text1);
			else
				reportFail("Device Type", testData.get("Name"),text1);

			String text2=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceIDofDH6(testData);
			if(text2.equalsIgnoreCase(testData.get("DeviceIDLabel")))
				reportPass("Device ID Label", testData.get("DeviceIDLabel"), text2);
			else
				reportFail("Device ID Label", testData.get("DeviceIDLabel"), text2);

			String text3=testSetup.pageObjectManager.getDeviceTypesPage().verifyImportIDDH6(testData);
			if(text3.equalsIgnoreCase(testData.get("ImportDeviceId")))
				reportPass("Import Device Id", testData.get("ImportDeviceId"), text3);
			else
				reportFail("Import Device Id", testData.get("ImportDeviceId"), text3);
			//Sav Feature change, below field is removed from LM app
			/*
			String text4=testSetup.pageObjectManager.getDeviceTypesPage().verifyRequiredIDDH6(testData);
			if(text4.equalsIgnoreCase(testData.get("RequiresDeviceID")))
				reportPass("Requires Device ID", testData.get("RequiresDeviceID"), text4);
			else
				reportFail("Requires Device ID", testData.get("RequiresDeviceID"), text4);
			*/
			String text5=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceSettingDH6(testData);
			if(text5.equalsIgnoreCase(testData.get("RequiresDeviceSetting")))
				reportPass("Requires Device Settings", testData.get("RequiresDeviceSetting"), text5);
			else
				reportFail("Requires Device Settings", testData.get("RequiresDeviceSetting"), text5);

			reportInfo(testData.toString());
			reportInfo("Verify the Device Type details with test data of DH6 SuccessFull");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDeviceTypesPage().clickonBackBtn();
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}
	@Then("I verify the Device Type with Name DH8 exist {string}")
	public void i_verify_the_device_type_with_name_dh8_exist(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the Device Type with Name DH8 exist");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			String text=testSetup.pageObjectManager.getDeviceTypesPage().verifydeviceNameDH8(testData);
			if(text.equalsIgnoreCase(testData.get("Name1"))) {
				reportPass("Device Type", testData.get("Name1"),text);
				reportInfo("Verify the Device Type with Name DH8 exist Successful");
			}
			else
			{
				reportFail("Device Type", testData.get("Name1"),text);
				reportInfo("The Device Type with Name DH8 does not exist");
			}
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	@Then("I verify the Device Type details with test data of DH8 {string}")
	public void i_verify_the_device_type_detailse_with_test_data_of_dh8(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify the Device Type detailse with test data of DH8");
			reportInfo("verify the Device Type detailse with test data Successful");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			reportInfo(testData.toString());
			String text=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceTypeDH8(testData);
			if(text.equalsIgnoreCase(testData.get("Name1")))
				reportPass("Device Type", testData.get("Name1"),text);
			else
				reportFail("Device Type", testData.get("Name1"),text);

			String text2=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceIDofDH8(testData);
			if(text2.equalsIgnoreCase(testData.get("DeviceIDLabel1")))
				reportPass("Device ID Label", testData.get("DeviceIDLabel1"), text2);
			else
				reportFail("Device ID Label", testData.get("DeviceIDLabel1"), text2);

			String text3=testSetup.pageObjectManager.getDeviceTypesPage().verifyImportIDDH8(testData);
			if(text3.equalsIgnoreCase(testData.get("ImportDeviceId1")))
				reportPass("Import Device Id", testData.get("ImportDeviceId1"), text3);
			else
				reportFail("Import Device Id", testData.get("ImportDeviceId1"), text3);
			/*
			String text4=testSetup.pageObjectManager.getDeviceTypesPage().verifyRequiredIDDH8(testData);
			if(text4.equalsIgnoreCase(testData.get("RequiresDeviceID1")))
				reportPass("Requires Device ID", testData.get("RequiresDeviceID1"), text4);
			else
				reportFail("Requires Device ID", testData.get("RequiresDeviceID1"), text4);
			*/
			String text5=testSetup.pageObjectManager.getDeviceTypesPage().verifyDeviceSettingDH8(testData);
			if(text5.equalsIgnoreCase(testData.get("RequiresDeviceSetting1")))
				reportPass("Requires Device Settings", testData.get("RequiresDeviceSetting1"), text5);
			else
				reportFail("Requires Device Settings", testData.get("RequiresDeviceSetting1"), text5);
			reportInfo("Verify the Device Type detailse with test data of DH8 SuccessFull");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDeviceTypesPage().clickonBackBtn();
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}
}
