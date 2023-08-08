package ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRespositry.ContactInfoPage;
import vtiger.ObjectRespositry.ContactsPage;
import vtiger.ObjectRespositry.CreateNewContactPage;
import vtiger.ObjectRespositry.CreateNewOrganizationPage;
import vtiger.ObjectRespositry.HomePage;
import vtiger.ObjectRespositry.OrganizationInfoPage;
import vtiger.ObjectRespositry.OrganizationPage;

public class CreateContactWithOrganisationTest extends BaseClass{

	@Test
	public void createContactWithOrgTest() throws Throwable {

		/* Create Organization */

		// Step 1: Read all the necessary data

		String ORGNAME = eUtil.getDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contact", 4, 2);

		// Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLink();

		// Step 6: click on Create Organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpIMG();

		// Step 6: create Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME);

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader=oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);

		/* Create Contact using Organization */

		// step 9: click on contacts link - 500 - update 
		hp.clickOnContactLink();

		// Step 10: Navigate to create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUp();

		// step 10: Create a contact with mandatory information
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);

		// Step 15: Validate for Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader=cip.getContactHeaderText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
	    System.out.println(ContactHeader);
		
		

	}
	@Test
	public void demotest() 
	{
	   System.out.println("demo");	
		
	}

}

