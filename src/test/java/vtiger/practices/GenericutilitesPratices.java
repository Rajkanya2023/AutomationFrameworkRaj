package vtiger.practices;

import java.io.IOException;

import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertiesFileUtility;

public class GenericutilitesPratices {
	public static void main(String[] args) throws IOException {

		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.getRandomNumber();
		System.out.println(value);

		PropertiesFileUtility pUtil = new PropertiesFileUtility();
		String value1 = pUtil.getDataFromProprtyFile("browser");
		System.out.println(value1);
		String date = jUtil.getSystemdate();
		System.out.println(date);
		
		

	}

}
