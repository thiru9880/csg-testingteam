package safefleetLM.testcomponents;

import org.openqa.selenium.WebDriver;

import safefleetLM.pageobjects.BaseProductPage;
import safefleetLM.pageobjects.BulkDeviceUploadPage;
import safefleetLM.pageobjects.CustomersPage;
import safefleetLM.pageobjects.DeviceTypesPage;
import safefleetLM.pageobjects.EcosystemSettingsPage;
import safefleetLM.pageobjects.DevicePage;
import safefleetLM.pageobjects.DeviceSettingsPage;
import safefleetLM.pageobjects.LMHomePage;
import safefleetLM.pageobjects.LandingPage;
import safefleetLM.pageobjects.LicenseTypePage;
import safefleetLM.pageobjects.LicensesPage;
import safefleetLM.pageobjects.SalesRegionPage;
import safefleetLM.pageobjects.ServersPage;
import safefleetLM.pageobjects.TenantManagerPage;
import safefleetLM.pageobjects.TenantTypesPage;
import safefleetLM.pageobjects.TenantsPage;
import safefleetLM.pageobjects.UserPage;

public class PageObjectManager {
	
	public LicensesPage L_Page;
	public LicenseTypePage LT_Page;
	public BaseProductPage BP_Page ;
	public WebDriver driver;
	public LandingPage lp;
	public LMHomePage homePg;
	public CustomersPage customer;
	public UserPage user;
	public DeviceTypesPage dtp;
	public DevicePage device;
	public TenantsPage tenants;
	public LicensesPage license;
	public EcosystemSettingsPage ess;
	public DeviceSettingsPage ds;
	public SalesRegionPage sr;
//bhanu
	public TenantTypesPage ttp;
	public ServersPage sp;

//--------------Nitin---------------//
	public BulkDeviceUploadPage bp;
	public TenantManagerPage tam;
//--------------Nitin---------------//

	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage getLandingPage() {
		lp = new LandingPage(driver);
		return lp;
	}
	
	public LMHomePage getHomePage() {
		homePg = new LMHomePage(driver);
		return homePg;
	}
	
	public CustomersPage getCustomerPage() {
		customer = new CustomersPage(driver);
		return customer;
	}
	
	public UserPage getUserPage() {
		user = new UserPage(driver);
		return user;
	}
	
	public DeviceTypesPage getDeviceTypesPage() {
		dtp = new DeviceTypesPage(driver);
		return dtp;
	}
	
	public DevicePage getDevicePage() {
		device = new DevicePage(driver);
		return device;
	}
	public BaseProductPage getBaseProductPage() {
		 BP_Page = new BaseProductPage(driver);
			return BP_Page;
			
		}
	
	public LicenseTypePage getLicenseTypePage() {
		 LT_Page = new LicenseTypePage(driver);
			return LT_Page;}
	/*		
     public LicensesPage getLicensePage() {
				 L_Page = new LicensesPage(driver);
					return L_Page;
			
		}*/

	public TenantsPage getTenantsPage() {
 		tenants = new TenantsPage(driver);
 		return tenants;
 	}
 	
 	public LicensesPage getLicensesPage() {
 		license = new LicensesPage(driver);
 		return license;
 	}
 	
 	public EcosystemSettingsPage getEcosystemSettingsPage() {
 		ess = new EcosystemSettingsPage(driver);
 		return ess;
 	}

	 public DeviceSettingsPage getDeviceSettingsPage() {
 		ds = new DeviceSettingsPage(driver);
 		return ds;
 	}
	 public SalesRegionPage getSalesRegionPage() {
	        sr = new SalesRegionPage(driver);
	        return sr;
	    }
//bhanu
	 public TenantTypesPage getTenantTypesPage() {
	 		ttp = new TenantTypesPage(driver);
	 		return ttp;
	 	}
	 public ServersPage getServersPage() {
		 sp = new ServersPage(driver);
	 		return sp;
	 	}

	//----------------------Nitin----------------------------//
	 public BulkDeviceUploadPage getBulkDeviceUploadPage()
	 {
		 bp = new BulkDeviceUploadPage(driver);
		 return bp;
	 }
	 public TenantManagerPage getTenantManagerPage()
	 {
		 tam = new TenantManagerPage(driver);
		 return tam;
	 }

	 
	 
}
