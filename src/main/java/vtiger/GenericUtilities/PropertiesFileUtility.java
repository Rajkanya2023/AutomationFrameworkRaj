package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consist of genric method relatd to property file
 * @author Admin
 */

public class PropertiesFileUtility {
	/**
	 * This method reads data from property file base on given key
	 * @param key
	 * @return value
	 * @throws IOException 
	 * 
	 * 
	 */
	
	
	public String getDataFromProprtyFile(String key) throws IOException {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		 String value=p.getProperty(key);
		 return value;
	}

}
