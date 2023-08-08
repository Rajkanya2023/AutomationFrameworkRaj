package vtiger.practices;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserationPractices {
	@Test
	public void SampleTest() {
		
		int a=1;
		int b=1;
		Assert.assertEquals(b, a);
		System.out.println("excuation and validation complted");
	}
	
	@Test
	public void SampleTest2() {
		
		SoftAssert sa=new SoftAssert();
		int a=1;// exp
		int b=2;// actual
		sa.assertEquals(b, a);
		 System.out.println("step1");
		 sa.assertEquals(false, true);//fail
		 
		 System.out.println("step2");
		 
		 //Assert.assertEquals(b, a);//failed 
		 
		 System.out.println("step3");
		 
		 System.out.println("step4");
		 
		 sa.assertTrue(false);
		 
		 System.out.println("excuation and validation complted");
		 sa.assertAll();// logging all the faliluar
		 
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
