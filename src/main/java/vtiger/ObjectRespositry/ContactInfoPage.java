package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	//Declaration
			@FindBy(xpath = "//span[@class='dvHeaderText']")
			private WebElement ContactsHeaderText;
			
			// Initialization
			public ContactInfoPage(WebDriver driver) {// test script
				PageFactory.initElements(driver, this);
			}
			
			//Utilization
			public WebElement getContactheaderText() {
				return ContactsHeaderText;
			}
			
			//Business Library
			// this method will capture the header text and return it to caller
			public String getContactHeaderText()
			{
				return ContactsHeaderText.getText();
			}


}
