package vtiger.ObjectRespositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebdriverUtilirty;

public class CreateNewContactPage extends WebdriverUtilirty{
	// Declaration
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
    private WebElement OrgLookUpImg;
    
    @FindBy(name="search_text")
    private WebElement OrgSearchEdt;
    
    @FindBy(name="search")
    private WebElement OrgSearchBtn;
    
    //initilization
    public CreateNewContactPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
  //Utilization
    public WebElement getLastNameEdt() {
    	return LastNameEdt;
  		
  		}
    
    public WebElement getSaveBtn() {
			return SaveBtn;
		}
    
    public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}
    
    public WebElement getOrgSearchEdt() {
			return OrgSearchEdt;
		}
    public WebElement getOrgSearchBtn() {
			return OrgSearchBtn;
		}
    
    //Business Libray
    
    // this method will create the contact with mandatory information
    
    public void createContacts(String LASTNAME)
    {
    	LastNameEdt.sendKeys(LASTNAME);
    	SaveBtn.click();
    }
    
    // this method will creete with relevant Orgnization
    
    public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)
    {
    	LastNameEdt.sendKeys(LASTNAME);
    	OrgLookUpImg.click();
    	switchToWindow(driver,"Account");
    	OrgSearchEdt.sendKeys(ORGNAME);
    	driver.findElement(By.xpath("//a= '"+ORGNAME+"']")).click();
    	switchToWindow(driver,"Contact");
    	SaveBtn.click();
    	
    }
}
