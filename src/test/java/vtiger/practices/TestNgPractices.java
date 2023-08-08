package vtiger.practices;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractices {
	
	@Test(priority = 1)
	public void createdCustomer()//failed for 3 mins
	{
		Assert.fail();// purposefully fail the script
		System.out.println("customer craeted");
	}
	@Test(invocationCount = 2)
	public void modifedCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test(priority = 2,invocationCount = 3)
	public void deledtedCustomer()
	{
		System.out.println("customer deledted");
	}

}
