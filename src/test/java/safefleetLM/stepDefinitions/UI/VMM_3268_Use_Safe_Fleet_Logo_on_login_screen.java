package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3268_Use_Safe_Fleet_Logo_on_login_screen extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_3268_Use_Safe_Fleet_Logo_on_login_screen(TestSetup testSetup) throws IOException { 
		this.testSetup=testSetup;
	}
	


@Then("I Verify if the License Management logo is there in the license manager")
public void i_verify_if_the_license_management_logo_is_there_in_the_license_manager() throws Exception { 
	try {
	 test = logInfo.get().createNode("I Verify if the License Management logo is there in the license manager");
	 test.assignCategory("Others");
	 String status=testSetup.pageObjectManager.getHomePage().verifyLMLogo();
	if(status.equals("true"))
	 {
		
		reportPass("LM Logo Displayed successfully", "true",  testSetup.pageObjectManager.getHomePage().verifyLMLogo()); 
		 reportScreenshot(testSetup.driver);
		reportInfo("Logo verified successfully");
		
	 }
	 else
	 {
		
		reportFail("LM Logo not Displayed", "true",  testSetup.pageObjectManager.getHomePage().verifyLMLogo());
		 reportScreenshot(testSetup.driver);
		reportInfo("Logo  not verified successfully");
	 }
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
	
}

@Then("I Click on the logout")
public void i_click_on_the_logout() throws InterruptedException {
	try {
	 test = logInfo.get().createNode("I Click on the logout");
	 testSetup.pageObjectManager.getLandingPage().logoutUser();
	 reportInfo("Logout successfully");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}
@Then("I verify that it takes  back to the login page")
public void i_verify_that_it_takes_back_to_the_login_page() throws IOException {
	try {
	 test = logInfo.get().createNode("I verify that it takes  back to the login page");
	 reportScreenshot(testSetup.driver);
	 reportInfo("It takes back to the   login page successfully");
   
}
catch (Exception e) {
	testStepHandle("FAIL", testSetup.driver, test, e);
}


	
}
}
