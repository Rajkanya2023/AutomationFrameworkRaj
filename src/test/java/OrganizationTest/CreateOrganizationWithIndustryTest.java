package OrganizationTest;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUltility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertiesFileUtility;
import vtiger.GenericUtilities.WebdriverUtilirty;
import vtiger.ObjectRespositry.CreateNewOrganizationPage;
import vtiger.ObjectRespositry.HomePage;
import vtiger.ObjectRespositry.Loginpage;
import vtiger.ObjectRespositry.OrganizationInfoPage;
import vtiger.ObjectRespositry.OrganizationPage;


public class CreateOrganizationWithIndustryTest extends BaseClass {
	
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createOrgWithIndustryTest() throws  Throwable
	{
		
		/* Read Data from Excel sheet - Test data */
 		String ORGNAME = eUtil.getDataFromExcel("Organization",4,2)+jUtil.getRandomNumber();
		String INDUSTRY1 = eUtil.getDataFromExcel("Organization",4,3);
			
		
		//Step 5: Click on Organizations Link
		HomePage hp=new HomePage(driver); //we modify the scrip we optimize scrip using object reposirty
				hp.ClickOnOrgLink();// we decrese the work of locator so we crete the object repositry
		
		//Step 6: click on Create Organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpIMG();// object reposirty we take drictly loactor optimized
		
		//Step 6: create Organization
		CreateNewOrganizationPage cnop=new  CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY1);// same here we access from obj Repositry

		
		//Step 8: Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();// remove the locator accrsss by obj
		

		
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
	}




@Test
public void demotest() 
{
   System.out.println("demo");	
	
}

}
