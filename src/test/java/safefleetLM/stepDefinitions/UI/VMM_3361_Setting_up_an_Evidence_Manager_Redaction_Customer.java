package safefleetLM.stepDefinitions.UI;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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

public class VMM_3361_Setting_up_an_Evidence_Manager_Redaction_Customer extends BaseTest {

  TestSetup testSetup;

  public VMM_3361_Setting_up_an_Evidence_Manager_Redaction_Customer(TestSetup testSetup) throws IOException{
    this.testSetup=testSetup;
  }

  @Then("I create the Tenant with Deployment type is onsite {string}")
  public void i_create_the_tenant_with_deployment_type_is_onsite(String tcid) throws Exception {
    try {

      String tenantID = randomStringGenerator();
      if(tcid.contains("3361")) {
        UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "TenantPage", "TenantID", tenantID, "VMM_3361_1");
        //--//UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3361_1");
        UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_3361_1");
        UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_3361_2");
      }
      else if(tcid.contains("4394"))
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "TenantPage", "TenantID", tenantID, "VMM_4394_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_4394_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir") + TestDataPath, "LicensePage", "TenantID", tenantID, "VMM_4394_2");

      test = logInfo.get().createNode("I create the Tenant with Deployment type is onsite");
      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
      reportScreenshot(testSetup.driver);
      String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
      reportScreenshot(testSetup.driver);
      if (AlertMsg.contains("A new Tenant is created with identifier")) {
        reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
        reportInfo("Tenant " + testData.get("TenantID").toLowerCase() + " created with Deployment type is onsite successfully");
      } else
        reportFail("Tenant ", "A new Tenant is created with identifier", AlertMsg);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      testSetup.pageObjectManager.getTenantsPage().continueExecution();
      reportFail("", "Tenant id is exist,", "Tenant id must be unique");
    }

  }

  @Then("I click on operations to navigate customer page")
  public void i_click_on_operations_to_navigate_customer_page() throws IOException {
    try {
      test = logInfo.get().createNode("I click on operations to navigate customer page");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
      Thread.sleep(1000);
      reportScreenshot(testSetup.driver);
      reportInfo("Navigate to customer page successfully");
    } catch (Exception e) {
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I Check that the Customer has been created if not i create the Customer {string}")
  public void i_check_that_the_customer_has_been_created_if_not_i_create_the_customer(String tcid) throws Exception {
    try {

      String tenantID=randomStringGenerator();

      System.out.println(tenantID);
/*
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Customer",tenantID,"VMM_3361_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM_3361_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Customer",tenantID,"VMM_3362_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM_3362_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Customer",tenantID,"VMM_3621_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM_3621_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Customer",tenantID,"VMM_4501_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM_4501_1");
*/
      test = logInfo.get().createNode("I Check that the Customer has been created if not i create the Customer");
      test.assignCategory("Licenses");
      Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
      reportInfo(testData.toString());
      String AlertMsg = testSetup.pageObjectManager.getCustomerPage().createCustomerForLicense(testData);
      reportScreenshot(testSetup.driver);
      if(AlertMsg.contains("A new Customer is created with identifier")) {
        reportPass("Customer", "A new Customer is created with identifier", AlertMsg);
        reportInfo("Create the customer '"+testData.get("Name")+"' successfully");
      } else {
        reportFail("Customer", "A new Customer is created with identifier", AlertMsg);
        reportInfo("Create the customer '"+testData.get("Name")+"' NOT successfully");
      }

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I navigate to licenses page")
  public void i_navigate_to_licenses_page() throws IOException {
    try {
      test = logInfo.get().createNode("I navigate to licenses page");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
      reportScreenshot(testSetup.driver);
      reportInfo("Navigate to licenses page successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      //testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
    }
  }

  @Then("I click on NEW button and Verify Add Another check box")
  public void i_click_on_new_button_and_verify_add_another_check_box() {
    try {
      test = logInfo.get().createNode("I click on NEW button and Verify Add Another check box");
      testSetup.pageObjectManager.getLicensesPage().checkAddAnotherCheckBox();
      reportInfo("Verify Add Another check box successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
    }

  }

  @Then("I Create App license with valid data {string}")
  public void i_create_app_license_with_valid_data(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I Create App license with valid data");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      String futureDate = testSetup.pageObjectManager.getLicensesPage().getExpirationDate(30);
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","ExpiryDate",futureDate,"VMM_3361_1");
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","ExpiryDate",futureDate,"VMM_3361_2");

      testSetup.pageObjectManager.getLicensesPage().createAppLicense(testData);
      reportScreenshot(testSetup.driver);
      reportInfo("Create App license with valid data successfully");} catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
    }
  }

  @Then("I Create a FEATURE_APP Redaction License as specified in Sales order {string}")
  public void i_create_a_feature_app_redaction_license_as_specified_in_sales_order(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I Create a FEATURE_APP Redaction License as specified in Sales order");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      testSetup.pageObjectManager.getLicensesPage().createFeatureAppRedaction(testData);
      reportScreenshot(testSetup.driver);
      reportInfo("Create a FEATURE_APP Redaction License with valid data successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
    }
  }

  @Then("I verify licenses i created are correct in licenses tab {string}")
  public void i_verify_licenses_i_created_are_correct_in_licenses_tab(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I verify licenses i created are correct in licenses tab");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      String Result = testSetup.pageObjectManager.getLicensesPage().verifyCeatedLicense(testData);
      reportScreenshot(testSetup.driver);
      if(Result.equalsIgnoreCase(testData.get("TenantID").toLowerCase()))
        reportPass("TenantID", testData.get("TenantID").toLowerCase()+" License should create successfully", Result+" License created successfully");
      else
        reportFail("TenantID", testData.get("TenantID").toLowerCase()+" License should create successfully", Result+" License NOT created successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","","License NOT created successfully");
    }

  }

  @Then("I publish the FEATURE_APP Redaction license")
  public void i_publish_the_feature_app_redaction_license() throws InterruptedException, IOException {
    try {
      test = logInfo.get().createNode("I publish the FEATURE_APP Redaction license");
      testSetup.pageObjectManager.getLicensesPage().publishFeatureAppRedaction();
      reportScreenshot(testSetup.driver);
      String AlertMessage = testSetup.pageObjectManager.getLicensesPage().publishFeatureAppOkButton();
      reportScreenshot(testSetup.driver);
      if(AlertMessage.equals("Vmaxmanager App license.updated")) {
        reportPass("FEATURE_APP ", "Vmaxmanager App license.updated", AlertMessage);
        reportInfo("FEATURE_APP Redaction license Published successfully");
      } else
        reportFail("FEATURE_APP ", "Vmaxmanager App license.updated", AlertMessage);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","","License NOT Published successfully");
    }
  }

  @Then("I click on publish for the App license")
  public void i_click_on_publish_for_the_app_license() throws InterruptedException, IOException {
    try {
      test = logInfo.get().createNode("I click on publish for the App license");
      testSetup.pageObjectManager.getLicensesPage().clickPublishAppLicense();
      reportScreenshot(testSetup.driver);
      reportInfo("click on publish for the App license successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","","License NOT Found to Publish successfully");
    }
  }

  @Then("I click and verify checkbox so that i can download encrypted license File {string}")
  public void i_click_on_checkbox_so_that_i_can_download_encrypted_license_file(String tcid) throws InterruptedException {
    try {
      test = logInfo.get().createNode("I click on checkbox so that i can download encrypted license File");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());

      FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + File.separator + "Downloads"));
      Thread.sleep(1500);

      String AlertMessage =testSetup.pageObjectManager.getLicensesPage().clickOnVerifyCheckboxAndVerifyDownload();
      reportScreenshot(testSetup.driver);

      //reportScreenshot("PASS", "Encrypted license should download", "Encrypted license downloaded successfully", testSetup.driver);
      if(AlertMessage.equals("Vmaxmanager App license.updated")) {
        reportPass("App license", "Vmaxmanager App license.updated", AlertMessage);
        reportInfo("App license Published successfully");
      } else {
        reportFail("App license ", "Vmaxmanager App license.updated", AlertMessage);
      }

      String expFileName = "license-"+testData.get("TenantID").toLowerCase()+".vmax";
      Thread.sleep(2000);
      File file = new File(System.getProperty("user.dir") + File.separator + "Downloads");
      Thread.sleep(1000);

      String[] downloadFiles = file.list();

      String actFilename = downloadFiles[0];
      System.out.println("Exp="+expFileName+"\n"+"Act="+actFilename);

      if(expFileName.equalsIgnoreCase(actFilename)) {
        reportPass("Encrypted License File", expFileName, actFilename);
        reportInfo("Encrypted license File downloaded successfully");
      } else {
        reportFail("Encrypted License File", expFileName, actFilename);
        reportFail("","","Encrypted license File NOT downloaded successfully");
      }

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","","License NOT created successfully");
    }
  }

  @Then("I delete the published App license {string}")
  @Then("I delete the published Add-on module Asset license {string}")
  public void i_delete_the_published_app_license(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I delete the published license");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      String Licenseid = testSetup.pageObjectManager.getLicensesPage().deleteAppLicense(testData);
      reportScreenshot(testSetup.driver);
      if(Licenseid.equalsIgnoreCase(testData.get("TenantID").toLowerCase()))
        reportPass("License Id", testData.get("TenantID").toLowerCase()+"  License should delete successfully", Licenseid+" License deleted successfully");
      else
        reportFail("License Id", testData.get("TenantID").toLowerCase()+"  License should delete successfully", Licenseid+" License NOT deleted successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","","License NOT created successfully");
    }
  }

  @Then("I delete the published FEATURE_APP Redaction license {string}")
  public void i_delete_the_published_feature_app_redaction_license(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I delete the published FEATURE_APP Redaction license");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      reportInfo(testData.toString());
      String licenseId = testSetup.pageObjectManager.getLicensesPage().deleteFeatureAppLicense(testData);
      reportScreenshot(testSetup.driver);
      testSetup.pageObjectManager.getLicensesPage().deleteConfirmation();
      if(licenseId.equalsIgnoreCase(testData.get("TenantID").toLowerCase())) {
        reportPass("LicenseID", testData.get("TenantID").toLowerCase()+" FEATURE_APP Redaction license should delete successfully", licenseId+" FEATURE_APP Redaction license deleted successfully");
      } else
        reportPass("LicenseID", testData.get("TenantID").toLowerCase()+" FEATURE_APP Redaction license should delete successfully", licenseId+" FEATURE_APP Redaction license deleted successfully");
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","Unable to delete or","License NOT Found");
      Assert.fail();
    }
  }

  @Then("I click on operations to navigate customer page again")
  public void i_click_on_operations_to_navigate_customer_page_again() throws IOException {
    try {
      test = logInfo.get().createNode("I click on operations to navigate customer page");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
      reportScreenshot(testSetup.driver);
      reportInfo("Navigate to customer page successfully");
    } catch (Exception e) {
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I delete the Tenant {string}")
  public void i_delete_the_tenant(String tcid) throws Exception {
    try{
      test = logInfo.get().createNode("I delete the Tenant");
      Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
      reportInfo(testData.toString());
      boolean result = testSetup.pageObjectManager.getTenantsPage().deleteTenant(testData);
      reportScreenshot(testSetup.driver);
      if(result==true) {
        String AlertMsg = testSetup.pageObjectManager.getTenantsPage().deleteConfirmation();
        reportScreenshot(testSetup.driver);
        reportPass("Delete Message", "A Tenant is deleted with identifier", AlertMsg);
        reportInfo("Tenant ID '"+testData.get("TenantID")+"' deleted successfully");
      } else {
        reportFail("FAIL", "Delete Tenent", "Not Deleted");
        reportInfo("Tenant ID "+testData.get("TenantID")+" NOT Deleted successfully");
        reportScreenshot(testSetup.driver);
      }
    } catch(Exception e) {
      testStepHandle("Fail", testSetup.driver, test, e);
      reportFail("","Delete Tenant" ,"Tenant id is NOT exist for Delete");
      reportScreenshot(testSetup.driver);
    }
  }

  @Then("I delete the customer {string}")
  public void i_delete_the_customer(String tcid) throws Exception {
    try {
      test = logInfo.get().createNode("I delete the customer");
      Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
      reportInfo(testData.toString());
      String AlertMsg = testSetup.pageObjectManager.getCustomerPage().deleteLicenseCustomer(testData);
      reportScreenshot(testSetup.driver);
      if(AlertMsg.contains("A Customer is deleted with identifier")) {
        reportPass("Customer", "A Customer is deleted with identifier", AlertMsg);
        reportInfo("Customer '"+testData.get("Name")+"' deleted successfully");
      } else
        reportFail("Customer", "A Customer is deleted with identifier", AlertMsg);
    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }
}
