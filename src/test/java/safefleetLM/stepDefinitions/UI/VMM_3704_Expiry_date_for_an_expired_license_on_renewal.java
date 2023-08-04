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

public class VMM_3704_Expiry_date_for_an_expired_license_on_renewal extends BaseTest {
		
	TestSetup testSetup;
	public static String expiryDate=null;
	public static String expExpiryDate=null;
    
	public VMM_3704_Expiry_date_for_an_expired_license_on_renewal(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
		
	}
	@Then("I click on Licenses showfilter to get the expired licenses {string}")
	public void i_click_on_Licenses_showfilter_to_get_the_expired_licenses(String tcid) {
		try {
			test = logInfo.get().createNode("I click on Licenses showfilter to get the expired licenses");
			test.assignCategory("Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			//testSetup.pageObjectManager.getLicensesPage().SearchExpiredLicenses();
			testSetup.pageObjectManager.getLicensesPage().filterExpiredLicenseWithMultiConditions(testData);
			reportScreenshot(testSetup.driver); 
			expiryDate =testSetup.pageObjectManager.getLicensesPage().VerifyLicenseexpirydateTxtBx();
			System.out.println("Expired Date: "+ expiryDate);
			reportScreenshot(testSetup.driver); 
			
			reportInfo("I get expired licenses successfully");    
		} 
		catch (Exception e)  
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e);  
		} 
		
	}
	@Then("I do not change license expiration date on the Renew license page and I Verify that the license expiry date on the license page is same as the expiry date on renew page {string}")
	public void i_do_not_change_the_license_expiry_date_on_the_renew_license_page_and_i_Verify_that_license_expiry_date_on_the_license_page_is_same_as_the_Renew_license_page (String tcid) {
		try {
			test = logInfo.get().createNode("I do not change license expiration date on the Renew license page and I Verify that the license expiry date on the license page is same as the expiry date on renew page");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().Partvalue(testData);
			reportScreenshot(testSetup.driver);  
			expExpiryDate=testSetup.pageObjectManager.getLicensesPage().VerifyLicenseexpirydate();
			
			testSetup.pageObjectManager.getLicensesPage().Renewcancel();
			reportScreenshot(testSetup.driver); 
			String actExpiryDate=expiryDate.split("-")[1]+"/"+expiryDate.split("-")[2]+"/"+expiryDate.split("-")[0];
			   
			if(expExpiryDate.equals(actExpiryDate)) 
			{
				reportPass("Expiry Date", expExpiryDate, actExpiryDate);	
			}
			else
			{
				reportFail("Expiry Date Not Match", expExpiryDate, actExpiryDate);
			}
		} 
		catch (Exception e)  
		{  
			testStepHandle("FAIL", testSetup.driver, test, e); 
		} 
	}
} 