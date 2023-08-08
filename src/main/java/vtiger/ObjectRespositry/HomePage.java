package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {// Rule no 1: crated a separeted pom class for every web page
	//Rule no2: Identify the web element using @FindBy,@FindBys,@FindAll
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement Organizationslinktext;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	
	@FindBy(linkText ="SignOutLnk")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	public WebElement getOrganizationslinktext() {
		return Organizationslinktext;
	}
	
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	
	// Business Library
	
	// this method will click on org link
	public void ClickOnOrgLink()
	{
		Organizationslinktext.click();
	}
	
	// this method will click on contact link
	
	public void clickOnContactLink() {
		ContactsLnk.click();
	}

	public void logoutOfApp(WebDriver driver) {
		
		
	}	
	
	
	
	

}
