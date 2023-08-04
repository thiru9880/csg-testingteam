package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3918AddTenantNameInTenantCreation extends BaseTest {
	
	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3918AddTenantNameInTenantCreation(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify tenant name feild in tenant creation tab")
	public void i_verify_tenant_name_feild_in_tenant_creation_tab() throws IOException, InterruptedException {
try {
	test = logInfo.get().createNode("I verify tenant name feild in tenant creation tab");
	
	test.assignCategory("Tenants");
	
    testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
    
    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
    
    testSetup.pageObjectManager.getTenantsPage().verifyTenantPageFeild();
    
    reportInfo("Verified mandetory Tenant name feild in tenant creation tab");
    
    reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	    
	}

	@Then("I create new tenant for VMM3918 with test data {string}")
	public void i_create_new_tenant_for_vmm3918_with_test_data(String tcid) throws Exception {
try {
    String tenantID=randomStringGenerator();

		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3918_1");
	        
	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3918_1");
	      
	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3918_1");
//
//	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetApplication","TenantID",tenantID,"VMM-3870");
//	      
       UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3918_1");
	      
	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM-3918_1");

	      
	        		
		test = logInfo.get().createNode("I create new tenant with test data");
		    
		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		    
		    testSetup.pageObjectManager.getTenantsPage().createNewTenantWithAdminMail2(testData);
		    
		    reportInfo("New tenant is created with test data ");
		    
		    reportInfo("Test data "+testData);
		    
		    reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}

	}

	@Then("I verify created tenant in tenant page with test data {string}")
	public void i_verify_created_tenant_in_tenant_page_with_test_data(String tcid) throws Exception {
try {		
	test = logInfo.get().createNode("I verify created tenant in tenant page");

Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

testSetup.pageObjectManager.getTenantsPage().filterTenant(testData.get("TenantID"));

testSetup.pageObjectManager.getTenantsPage().eyeViewTenant(tcid);

reportInfo("I verify tenant name feild of created tenant in eye button");

reportScreenshot(testSetup.driver);
			
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}

	}

}
