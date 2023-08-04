package safefleetLM.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import safefleetLM.componentgroups.ReusableLibrary;

public class CustomersPage extends ReusableLibrary{

	WebDriver driver;

	public CustomersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Reference
	//WebElement xXX = driver.findElement(By.id("Input_Password"));
	//By findBy = By.cssSelector(".btn-primary");

	//PageFactory

	@FindBy(id="customer_btn_new")
	WebElement newCustomerBtn;

	@FindBy(id="field_name")
	WebElement nameInputTxt;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath="//div[@class='ng-scope']/input[@type='text']")
	WebElement custSearchTxt;

	@FindBy(xpath="//div[@class='ui-grid-canvas']")
	WebElement custTable;

	@FindBy(xpath="//i[text()='delete']")
	WebElement custDeleteLnk;

	@FindBy(xpath="//*[@name='deleteForm']//button[@type='submit']")
	WebElement custDelConfirmBtn;

	@FindBy(xpath="//i[text()='edit']")
	WebElement custEditLnk;






	//Rajath-----------------------------------------

	@FindBy(xpath="(//span[text()='Customers'])[1]")
	WebElement clickoncustomer;

	@FindBy(xpath="//input[@id='field_name']")
	WebElement createNewcustomer;

	@FindBy(xpath="//button[@id='customer_btn_new']")
	WebElement ClickNewBtn;

	@FindBy(xpath="//input[@id='field_name']")
	WebElement sendkeys;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn1;

	@FindBy(xpath="//div[@class='ng-scope']/input[@type='text']")
	WebElement customertable;

	@FindBy(xpath="//i[text()='visibility']")
	WebElement Viewcustomer;

	@FindBy(xpath="//*[@class='showHideFilters ng-binding']")
	WebElement clickshowfilter;

	@FindBy(xpath="(//span[text()='Licenses'])[1]")
	WebElement clickonlicenses;

	@FindBy(xpath="//div[@class='ng-scope']/input[@type='text']")
	WebElement emptyfield;


	@FindBy(xpath="//option[text()='License Type']")
	WebElement licensetype;


	@FindBy(xpath="//span[text()='System Admin']")
	WebElement systemadmin;


	String scrolltoAddOnProduct="//tbody/tr[35]/td[2]";
	//WebElement ADDONPRODUCT;


	String addOnProduct="//tbody/tr[22]/td[4]";

	@FindBy(xpath="//span[text()='Save']")
	WebElement SaveNewCustName;

	@FindBy(xpath="//span[text()='Back']")
	WebElement cancelbutton;


	//@FindBy(xpath="//input[@type='text']")
	//WebElement empcustshowfilter;

	@FindBy(xpath="//i[text()='visibility']")
	WebElement custdata;

	@FindBy(xpath="//input[@type='text']")
	WebElement clickEpCsbut;

	@FindBy(xpath="//input[@id='field_name']")
	WebElement custxtfield;

	@FindBy(xpath="//input[@aria-label='Filter for column']")
	WebElement Customerempty;

	@FindBy(xpath="//input[@aria-label='Filter for column']")
	WebElement customerTxtField;

	@FindBy(xpath="//select[@style='width:180px;']")
	WebElement textfield;



	//Rajath VMM-3369

	@FindBy(xpath="(//i[text()='assignment_turned_in'])[10]")
	WebElement Devicetrack;

	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement loadchangelist;

	String scrolltoUPDATE="//tbody/tr[10]/td[7]/button[1]/i[1]";

	@FindBy(xpath="//tbody/tr[10]/td[7]/button[1]/i[1]")
	WebElement eyesymbol;

	@FindBy(xpath = "//button[normalize-space()='Done']")
	WebElement doneSymbol;


	@FindBy(xpath="//button[@title='Device tracking']//i[@class='material-icons']")
	WebElement devicetrackBbtn;

	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[7]/button/i")
	WebElement eye;

	@FindBy(xpath="/html/body/div[4]/div/div/div[3]/button")
	WebElement done;

	@FindBy(xpath="/html/body/div[4]/div/div/div[1]/h4")
	WebElement verifyaudit;



	//Rajath VMM-3573---------------------------------------------
	@FindBy(xpath = "(//select[@placeholder='Filter for column'])[1]")
	WebElement devicetype;

	@FindBy(xpath="//option[text()='MDT LTE']")
	WebElement item;

	@FindBy(xpath="(//i[text()='visibility'])[13]")
	WebElement view;

	@FindBy(xpath="//span[text()='View Device']")
	WebElement viewDevice;


	//Rajath VMM-3718------------------------------------------------
	@FindBy(xpath = "//span[@id='system-admin-server']")
	WebElement server;

	@FindBy(xpath = "//button[@id='newserver']")
	WebElement newserver;

	@FindBy(xpath = "(//*[@type='text'])[1]")
	WebElement EnterName;

	@FindBy(xpath = "//input[@type='url']")
	WebElement Enterurl;

	@FindBy(xpath = "//select[@id='field_deploymentType']")
	WebElement Enterdeplmttype;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement savebutton;

	@FindBy(xpath = "//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
	WebElement alertpopup;

	@FindBy(xpath = "//div[@id='mm-0']/div[2]/form/div[2]/jh-alert-error/div/div/div/div/pre")
	WebElement errorPopup;

	@FindBy(xpath = "//button[@type='button']")
	WebElement Servercancelbutton;


	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
	WebElement showFilterName;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
	WebElement showFilterequals;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
	WebElement Dataenter;

	@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Filter']")
	WebElement ServerFILTERbutton;

	@FindBy(xpath = "//i[normalize-space()='delete']")
	WebElement serverDeletesymbol;

	@FindBy(xpath = "//button[@id='delbutton123']")
	WebElement ServerDeleteAction;





	//Rajath VMM-3585-----------------------------------------
	@FindBy(xpath = "(//button[@id='savebutton'])[1]")
	WebElement savebutt;

	@FindBy(xpath = "//tbody/tr[2]/td[5]/button[1]/i[1]")
	WebElement clickeye;

	@FindBy(xpath = "//span[@id='uuid123']")
	WebElement uuid;

	@FindBy(xpath = "//span[normalize-space()='Back']")
	WebElement Backbutt;

	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement uuidcolumn;

	@FindBy(xpath = "//tbody/tr[3]/td[5]/button[1]/i[1]")
	WebElement viewingbutt;

	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	List<WebElement> uuidList;



	@FindBy(xpath = "//span[@class='showHideFilters ng-binding']")
	WebElement servershowfilter;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
	WebElement EnterNameservershowfilter;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
	WebElement Enterequalservershowfilter;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
	WebElement EnterData;

	@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Filter']")
	WebElement FILTERButton;

	@FindBy(xpath = "//i[normalize-space()='delete']")
	WebElement Deletesymbol;

	@FindBy(xpath = "//button[@id='delbutton123']")
	WebElement DeleteAction;









	//Rajath VMM-3425-----------------------------------------
	@FindBy(xpath = "//input[@type='text']")
	WebElement Customerbox;

	@FindBy(xpath = "(//i[normalize-space()='delete'])[1]")
	WebElement deletecustomertrashbutt;

	@FindBy(xpath="//span[normalize-space()='Delete']")
	WebElement deletesymbol;


/////*******************Bhanu*******************************

	@FindBy(xpath = "//pre[@class='ng-binding ng-scope']")
	WebElement Alertpopup;

	@FindBy(xpath="//input[@type='text']")
	WebElement textBox;

	@FindBy(xpath="(//i[text()='delete'])[1]")
	WebElement deleteCustomerBtn;

	@FindBy(xpath="//span[@translate='entity.action.delete']")
	WebElement deleteCustomerConfirmBtn;

	@FindBy(xpath="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]")
	WebElement getCustomerName;


	//Savitha

	@FindBy(xpath="//td/span[text()='Customer']/../following::td/span")
	WebElement custNameTxt;

	public void createNewCustomer(String newCustomerName) {
		waitForElementToBeClickableThenClick(newCustomerBtn);
		waitForElementToBeClickableThenSendkeys(nameInputTxt,newCustomerName);
		waitForElementToBeClickableThenClick(saveBtn);
		waitForAngularRequestsToFinish();
			}



	public boolean verifyCustomerIsAvailable(String newCustomerName) {
		// User should be on 'Customers' dashboard Page
		waitForElementToBeClickableThenClearThenSendkeys(custSearchTxt,newCustomerName);
		waitForAngularRequestsToFinish();
		String resultCustomer = custTable.getText().trim();
		if(resultCustomer.equalsIgnoreCase(newCustomerName)) {
			return true;
		}
		else
			return false;
	}



	public void deleteCustomer(String newCustomerName) throws InterruptedException {
		// Customer should be available in LM
		waitForAngularRequestsToFinish();
		boolean custAvailability= verifyCustomerIsAvailable(newCustomerName);
		if(custAvailability){
			waitForElementToBeClickableThenClick(custDeleteLnk);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(custDelConfirmBtn);
			//waitForAngularRequestsToFinish();
			sleepMAX();
		}
		else
			//Add this in report as Fail
			System.out.println("Customer Not available");
	}

	public void editCustomer(String updateCustomerName) throws InterruptedException {
		// User should be on 'Customers' dashboard Page
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(custEditLnk);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClearThenSendkeys(nameInputTxt,updateCustomerName);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(saveBtn);
		waitForAngularRequestsToFinish();
	}

public void clickonlicenses() {
		waitForElementToBeClickableThenClick(clickonlicenses);
		waitForElementToBeClickableThenClick(Viewcustomer);
	}

	// Rajath   VMM-3367
	public void createNewCustomer(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenSendkeys(custxtfield,testData.get("Name"));
		waitForAngularRequestsToFinish();
	}
	public void Clickoncustomer() {
		waitForElementToBeClickableThenClick(clickoncustomer);
	}

	/*public void Sendkeys() {
		waitForElementToBeClickableThenSendkeys(sendkeys,"Rajath");
	}
	*/

	public void clicknewbutton() {
		waitForElementToBeClickableThenClick(ClickNewBtn);
		waitForAngularRequestsToFinish();
	}

	public void Clicksavebutton() throws InterruptedException {
		waitForElementToBeClickableThenClick(saveBtn);
		sleepMAX();
	}

	public void Clickoncustomertable() {
		waitForElementToBeClickableThenClick(customertable);
	}

	public void ClickOnShowFilter() {
		waitForElementToBeClickableThenClick( clickshowfilter);
			}

	public void Clickonview() throws InterruptedException {
		waitForElementToBeClickableThenClick(Viewcustomer);
		sleepMAX();
	}
	//public void Clickoncustxtfield(Map<String, String> testData) throws InterruptedException {
		//waitForElementToBeClickableThenSendkeys(custxtfield,testData.get("Name"));
		//sleepMin();
		//waitForElementToBeClickableThenClick(Viewcustomer);
//	}

	//public void Sendkeys1() {
		//waitForElementToBeClickableThenSendkeys(sendkeys,"Rajath");
///////////


 public String DeleteCreatedCustomer(Map<String, String> testData) throws InterruptedException {
			waitForAngularRequestsToFinish();

			//waitForElementToBeClickableThenClick(textBox);

			//waitForElementToBeClickableThenSendkeys(textBox,testData.get("edit_Name"));

			waitForElementToBeClickableThenSendkeys(textBox,testData.get("edit_Name"));

			waitForAngularRequestsToFinish();
			sleepMin();
			waitForElementToBeClickableThenClick(deleteCustomerBtn);
			sleepMin();
			waitForElementToBeClickableThenClick(deleteCustomerConfirmBtn);

			String msg=Alertpopup.getText();

			return msg;
	 }


	///***************************************************

	public void  clickonemttxtfield() throws Exception {
		waitForElementToBeClickableThenClick(emptyfield);
		sleepMAX();
	}
	public String  clickonlicensetype() throws Exception {
		waitForElementToBeClickableThenClick(licensetype);
		sleepMin();
		String lt = getWebelementText(licensetype);
		if(lt!=null)
			return lt;
		else
			return null;
	}


	public void ClickonSystemadmin() {
		waitForElementToBeClickableThenClick(systemadmin);
	}


	public String AddOnProduct () throws Exception
	{
		scrollToElement(scrolltoAddOnProduct);
		scrollToElement(addOnProduct);
		sleepAvg();
	String text="Cloud-Courier";
	return text;
	}


	public void  ClickOnSave() throws InterruptedException {
		waitForElementToBeClickableThenClick(SaveNewCustName);

	}

	public void time() throws Exception {
		sleepAvg();
	}


	public void  searchCustomer() {
		//waitForElementToBeClickableThenClick(empcustshowfilter);
		waitForElementToBeClickableThenSendkeys(sendkeys,"Rajath");
	}


	public void Clickoncustxtfield(String testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(emptyfield,testData);
		waitForAngularRequestsToFinish();
		sleepMin();

	}

    public void searchCustomer(Map<String, String> testData) throws InterruptedException {
    //sleepMin();
    waitForElementToBeClickableThenSendkeys(customerTxtField,testData.get("Name"));
    waitForAngularRequestsToFinish();
    //sleepMin();
    }

    public void viewCustomer() throws InterruptedException {
    waitForElementToBeClickableThenClick(Viewcustomer);
    waitForAngularRequestsToFinish();
    }


    public void searchCustomer1() throws InterruptedException {
    	waitForAngularRequestsToFinish();
    	sleepMAX();
    	waitForElementToBeClickableThenSendkeys(Customerempty,"Rajath");
    }

    public void cusTxt() {
    	waitForElementToBeClickableThenSendkeys(Customerempty,"Rajath");
    }
    public void customerSearch() {
    	waitForElementToBeClickableThenClick(customerTxtField);
}
    public void clickOnEmptyField () {
    	waitForElementToBeClickableThenClick(textfield);
    }


	// S9 Rajath VMM-3369-------------------------------
    public void clickOnDevicetracking () {
    	waitForElementToBeClickableThenClick(Devicetrack);
    }
    public void clickOnLoadChange () {
        waitForElementToBeClickableThenClick(loadchangelist);
    	}

    public void UPDATE () throws Exception
	{
		scrollToElement(scrolltoUPDATE);
		//sleepMAX();
		waitForElementToBeClickableThenClick(eyesymbol);
		Thread.sleep(5000);
		//waitForElementToBeClickableThenClick(doneSymbol);
	}
    public void clickOnDone () {
    waitForElementToBeClickableThenClick(doneSymbol);
	}


	//Rajath VMM-3573-------------------------------------------
	 public void clickOnDeviceType () throws InterruptedException {
	        waitForElementToBeClickableThenClick(devicetype);
	        Thread.sleep(2000);

	 }
	 public void clickOnMTDLTE () throws InterruptedException  {
		 waitForElementToBeClickableThenClick(item);
		 Thread.sleep(3000);

	 }
	 public void  clickOneye() throws InterruptedException  {
		 waitForElementToBeClickableThenClick(view);
		 Thread.sleep(4000);
	 }

	 public void gettext() {
		 String mdt = getWebelementText(viewDevice);
		 System.out.println("text:"+mdt);
	 }


public String  VerifyViewDevice() throws Exception {
	    waitForElementToBeClickableThenClick(viewDevice);
	    sleepMin();
	    String VerifyViewDevice = getWebelementText(viewDevice);
	    if(VerifyViewDevice!=null)
		     return VerifyViewDevice;
	    else
		     return null;
}

//Rajath VMM-3718------------------------------------------------
	 public void clickOnServers () {
		 waitForElementToBeClickableThenClick(server);
	 }
	 public void  clickOnNewServers () {
		 waitForElementToBeClickableThenClick(newserver);
	 }

	 public void  createServers (Map<String, String> testData) throws InterruptedException {
		 waitForElementToBeClickableThenSendkeys(EnterName, testData.get("Name"));
		 sleepMin();
		 waitForElementToBeClickableThenSendkeys(Enterurl, testData.get("Url"));
		 sleepMin();
		 waitForElementToBeClickableThenSendkeys(Enterdeplmttype, testData.get("Deployment Type"));
		 sleepMin();
}
	 public void  clickOnsave () throws InterruptedException {
		 waitForElementToBeClickableThenClick(savebutton);
		 Thread.sleep(4000);
	 }

	 public void  createServersWithSameName (Map<String, String> testData) throws InterruptedException {
		 waitForElementToBeClickableThenSendkeys(EnterName, testData.get("Name"));
		 sleepMin();
		 waitForElementToBeClickableThenSendkeys(Enterurl, testData.get("Url"));
		 sleepMin();
		 waitForElementToBeClickableThenSendkeys(Enterdeplmttype, testData.get("Deployment Type"));
		 sleepMin();

}
	 public void clickAlertpopup () {
		 waitForElementToBeClickableThenClick(alertpopup);



}

public boolean checksavePopup() {
			if(alertpopup.isDisplayed())
			return true;
			else
				return false;
	 }


public boolean checkalertPopup() {
	if(errorPopup.isDisplayed())
	return true;
	else
		return false;
}
public void clickOnCancelButton () {
	 waitForElementToBeClickableThenClick(Servercancelbutton);
	 waitForAngularRequestsToFinish();
}

public void FilterSearching (Map<String, String> testData) {
	waitForAngularRequestsToFinish();
	 selectListByVisibleText(showFilterName, "Name");
	 selectListByVisibleText(showFilterequals, "equals");
	 waitForElementToBeClickableThenSendkeys(Dataenter,testData.get("Name"));

}
public void clickFILTER () {
	 waitForElementToBeClickableThenClick(ServerFILTERbutton);
}
public void  clickDelete() throws InterruptedException {
	 waitForElementToBeClickableThenClick(serverDeletesymbol);
	 Thread.sleep(3000);
}
public void clickDeleteAction () throws InterruptedException {
	 waitForElementToBeClickableThenClick(ServerDeleteAction);
	 Thread.sleep(3000);
}






//Rajath VMM-3585-----------------------------------------
	 public void clickSaveButtonn () throws InterruptedException {
		 waitForElementToBeClickableThenClick(savebutt);
		 Thread.sleep(4000);

	 }
	 public void  clickEyeButt () throws InterruptedException {
		 waitForElementToBeClickableThenClick(clickeye);
		 Thread.sleep(4000);
     }
	 public String VerifyUUID() {
		 waitForElementToBeClickableThenClick(uuid);
		 String UUID = getWebelementText(uuid);
		 if(UUID!=null)
			 return UUID;
		 else {
			return null;
		}
     }
	 public void ClickOnBack () throws InterruptedException {
		 waitForElementToBeClickableThenClick(Backbutt);
		 Thread.sleep(4000);

}

public boolean UUIDsVerify()
	 {
		 waitForElementToBeClickableThenClick(uuidcolumn);
		 String VerifyUUIDs = getWebelementText(uuid);
		 int fail = 0,pass=0;
		{
			 for(int i=1; i<31; i++)
			 {
				 boolean Type = driver.findElement(By.xpath("uuidcolumn")).isDisplayed();
				 if(Type == true)
				 {
					 int Pass = 0;
					Pass ++;
				 System.out.println(uuid .getText());
				 }
				 else
				 {
					 fail ++;
				 }
			 }
		 }
		if(fail==0)
			return true;
		else
			return false;
	 }
		public boolean verifyUUIDName() {
			 int fail = 0,pass=0;
			int count=uuidList.size();
			for(int i=1; i<count; i++)
			{
				boolean BSName=uuidList.get(i).isDisplayed();
				if(BSName==true)
				{
					pass++;
				}
				else
					fail++;

			}
		if(fail==0)
			return true;
		else
			return false;

		}

		 public void clickOnEyeactionbutt () throws InterruptedException {
			 waitForElementToBeClickableThenClick(viewingbutt);
			 Thread.sleep(3000);
		 }



		public void clickOnBackbut () {
			 waitForElementToBeClickableThenClick(Backbutt);
		 }

		 public void clickOnServerShowFilterbutt () {
			 waitForElementToBeClickableThenClick(servershowfilter);
		 }

		 public void  SearchServerFilter(Map<String, String> testData) {
			waitForAngularRequestsToFinish();
				//waitForElementToBeClickableThenClick(showFilterBtn);
				//waitForAngularRequestsToFinish();
				//waitForElementToBeClickableThenSendkeys(EnterNameservershowfilter,"Name");
				//waitForElementToBeClickableThenSendkeys(Enterequalservershowfilter,"equals");
				//waitForElementToBeClickableThenSendkeys(EnterData,testData.get("Automationtest"));

			 selectListByVisibleText(EnterNameservershowfilter, "Name");
			 selectListByVisibleText(Enterequalservershowfilter, "equals");
			 waitForElementToBeClickableThenSendkeys(EnterData,testData.get("Name"));
		 }
		 public void clickOnFILTER () {
			 waitForElementToBeClickableThenClick(FILTERButton);
		 }
		 public void clickOnDeletesymbol () throws InterruptedException {
			 waitForElementToBeClickableThenClick(Deletesymbol);
			 Thread.sleep(3000);
		 }
		 public void clickOnDeleteAction () throws InterruptedException {
			 waitForElementToBeClickableThenClick(DeleteAction);
			 Thread.sleep(3000);
		}










	 //Rajath VMM-3425-----------------------------------------
		 public boolean  customerAdd(Map<String, String> testData) throws InterruptedException  {
			 sleepMin();
			 waitForElementToBeClickableThenClick(Customerbox);
			 waitForAngularRequestsToFinish();
			 System.out.println(testData.get("Name"));
			 waitForElementToBeClickableThenSendkeys(Customerbox, testData.get("Name"));
			 waitForAngularRequestsToFinish();
				String resultCustomer = custTable.getText().trim();
				if(resultCustomer.equalsIgnoreCase(testData.get("Name"))) {
					return true;
				}
				else
					return false;
		 }

		 public void clickOnDeleteCustomer () {
			 waitForElementToBeClickableThenClick(deletecustomertrashbutt);
		 }
		 public void ClickOnDeleteSymbol () throws Exception {
			 waitForElementToBeClickableThenClick(deletesymbol);
			 Thread.sleep(1000);
		 }



	//----------------------------Melroy VMM-3385--------------------------
	 public void createCustomerForTenant(Map<String, String> testData) throws Exception {
			waitForElementToBeClickableThenClick(newCustomerBtn);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(nameInputTxt,testData.get("Name"));
			waitForElementToBeClickableThenClick(saveBtn);
			sleepAvg();
	 }



////**********************Bhanu*********************************************
////VMM_3361

	 public String createCustomerForLicense(Map<String, String> testData) {
		 waitForElementToBeClickableThenClick(newCustomerBtn);
		 waitForAngularRequestsToFinish();
		 waitForElementToBeClickableThenSendkeys(nameInputTxt,testData.get("Name"));
		 waitForElementToBeClickableThenClick(saveBtn);
		 String msg=Alertpopup.getText();
		 return msg;
	 }

	 public String deleteLicenseCustomer(Map<String, String> testData) throws InterruptedException {
		 waitForAngularRequestsToFinish();

		 //waitForElementToBeClickableThenClick(textBox);

		 waitForElementToBeClickableThenSendkeys(textBox,testData.get("Name"));

		 waitForAngularRequestsToFinish();
		 sleepMin();
		 waitForElementToBeClickableThenClick(deleteCustomerBtn);
		 sleepMin();
		 waitForElementToBeClickableThenClick(deleteCustomerConfirmBtn);

		 String msg=Alertpopup.getText();

		 return msg;
	 }


	 public String[] verifyCustomerTextLength(Map<String, String> testData) throws InterruptedException {

		 waitForAngularRequestsToFinish();

		 waitForElementToBeClickableThenClick(newCustomerBtn);

		 waitForAngularRequestsToFinish();

		 waitForElementToBeClickableThenSendkeys(nameInputTxt,testData.get("Name"));

		 waitForElementToBeClickableThenClick(saveBtn);
		 String msg=Alertpopup.getText();

		 waitForAngularRequestsToFinish();

		 String CustomerSavedId = testData.get("Name").substring(0, Math.min(testData.get("Name").length(), 50));

		 waitForElementToBeClickableThenSendkeys(textBox,CustomerSavedId);

		 waitForAngularRequestsToFinish();
		 sleepMin();



		 String customerProvidedName = getCustomerName.getText();


		 return new String [] {msg,customerProvidedName};
	 }


///***********



//Rajath VMM-3369----------------------------------------------

		 public void clickOnDeviceTrackingButton () throws InterruptedException {
		 waitForElementToBeClickableThenClick(devicetrackBbtn);
		 waitForAngularRequestsToFinish();
		 sleepMin();

		 }
		 public void clickOnEyeSymbolBtn () throws InterruptedException {
		 waitForElementToBeClickableThenClick(eye);
		 waitForAngularRequestsToFinish();
		 sleepMin();
		 }

		 public void clickOnDoneSymbolBtn () throws InterruptedException {
			 waitForElementToBeClickableThenClick(done);
			 waitForAngularRequestsToFinish();
			 sleepMin();
		 }

		 public String VerifyAuditDetails() {

				String text=verifyaudit.getText();
				return text;
		 }

		 public String deleteCustomer(Map<String, String> testData) throws InterruptedException {
				waitForAngularRequestsToFinish();

				//waitForElementToBeClickableThenClick(textBox);

				waitForElementToBeClickableThenSendkeys(textBox,testData.get("edit_Name"));

				waitForAngularRequestsToFinish();
				sleepMin();
				waitForElementToBeClickableThenClick(deleteCustomerBtn);
				sleepMin();
				waitForElementToBeClickableThenClick(deleteCustomerConfirmBtn);

				String msg=Alertpopup.getText();

				return msg;

		 }

		 public String verifyCustomerFieldIsMandatory() {

				String field =custxtfield.getAttribute("aria-required");
				return field;
		 }

		 public String getCustNameFromViewScreen() {
			//td/span[text()='Customer']/../following::td/span
				String custName =custNameTxt.getText();
				return custName;
		 }

}




