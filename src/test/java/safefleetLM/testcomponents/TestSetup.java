package safefleetLM.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import safefleetLM.componentgroups.ReusableLibrary;
import safefleetLM.componentgroups.ConfigFileReader;

public class TestSetup {
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public ReusableLibrary reusableLibrary;
	public ExcelFileReader excelReader;
	public ConfigFileReader prop;
	
	public TestSetup() throws IOException{
		baseTest = new BaseTest();
		driver = baseTest.intializeDriver();
		pageObjectManager = new PageObjectManager(driver);
		reusableLibrary = new ReusableLibrary(driver);
		excelReader = new ExcelFileReader();
		prop = new ConfigFileReader();
	}
	
	
	

}
