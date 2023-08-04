package safefleetLM.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ConfigFileReader;
import safefleetLM.componentgroups.ReusableLibrary;



public class LandingPage extends ReusableLibrary {
	
	
	public WebDriver driver;
	ConfigFileReader prop;
	static String url=null;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmailId = driver.findElement(By.id("Input_Email"));
	//WebElement userPW = driver.findElement(By.id("Input_Password"));
	//WebElement btnsingIn = driver.findElement(By.cssSelector(".btn-primary"));
	
	//PageFactory
	//@FindBy(id="Input_Email")		//Test env element
	@FindBy(xpath = "//input[@id='input-email']")		//Dev env element
	WebElement userEmailId;
	
	@FindBy(xpath = "//input[@id='Input_Email']")		//Dev env element
	WebElement userEmailIdNew;
		
	@FindBy(xpath="//input[@id='Input_Password']")
	WebElement userPW;
	
	@FindBy(xpath="//input[@id='Input_Password']")
	WebElement userPWNew;

	@FindBy(css=".btn-primary")
	WebElement singInBtn;
	
	//Sunil(VMM-3268) logoutuser
	@FindBy(xpath="//a[@class='btn btn btn-primary btn-xs']//i[@class='material-icons'][normalize-space()='exit_to_app']")
	WebElement LMLogoutBtn;
	
	@FindBy(css=".btn-primary")
	WebElement nextBtn;
	

	public WebDriver launchLM() {
		
		prop = new ConfigFileReader();
		String env = prop.getEnvName();
		
		if(env.equalsIgnoreCase("Test"))
			url = prop.getLMTestUrl();
		
		else if(env.equalsIgnoreCase("Dev"))
			url = prop.getLMDevUrl();
		driver.get(url);
		waitForAngularRequestsToFinish();
		return driver;
	}
	
	public WebDriver launchLM(String url) {
		driver.get(url);
		waitForAngularRequestsToFinish();
		String currentUrl= driver.getCurrentUrl();
		waitForAngularRequestsToFinish();
		if(!currentUrl.contains("/Account/Login"))
			driver.get(url);
		return driver;
	}
	
	public void loginLM(String emailId, String pw) throws Exception{
		waitForAngularRequestsToFinish();
		pw = decodeData(pw);
		userEmailId.sendKeys(emailId);
		userPW.sendKeys(pw);
		singInBtn.click();
		waitForAngularRequestsToFinish();
		//String currentUrl= driver.getCurrentUrl();
	}
	
	public void loginLMNew(String emailId, String pw) throws Exception {
		sleepMin();
		waitForAngularRequestsToFinish();
		pw = decodeData(pw);
		userEmailIdNew.sendKeys(emailId);
		nextBtn.click();
		waitForElementToAppear(userPWNew);
		userPWNew.sendKeys(pw);
		singInBtn.click();
		waitForAngularRequestsToFinish();
		
	}	

	
	//Sunil(VMM-3268) logoutuser
	public boolean logoutUser() throws InterruptedException {
		waitForElementToBeClickableThenClick(LMLogoutBtn); 
		waitForAngularRequestsToFinish();
		String currentUrl= driver.getCurrentUrl();
		if(currentUrl.contains("/Account/Login"))
			return true;
		
		return false;
		}
		
	
	
	


}
