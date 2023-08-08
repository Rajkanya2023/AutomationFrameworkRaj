package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.beust.jcommander.Parameters;

import vtiger.ObjectRespositry.HomePage;
import vtiger.ObjectRespositry.Loginpage;

public class BaseClass {
	

	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUltility eUtil = new ExcelFileUltility();
	public PropertiesFileUtility pUtil = new PropertiesFileUtility();
	public WebdriverUtilirty wUtil = new WebdriverUtilirty();
	
	public WebDriver driver = null;
	
	//only used for listener to take screenshot
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====== db connection successful ======");
	}
	
	//@org.testng.annotations.Parameters("browser")//hold a value
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		//Read browser name and URL from property File
		String BROWSER= pUtil.getDataFromProprtyFile("browser");
		
		
	   String URL = pUtil.getDataFromProprtyFile("url");
			
		if (BROWSER.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			System.out.println(BROWSER + " === Browser launched ===");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " === Browser launched ===");
		} else {
			System.out.println("==== invalid Browser name ====");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//only used for listener to take screenshot
		sdriver=driver;

		//Load the URL
		driver.get(URL);
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		//read username and passowrd from property file
		String USERNAME = pUtil.getDataFromProprtyFile("username");
		String PASSWORD = pUtil.getDataFromProprtyFile("password");
		
		Loginpage lp = new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("==== Login Successful ====");
	}


	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("==== Logout Successful ====");
	}
		
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println(" ========== Browser Closed ========");
	}
		
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====== db connection closed ======");
	}

}

