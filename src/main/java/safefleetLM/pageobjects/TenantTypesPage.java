package safefleetLM.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class TenantTypesPage extends ReusableLibrary
{
WebDriver driver;
	
	public TenantTypesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Commercial']")
	WebElement TenantType;
	
	public boolean verifyCommercialVehicle(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		String ExpectedTenantType = testData.get("VerifyTypes");
		
		String Ac1=driver.findElement(By.xpath("//td[text()='"+testData.get("VerifyTypes")+"']")).getText();
		
		String Ac = TenantType.getText();
		
		if(Ac1.equalsIgnoreCase(ExpectedTenantType))
		{
			return true;
		}
		else {
			return false;
		}
	}
}
