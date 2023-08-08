package vtiger.practices;

	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import vtiger.GenericUtilities.ExcelFileUltility;
	import vtiger.GenericUtilities.JavaUtility;
	import vtiger.GenericUtilities.PropertiesFileUtility;
	import vtiger.GenericUtilities.WebdriverUtilirty;

	public class CreateContactWithOrgPractices {

	public static void main(String[] args) throws Throwable {
			/* create Organization */
		// create object requried utilities //
		JavaUtility jUltil=new JavaUtility();
		ExcelFileUltility eUltil= new ExcelFileUltility();
		PropertiesFileUtility pUltil=new PropertiesFileUtility();
		WebdriverUtilirty wUltil=new WebdriverUtilirty();
		
			WebDriver driver=null;
			
			//Step 1: Read all the necessary data
			
			/* Read data from property File - Common Data */
			
			String BROWSER = pUltil.getDataFromProprtyFile("browser");
			String URL = pUltil.getDataFromProprtyFile("url");
			String USERNAME = pUltil.getDataFromProprtyFile("username");
			String PASSWORD = pUltil.getDataFromProprtyFile("password");
			
			/* Read Data from Excel sheet - Test data */

			String ORGNAME = eUltil.getDataFromExcel("Contact",4,3)+jUltil.getRandomNumber();
			String LASTNAME = eUltil.getDataFromExcel("Contact",4,2);
			
			//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
			
				driver = new ChromeDriver();
				System.out.println(BROWSER+" --- Browser launched");
				
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				
				driver = new FirefoxDriver();
				System.out.println(BROWSER+" --- Browser launched");
			}
			else
			{
				System.out.println("invalid Browser name");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Step 3: Load the URL
			driver.get(URL);
			
			//Step 4: Login to the Application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//Step 5: Click on Organizations Link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 6: click on Create Organization look up image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step 6: create Organization
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
			//Step 7: save 
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 8: Validate for Organization
			String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println("Orgnization Created ");
				System.out.println(OrgHeader);
			}
			else
			{
				System.out.println("Fail");
			}
			
			// Create Contact Using Organization//
			
			// step 9: click on contacts link
			driver.findElement(By.linkText("Contacts")).click();
			
			
			// Step 10: Navigate to create contact look up image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			// step 10: Create a contact with mandatory information
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']"));
			
			//step 11: switch to child window
			wUltil.switchToWindow(driver, "Accounts");
			
			//step 12: search for Organization
			driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
			
			//step 13:switch the control back to parent window
			wUltil.switchToWindow(driver, "Contacts");
			
			//step 14: save
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			// step 15: Validate for Organization
			
			String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(ContactHeader.contains(LASTNAME))
			{
				System.out.println("PASS ");
				System.out.println(ContactHeader);
			}
			else
			{
				System.out.println("Fail");
			}
			

			//Step 15: Logout of Application
					WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wUltil.mouseHoverAction(driver, AdminImg);
					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("Logout successfull");
			
	}		
	}


