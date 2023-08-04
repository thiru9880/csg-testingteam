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

public class VMM_3846_Filter_issues_in_the_Licenses_page extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3846_Filter_issues_in_the_Licenses_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


@Then("I Verify that the Deployment Type filter CLOUD_COMMERCIAL working correctly with testdata {string}")
public void i_verify_that_the_deployment_type_filter_CLOUD_COMMERCIAL_working_correctly_with_testdata(String string) { 
	
	try {
		test = logInfo.get().createNode("I Verify that the Deployment Type filter,CLOUD_COMMERCIAL with equals working correctly with testdata");
		test.assignCategory("Licenses");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3846_1");
		testSetup.pageObjectManager.getLicensesPage().cloudCommercialwithequals(testData); 
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		System.out.println(text);
		if (text.equalsIgnoreCase("CLOUD_COMMERCIAL")) {
			
			reportPass("Text", "CLOUD_COMMERCIAL", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with equals filter working correctly");
			
		}
		else {
			reportFail("Text", "CLOUD_COMMERCIAL", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with equals filter not working correctly");
			
			
			
		}
		
		test = logInfo.get().createNode("I Verify that the Deployment Type filter, CLOUD_COMMERCIAL with notequal working correctly with testdata");
		testSetup.pageObjectManager.getLicensesPage().deploymentTypefilternotequal(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text1 = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		System.out.println(text1);
		if (text1!=("CLOUD_COMMERCIAL")) {
			
			reportPass("Text", "CLOUD_COMMERCIAL", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with not equal filter working correctly");
			
			
		} else {
			reportFail("Text", "CLOUD_COMMERCIAL", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with not equal filter not working correctly");
			

		}
		
		test = logInfo.get().createNode("I Verify that the Deployment Type filter, CLOUD_COMMERCIAL with contains working correctly with testdata");
		testSetup.pageObjectManager.getLicensesPage().deploymentTypefiltercontains(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text2 = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		System.out.println(text2);
		if (text2.contains("CLOUD_COMMERCIAL")) {
			
			reportPass("Text", "CLOUD_COMMERCIAL", text2);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with contains filter working correctly");
			
			
		} else {
			reportFail("Text", "CLOUD_COMMERCIAL", text2);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the CLOUD_COMMERCIAL  with contains filter not working correctly");
			

		}
		
	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
	
	
}
@When("I Verify that the Deployment Type filter ONSITE working correctly with testdata {string}")
public void i_verify_that_the_deployment_type_filter_onsite_working_correctly_with_testdata(String string) {
	try {
		test = logInfo.get().createNode("I Verify that the Deployment Type filter, ONSITE with equals working correctly with testdata");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3846_2");
		
		testSetup.pageObjectManager.getLicensesPage().onsitewithequals(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		
		if (text.equals("ONSITE")) {
			
			reportPass("Text", "ONSITE", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with equals filter working correctly");
			
		}
		else {
			reportFail("Text", "ONSITE", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with equals filter not working correctly");
			
			
			
		}
		
		test = logInfo.get().createNode("I Verify that the Deployment Type filter, ONSITE with notequal working correctly with testdata");
		testSetup.pageObjectManager.getLicensesPage().deploymentTypefilternotequal(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text1 = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		if (text1!=("ONSITE")) {
			reportPass("Text", "ONSITE", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with not equal filter working correctly");
			
			
		} else {
			reportFail("Text", "ONSITE", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with not equal filter not working correctly");
			

		}
		
		test = logInfo.get().createNode("I Verify that the Deployment Type filter, ONSITE with contains working correctly with testdata");
		testSetup.pageObjectManager.getLicensesPage().onsitewithcontains(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltodeploymenttype();
		String text2 = testSetup.pageObjectManager.getLicensesPage().verifyfilter();
		if (text2.contains("ONSITE")) {
			reportPass("Text", "ONSITE", text2);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with contains filter working correctly");
			
			
		} else {
			reportFail("Text", "ONSITE", text2);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that the ONSITE  with contains filter not working correctly");
			

		}
		
	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
   
}


@Then("I Verify that the License Type filter with Base Product working correctly with testdata {string}") 
public void i_verify_that_the_license_type_filter_with_base_product_working_correctly_with_testdata(String string) {
	
	try {
		test = logInfo.get().createNode("I Verify that the License Type filter with Base Product working correctly with testdata");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3846_3");
		
		testSetup.pageObjectManager.getLicensesPage().licensetypewithequals(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltolicensetype();
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that the BASE_PRODUCT with equals, License Type filter working correctly");
		
		testSetup.pageObjectManager.getLicensesPage().licensetypewithnotequals(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltolicensetype();
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that the BASE_PRODUCT with not equal, License Type filter working correctly");
		
		
		
	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}



@Then("I Verify that the License Type filter with ASSET working correctly with testdata {string}")
public void i_verify_that_the_license_type_filter_with_ASSET_working_correctly_with_testdata(String string) {
	try {
		test = logInfo.get().createNode("I Verify that the License Type filter with ASSET working correctly with testdata");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", "VMM_3846_4");
		
		testSetup.pageObjectManager.getLicensesPage().licensetypewithequals(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltolicensetype();
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that the BASE_PRODUCT with equals, License Type filter working correctly");
		
		testSetup.pageObjectManager.getLicensesPage().licensetypewithnotequals(testData);
		testSetup.pageObjectManager.getLicensesPage().scrolltolicensetype();
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that the BASE_PRODUCT with not equal, License Type filter working correctly");
		
		
		
	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
   
}
	
	
}
