package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebdriverUtilirty;

public class CreateNewOrganizationPage extends WebdriverUtilirty{
	// Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name= "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// utilizaton
	public WebElement getOrgNameEdt() {
		
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn()
	{
		return IndustryDropDwn;
		
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
		
	}
	
	// Business Libries
	// this method will crated Org with mandatory fields
	public void CreateOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
		
	}

	// this method will crete organization with indusrty drop down
	public void CreateOrganization(String ORGNAME, String Industry )
	{
		OrgNameEdt.sendKeys(ORGNAME);
           handleDropDown(IndustryDropDwn,Industry);// this ex of methodoverloadng so exted the webdriverutility
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
