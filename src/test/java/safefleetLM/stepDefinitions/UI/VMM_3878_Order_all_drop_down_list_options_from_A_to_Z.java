package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.List;
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

public class VMM_3878_Order_all_drop_down_list_options_from_A_to_Z extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3878_Order_all_drop_down_list_options_from_A_to_Z(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I Verify if all the drop down values in the application are ordered In Tenants Page")
	public void i_verify_if_all_the_drop_down_values_in_the_application_are_ordered_in_tenants_page() {
		
		try {
			test = logInfo.get().createNode("I Verify if all the drop down values in the application are ordered In Tenants Page");
			test.assignCategory("Others");
			//tenantTypeinTenantpage
			List[] StatusOfTenantTypeDropDown = testSetup.pageObjectManager.getTenantsPage().verifyTenatTypeDropTownOrderINTenant();
			reportInfo("I Verify Tenant Type DropDown Is Orderd A to Z or Not in TenantPage");
			reportScreenshot(testSetup.driver);

			if( StatusOfTenantTypeDropDown[0].equals(StatusOfTenantTypeDropDown[1])) {
				reportPass("List of Tenants Type DropDownValues :",  StatusOfTenantTypeDropDown[0].toString(), StatusOfTenantTypeDropDown[1].toString());
				reportInfo("Tenant Type DropDown Is Orderd A to Z Correctly In TenantPage");
			}else {
				reportFail("Tenants Type DropDownValues Not Ordred",  "Not Ordred",  "Not Ordred");
			}
			reportInfo(" ");
			
			//DeploymentTypeinTenantpage
			List[] StatusOfDeploymentTypeDropDown = testSetup.pageObjectManager.getTenantsPage().verifyDeploymentTypeDropTownOrderINTenant();
			reportInfo("I Verify Deployment Type DropDown Is Orderd A to Z  or Not in TenantPage");
			reportScreenshot(testSetup.driver);
			if( StatusOfDeploymentTypeDropDown[0].equals(StatusOfDeploymentTypeDropDown[1])) {
				reportPass("List of Deployment Type DropDownValues :",  StatusOfDeploymentTypeDropDown[0].toString(), StatusOfDeploymentTypeDropDown[1].toString());
				reportInfo("Deployment Type DropDown Is Orderd A to Z Correctly In TenantPage");
			}else {
				reportFail("Deployment Type DropDownValues Not Ordred",  "Not Ordred",  "Not Ordred");
			}
			reportInfo(" ");
			
			//salesregionIntenantPage
			
			List[] StatusOfSalesRegionTypeDropDown = testSetup.pageObjectManager.getTenantsPage().verifySalesRegionDropTownOrderINTenant();
			reportInfo("I Verify SalesRegion Type DropDown Is Orderd A to Z  or Not in TenantPage");
			reportScreenshot(testSetup.driver);
			if( StatusOfSalesRegionTypeDropDown[0].equals(StatusOfSalesRegionTypeDropDown[1])) {
				reportPass("List of SalesRegion Type DropDownValues :",  StatusOfSalesRegionTypeDropDown[0].toString(), StatusOfSalesRegionTypeDropDown[1].toString());
				reportInfo("SalesRegion Type DropDown Is Orderd A to Z Correctly In TenantPage");
			}else {
				reportFail("SalesRegion Type DropDownValues Not Ordred",  "Not Ordred",  "Not Ordred");
			}
			testSetup.pageObjectManager.getTenantsPage().scrollToStatus();
			reportInfo(" ");
			
			//statusDropDown in TenantPage
			

			List[] StatusOfStatusDropDown = testSetup.pageObjectManager.getTenantsPage().verifyStatusDropTownOrderINTenant();
			reportInfo("I Verify  StatusDropDown Is Orderd A to Z or Not in TenantPage");
			reportScreenshot(testSetup.driver);
			if( StatusOfStatusDropDown[0].equals(StatusOfStatusDropDown[1])) {
				reportPass("List of SalesRegion Type DropDownValues :",  StatusOfStatusDropDown[0].toString(), StatusOfStatusDropDown[1].toString());
				reportInfo("Status Type DropDown Is Orderd A to Z  Correctly In  TenantPage");
			}else {
				reportFail("status Type DropDownValues Not Ordred",  "Not Ordred",  "Not Ordred");
			}
				
			
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	
	    
	}
	@Then("I Verify if all the drop down values in the application are ordered In License Page {string}")
	public void i_verify_if_all_the_drop_down_values_in_the_application_are_ordered_in_license_page(String string) {
		
	try {
		test = logInfo.get().createNode("I Verify if all the drop down values in the application are ordered In License Page");
		
		//BaseProduct DropDown in Licenses
		
		List[] StatusOfBaseProductDropDown = testSetup.pageObjectManager.getLicensesPage().verifyBaseProductDropDownOrderInLicenses();
		reportInfo("I Verify  BaseProduct DropDown Is Orderd A to Z or Not In Licenses Page");
		reportScreenshot(testSetup.driver);
		if( StatusOfBaseProductDropDown[0].equals(StatusOfBaseProductDropDown[1])) {
			reportPass("List of BaseProduct DropDown :",  StatusOfBaseProductDropDown[0].toString()+"                       ", StatusOfBaseProductDropDown[1].toString());
			reportInfo("BaseProductDropDown Is Orderd A to Z Correctly In Licenses Page");
		}else {
			reportFail("BaseProduct DropDown Not Ordered In License Page",  "Not Ordred",  "Not Ordred");
		
		}
		reportInfo(" ");
		
	//LicenseType DropDown in Licenses
		
		List[] StatusOfLicenseDropDown = testSetup.pageObjectManager.getLicensesPage().verifyLicenseTypeDropDownOrderInLicenses();
		reportInfo("I Verify  LicenseType DropDown Is Orderd A to Z or Not In Licenses Page");
		reportScreenshot(testSetup.driver);
		if( StatusOfLicenseDropDown[0].equals(StatusOfLicenseDropDown[1])) {
			reportPass("List of License Type DropDown :",  StatusOfLicenseDropDown[0].toString(), StatusOfLicenseDropDown[1].toString());
			reportInfo("License Type DropDown Is Orderd A to Z Correctly In Licenses Page");
		}else {
			reportFail("License Type DropDown Not Ordered In License Page",  "Not Ordred",  "Not Ordred");
		
		}
		reportInfo(" ");
		
	
		
		// CharegeTypeDropDwn in Licenses Page
		
		
		List[] StatusOfChargeTypeDropDown = testSetup.pageObjectManager.getLicensesPage().verifyChargeTypeDropDownOrderInLicenses();
		reportInfo("I Verify  ChargeType DropDown Is Orderd A to Z or Not In Licenses Page");
		reportScreenshot(testSetup.driver);
		if( StatusOfChargeTypeDropDown[0].equals(StatusOfChargeTypeDropDown[1])) {
			reportPass("List of ChargeType DropDown :",  StatusOfChargeTypeDropDown[0].toString(), StatusOfChargeTypeDropDown[1].toString());
			reportInfo("ChargeType Is Orderd A to Z Correctly In Licenses Page");
		}else {
			reportFail("ChargeType DropDown Not Ordered In License Page",  "Not Ordred",  "Not Ordred");
			
		
		}
		reportInfo(" ");
		
	
		//Status DropDownIn licenses page
		
		
		List[] StatusOfStatusDropDown = testSetup.pageObjectManager.getLicensesPage().verifyStatusTypeDropDownOrderInLicenses();
		reportInfo("I Verify  status DropDown Is Orderd A to Z or Not In Licenses Page");
		reportScreenshot(testSetup.driver);
		if( StatusOfStatusDropDown[0].equals(StatusOfStatusDropDown[1])) {
			reportPass("List of Status DropDown :",  StatusOfStatusDropDown[0].toString(), StatusOfStatusDropDown[1].toString());
			reportInfo("Status DropDown Is Orderd A to Z Correctly In Licenses Page");
		}else {
			reportFail("Status DropDown Not Ordered In License Page",  "Not Ordred",  "Not Ordred");
		
		}
		reportInfo(" ");
			
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	 
	}
	@Then("I Verify if all the drop down values in the application are ordered In Devices Page {string}")
	public void i_verify_if_all_the_drop_down_values_in_the_application_are_ordered_in_devices_page(String string) {
		
	try {
		test = logInfo.get().createNode("I Verify if all the drop down values in the application are ordered In Devices Page");
	
		//DeviceType DropDown in Devices
		
				List[] StatusOfDeviceDropDown = testSetup.pageObjectManager.getDevicePage().verifyDeviceTypeDropTownOrderINDevices();
				reportInfo("I Verify  DeviceType DropDown Is Orderd A to Z or Not In Devices Page");
				reportScreenshot(testSetup.driver);
				if( StatusOfDeviceDropDown[0].equals(StatusOfDeviceDropDown[1])) {
					reportPass("List of BaseProduct DropDown :",  StatusOfDeviceDropDown[0].toString()+"                       ", StatusOfDeviceDropDown[1].toString());
					reportInfo("DeviceTypeDropDown Is Orderd A to Z Correctly In Devices Page");
				}else {
					reportFail("DeviceType DropDown Not Ordered In Devices Page",  "Not Ordred",  "Not Ordred");
				
				}
			  testSetup.pageObjectManager.getDevicePage().scrollToDeviceStatus();
		reportInfo(" ");
		
		//DeviceStatus1 DropDown in Devices
		
				List[] StatusOfDeviceStatus1DropDown = testSetup.pageObjectManager.getDevicePage().verifyDeviceStatusDropDown_OrderINDevicesINDevices();
				reportInfo("I Verify  Device Status DropDown  Is Orderd A to Z or Not In Devices Page");
				reportScreenshot(testSetup.driver);
				if( StatusOfDeviceStatus1DropDown[0].equals(StatusOfDeviceStatus1DropDown[1])) {
					reportPass("List of BaseProduct DropDown :",  StatusOfDeviceStatus1DropDown[0].toString()+"                       ", StatusOfDeviceStatus1DropDown[1].toString());
					reportInfo("DeviceStatus DropDown Is Orderd A to Z Correctly In Devices Page");
				}else {
					reportFail("DeviceStatus DropDown  Not Ordered In Devices Page",  "Not Ordred",  "Not Ordred");
				
				}
	
	reportInfo(" ");
		
			
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	
	 
	}


	
}
