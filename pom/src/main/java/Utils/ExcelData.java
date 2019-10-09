package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.sun.media.sound.InvalidFormatException;

public class ExcelData {
	
	public Object[][] getCellData(String path, String sheetName) throws InvalidFormatException, IOException {
		FileInputStream fis= new FileInputStream(path);
		Workbook wb = new HSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
	  int rowcount = sheet.getLastRowNum();
	  int cellcount = sheet.getRow(0).getLastCellNum();
	  String data[][] = new String[rowcount][cellcount];
	  for (int i = 1; i <=rowcount; i++) {
	   Row r = sheet.getRow(i);
	   for (int j = 0; j <cellcount; j++) {
	   Cell c = r.getCell(j);
	   c.setCellType(Cell.CELL_TYPE_STRING);
	      data[i - 1][j] = c.getStringCellValue();
	   }
	  }
	  wb.close();
	  return data;
	 
	 }

}
