package safefleetLM.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import safefleetLM.componentgroups.ReusableLibrary;

public class UserPage extends ReusableLibrary{
		
		WebDriver driver;
		
		public UserPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(id="userspage")
		WebElement newUserButton;
		
		@FindBy(xpath = "//input[@name='login']")
		WebElement loginInputText;
		
		@FindBy(xpath = "//input[@name='firstName']")
		WebElement firstNameInputText;
		
		@FindBy(xpath = "//input[@name='lastName']")
		WebElement lastNameInputText;
		
		@FindBy(xpath = "//label[normalize-space()='Activated']/following-sibling::div/label")
		WebElement activatedcheckBox;
		
		@FindBy(xpath = "//label[normalize-space()='System Admin Role']/following-sibling::div/label")
		WebElement systemAdminRoleCheckBox;

		@FindBy(xpath = "//label[normalize-space()='Operations Admin Role']/following-sibling::div/label")
		WebElement operationAdminRoleCheckBox;
		
		@FindBy(xpath = "//label[normalize-space()='Customer']/following-sibling::div/label")
		WebElement customerCheckBox;
		
		@FindBy(xpath = "//label[normalize-space()='Operations Role']/following-sibling::div/label")
		WebElement operationRoleCheckBox;
		
		@FindBy(xpath = "//label[normalize-space()='Sales Role']/following-sibling::div/label")
		WebElement salesRoleCheckBox;
		
		@FindBy(xpath = "//button[@id='savebtn']")
		WebElement saveButton;

		@FindBy(xpath = "//button[@class='btn btnShowFilterGroups btn-info btn-raised']")
		WebElement showFilterButton;
		
		@FindBy(xpath = "//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
		WebElement searchFieldSelect;
		
		@FindBy(xpath = "//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
		WebElement searchFieldSelectEmpty;
		
		@FindBy(xpath = "//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
		WebElement searchConditionSelect;
		
		@FindBy(xpath = "//input[@type='text']")
		WebElement searchValueInputText;
		
		@FindBy(xpath = "//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
		WebElement filterButton;
		
		
		@FindBy(xpath = "(//table[@class='table']/tbody/tr/td)[1]")
		WebElement resultTableLogin;
		
		@FindBy(xpath = "(//table[@class='table']/tbody/tr/td)[6]//button[@id='dltbtn']")
		WebElement resultTableDelete;
		
		
		@FindBy(xpath = "//form[@name='deleteForm']/div/p")
		WebElement deleteConfirmText;
		
		@FindBy(xpath = "//button[@id='deluser']")
		WebElement delUserButton;
		
		@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
		WebElement alert;
		
		@FindBy(xpath="//div[@id='mm-0']/div[2]/form/div[2]/jh-alert-error/div/div/div/div/pre")
		WebElement alerterror;

		//Bhanu
		@FindBy(xpath="//i[text()='edit']")
		WebElement editButton;
		
		@FindBy(xpath="//pre[contains(text(),'An user is updated with identifier')]")
		WebElement updateAlert;
		
		@FindBy(xpath="//i[text()='visibility']")
		WebElement viewButton;
		
		@FindBy(xpath="//span[text()='Login']/../../td[2]/span")
		WebElement loginValue;
		
		@FindBy(xpath="//span[text()='First Name']/../../td[2]/span")
		WebElement firstNameValue;

		
//-----------------Sunilkumar(VMM3582)-------------------------
		@FindBy(xpath="(//input[@aria-label='Select box'])[1]")
		WebElement tenanttextfield;
		
		@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
		WebElement selecttenant;
		
		
		@FindBy(xpath="(//div[@class='ng-binding ng-scope'])[1]")
		WebElement filterfield;
		
		@FindBy(xpath="//span[@class='close ui-select-match-close']")
		WebElement removetenant;
		
		@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
		WebElement usercreatepopup;
		
		//sav
		@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
		WebElement selectTenant;
		
		public String createNewUser(Map<String, String> td) throws InterruptedException {
			String msg;
			waitForElementToBeClickableThenClick(newUserButton);
			waitForElementToBeClickableThenSendkeys(loginInputText,td.get("LOGIN"));
			waitForElementToBeClickableThenSendkeys(firstNameInputText,td.get("FIRSTNAME"));
			waitForElementToBeClickableThenSendkeys(lastNameInputText,td.get("LASTNAME"));
			
			if(td.get("ACTIVATED").equalsIgnoreCase("no"))
				waitForElementToBeClickableThenClick(activatedcheckBox);
			
			if(td.get("SYSTEMADMINROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(systemAdminRoleCheckBox);
			
			if(td.get("OPERATIONSADMINROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(operationAdminRoleCheckBox);
			
			if(td.get("OPEARTIONSROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(operationRoleCheckBox);
			
			if(td.get("SALESROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(salesRoleCheckBox);
			
			if(td.get("CUSTOMER").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(customerCheckBox);
			waitForElementToBeClickableThenClick(saveButton);
			msg = getAlertMessage();
			System.out.println(msg);
			sleepAvg();	
			waitForAngularRequestsToFinish();
			return msg;
			}
		
		public String searchUser(String mailid ) throws InterruptedException {
			
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,mailid);
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			
			String user =getWebelementText(resultTableLogin);
			waitForElementToBeClickableThenClick(showFilterButton);
			return user;
		}
		
		public String deleteUser(String mailid) throws InterruptedException {
			
			String msg = null;
			driver.navigate().refresh();
			if(searchUser(mailid).equals(mailid)) {
				waitForElementToBeClickableThenClick(resultTableDelete);
				waitForAngularRequestsToFinish();
				if(getWebelementText(deleteConfirmText).equals("Delete this user "+mailid+"?")) {
					waitForElementToBeClickableThenClick(delUserButton);
					msg = getAlertMessage();
					//sleepAvg();
					
				}
				return msg;	
			}
			else
				return msg;
		}
		
		public String getAlertMessage() {
			
			return alert.getText();
		}

//Bhanu
		
		public String viewUser(Map<String, String> testData) throws InterruptedException {
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,testData.get("LOGIN"));
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(viewButton);
			sleepMin();
			String login = loginValue.getText();
			String Name = firstNameValue.getText();
			if(login.equals(testData.get("LOGIN"))  &&  Name.equals(testData.get("FIRSTNAME")))
			{
				return Name;
			}
			else
				return "";
		}
		
		public String editUser(Map<String, String> testData) throws InterruptedException {
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,testData.get("LOGIN"));
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(editButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClearThenSendkeys(loginInputText, testData.get("UPDATEDLOGIN"));
			//waitForElementToBeClickableThenSendkeys(loginInputText,testData.get("UPDATEDLOGIN"));
			//waitForElementToBeClickableThenSendkeys(firstNameInputText,testData.get("EDITNAME"));
			waitForElementToBeClickableThenClearThenSendkeys(firstNameInputText, testData.get("EDITNAME"));
			waitForElementToBeClickableThenClick(saveButton);
			//waitForAngularRequestsToFinish();
			String msg=updateAlert.getText();
			System.out.println(msg);
			//sleepAvg();		
			return msg;
		}


////////////// Naincy
		
		public void createNewUserWithTenant(Map<String, String> td) throws InterruptedException, AWTException {
			String msg;
			waitForElementToBeClickableThenClick(newUserButton);
			waitForElementToBeClickableThenSendkeys(loginInputText,td.get("LOGIN"));
			waitForElementToBeClickableThenSendkeys(firstNameInputText,td.get("FIRSTNAME"));
			waitForElementToBeClickableThenSendkeys(lastNameInputText,td.get("LASTNAME"));
			
			if(td.get("ACTIVATED").equalsIgnoreCase("no"))
				waitForElementToBeClickableThenClick(activatedcheckBox);
			
			if(td.get("SYSTEMADMINROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(systemAdminRoleCheckBox);
			
			if(td.get("OPERATIONSADMINROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(operationAdminRoleCheckBox);
			
			if(td.get("OPEARTIONSROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(operationRoleCheckBox);
			
			if(td.get("SALESROLE").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(salesRoleCheckBox);
			
			if(td.get("CUSTOMER").equalsIgnoreCase("yes"))
				waitForElementToBeClickableThenClick(customerCheckBox);
			
			tenanttextfield.click();
			sleepMAX();
			tenanttextfield.sendKeys(td.get("TenantID"));
    	    sleepMin();
    	    //Robot robot = new Robot (); 
    		

    	    //robot.keyPress (KeyEvent.VK_ENTER); 
    		//sleepMin();
    		waitForElementToAppear(selectTenant);
    		waitForElementToBeClickableThenClick(selectTenant);
    		
			waitForElementToBeClickableThenClick(saveButton);
			 sleepMin();
			}
		
		
		public String removeTenatFromUser(Map<String, String> testData) throws Exception {
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			//waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,testData.get("LOGIN"));
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(editButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(removetenant);
			waitForElementToBeClickableThenClick(saveButton);
			//waitForAngularRequestsToFinish();
			String msg=updateAlert.getText();
			System.out.println(msg);
			//sleepAvg();		
			return msg;
		}

		/////////////edit role

		public String editRoleForUser(Map<String, String> testData) throws InterruptedException {
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,testData.get("LOGIN"));
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(editButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(customerCheckBox);
			waitForElementToBeClickableThenClick(systemAdminRoleCheckBox);
			sleepMin();
			waitForElementToBeClickableThenClick(saveButton);
			//waitForAngularRequestsToFinish();
			String msg=updateAlert.getText();
			System.out.println(msg);
			//sleepAvg();
			waitForAngularRequestsToFinish();
			return msg;
		}
			
		///edit user by providing customer role and choose one or more tenants
		public String editRoleAddCustTenantForUser(Map<String, String> testData) throws InterruptedException, AWTException {
			waitForElementToBeClickableThenClick(showFilterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(searchFieldSelect,"Email");
			waitForElementToBeClickableThenSendkeys(searchConditionSelect,"equals");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,"");
			waitForElementToBeClickableThenSendkeys(searchValueInputText,testData.get("LOGIN"));
			waitForElementToBeClickableThenClick(filterButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(editButton);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(salesRoleCheckBox);
			waitForElementToBeClickableThenClick(customerCheckBox);
			sleepMin();
			tenanttextfield.click();
			sleepMAX();
			tenanttextfield.sendKeys(testData.get("TenantID"));
    	    /*sleepMin();
    	    Robot robot = new Robot (); 
    		

    	    robot.keyPress (KeyEvent.VK_ENTER);*/
    	    
    	    waitForElementToAppear(selectTenant);
    		waitForElementToBeClickableThenClick(selectTenant);
			
			waitForElementToBeClickableThenClick(saveButton);
			//waitForAngularRequestsToFinish();
			String msg=updateAlert.getText();
			System.out.println(msg);
			//sleepAvg();		
			return msg;
		}



		//--------------------Sunilkumar(VMM3582)-----------------------
		public void clickedituser() throws Exception {
			
			waitForElementToBeClickableThenClick(editButton);
			sleepMin();
		}
		
	   public void tenanttextfield(Map<String, String> testData) throws Exception {
			
			waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenanttextfield,testData.get("TenantID"));
//			waitForAngularRequestsToFinish();
			sleepMAX();
			waitForElementToBeClickableThenClick(saveButton);
		}
		
		public void addTenant(Map<String, String> testData) throws InterruptedException, AWTException
		{
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(tenanttextfield);
			sleepMAX();
			waitForElementToBeClickableThenSendkeys(tenanttextfield,testData.get("TenantID"));
			
			waitForElementToBeClickableThenClick(selecttenant);
    	    sleepMin();
		
		}
		
		
		public void removetenantid() throws Exception {
			 waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(removetenant);
		}
		
		public void clicksaveBtn() throws Exception {
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(saveButton);
			waitForAngularRequestsToFinish();
		}
		
		public String usercreatepopup() throws InterruptedException {
			//sleepMin();
			if (usercreatepopup.isDisplayed()) {
				 
				return "true";
				
			} else {
				
	            return "false";
			}
		}
		
		
		
		

}
