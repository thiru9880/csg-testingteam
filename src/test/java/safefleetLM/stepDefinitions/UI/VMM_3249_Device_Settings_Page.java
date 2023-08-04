package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3249_Device_Settings_Page extends BaseTest {

  TestSetup testSetup;

  public VMM_3249_Device_Settings_Page(TestSetup testSetup) throws IOException {
    this.testSetup = testSetup;
  }

  @Then("I create new Tenant with test Data {string}")
  public void I_create_new_Tenant_with_test_Data(String tcid) throws InterruptedException {
    try {
      //String tenantID=randomStringGenerator();
      //UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3249_1");
      //UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3249_1");
      //UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM3249_1");
      test = logInfo.get().createNode("Pre-condition: I Create a Tenant");
      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());

      testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
      reportInfo("I Create a  tenant with Test data");
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getTenantsPage().clickOnTenantsave();
      reportInfo("Tenant Created Successfully");
      reportScreenshot(testSetup.driver);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      testSetup.pageObjectManager.getTenantsPage().continueExecution();
      reportFail("", "Tenant id is exist,", "Tenant id must be unique");
    }
  }


  @Then("Pre-condition: I create a Device {string}")
  public void pre_condition_i_create_a_device(String tcid) {
    try {
      String serialID = randomStringGenerator();
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "Devices", "serial", serialID, "VMM3249_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "Devices", "DeviceID", serialID, "VMM3249_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "Devices", "MAC Address", serialID, "VMM3249_1");

      test = logInfo.get().createNode("Pre-condition: I create a Device");
      test.assignCategory("Device Settings");
      Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getHomePage().navigateToDevicesTab();
      testSetup.pageObjectManager.getDevicePage().CreateDeviceNew(testData);
      reportInfo("I Create a Device With TestData");
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getDevicePage().DeviceSave();

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

  @Then("Pre-condition: I create a License and assign devices {string}")
  public void pre_condition_i_create_a_license_and_assign_devices(String tcid) {
    try {
      test = logInfo.get().createNode("Pre-condition: I create a License and assign devices");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().CreateNewLicense(testData);
      reportInfo("I Create a License With TestData");
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
      Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
      reportInfo(testData2.toString());
      testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
      testSetup.pageObjectManager.getLicensesPage().LicenseAssignToDevice(testData2);
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().ConformAssignDevice(testData2);
      reportScreenshot(testSetup.driver);
      reportInfo("I Assign The Device to the License");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

  @Then("I Verify it navigates to the settings page it is rendered correctly {string}")
  public void i_Verify_navigates_to_the_settings_page_it_is_rendered_correctly(String tcid) {
    try {
      test = logInfo.get().createNode("I Verify it navigates to the settings page it is rendered correctly");
      Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
      String VerifySettingPage = testSetup.pageObjectManager.getLicensesPage().verifyNavigateToSettinsPage();
      reportInfo("navigates to the settings Successfully");
      reportScreenshot(testSetup.driver);
      if (VerifySettingPage.contains("View Device Settings")) {
        reportPass("I Verify it navigates to the settings page it is rendered correctly", "View Device Settings", VerifySettingPage);
        reportInfo("successfully Navigating to settings page");
      } else {
        reportFail("I Verify it navigates to the settings page it is rendered correctly", "View Device Settings", VerifySettingPage);
        reportInfo("Navigating to settings page Not Successful");
        reportScreenshot(testSetup.driver);
      }

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }


  }

  @Then("I Verify if all the buttons in View Device Settings page are working {string}")
  public void I_Verify_if_all_the_buttons_in_View_Device_Settings_page_are_working(String tcid) {
    try {
      test = logInfo.get().createNode("I Verify if all the buttons in View Device Settings page are working");
      Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
      reportInfo(testData.toString());
      reportInfo("i verify new button is working in View Device Settings page");
      String VerifynewSettingpage = testSetup.pageObjectManager.getLicensesPage().verifyNewButtonINSettings();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().CancelAfterSettingPage();
      if (VerifynewSettingpage.contains("New Device Settings")) {
        reportPass("I Verify view device Setting page New Button is working Successfully", "New Device Settings", VerifynewSettingpage);
        reportInfo("New Button is working Successfully in View Device Settings Page");
      } else {
        reportFail("view device Setting page New Button is not  working Successfully", "New Device Settings", VerifynewSettingpage);
        reportInfo("New Button is Not working ");
        reportScreenshot(testSetup.driver);
      }

      testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
      testSetup.pageObjectManager.getLicensesPage().verifyNavigateToSettinsPage();
      reportInfo("i Verify Edit button is working in View Device Settings page");
      String VerifyEditSettingpage = testSetup.pageObjectManager.getLicensesPage().verifyEditButtonINSettings();
      reportScreenshot(testSetup.driver);
      if (VerifyEditSettingpage.contains("Edit Device Settings")) {
        reportPass("I Verify view device Setting page Edit device Setting  Button is working Successfully", "Edit Device Settings", VerifyEditSettingpage);
        reportInfo("Edit Button is working Successfully in View Device Settings Page");
      } else {
        reportFail("view device Setting page Edit Button is not  working Successfully", "Edit Device Settings", VerifyEditSettingpage);
        reportInfo("Edit Button is Not working ");
        reportScreenshot(testSetup.driver);
      }
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I Unassign the Device In License {string}")
  public void i_unassign_device_in_license(String tcid) {
    try {
      test = logInfo.get().createNode("I Unassign the Device In License");
      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
      testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().UnAssignDevice();
      reportInfo("I UnAssign The Device in License");
      reportScreenshot(testSetup.driver);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

  @Then("I delete the license {string}")
  public void I_delete_the_license(String tcid) {
    try {
      test = logInfo.get().createNode("I delete the license");
      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
      testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
      reportInfo("License deleted Successfully");

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I delete the Device {string}")
  public void I_delete_the_device(String tcid) {
    try {
      test = logInfo.get().createNode("I delete the device");
      Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
      reportInfo(testData2.toString());
      testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData2);
      testSetup.pageObjectManager.getDevicePage().SelectDeleteIconCreatedDevice();
      reportInfo("Device deleted Successfully");
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getDevicePage().ConformDeleteCreatedDevice();
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

}

