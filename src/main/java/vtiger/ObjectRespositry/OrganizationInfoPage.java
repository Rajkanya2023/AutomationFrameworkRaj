package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement OrgHeaderText;
		
		// Initialization
		public OrganizationInfoPage(WebDriver driver) {// test script
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getOrgheaderText() {
			return OrgHeaderText;
		}
		
		//Business Library
		// this method will capture the header text and return it to caller
		public String getHeaderText()
		{
			return OrgHeaderText.getText();
		}

}
