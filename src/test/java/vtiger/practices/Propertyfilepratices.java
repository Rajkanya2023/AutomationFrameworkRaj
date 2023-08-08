package vtiger.practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfilepratices {
	public static void main(String[] args) throws IOException {
		// step1: load the document in java readable format
		// step2:create object of properties class from java.util
		// step3: load the file into properties class
		//step 4: provided keys and get the values
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		Object value = pObj.getProperty("browser");
	System.out.println(value);
		
		
	}

}
