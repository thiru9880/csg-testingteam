package safefleetLM.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class TenantsPage extends ReusableLibrary {

	WebDriver driver;

	public TenantsPage(WebDriver driver)  {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath="//*[@id=\"fleet_btn_new\"]/span")
	WebElement createNewTenantBtn;

	@FindBy(xpath="//*[@id='field_fleetId']")
	WebElement tenantIDTxt;

	@FindBy(xpath="//*[@id='field_fleet_type']")
	WebElement tenantTypeDrp;

	@FindBy(xpath="//*[@id='field_tenantName']")
	WebElement tenantNameTxt;

	@FindBy(xpath="//*[@id='field_deploymentType']")
	WebElement deploymentTypeDrp;

//
	@FindBy(xpath="(//*[@id='field_customer']//span)[1]")
	WebElement customerTxt;

	@FindBy(xpath="//*[@id='field_customer']//input[@type='search']")
	WebElement customerTxtBox;

	@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
	WebElement suggestionRowFirstValue;

	@FindBy(xpath="//*[@id='fleet_btn_save']")
	WebElement tenantSaveBtn;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/form/div[2]/div[13]/div/div/label/span")
	WebElement syncWithTMChk;

	@FindBy(xpath="//*[@class='table table-assign']/tbody/tr[1]/td[6]/button")
	WebElement tenantPgeDeviceSettingBtn;

	@FindBy(xpath="//*[@class='table table-assign']/tbody/tr[1]/td[2]")
	WebElement tenantPgeDeviceTypeNameTxt;

	@FindBy(xpath="//*[@type='submit'][2]")
	WebElement tenantEditBtn;


	@FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/button/span")
	WebElement showFiltersBtn;

	@FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/button")
	WebElement hideFiltersBtn;

	@FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
	WebElement filterFieldsDrp;

	@FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
	WebElement filterOperationsDrp;

	@FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
	WebElement tenantTxt;

	@FindBy(xpath="//*[@class='filterButtons']/button[2]")
	WebElement filterBtn;


	///3584
		@FindBy(xpath="(//input[@id='field_adminEmail'])[1]")
	WebElement adminEmail;

//-----------bhanu--------------

	@FindBy(xpath="(//*[@type='text'])[1]")
	WebElement tenantIdFilter;

	@FindBy(xpath="//i[text()='delete']")
	WebElement deleteButton;

	@FindBy(xpath="//span[text()='Delete']")
	WebElement DeleteConfirmBtn;

	@FindBy(xpath="//span[contains(text(),'Show Filters')]")
	WebElement showfilterBtn;

	@FindBy(xpath="//option[text()='Customer']")
	WebElement CustomerFilterOption;

	@FindBy(xpath="//option[text()='Tenant ID']")
	WebElement IDfilterOption;

	@FindBy(xpath="(//option[@label='equals'])[1]")
	WebElement equalsOption;

	@FindBy(xpath="(//span[text()='Filter'])[2]")
	WebElement FilterBtn;

	@FindBy(xpath="//span[@id='fleet_name']")
	WebElement countOfIDs;

	@FindBy(xpath="//span[@id='fleet_name']")
	WebElement tenantId;

	@FindBy(xpath="//i[text()='visibility']")
	WebElement metaData;

	@FindBy(xpath="//i[text()='edit']")
	WebElement EditButton;

	@FindBy(xpath="(//span[text()='Tenant ID']/../..//span)[2]")
	WebElement VrfydTenantId;

	@FindBy(xpath="//span[text()='Back']")
	WebElement backButton;

	@FindBy(xpath="//option[@label='Commercial']")
	WebElement commercialType;

	@FindBy(xpath="//span[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath="//button[text()='OK']")
	WebElement OKbutton;
//
	@FindBy(xpath="//option[text()='CLOUD_COMMERCIAL']")
	WebElement cloudCommercialoption;
	@FindBy(xpath="//option[text()='CLOUD_GOVERNMENT']")
	WebElement cloudGovoption;

	@FindBy(xpath = "//pre[@class='ng-binding ng-scope']")
	WebElement Alertpopup;

//VMM_3361-----

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement AlertMessage;

	/////

	@FindBy(xpath="(//button[@class='btn btn-primary btn-raised'])[2]")
	WebElement filterButton;

	@FindBy(xpath="(//i[normalize-space()='visibility'])[1]")
	WebElement eyeButton;

///***********


	//Rajath VMM-3326------------------------------------------------

	@FindBy(xpath="//span[@translate='entity.action.save']")
	WebElement savebutton;

	@FindBy(xpath="//div[@class='form-group label-floating']//span[@class='check']")
	WebElement synctoTM;






//------------------------------------------Nitin------------------------------------------------------//
  	@FindBy(xpath="//button[@class='btn btnShowFilterGroups btn-info btn-raised']")
  	WebElement showFiltersBtnn;

  	@FindBy(xpath="//span[contains(text(),'Hide Filters')]")
  	WebElement hideFiltersBtnn;

  	@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-valid ng-touched']")
  	WebElement filterFieldsDrpp;

  	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
  	WebElement filterOperationsDrpp;

  	@FindBy(xpath="//input[@class='form-control data-input ng-pristine ng-valid ng-touched']")
  	WebElement tenantTxtt;

  	@FindBy(xpath="//input[@id='field_fleetId']")
  	WebElement filledTenantId;

  	@FindBy(xpath="//span[contains(text(),'CLOUD_GOVERNMENT')]")
  	WebElement firstTenantIDDeploymentType;

  	@FindBy(id="tenant_assign_devicetype_filter")
  	WebElement deviceTypeDropDown;

  	@FindBy(xpath = "(//span[@class='check'])[3]")
  	WebElement firstDeviceCheckBox;

  	@FindBy(xpath = "//span[text()='Assign']")
  	WebElement assign;

  	@FindBy(xpath = "//span[@class='ui-select-match-text pull-left']")
  	WebElement settingDropDown;

  	@FindBy(xpath="//span[text()='Assign Device']")
  	WebElement assignDevice;

  	@FindBy(xpath = "//span[text()='Create a new Tenant']")
  	WebElement createANewTenant;

  	@FindBy(xpath = "(//input[@id='field_syncWithTM']//ancestor::div[@class='checkbox']//descendant::span)[2]")
  	WebElement syncWithTMCheckBox;

  	@FindBy(xpath = "//div[text()='Device Test']")
  	WebElement deviceTest;

  	@FindBy(xpath = "//span[text()='Save']")
  	WebElement saveButtonn;
  	//------------------------------------------Nitin------------------------------------------------------//



//surya-------------------------------------------VMM-3878---------------------------


    @FindBy(xpath=" (//*[contains (@class,'ui-grid-filter-select ui-grid-filter-input')])[1]")
	WebElement TenenatTypeDropDwn;

    @FindBy(xpath="(//*[contains (@class,'ui-grid-filter-select ui-grid-filter-input')])[1]//option[@label]")
   	List<WebElement> TenenatTypeDropDwnValues;


    @FindBy(xpath="(//select[@placeholder='Filter for column'])[2]")
    WebElement DeploymentTypeDropDwn;

    @FindBy(xpath="(//select[@placeholder='Filter for column'])[2]//option[@label]")
   	List<WebElement> DeploymentDropDwnValues;

    @FindBy(xpath="(//select[@placeholder='Filter for column'])[3]")
    WebElement SalesRegionTypeDropDwn;

    @FindBy(xpath="(//select[@placeholder='Filter for column'])[3]//option[@label]")
    List<WebElement> SalesRegionTypeDropDwnValues;

    @FindBy(xpath=" (//select[@placeholder='Filter for column'])[4]")
    WebElement StatusTypeDropDwn;

    @FindBy(xpath="(//select[@placeholder='Filter for column'])[4]//option[@label]")
    List<WebElement> StatusTypeDropDwnValues;

	@FindBy(xpath="//button[@id='fleet_delete_btn_delete']")
	WebElement DeleteConfirmBtnfleet;

//Rajath VMM_3592-----------------------------------------------------
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[3]/button[1]/span")
	WebElement clickClear;



	//Rajath VMM_4578-------------------------------------------------------------------
	@FindBy(xpath="//select[@id='field_fleet_id']")
	WebElement tenantidfield;

	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div") //pending
	WebElement tenantfiledtxtbox;

	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[3]/div") //
	WebElement devicetypetxtbox;

	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[9]/div") //
	WebElement devicestatus;


//--------------------------Sunilkumar(VMM4423)--------------------------
			@FindBy(xpath="//select[@id='tenant_assign_devicetype_filter']")
			WebElement deviceTypeTxtfield;

			@FindBy(xpath = "//*[@id=\"mm-0\"]/div[2]/div/div[1]/div[1]/div[2]/div[2]/table/tbody")
			List<WebElement> assignDeviceList;

	//-------------------------Sunilkumar(VMM4464)-------------------------
			@FindBy(xpath="//div[@id='assign_setting_select_field']//span[@class='ui-select-match-text pull-left']")
			WebElement assigndevicesettingTxtfield;




//Rajath VMM_4579--------------------------------------------------
			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div/div[10]/div/div/button[2]/i")
			WebElement tenanteditbtn;

			@FindBy(xpath="//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Filter']")
			WebElement tenantfilterbtn;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/table/tbody/tr/td[1]/select")
			WebElement DeviceTypeSelect;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/table/tbody/tr/td[3]/input")
			WebElement DeviceIDSelect;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div/label/span/span")
			WebElement checkbox;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[1]/div[1]/button/span")
			WebElement assignbtn;

			@FindBy(xpath="//span[text()='Tenants']")
			WebElement TenantsTabCheck;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[6]/button/i")
			WebElement verifyassignsettingbtn;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div/label/span/span")
			WebElement unassigncheckbox;

			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[1]/div[1]/button")
			WebElement unassignButton;

			@FindBy(xpath="/html/body/div[1]/div[2]/form/div[1]/div/button[2]/span")
			WebElement savebtn;


			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[6]/button")
			WebElement Settingicondisabled;

			@FindBy(xpath="//div[@id='assign_setting_select_field']//span[@class='ui-select-match-text pull-left']")
			WebElement deviceassigntxtfield;



//Rajath VMM_3656----------------------------------------------

			@FindBy(xpath="/html/body/div[1]/div[2]/form/div[2]/div[6]/div/select")
			WebElement salesregion;

			@FindBy(xpath="/html/body/div[1]/div[2]/form/div[2]/div[8]/div/input")
			WebElement state;

			@FindBy(xpath="/html/body/div[1]/div[2]/form/div[2]/div[10]/div/div/input")
			WebElement anniversarydate;

			@FindBy(xpath="/html/body/div[1]/div[2]/form/div[2]/div[5]/div/select")
			WebElement customertexttfield;





			@FindBy(xpath="//span[@class='showHideFilters ng-binding']")
			WebElement tenantshowfilter;

			//1-----------
			@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[5]")
			WebElement tenanttext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[1]/div[1]/div[1]/span[1]")
			WebElement tenantIDRow;

            //2------------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[6]")
			WebElement tenanttypetext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[3]/div[2]/div[1]/span[1]")
			WebElement tenanttypeRow;

		    //3------------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[7]")
			WebElement salesregiontext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[6]/div[2]/div[1]/span[1]")
			WebElement salesregionRow;

		    //4-----------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[8]")
			WebElement statetext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[7]/div[2]/div[1]/span[1]")
			WebElement stateRow;

		    //5--------------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[4]")
			WebElement customertext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[2]/div[2]/div[1]/span[1]")
			WebElement customerRow;

		    //6-------------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[3]")
			WebElement deploymenttypetext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[4]/div[2]/div[1]/span[1]")
			WebElement deploymenttypeRow;

		    //7--------------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[2]")
			WebElement anniversarydatetext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[8]/div[2]/div[1]/span[1]")
			WebElement anniversarydateRow;

		    //8----------
		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select/option[1]")
			WebElement statustext;

		    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[9]/div[2]/div[1]/span[1]")
			WebElement statusRow;



		//RajathVMM-4758------------------------------------------------------

		    @FindBy(xpath="//i[normalize-space()='visibility']")
			WebElement tenantview;

		    @FindBy(xpath="//span[@translate='vmaxmanagerApp.fleet.fleetId']")
			WebElement tenantverify;

		    @FindBy(xpath="//span[normalize-space()='Back']")
			WebElement tenantbackbtn;

			@FindBy(xpath="//span[normalize-space()='Save']")
			WebElement saveassigndevice;


			@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/table/tbody/tr/td[1]/select")
			WebElement devicetypeselect;

			@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/table/tbody/tr/td[3]/input")
			WebElement deviceIDselect;

	//Savitha
	@FindBy(xpath="//*[@id='field_state']")
	WebElement stateField;

	@FindBy(xpath="//*[@id='field_state']//input[@type='search']")
	WebElement stateTxtBox;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Tenant ID']")
	WebElement mandatoryFieldTenantId;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Tenant Type']")
	WebElement mandatoryFieldTenantType;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Tenant Name']")
	WebElement mandatoryFieldTenantName;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Deployment Type']")
	WebElement mandatoryFieldDeploymentType;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Customer']")
	WebElement mandatoryFieldCustomer;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='Admin Email']")
	WebElement mandatoryFieldAdminEmail;

	@FindBy(xpath="//*[@aria-required='true']/..//label//*[text()='State']")
	WebElement mandatoryFieldState;

	//Tenant Filter - Start
	@FindBy(xpath="//button[@ng-click='addCondition()']")
	WebElement AddConditionBtn;

  	@FindBy(xpath="(//select[@ng-model='rule.field'])[1]")
	WebElement conditionField1;

  	//@FindBy(xpath="(//select[@ng-model='rule.condition'])[2]")
	@FindBy(xpath="(//select[@ng-model='rule.condition'])[1]")
	WebElement conditionOperation1;

	@FindBy(xpath="//*[@class='group-conditions']//input[@type='text']")
	//@FindBy(xpath="(//select[@ng-model='rule.model'])[1]")
	//@FindBy(xpath="(//input[@ng-model='rule.data'])[1]")
	WebElement conditionFieldValue1;

	@FindBy(xpath="(//select[@ng-model='rule.field'])[2]")
	WebElement conditionField2;

	@FindBy(xpath="(//select[@ng-model='rule.condition'])[4]")
	WebElement conditionOperation2;

	//@FindBy(xpath="(//select[@ng-model='rule.model'])[2]")
	@FindBy(xpath="(//select[@ng-model='rule.model'])[1]")
	WebElement conditionFieldValue2;

	@FindBy(xpath="(//select[@ng-model='rule.field'])[3]")
	WebElement conditionField3;

	@FindBy(xpath="(//select[@ng-model='rule.condition'])[6]")
	WebElement conditionOperation3;

	@FindBy(xpath="(//select[@ng-model='rule.model'])[2]")
	WebElement conditionFieldValue3;
	//Tenant Filter - end

	@FindBy(xpath="//*[@id='fleet_detail_id']/span")
	WebElement tenantIdTxt;

	@FindBy(xpath="//*[@id='fleet_detail_deployment']/span")
	WebElement deploymentTypeTxt;

	@FindBy(xpath="//*[@id='fleet_detail_type']/a")
	WebElement tenantTypeTxt;






	public void createNewTenant(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("TenantType"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));
		waitForElementToBeClickableThenSendkeys(deploymentTypeDrp, testData.get("DeploymentType"));
		waitForElementToBeClickableThenClick(customerTxt);
		waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
		waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));
		waitForElementToBeClickableThenClick(stateField);
		waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
		waitForElementToBeClickableThenClick(syncWithTMChk);
	}

	public void tenantSave() throws InterruptedException {

		waitForElementToBeClickableThenClick(tenantSaveBtn);
		waitForAngularRequestsToFinish();
		//sleepMAX();
	}

	public Map<String,String> settingsButtonTest() {

		scrollToElement("//*[@class='table table-assign']/tbody/tr[1]/td[2]");

		Map<String,String> settingsBtnStatus = new HashMap<String,String>();

		for(int i = 1; i<=3;i++) {

		String deviceType = "//*[@class='table table-assign']/tbody/tr["+i+"]/td[2]";

		String settingsBtn = "//*[@class='table table-assign']/tbody/tr["+i+"]/td[6]/button";

		settingsBtnStatus.put(driver.findElement(By.xpath(deviceType)).getText(), driver.findElement(By.xpath(settingsBtn)).getAttribute("aria-disabled"));

		}

		return settingsBtnStatus;
	}


	public void clickTenantEditBtn() {

		waitForElementToBeClickableThenClick(tenantEditBtn);

	}

 public void searchTenants(Map<String, String> testData) throws InterruptedException {

	 	waitForAngularRequestsToFinish();

		 waitForElementToBeClickableThenClick(showFiltersBtn);

		 selectListByVisibleText(filterFieldsDrp, "Tenant ID");

		 selectListByVisibleText(filterOperationsDrp, "equals");

		 waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

	//	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

		 sleepMAX();

		 waitForElementToBeClickableThenClick(filterBtn);

		 sleepAvg();

		 waitForElementToBeClickableThenClick(hideFiltersBtn);


		 	 }


	///3584

	public void createNewTenantWithAdminMail(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));

		sleepMin();

		waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("TenantType"));

		sleepMin();

		waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));

		waitForElementToBeClickableThenSendkeys(deploymentTypeDrp, testData.get("DeploymentType"));

		waitForElementToBeClickableThenClick(customerTxt);
		waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));

		//if(env.equals("DEV")) {
		waitForElementToBeClickableThenClick(stateField);
		waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
	//}

		waitForElementToBeClickableThenClick(syncWithTMChk);
		sleepMAX();
//		sleepMAX();

		waitForElementToBeClickableThenClick(tenantSaveBtn);

		sleepMAX();




	}

	////////////

	public void verifyTenantPageFeild() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(createNewTenantBtn);
		sleepMin();
	}
	public void createNewTenantWithAdminMail2(Map<String, String> testData) throws InterruptedException {

//		waitForElementToBeClickableThenClick(createNewTenantBtn);

		waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));

		sleepMin();

		waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("TenantType"));

		sleepMin();

		waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));

		waitForElementToBeClickableThenSendkeys(deploymentTypeDrp, testData.get("DeploymentType"));

		waitForElementToBeClickableThenClick(customerTxt);
		waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));

		//if(env.equals("DEV")) {
		waitForElementToBeClickableThenClick(stateField);
		waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
	//}

		waitForElementToBeClickableThenClick(syncWithTMChk);
		sleepMAX();
//		sleepMAX();

		waitForElementToBeClickableThenClick(tenantSaveBtn);

		sleepMAX();


	}
	public void filterTenant(String ID) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(showfilterBtn);
		waitForElementToBeClickableThenClick(IDfilterOption);
		waitForElementToBeClickableThenClick(equalsOption);
		waitForElementToBeClickableThenSendkeys(tenantIdFilter,ID);
		waitForElementToBeClickableThenClick(filterButton);
		sleepMAX();
	}
	public void eyeViewTenant(String ID) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(eyeButton);
		sleepMAX();
	}


	//bhanu---------------------------------Bhanu-----------------------------------------------------

	public String verifyTenantType(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("VerifyTypes"));
		waitForAngularRequestsToFinish();

		String ActualType1 = driver.findElement(By.xpath("//option[@label='"+testData.get("VerifyTypes")+"']")).getText();

		String ActualType=commercialType.getText();
		System.out.println(ActualType1);

		if(ActualType1!=null)
			return ActualType1;
		else
			return null;
	}
	public void clickCancelBtn()
	{
		waitForElementToBeClickableThenClick(cancelBtn);
		waitForAngularRequestsToFinish();
	}
	//Method overloading based on implementation
	public String tenantSave(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(tenantSaveBtn);
		String msg = AlertMessage.getText();
		return msg;
		//sleepMin();
	}


	public void tenantWithAdminEmail(Map<String, String> testData) {

		///waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));

		waitForElementToBeClickableThenClearThenSendkeys(adminEmail, testData.get("AdminEmail"));

	}



	public String saveConfirmation(Map<String, String> testData) throws InterruptedException
	{
		filterHere(testData.get("TenantID").toLowerCase());

		waitForElementToBeClickableThenClick(FilterBtn);
		Thread.sleep(8000);
		//waitForAngularRequestsToFinish();
		String ActualID = getWebelementText(tenantId);
		System.out.println(ActualID);
		if(ActualID!=null)
			return ActualID;
		else
			return null;
	}
	public String verifyTenantInformation(Map<String, String> testData) throws InterruptedException
	{
		//////////////

		waitForAngularRequestsToFinish();
		  filterHere(testData.get("TenantID").toLowerCase());
			sleepMin();
			waitForElementToBeClickableThenClick(FilterBtn);
			waitForAngularRequestsToFinish();

			sleepMAX();

		waitForElementToBeClickableThenClick(metaData);
		waitForAngularRequestsToFinish();
		String ActualId =getWebelementText(VrfydTenantId);
		return ActualId;
	}
	public String verifyIdCase(Map<String, String> testData) throws InterruptedException
	{
		String ActualID =getWebelementText(VrfydTenantId);
		String ExpectedID=testData.get("TenantID").toLowerCase();
		return ActualID;
	}
	public void editTenantUserData(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(backButton);
		sleepMAX();

		filterHere(testData.get("TenantID").toLowerCase());

		waitForElementToBeClickableThenClick(FilterBtn);
		Thread.sleep(5000);
		waitForElementToBeClickableThenClick(EditButton);
		sleepMAX();

		waitForElementToBeClickableThenClearThenSendkeys(tenantIDTxt, testData.get("EditedTenantID"));
		waitForElementToBeClickableThenClick(tenantSaveBtn);
		sleepMAX();
	}
	public String verifyEditedTenant(Map<String, String> testData) throws InterruptedException
	{
		filterHere(testData.get("EditedTenantID").toLowerCase());

		sleepMin();
		waitForElementToBeClickableThenClick(FilterBtn);
		waitForAngularRequestsToFinish();
		String EditedId =getWebelementText(tenantId);
		System.out.println("Edited :"+EditedId);
		sleepMin();

		if(EditedId!=null)
			return EditedId;
		else
			return null;
	}

	public boolean deleteEditedTenant(Map<String, String> testData) throws InterruptedException {

		sleepMin();
		String DeletID = tenantId.getText();
		sleepMin();
		System.out.println("want to delete :"+DeletID);
		if(DeletID.equalsIgnoreCase(testData.get("EditedTenantID").toLowerCase()))
		{
			waitForElementToBeClickableThenClick(deleteButton);
			sleepMin();
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deleteTenant(Map<String, String> testData) throws InterruptedException
	{
		sleepMin();

		driver.navigate().refresh();

		waitForAngularRequestsToFinish();

    filterHere(testData.get("TenantID").toLowerCase());
		sleepMin();
		waitForElementToBeClickableThenClick(FilterBtn);
		waitForAngularRequestsToFinish();
		sleepMAX();
		waitForElementToAppear(tenantId);
		String DeleteID = tenantId.getText();
		sleepMin();
		System.out.println("want to delete :"+DeleteID);
		if(DeleteID.equalsIgnoreCase(testData.get("TenantID")))//testData.get("EditedTenantID").toLowerCase())
		{
			waitForElementToBeClickableThenClick(deleteButton);
			waitForAngularRequestsToFinish();
			return true;
		}
		else {
			return false;
		}
	}
	public String deleteConfirmation() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(DeleteConfirmBtn);
		String alertMsg = Alertpopup.getText();
		//waitForAngularRequestsToFinish();
		sleepAvg();
		return alertMsg;
	}
	public String checkCustomerFilter()
	{
		waitForElementToBeClickableThenClick(showfilterBtn);
		waitForElementToBeClickableThenClick(CustomerFilterOption);
		String filterType=CustomerFilterOption.getText();
		if(filterType!=null)
			return filterType;
		else
			return null;
	}
	public void filterHere(String ID)
	{
		waitForElementToBeClickableThenClick(showfilterBtn);
		waitForElementToBeClickableThenClick(IDfilterOption);
		waitForElementToBeClickableThenClick(equalsOption);
		waitForElementToBeClickableThenSendkeys(tenantIdFilter,ID);
	}


	public void continueExecution() throws InterruptedException {
		waitForElementToBeClickableThenClick(OKbutton);
		sleepMin();
		waitForElementToBeClickableThenClick(cancelBtn);
		sleepMin();
	}

	public void continueExecution2() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(cancelBtn);
		sleepMin();

	}

//VMM_3274
	public void clickOnNew() {
		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForAngularRequestsToFinish();
	}

	public boolean checkCloudDeploymentType(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenSendkeys(deploymentTypeDrp,"");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(deploymentTypeDrp, testData.get("DeploymentType"));
		sleepMin();
		String AType1 =getWebelementText(cloudCommercialoption);
		sleepMin();
		waitForElementToBeClickableThenClick(cloudGovoption);
		sleepMin();
		String AType2 =getWebelementText(cloudGovoption);
		sleepMin();
		waitForElementToBeClickableThenClick(deploymentTypeDrp);
		sleepMin();
		System.out.println(AType1+" "+testData.get("DeploymentType")+"\n"+AType2+" "+testData.get("DeploymentType2"));

		if(AType1.equalsIgnoreCase(testData.get("DeploymentType")) && AType2.equalsIgnoreCase((testData.get("DeploymentType2"))))
		{
			return true;
		}
		else
			return false;
	}


///VMM_3699

	public void editTenantAdminEmail(Map<String, String> testData) {
		waitForAngularRequestsToFinish();

		filterHere(testData.get("TenantID").toLowerCase());

		waitForElementToBeClickableThenClick(FilterBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(EditButton);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClearThenSendkeys(adminEmail, testData.get("EditedAdminEmail"));
	}

	///VMM_3572

	public String verifyTenantTextLength(Map<String, String> testData) throws InterruptedException {

		waitForAngularRequestsToFinish();

		 String CustomerSavedId = testData.get("TenantID").substring(0, Math.min(testData.get("TenantID").length(), 20));

		filterHere(CustomerSavedId.toLowerCase());

		waitForElementToBeClickableThenClick(FilterBtn);

		waitForAngularRequestsToFinish();
		sleepMin();

		String ActualID = getWebelementText(tenantId);

		return ActualID;
	}

//**********************************


//surya------------------------------------VMM-3277---------------------------------------
public void deleteTheTenant(Map<String, String> testData) throws InterruptedException
{   waitForAngularRequestsToFinish();
	waitForElementToBeClickableThenClick(deleteButton);
	sleepAvg();
}


public String deleteTenantConformation(Map<String, String> testData) throws InterruptedException
{   waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(DeleteConfirmBtnfleet);
    String alertMsg = Alertpopup.getText();
    sleepAvg();
    return alertMsg;

}



//--------------------------------Melroy 3405-----------------------------------------
public void createNewTenantLicense(Map<String, String> testData) throws Exception
{
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(createNewTenantBtn);
		waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));
		selectListByVisibleText(tenantTypeDrp, testData.get("TenantType"));
		waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));
		selectListByVisibleText(deploymentTypeDrp, testData.get("DeploymentType"));
		//sleepMin();
		waitForElementToBeClickableThenClick(customerTxt);
		waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));
			waitForElementToBeClickableThenClick(stateField);
			waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
			waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenClick(syncWithTMChk);
		waitForElementToBeClickableThenClick(tenantSaveBtn);
		waitForAngularRequestsToFinish();
	}

}

  public void createNewTenantSyncToTMOFF(Map<String, String> testData) throws Exception
  {
    {
      waitForAngularRequestsToFinish();
      waitForElementToBeClickableThenClick(createNewTenantBtn);
      waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));
      selectListByVisibleText(tenantTypeDrp, testData.get("TenantType"));
      waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));
      selectListByVisibleText(deploymentTypeDrp, testData.get("DeploymentType"));
      //sleepMin();
      waitForElementToBeClickableThenClick(customerTxt);
      waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
      waitForElementToBeClickableThenClick(suggestionRowFirstValue);

      waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));
      waitForElementToBeClickableThenClick(stateField);
      waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
      waitForElementToBeClickableThenClick(suggestionRowFirstValue);

      //waitForElementToBeClickableThenClick(syncWithTMChk);
      //waitForElementToBeClickableThenClick(tenantSaveBtn);
      //waitForAngularRequestsToFinish();
    }

  }

//------------------------------------Sunilkumar(VMM4423)--------------------------------
public void clickdeviceType(Map<String, String> testData) throws Exception {
	sleepAvg();
	//waitForElementToBeClickableThenClick(deviceTypeTxtfield);
	sleepMin();
	selectListByVisibleText(deviceTypeTxtfield, testData.get("Device Type"));
	sleepAvg();
}

public void assignMultipledevice(Map<String, String> testData) throws Exception
{
	sleepAvg();
	driver.findElement(By.xpath("//td[text()='"+testData.get("Device ID")+"']/..//div")).click();
	sleepAvg();
	driver.findElement(By.xpath("//td[text()='"+testData.get("Device ID2")+"']/..//div")).click();
	sleepMin();
	waitForElementToBeClickableThenClick(assign);
	sleepMin();


}

//---------------------------------Sunilkumar(4464)-------------------------
public void assigndevicesettinginTenantpage(Map<String, String> testData) throws Exception // assigndevicesettingTxtfield
{

	waitForAngularRequestsToFinish();
	waitForElementToBeClickableThenClick(assigndevicesettingTxtfield);
	WebElement assignSettings=driver.findElement(By.xpath("//div[contains(text(),'"+testData.get("Setting")+"')]"));
	waitForElementToBeClickableThenClick(assignSettings);
	waitForAngularRequestsToFinish();

}


public void assigndevice(Map<String, String> testData) throws Exception
{

	driver.findElement(By.xpath("//td[text()='"+testData.get("Device ID")+"']/..//div")).click();
	sleepMin();
	waitForElementToBeClickableThenClick(assign);
	sleepMAX();

}




	//Rajath  VMM-3326------------------------------------------------------------

public void TenantCreate (Map<String, String> testData) throws InterruptedException {
	sleepAvg();

	waitForElementToBeClickableThenClick(createNewTenantBtn);
	sleepMAX();

	waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));
	sleepMAX();

	waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("TenantType"));
	sleepMAX();

	waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));
	sleepMAX();

	selectListByVisibleText(deploymentTypeDrp, testData.get("DeploymentType"));
	sleepMAX();

	waitForElementToBeClickableThenClick(customerTxt);
		waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));
		//if(env.equals("DEV")) {
		waitForElementToBeClickableThenClick(stateField);
		waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
	//}
	sleepMAX();
}


	public void clickOnTenantsave() throws InterruptedException {
	waitForElementToBeClickableThenClick(savebutton);
	sleepMAX();

}


//surya------------------------------VMM-3265-------------------------------

public boolean deleteTenantCommercial(Map<String, String> testData) throws InterruptedException {
	sleepMAX();
	String DeletID = tenantId.getText();
	sleepMin();
	System.out.println("want to delete :"+DeletID);
	if(DeletID.equalsIgnoreCase(testData.get("DeleteTenantCommercial")))
	{
		waitForElementToBeClickableThenClick(deleteButton);
		sleepMin();
		return true;
	}
	else {
		return false;
	}

}

public boolean deleteTenantGoverment(Map<String, String> testData) throws InterruptedException {
	sleepMAX();
	String DeletID = tenantId.getText();
	sleepMin();
	System.out.println("want to delete :"+DeletID);
	if(DeletID.equalsIgnoreCase(testData.get("DeleteTenantGoverment")))
	{
		waitForElementToBeClickableThenClick(deleteButton);
		sleepMin();
		return true;
	}
	else {
		return false;
	}

}


//---------------------------------------------------------Nitin-------------------------------------------------------//
public boolean editableOrNotEditableDeploymentType() throws InterruptedException
{
	waitForAngularRequestsToFinish();
	waitForAngularRequestsToFinish();
	if(firstTenantIDDeploymentType.isEnabled())
	{
		return true;
	}
	else
	{
		return false;
	}
}

public boolean verifyFilledTenantId()
{
	String text = filledTenantId.getText();
	if(text.length() <= 20)
	{
		return true;
	}
	return false;
}

public void filterTenantByID(Map<String, String> testData) throws InterruptedException
{
	waitForElementToBeClickableThenClick(showfilterBtn);
	waitForElementToBeClickableThenClick(IDfilterOption);
	waitForElementToBeClickableThenClick(equalsOption);
	waitForElementToBeClickableThenSendkeys(tenantIdFilter,testData.get("TenantID"));
	waitForElementToBeClickableThenClick(filterButton);
	waitForAngularRequestsToFinish();
	waitForAngularRequestsToFinish();
	waitForAngularRequestsToFinish();
}

public void createNewTenantWithAssigningOfDevice() throws InterruptedException {
	waitForAngularRequestsToFinish();

	selectListByIndex(deviceTypeDropDown, 11);

	scrollToElement("(//span[@class='check'])[3]");

	waitForAngularRequestsToFinish();

	waitForElementToBeClickableThenClick(firstDeviceCheckBox);

	waitForAngularRequestsToFinish();

	waitForElementToBeClickableThenClick(assign);

	waitForAngularRequestsToFinish();

}

public void createANewTenant(Map<String, String> testData) throws InterruptedException {

	waitForAngularRequestsToFinish();
	waitForElementToBeClickableThenClick(createANewTenant);
	waitForElementToBeClickableThenSendkeys(tenantIDTxt, testData.get("TenantID"));
	sleepAvg();
	waitForElementToBeClickableThenSendkeys(tenantTypeDrp, testData.get("TenantType"));
	sleepMin();
	waitForElementToBeClickableThenSendkeys(tenantNameTxt, testData.get("TenantName"));
	waitForElementToBeClickableThenSendkeys(deploymentTypeDrp, testData.get("DeploymentType"));
	waitForElementToBeClickableThenClick(customerTxt);
	waitForElementToBeClickableThenSendkeys(customerTxtBox, testData.get("Customer"));
	waitForElementToBeClickableThenClick(suggestionRowFirstValue);
	waitForElementToBeClickableThenSendkeys(adminEmail, testData.get("AdminEmail"));
	//if(env.equals("DEV")) {
	waitForElementToBeClickableThenClick(stateField);
	waitForElementToBeClickableThenSendkeys(stateTxtBox, testData.get("State"));
	waitForElementToBeClickableThenClick(suggestionRowFirstValue);
//}
	waitForElementToBeClickableThenClick(syncWithTMCheckBox);
	//waitForAngularRequestsToFinish();
}
public void clickOnSaveButtonn() throws InterruptedException
{
	waitForElementToBeClickableThenClick(saveButtonn);
	waitForAngularRequestsToFinish();
}
//---------------------------------------------------------Nitin-------------------------------------------------------//



//surya--------------------------------VMM-3878---------------------------------------------------------


//tenantTypeinTenantpage
 ArrayList<String> ActualTenenatTypeDropDwnValues=new ArrayList<String>();

 ArrayList<String> ExpectedTenenatTypeDropDwnValues=new ArrayList<String>();




public List[] verifyTenatTypeDropTownOrderINTenant() throws InterruptedException {
	sleepAvg();
	waitForElementToBeClickableThenClick(TenenatTypeDropDwn);
	sleepAvg();

	 for(int i=0;i<TenenatTypeDropDwnValues.size();i++) {

		 String TenenatTypeDropDwnText = TenenatTypeDropDwnValues.get(i).getText();

		 ActualTenenatTypeDropDwnValues.add(TenenatTypeDropDwnText);


	 }
	 ExpectedTenenatTypeDropDwnValues=ActualTenenatTypeDropDwnValues;
	 Collections.sort(ExpectedTenenatTypeDropDwnValues);
	 return new List[] {ActualTenenatTypeDropDwnValues,ExpectedTenenatTypeDropDwnValues};
}

//DeploymentTypeinTenantpage

ArrayList<String> ActualDeploymentTypeDropDwnValues=new ArrayList<String>();

ArrayList<String> ExpectedDeploymentTypeDropDwnValues=new ArrayList<String>();




public List[] verifyDeploymentTypeDropTownOrderINTenant() throws InterruptedException {
	sleepAvg();
	waitForElementToBeClickableThenClick(DeploymentTypeDropDwn);
	sleepAvg();
	 for(int i=0;i<DeploymentDropDwnValues.size();i++) {

		 String DeploymentTypeDropDwnText = DeploymentDropDwnValues.get(i).getText();

		 ActualDeploymentTypeDropDwnValues.add(DeploymentTypeDropDwnText);


	 }
	 ExpectedDeploymentTypeDropDwnValues=ActualDeploymentTypeDropDwnValues;
	 Collections.sort(ExpectedDeploymentTypeDropDwnValues);
	 return new List[] {ActualDeploymentTypeDropDwnValues,ExpectedDeploymentTypeDropDwnValues};
}

//SalesRegionInTenantPage

ArrayList<String> ActualSalesRegionDropDwnValues=new ArrayList<String>();

ArrayList<String> ExpectedSalesRegionDropDwnValues=new ArrayList<String>();




public List[] verifySalesRegionDropTownOrderINTenant() throws InterruptedException {
	sleepAvg();
	waitForElementToBeClickableThenClick(SalesRegionTypeDropDwn);
	sleepAvg();
	 for(int i=0;i<SalesRegionTypeDropDwnValues.size();i++) {

		 String SalesregionTypeDropDwnText = SalesRegionTypeDropDwnValues.get(i).getText();

		 ActualSalesRegionDropDwnValues.add(SalesregionTypeDropDwnText);


	 }
	 ExpectedSalesRegionDropDwnValues=ActualSalesRegionDropDwnValues;
	 Collections.sort(ExpectedDeploymentTypeDropDwnValues);
	 return new List[] {ActualSalesRegionDropDwnValues,ExpectedSalesRegionDropDwnValues};
}


//statusDropDownInTenantPage


ArrayList<String> ActualstatusDropDwnValues=new ArrayList<String>();

ArrayList<String> ExpectedstatusDropDwnValues=new ArrayList<String>();




public List[] verifyStatusDropTownOrderINTenant() throws InterruptedException {
	sleepAvg();
	waitForElementToBeClickableThenClick(StatusTypeDropDwn);
	sleepAvg();
	 for(int i=0;i<StatusTypeDropDwnValues.size();i++) {

		 String stausTypeDropDwnText = StatusTypeDropDwnValues.get(i).getText();

		 ActualstatusDropDwnValues.add(stausTypeDropDwnText);


	 }
	 ExpectedstatusDropDwnValues=ActualstatusDropDwnValues;
	 Collections.sort(ExpectedstatusDropDwnValues);
	 return new List[] {ActualstatusDropDwnValues,ExpectedstatusDropDwnValues};
}


public void scrollToStatus() throws Exception {
	scrollToElement("//*[text()='Anniversary Date' and @class='ui-grid-header-cell-label ng-binding']");
	sleepMin();
	scrollToElement("//*[text()='Status' and @class='ui-grid-header-cell-label ng-binding']");
}


//----------------------------------ended-------------------------------------------------



 //Rajath VMM_3592-----------------------------------------------------
public void TenantSearch (Map<String, String> testData) throws InterruptedException {

	 waitForAngularRequestsToFinish();

	 waitForElementToBeClickableThenClick(showfilterBtn);

	 selectListByVisibleText(filterFieldsDrp, "Tenant ID");

	 selectListByVisibleText(filterOperationsDrp, "equals");

	 waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));


	 sleepMAX();

	 waitForElementToBeClickableThenClick(filterBtn);

	 sleepMAX();

	/* waitForElementToBeClickableThenClick(clickClear);

   selectListByVisibleText(filterFieldsDrp, "Tenant ID");

	 selectListByVisibleText(filterOperationsDrp, "equals");
	 sleepMin();
	 waitForElementToBeClickableThenClearThenSendkeys(tenantTxt,"");
	 sleepMAX();
	 */


}

public void TenantSearchWithClearValue (Map<String, String> testData) throws InterruptedException {
		 waitForElementToBeClickableThenClick(clickClear);
		 sleepMin();

	     selectListByVisibleText(filterFieldsDrp, "Tenant ID");

		 selectListByVisibleText(filterOperationsDrp, "equals");
		 sleepMin();
		 waitForElementToBeClickableThenClearThenSendkeys(tenantTxt,"");
		 sleepMin();
	}


//Rajath VMM_4578-------------------------------------------------------------------
  public void TenantIdsearch (Map<String, String> testData) throws InterruptedException {
	 sleepAvg();
	 selectListByVisibleText(tenantidfield, testData.get("TenantID").toLowerCase());
	 sleepAvg();
  }


//Rajath VMM_4579-------------------------------------------------------------------

	 public void clickOnTenantEdit () throws InterruptedException {
		 waitForElementToBeClickableThenClick(tenanteditbtn);
		 sleepMin();
	 }


	 public void selectDeviceType(Map<String, String> testData) throws InterruptedException {
		 sleepMAX();
		 selectListByVisibleText(DeviceTypeSelect,testData.get("DeviceType"));
		 sleepMin();
		 waitForElementToBeClickableThenClearThenSendkeys(DeviceIDSelect,testData.get("DeviceID"));
		 sleepMAX();
		 waitForElementToBeClickableThenClick(checkbox);
		 sleepMin();
		 waitForElementToBeClickableThenClick(assignbtn);
		 sleepMin();
	 }

	 public void navigateToTenantCheck() throws InterruptedException {
		 waitForElementToBeClickableThenClick(TenantsTabCheck);
		 sleepMAX();
		 sleepMin();

	 }

	 public Boolean AssignDeviceSettingBtn() {

	        if (verifyassignsettingbtn.isEnabled()) {

				return true;
			}
			return false;
	 }



	 public void selectUnAssignBtn () throws InterruptedException {
		 waitForElementToBeClickableThenClick(unassigncheckbox);
		 sleepMAX();
		 waitForElementToBeClickableThenClick(unassignButton);
		 sleepMAX();
		 //waitForElementToBeClickableThenClick(savebtn);
		 //sleepMin();

	 }



	 public Boolean AssignDeviceSettingDisabledBtn() {

	        if (Settingicondisabled.isDisplayed()) {

				return true;
			}
			return false;
	 }


	 public void clickemptyTextFieldBtn(Map<String, String> testData) throws Exception // assigndevicesettingTxtfield
	 {
	 waitForAngularRequestsToFinish();
	  waitForElementToBeClickableThenClick(deviceassigntxtfield);
	  WebElement assignSettings=driver.findElement(By.xpath("//div[contains(text(),'"+testData.get("Setting")+"')]"));
	  waitForElementToBeClickableThenClick(assignSettings);
	 waitForAngularRequestsToFinish();
	 }




	   //Rajath VMM_3656----------------------------------------------


	 public void clickOnTenantShowfilter () throws InterruptedException {
		 waitForElementToBeClickableThenClick(tenantshowfilter);
		 sleepMin();
	 }
	//////1--------
	 public void TenantFilter () throws InterruptedException {

		 waitForAngularRequestsToFinish();

		 selectListByVisibleText(filterFieldsDrp, "Tenant ID");
	 }

	 public String VerifyTenantIDFilterDropDown() {

			String verifytenantIDtext=tenanttext.getText();
         	return verifytenantIDtext;
	 }
	 public String VerifyTenantRow() {

			String verifytenantIDtext=tenantIDRow.getText();
			return verifytenantIDtext;

	 }
	 public void RefreshTenantPage () {
			driver.navigate().refresh();
			waitForAngularRequestsToFinish();
			waitForAngularRequestsToFinish();

	 }




	 /////2--------
     public void TenantTypeFilter () throws InterruptedException {

		 waitForAngularRequestsToFinish();
		 waitForAngularRequestsToFinish();
		 selectListByVisibleText(filterFieldsDrp, "Tenant Type");
     }

     public String VerifyTenantTypeFilterDropDown() {

			String verifytenantTypetext=tenanttypetext.getText();
      	    return verifytenantTypetext;
     }

     public String VerifyTenantTypeRow() {

			String verifytenantTypetext=tenanttypeRow.getText();
			return verifytenantTypetext;
	 }


     ////3--------

     public void SalesRegionFilter () throws InterruptedException {

		 //waitForAngularRequestsToFinish();
		 //waitForAngularRequestsToFinish();
		 selectListByVisibleText(filterFieldsDrp, "Sales Region");
     }

     public String VerifySalesRegionFilterDropDown() {

			String verifysalesregiontext=salesregiontext.getText();
      	    return verifysalesregiontext;
     }

     public String VerifyeSalesRegionRow() {

			String verifysalesregiontext=salesregionRow.getText();
			return verifysalesregiontext;
     }
    ////4-----------
     public void StateFilter () throws InterruptedException {

		 //waitForAngularRequestsToFinish();
		 //waitForAngularRequestsToFinish();
		 selectListByVisibleText(filterFieldsDrp, "State");
     }
     public String VerifyStateFilterDropDown() {

			String verifystatetext=statetext.getText();
   	        return verifystatetext;
  }

     public String VerifyeStateRow() {

			String verifystatetext=stateRow.getText();
			return verifystatetext;
     }

     /////5----------
	 public void CustomerFilter () throws InterruptedException {

	     // waitForAngularRequestsToFinish();
		  selectListByVisibleText(filterFieldsDrp, "Customer");
	 }
     public String VerifyCustomerFilterDropDown() {

			String verifycustomertext=customertext.getText();
   	        return verifycustomertext;
  }

     public String VerifyCustomerRow() {

			String verifycustomertext=customerRow.getText();
			return verifycustomertext;

     }

     ////6---------------
     public void deploymenttypeFilter () throws InterruptedException {

	      //waitForAngularRequestsToFinish();
		  //waitForAngularRequestsToFinish();
		  selectListByVisibleText(filterFieldsDrp, "Deployment Type");
     }
     public String VerifydeploymenttypeFilterDropDown() {

			String verifydeploymenttypetext=deploymenttypetext.getText();
	        return verifydeploymenttypetext;
  }

     public String VerifydeploymenttypeRow() {

			String verifydeploymenttypetext=deploymenttypeRow.getText();
			return verifydeploymenttypetext;
     }


     /////7-----
     public void AnniversaryDateFilter () throws InterruptedException {

	     // waitForAngularRequestsToFinish();
		  //waitForAngularRequestsToFinish();
		  selectListByVisibleText(filterFieldsDrp, "Anniversary Date");
    }
     public String VerifyAnniversarDateyFilterDropDown() {

			String verifyanniversarydattext=anniversarydatetext.getText();
	        return verifyanniversarydattext;
 }

     public String VerifyAnniversaryDateRow() {

			String verifyanniversarydattext=anniversarydateRow.getText();
			return verifyanniversarydattext;
    }
     ////8------
     public void StatusFilter () throws InterruptedException {

	     // waitForAngularRequestsToFinish();
		  //waitForAngularRequestsToFinish();
		  selectListByVisibleText(filterFieldsDrp, "Status");
   }
     public String VerifyStatusFilterDropDown() {

			String verifystatustext=statustext.getText();
	        return verifystatustext;
}

     public String VerifyStatusDateRow() {

			String verifystatustext=statusRow.getText();
			return verifystatustext;


     }

	  //RajathVMM-4758------------------------------------------------------

     public void clickOnTenantViewBtn ()  {
		 waitForElementToBeClickableThenClick(tenantview);
		 waitForAngularRequestsToFinish();
     }

	 public String VerifyCretedTenant() {
			String verifytenanttext=tenantverify.getText();
			return verifytenanttext;
     }

     public void clickOnTenantBackBtn () throws InterruptedException {
		 waitForElementToBeClickableThenClick(tenantbackbtn);
		 sleepMin();
     }

	 public void clickOnAssignSave () throws InterruptedException {
		 waitForElementToBeClickableThenClick(saveassigndevice);
		 sleepMin();
     }


	  public void selectDeviceTypeandDeviceID(Map<String, String> testData) throws InterruptedException {
		 sleepMAX();
		 selectListByVisibleText(devicetypeselect,testData.get("DeviceType"));
		 sleepMin();
		 waitForElementToBeClickableThenClearThenSendkeys(deviceIDselect,testData.get("DeviceID"));
		 sleepMAX();
		 waitForElementToBeClickableThenClick(checkbox);
		 sleepMin();

	 }




//Savitha
	  public boolean verifyMandatoryFieldsInNewTenantScreen() throws InterruptedException {

		  if( mandatoryFieldTenantId.isDisplayed() &&
				  mandatoryFieldTenantType.isDisplayed() &&
				  mandatoryFieldTenantName.isDisplayed() &&
				  mandatoryFieldDeploymentType.isDisplayed() &&
				  mandatoryFieldCustomer.isDisplayed() &&
				  mandatoryFieldAdminEmail.isDisplayed() &&
				  mandatoryFieldState.isDisplayed()
				  )
			  return true;

		  return false;


		}

		public void searchTenantsWithMultiCondition(Map<String, String> testData) throws InterruptedException {

			waitForElementToBeClickableThenClick(showFiltersBtn);

			selectListByVisibleText(conditionField1,testData.get("Filter1"));
			selectListByVisibleText(conditionOperation1,testData.get("FilterOperation1"));
			waitForElementToBeClickableThenClearThenSendkeys(conditionFieldValue1,testData.get("FilterValue1"));

			waitForElementToBeClickableThenClick(AddConditionBtn);
			selectListByVisibleText(conditionField2,testData.get("Filter2"));
			//waitForElementToBeClickableThenClick(conditionFieldValue2);
			selectListByVisibleText(conditionFieldValue2,testData.get("FilterValue2"));

			waitForElementToBeClickableThenClick(AddConditionBtn);
			waitForElementToBeClickableThenClick(conditionField3);
			selectListByVisibleText(conditionField3,testData.get("Filter3"));
			waitForElementToBeClickableThenClick(conditionFieldValue3);
			selectListByVisibleText(conditionFieldValue3,testData.get("FilterValue3"));

			waitForElementToBeClickableThenClick(filterBtn);
		  	waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(hideFiltersBtn);

		}

		 public String getTenantIDFromViewScreen() {

				return tenantIdTxt.getText();
		 }

		 public String getDeploymentTypeFromViewScreen() {

				return deploymentTypeTxt.getText();
		 }

		 public String getTenantTypeFromViewScreen() {

				return tenantTypeTxt.getText();
		 }





}
