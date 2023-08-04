package safefleetLM.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class ServersPage extends ReusableLibrary
{
	WebDriver driver;

	public ServersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//button[@id='newserver']")
	WebElement createNewTenantBtn;

	@FindBy(xpath="//input[@name='name']")
	WebElement nameTextBox;

	@FindBy(xpath="//input[@type='url']")
	WebElement urlTextBox;

	@FindBy(xpath="//select[@id='field_deploymentType']")
	WebElement DiploymentTypeTextBox;

	@FindBy(xpath="//button[@id='savebutton']")
	WebElement saveButton;

	@FindBy(xpath = "//pre[@class='ng-binding ng-scope']")
	WebElement AlertMessage;

	@FindBy(xpath="//span[contains(text(),'Show Filters')]")
	WebElement ShowFilterBtn;

	@FindBy(xpath="(//div[@class='form-group'])[1]/select")
	WebElement filterTypeDropdown;

	@FindBy(xpath="(//div[@class='form-group'])[2]/select")
	WebElement EqualsFilterDropdown;

	@FindBy(xpath="//input[@type='text']")
	WebElement FilterValue;

	@FindBy(xpath="(//span[text()='Filter'])[2]")
	WebElement FilterBtn;

	@FindBy(xpath="(//option[@label='equals'])[1]")
	WebElement equalsOption;

	@FindBy(xpath="//i[text()='edit']")
	WebElement EditBtn;

	@FindBy(xpath="//i[text()='visibility']")
	WebElement ViewBtn;

	@FindBy(xpath="//i[text()='delete']")
	WebElement DeleteBtn;

	@FindBy(xpath="//div[@class='modal-footer']//span[text()='Delete']")
	WebElement DeleteConfirmBtn;

	@FindBy(xpath="(//span[text()='IP Address']/../..//span)[2]")
	WebElement IpAddress;

	@FindBy(xpath="//span[text()='Back']")
	WebElement BackBtn;

	public String createServerWithoutIpAdress(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenSendkeys(nameTextBox, testData.get("Name"));

		waitForElementToBeClickableThenSendkeys(urlTextBox, testData.get("Url"));
		//sleepMin();

		selectListByVisibleText(DiploymentTypeTextBox, testData.get("Deployment Type"));

		sleepMin();

		waitForElementToBeClickableThenClick(saveButton);

		String msg = AlertMessage.getText();

		return msg;

	}

	public void searchServer(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(ShowFilterBtn);
		//sleepMin();
		selectListByVisibleText(filterTypeDropdown, testData.get("FilterType"));
		//selectListByVisibleText(EqualsFilterDropdown, testData.get("EqualDropdown"));
		//waitForElementToBeClickableThenSendkeys(EqualsFilterDropdown, testData.get("Name"));
		waitForElementToBeClickableThenClick(equalsOption);

		waitForElementToBeClickableThenSendkeys(FilterValue, testData.get("Name"));

		waitForElementToBeClickableThenClick(FilterBtn);
		waitForAngularRequestsToFinish();
		sleepMin();
	}

	public String editServer(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(EditBtn);

		sleepAvg();

		waitForElementToBeClickableThenClearThenSendkeys(nameTextBox, testData.get("EditName"));

		//waitForElementToBeClickableThenClearThenSendkeys(urlTextBox, testData.get("EditedUrl"));

		sleepMin();

		waitForElementToBeClickableThenClick(saveButton);

		String msg = AlertMessage.getText();

		return msg;
	}

	public String validateIpAddress(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(ViewBtn);

		String ipAdress = IpAddress.getText();

		boolean Status = ipAdress.isEmpty();

		sleepMin();

		System.out.println("IP Adress is : "+ipAdress.isEmpty());

			return ipAdress;
	}


	public void cancelButton(){

		waitForElementToBeClickableThenClick(BackBtn);
	}

	public String deleteUpdatedServer(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(DeleteBtn);

		sleepMin();

		waitForElementToBeClickableThenClick(DeleteConfirmBtn);

		String msg = AlertMessage.getText();

		return msg;
	}

	public void searchEditedServer(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(ShowFilterBtn);
		//sleepMin();
		selectListByVisibleText(filterTypeDropdown, testData.get("FilterType"));
		//selectListByVisibleText(EqualsFilterDropdown, testData.get("EqualDropdown"));
		//waitForElementToBeClickableThenSendkeys(EqualsFilterDropdown, testData.get("Name"));
		waitForElementToBeClickableThenClick(equalsOption);

		waitForElementToBeClickableThenSendkeys(FilterValue, testData.get("EditName"));

		waitForElementToBeClickableThenClick(FilterBtn);
		waitForAngularRequestsToFinish();
		sleepMin();
	}


}
