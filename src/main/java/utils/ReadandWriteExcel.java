package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadandWriteExcel {
	
	
	private Workbook wb;

	public void writeexcel(String filePath, String fileName,
			String sheetName, String[] dataToWrite) throws IOException {
		
		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		
		// Create an object of FileInputStream class to read excel file
		FileInputStream fin = new FileInputStream(file);
		
		
		Workbook workbook = null;
		
		// Find the file extension by splitting file name in substring and getting only extension name

	     String fileExtensionName = fileName.substring(fileName.indexOf("."));
	     
	  // Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(fin);
		} else if(fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			workbook = new HSSFWorkbook(fin);
		}
		
		// Read excel sheet by sheet name
           Sheet sheet = workbook.getSheetAt(0);
   		// Get the current count of rows in excel file

   		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

   		// Get the first row from the sheet

   		Row row = sheet.getRow(0);

   		// Create a new row and append it at last of sheet

   		Row newRow = sheet.createRow(rowCount + 1);

   		// Create a loop over the cell of newly created Row

   		for (int j = 0; j < row.getLastCellNum(); j++) {

   			// Fill data in row

   			Cell cell = newRow.createCell(j);

   			cell.setCellValue(dataToWrite[j]);

   		}

   		// Close input stream

   		fin.close();

   		// Create an object of FileOutputStream class to create write data in excel file

   		FileOutputStream outputStream = new FileOutputStream(file);

   		workbook.write(outputStream);

   		// close output stream

   		outputStream.close();

   	}
   	
   	public void clearExcel(String excelFilePath)
   	{
   		File file = new File(excelFilePath);

   		try {
   	
   		FileInputStream inputStream = new FileInputStream(file);
   		
   		wb = new XSSFWorkbook(inputStream);
   		
   		Sheet sheet = wb.getSheetAt(0);
   		
   		sheet = wb.getSheetAt(0);
   		for (Row row : sheet) {
   		   sheet.removeRow(row);
   		}
   		
   		System.out.println("EXCEL CLEARED");
   		
   		} catch (Exception e) {
   			System.out.println("could not clear excel... "+e);
   		}
   	}
	}


