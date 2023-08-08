package vtiger.ObjectRespositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {// Rule no 1: crated a separeted pom class for every web page

	//Rule no2: Identify the web element using @FindBy,@FindBys,@FindAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule no3: Create a constructor to initialise the web elements
	public  Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Rule no4: Provide the getter access these web elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Libray-project spcific genric method
	
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
