package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// this class providd implemeation for IretryAnlayser interface
public class RetryAnalyserImplemation implements IRetryAnalyzer{

	int count=1;
	int retryCount=3;
	
	
	public boolean retry(IRetryAnalyzer result) {
		//1<=3 2<=3 3<=3 4<=3
		while(count<=retryCount)
		{
			count++;
			return true;//retry retry retry
		}
		
		
		
		
		return false;//dont count
		
	}


	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
			
}
