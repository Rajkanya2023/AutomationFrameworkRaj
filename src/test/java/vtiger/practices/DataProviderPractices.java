package vtiger.practices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractices {

	@Test(dataProvider = "getdata")
	public void addToCartTest(String name,int price,String model)
	{
		System.out.println("name is "+name+" price is "+price+" model is "+model+"");	
	}
	
	
	@DataProvider
	public Object[][] getData()// row column
	{
		Object[][] data=new Object[3][3];
		
		data[0][0]="Iphone";// 1st set of data
		data[0][1]=3000;
		data[0][2]="S23";
		
		data[1][0]="redmi";// 2nd set of data
		data[1][1]=4000;
		data[1][2]="A3";
		
		data[2][0]="samsun";// 3rd set of Data
		data[2][1]=5000;
		data[2][2]="R6";
		
		return data;
		
		
		
		
		
		
		
		
		
		
		
	}
}
