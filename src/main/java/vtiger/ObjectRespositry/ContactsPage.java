package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
		@FindBy(xpath = "//img[@tiltle='Create Contact...']")
		private WebElement CreateContactsLookUpImg;
		
		// Initialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getCreateContactLookUpImg() {
			return CreateContactsLookUpImg;
		}
		
		//Business Library
		// this method will click on create organization look up Image
		public void clickOnCreateContactLookUp()
		{
			CreateContactsLookUpImg.click();
		}

}
