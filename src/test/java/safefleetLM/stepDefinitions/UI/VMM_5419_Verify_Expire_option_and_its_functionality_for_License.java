package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.*;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class VMM_5419_Verify_Expire_option_and_its_functionality_for_License extends BaseTest{
  private static final String String = null;
  TestSetup testSetup;
  Response response = null;
  public static String resString=null;
    public static RequestSpecification req = null;
  public static ResponseSpecification res = null;

  public VMM_5419_Verify_Expire_option_and_its_functionality_for_License(TestSetup testSetup) throws IOException {
    this.testSetup=testSetup;
  }

  @Then("I verify EXPIRE option is not enabled for Draft license")
  public void i_verify_expire_option_is_not_enabled() {
   try {
      test = logInfo.get().createNode("I verify EXPIRE option is not enabled for Draft license");
     testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();
      String result = testSetup.pageObjectManager.getLicensesPage().verifyExpireOptionEnabledOrDisabled();
     testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();
      reportScreenshot(testSetup.driver);
      if(result.equals("true")) {
        reportPass("EXPIRE option", "EXPIRE option should be disabled for Draft license", "EXPIRE option is disabled for Draft license");
      }
      else {
        reportFail("EXPIRE option", "EXPIRE option should be disabled for Draft license", "EXPIRE option is not disabled for Draft license");
      }
    } catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I verify EXPIRE option is enabled for Published license")
  public void i_verify_expire_option_is_enabled() {
    try {
      test = logInfo.get().createNode("I verify EXPIRE option is enabled for Published license");

      testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();
      String result = testSetup.pageObjectManager.getLicensesPage().verifyExpireOptionEnabledOrDisabled();
      reportScreenshot(testSetup.driver);
      if(result.equals("false")) {
        reportPass("EXPIRE option", "EXPIRE option should be enabled for Published license", "EXPIRE option is enabled for Published license");
      }
      else {
        reportFail("EXPIRE option", "EXPIRE option should be enabled for Published license", "EXPIRE option is not enabled for Published license");
      }
    } catch(Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

@Then("I expire APP license with test data")
public void i_expire_app_license_with_test_data() {

  try {
    test = logInfo.get().createNode("I expire APP license with test data");
    testSetup.pageObjectManager.getLicensesPage().expireLicense();
    reportInfo("Expired APP license ");
    reportScreenshot(testSetup.driver);
    testSetup.pageObjectManager.getLicensesPage().clickPublishOK();


  } catch(Exception e) {
    testStepHandle("FAIL", testSetup.driver, test, e);
  }
}



}
