package safefleetLM.testcomponents;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Listeners extends BaseTest implements ITestListener{
	
	public Listeners() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static ExtentReports extent;

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {

		
		System.out.println(scenarioName +" : PASS");
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", scenarioName, rowcount, 1);
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", "PASS", rowcount, 2);
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", getTimeStamp(), rowcount, 3);
	    //rowcount++;

		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(scenarioName +" : FAIL");
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", scenarioName, rowcount, 1);
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", "FAIL", rowcount, 2);
	    //ReadXL.writeCell(System.getProperty("user.dir")+"\\ResultsSummary.xlsx", "TESTRESULTS", getTimeStamp(), rowcount, 3);
	    //rowcount++;
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution started ...");
		try {
			extent= setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Execution completed ...");
		extent.flush();	
		getCustomJsonReport();
		System.out.println("Generated Report. . .");	
		//System.out.println("Toal : "+extent.getStats().getParentCount()+" Pass : "+extent.getStats().getParentCountPass()+" Fail : "+extent.getStats().getParentCountFail()+" Skip : "+extent.getStats().getParentCountSkip());
	}
	

}
