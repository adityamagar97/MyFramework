package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class provide {
	
	@DataProvider(name="regis")
	public static Object[][] senddata() throws IOException {
		
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream("/Users/adityamagar/Desktop/TNS /Store_TestCases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("adi");
		
	    System.out.println("Reading from sheet: " + (sheet != null ? sheet.getSheetName() : "Sheet not found!"));
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		
		Object obj[][] = new Object[row][col];
		for(int i=0;i<row;i++) {
			
			XSSFRow rows= sheet.getRow(i+1);
			
			for(int j=0;j<col;j++) {
				
				XSSFCell cello = rows.getCell(j);
				obj[i][j] = df.formatCellValue(cello);
			}
		}
		return obj;
		
	}
	@DataProvider(name="Login")
	public static Object[][] sendddata() throws IOException {
		
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream("/Users/adityamagar/Desktop/TNS /Store_TestCases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("adi");
		
	    System.out.println("Reading From Sheet : " + sheet.getSheetName() );
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		
		Object obj[][] = new Object[row][col];
		for(int i=0;i<row;i++) {
			
			XSSFRow rows= sheet.getRow(i+1);
			
			for(int j=0;j<col;j++) {
				
				XSSFCell cello = rows.getCell(j);
				obj[i][j] = df.formatCellValue(cello);
			}
		}
		return obj;
		
	}

}
