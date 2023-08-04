package safefleetLM.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class TenantManagerPage extends ReusableLibrary{

	WebDriver driver;

	public TenantManagerPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//--------------------------------Nitin--------------------------------------------------------//
		@FindBy(xpath = "(//input)[1]")
		WebElement tenantIDTextBox;
		
		@FindBy(xpath="//td[text()='123']")
		WebElement firstSearch;
	//-----------------------------------Nitin-----------------------------------------------------//
	
	
	//-----------------------------------Nitin-----------------------------------------------------//
		public void enterTenantIDTextBox(Map<String, String> testData) throws InterruptedException
		{
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID"));
		}
		
		public boolean verifyTenantIDInTenantManager(Map<String, String> testData)
		{
			String text = firstSearch.getText();
			if(text.contains(testData.get("TenantID")))
			{
				return true;
			}
			return false;
		}
	//-----------------------------------Nitin-----------------------------------------------------//
	
}
