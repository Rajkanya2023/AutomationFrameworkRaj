package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// this class provied implementes ti ITestListner of TestNG 
public class ListenerImplemationClass implements ITestListener{

	public void onTestStart(ITestResult result) {// right click sources then select the overide method all ab method will come
	String methodName = result.getMethod().getMethodName();
		System.out.println("....Excution stared..."+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println("....Pass..."+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("....Fail..."+methodName);
		System.out.println(result.getThrowable());
		
		WebdriverUtilirty wu =new WebdriverUtilirty();
		JavaUtility ju=new JavaUtility();
		
		String screenShotName = methodName+ju.getSystemdate();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("....Skip..."+methodName);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// start of suite tag @Beforesuite
		System.out.println("suite excution start");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// end of suite tag @Aftersuite

		System.out.println("suite execution ended");
	}

}
