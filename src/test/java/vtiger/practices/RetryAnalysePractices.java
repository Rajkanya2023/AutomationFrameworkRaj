package vtiger.practices;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalysePractices {
	@Test(retryAnalyzer =vtiger.GenericUtilities.RetryAnalyserImplemation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
