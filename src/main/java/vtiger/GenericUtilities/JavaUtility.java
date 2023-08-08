package vtiger.GenericUtilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * This class consists of all generic method related to java
 * @author Admin
 *
 */

public class JavaUtility {
	/**
	 * this method will generated a random method related to java
	 * @return Random value 
	 */
	
	
	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	
	public String getSystemdate()
	{
	      SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	       Date d = new Date();
	       String date=sf.format(d).toString();
	       
	       return date;
	       
	       
	    		 
	}
	

	
	
	
	
	
	
	
	
	
	

}
