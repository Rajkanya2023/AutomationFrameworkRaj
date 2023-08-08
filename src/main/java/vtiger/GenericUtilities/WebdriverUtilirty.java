package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
// this class consisit of all the re usable methods related to web driver actions
public class WebdriverUtilirty {
	
	public void maximizeWindow(WebDriver driver)// upadted driver references
	{
		driver.manage().window().maximize();
	}
	
	public void maximazeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	// this method will wait for all findelement and findelements operation to be performed.
	//@param driver
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	// this method will wait until the specific element is visible in DOM
	public void waitForElementToVisible(WebDriver dirver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(dirver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);			
	}
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	public void dragAndDropAction(WebDriver driver,WebElement targetElement,WebElement srcElement)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(srcElement,targetElement).perform();
	}
	
	//this method is used to move the cursor anywhere on the web page based on offset values.
	//@param driver
	//@param  xOffset
	// @param yoffset
	public void moveAcrossWebPage(WebDriver driver,int xoffSet,int yoffSet)
	{
		Actions act= new Actions(driver);
		act.moveByOffset(xoffSet, yoffSet).perform();
	
	}
	
	// this method will scroll vertically for 500 pixcel
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollBy(0,500);","");
		
	}
	
	// this method will scroll vertically until the element refrences
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView();",element);
			
	}
	// this method will accept alert pop ups
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	// this method will cancel the conformation pop up 
	//@param driver
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	
    // this method will enter the text in prompt pop up
	
	public void sendTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	// this method will capture the alert message and return to the calle
	public void getTextAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().getText();
	}
	
	// 
	public void handleframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	// this method will handle frame based on values of name ID attribute
	public void handleframe(WebDriver driver,String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	
	// this method will handleframe based on web element 
	//@param driver
	//@param element
	public void handleframe(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	// this method will help to switch the control to immediate parent
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	// this method will help to switch the control back to current page.
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	// this method will switch the selenium control frrom parent to child or
	// child to parent based on partiL window title
	//@param driver
	//@param partialWinTile
	public void switchToWindow(WebDriver driver, String partialWinTitle)	
	{
		//step1-capture all the windowids
		Set<String> allwindowids = driver.getWindowHandles();
		
	//step2-iterate though individual ids
		for(String winID:allwindowids)
			
		{
			//Ste3-switch to each ID and capture the title
			String CurrentTitle =driver.switchTo().window(winID).getTitle();
			
			//Step4-compare the title with required refrences
			if(CurrentTitle.contains(partialWinTitle))
				
			{
			break;
			}	
		}
	}
	
	
	// this method will take screen shot and return the absoulte path of it 
	//@param drver
	//@param screenshotsname
	//@return path
	//@throws ioexcepton

	public String takeScreenShot(WebDriver driver, String screenshotname)throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	     File src=ts.getScreenshotAs(OutputType.FILE);
	    File dst= new File("\\Screenshots\\"+screenshotname+".png");
	    Files.copy(src, dst);//this class is from common io tool
	    return dst.getAbsolutePath();//attach the screen shot to extent reports

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
