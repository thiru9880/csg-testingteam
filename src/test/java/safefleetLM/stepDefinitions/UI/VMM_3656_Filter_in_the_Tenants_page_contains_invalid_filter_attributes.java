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

public class VMM_3656_Filter_in_the_Tenants_page_contains_invalid_filter_attributes extends BaseTest {

	TestSetup testSetup;

	public VMM_3656_Filter_in_the_Tenants_page_contains_invalid_filter_attributes(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Then("I click on show filter and Expand the filter parameter drop down")
	public void i_click_on_show_filter_and_expand_the_filter_parameter_drop_down() {
		try {
			test = logInfo.get().createNode("I click on show filter and Expand the filter parameter drop down");
			test.assignCategory("Tenants");
			testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
			reportInfo("I click on show filter Successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify that the Tenant filter attribute match with column names in tenant table")
	public void i_verify_that_the_drop_down_not_have_invalid_filter_attributes() {
		try {
			test = logInfo.get().createNode("I verify that the Tenant filter attribute match with column names in tenant table");
			//1
			testSetup.pageObjectManager.getTenantsPage().TenantFilter();
			reportScreenshot(testSetup.driver);

			reportInfo("I Verify Tenant Id Attribute In TenantPage Filter");
			String TenantidRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyTenantRow();
			String Tenantidfilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyTenantIDFilterDropDown();

			if(TenantidRowstatus.contains(Tenantidfilterdropdownsts))
			{
				reportPass("I Verify Filter Attributes In Tenant Page", TenantidRowstatus, Tenantidfilterdropdownsts);
				reportInfo("I verify Tenant ID Attribute successfully");
			}
			else {
				reportFail("I Verify Tenant Id Attribute", TenantidRowstatus, Tenantidfilterdropdownsts);
				reportInfo("I verify Tenant ID invalid filter Attribute successfully");

			}

			 //2

			//testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
			testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
			testSetup.pageObjectManager.getTenantsPage().TenantTypeFilter();
			reportScreenshot(testSetup.driver);

			reportInfo("I Verify Tenant TYpe Attribute In TenantPage Filter");
			String TenanttypeRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyTenantTypeRow();
			String Tenanttypefilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyTenantTypeFilterDropDown();

			if(TenanttypeRowstatus.contains(Tenanttypefilterdropdownsts))
			{
				reportPass("I Verify Filter Attributes In Tenant Page", TenanttypeRowstatus, Tenanttypefilterdropdownsts);
				reportInfo("I verify Tenant type Attribute successfully");
			}
			else {
				reportFail("I Verify Tenant TYpe Attribute", TenanttypeRowstatus, Tenanttypefilterdropdownsts);
				reportInfo("I verify Tenant type invalid filter Attribute successfully");

			}

		      //3

	      // testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().SalesRegionFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify Sales Region Attribute In TenantPage Filter");
		   String SalesRegionRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyeSalesRegionRow();
		   String Salesregionfilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifySalesRegionFilterDropDown();

	       if(SalesRegionRowstatus.contains(Salesregionfilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", SalesRegionRowstatus, Salesregionfilterdropdownsts);
		   reportInfo("I verify Sales region Attribute successfully");
		   }
		   else {
		   reportFail("I Verify Tenant TYpe Attribute", SalesRegionRowstatus, Salesregionfilterdropdownsts);
	       reportInfo("I verify Sales region invalid filter Attribute successfully");
		   }


			//4
		   //testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().StateFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify State Attribute In TenantPage Filter");
		   String StateRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyeStateRow();
		   String Statefilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyStateFilterDropDown();

	       if(StateRowstatus.contains(Statefilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", StateRowstatus, Statefilterdropdownsts);
		   reportInfo("I verify State Attribute successfully");
		   }
		   else {
		   reportFail("I Verify State Attribute", StateRowstatus, Statefilterdropdownsts);
	       reportInfo("I verify State invalid filter Attribute successfully");
		   }


		   //5
	      // testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().CustomerFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify Customer Attribute In TenantPage Filter");
		   String CustomerRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyCustomerRow();
		   String Customerfilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyCustomerFilterDropDown();

	       if(CustomerRowstatus.contains(Customerfilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", CustomerRowstatus, Customerfilterdropdownsts);
		   reportInfo("I verify Customer Attribute successfully");
		   }
		   else {
		   reportFail("I Verify Customer Attribute", CustomerRowstatus, Customerfilterdropdownsts);
	       reportInfo("I verify Customer invalid filter Attribute successfully");
		   }


	       //6
	      // testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().deploymenttypeFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify Deployment type Attribute In TenantPage Filter");
		   String DeploymenttypeRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifydeploymenttypeRow();
		   String Deploymenttypefilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifydeploymenttypeFilterDropDown();

	       if(DeploymenttypeRowstatus.contains(Deploymenttypefilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", DeploymenttypeRowstatus, Deploymenttypefilterdropdownsts);
		   reportInfo("I verify Deploymenttype Attribute successfully");
		   }
		   else {
		   reportFail("I Verify Deploymenttype Attribute", DeploymenttypeRowstatus, Deploymenttypefilterdropdownsts);
	       reportInfo("I verify Deploymenttype invalid filter Attribute successfully");
		   }


	       //7
	     //  testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().AnniversaryDateFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify AnniversaryDate Attribute In TenantPage Filter");
		   String AnniversaryRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyAnniversaryDateRow();
		   String Anniversaryfilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyAnniversarDateyFilterDropDown();

	       if(AnniversaryRowstatus.contains(Anniversaryfilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", AnniversaryRowstatus, Anniversaryfilterdropdownsts);
		   reportInfo("I verify AnniversaryDate Attribute successfully");
		   }
		   else {
		   reportFail("I Verify AnniversaryDate Attribute", AnniversaryRowstatus, Anniversaryfilterdropdownsts);
	       reportInfo("I verify AnniversaryDate invalid filter Attribute successfully");
		   }

	       //8
	      // testSetup.pageObjectManager.getTenantsPage().RefreshTenantPage();
		   //testSetup.pageObjectManager.getTenantsPage().clickOnTenantShowfilter();
		   testSetup.pageObjectManager.getTenantsPage().StatusFilter();
		   reportScreenshot(testSetup.driver);

		   reportInfo("I Verify Status Attribute In TenantPage Filter");
		   String StatusRowstatus = testSetup.pageObjectManager.getTenantsPage().VerifyStatusDateRow();
		   String Statusfilterdropdownsts = testSetup.pageObjectManager.getTenantsPage().VerifyStatusFilterDropDown();

	       if(StatusRowstatus.equals(Statusfilterdropdownsts))
		   {
		   reportPass("I Verify Filter Attributes In Tenant Page", StatusRowstatus, Statusfilterdropdownsts);
		   reportInfo("I verify Status Attribute successfully");
		   }
		   else {
		   reportFail("I Verify Status Attribute", StatusRowstatus, Statusfilterdropdownsts);
	       reportInfo("I verify Status invalid filter Attribute successfully");
		   }

		   }
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
}




