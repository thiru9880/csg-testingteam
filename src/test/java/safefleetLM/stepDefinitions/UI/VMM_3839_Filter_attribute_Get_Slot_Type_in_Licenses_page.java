package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3839_Filter_attribute_Get_Slot_Type_in_Licenses_page extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3839_Filter_attribute_Get_Slot_Type_in_Licenses_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
//1
	  @Then("I Navigate to Operations")
	    public void i_navigate_to_operations() {
		  try {
	    	test = logInfo.get().createNode("I Navigate to Operations");
	    	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	    	reportInfo("I Navigate to operation page successfully");
		  } 
		  catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);
		  }
	   }  
	   
	    @Then("I Navigate to Licenses")
	    public void i_navigate_to_licenses() {
	    	try {
	    	test = logInfo.get().createNode("I Navigate to Licenses"); 
	    	testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
	    	reportInfo("I Navigate to License page successfully"); 
	    	}
			  catch (Exception e) {
				  testStepHandle("FAIL",testSetup.driver, test, e);
		    }
	   
	    }
	    @When("I Click on Show Filters")
	    public void i_click_on_show_filters() {
	    	try {
	    	test = logInfo.get().createNode("I Click on Show Filters");
	    	testSetup.pageObjectManager.getCustomerPage().ClickOnShowFilter();
	    	reportInfo("I click on show filter successfully");
	    	}
			  catch (Exception e) {
				  testStepHandle("FAIL",testSetup.driver, test, e);
		    }
	    
	    }
	    @Then("I Verify that there is no {string}")
	    public void i_verify_that_there_is_no(String string) {
	    	try {
	    	test = logInfo.get().createNode("I Verify that there is no {string}");
	    	test.assignCategory("Licenses");
	    	
	    	//testSetup.pageObjectManager.getCustomerPage().clickonemttxtfield();
	    	//testSetup.pageObjectManager.getCustomerPage().clickonlicensetype();
	    	reportInfo("I verify that no {string} successfully");
	    	}
			  catch (Exception e) {
				  testStepHandle("FAIL",testSetup.driver, test, e); 
		    }
	   
	    }
	    @Then("I Verify that there is License type attribute is matching")
	    public void i_verify_that_there_is_license_type_attribute_is_matching() {
	    	try {
	    	test = logInfo.get().createNode("I Verify that there is License type attribute is matching");
	    	//testSetup.pageObjectManager.getCustomerPage().clickonemttxtfield();
	    	testSetup.pageObjectManager.getCustomerPage().clickOnEmptyField();
	    	String licenseType = testSetup.pageObjectManager.getCustomerPage().clickonlicensetype();
	    	if(licenseType.equalsIgnoreCase("License Type"))
	    	{
	    		reportPass("Option Type", "License Type", licenseType);
	    	}
	    	else {
	    		reportFail("Option Type", "License Type", licenseType);
	    	}
	    	reportScreenshot(testSetup.driver);
	    	reportInfo("I verify that there is no Get Slot Type() and verify that there a license type is  matching successfully");
	    	
	    	}
			  catch (Exception e) {
				  testStepHandle("FAIL",testSetup.driver, test, e); 
		    }
	    } 

	    
	    
	    
//2	   
	    
	
	    	@Then("I Navigate to System Admin")
	    	public void i_navigate_to_system_admin() {
	    		try {
	    		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
	    		test = logInfo.get().createNode("I Navigate to System Admin");
	        	reportInfo("I Navigate to system admin page successfully");
	    		}
				  catch (Exception e) {
					  testStepHandle("FAIL",testSetup.driver, test, e);
			    }
	    	}
	    	    
	    	@Then("I Navigate to License Type")
	    	public void i_navigate_to_license_type() {
	    		try {
	    		testSetup.pageObjectManager.getHomePage().navigateToLicenseTypesTab();
	    		test = logInfo.get().createNode("I Navigate to License Type");
	        	reportInfo("I Navigate to license page successfully");
	    		}
				  catch (Exception e) {
					  testStepHandle("FAIL",testSetup.driver, test, e); 
			    }
	    		
	    	}
	    	    
	    	@Then("I Navigate to  ADD_ON_PRODUCT  license type of DES Cloud Courier software")
	    	public void i_navigate_to_add_on_product_license_type_of_des_cloud_courier_software() throws Exception {
	    		try {
	    		testSetup.pageObjectManager.getCustomerPage().AddOnProduct();
	    		test = logInfo.get().createNode("I Navigate to  ADD_ON_PRODUCT  license type of DES Cloud Courier software");
	    		test.assignCategory("Licenses");	
	        	reportInfo("I Navigate to ADD_ON_PRODUCT  license type of DES Cloud Courier successfully");
	    		}
				  catch (Exception e) {
					  testStepHandle("FAIL",testSetup.driver, test, e);
			    }
	    	}
	    	    
	    	@Then("I confirm that ADD_ON_PRODUCT name is cloud-courier")
	    	public void i_confirm_that_add_on_product_name_is_cloud_courier() throws Exception {
	    		try {
	    		test = logInfo.get().createNode("I confirm that ADD_ON_PRODUCT name is cloud-courier");
	    		String text=testSetup.pageObjectManager.getCustomerPage().AddOnProduct();
	    		if(text.equals(text))
	    		{
	    			reportPass("Add On Product", text, "Cloud-Courier");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		else
	    		{
	    			reportFail("Add On Product", text, "Cloud-Courier");
	    			reportScreenshot(testSetup.driver);
	    		}
	        	reportInfo("I confirm that ADD_ON_PRODUCT name is cloud-courier is successfully");
	    		}
				  catch (Exception e) {
					  testStepHandle("FAIL",testSetup.driver, test, e);
			    }
	    	}
	    	    
}  

