package vtiger.practices;

public class Genericmethodpratices {
	public static void main(String[] args) {//caller
		
		int result=add(40, 20);
		System.out.println(result);
		
	}
	
	
	public static int add(int a,int b)// called
	{
		int c =a+b;
		return c;
	}

}
