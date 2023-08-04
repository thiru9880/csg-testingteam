package safefleetLM.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;


public class LicensesPage extends ReusableLibrary
{
  WebDriver driver;

  public LicensesPage(WebDriver driver) {
    super(driver);
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }

  //(//select[@id='field_software'])[1]

  @FindBy(xpath="(//span[normalize-space()='New'])[1]")
  WebElement createNewBtn;

  @FindBy(xpath="(//div[@name='fleetId']//span)[1]")
  WebElement tenantID;
//
@FindBy(xpath="//*[@id='field_fleet_id']//input[@type='search']")
WebElement tenantIDTextBox;

  @FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
  WebElement suggestionRowFirstValue;

  @FindBy(xpath="(//select[@id='field_software'])[1]")
  WebElement baseProduct;

  @FindBy(xpath="(//select[@id='field_slotType'])[1]")
  WebElement licenseType;

  @FindBy(xpath="(//input[@id='field_partnum'])[1]")
  WebElement part;

  @FindBy(xpath="(//select[@id='field_chargeType'])[1]")
  WebElement chargeType;

  @FindBy(xpath="//*[@id='field_server']")
  WebElement serverDrp;

  @FindBy(xpath="(//button[@id='save_btn'])[1]")
  WebElement saveBtn;

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

  @FindBy(xpath="//i[@class='ui-grid-icon-plus-squared']")
  WebElement tenantIDExp;

  @FindBy(xpath="//*[@id='new_license_btn']/span")
  WebElement newLicenseBtn;

  @FindBy(xpath="//*[@id='field_fleet_id']")
  WebElement tenantIDDrp;

  @FindBy(xpath="//*[@id='field_software']")
  WebElement baseProductDrp;

  @FindBy(xpath="//*[@id='field_slotType']")
  WebElement licenseTypeDrp;

  @FindBy(xpath="//*[@id='field_partnum']")
  WebElement partTxt;

  @FindBy(xpath="//*[@id='field_chargeType']")
  WebElement chargeTypeDrp;

  @FindBy(xpath="//*[@id='field_slot']")
  WebElement qtyTxt;

  @FindBy(xpath="//*[@id='save_btn']/span")
  WebElement saveLicenseBtn;

  @FindBy(xpath="//*[@id='cancel_btn']/span")
  WebElement cancleLicenseBtn;

  @FindBy(xpath="//*[@id='field_startDate'][@aria-required='false']")
  WebElement inauguralDateField;

////// Dilip xpath changes

@FindBy(xpath="(//*[contains(@id,'split-button-1')])[1]")
WebElement actionsBtn;

  @FindBy(xpath="(//*[contains(@id,'split-button-1')])[2]")
  WebElement actionsBtn2;

  @FindBy(xpath="(//*[contains(@id,'split-button-1')])[3]")
  WebElement actionsBtn3;

  @FindBy(xpath="//*[contains(@id,'menu_link_cloud_1')]/span")
  WebElement publishBtn;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cloud_1')]/span)[2]")
  WebElement publishBtn2;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cloud_1')]/span)[3]")
  WebElement publishBtn3;

  @FindBy(xpath="(//*[contains(@aria-labelledby,'split-button-1')]/li[2]/a)[1]")
  WebElement editBtn;
//0000
@FindBy(xpath="//*[contains(@aria-labelledby,'split-button-1')]/li[2]")
WebElement editBtn2;


  @FindBy(xpath="//*[@class='bootbox modal fade in']//span[@style='color:red;']")
  WebElement warningPopup;

  @FindBy(xpath="/html/body/div[3]/div/div/div[3]/button[2]")
  WebElement warningOKBtn;

  @FindBy(xpath="//*[@id='outer']//div[@class='ui-grid-contents-wrapper']//*[text()='PUBLISHED']")
  WebElement publishStatus;

  @FindBy(xpath="//*[@id=\"field_startDate\"]")
  WebElement inaugaralDateTxt;

  @FindBy(xpath="/html/body/div[3]/div/div/div[3]/button[2]")
  WebElement appLicensePublishOKBtn;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cancel_1')]/span)[7]")
  WebElement terminateBtn;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cancel_1')]/span)[5]")
  WebElement terminateBtn2;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cancel_1')]/span)[3]")
  WebElement terminateBtn3;

  @FindBy(xpath="(//*[contains(@id,'menu_link_return_1')]/span)[10]")
  WebElement returnBtn;

  @FindBy(xpath="(//*[contains(@id,'menu_link_return_171')]/span)[8]")
  WebElement returnBtn2;

  @FindBy(xpath="(//*[contains(@id,'menu_link_return_171')]/span)[9]")
  WebElement returnBtn3;

  @FindBy(xpath="//*[@class='btn btn btn-primary btn-xs menu-button']/i")
  WebElement menuBtn;

  @FindBy(xpath="(//*[contains(@aria-labelledby,'split-button-171')]/li[3]/a)[1]")
  WebElement settingsBtn;


  ////3953

  @FindBy(xpath="(//div[@class='ui-grid-tree-base-row-header-buttons ng-scope ui-grid-icon-plus-squared'])[1]")
  WebElement expandBtn;

  @FindBy(xpath="(//input[@id='field_slot'])[1]")
  WebElement Quantity;

  @FindBy(xpath="(//select[@id='field_server'])[1]")
  WebElement server;


  //surya--------------------------------VMM-3331


  @FindBy(xpath="(//ul[@role='menu']//span[text()='Terminate'])")
  List<WebElement> TeriminateBTNF;

  @FindBy(xpath="//*[contains (@id,'downloadFile')]")
  WebElement DownloadTerminateLicenseCheckBox;

  @FindBy(xpath="//button[normalize-space()='Ok']")
  WebElement TeriminateOKbtn;

  //surya-------------------VMM-4677
  @FindBy(xpath="(//button[contains(text(),'Actions')])[7]")
  WebElement ActionBtnSFCommander;

  ////3584


  @FindBy(xpath="(//span[@class='caret'])[4]")
  WebElement actionBtn3584;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cloud_1')]/span)[1]")
  WebElement publishBtn3584;

  @FindBy(xpath="//button[normalize-space()='Ok']")
  WebElement okBtnToPublish;


  @FindBy(xpath="(//span[@class='caret'])[6]")
  WebElement actionBtn3584_1;

  @FindBy(xpath="(//*[contains(@id,'menu_link_cloud_1')]/span)[2]")
  WebElement publishBtn3584_1;

  //
  @FindBy(xpath="(//button[normalize-space()='Ok'])[1]")
  WebElement okBtn;

  ///3412

  @FindBy(xpath="(//i[@class='material-icons'][normalize-space()='visibility'])[6]")
  WebElement eyeBtn3412_1;

  @FindBy(xpath="(//span[@class='ng-binding'][normalize-space()='Base App'])[1]")
  WebElement License3412_1;


  @FindBy(xpath="//span[@title='Student Tracking'][@aria-hidden='false']")
  WebElement License3412_2;

  @FindBy(xpath="//span[@title='Zonar Integration'][@aria-hidden='false']")
  WebElement License3412_3;

  @FindBy(xpath="//span[@title='Transfinder Integration'][@aria-hidden='false']")
  WebElement License3412_4;

  @FindBy(xpath="//input[@id='field_addAnother']//..//span[@class='check']")
  WebElement addAnotherBtn;

  @FindBy(xpath="(//input[@id='field_expiryDate'])[1]")
  WebElement expiryDate;

  @FindBy(xpath="(//span[@class='check'])[1]")
  WebElement showAllFeildBtn;

  @FindBy(xpath="(//div[@role='button'])[24]")
  WebElement viewExpiryDate;

//surya-------------------------------3277---------------------------------------
//*[@id='field_fleet_id']
@FindBy(xpath="//*[@id='field_fleet_id']")
WebElement EnterTenetIdField;

  @FindBy(xpath="(//select[@id='field_softwareLicense'])[1]")
  WebElement SoftwareVersion;

  @FindBy(xpath="//*[@id='field_dataAmount']")
  WebElement DataamountField;

  @FindBy(xpath="//*[@id='field_slot']")
  WebElement Qtyfield;

  @FindBy(xpath="//*[contains(text(),'Show Filters')]")
  WebElement showFilterBtn;

  @FindBy(xpath="//*[@class='ui-grid-filter-input ui-grid-filter-input-0 ng-dirty ng-valid-parse ng-touched']")
  WebElement EnterTenantid;

  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
  WebElement selectEquals;

  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
  WebElement EnterTenantIDValue;

  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
  WebElement selectTenetID;

  @FindBy(xpath="//div/span[text()='Status']/..//..//select")
  WebElement selectStatus;

  @FindBy(xpath="//i[@class='ui-grid-icon-plus-squared']")
  WebElement ExpandLicense;

  @FindBy(xpath="(//span[@class='caret'])[4]")
  WebElement ClickActionBtn;

  @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='delete'])[4]/following::span[1]")
  WebElement ClickDeleteActionBtn;


  @FindBy(xpath="(//i[@class='material-icons text-danger'][normalize-space()='delete'])[8]")
  WebElement ClickDeleteActionBtn2;

  @FindBy(xpath="//*[@id='license_delete_btn']")
  WebElement ClickDeletePopup;

  @FindBy(xpath="//pre[@class='ng-binding ng-scope']")
  WebElement LicenseAlertMessage;

  @FindBy(xpath="//input[@id='field_dataAmount']")
  WebElement VerifyDataAmountField;

  @FindBy(xpath="//button[@id='save_btn']")
  WebElement VerifySaveBtnInLisense;

  //----------------------------------------------------------------------------------------------------


  ////////////terminate License

  @FindBy(xpath="(//*[contains(@id,'menu_link_cancel_1')]/span)[1]")
  WebElement terminateButton;



  @FindBy(xpath="(//span[text()='Publish'])[42]")
  WebElement publishSecond;

//-------------------------------VMM-3405 Melroy---------------------------------
@FindBy(xpath = "//button[@class='btn btnShowFilterGroups btn-info btn-raised']")
WebElement clickShowFilter;

  @FindBy(xpath = "//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
  WebElement tentIdfield;

  @FindBy(xpath = "//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
  WebElement tenantOption;

  @FindBy(xpath = "//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
  WebElement tenantValue;

  @FindBy(xpath = "//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
  WebElement clickfilterBtn;

  @FindBy(xpath = "//button[@id='new_license_btn']")
  WebElement licenseNewBtn;

  @FindBy(xpath = "//select[@id='field_fleet_id']")
  WebElement licenseTenantID;

  @FindBy(xpath = "//select[@id='field_software']")
  WebElement licenseBaseP;

  @FindBy(xpath = "//select[@id='field_slotType']")
  WebElement licenseTypefield;

  @FindBy(xpath = "//input[@id='field_partnum']")
  WebElement licensePartNum;

  @FindBy(xpath = "//select[@id='field_chargeType']")
  WebElement licenseChargeType;

  @FindBy(xpath = "//select[@id='field_softwareLicense']")
  WebElement licenseSoftwareType;

  @FindBy(xpath = "//*[@id='field_identity_provider']/input")
  WebElement idpTextBox;

  @FindBy(xpath = "//*[@id='field_market_segment']//option[@selected='selected']")
  WebElement marketSegmentTxt;

  @FindBy(xpath = "//input[@id='field_slot']")
  WebElement selectQTY;

  @FindBy(xpath = "//button[@id='save_btn']")
  WebElement licenseSaveBtn;

  @FindBy(xpath = "//i[@class='ui-grid-icon-plus-squared']")
  WebElement clickonPlus;

  @FindBy(xpath = "(//span[@class='caret'])[4]")
  WebElement clickonActionBtn;

  @FindBy(xpath = "//ul[@role='menu']//span[text()='Publish']")
  List<WebElement> clickonPublishLS;

  @FindBy(xpath = "(//span[@class='ng-binding'][normalize-space()='Publish'])[31]")
  WebElement clickonPublish;

  @FindBy(xpath = "(//ul[@role='menu'])[16]")
  WebElement actionList;

  @FindBy(xpath = "//button[@id='split-button-170971']")
  WebElement clickonActionBtn2;

  @FindBy(xpath = "(//span[@class='ng-binding'][normalize-space()='Publish'])[7]")
  WebElement clickonPublish2;

  @FindBy(xpath = "(//input[@id='downloadFile-0'])[1]")
  WebElement checkDownloadbox;

  @FindBy(xpath = "//button[normalize-space()='Ok']")
  WebElement cliclOKBtn;

  @FindBy(xpath = "//div[@class='filterButtons']//button[@class='btn btn-danger btn-raised']")
  WebElement clickClear;
  //--------------------------------------------------------------------------------------------
  //-----------------------------VMM3283 Melroy-----------------------------------------------
  @FindBy(xpath = "//select[@id='field_server']")
  WebElement licensesServer;
  //-------------------------------------------------------------------------------------------------
//-------------------------------------VMM3385 Melroy-----------------------------------
  @FindBy(xpath = "//input[@id='field_addAnother']//..//span[@class='check']")
  WebElement addAnother;

  @FindBy(xpath = "(//span[@class='caret'])[4]")
  WebElement actionBtn1;

  @FindBy(xpath = "(//ul[@role='menu'][4]//span[text()='Publish'])[2]")
  WebElement clickonPublishL;

  @FindBy(xpath = "(//span[@class='caret'])[6]")
  WebElement actionBtn2;

  @FindBy(xpath = "(//ul[@role='menu'][6]//span[text()='Publish'])[2]")
  WebElement clickPublishF;
  //-------------------------------------------------------------------


//suryaaaa-----------------------VMM-3249-------------------------------------
@FindBy(xpath="/html/body/ul[16]/li[9]/a/span")
WebElement ClickAssignDeviceIcon;

  @FindBy(xpath="//select[@id='license_assign_devicetype_filter']")
  WebElement SelectDeviceTypeAssign;

  @FindBy(xpath="//select[@ng-model='searchedAvailableDevice.status']")
  WebElement SelectDeviceStatus;

  @FindBy(xpath="//select[@ng-model='searchedAvailableDevice.dataStatus']")
  WebElement SelectDataStatus;

  @FindBy(xpath="//button[@id='license_assign_btn']")
  WebElement ClickAssign;

  @FindBy(xpath="//i[@role='button']")
  WebElement SelectArrowDropDown;

  @FindBy(xpath="(//span[@class='ui-select-match-text pull-left'])[1]")
  WebElement SelectAssignDevicePopup;

  @FindBy(xpath="//div[contains(text(),'Core Controller')]")
  WebElement SelectCoreController;

  @FindBy(xpath="//span[@class='ng-scope'][normalize-space()='Assign Devices']")
  WebElement ConformAssignDevicePopup;

  @FindBy(xpath="//span[normalize-space()='Back']")
  WebElement ClickBackAfterAssginDevice;

  @FindBy(xpath="//button[@title='Settings']//i[@class='material-icons'][normalize-space()='settings']")
  WebElement SettingsIcon;

  @FindBy(xpath="//*[normalize-space()='View Device Settings']")
  WebElement VerifySettingPageText;

  @FindBy(xpath="//span[normalize-space()='NEW']")
  WebElement VerifyNewBTN;

  @FindBy(xpath="//*[normalize-space()='New Device Settings']")
  WebElement VerifyNewDeviceSettingPage;

  @FindBy(xpath="//span[normalize-space()='EDIT']")
  WebElement VerifyEditBTN;

  @FindBy(xpath="//*[normalize-space()='Edit Device Settings']")
  WebElement VerifyEditDeviceSettingPage;

  @FindBy(xpath="//span[normalize-space()='CLONE']")
  WebElement VerifyCloneBTN;

  @FindBy(xpath="//span[normalize-space()='CHANGE SETTINGS']")
  WebElement VerifyChangeSettingsBTN;

  @FindBy(xpath="//span[normalize-space()='Cancel']")
  WebElement CancelBtn;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Assign Devices'])")
  List<WebElement> AssignDeviceBTNF;

  @FindBy(xpath="//*[contains (@for,'checkAssingnedDevice')]//span[@class='check']")
  WebElement CheckBoxAssignDevice;

  @FindBy(xpath="//button[@id='license_unassign_button']")
  WebElement SelectUnAssign;

  @FindBy(xpath="//select[@id='unassign_status_select_field']")
  WebElement EnterNotAssigned;

  @FindBy(xpath="//span[normalize-space()='Unassign Devices']")
  WebElement ConformUnAssign;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Delete'])")
  List<WebElement> DeleteBTNF;

  @FindBy(xpath="//button[@id='license_delete_btn']")
  WebElement DeleteConformBtn;

  @FindBy(xpath="//span[@class='showHideFilters ng-binding']")
  WebElement ShowFilterBtnN;

  //t

  @FindBy(xpath="//input[@id='available']")
  WebElement DeviceIdFieldInAssign;

  //------------------------endeddd------------------------------------------



//-------------VMM_3361 Bhanu-------------------------------


  @FindBy(xpath ="//input[@id='field_addAnother']//..//span[@class='check']")
  WebElement AddAnotherCheckbox;

  @FindBy(xpath="//span[normalize-space()='(Published):']/../../../../../div/div[3]//span[@class='ng-binding']")
  List<WebElement> licenseTypeSText;

  @FindBy(xpath ="(//span[normalize-space()='(Published):']/../../../../div/div/div[1])[1]")
  WebElement tenantIdForLicenseOld;

  @FindBy(xpath ="(//span[@class='ng-binding ng-scope text-danger' or @class='ng-binding ng-scope'])[1]")//span[@class='ng-binding ng-scope text-danger']
  WebElement tenantIdForLicense;

  @FindBy(xpath="(//button[contains(text(),'Actions')])[6]")
  WebElement featureAppActionButton;

  @FindBy(xpath="(//ul[@role='menu'][6]//span[text()='Publish'])[1]")
  WebElement publishFAbtn;

  @FindBy(xpath="//button[text()='Ok']")
  WebElement publishOkBtn;

  @FindBy(xpath = "//pre[@class='ng-binding ng-scope']")
  WebElement Alertpopup;

  @FindBy(xpath="(//button[contains(text(),'Actions')])[4]")
  WebElement AppLicenseActionButton;

  @FindBy(xpath="(//ul[@role='menu'][4]//span[text()='Publish'])[1]")
  WebElement AppLicensePublishButton;
//

  @FindBy(xpath="//ul[@role='menu']//span[text()='Publish']")
  List<WebElement> AppLicensePublishButtonS;


  @FindBy(xpath="//input[@value='Download Licenses']")
  WebElement DownloadLicenseCheckBox;

  @FindBy(xpath="//label[contains(text(),'Download')]")
  WebElement DownloadLicenseCheckBox2;

  @FindBy(xpath="(//ul[@role='menu'][4]//span[text()='Edit'])[1]")
  WebElement AppLicenseEditeBtn;


  @FindBy(xpath="//ul[@role='menu']//span[text()='Edit']")
  List<WebElement> AppLicenseEditeBtnS;
  //
  @FindBy(xpath="(//ul[@role='menu'])//span[text()='Delete']")
  List<WebElement> AppLicenseDeleteBtns;


  @FindBy(xpath="(//ul[@role='menu'][10]//span[text()='Delete'])[1]")
  WebElement AppLicenseDeleteBtn;


  @FindBy(xpath="//button[@id='license_delete_btn']")
  WebElement AppLicenseDeleteConfirmBtn;

  @FindBy(xpath="//select[@id='field_status']")
  WebElement LicenseStatus;

  @FindBy(xpath="(//button[contains(text(),'Actions')])[4]")
  WebElement fordeleteFeatureActionBtn;

  @FindBy(xpath="(//ul[@role='menu'][16]//span[text()='Edit'])")
  WebElement FeatureAppEditBtn;

//
@FindBy(xpath="(//ul[@role='menu'])//span[text()='Edit']")
List<WebElement> FeatureAppEditBtnS;


  @FindBy(xpath="(//ul[@role='menu'][20]//span[text()='Delete'])")
  WebElement FeatureAppLicenseDeleteBtn;
//
@FindBy(xpath="(//ul[@role='menu']//span[text()='Delete'])")
List<WebElement> FeatureAppLicenseDeleteBtnS;

  @FindBy(xpath="//button[@id='license_delete_btn']")
  WebElement FeatureAppLicenseDeleteConfirmBtn;

  //VMM_3362
  @FindBy(xpath="(//button[contains(text(),'Actions')])[7]")
  WebElement vehicleLicenseActionBtn;

  @FindBy(xpath="((//ul[@role='menu'])[7]//span[text()='Publish'])[2]")
  WebElement vehicleLicensePublishBtn;

  @FindBy(xpath="(//ul[@role='menu'][7]//span[text()='Edit'])")
  WebElement vehicleLicenseEditBtn;

  @FindBy(xpath="(//ul[@role='menu'][7]//span[text()='Delete'])")
  WebElement vehicleLicenseDeleteBtn;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Publish'])")
  List<WebElement> vehicleLicensePublishBtnS;

  @FindBy(xpath="(//button[contains(text(),'Actions')])")
  List<WebElement> vehicleLicenseActionBtnS;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Edit'])")
  List<WebElement> vehicleLicenseEditBtnS;

  @FindBy(xpath="//ul[@role='menu']//span[text()='Delete']")
  List<WebElement> vehicleLicenseDeleteBtnS;

  @FindBy(xpath="//ul[@role='menu']//span[text()='Generate Keys']")
  List<WebElement> generateKeysButton;

  @FindBy(xpath="//span[text()='API Client']")
  WebElement ApiClientText;
//
@FindBy(xpath="//th[text()='Tenant Id']/../../tr[2]//kendo-grid-filter-wrapper-cell//input")//input[@class='k-textbox ng-pristine ng-valid ng-touched']
  WebElement TMfilterCheckBox;

  @FindBy(xpath="//tbody/tr[1]/td[1]")//td[@data-kendo-grid-column-index='0' and @colspan='1']
  WebElement TMtenantIdTxt;

  @FindBy(xpath="//tbody/tr[1]/td[2]")
  WebElement TMClientNameTxt;

  @FindBy(xpath="//tbody/tr[1]/td[3]")
  WebElement TMApiClientIdTxt;


  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
  WebElement selectTenetIDB;

  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
  WebElement selectEqualsB;

  @FindBy(xpath="//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
  WebElement EnterTenantIDValueB;

///4394
@FindBy(xpath="//div[@ng-class='headerButtonClass()']")
WebElement ExpandAllLicense;

  @FindBy(xpath="(((//div[@role='presentation'])[2])/div[2]/div/div//span[contains(text(),'DH8')])[4]")
  WebElement DH8Xpath;

  @FindBy(xpath="(((//div[@role='presentation'])[2])/div[2]/div/div//span[contains(text(),'DH6')])[1]")
  WebElement DH6Xpath;

  @FindBy(xpath="(//button[contains(text(),'Actions')])[5]")
  WebElement DH8ActionBtn;

  @FindBy(xpath="(//button[contains(text(),'Actions')])[4]")
  WebElement DH6ActionBtn;

  @FindBy(xpath="(//span[text()='Assign Devices'])[5]")
  WebElement DH6AssignBtn;

  @FindBy(xpath="(//span[text()='Assign Devices'])[4]")
  WebElement DH8AssignBtn;

  @FindBy(xpath="(//select)[5]")
  WebElement selectTypesOfBP;

  @FindBy(xpath="(//div[@class='form-group'])[4]")
  WebElement selectTypesOfBP1;

  @FindBy(xpath="//button[@ng-click='addCondition()']")
  WebElement AddConditionBtn;

  @FindBy(xpath="(//select)[6]")
  WebElement AddConditonFilterSelect;

  @FindBy(xpath="(//select)[9]")
  WebElement AddConditonSelectTypeOfVL;

  @FindBy(xpath="(//select)[2]")
  WebElement AddConditonSelectType1;

  @FindBy(xpath="(//select)[3]")
  WebElement AddConditonSelectTypeC1;

  @FindBy(xpath="//*[@class='group-conditions']//input[@type='text']")
  WebElement AddConditonSelectTypeV1;

  @FindBy(xpath="(//select)[5]")
  WebElement AddConditonSelectType2;

  @FindBy(xpath="(//select)[8]")
  WebElement AddConditonSelectTypeV2;

  @FindBy(xpath="(//select)[9]")
  WebElement AddConditonSelectType3;

  @FindBy(xpath="(//select)[12]")
  WebElement AddConditonSelectTypeV3;

  @FindBy(xpath="(//span[text()='Delete'])[5]")
  WebElement temp;


  @FindBy(xpath="(//button[@aria-disabled='false']//span[text()='Clear'])[2]")
  WebElement ClearBtn;

  @FindBy(xpath="(//span[text()='Assign Devices'])/..")
  List<WebElement> AssignDeviceAttributeS;



///VMM_4338

  @FindBy(xpath="//span[@class='check']")
  WebElement ShowAllFieldsCheckBox;

  @FindBy(xpath="(//span[@class='ng-binding ng-scope'][normalize-space()='EXPIRED'])[1]/../../../../div/div[7]//span")
  WebElement LicenseActiveStatus;

  @FindBy(xpath="(//div[@class='ui-grid-row ng-scope'])[2]/div/div[5]//span")
  WebElement LicenseStatusText;

  @FindBy(xpath="//input[@id='field_expiryDate']")
  WebElement ExpiryDateTextBox;

  @FindBy(xpath="//input[@id='field_startDate']")
  WebElement InauguralDateTextBox;

  @FindBy(xpath="(//div[@class='ui-grid-row ng-scope'])[2]/div/div[12]//span[@class='ng-binding']")
  WebElement SFcommanderLicenseId;

  @FindBy(xpath="(//div[@class='ui-grid-row ng-scope'])[2]/div/div//span[contains(text(),'1')]")
  List<WebElement> SFcommanderLicenseIdS;

///4439

  @FindBy(xpath="(//ul[@role='menu'])//span[text()='Assign Devices']")
  List<WebElement> AssignDeviceBtnS;


  @FindBy(xpath="(//select[@name='deviceType'])[1]")
  WebElement DeviceTypeDropDown;

  @FindBy(xpath="(//span[@class='check'])[2]")
  WebElement selectDeviceTypeToAssign;

  @FindBy(xpath="(//button[@id='license_assign_btn'])")
  WebElement AssignBtn;

  @FindBy(xpath="(//select[@name='deviceType'])[1]/option")
  List<WebElement> ListOfAvailableDeviceTypeInAssignDevicePage;

  @FindBy(xpath="(//span[contains(text(),'16') or contains(text(),'17') and not(contains(category,'-')) ])[1]")
  WebElement LicenseId;

  @FindBy(xpath="(//th[text()='Device Type'])[2]/..//div")
  WebElement SelectAllDevicesToUnassign;



////*************************


  //suryaaa //-----------------------VMM3265----------------------------]
  @FindBy(xpath ="(//ul[@role='menu']//span[text()='Publish'])")
  List<WebElement> PublishBTNCommercial;


  @FindBy(xpath ="(//button[contains(text(),'Actions')])[4]")
  WebElement ActionBTNCommercial;

  @FindBy(xpath ="//button[normalize-space()='Ok']")
  WebElement PublishOkBTN;


  @FindBy(xpath ="(//ul[@role='menu']//span[text()='Generate Keys'])")
  List<WebElement> GenerateKeysCommercial;

  @FindBy(xpath ="//*[text()='Logout']")
  WebElement LogoutTenantManager;

  @FindBy(xpath ="//button[normalize-space()='Yes']")
  WebElement ConformLogoutTenantManager;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Edit'])")
  List<WebElement> EditBTNF;
  //----------T

  @FindBy(xpath ="//*[normalize-space()='API Clients']")
  WebElement CoformApiClientPage;


  //-------------------Sunilkumar(VMM3285)----------------------------------
  @FindBy(xpath ="//label[@id='field_server_label']")
  WebElement serverlabelonlicensepage;

  //---------------------Sunilkumar(VMM3284)--------------------------------
  @FindBy(xpath ="//select[@id='field_server']")
  WebElement serverfield;

  //-----------------Sunilkumar(VMM3846)-------------------------------
  @FindBy(xpath ="//span[@class='check']")
  WebElement showallfieldcheckBox;

  @FindBy(xpath ="//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
  WebElement selectfield;

  @FindBy(xpath ="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
  WebElement conditionfieled;

  @FindBy(xpath ="//input[@class='form-control data-input ng-pristine ng-untouched ng-valid']")
  WebElement datainputfield;

  @FindBy(xpath ="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/select")
  WebElement LicenceTypedatainputfield;

  @FindBy(xpath ="(//*[@class='ui-grid-cell-contents ng-binding ng-scope' ]//span[@class='deployment-type ng-binding'])[4]")
  WebElement cloudcommercialsymbl;

  @FindBy(xpath ="(//i[@title='CLOUD_GOVERNMENT'])[1]")
  WebElement cloudgovernmentsymbl;

  @FindBy(xpath ="(//i[@title='ONSITE'])[1]")
  WebElement onsitesymbl;

  //Savitha
  @FindBy(xpath ="//*[@class='input-group ng-scope']//select")
  WebElement selectDatafield;

  //------------------------Sunilkumar(VMM4423)-------------------------------------------

  @FindBy(xpath ="(//button[contains(text(),'Actions')])[6]")
  WebElement ActionBTNH2;

  @FindBy(xpath ="//span[text()='Licenses']")
  WebElement LicensesCheckNavigate;

  @FindBy(xpath ="(//button[contains(text(),'Actions')])[8]")
  WebElement ActionBTNH3;


  //Rajath VMM-3326--------------------------------------------------------------

  @FindBy(xpath="//span[@class='showHideFilters ng-binding']")
  WebElement licensesshowfilter;

  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
  WebElement EnterTenantID;

  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
  WebElement Enterequals;

  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
  WebElement Entertenantname;

  @FindBy(xpath="//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
  WebElement FILTER;

  @FindBy(xpath="//i[@class='ui-grid-icon-plus-squared']")
  WebElement plussymbol;

  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[4]/div/div/div/div/div/div/button")
  WebElement Actionbtn;

  @FindBy(xpath="/html/body/ul[4]/li[7]/a/span")
  WebElement PUBLISHbtn;

  @FindBy(xpath="//button[normalize-space()='Ok']")
  WebElement PUBLISHOKbtn;

  @FindBy(xpath="//a[@id='menu_link_cancel_171762']//span[@class='ng-binding'][normalize-space()='Terminate']")
  WebElement TERMINATEbtn;

  @FindBy(xpath="//button[normalize-space()='Ok']")
  WebElement TERMINATEOKbtn;

  @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div[5]/div")
  WebElement verifyTerminate;


  //Rajath VMM-3704-----------------------------------------------

  @FindBy(xpath="//span[@id='lifecycle-license']")
  WebElement navigatetolicenses;

  @FindBy(xpath="(//span[@class='caret'])[4]")
  WebElement Action2btn;

  @FindBy(xpath="(//ul[@role='menu'][20])//span[text()='Renew']")
  WebElement Renewbtn;

  @FindBy(xpath="(//ul[@role='menu']//span[text()='Renew'])")
  List<WebElement> RenewbtnS;

  @FindBy(xpath="/html/body/div[1]/div[2]/form/div[2]/div[6]/div/input")
  WebElement Part;

  @FindBy(xpath="//span[normalize-space()='Cancel']")
  WebElement renewcancel;

  @FindBy(xpath="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[35]")
  WebElement LicenseexpirydateTxtBx;

  @FindBy(xpath="//input[@id='field_expiryDate']")
  WebElement Licenseexpirydate;

  @FindBy(xpath="(//input[@id='field_expiryDate'])[1]")
  WebElement RenewLicenseexpirydateTxtBx;


  //surya----------------------------VMM-3878--------------------------------

    @FindBy(xpath="(//select[@placeholder='Filter for column'])[1]")
    WebElement BaseProductTypeDropDwn;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[1]//option[@label]")
  List<WebElement> BaseProductTypeDropDwnValues;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[2]")
  WebElement LicenseTypeDropDwn;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[2]//option[@label]")
  List<WebElement> LicenseTypeDropDwnValues;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[3]")
  WebElement CharegeTypeDropDwn;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[3]//option[@label]")
  List<WebElement> ChargeTypeDropDwnValues;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[4]")
  WebElement StatusDropDwn;

  @FindBy(xpath="(//select[@placeholder='Filter for column'])[4]//option[@label]")
  List<WebElement> StatusDropDwnValues;


  @FindBy(xpath="//select[@id='field_fleet_id']")
  WebElement TenantIDDropDwn;

  @FindBy(xpath="//select[@id='field_fleet_id']//option[@label]")
  List<WebElement> TenantIDDropDwnValues;




//------------------------------------------------Nitin-------------------------------------------------//
@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-valid ng-touched']")
WebElement filterFieldsDrpp;

  @FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-valid ng-touched']")
  WebElement filterOperationsDrpp;

  @FindBy(xpath="//input[@class='form-control data-input ng-pristine ng-valid ng-touched']")
  WebElement tenantTxtt;

  @FindBy(xpath="(//span[text()='Edit'])[30]")
  WebElement editBtnn;

  @FindBy(xpath = "//span[contains(text(),'Show Filters')]")
  WebElement showFilters;

  @FindBy(xpath = "(//select)[2]")
  WebElement filterLicenseFirst;

  @FindBy(xpath = "(//select)[3]")
  WebElement filterLicenseSecond;

  @FindBy(xpath="(//input)[2]")
  WebElement filterLicenseText;

  @FindBy(xpath = "(//span[text()='Filter'])[2]")
  WebElement filterButton;

  @FindBy(xpath = "(//div[@role='button'])[1]")
  WebElement firstPlusExpandSymbol;

  @FindBy(xpath = "(//button[contains(text(),'Actions')])[7]")
  WebElement secondActionsDropButton;

  @FindBy(xpath = "(//button[contains(text(),'Actions')])[4]")
  WebElement firstActionsDropButton;

  @FindBy(xpath = "(//button[contains(text(),'Actions')])[7]")
  WebElement thirdActionsDropButton;

  @FindBy(xpath = "(//span[text()='Publish'])[7]")
  WebElement firstPublish;

  @FindBy(xpath = "(//span[text()='Publish'])[14]")
  WebElement thirdPublish;

  @FindBy(xpath = "(//span[text()='Generate Keys'])[2]")
  WebElement secondDropGenerateKeys;

  @FindBy(xpath = "//input[@id='downloadFile-0']")
  WebElement publishDownloadCheckBox;

  @FindBy(xpath = "//button[text()='Ok']")
  WebElement okk;

  @FindBy(xpath = "//span[text()='New']")
  WebElement neww;

  @FindBy(xpath="(//select)[9]")
  WebElement serverr;

  @FindBy(xpath = "//input[@id='field_expiryDate']")
  WebElement expiryDatee;

  @FindBy(xpath = "//select[@id='field_slotType']//child::option")
  List<WebElement> optionsTextt;
  //------------------------------------------------Nitin-------------------------------------------------//


  //Rajath VMM_3592----------------------------------------------------------

  @FindBy(xpath="//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
  WebElement clearlicense;

  @FindBy(xpath="//select[@id='field_softwareLicense']")
  WebElement licensesoftwareversion;


  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/div/div/i")
  WebElement expandbtn;

  @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[4]/div/div/div/div/div/div/button")
  WebElement actionbtn;

  @FindBy(xpath="//body/ul[14]/li[4]/a[1]/span[1]")
  WebElement deletelicensebtn;

  @FindBy(xpath="//span[@class='ng-scope'][normalize-space()='Delete']")
  WebElement deleteokbtn;
///////4330

  @FindBy(xpath = "//select[@id='field_integration']")
  WebElement integrtion;

  @FindBy(xpath = "//select[@id='field_j1939']")
  WebElement j1939;

  //Savitha
  @FindBy(xpath="//*[contains(@id,'menu_link_cloud_1')]/span")
  List<WebElement> publishBtns;

  @FindBy(xpath="//*[contains(@id,'menu_link_cancel_1')]/span")
  List<WebElement> terminateBtns;

  @FindBy(xpath="//*[contains(@id,'menu_link_return_1')]/span")
  List<WebElement> returnBtns;

  @FindBy(xpath="//span[text()='Status']/..//*[@class='ui-grid-icon-up-dir']")
  WebElement statusSortBtn;


  @FindBy(xpath="//button[@id='details-button']")
  WebElement AdvanceBtn;

  @FindBy(xpath="//a[@id='proceed-link']")
  WebElement ProceedLnk;

  @FindBy(xpath="//*[@id='showAllFields']/../span/span")
  WebElement showAllFieldsCheckBox;

  //Savitha
  @FindBy(xpath="//input[@id='field_addProvider']/..//span[@class='check']")
  WebElement providerChkbox;

  @FindBy(xpath="//input[@id='field_licenseKey']")
  WebElement licenseKeyTxt;

  @FindBy(xpath="//input[@id='field_systemid']")
  WebElement SystemIdTxt;

  @FindBy(xpath="//input[@id='field_providerRegisteredDate']")
  WebElement registeredDateTxt;

  @FindBy(xpath="//input[@id='field_providerExpiryDate']")
  WebElement expiredDateTxt;

  @FindBy(xpath="(//select[@id='field_softwareLicense'])[2]")
  WebElement softwareVersionDrp;


  @FindBy(xpath="//*[@id='field_slotType']/option")
  List<WebElement> listOfLicenseTypes;


  @FindBy(xpath="//*[contains(@aria-labelledby,'split-button-1')]/li[1]")
  WebElement viewBtn;


  @FindBy(xpath="//*[@class='ui-grid-cell-contents ng-binding ng-scope']/span")
  WebElement tenantIdTxt;

  @FindBy(xpath="//a[contains(@id,'menu_link_expire')]//span[text()='Expire']/..")
  List<WebElement> ExpireBtnS;

  @FindBy(xpath="(//*[contains(@id,'menu_link_expire_1')]/span)[1]")
  WebElement expireBtn;
  public void createNewLicense() {
    createNewBtn.click();
  }


  public void addLicenses(Map<String, String> testData) throws InterruptedException {

    //	 waitForElementToBeClickableThenSendkeys(tenantIDSrch, testData.get("TenantID") );
    //	 waitForElementToBeClickableThenClick(tenantIDExp);
    sleepMin();
    waitForElementToBeClickableThenClick(newLicenseBtn);
    waitForAngularRequestsToFinish();
    //selectListByVisibleText(tenantIDDrp, testData.get("TenantID"));
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProductDrp, testData.get("Base Product"));
    waitForAngularRequestsToFinish();
    sleepMin();
    selectListByVisibleText(licenseTypeDrp, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenClearThenSendkeys(partTxt, testData.get("Part #"));
    sleepMin();

    if(testData.get("License Type").equals("1") || testData.get("License Type").equals("2") ) {
      waitForElementToBeClickableThenClearThenSendkeys(qtyTxt, testData.get("QTY"));
    }

    selectListByVisibleText(chargeTypeDrp, testData.get("Charge Type"));
    sleepMin();
    selectListByVisibleText(serverDrp, "FLEET1-CLOUD_COMMERCIAL");
    sleepMin();
    waitForElementToBeClickableThenClick(saveLicenseBtn);
    sleepMAX();

  }

  public void fillAddLicenses(Map<String, String> testData) throws InterruptedException {

    //	 waitForElementToBeClickableThenSendkeys(tenantIDSrch, testData.get("TenantID") );

    //	 waitForElementToBeClickableThenClick(tenantIDExp);

    sleepMin();

    waitForElementToBeClickableThenClick(newLicenseBtn);

    waitForAngularRequestsToFinish();

    //selectListByVisibleText(tenantIDDrp, testData.get("TenantID"));
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);


    selectListByVisibleText(baseProductDrp, testData.get("Base Product"));

    sleepMin();

    selectListByValue(licenseTypeDrp, testData.get("License Type"));

    sleepMin();

    waitForElementToBeClickableThenClearThenSendkeys(partTxt, testData.get("Part #"));

    sleepMin();

    //	 selectListByValue(licenseTypeDrp, testData.get("License Type"));

    //	 sleepMin();

    if(testData.get("License Type").equals("1") || testData.get("License Type").equals("2") ) {

      waitForElementToBeClickableThenClearThenSendkeys(qtyTxt, testData.get("QTY"));

    }


    selectListByVisibleText(chargeTypeDrp, testData.get("Charge Type"));

    sleepMin();


  }

  public void saveAddingLicense() throws InterruptedException {

    waitForElementToBeClickableThenClick(saveLicenseBtn);

    sleepMAX();


  }


  public void viewLicenseWarning(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(filterBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(hideFiltersBtn);

    sleepMAX();
    licenseExpand();

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn2);

    sleepMin();

    waitForElementToBeClickableThenClick(publishBtn2);

    String text = getWebelementText(warningPopup);


    assert text.equalsIgnoreCase("WARNING: Since this tenant does not have a published App license for this software, the activation of this license on the Cloud will not take effect until after an App license is published as well.") ;


  }

  public void closeWarning() throws InterruptedException {

    sleepMin();

    waitForElementToBeClickableThenClick(warningOKBtn);

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(actionsBtn);

    sleepMin();

    waitForElementToBeClickableThenClick(publishBtn);

    String text2 = getWebelementText(warningPopup);

    assert text2.equalsIgnoreCase("WARNING: Since this tenant does not have a published App license for this software, the activation of this license on the Cloud will not take effect until after an App license is published as well.") ;


    waitForElementToBeClickableThenClick(warningOKBtn);

    //	String status = getWebelementText(publishStatus);


  }


  public void publishVehicleLicense() throws InterruptedException {

    sleepMin();

    scrollToElement("(//*[contains(@id,'split-button-1')])[3]");

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn2);

    sleepMin();

    publishVisibleLicense();

    sleepMin();

    waitForElementToBeClickableThenClick(warningOKBtn);


  }

  public void terminateVehicleLicense() throws InterruptedException {

    sleepMin();

    scrollToElement("(//*[contains(@id,'split-button-1')])[3]");

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn3);

    sleepMin();

    terminateVisibleLicense();

    sleepMin();

    waitForElementToBeClickableThenClick(warningOKBtn);

    waitForAngularRequestsToFinish();

  }

  public void terminateUserLicense(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(filterBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(hideFiltersBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(tenantIDExp);

    sleepMin();

    scrollToElement("(//*[contains(@id,'split-button-1')])[3]");

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn2);

    sleepMin();

    //scrollToElement("(//*[contains(@id,'menu_link_cancel_1')]/span)[5]");

    terminateVisibleLicense();

    sleepMin();

    waitForElementToBeClickableThenClick(warningOKBtn);

    waitForAngularRequestsToFinish();


  }

  public void terminateAppLicense(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(filterBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(hideFiltersBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(tenantIDExp);

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn);

    sleepMin();

    terminateVisibleLicense();

    sleepMin();

    waitForElementToBeClickableThenClick(warningOKBtn);

    waitForAngularRequestsToFinish();

  }

 public void publishUserLicense() throws InterruptedException {

   sleepMin();

   scrollToElement("(//*[contains(@id,'split-button-1')])[3]");

   sleepMin();

   waitForElementToBeClickableThenClick(actionsBtn3);

   sleepMin();

   publishVisibleLicense();

   sleepMin();

   waitForElementToBeClickableThenClick(warningOKBtn);


 }

  public void clickMenu() throws InterruptedException {

    sleepMin();

    waitForElementToBeClickableThenClick(menuBtn);

    sleepMin();
  }

  public void searchLicense(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    sleepMin();

    waitForElementToBeClickableThenClick(filterBtn);

    sleepAvg();

    waitForElementToBeClickableThenClick(hideFiltersBtn);

    waitForElementToBeClickableThenClick(ExpandLicense);

    sleepMin();

  }

  public void licenseExpand() throws InterruptedException {
    waitForElementToBeClickableThenClick(ExpandLicense);
    sleepMin();
  }


  ////edit license
  public void editLicense(Map<String, String> testData) throws InterruptedException {
    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn);

    sleepMin();

    waitForElementToBeClickableThenClick(editBtn2);

    sleepMAX();

    selectListByVisibleText(baseProductDrp, testData.get("Base Product"));
    waitForAngularRequestsToFinish();

    sleepMAX();

    selectListByVisibleText(licenseTypeDrp, testData.get("License Type"));

    sleepMin();

    selectListByVisibleText(serverDrp, "FLEET1-CLOUD_COMMERCIAL");

    sleepMin();

    waitForElementToBeClickableThenClick(saveBtn);

    sleepMin();


  }

  public void saveLicense() throws InterruptedException {


    waitForElementToBeClickableThenClick(appLicensePublishOKBtn);

    sleepMAX();

    sleepMAX();
  }


  public void publishAppLicense(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    sleepMAX();

    waitForElementToBeClickableThenClick(filterBtn);

    sleepMAX();

    waitForElementToBeClickableThenClick(hideFiltersBtn);

    sleepMin();

    licenseExpand();

    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn);

    sleepMAX();

    if(testData.get("TCID").equalsIgnoreCase("VMM_3853_3")) {

      publishVisibleLicense();
    } else if(testData.get("TCID").equalsIgnoreCase("VMM_3407_1")) {

      publishVisibleLicense();
    } else if(testData.get("TCID").equalsIgnoreCase("VMM_3272_3")) {

      publishVisibleLicense();
    }

    sleepAvg();

  }

  public void clickPublishOK() throws InterruptedException {

    waitForElementToBeClickableThenClick(appLicensePublishOKBtn);
    waitForAngularRequestsToFinish();

  }

  public void clickReturnLicenses(Map<String, String> testData) throws InterruptedException {

     driver.navigate().refresh();
     waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");

    selectListByVisibleText(filterOperationsDrp, "equals");

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));

    //	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(filterBtn);

     waitForAngularRequestsToFinish();

    //waitForElementToBeClickableThenClick(hideFiltersBtn);

    waitForElementToBeClickableThenClick(tenantIDExp);
    sleepMin();

    waitForElementToBeClickableThenClick(actionsBtn);

    sleepMin();

    returnVisibleLicense();

    waitForAngularRequestsToFinish();

  }

  public void returnLicensesNew(Map<String, String> testData) throws InterruptedException {

    //selectListByValue(licenseTypeDrp, testData.get("License Type"));

    sleepMin();

    waitForElementToBeClickableThenClearThenSendkeys(partTxt, testData.get("Part #"));

    //sleepMin();

    waitForElementToBeClickableThenClick(saveLicenseBtn);

    waitForAngularRequestsToFinish();

  }

  public String settingsButtonTest() {

    waitForElementToBeClickableThenClick(actionsBtn);

    String settingsBtnStatus =driver.findElement(By.xpath("(//*[contains(@aria-labelledby,'split-button-170')]/li[3]/a)[1]")).getAttribute("aria-disabled");

    return settingsBtnStatus;
  }

 public String settingsButtonTest2() {

   waitForElementToBeClickableThenClick(actionsBtn2);

   String settingsBtnStatus =driver.findElement(By.xpath("(//*[contains(@aria-labelledby,'split-button-170')]/li[3]/a)[2]")).getAttribute("aria-disabled");

   return settingsBtnStatus;
 }

 public void showFilterdoubleClick() throws InterruptedException {

   waitForElementToBeClickableThenClick(showFiltersBtn);

   sleepMin();

   waitForElementToBeClickableThenClick(showFiltersBtn);

 }
 //Savitha
 public void showFilterClick() throws InterruptedException {

   waitForElementToBeClickableThenClick(showFiltersBtn);
   sleepMin();
 }

  public void createNewLicense(Map<String, String> testData) throws InterruptedException {
    //sleepMAX();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    //sleepMAX();
    //sleepMAX();
    //selectListByVisibleText(tenantID, testData.get("TenantID"));
    waitForElementToAppear(inauguralDateField);
    //sleepMin();
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    sleepMin();
    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    waitForAngularRequestsToFinish();
    sleepMin();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    //waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    selectListByVisibleText(server,testData.get("Server"));
    //System.out.println(testData.get("TCID"));
    //if(!testData.get("TCID").contains("VMM-3870"))
    waitForElementToBeClickableThenSendkeys(Quantity, testData.get("QTY"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    //sleepMAX();

  }

  public void createNewLicenseWithoutOTY(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    sleepMin();
    waitForAngularRequestsToFinish();
    ///selectListByVisibleText(tenantID, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    selectListByVisibleText(server,testData.get("Server"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();

  }

  public void createNewLicenseWithoutServer(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    sleepMin();
    waitForAngularRequestsToFinish();
    sleepMin();
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    sleepMin();
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(Quantity, testData.get("QTY"));
    sleepMin();
    saveBtn.click();
    waitForAngularRequestsToFinish();
    sleepMin();

  }

  ///3584

  public void addLicensesforBaseProduct(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    waitForElementToAppear(inauguralDateField);

    //selectListByVisibleText(tenantID, testData.get("TenantID"));
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    waitForAngularRequestsToFinish();
    //sleepMin();
    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    //sleepMin();
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    //sleepMin();
    if(testData.get("Server")!="")
      selectListByVisibleText(server,testData.get("Server"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    //sleepMAX();
  }

  ////////publishTwoLicense
  public void publishTwoLicense(Map<String, String> testData) throws InterruptedException {


    waitForElementToBeClickableThenClick(showFiltersBtn);
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterOperationsDrp, "equals");
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClick(filterBtn);
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClick(expandBtn);
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClick(showFiltersBtn);
    sleepMAX();

    waitForElementToBeClickableThenClick(actionBtn3584);
    sleepMin();


//				 waitForElementToBeClickableThenClick(publishBtn3584);
//				 sleepMAX();
    for(int i=0; i<AppLicensePublishButtonS.size();i++) {
      boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        AppLicensePublishButtonS.get(i).click();
        break;
      }
    }

    waitForElementToBeClickableThenClick(okBtnToPublish);
    sleepMAX();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(actionBtn3584_1);
    sleepMAX();
    waitForAngularRequestsToFinish();
//				 waitForElementToBeClickableThenClick(publishBtn3584_1);
//				 sleepMAX();
    for(int i=0; i<AppLicensePublishButtonS.size();i++) {
      boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        AppLicensePublishButtonS.get(i).click();
        break;
      }
    }

       }

  public void clickOK() throws InterruptedException {

    waitForElementToBeClickableThenClick(okBtn);
    waitForAngularRequestsToFinish();

  }
  ////3412


  public void addLicensesforBaseProductAddAnother(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    createNewBtn.click();
    waitForAngularRequestsToFinish();
    ///selectListByVisibleText(tenantID, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));

    selectListByVisibleText(chargeType, testData.get("Charge Type"));

    selectListByVisibleText(server,testData.get("Server"));
    sleepMin();
    addAnotherBtn.click();
    saveBtn.click();
    waitForAngularRequestsToFinish();
  }

  public void createNewLicenseWithAddAnother3412(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    createNewBtn.click();
    //Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    sleepMin();
    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));

    selectListByVisibleText(chargeType, testData.get("Charge Type"));

    waitForElementToBeClickableThenSendkeys(Quantity, testData.get("QTY"));

    selectListByVisibleText(server,testData.get("Server"));
    sleepMin();
    addAnotherBtn.click();

    saveBtn.click();
    waitForAngularRequestsToFinish();


  }

  public void createNewLicenseWithAddAnother2(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    sleepMAX();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    Thread.sleep(SLEEP_AVG);
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    Thread.sleep(SLEEP_AVG);
    addAnotherBtn.click();
    Thread.sleep(SLEEP_AVG);
    saveBtn.click();
  }

  public void createNewLicenseWithAfterAddLast(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    sleepMin();
    saveBtn.click();
    sleepMAX();

  }

  /////////////////////////////////////
 public void createNewLicenseWithQtyAfterAddLast(Map<String, String> testData) throws InterruptedException {
   sleepMAX();
   selectListByVisibleText(licenseType, testData.get("License Type"));
   sleepMin();
   waitForElementToBeClickableThenSendkeys(Quantity, testData.get("QTY"));
   sleepMin();
   waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
   sleepMin();
   saveBtn.click();
   sleepMAX();

 }

  public void checkLicenseFeatures(Map<String, String> testData) throws InterruptedException {
    try {
      waitForElementToBeClickableThenClick(showFiltersBtn);
      Thread.sleep(SLEEP_AVG);

      selectListByVisibleText(filterFieldsDrp, "Tenant ID");
      sleepMin();

      selectListByVisibleText(filterOperationsDrp, "equals");
      sleepMin();

      waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
      sleepMin();

      waitForElementToBeClickableThenClick(filterBtn);
      Thread.sleep(SLEEP_AVG);

      waitForElementToBeClickableThenClick(expandBtn);
      sleepMin();

      waitForElementToBeClickableThenClick(showFiltersBtn);
      sleepMin();

      String t=License3412_1.getText();
      assert t.equals(testData.get("License1"));

      String t1=License3412_2.getText();
      assert t1.equals(testData.get("License2"));

      String t2=License3412_3.getText();
      assert t2.equals(testData.get("License3"));

      String t3=License3412_4.getText();
      assert t3.equals(testData.get("License4"));
    } catch(Exception e) {
      System.out.println(e.getStackTrace());
    }

  }


 public void waitForAngularToLoad() {

   waitForAngularRequestsToFinish();
 }

  ///////////// Add License with expiry date
  public void addLicensesforBaseProductWithExpiryDate(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    sleepMin();
    waitForAngularRequestsToFinish();
    ///selectListByVisibleText(tenantID, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    waitForElementToBeClickableThenSendkeys(expiryDate, "12/30/2023");
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();
}

 public void addFeatureLicenseWithExpiryDate(Map<String, String> testData) throws InterruptedException {
   sleepMAX();
   waitForElementToBeClickableThenClick(licenseNewBtn);
   sleepMin();
   waitForAngularRequestsToFinish();
   ///selectListByVisibleText(tenantID, testData.get("TenantID"));

   waitForElementToBeClickableThenClick(tenantID);
   waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
   waitForElementToBeClickableThenClick(suggestionRowFirstValue);
   sleepMin();
   selectListByVisibleText(baseProduct, testData.get("Base Product"));
   sleepMin();
   selectListByVisibleText(licenseType, testData.get("License Type"));
   sleepMin();
   waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
   selectListByVisibleText(chargeType, testData.get("Charge Type"));
   waitForElementToBeClickableThenSendkeys(expiryDate, "12/30/2023");
   waitForElementToBeClickableThenSendkeys(Quantity, testData.get("QTY"));
   waitForElementToBeClickableThenClick(licenseSaveBtn);
   waitForAngularRequestsToFinish();
   sleepMAX();
 }


 public void viewAllLicenses(Map<String, String> testData) throws InterruptedException {


   waitForElementToBeClickableThenClick(showFiltersBtn);
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterFieldsDrp, "Tenant ID");
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterOperationsDrp, "equals");
   Thread.sleep(SLEEP_AVG);

   waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
   Thread.sleep(SLEEP_AVG);

       sleepMAX();

   waitForElementToBeClickableThenClick(filterBtn);
   Thread.sleep(SLEEP_AVG);

      waitForElementToBeClickableThenClick(expandBtn);
      Thread.sleep(SLEEP_AVG);

      waitForElementToBeClickableThenClick(showFiltersBtn);
      sleepMin();
}
/////////3273
 public void verifyGenerateButton1(Map<String, String> testData) throws InterruptedException
 {

   waitForElementToBeClickableThenClick(actionBtn3584);
   sleepMin();
 }

 public void verifyGenerateButton2(Map<String, String> testData) throws InterruptedException
 {
   waitForElementToBeClickableThenClick(actionBtn3584);
   sleepMin();
   waitForElementToBeClickableThenClick(actionBtn3584_1);

}

  ArrayList<String> newTb = null;

  public String clickOnSecondGenerateButton(String env) throws InterruptedException {
    for(int i=0; i<generateKeysButton.size();i++) {
      boolean DeleteBtn = generateKeysButton.get(i).isDisplayed();
      if(DeleteBtn==true) {
        System.out.println(i);
        generateKeysButton.get(i).click();
        break;
      }
    }

    waitForAngularRequestsToFinish();

    // hold all window handles in array list
    newTb = new ArrayList<String>(driver.getWindowHandles());
    //switch to new tab
    driver.switchTo().window(newTb.get(1));
    waitForAngularRequestsToFinish();
    sleepMAX();
    System.out.println("Page title of new tab: " + driver.getTitle());
    //driver.navigate().to("https://test-tenant-manager.safefleetcloud.com/api-client");
  /*
    if(env.equals("STG")) {
      waitForElementToBeClickableThenClick(AdvanceBtn);
      waitForElementToBeClickableThenClick(ProceedLnk);
    }*/


    String title = driver.getTitle();
    System.out.println(title);
    return title;

  }

  public void verifyActionButton(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(showFiltersBtn);
    sleepMin();
    selectListByVisibleText(filterFieldsDrp, "Tenant ID");
    sleepMin();
    selectListByVisibleText(filterOperationsDrp, "equals");
    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(expandBtn);
    waitForElementToBeClickableThenClick(showFiltersBtn);
    waitForElementToBeClickableThenClick(actionBtn3584);
    sleepMin();
  }

public void verifyLicenseTab(Map<String, String> testData) throws InterruptedException {
  waitForElementToBeClickableThenClick(showFiltersBtn);
  sleepMin();
  selectListByVisibleText(filterFieldsDrp, "Tenant ID");
  sleepMin();
  selectListByVisibleText(filterOperationsDrp, "equals");
  waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForElementToBeClickableThenClick(expandBtn);
  waitForElementToBeClickableThenClick(showFiltersBtn);

}

 public void publishOneLicense(Map<String, String> testData) throws InterruptedException {
   waitForElementToBeClickableThenClick(showFiltersBtn);
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterFieldsDrp, "Tenant ID");
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterOperationsDrp, "equals");
   waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
   waitForElementToBeClickableThenClick(filterBtn);
   waitForAngularRequestsToFinish();

   waitForElementToBeClickableThenClick(expandBtn);
   waitForElementToBeClickableThenClick(showFiltersBtn);
   waitForElementToBeClickableThenClick(actionBtn3584);
   sleepMin();

//		 waitForElementToBeClickableThenClick(publishBtn3584);
//		 sleepMAX();

   for (int i = 0; i < AppLicensePublishButtonS.size(); i++) {
     boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
     //System.out.println(DeleteBtn);
     if (DeleteBtn == true) {
       System.out.println(i);
       //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
       AppLicensePublishButtonS.get(i).click();
       break;
     }
   }

 }

 public void publishSecondLicense(Map<String, String> testData) throws InterruptedException {
   waitForElementToBeClickableThenClick(showFiltersBtn);
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterFieldsDrp, "Tenant ID");
   Thread.sleep(SLEEP_AVG);

   selectListByVisibleText(filterOperationsDrp, "equals");
   waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
   waitForElementToBeClickableThenClick(filterBtn);
   waitForAngularRequestsToFinish();
   waitForElementToBeClickableThenClick(expandBtn);
   waitForElementToBeClickableThenClick(showFiltersBtn);
   waitForElementToBeClickableThenClick(actionBtn3584);
   sleepMin();

   for (int i = 0; i < AppLicensePublishButtonS.size(); i++) {
     boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
     //System.out.println(DeleteBtn);
     if (DeleteBtn == true) {
       System.out.println(i);
       //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
       AppLicensePublishButtonS.get(i).click();
       break;
     }
   }

 }

//surya----------------------------------------VMM-3277------------------------------------

 public void CreateLicense(Map<String, String> testData) throws InterruptedException {
   waitForAngularRequestsToFinish();
   waitForElementToBeClickableThenClick(licenseNewBtn);
   waitForAngularRequestsToFinish();
   ///selectListByVisibleText(tenantID, testData.get("TenantID"));

   waitForElementToBeClickableThenClick(tenantID);
   waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
   waitForElementToBeClickableThenClick(suggestionRowFirstValue);

   selectListByVisibleText(baseProduct, testData.get("Base Product"));
   selectListByVisibleText(licenseType, testData.get("License Type"));
   sleepAvg();
   waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
   waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
   selectListByVisibleText(chargeType, testData.get("Charge Type"));
   sleepMin();
 }


  public String LicenseSaveAndVerifyAlert() throws InterruptedException {
    waitForElementToBeClickableThenClick(saveBtn);
    String msg = LicenseAlertMessage.getText();
    return msg;

  }

  public String verifyDataamountfield() {
    String DAFstatus = VerifyDataAmountField.getText();
    System.out.println("empty" +DAFstatus);
    if(DAFstatus.isEmpty()) {
      System.out.println("empty");
      return "true";

    } else {
      return "false";
    }
  }

  public void createLicenseWithoutQtyField(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    ///	selectListByVisibleText(tenantID, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepAvg();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));


  }

  public String VerifySaveBtnDisabled() {

    String SaveBtnSts = VerifySaveBtnInLisense.getAttribute("aria-disabled");
    if(SaveBtnSts.contains("true")) {
      return "true";
    } else {
      return "fail";
    }
  }

  public boolean VerifySaveBtnEnabled() {

    boolean SaveBtnSts = VerifySaveBtnInLisense.isEnabled();
    if(SaveBtnSts==true) {
      return true;
    } else {
      return false;
    }
  }

  public void EnterQtyField(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
    sleepAvg();
  }

//------------------------------------------------------------------------------------




//-----------------------------------------VMM3405 Melroy------------------------------------------------------
public void createLicenses(Map<String, String> testData) throws Exception
{
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  waitForAngularRequestsToFinish();
  ///selectListByVisibleText(licenseTenantID, testData.get("TenantID"));

  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);
  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
  selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
  selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));

  waitForElementToBeClickableThenClick(licenseSaveBtn);
  waitForAngularRequestsToFinish();

}


 public void entertheTenantID(Map<String, String> testData) throws Exception
 {


   waitForElementToBeClickableThenClick(showFiltersBtn);
   waitForAngularRequestsToFinish();
   selectListByVisibleText(tentIdfield, "Tenant ID");
   selectListByVisibleText(tenantOption, "equals");
   waitForElementToBeClickableThenSendkeys(tenantValue, "");
   waitForElementToBeClickableThenSendkeys(tenantValue, testData.get("TenantID"));
   waitForElementToBeClickableThenClick(clickfilterBtn);
   waitForAngularRequestsToFinish();
   waitForElementToBeClickableThenClick(clickonPlus);
 }

  public void clickedonPublishBtn() throws Exception {
    waitForElementToBeClickableThenClick(clickonActionBtn);
    sleepAvg();

    for(int i=0; i<clickonPublishLS.size();i++) {
      boolean DeleteBtn = clickonPublishLS.get(i).isDisplayed();
      ;
      if(DeleteBtn==true) {
        System.out.println(i);

        clickonPublishLS.get(i).click();
        break;
      }
    }
    sleepAvg();
  }

  public void clickedonPublishBtn2() throws Exception {
    waitForElementToBeClickableThenClick(clickonActionBtn2);
    sleepMin();

    for(int i=0; i<clickonPublishLS.size();i++) {
      boolean DeleteBtn = clickonPublishLS.get(i).isDisplayed();
      if(DeleteBtn==true) {
        System.out.println(i);

        clickonPublishLS.get(i).click();
        break;
      }
    }
    sleepAvg();
  }

public void verifydownloadBoxCheck() throws Exception
{
  waitForElementToBeClickableThenClick(checkDownloadbox);
  sleepMin();
  waitForElementToBeClickableThenClick(cliclOKBtn);
  sleepAvg();
  Robot r=new Robot();
  r.keyPress(KeyEvent.VK_ENTER);
  sleepMin();
}
public void clickonClear()
{
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(clickClear);
}
//--------------------------------------VMM3283 Melroy----------------------------------
public  ArrayList<String> licensesServers(Map<String, String> testData) throws Exception{
  waitForElementToBeClickableThenClick(licenseNewBtn);
  sleepAvg();
  waitForAngularRequestsToFinish();
  ///selectListByVisibleText(licenseTenantID, testData.get("TenantID"));

  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);


  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  sleepAvg();
  waitForElementToBeClickableThenClick(licensesServer);
  sleepAvg();
  List<WebElement> serverOption = driver.findElements(By.xpath("//select[@id='field_server']/option"));
  sleepMin();
  int count =serverOption.size();
  System.out.println(count);
  ArrayList<String> baseServers=new ArrayList<>();
  for(int i=2;i<=count;i++) {
    WebElement ele=driver.findElement(By.xpath("(//select[@id='field_server']/option)[" +i+ "]"));
    String str = ele.getAttribute("label");
    baseServers.add(str);
  }
  System.out.println(baseServers);
  sleepMin();
  return baseServers;
}



public boolean compareServer(List<String> baseProductServer, List<String> licensesServer2) {
  int PASS=0;
  int count1=baseProductServer.size();
  int count2=licensesServer2.size();
  for(int i=0; i<count1; i++) {
    for(int j=0;j<count2;j++) {
      if(baseProductServer.contains(i)==licensesServer2.contains(j)) {
        PASS++;
        return true;
      }
    }
  }
  return false;
}
//-----------------------------------------------------------------------------------------------------
//------------------------------VMM3385 Melroy-----------------------------------------------------------
public void createLicenses1(Map<String, String> testData) throws Exception
{
  sleepMAX();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  sleepMin();
  waitForAngularRequestsToFinish();
  //selectListByVisibleText(licenseTenantID, testData.get("TenantID"));

  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);

  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
  selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
  selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
  waitForElementToBeClickableThenClick(addAnother);
  //waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  waitForAngularRequestsToFinish();
  sleepMAX();

}
public void createLicenses2(Map<String, String> testData) throws Exception
{
  //sleepMAX();
  //waitForElementToBeClickableThenClick(licenseNewBtn);
  sleepMin();
  waitForAngularRequestsToFinish();
  ///selectListByVisibleText(licenseTenantID, testData.get("TenantID"));

  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);

  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
  selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
  selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
  //waitForElementToBeClickableThenClick(addAnother);
  waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  waitForAngularRequestsToFinish();
  sleepMAX();

}
public void clickedonPublishBtn1() throws Exception
{
  waitForElementToBeClickableThenClick(actionBtn1);
  sleepAvg();
  waitForElementToBeClickableThenClick(clickonPublishL);
  sleepAvg();
}
public void clickedonPublishBtn3() throws Exception
{
  waitForElementToBeClickableThenClick(actionBtn2);
  sleepMin();
  waitForElementToBeClickableThenClick(clickPublishF);
  sleepAvg();
}

//----------------------------------------------------------------------------------------------


///suryaaaaaa--------------------------------------------------VMM3249--------------------------------------------------------------
public void CreateNewLicense(Map<String, String> testData) throws InterruptedException {
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  waitForAngularRequestsToFinish();
  ///selectListByVisibleText(tenantID, testData.get("TenantID"));

  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);

  selectListByVisibleText(baseProduct, testData.get("Base Product"));
  selectListByVisibleText(licenseType, testData.get("License Type"));
  sleepAvg();
  waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
  waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
  selectListByVisibleText(chargeType, testData.get("Charge Type"));
  waitForElementToBeClickableThenClick(licenseSaveBtn);

}

  public void SelectAssignDevicesInLicense() throws InterruptedException {
    waitForAngularRequestsToFinish();
    sleepMin();
    waitForElementToBeClickableThenClick(ExpandLicense);
    waitForElementToBeClickableThenClick(ClickActionBtn);
    for(int i=0; i<AssignDeviceBTNF.size();i++) {
      boolean AssignBtn = AssignDeviceBTNF.get(i).isDisplayed();
      if(AssignBtn==true) {

        AssignDeviceBTNF.get(i).click();
        waitForAngularRequestsToFinish();
        break;
      }
    }
  }

  @FindBy(xpath="//li[@class='ng-scope']/a[@class='ng-binding']")
  List<WebElement> paginationCount;

  public void LicenseAssignToDevice(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    sleepMin();
    selectListByVisibleText(SelectDeviceTypeAssign, testData.get("DeviceType"));
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenSendkeys(DeviceIdFieldInAssign,testData.get("DeviceID"));
    waitForAngularRequestsToFinish();
    try {
      driver.findElement(By.xpath("//td[text()='"+testData.get("DeviceID")+"']/..//div")).click();
    } catch(Exception e){
      scrollDownTill(1000);
      for(int i=1; i<=paginationCount.size(); i++) {
        System.out.println(paginationCount.size());
        System.out.println("//a[text()='"+(i+1)+"']");
        driver.findElement(By.xpath("//a[text()='"+(i+1)+"']")).click();
        waitForAngularRequestsToFinish();
        System.out.println(driver.findElement(By.xpath("//table[@class='table']/tbody")).getText());
        if(!driver.findElement(By.xpath("//table[@class='table']/tbody")).getText().equals("")) {
          driver.findElement(By.xpath("//td[text()='"+testData.get("DeviceID")+"']/..//div")).click();
          break;
        }
      }
    }

    //selectListByVisibleText(SelectDeviceStatus, "ASSIGNED");
    //selectListByVisibleText(SelectDataStatus, "Provisioned");

  }

  public void DeviceAssignToLicense(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    selectListByVisibleText(SelectDeviceTypeAssign, testData.get("DeviceType"));
    waitForElementToBeClickableThenSendkeys(DeviceIdFieldInAssign,testData.get("DeviceID"));
    driver.findElement(By.xpath("//td[text()='"+testData.get("DeviceID")+"']/..//div")).click();
    waitForElementToBeClickableThenClick(ClickAssign);
    waitForAngularRequestsToFinish();
  }

  public void ConformAssignDevice(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(ClickAssign);
    waitForElementToBeClickableThenClick(SelectArrowDropDown);
    WebElement assignSettings=driver.findElement(By.xpath("//div[contains(text(),'"+testData.get("Setting")+"')]"));
    waitForElementToBeClickableThenClick(assignSettings);
    waitForElementToBeClickableThenClick(ConformAssignDevicePopup);
    waitForAngularRequestsToFinish();
    sleepMin();
  }

  public void searchTenant(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showFiltersBtn);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(selectTenetID,"Tenant ID");
    selectListByVisibleText(selectEquals,"equals");
    //waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,testData.get("TenantID"));
    waitForElementToBeClickableThenClearThenSendkeys(EnterTenantIDValue,testData.get("TenantID"));
    waitForElementToBeClickableThenClick(filterBtn);
    sleepMAX();
  }

  public String verifyNavigateToSettinsPage() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(SettingsIcon);
    waitForAngularRequestsToFinish();
    String viewsettingpageStatus = getWebelementText(VerifySettingPageText);

    if(viewsettingpageStatus!=null) {
      return viewsettingpageStatus ;
    } else {
      return null;
    }


  }

  public String verifyNewButtonINSettings() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(VerifyNewBTN);
    waitForAngularRequestsToFinish();
       String NewsettingpageStatus = getWebelementText(VerifyNewDeviceSettingPage);

    if(NewsettingpageStatus!=null) {
      return NewsettingpageStatus;
    } else {
      return null;
    }
  }

  public String verifyEditButtonINSettings() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(VerifyEditBTN);
    waitForAngularRequestsToFinish();
       String EditsettingpageStatus = getWebelementText(VerifyEditDeviceSettingPage);
    if(EditsettingpageStatus!=null) {
      return EditsettingpageStatus;
    } else {
      return null;
    }
  }

  public void verifyCloneButtonINSettings() throws InterruptedException {
    waitForElementToBeClickableThenClick(VerifyCloneBTN);
  }

  public void verifyChangeSettingsButtonINSettings() throws InterruptedException {
    waitForElementToBeClickableThenClick(VerifyChangeSettingsBTN);
  }

  public void CancelAfterSettingPage() throws InterruptedException {
    waitForElementToBeClickableThenClick(CancelBtn);
  }

  public void UnAssignDevice() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(CheckBoxAssignDevice);
    waitForElementToBeClickableThenClick(SelectUnAssign);
    selectListByVisibleText(EnterNotAssigned,"NOT_ASSIGNED");
    waitForElementToBeClickableThenClick(ConformUnAssign);
    waitForAngularRequestsToFinish();
  }

  public void deleteCreatedLicense() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(ExpandLicense);
    waitForElementToBeClickableThenClick(ClickActionBtn);
    for(int i=0; i<DeleteBTNF.size(); i++) {
      boolean AssignBtn = DeleteBTNF.get(i).isDisplayed();
      if(AssignBtn==true) {
        DeleteBTNF.get(i).click();
        sleepMAX();
        break;
      }

    }
    sleepAvg();
  }

  public void deleteConformationLicense() throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(DeleteConformBtn);
    waitForAngularRequestsToFinish();
  }

  //----------------------------------------endedddd-----------------------------------------------











//********************************Bhanu*****************************

//VMM_3361
public void checkAddAnotherCheckBox() {
  //waitForElementToBeClickableThenClick(licenseNewBtn);


}

  public void createAppLicense(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();

    //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);


    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    sleepMAX();
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    if(testData.get("ExpiryDate")!="")
            waitForElementToBeClickableThenClearThenSendkeys(ExpiryDateTextBox, testData.get("ExpiryDate"));

    if(testData.get("SoftwareVersion")!="")
      selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
    //waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));
    sleepMin();

    if(testData.get("addAnother").equals("YES")) {
      waitForElementToBeClickableThenClick(AddAnotherCheckbox);
    }
    waitForElementToBeClickableThenClick(licenseSaveBtn);
  }


  public void createFeatureAppRedaction(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    //sleepMAX();

    ///selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);


    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    sleepMAX();
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
    //System.out.println(testData.get("Software Version"));
    //selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));


    waitForElementToBeClickableThenClick(licenseSaveBtn);
  }


  public String verifyCeatedLicense(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    sleepAvg();
    waitForElementToBeClickableThenClick(showFiltersBtn);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(selectTenetIDB,"Tenant ID");
    selectListByVisibleText(selectEqualsB,"equals");
    waitForElementToBeClickableThenSendkeys(EnterTenantIDValueB,testData.get("TenantID").toLowerCase());

    waitForElementToBeClickableThenClick(filterBtn);
    sleepMin();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(ExpandLicense);
    sleepMin();
    /*for(int i=0; i<licenseTypeSText.size(); i++)
	{
		if(licenseTypeSText.get(i).getText().equalsIgnoreCase(testData.get("License Type")))
		{
			return testData.get("TenantID").toLowerCase();
		}
	}*/
    String LicenseId = tenantIdForLicense.getText();


    return LicenseId;
  }


  public void publishFeatureAppRedaction() throws InterruptedException {
    waitForElementToBeClickableThenClick(featureAppActionButton);
    sleepMin();

    for(int i=0; i<AppLicensePublishButtonS.size();i++) {
      boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        AppLicensePublishButtonS.get(i).click();
        break;
      }
    }

    //waitForElementToBeClickableThenClick(publishFAbtn);
    sleepMin();
  }

  public String publishFeatureAppOkButton() throws InterruptedException {
    sleepAvg();
    //boolean result = publishOkBtn.isDisplayed();
    waitForElementToBeClickableThenClick(publishOkBtn);
    String alertMsg = Alertpopup.getText();

    return alertMsg;
  }


  public void clickPublishAppLicense() throws InterruptedException {
    sleepAvg();

    waitForElementToBeClickableThenClick(AppLicenseActionButton);
    sleepAvg();

    for(int i=0; i<AppLicensePublishButtonS.size();i++) {
      boolean DeleteBtn = AppLicensePublishButtonS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        AppLicensePublishButtonS.get(i).click();
        break;
      }
    }
    //waitForElementToBeClickableThenClick(AppLicensePublishButton);
    sleepMin();
  }


  public String clickOnVerifyCheckboxAndVerifyDownload() throws InterruptedException {

   // List<WebElement> CountOfCheckBox = driver.findElements(By.xpath("//input[@value='Download Licenses']"));

    //	if(CountOfCheckBox.size()>0)
    //		waitForElementToBeClickableThenClick(DownloadLicenseCheckBox);

    sleepMin();
    waitForElementToBeClickableThenClick(publishOkBtn);
    String alertMsg = Alertpopup.getText();
    sleepMin();
    return alertMsg;
  }

  public void clickOnActionBtn() throws InterruptedException {
    for(int i=0; i<vehicleLicenseActionBtnS.size();i++) {
      boolean actionBtn = vehicleLicenseActionBtnS.get(i).isDisplayed();
      if(actionBtn==true) {
        vehicleLicenseActionBtnS.get(i).click();
        sleepMin();
        break;
      }
    }
  }

  public String deleteAppLicense(Map<String, String> testData) throws InterruptedException {
    sleepMin();
    //waitForElementToBeClickableThenClick(AppLicenseActionButton);
    clickOnActionBtn();
    for(int i=0; i<AppLicenseEditeBtnS.size();i++) {
      boolean DeleteBtn = AppLicenseEditeBtnS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        AppLicenseEditeBtnS.get(i).click();
        break;
      }
    }

    //waitForElementToBeClickableThenClick(AppLicenseEditeBtn);

    waitForAngularRequestsToFinish();
    sleepMAX();
    selectListByVisibleText(LicenseStatus, "RETURN");
    sleepMin();
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    //Method calling
    String Licenseid = verifyCeatedLicense(testData);

    sleepMin();
    //waitForElementToBeClickableThenClick(AppLicenseActionButton);
    clickOnActionBtn();
    //waitForElementToBeClickableThenClick(AppLicenseDeleteBtn);
    ///System.out.println(AppLicenseDeleteBtns.size());
    for(int i=0; i<AppLicenseDeleteBtns.size();i++) {
      boolean DeleteBtn = AppLicenseDeleteBtns.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        AppLicenseDeleteBtns.get(i).click();
        break;
      }
    }
    sleepAvg();
    waitForElementToBeClickableThenClick(AppLicenseDeleteConfirmBtn);
    waitForAngularRequestsToFinish();
    return Licenseid;
  }

  public String deleteAssetLicense(Map<String, String> testData) throws Exception {
    sleepMin();
    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
    String licenseId = verifyCeatedLicense(testData);

    clickOnActionBtn();

    for(int i=0; i<FeatureAppEditBtnS.size();i++) {
      boolean Button = FeatureAppEditBtnS.get(i).isDisplayed();
      //System.out.println(Button);
      if(Button==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        FeatureAppEditBtnS.get(i).click();
        break;
      }
    }
    waitForAngularRequestsToFinish();
    sleepMAX();
    selectListByVisibleText(LicenseStatus, "RETURN");
    sleepMin();
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    sleepAvg();
    //Method calling
    verifyCeatedLicense(testData);
    waitForElementToBeClickableThenClick(statusSortBtn);
    clickOnActionBtn();
    for(int i=0; i<FeatureAppLicenseDeleteBtnS.size();i++) {
      boolean Button = FeatureAppLicenseDeleteBtnS.get(i).isDisplayed();
      //System.out.println(Button);
      if(Button==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        FeatureAppLicenseDeleteBtnS.get(i).click();
        break;
      }
    }
    sleepAvg();
    return licenseId;
  }

  public String deleteFeatureAppLicense(Map<String, String> testData) throws Exception {
    sleepMin();
    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
    String licenseId = verifyCeatedLicense(testData);

    clickOnActionBtn();

    for(int i=0; i<FeatureAppEditBtnS.size();i++) {
      boolean Button = FeatureAppEditBtnS.get(i).isDisplayed();
      //System.out.println(Button);
      if(Button==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        FeatureAppEditBtnS.get(i).click();
        break;
      }
    }
    waitForAngularRequestsToFinish();
    sleepMAX();
    selectListByVisibleText(LicenseStatus, "RETURN");
    sleepMin();
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    sleepAvg();
    //Method calling
    verifyCeatedLicense(testData);

    clickOnActionBtn();
    for(int i=0; i<FeatureAppLicenseDeleteBtnS.size();i++) {
      boolean Button = FeatureAppLicenseDeleteBtnS.get(i).isDisplayed();
      //System.out.println(Button);
      if(Button==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        FeatureAppLicenseDeleteBtnS.get(i).click();
        break;
      }
    }
    sleepAvg();
    return licenseId;
  }

  public void deleteConfirmation() throws InterruptedException {
    waitForElementToBeClickableThenClick(FeatureAppLicenseDeleteConfirmBtn);

    waitForAngularRequestsToFinish();
    sleepMAX();
    //driver.navigate().refresh();
    //waitForAngularRequestsToFinish();
  }

  //VMM_3362
  public String createVehicleLicense(Map<String, String> testData) throws InterruptedException {
    //waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();

    //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    sleepMAX();
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));

    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    if(testData.get("addAnother").equals("YES")) {
      waitForElementToBeClickableThenClick(AddAnotherCheckbox);
    }
    waitForElementToBeClickableThenClick(licenseSaveBtn);

    String alertMsg = Alertpopup.getText();
    sleepMin();
    return alertMsg;
  }

  public String publishVehicleLicense(Map<String, String> testData) throws InterruptedException {
    sleepMin();
    //waitForElementToBeClickableThenClick(vehicleLicenseActionBtn);
    for(int i=0; i<vehicleLicenseActionBtnS.size();i++) {
      boolean actionBtn = vehicleLicenseActionBtnS.get(i).isDisplayed();
      if(actionBtn==true) {
        vehicleLicenseActionBtnS.get(i).click();
        waitForAngularRequestsToFinish();
        break;
      }
    }

    for(int i=0; i<vehicleLicensePublishBtnS.size();i++) {
      boolean DeleteBtn = vehicleLicensePublishBtnS.get(i).isDisplayed();
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        vehicleLicensePublishBtnS.get(i).click();
        break;
      }
    }
    //waitForElementToBeClickableThenClick(vehicleLicensePublishBtn);
    sleepMin();
    waitForElementToBeClickableThenClick(publishOkBtn);
    String alertMsg = Alertpopup.getText();

    return alertMsg;
  }

  public String deleteVehicleLicense(Map<String, String> testData) throws InterruptedException {
    sleepMin();
    int j = 0;
    String licenseId = verifyCeatedLicense(testData);

    sleepMin();

    System.out.println(vehicleLicenseActionBtnS.size());
    for(int i=0; i<vehicleLicenseActionBtnS.size();i++) {
      boolean ActionBtn = vehicleLicenseActionBtnS.get(i).isDisplayed();
      //System.out.println(ActionBtn);
      if(ActionBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        vehicleLicenseActionBtnS.get(i).click();
        j=i;
        break;
      }
    }
    //waitForElementToBeClickableThenClick(vehicleLicenseActionBtn);

    sleepAvg();
    //waitForElementToBeClickableThenClick(vehicleLicenseEditBtn);
    for(int i=0; i<vehicleLicenseEditBtnS.size();i++) {
      boolean DeleteBtn = vehicleLicenseEditBtnS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        vehicleLicenseEditBtnS.get(i).click();
        break;
      }
    }

    waitForAngularRequestsToFinish();
    sleepMAX();
    selectListByVisibleText(LicenseStatus, "RETURN");
    sleepMin();
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    //Method calling
    verifyCeatedLicense(testData);

    sleepMin();
    vehicleLicenseActionBtnS.get(j).click();
    //waitForElementToBeClickableThenClick(vehicleLicenseActionBtn);
    sleepAvg();

    for(int i=0; i<vehicleLicenseDeleteBtnS.size();i++) {
      boolean DeleteBtn = vehicleLicenseDeleteBtnS.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(DeleteBtn==true) {
        ///System.out.println(i);
        //driver.findElement(By.xpath("(//ul[@role='menu']["+(i+1)+"]//span[text()='Delete'])[1]")).click();
        vehicleLicenseDeleteBtnS.get(i).click();
        break;
      }
    }
    waitForElementToBeClickableThenClick(AppLicenseDeleteConfirmBtn);
    waitForAngularRequestsToFinish();
    //waitForElementToBeClickableThenClick(vehicleLicenseDeleteBtn);
    sleepMin();
    return licenseId;
  }

  public void deleteConfirmationButton() throws InterruptedException {
    waitForElementToBeClickableThenClick(AppLicenseDeleteConfirmBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();
    //	driver.navigate().refresh();
    //waitForAngularRequestsToFinish();
  }

  public String createLiceseWithQty(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();

    String alertMsg = createVehicleLicense(testData);

    return alertMsg;
  }

  public String publishLicense(Map<String, String> testData) throws InterruptedException {
    //methodCalling
    clickPublishAppLicense();
    String AlertMsg =publishFeatureAppOkButton();

    return AlertMsg;
  }

  public String clickOnGenerateKeysToTMGsite(String env, Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    sleepMin();
    waitForElementToBeClickableThenClick(AppLicenseActionButton);
    sleepMin();
    // waitForElementToBeClickableThenClick(generateKeysButton);

    for(int i=0; i<generateKeysButton.size();i++) {
      boolean generateBtn = generateKeysButton.get(i).isDisplayed();
      if(generateBtn==true) {
        ///System.out.println(i);
        generateKeysButton.get(i).click();
        break;
      }
    }

    waitForAngularRequestsToFinish();

    String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    for (String windowHandle : allWindowHandles) {
      // Switch to the desired window
      if (!windowHandle.equals(mainWindowHandle)) {
        driver.switchTo().window(windowHandle);
        break;
      }
    }
    if(env.equals("STG")) {
      waitForElementToBeClickableThenClick(AdvanceBtn);
      waitForElementToBeClickableThenClick(ProceedLnk);
    }
    //driver.navigate().to("https://test-tenant-manager.safefleetcloud.com/api-client");
    //driver.navigate().to("https://stg-tenant-manager.safefleetcloud.com/api-client");
    waitForAngularRequestsToFinish();
    sleepMAX();
    sleepMAX();
    waitForAngularRequestsToFinish();
    String title = driver.getTitle();

    return title;
  }


  public String verifyApiClientNameScheme(Map<String, String> testData) throws InterruptedException {

    sleepMin();
    waitForElementToBeClickableThenSendkeys(TMfilterCheckBox, testData.get("TenantID").toLowerCase());
    waitForAngularRequestsToFinish();
    sleepMAX();
    waitForAngularRequestsToFinish();

    String TMtenantId = TMtenantIdTxt.getText();
    System.out.println(TMtenantId);

    String TMClientName = TMClientNameTxt.getText();
    System.out.println(TMClientName);

    String TMApiClientId = TMApiClientIdTxt.getText();
    System.out.println(TMApiClientId);

    System.out.println("Tenant id : "+TMtenantId+" and API CLIENT ID : "+TMApiClientId);

    return "Tenant id : "+TMtenantId+" AND API CLIENT ID : "+TMApiClientId;
  }

  public void createAppLicenseWithServer(Map<String, String> testData, String env) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    waitForElementToAppear(inauguralDateField);
    //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    if (!testData.get("SoftwareVersion").isEmpty())
      selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));

    if(!testData.get("QTY").isEmpty())
    waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));

    String licenseServer = null;
    if (env.equals("DEV"))
      licenseServer = testData.get("Server_DEV");
    else if (env.equals("STG"))
      licenseServer = testData.get("Server_STG");
    else
      licenseServer = testData.get("Server");
    if (!licenseServer.isEmpty())
      selectListByVisibleText(server, licenseServer);

    if (testData.get("addAnother").equals("YES")) {
      waitForElementToBeClickableThenClick(AddAnotherCheckbox);
    }
  }

  public String clickOnSave() throws InterruptedException {

    waitForElementToBeClickableThenClick(licenseSaveBtn);

    String alertMsg = Alertpopup.getText();
    sleepMin();
    return alertMsg;
  }


  ///4394

  public void createDVRFirmwareLicense(Map<String, String> testData) throws InterruptedException {

    waitForAngularRequestsToFinish();

    createExpiredSFCommanderLicense(testData);

  }


  public String verifyAssignDeviceForDH8(Map<String, String> testData) throws InterruptedException {

    String licenseId = verifyCeatedLicense(testData);

    String AssignDeviceResult = null;

    waitForElementToBeClickableThenClick(DH8ActionBtn);
    sleepMin();


    for(int i=0; i<AssignDeviceAttributeS.size();i++) {
      boolean AssignBtn = AssignDeviceAttributeS.get(i).isDisplayed();
      if(AssignBtn==true) {
        AssignDeviceResult = AssignDeviceAttributeS.get(i).getAttribute("aria-disabled");
        break;
      }
    }

        /*	AssignDeviceResult = driver.findElement(By.xpath("(//span[text()='Assign Devices'])[5]/..")).getAttribute("aria-disabled");
	    	System.out.println(AssignDeviceResult +"==fasle means its visible");*/

    return AssignDeviceResult;
  }

  public String verifyAssignDeviceForDH6(Map<String, String> testData) throws InterruptedException {

    String AssignDeviceResult = null;

    waitForElementToBeClickableThenClick(DH6ActionBtn);
    sleepMin();

    for(int i=0; i<AssignDeviceAttributeS.size();i++) {
      boolean AssignBtn = AssignDeviceAttributeS.get(i).isDisplayed();
      if(AssignBtn==true) {
        AssignDeviceResult = AssignDeviceAttributeS.get(i).getAttribute("aria-disabled");
        break;
      }
    }

    return AssignDeviceResult;
  }

  public String verifyAssignDeviceForSFlive(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(AddConditionBtn);
    sleepMin();

    selectListByVisibleText(selectTenetIDB,testData.get("License1"));
    //selectListByVisibleText(selectEqualsB,"equals");
    sleepMin();

    waitForElementToBeClickableThenClick(selectTypesOfBP);
    selectListByVisibleText(selectTypesOfBP,testData.get("License2"));
    sleepMin();
    waitForElementToBeClickableThenClick(AddConditonFilterSelect);
    selectListByVisibleText(AddConditonFilterSelect,"License Type");
    //selectListByVisibleText(selectEqualsB,"equals");
    sleepMin();
    waitForElementToBeClickableThenClick(AddConditonSelectTypeOfVL);
    //System.out.println(testData.get("License4")+"  "+testData.get("License1")+"  "+testData.get("License2")+"  "+testData.get("License3") );
    selectListByVisibleText(AddConditonSelectTypeOfVL,testData.get("License4"));

    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(ExpandAllLicense);
    waitForElementToBeClickableThenClick(ExpandAllLicense);

    String AssignDeviceResult = null;
    waitForElementToBeClickableThenClick(DH6ActionBtn);

    sleepMin();

    for(int i=0; i<AssignDeviceAttributeS.size();i++) {
      boolean AssignBtn = AssignDeviceAttributeS.get(i).isDisplayed();
      if(AssignBtn==true) {
        AssignDeviceResult = AssignDeviceAttributeS.get(i).getAttribute("aria-disabled");
        break;
      }
    }

    return AssignDeviceResult;
  }


  public String verifyBaseProductLicenseAssignDeviceOption(Map<String, String> testData) throws InterruptedException {
    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showFiltersBtn);
    //waitForAngularRequestsToFinish();

    selectListByVisibleText(selectTenetIDB,"License Type");

    sleepMin();

    waitForElementToBeClickableThenClick(selectTypesOfBP);
    selectListByVisibleText(selectTypesOfBP,testData.get("License1"));


    waitForElementToBeClickableThenClick(filterBtn);


    waitForAngularRequestsToFinish();
    String AssignDeviceResult = null;
    waitForElementToBeClickableThenClick(ExpandAllLicense);
    waitForElementToBeClickableThenClick(DH6ActionBtn);
    AssignDeviceResult = driver.findElement(By.xpath("(//span[text()='Assign Devices'])[4]/..")).getAttribute("aria-disabled");
    sleepMin();
    return AssignDeviceResult;
  }


  public String verifyDeviceLicenseAssignDeviceOption(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(selectTypesOfBP);
    selectListByVisibleText(selectTypesOfBP,testData.get("License2"));
    waitForElementToBeClickableThenClick(filterBtn);


    waitForAngularRequestsToFinish();
    String AssignDeviceResult = null;
    waitForElementToBeClickableThenClick(ExpandAllLicense);
    waitForElementToBeClickableThenClick(ExpandAllLicense);

    waitForElementToBeClickableThenClick(DH6ActionBtn);
    AssignDeviceResult = driver.findElement(By.xpath("(//span[text()='Assign Devices'])[4]/..")).getAttribute("aria-disabled");
    sleepMin();
    return AssignDeviceResult;
  }

  public String verify_ADD_ON_PRODUCT_LicenseAssignDeviceOption(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(selectTypesOfBP);
    selectListByVisibleText(selectTypesOfBP,testData.get("License3"));
    waitForElementToBeClickableThenClick(filterBtn);


    waitForAngularRequestsToFinish();
    String AssignDeviceResult = null;
    waitForElementToBeClickableThenClick(ExpandAllLicense);
    waitForElementToBeClickableThenClick(ExpandAllLicense);

    waitForElementToBeClickableThenClick(DH6ActionBtn);
    AssignDeviceResult = driver.findElement(By.xpath("(//span[text()='Assign Devices'])[4]/..")).getAttribute("aria-disabled");
    sleepMin();
    return AssignDeviceResult;
  }

  //Savitha
  public String verifyAssignDevicesOptionEnabledOrDisabled() {
    String AssignDeviceResult = null;

    for(int i=0; i<AssignDeviceAttributeS.size();i++) {
      boolean AssignBtn = AssignDeviceAttributeS.get(i).isDisplayed();
      if(AssignBtn==true) {
        AssignDeviceResult = AssignDeviceAttributeS.get(i).getAttribute("aria-disabled");
        break;
      }
    }

    return AssignDeviceResult;
  }

  public void filterLicenseWithMultiCondition(Map<String, String> testData) throws InterruptedException {

    filterLicenseWithTenant(testData);

    waitForElementToBeClickableThenClick(AddConditionBtn);
    selectListByVisibleText(AddConditonSelectType2,testData.get("License1"));
    waitForElementToBeClickableThenClick(AddConditonSelectTypeV2);
    selectListByVisibleText(AddConditonSelectTypeV2,testData.get("License2"));
    waitForElementToBeClickableThenClick(AddConditionBtn);
    waitForElementToBeClickableThenClick(AddConditonSelectType3);
    selectListByVisibleText(AddConditonSelectType3,testData.get("License3"));
    waitForElementToBeClickableThenClick(AddConditonSelectTypeV3);
    selectListByVisibleText(AddConditonSelectTypeV3,testData.get("License4"));
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(hideFiltersBtn);
  }

  public String verifyAssignDeviceOptionEnabledOrNot(Map<String, String> testData) throws InterruptedException {
    filterLicenseWithMultiCondition(testData);
      /*
			try {
				if(DH6ActionBtn.isDisplayed())
					System.out.println("License section is expanded");

			}
			catch (Exception e) {
				waitForElementToBeClickableThenClick(ExpandAllLicense);
				waitForElementToAppear(DH6ActionBtn);
			}*/
    waitForElementToBeClickableThenClick(ExpandAllLicense);
    String AssignDeviceResult = null;
    waitForElementToBeClickableThenClick(DH6ActionBtn);
    sleepMin();

    for(int i=0; i<AssignDeviceAttributeS.size();i++) {
      boolean AssignBtn = AssignDeviceAttributeS.get(i).isDisplayed();
      if(AssignBtn==true) {
        AssignDeviceResult = AssignDeviceAttributeS.get(i).getAttribute("aria-disabled");
        break;
      }
    }

    return AssignDeviceResult;
  }

  public void filterLicenseWithTenantAndBaseApp(Map<String, String> testData) throws InterruptedException {
    filterLicenseWithTenant(testData);

    selectListByVisibleText(AddConditonSelectType2,testData.get("License Type"));
    waitForElementToBeClickableThenClick(AddConditonSelectTypeV2);
    selectListByVisibleText(AddConditonSelectTypeV2,testData.get("Base Product"));

    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(hideFiltersBtn);
  }

  @FindBy(xpath="(//select[@ng-model='rule.field'])[1]")
  WebElement conditionField1;

  @FindBy(xpath="(//select[@ng-model='rule.condition'])[2]")
  WebElement conditionOperation1;

  @FindBy(xpath="(//select[@ng-model='rule.condition'])[1]")
  WebElement conditionOperation1N;

  @FindBy(xpath="(//select[@ng-model='rule.model'])[1]")
  WebElement conditionFieldValue1;

  @FindBy(xpath="//*[@class='group-conditions']//input[@type='text']")
  WebElement conditionFieldValue1N;

  @FindBy(xpath="(//select[@ng-model='rule.field'])[2]")
  WebElement conditionField2;

  @FindBy(xpath="(//select[@ng-model='rule.condition'])[4]")
  WebElement conditionOperation2;

  @FindBy(xpath="(//select[@ng-model='rule.model'])[2]")
  WebElement conditionFieldValue2;

  @FindBy(xpath="(//select[@ng-model='rule.model'])[1]")
  WebElement conditionFieldValue2N;

  @FindBy(xpath="(//select[@ng-model='rule.field'])[3]")
  WebElement conditionField3;

  @FindBy(xpath="(//select[@ng-model='rule.condition'])[6]")
  WebElement conditionOperation3;

  @FindBy(xpath="(//select[@ng-model='rule.model'])[3]")
  WebElement conditionFieldValue3;

  @FindBy(xpath="(//select[@ng-model='rule.model'])[2]")
  WebElement conditionFieldValue3N;

  public void filterLicenseWithStatusBaseAppAndLicenseType(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(conditionField1,testData.get("Filter1"));
    selectListByVisibleText(conditionOperation1,testData.get("FilterOperation1"));
    selectListByVisibleText(conditionFieldValue1,testData.get("FilterValue1"));

    waitForElementToBeClickableThenClick(AddConditionBtn);
    selectListByVisibleText(conditionField2,testData.get("Filter2"));
    selectListByVisibleText(conditionOperation2,testData.get("FilterOperation2"));
    selectListByVisibleText(conditionFieldValue2,testData.get("FilterValue2"));

    waitForElementToBeClickableThenClick(AddConditionBtn);
    //waitForElementToBeClickableThenClick(conditionField3);
    selectListByVisibleText(conditionField3,testData.get("Filter3"));
    selectListByVisibleText(conditionOperation3,testData.get("FilterOperation3"));
    //waitForElementToBeClickableThenClick(conditionFieldValue3);
    selectListByVisibleText(conditionFieldValue3,testData.get("FilterValue3"));

    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    //waitForElementToBeClickableThenClick(hideFiltersBtn);
  }

  public void searchLicenseWithTenantAndMultiCondition(Map<String, String> testData) throws InterruptedException {
    waitForElementToAppear(conditionField1);
    selectListByVisibleText(conditionField1, testData.get("Filter1"));
    selectListByVisibleText(conditionOperation1N, testData.get("FilterOperation1"));
    waitForElementToBeClickableThenClearThenSendkeys(conditionFieldValue1N, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(AddConditionBtn);
    selectListByVisibleText(conditionField2, testData.get("Filter2"));
    //waitForElementToBeClickableThenClick(conditionFieldValue2);
    selectListByVisibleText(conditionFieldValue2N, testData.get("FilterValue2"));

    waitForElementToBeClickableThenClick(AddConditionBtn);
    waitForElementToBeClickableThenClick(conditionField3);
    selectListByVisibleText(conditionField3, testData.get("Filter3"));
    waitForElementToBeClickableThenClick(conditionFieldValue3N);
    selectListByVisibleText(conditionFieldValue3N, testData.get("FilterValue3"));
    sleepMin();
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(hideFiltersBtn);

  }

    public void filterLicenseWithTenant(Map<String, String> testData) throws InterruptedException {
    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
      /*
			try {
				if(AddConditionBtn.isDisplayed())
					System.out.println("Filter section is expanded");
				else {
					waitForElementToBeClickableThenClick(showFiltersBtn);
				}
				if(ClearBtn.isEnabled())
					waitForElementToBeClickableThenClick(ClearBtn);
			}
			catch (Exception e) {

			}*/
    waitForElementToBeClickableThenClick(showFiltersBtn);
    //waitForElementToBeClickableThenClick(AddConditionBtn);
    selectListByVisibleText(AddConditonSelectType1,"Tenant ID");
    selectListByVisibleText(AddConditonSelectTypeC1,"equals");
    waitForElementToBeClickableThenClearThenSendkeys(AddConditonSelectTypeV1, testData.get("TenantID"));

  }

  public void filterExpiredLicenseWithMultiConditions(Map<String, String> testData) throws InterruptedException {
    String currentDate = getCurrentDate();

    waitForElementToBeClickableThenClick(showAllFieldsCheckBox);
    waitForElementToBeClickableThenClick(showFiltersBtn);
    selectListByVisibleText(AddConditonSelectType1,testData.get("Licencesfilter1"));
    selectListByVisibleText(AddConditonSelectTypeC1,"less than");
    waitForElementToBeClickableThenClearThenSendkeys(AddConditonSelectTypeV1,currentDate );

    waitForElementToBeClickableThenClick(AddConditionBtn);
    selectListByVisibleText(AddConditonSelectType2,testData.get("Licencesfilter2"));
    waitForElementToBeClickableThenClick(AddConditonSelectTypeV2);
    selectListByVisibleText(AddConditonSelectTypeV2,testData.get("Licencesfilter3"));

    waitForElementToBeClickableThenClick(AddConditionBtn);
    waitForElementToBeClickableThenClick(AddConditonSelectType3);
    selectListByVisibleText(AddConditonSelectType3,testData.get("Licencesfilter4"));
    waitForElementToBeClickableThenClick(AddConditonSelectTypeV3);
    selectListByVisibleText(AddConditonSelectTypeV3,testData.get("Licencesfilter5"));
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(hideFiltersBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showAllFieldsCheckBox);
    waitForElementToBeClickableThenClick(ExpandLicense);
  }


  ///VMM_4338

  public String searchExpiredSFCommanderLicense(Map<String, String> testData) throws InterruptedException {

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(ShowAllFieldsCheckBox);

    waitForElementToBeClickableThenClick(showFiltersBtn);


    selectListByVisibleText(selectTenetIDB,"Base Product");

    sleepMin();

    waitForElementToBeClickableThenClick(selectTypesOfBP);
    selectListByVisibleText(selectTypesOfBP,testData.get("License1"));

    waitForElementToBeClickableThenClick(filterBtn);

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(AddConditionBtn);
    sleepMin();

    waitForElementToBeClickableThenClick(AddConditonFilterSelect);
    selectListByVisibleText(AddConditonFilterSelect,"Status");

    waitForElementToBeClickableThenClick(AddConditonSelectTypeOfVL);
    selectListByVisibleText(AddConditonSelectTypeOfVL,testData.get("Status"));

    waitForElementToBeClickableThenClick(filterBtn);

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(ExpandAllLicense);

    return null;
  }

  public String[] verifyLicenseStatus(Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(ShowAllFieldsCheckBox);
    waitForAngularRequestsToFinish();

    String licenseActiveStatuText=LicenseStatusText.getText();

    scrollToElement("//span[text()='Renewal Status']");
    sleepMin();

    scrollToElement("//span[text()='QTY Used']");
    sleepMin();

    scrollToElement("//span[text()='Deployment Type']");
    sleepMin();

    scrollToElement("//span[text()='License ID']");
    sleepMin();

    String LicenseIdText = null;
    //String LicenseIdText = SFcommanderLicenseId.getText();
    for(int i=0; i<SFcommanderLicenseIdS.size();i++) {
      if(SFcommanderLicenseIdS.size()==i+1) {
        LicenseIdText=SFcommanderLicenseIdS.get(i).getText();
        break;
      }
    }

    System.out.println("LicenseId Is="+LicenseIdText+" AND Status ="+licenseActiveStatuText);

    return new String[] {licenseActiveStatuText,LicenseIdText};
  }

  public void createExpiredSFCommanderLicense(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();

    //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));

    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    sleepMin();
    selectListByVisibleText(server,testData.get("Server"));
    //	waitForAngularRequestsToFinish();
    sleepMin();

    if(testData.get("Part #")!="")
      waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));

    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    if(testData.get("SoftwareVersion")!="")
      selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));

    if(testData.get("j1939")!="")
      selectListByVisibleText(j1939, testData.get("j1939"));

    if(testData.get("integration")!="")
      selectListByVisibleText(integrtion, testData.get("integration"));

    if(testData.get("addAnother").equals("YES")) {
      waitForElementToBeClickableThenClick(AddAnotherCheckbox);
    }

    if(testData.get("ExpiryDate")!="")
      waitForElementToBeClickableThenClearThenSendkeys(ExpiryDateTextBox, testData.get("ExpiryDate"));

    if(testData.get("Inaugural_Date")!="")
      waitForElementToBeClickableThenClearThenSendkeys(InauguralDateTextBox, testData.get("Inaugural_Date"));

    if(testData.get("QTY")!="")
      waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));

  }

  public void createDVRLicense(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
sleepMin();
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));

    selectListByVisibleText(licenseTypefield, testData.get("License Type"));

    //	waitForAngularRequestsToFinish();
    sleepMAX();

    if(testData.get("Part #")!="")
      waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));

    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    if(testData.get("SoftwareVersion")!="")
      selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));

//	if(testData.get("j1939")!="")
    selectListByVisibleText(j1939, testData.get("j1939"));

//	if(testData.get("integration")!="")
    selectListByVisibleText(integrtion, testData.get("integration"));

    if(testData.get("addAnother").equals("YES")) {
      waitForElementToBeClickableThenClick(AddAnotherCheckbox);
    }

    if(testData.get("ExpiryDate")!="")
      waitForElementToBeClickableThenClearThenSendkeys(ExpiryDateTextBox, testData.get("ExpiryDate"));

    if(testData.get("Inaugural_Date")!="")
      waitForElementToBeClickableThenClearThenSendkeys(InauguralDateTextBox, testData.get("Inaugural_Date"));

    if(testData.get("QTY")!="")
      waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));

}


///4439
public String[] assignDeviceToVerifyInDB(Map<String, String> testData) throws InterruptedException {

  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(showFiltersBtn);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectTenetIDB,"Base App");
  sleepMin();
  waitForElementToBeClickableThenClick(selectTypesOfBP);
  selectListByVisibleText(selectTypesOfBP,testData.get("License1"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ShowAllFieldsCheckBox);
  sleepMin();
  waitForElementToBeClickableThenClick(ExpandAllLicense);
  sleepMin();
  scrollToElement("//span[text()='Renewal Status']");
  sleepMin();
  scrollToElement("//span[text()='QTY Used']");
  sleepMin();
  scrollToElement("//span[text()='Deployment Type']");
  sleepMin();
  scrollToElement("//span[text()='License ID']");
  sleepMAX();
  String LicenseIdText = LicenseId.getText();
  System.out.println("License id is ="+LicenseIdText);
  waitForElementToBeClickableThenClick(DH6ActionBtn);
  sleepMin();

  for(int i=0; i<AssignDeviceBtnS.size();i++) {
    boolean DeleteBtn = AssignDeviceBtnS.get(i).isDisplayed();
    if(DeleteBtn==true) {
      AssignDeviceBtnS.get(i).click();
      break;}
  }

  waitForAngularRequestsToFinish();

  waitForElementToBeClickableThenClick(DeviceTypeDropDown);

  selectListByVisibleText(DeviceTypeDropDown,testData.get("AssignDeviceType"));

  waitForAngularRequestsToFinish();

  waitForElementToBeClickableThenClick(selectDeviceTypeToAssign);

  waitForElementToBeClickableThenClick(AssignBtn);

  waitForAngularRequestsToFinish();

  if(AssignBtn.isDisplayed())
    return new String[] {"ASSIGNED",LicenseIdText};
  else
    return new String[] {"NOTASSIGNED",LicenseIdText};


}


  public boolean verifyAvailableDevicesWithDeviceTypes(List<String> listOfDeviceTypes) {

    waitForElementToBeClickableThenClick(DeviceTypeDropDown);
    List<String> ListOfAvailableDeviceType=new ArrayList<>();
    for(int i=0;i<ListOfAvailableDeviceTypeInAssignDevicePage.size();i++) {
      String Name = ListOfAvailableDeviceTypeInAssignDevicePage.get(i).getText();
      if(!Name.isEmpty())
        ListOfAvailableDeviceType.add(Name);
    }

    boolean Result = listOfDeviceTypes.containsAll(ListOfAvailableDeviceType);
    System.out.println("listOfDeviceTypes from Device Type screen: "+listOfDeviceTypes);
    System.out.println("listOfDeviceTypes from Device Type screen: "+ListOfAvailableDeviceType);
    return Result;
  }

  public void refreshPage() {

    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
  }

  public void unAssignTheDevice() throws InterruptedException {

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(SelectAllDevicesToUnassign);

    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(SelectUnAssign);

    waitForAngularRequestsToFinish();
    sleepMin();

    selectListByVisibleText(EnterNotAssigned,"NOT_ASSIGNED");
    sleepMin();

    waitForElementToBeClickableThenClick(ConformUnAssign);

    waitForAngularRequestsToFinish();

  }

  ///3572
  public void createFeatureAppDesCloudCourierLicense(Map<String, String> testData) throws InterruptedException {

    waitForAngularRequestsToFinish();

    createExpiredSFCommanderLicense(testData);

  }




////**********************************************************




//---------------------Sunilkumar(VMM3285)-------------------------------------
public void verifyserver(Map<String, String> testData) throws Exception {
  sleepMAX();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  sleepMin();
  waitForAngularRequestsToFinish();
  //selectListByVisibleText(licenseTenantID, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);
  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  sleepMin();
}

public String verifyserverlabel() {
  String text = serverlabelonlicensepage.getText();
  return text;

}
//---------------------------Sunilkumar(VMM3284)--------------------------------------
public ArrayList<String> clickcreateLicense(Map<String, String> testData) throws Exception {
  sleepMin();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  waitForAngularRequestsToFinish();
  sleepMAX();

  //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);


  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  sleepMAX();
  waitForElementToBeClickableThenClick(serverfield);
  sleepMin();

  List<WebElement> serverOption = driver.findElements(By.xpath("//select[@id='field_server']/option"));
  sleepMin();
  int count =serverOption.size();
  //System.out.println(count);
  ArrayList<String> baseServers=new ArrayList<>();
  for(int i=2;i<=count;i++) {
    WebElement ele=driver.findElement(By.xpath("(//select[@id='field_server']/option)[" +i+ "]"));
    String str = ele.getAttribute("label");
    baseServers.add(str);
  }
  //System.out.println(baseServers);
  sleepMin();
  return baseServers;

}
//---------------------------------------------------End(VMM3284)--------------------------------------------------



//---------------------------------------------------Sunilkumar(VMM4423)--------------------------------------------------
public void  CreateAPPandH2DeviceLicenses(Map<String, String> testData) throws Exception {
  sleepMin();
  waitForElementToBeClickableThenClick(licenseNewBtn);
  waitForAngularRequestsToFinish();
  sleepMAX();

//	selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);

  sleepMin();
  selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
  sleepMin();
  selectListByVisibleText(licenseTypefield, testData.get("License Type"));
  sleepMAX();
  waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
  sleepMin();
  selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
  sleepMin();
  selectListByVisibleText(server,testData.get("Server"));
  sleepMin();

  if(testData.get("addAnother").equals("YES")) {
    waitForElementToBeClickableThenClick(AddAnotherCheckbox);
  }
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  sleepMAX();
  selectListByVisibleText(licenseTypefield, testData.get("License1"));
  waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
  sleepMin();
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  //driver.navigate().refresh();

}

public void PublishMultipleLicenses() throws InterruptedException {

  waitForElementToBeClickableThenClick(ActionBTNCommercial);
  sleepMin();
  for(int i=0; i<PublishBTNCommercial.size();i++) {
    boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
    if(PublishBtn==true) {
      PublishBTNCommercial.get(i).click();
      break;
    }
  }
  waitForElementToBeClickableThenClick(PublishOkBTN);
  waitForAngularRequestsToFinish();

  waitForElementToBeClickableThenClick(ActionBTNH2);
  sleepMin();
  for(int i=0; i<PublishBTNCommercial.size();i++) {
    boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
    if(PublishBtn==true) {
      PublishBTNCommercial.get(i).click();
      break;
    }
  }
  waitForElementToBeClickableThenClick(PublishOkBTN);
  waitForAngularRequestsToFinish();

  waitForElementToBeClickableThenClick(ActionBTNH3);
  sleepMin();
  publishVisibleLicense();
  waitForElementToBeClickableThenClick(PublishOkBTN);
  waitForAngularRequestsToFinish();
}

public void navigatetoLicenseCheck() throws InterruptedException {

  waitForElementToBeClickableThenClick(LicensesCheckNavigate);
  sleepMAX();
  sleepMin();



}


//-----------------------------Sunilkumar(VMM3846)--------------------
public void cloudCommercialwithequals(Map<String, String> testData) throws Exception {
  sleepMin();
  waitForElementToBeClickableThenClick(showallfieldcheckBox);
  sleepAvg();
  waitForElementToBeClickableThenClick(showFiltersBtn);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(conditionfieled,"equals");
  sleepMin();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(datainputfield,testData.get("Licencesfilter3"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);


}
public String verifyfilter() {

  String text = cloudcommercialsymbl.getText();

  return text;

}


public void deploymentTypefilternotequal(Map<String, String> testData) throws Exception {
  sleepMin();
  waitForElementToBeClickableThenClick(clickClear);
  waitForAngularRequestsToFinish();

  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  waitForElementToBeClickableThenSendkeys(conditionfieled,"not equal");
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(datainputfield,testData.get("Licencesfilter3"));

  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);


}



public void deploymentTypefiltercontains(Map<String, String> testData) throws Exception {

  sleepAvg();
  waitForElementToBeClickableThenClick(clickClear);
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  selectListByVisibleText(conditionfieled,"contains");
  sleepMin();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(datainputfield,testData.get("Licencesfilter3"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);

}


public void onsitewithcontains(Map<String, String> testData) throws Exception {

  sleepAvg();
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(clickClear);
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  selectListByVisibleText(conditionfieled,"contains");
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(datainputfield,testData.get("Licencesfilter3").toLowerCase());
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);

}
public void onsitewithequals(Map<String, String> testData) throws Exception {

  waitForElementToBeClickableThenClick(clickClear);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(conditionfieled,"equals");
  sleepMin();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(datainputfield,testData.get("Licencesfilter3"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);


}


public void scrolltodeploymenttype() throws Exception {
  scrollToElement("//span[text()='Renewal Status']");
  sleepMin();

  scrollToElement("//span[text()='QTY Used']");
  sleepMin();

  scrollToElement("//span[text()='Deployment Type']");
  sleepMin();

  scrollToElement("//span[text()='License ID']");
}

public void scrolltolicensetype() throws Exception {
  scrollToElement("//span[text()='QTY Used']");
  sleepMin();
  scrollToElement("//span[text()='Renewal Status']");
  sleepMin();
  scrollToElement("//span[text()='License Type']");
}




public void licensetypewithequals(Map<String, String> testData) throws Exception {

  waitForElementToBeClickableThenClick(clickClear);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(conditionfieled,"equals");
  sleepMin();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(LicenceTypedatainputfield,testData.get("Licencesfilter3"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);


}


public void licensetypewithnotequals(Map<String, String> testData) throws Exception {

  waitForElementToBeClickableThenClick(clickClear);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectfield, testData.get("Licencesfilter1"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(conditionfieled,"not equal");
  sleepMin();
  selectListByVisibleText(selectDatafield,testData.get("Licencesfilter3"));
  //waitForElementToBeClickableThenSendkeys(LicenceTypedatainputfield,testData.get("Licencesfilter3"));
  waitForElementToBeClickableThenClick(filterBtn);
  waitForAngularRequestsToFinish();
  waitForElementToBeClickableThenClick(ExpandLicense);


}
















//surya------------------------VMM-3331


  public void CreateLicenseBaseProduct(Map<String, String> testData) throws InterruptedException {
    sleepMAX();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    sleepMAX();
    //selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    sleepMAX();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    selectListByVisibleText(SoftwareVersion, testData.get("SoftwareVersion"));
    sleepMin();
  }

  public void publishLicenseBaseProduct() throws InterruptedException {
    waitForElementToBeClickableThenClick(ActionBTNCommercial);
    sleepAvg();
    for(int i=0; i<PublishBTNCommercial.size();i++) {
      boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
      if(PublishBtn==true) {
        System.out.println(i);
        PublishBTNCommercial.get(i).click();
        break;
      }
    }
    sleepAvg();

  }

  public void conformPublish() throws InterruptedException {
    waitForElementToBeClickableThenClick(PublishOkBTN);
    sleepMAX();

  }


  public void clickCancleBtn() throws InterruptedException {
    waitForElementToBeClickableThenClick(cancleLicenseBtn);
    waitForAngularRequestsToFinish();

  }

  public void TeriminateLicenseBaseProduct() throws InterruptedException {
    waitForElementToBeClickableThenClick(ActionBTNCommercial);
    sleepAvg();
    for(int i=0; i<TeriminateBTNF.size();i++) {
      boolean PublishBtn = TeriminateBTNF.get(i).isDisplayed();
      if(PublishBtn==true) {
        System.out.println(i);
        TeriminateBTNF.get(i).click();
        break;
      }
    }
    sleepAvg();
    //	waitForElementToBeClickableThenClick(DownloadTerminateLicenseCheckBox);
    //	sleepAvg();
  }

  public void confromTeriminate() throws InterruptedException {
    waitForElementToBeClickableThenClick(TeriminateOKbtn);
    waitForAngularRequestsToFinish();
    sleepMAX();

  }


  public void SearchPublishLicense(Map<String, String> testData) throws InterruptedException {
    driver.navigate().refresh();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showFiltersBtn);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(selectTenetID,"Tenant ID");
    selectListByVisibleText(selectEquals,"equals");
    waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,testData.get("TenantID"));
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(ExpandLicense);

  }





//suryaaa----------------------------------VMM3265------------------------------------
  public void createLicense(Map<String, String> testData) throws InterruptedException
  {
    sleepMin();
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    waitForAngularRequestsToFinish();
    sleepMin();
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    sleepMin();
  }

  public void LicenseSave() throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    sleepMin();

  }
public void SearchLicenseCreated(Map<String, String> testData) throws InterruptedException {
  waitForElementToBeClickableThenClick(showFiltersBtn);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectTenetID,"Tenant ID");
  selectListByVisibleText(selectEquals,"equals");
  waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,testData.get("TenantID"));
  waitForElementToBeClickableThenClick(filterBtn);
  sleepMAX();
  waitForElementToBeClickableThenClick(ExpandLicense);
  sleepMAX();
}
public void NavigateToTenantManager() throws InterruptedException {
  sleepAvg();
  waitForElementToBeClickableThenClick(ActionBTNCommercial);
  sleepAvg();
  for(int i=0; i<PublishBTNCommercial.size();i++) {
    boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
    if(PublishBtn==true) {
      System.out.println(i);
      PublishBTNCommercial.get(i).click();
      break;
    }
  }
  sleepAvg();
  waitForElementToBeClickableThenClick(PublishOkBTN);
  sleepMAX();

  waitForElementToBeClickableThenClick(ActionBTNCommercial);
  sleepAvg();
  for(int i=0; i<GenerateKeysCommercial.size();i++) {
    boolean PublishBtn = GenerateKeysCommercial.get(i).isDisplayed();
    if(PublishBtn==true) {
      driver.navigate().to("https://test-tenant-manager.safefleetcloud.com/api-client");
      break;
    }
  }
  sleepMAX();
  sleepMAX();
}

//-----------t

public String verifyApiClientPageTenantCommercial() {

  String VerifyApiClientPageStatus = getWebelementText(CoformApiClientPage);

  if(VerifyApiClientPageStatus!=null) {
    return  VerifyApiClientPageStatus;

  } else{
    return null;

  }
}

public String verifyApiClientPageTenantGoverment() {

  String VerifyApiClientPageStatus = getWebelementText(CoformApiClientPage);

  if(VerifyApiClientPageStatus!=null) {
    return  VerifyApiClientPageStatus;

  } else{
    return null;

  }
}



public void logoutTenantManager() throws InterruptedException {
  sleepMAX();
  waitForElementToBeClickableThenClick(LogoutTenantManager);
  sleepAvg();
}

public void conformLogutTenantManager() throws InterruptedException {
  waitForElementToBeClickableThenClick(ConformLogoutTenantManager);
  sleepMAX();

}

public void searchTenantCommercial(Map<String, String> testData) throws InterruptedException {
  sleepMin();
  waitForElementToBeClickableThenClick(showFiltersBtn);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectTenetID,"Tenant ID");
  selectListByVisibleText(selectEquals,"equals");
  waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,testData.get("DeleteTenantCommercial"));
  waitForElementToBeClickableThenClick(filterBtn);
  sleepMAX();

}

public void deleteLicenseTenantCommercial(Map<String, String> testData) throws InterruptedException {
  waitForElementToBeClickableThenClick(ExpandLicense);
  sleepAvg();
  waitForElementToBeClickableThenClick(ClickActionBtn);
  sleepAvg();
  for(int i=0; i<EditBTNF.size();i++) {
    boolean EditBtn = EditBTNF.get(i).isDisplayed();
    if(EditBtn==true) {
      System.out.println(i);
      EditBTNF.get(i).click();
      break;
    }
  }

  waitForAngularRequestsToFinish();
  sleepMAX();
  selectListByVisibleText(LicenseStatus, "RETURN");
  sleepMin();
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  waitForAngularRequestsToFinish();
  searchTenantCommercial(testData);
  sleepMAX();
  waitForElementToBeClickableThenClick(ExpandLicense);
  sleepAvg();
  waitForElementToBeClickableThenClick(ClickActionBtn);
  sleepAvg();
  for(int i=0; i<DeleteBTNF.size(); i++) {
    boolean AssignBtn = DeleteBTNF.get(i).isDisplayed();
    if(AssignBtn==true) {
      DeleteBTNF.get(i).click();
      sleepMAX();
      break;
    }

  }
  sleepMAX();
  waitForAngularRequestsToFinish();

}



public void searchTenantGoverment(Map<String, String> testData) throws InterruptedException {

  waitForElementToBeClickableThenClick(showFiltersBtn);
  waitForAngularRequestsToFinish();
  selectListByVisibleText(selectTenetID,"Tenant ID");
  selectListByVisibleText(selectEquals,"equals");
  waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,testData.get("DeleteTenantGoverment"));
  waitForElementToBeClickableThenClick(filterBtn);
  sleepMAX();

}

public void deleteLicenseTenantGoverment(Map<String, String> testData) throws InterruptedException {
  waitForElementToBeClickableThenClick(ExpandLicense);
  sleepAvg();
  waitForElementToBeClickableThenClick(ClickActionBtn);
  sleepAvg();
  for(int i=0; i<EditBTNF.size();i++) {
    boolean EditBtn = EditBTNF.get(i).isDisplayed();
    if(EditBtn==true) {
      System.out.println(i);
      EditBTNF.get(i).click();
      break;
    }
  }

  waitForAngularRequestsToFinish();
  sleepMAX();
  selectListByVisibleText(LicenseStatus, "RETURN");
  sleepMin();
  waitForElementToBeClickableThenClick(licenseSaveBtn);
  waitForAngularRequestsToFinish();
  searchTenantGoverment(testData);
  sleepMAX();
  waitForElementToBeClickableThenClick(ExpandLicense);
  sleepAvg();
  waitForElementToBeClickableThenClick(ClickActionBtn);
  sleepAvg();
  for(int i=0; i<DeleteBTNF.size(); i++) {
    boolean AssignBtn = DeleteBTNF.get(i).isDisplayed();
    if(AssignBtn==true) {
      DeleteBTNF.get(i).click();
      sleepMAX();
      break;
    }

  }
  sleepMAX();
  waitForAngularRequestsToFinish();

}
//-----------------------------------------------------------------------

  /////////////////////////////// terminate License ////////////////////////////////////////////////

 public void terminateLicense(Map<String, String> testData) throws InterruptedException {


   waitForElementToBeClickableThenClick(actionBtn3584);
   sleepMin();

   waitForElementToBeClickableThenClick(terminateButton);
   sleepMin();
}


//Rajath VMM-3326---------------------------------------
public void NewLicenseCreate (Map<String, String> testData) throws InterruptedException
{   sleepMAX();
  createNewBtn.click();
  waitForAngularRequestsToFinish();
  sleepMAX();
  //sleepMAX();
  //sleepMAX();
  //selectListByVisibleText(tenantID, testData.get("TenantID"));
  waitForElementToBeClickableThenClick(tenantID);
  waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
  waitForElementToBeClickableThenClick(suggestionRowFirstValue);
  sleepMin();
  selectListByVisibleText(baseProduct, testData.get("Base Product"));
  sleepMin();
  selectListByVisibleText(licenseType, testData.get("License Type"));
  sleepMin();
  waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
  sleepMin();
  selectListByVisibleText(chargeType, testData.get("Charge Type"));
  sleepMin();
  selectListByVisibleText(server,testData.get("Server"));
  sleepMin();
  selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
}

  public void ClickLicensesSave () throws InterruptedException {
    saveBtn.click();
    waitForAngularRequestsToFinish();
    //sleepMin();

}

  public void Filterlicenses (Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licensesshowfilter);
    selectListByVisibleText(EnterTenantID,"Tenant ID");
    selectListByVisibleText(Enterequals,"equals");
    waitForElementToBeClickableThenSendkeys(Entertenantname,testData.get("TenantID"));
    waitForElementToBeClickableThenClick(filterBtn);
    sleepMAX();
    sleepMAX();

  }

  public void publishLicense() throws InterruptedException {

    waitForElementToBeClickableThenClick(ExpandLicense);
    waitForElementToBeClickableThenClick(ClickActionBtn);
    sleepMin();
    for(int i=0; i<PublishBTNCommercial.size();i++) {
      boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
      if(PublishBtn==true) {
        PublishBTNCommercial.get(i).click();
        break;
      }
    }
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(PublishOkBTN);
    waitForAngularRequestsToFinish();
  }


  public void verifyTerminate() throws InterruptedException {
    sleepAvg();
    waitForElementToBeClickableThenClick(ClickActionBtn);
    sleepAvg();
    waitForElementToBeClickableThenClick(TERMINATEbtn);
    sleepAvg();
    waitForElementToBeClickableThenClick(TERMINATEOKbtn);


}


  public void PublishLicenses (Map<String, String> testData) throws InterruptedException {


    waitForElementToBeClickableThenClick(showFiltersBtn);
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterOperationsDrp, "equals");
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
    Thread.sleep(SLEEP_AVG);

          sleepMAX();

    waitForElementToBeClickableThenClick(filterBtn);
    Thread.sleep(SLEEP_AVG);

         waitForElementToBeClickableThenClick(expandBtn);
         Thread.sleep(SLEEP_AVG);

         waitForElementToBeClickableThenClick(showFiltersBtn);
         sleepMAX();

    waitForElementToBeClickableThenClick(actionBtn3584);
    sleepMin();


    for(int i=0; i<PublishBTNCommercial.size();i++) {
      boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
      if(PublishBtn==true) {
        //System.out.println(i);
        PublishBTNCommercial.get(i).click();
        break;
      }
    }

    // waitForElementToBeClickableThenClick(PUBLISHbtn);
    //sleepMAX();

    waitForElementToBeClickableThenClick(okBtnToPublish);
    sleepMAX();
    sleepMAX();
  }


  public void TerminateLicenses (Map<String, String> testData) throws InterruptedException {


    waitForElementToBeClickableThenClick(actionBtn3584);
    sleepMin();

    waitForElementToBeClickableThenClick(terminateButton);
    sleepMin();
  }

  public void TerminateLicensesOKBtn () throws InterruptedException {
    waitForElementToBeClickableThenClick(TERMINATEOKbtn);
    sleepMAX();
  }

  public String Verifyterminatelicenses (Map<String, String> testData) throws InterruptedException {

    waitForElementToBeClickableThenClick(showFiltersBtn);
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterFieldsDrp, "Tenant ID");
    Thread.sleep(SLEEP_AVG);

    selectListByVisibleText(filterOperationsDrp, "equals");
    Thread.sleep(SLEEP_AVG);

    waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
    Thread.sleep(SLEEP_AVG);

         // sleepMAX();

    waitForElementToBeClickableThenClick(filterBtn);
    Thread.sleep(SLEEP_AVG);

         waitForElementToBeClickableThenClick(expandBtn);
         Thread.sleep(SLEEP_AVG);

    String text= verifyTerminate.getText();
         return text;

}


//Rajath VMM-3704-----------------------------------------------

  public void clickOnNavigeteToLicenses () throws InterruptedException {
    waitForElementToBeClickableThenClick(navigatetolicenses);
    sleepMin();
  }

  public void SearchExpiredLicenses () throws InterruptedException {
    sleepMAX();
    waitForElementToBeClickableThenClick(showFiltersBtn);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(selectTenetID,"Tenant ID");
    selectListByVisibleText(selectEquals,"equals");
    waitForElementToBeClickableThenSendkeys(EnterTenantIDValue,"savt6nexus2");
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(ExpandLicense);
    sleepMin();
    waitForElementToBeClickableThenClick(selectStatus);
    selectListByVisibleText(selectStatus,"EXPIRED");
    waitForAngularRequestsToFinish();
  }

  public void Partvalue (Map<String, String> testData) throws InterruptedException {
    sleepMin();
    waitForElementToBeClickableThenClick(Action2btn);
    sleepMin();


    for(int i=0; i<RenewbtnS.size();i++) {
      boolean PublishBtn = RenewbtnS.get(i).isDisplayed();
      if(PublishBtn==true) {
        System.out.println(i);
        RenewbtnS.get(i).click();
        break;
      }
    }

    waitForAngularRequestsToFinish();
    sleepAvg();
    waitForElementToBeClickableThenClearThenSendkeys(Part, testData.get("Part #"));
    sleepMAX();
    sleepMin();
  }

  public void Renewcancel () throws InterruptedException {
    waitForElementToBeClickableThenClick(renewcancel);
    sleepMAX();
  }


  public String VerifyLicenseexpirydateTxtBx() {

    String filterType=LicenseexpirydateTxtBx.getText();
    return filterType;

  }

  public String VerifyLicenseexpirydate() {

    JavascriptExecutor js = (JavascriptExecutor)driver;
    String expiryDate = (String) js.executeScript("return arguments[0].value", Licenseexpirydate);

    return expiryDate;

  }




//surya------------------------------------------------------VMM-3878---------------------------------

//BaseProduct DropDown In LicensesPage

  ArrayList<String> ActualBaseProductDropDwnValues=new ArrayList<String>();

  ArrayList<String> ExpectedBaseProductDropDwnValues=new ArrayList<String>();




 public List[] verifyBaseProductDropDownOrderInLicenses() throws InterruptedException {
   sleepAvg();
   waitForElementToBeClickableThenClick(BaseProductTypeDropDwn);
   sleepAvg();

   for(int i=0;i<BaseProductTypeDropDwnValues.size();i++) {

     String BaseProductDropDwnText = BaseProductTypeDropDwnValues.get(i).getText();

     ActualBaseProductDropDwnValues.add(BaseProductDropDwnText);


   }
   ExpectedBaseProductDropDwnValues=ActualBaseProductDropDwnValues;
   Collections.sort(ExpectedBaseProductDropDwnValues);
   return new List[] {ActualBaseProductDropDwnValues,ExpectedBaseProductDropDwnValues};
 }

 //LicenseType DropDown In Licenses

 ArrayList<String> ActualLicenseTypeDropDwnValues=new ArrayList<String>();

 ArrayList<String> ExpectedLicenseTypeDropDwnValues=new ArrayList<String>();




public List[] verifyLicenseTypeDropDownOrderInLicenses() throws InterruptedException {
  sleepAvg();
  waitForElementToBeClickableThenClick(LicenseTypeDropDwn);
  sleepAvg();

  for(int i=0;i<LicenseTypeDropDwnValues.size();i++) {

    String LicesneTypeDropDwnText = LicenseTypeDropDwnValues.get(i).getText();

    ActualLicenseTypeDropDwnValues.add(LicesneTypeDropDwnText);


  }
  ExpectedLicenseTypeDropDwnValues=ActualLicenseTypeDropDwnValues;
  Collections.sort(ExpectedLicenseTypeDropDwnValues);
  return new List[] {ActualLicenseTypeDropDwnValues,ExpectedLicenseTypeDropDwnValues};
}


// CharegeTypeDropDwn in Licenses Page


 ArrayList<String> ActualChargeTypeDropDwnValues=new ArrayList<String>();

 ArrayList<String> ExpectedChargeTypeDropDwnValues=new ArrayList<String>();




public List[] verifyChargeTypeDropDownOrderInLicenses() throws InterruptedException {
  sleepAvg();
  waitForElementToBeClickableThenClick(CharegeTypeDropDwn);
  sleepAvg();

  for(int i=0;i<ChargeTypeDropDwnValues.size();i++) {

    String ChargeTypeDropDwnText = ChargeTypeDropDwnValues.get(i).getText();

    ActualChargeTypeDropDwnValues.add(ChargeTypeDropDwnText);


  }
  ExpectedChargeTypeDropDwnValues=ActualChargeTypeDropDwnValues;
  Collections.sort(ExpectedChargeTypeDropDwnValues);
  return new List[] {ActualChargeTypeDropDwnValues,ExpectedChargeTypeDropDwnValues};
}



//Status DropDownIn licenses page



ArrayList<String> ActualStatusTypeDropDwnValues=new ArrayList<String>();

ArrayList<String> ExpectedStatusTypeDropDwnValues=new ArrayList<String>();




public List[] verifyStatusTypeDropDownOrderInLicenses() throws InterruptedException {
  sleepAvg();
  waitForElementToBeClickableThenClick(StatusDropDwn);
  sleepAvg();

  for(int i=0;i<StatusDropDwnValues.size();i++) {

    String StatusTypeDropDwnText = StatusDropDwnValues.get(i).getText();

    ActualStatusTypeDropDwnValues.add(StatusTypeDropDwnText);


  }
  ExpectedStatusTypeDropDwnValues=ActualStatusTypeDropDwnValues;
  Collections.sort(ExpectedStatusTypeDropDwnValues);
  return new List[] {ActualStatusTypeDropDwnValues,ExpectedStatusTypeDropDwnValues};
}

//----------------------------------------------------Nitin------------------------------------------------//
public void clickOnActionsAndThenEdit() {
  waitForElementToBeClickableThenClick(actionsBtn);
  //waitForElementToBeClickableThenClick(editBtnn);
  for(int i=0; i<EditBTNF.size();i++) {
    boolean EditBtn = EditBTNF.get(i).isDisplayed();
    if(EditBtn==true) {
      System.out.println(i);
      EditBTNF.get(i).click();
      break;
    }
  }
}

  public void createAppLicenseOnly(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();

    //	selectListByVisibleText(tenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);


    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));

    selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));

    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();

  }

  public void verifyFilterLicense(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(showFilters);
    waitForAngularRequestsToFinish();
    selectListByVisibleText(filterLicenseFirst, "Tenant ID");
    waitForAngularRequestsToFinish();
    selectListByVisibleText(filterLicenseSecond, "equals");
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenSendkeys(filterLicenseText, testData.get("TenantID"));
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(filterButton);
  }

  public void goToTenantManager() throws InterruptedException {
    waitForElementToBeClickableThenClick(firstPlusExpandSymbol);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(secondActionsDropButton);
    waitForAngularRequestsToFinish();
    scrollToElement("(//span[text()='Generate Keys'])[2]");
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(secondDropGenerateKeys);
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();
    String parent = driver.getWindowHandle();
    Set<String> list = driver.getWindowHandles();
    for(String l:list) {
      if(l.equals(parent)) {
        driver.close();
      } else {
        driver.switchTo().window(l);
      }
    }
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();
  }

  public void goToLicensePublishAfterFilter() throws InterruptedException, AWTException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(firstPlusExpandSymbol);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(firstActionsDropButton);
    waitForAngularRequestsToFinish();
    for(int i=0; i<vehicleLicensePublishBtnS.size();i++) {
      boolean DeleteBtn = vehicleLicensePublishBtnS.get(i).isDisplayed();
      if(DeleteBtn==true) {
        System.out.println(i);
        vehicleLicensePublishBtnS.get(i).click();
        break;
      }
    }
    waitForAngularRequestsToFinish();
    //waitForElementToBeClickableThenClick(publishDownloadCheckBox);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(okk);
    waitForAngularRequestsToFinish();
  }

  public String createLicensesforDesktop(Map<String, String> testData) throws Exception {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    sleepMin();
    //selectListByVisibleText(licenseTenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    sleepMin();
    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    sleepMin();
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    sleepMin();
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
    selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
    waitForElementToBeClickableThenSendkeys(idpTextBox, testData.get("Identity Provider"));
    String marketSegment = marketSegmentTxt.getText();
    waitForElementToBeClickableThenClick(addAnother);

    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    return marketSegment;

  }

  public void createLicensesforDesktopwithoutAddingAnother(Map<String, String> testData) throws InterruptedException {
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    //waitForAngularRequestsToFinish();
    //selectListByVisibleText(licenseTenantID, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
    if (testData.get("SoftwareVersion") != "")
      selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
    waitForElementToBeClickableThenSendkeys(expiryDatee, testData.get("ExpiryDate"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();

  }

  public void createLicensesSFNexus(Map<String, String> testData) throws Exception {
    //waitForAngularRequestsToFinish();
    //waitForAngularRequestsToFinish();
    //sleepMin();
    selectListByVisibleText(licenseTenantID, testData.get("TenantID"));
/*
		waitForElementToBeClickableThenClick(tenantID);
		waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
*/
    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
    selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
    selectListByVisibleText(serverr, testData.get("Server"));
    waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
    waitForAngularRequestsToFinish();

  }

  public void goToLicensePublishAfterFilterAgain() throws InterruptedException {
    waitForAngularRequestsToFinish();
    scrollToElement("(//button[contains(text(),'Actions')])[7]");
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(thirdActionsDropButton);
    waitForAngularRequestsToFinish();
    for(int i=0; i<vehicleLicensePublishBtnS.size();i++) {
      boolean DeleteBtn = vehicleLicensePublishBtnS.get(i).isDisplayed();
      if(DeleteBtn==true) {
        System.out.println(i);
        vehicleLicensePublishBtnS.get(i).click();
        break;
      }
    }
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(okk);
  }

  public void createLicensesForVisualization(Map<String, String> testData) throws Exception {
    waitForAngularRequestsToFinish();
    sleepMAX();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
    sleepMin();
    waitForElementToBeClickableThenClick(licenseBaseP);
    selectListByVisibleText(licenseBaseP, testData.get("Base Product"));
    sleepMin();
    waitForElementToBeClickableThenClick(licenseTypefield);
    for(WebElement optionText:optionsTextt) {
      System.out.println(optionText.getText());
    }
    selectListByVisibleText(licenseTypefield, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(licensePartNum, testData.get("Part #"));

    waitForElementToBeClickableThenSendkeys(selectQTY, testData.get("QTY"));
    selectListByVisibleText(licenseChargeType, testData.get("Charge Type"));
    waitForElementToBeClickableThenClick(licenseSaveBtn);
    waitForAngularRequestsToFinish();
  }
  //----------------------------------------------------Nitin------------------------------------------------//


  //Rajath VMM_3592----------------------------------------------------------
  public void licenseSearch (Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(licensesshowfilter);
    sleepAvg();
    selectListByVisibleText(EnterTenantID,"Tenant ID");
    sleepAvg();
    selectListByVisibleText(Enterequals,"equals");
    sleepAvg();
    waitForElementToBeClickableThenSendkeys(Entertenantname,testData.get("TenantID"));
    sleepMin();
    waitForElementToBeClickableThenClick(filterBtn);
    sleepMAX();
  }

  public void licenseSearchWithClearValue (Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(clearlicense);
    sleepMin();
    selectListByVisibleText(EnterTenantID,"Tenant ID");
        sleepMin();
    selectListByVisibleText(Enterequals,"equals");
        sleepMin();
    waitForElementToBeClickableThenClearThenSendkeys(Entertenantname,"");
    sleepMin();

  }

  public void ClickExpandBtn () throws InterruptedException {
    waitForElementToBeClickableThenClick(expandbtn);
    sleepMAX();
    waitForElementToBeClickableThenClick(actionbtn);
    sleepMAX();
    for(int i=0; i<DeleteBTNF.size(); i++) {
      boolean AssignBtn = DeleteBTNF.get(i).isDisplayed();
      if(AssignBtn==true) {
        DeleteBTNF.get(i).click();
        sleepMAX();
        break;
      }

    }
    sleepMAX();
  }

  public void ClickDeleteOkBtn () throws InterruptedException {
    waitForElementToBeClickableThenClick(deleteokbtn);
    sleepMAX();
  }


  //surya----------------------------VMM--4677-------------------------------------------

  public void CreateLicenseWithSoftwareVersionField(Map<String, String> testData) throws InterruptedException {

    waitForAngularRequestsToFinish();
    sleepAvg();
    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    //selectListByVisibleText(tenantID, testData.get("TenantID"));

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);

    selectListByVisibleText(baseProduct, testData.get("Base Product"));
    selectListByVisibleText(licenseType, testData.get("License Type"));
    waitForElementToBeClickableThenSendkeys(part, testData.get("Part #"));
    waitForElementToBeClickableThenSendkeys(Qtyfield, testData.get("QTY"));
    selectListByVisibleText(chargeType, testData.get("Charge Type"));
    selectListByVisibleText(licenseSoftwareType, testData.get("SoftwareVersion"));
    waitForAngularRequestsToFinish();
  }

  public void PublishDvrFirmwareLicense() throws InterruptedException {
    waitForElementToBeClickableThenClick(ExpandLicense);
    waitForElementToBeClickableThenClick(ClickActionBtn);
    for(int i=0; i<PublishBTNCommercial.size();i++) {
      boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
      if(PublishBtn==true) {
        System.out.println(i);
        PublishBTNCommercial.get(i).click();
        break;
      }
    }
    sleepAvg();

  }



    public void PublishSFCommanderLicense() throws InterruptedException {
      waitForElementToBeClickableThenClick(ActionBtnSFCommander);
      for(int i=0; i<PublishBTNCommercial.size();i++) {
        boolean PublishBtn = PublishBTNCommercial.get(i).isDisplayed();
        if(PublishBtn==true) {
          System.out.println(i);
          PublishBTNCommercial.get(i).click();
          break;
        }
      }
      sleepAvg();

    }

    public void ConformPublishLicense() {
      waitForAngularRequestsToFinish();
      waitForElementToBeClickableThenClick(PublishOkBTN);
      waitForAngularRequestsToFinish();
    }

  public void unzipAndVerifyDVRLicenseFile(String zipFilePath, String destDirectory, String expectedFileName1, String expectedFileName2  ) {

       try {
           unzip(zipFilePath, destDirectory);
           File extractedFile1 = new File(destDirectory + "/" + expectedFileName1);
           File extractedFile2 = new File(destDirectory + "/" + expectedFileName2);
           if (extractedFile1.exists() && extractedFile2.exists()) {
               System.out.println("File successfully extracted and verified.");
           } else {
               System.out.println("Error: extracted file not found.");
           }
       } catch (IOException e) {
           System.out.println("Error unzipping file: " + e.getMessage());
       }
}

  public void publishVisibleLicense() {
    for(int i=0; i<publishBtns.size();i++) {
      boolean PublishBtn = publishBtns.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(PublishBtn==true) {
        publishBtns.get(i).click();
        break;
      }
    }
    }

  public void terminateVisibleLicense() {
    for(int i=0; i<terminateBtns.size();i++) {
      boolean PublishBtn = terminateBtns.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(PublishBtn==true) {
        System.out.println(i);
        terminateBtns.get(i).click();
        break;
      }
    }
    }

  public void returnVisibleLicense() {
    for(int i=0; i<returnBtns.size();i++) {
      boolean PublishBtn = returnBtns.get(i).isDisplayed();
      //System.out.println(DeleteBtn);
      if(PublishBtn==true) {
        System.out.println(i);
        returnBtns.get(i).click();
        break;
      }
    }
    }

  public void addProviderDetails(Map<String, String> testData) {

    waitForElementToBeClickableThenClick(providerChkbox);
    waitForElementToBeClickableThenSendkeys(licenseKeyTxt, testData.get("PD License Key"));
    waitForElementToBeClickableThenSendkeys(SystemIdTxt, testData.get("PD System ID"));
    waitForElementToBeClickableThenSendkeys(registeredDateTxt, getCurrentDate());
    waitForElementToBeClickableThenSendkeys(expiredDateTxt, getFutureDate(30));
    //waitForElementToBeClickableThenClick(softwareVersionDrp);
    selectListByVisibleText(softwareVersionDrp, testData.get("PD Software Version"));
  }

  public boolean verifyProviderDetails(Map<String, String> testData) {


    getWebelementText(licenseKeyTxt).equals(testData.get("PD License Key"));
    getWebelementText(SystemIdTxt).equals(testData.get("PD License Key"));
    getWebelementText(registeredDateTxt).equals(getCurrentDate());
    getWebelementText(expiredDateTxt).equals(getFutureDate(30));
    getWebelementText(softwareVersionDrp).equals(testData.get("PD Software Version"));

    return true;

  }

  public void updateProviderDetails(Map<String, String> testData) {
    waitForElementToBeClickableThenClearThenSendkeys(licenseKeyTxt, testData.get("PD License Key"));
    waitForElementToBeClickableThenClearThenSendkeys(SystemIdTxt, testData.get("PD System ID"));
    waitForElementToBeClickableThenClearThenSendkeys(registeredDateTxt, getCurrentDate());
    waitForElementToBeClickableThenClearThenSendkeys(expiredDateTxt, getFutureDate(30));
  }

  public void clickOnNewLicenseBtn() {

    waitForElementToBeClickableThenClick(licenseNewBtn);
    waitForAngularRequestsToFinish();
    waitForElementToAppear(inauguralDateField);
  }

  public void selectTenantId(Map<String, String> testData) {

    waitForElementToBeClickableThenClick(tenantID);
    waitForElementToBeClickableThenSendkeys(tenantIDTextBox, testData.get("TenantID").toLowerCase());
    waitForElementToBeClickableThenClick(suggestionRowFirstValue);
  }

  public void selectBaseApp(Map<String, String> testData) {

    selectListByVisibleText(baseProductDrp, testData.get("Base Product"));
    waitForAngularRequestsToFinish();
  }

  public void selectLicenseType(Map<String, String> testData) {

    selectListByVisibleText(licenseTypeDrp, testData.get("License Type"));
    waitForAngularRequestsToFinish();
  }

  public List<String> getListOfLicenseTypes(String[] licenseType) {
    List<String> listOfLT = new ArrayList<>();

    waitForElementToBeClickableThenClick(licenseTypeDrp);
    for(WebElement ele:listOfLicenseTypes) {
      if(!ele.getText().isEmpty())
        listOfLT.add(ele.getText());
    }
    /*
		if(listOfLT.size()==licenseType.length) {
			if(listOfLT.equals(Arrays.asList(licenseType))) {
				return listOfLT;
			}
		}*/
    return listOfLT;

  }

  @FindBy(xpath = "//*[@id='field_softwareLicense']")
  WebElement softwareVerField;

  @FindBy(xpath = "//*[@id='field_slot']")
  WebElement qtyField;

  @FindBy(xpath = "//*[@id='field_partnum']")
  WebElement partNumTxt;

  @FindBy(xpath = "//*[@id='field_server']")
  WebElement serverField;

  @FindBy(xpath = "//*[@id='field_chargeType']")
  WebElement chargeTypeField;

  public boolean verifyMandatoryFieldsForEmbeddedEntity() throws Exception {

    if(partNumTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
      qtyField.getAttribute("aria-required").equalsIgnoreCase("true") &&
      softwareVerField.getAttribute("required").equals("true")) {
      return true;
    } else
      return false;

  }


  public boolean verifyMandatoryFieldsFortBaseApp() throws Exception {

    if(partNumTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
      serverField.getAttribute("required").equalsIgnoreCase("true")) {
      return true;
    } else
      return false;

  }

  public boolean verifyMandatoryFieldsForAsset() throws Exception {

    if(partNumTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
      qtyField.getAttribute("required").equalsIgnoreCase("true") &&
      chargeTypeField.getAttribute("required").equalsIgnoreCase("true")) {
      return true;
    } else
      return false;

  }

  public boolean verifyMandatoryFieldsForAddOnModule() throws Exception {

    if(partNumTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
      chargeTypeField.getAttribute("required").equalsIgnoreCase("true")) {
      return true;
    } else
      return false;

  }

  public String getExpirationDate(int days) {
        return getFutureDate(days);
    }

  public void switchToParentWindow() {
    newTb = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(newTb.get(0));
    System.out.println("Page title of parent window: " + driver.getTitle());
  }

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Tenant ID']")
  WebElement colTenantID;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Base App']")
  WebElement colBaseApp;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='License Type']")
  WebElement colLicenseType;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Charge Type']")
  WebElement colChargeType;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Status']")
  WebElement colStatus;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='QTY']")
  WebElement colQTY;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Renewal Status']")
  WebElement colRenewalStatus;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Part #']")
  WebElement colPartNum;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Expiration Date']")
  WebElement colExpirationDate;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='SO #']")
  WebElement colSONum;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Principal SO #']")
  WebElement colPrincipalSONum;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='QTY Used']")
  WebElement colQTYUsed;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Inaugural Date']")
  WebElement colInauguralDate;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Anniversary Date']")
  WebElement colAnniversaryDate;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Deployment Type']")
  WebElement colDeploymentType;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Server']")
  WebElement colServer;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='Software Version']")
  WebElement colSoftwareVersion;

  @FindBy(xpath = "//*[@role='columnheader']//span[text()='License ID']")
  WebElement colLicenseID;


  public boolean verifyAllColumnsAvailableInLicensesScreen() throws InterruptedException {

    waitForElementToBeClickableThenClick(ShowAllFieldsCheckBox);
    waitForAngularRequestsToFinish();

    colTenantID.isDisplayed();
    colBaseApp.isDisplayed();
    colLicenseType.isDisplayed();
    colChargeType.isDisplayed();
    colStatus.isDisplayed();
    colQTY.isDisplayed();
    colRenewalStatus.isDisplayed();
    colPartNum.isDisplayed();
    colExpirationDate.isDisplayed();
    sleepMin();
    scrollToElement(colInauguralDate);
    colSONum.isDisplayed();
    colPrincipalSONum.isDisplayed();
    colQTYUsed.isDisplayed();
    colInauguralDate.isDisplayed();
    sleepMin();
    scrollToElement(colSoftwareVersion);
    colAnniversaryDate.isDisplayed();
    colDeploymentType.isDisplayed();
    colServer.isDisplayed();
    colSoftwareVersion.isDisplayed();
    sleepMin();
    scrollToElement(colLicenseID);
    colLicenseID.isDisplayed();

    return true;
  }


  public void hideFiltersBtn() {

    waitForElementToBeClickableThenClick(hideFiltersBtn);
  }

    public void clickOnLicenseViewBtn ()  {
      waitForElementToBeClickableThenClick(viewBtn);
      waitForAngularRequestsToFinish();
      waitForAngularRequestsToFinish();
    }

  @FindBy(xpath="//td/span[text()='Status']/../following-sibling::td")
  WebElement StatusTxt;

  @FindBy(xpath="//td/span[text()='Base App']/../following-sibling::td")
  WebElement baseAppTxt;

  @FindBy(xpath="//td/span[text()='License Type']/../following-sibling::td")
  WebElement licenseTypeTxt;

  public String getLicenseStatusFromViewScreen() {

    return StatusTxt.getText();
  }

  public String getBaseAppFromViewScreen() {

    return baseAppTxt.getText();
  }

  public String getLicenseTypeFromViewScreen() {

    return licenseTypeTxt.getText();
  }

  @FindBy(xpath="//a[contains(@id,'menu_link_expire_1')]/span[text()='Expire']")
  WebElement expireOption;

  @FindBy(xpath="//a[contains(@id,'menu_link_cancel_1')]/span[text()='Terminate']")
  WebElement terminateOption;


  public boolean verifyExpireAndTerminateOptionsAvailability() {

    if(expireOption.isDisplayed() && terminateOption.isDisplayed()) {
      return true;
    } else
      return false;
  }

  public void selectFilterField(Map<String, String> testData) throws InterruptedException {
    waitForElementToBeClickableThenClick(showFiltersBtn);

    selectListByVisibleText(conditionField1,testData.get("Filter1"));
    selectListByVisibleText(conditionOperation1,testData.get("FilterOperation1"));
    waitForElementToBeClickableThenClick(conditionFieldValue1);
    //selectListByVisibleText(conditionFieldValue1,testData.get("FilterValue1"));
  }

  @FindBy(xpath="(//select[@ng-model='rule.model'])[1]/option")
  List<WebElement> ListOfAvailableBaseAppInLicensesPage;

  public boolean verifyAvailableBaseAppWithBaseAppsList(List<String> listOfBaseApps) {

    //waitForElementToBeClickableThenClick(DeviceTypeDropDown);
    List<String> ListOfAvailableBaseApps=new ArrayList<>();
    for(int i=0;i<ListOfAvailableBaseAppInLicensesPage.size();i++) {
      String Name = ListOfAvailableBaseAppInLicensesPage.get(i).getText();
      if(!Name.isEmpty())
        ListOfAvailableBaseApps.add(Name);
    }

    boolean Result = listOfBaseApps.containsAll(ListOfAvailableBaseApps);
    System.out.println("listOfBaseApps from Base App screen: "+listOfBaseApps);
    System.out.println("listOfBaseApps from Licenses screen: "+ListOfAvailableBaseApps);
    return Result;
  }
  public void assignDeviceBackBtn() {

    waitForElementToBeClickableThenClick(assignDeviceBackBtn);
    waitForAngularRequestsToFinish();
  }
  @FindBy(xpath="//*[@id='license_assign_back_btn']/span")
  WebElement assignDeviceBackBtn;

  public void clickFilterBtn() throws InterruptedException {
    sleepMin();
    waitForElementToBeClickableThenClick(filterBtn);
    waitForAngularRequestsToFinish();
    waitForElementToBeClickableThenClick(hideFiltersBtn);
    waitForAngularRequestsToFinish();
  }

  public String getTenantId()
  {
    return tenantIdTxt.getText().trim();
  }

  public String verifyExpireOptionEnabledOrDisabled() {
    String ExpireOption = null;
    boolean ExpireBtn = false;

    for(int i=0; i<ExpireBtnS.size();i++) {
      ExpireBtn = ExpireBtnS.get(i).isDisplayed();
      if(ExpireBtn==true) {
        System.out.println(i);
        ExpireOption = ExpireBtnS.get(i).getAttribute("aria-disabled");
        break;
      }
    }
    return ExpireOption;
  }

  public void expireLicense() throws InterruptedException {
    //clickOnActionBtn();
    waitForElementToBeClickableThenClick(expireBtn);
    waitForElementToAppear(appLicensePublishOKBtn);

  }

}
