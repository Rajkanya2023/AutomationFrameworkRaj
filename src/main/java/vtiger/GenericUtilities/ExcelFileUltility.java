package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Chaitra M
 *
 */
public class ExcelFileUltility {
	
	/**
	 * This method will read data from excel sheet based of sheet name, row no 
	 * and cell No given by caller
	 * @param sheetName
	 * @param rowNow
	 * @param celNo
	 * @return value
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNow, int celNo) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream(IContstants.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNow).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
		
	}
	
	/**
	 * This method will write data into the excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IContstants.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IContstants.excelFilepath);
		wb.write(fos); // action
		wb.close();
		
	}
	
	
	
	

}

