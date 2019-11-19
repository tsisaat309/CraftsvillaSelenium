//Class Recording 13 - read values from this excel file
//need to have Apache POI jar files in build path

package com.craftsvilla.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	
	public static String[][] getData(String filename, String sheetname){
		File f = null;  //define the file
		FileInputStream fin = null;  //this is to read
		Workbook wb = null;  //the excel workbook
		Sheet sh = null;  //the excel sheet
		
		
		
		//Need to have a try catch to catch errors in case file read files and handle them gracefully
		try {
			f = new File(filename);			//create a new filw
			fin = new FileInputStream(f);	//new readline
			wb = new XSSFWorkbook(fin);		//create the workbook
			sh = wb.getSheet(sheetname);	//the sheet
			
			int rows = sh.getLastRowNum();  //get count of rows
			int cols = sh.getRow(0).getLastCellNum(); //to get number of columns for each row
			
			//Now you're able to construct a 2D array
			String[][] data = new String[rows][cols];
			
			//loop through the excel file all rows and cols
			for(int i = 0;i<rows;i++) {
				
				Row r = sh.getRow(i);		
				
				for(int j =0;j<cols;j++) {
					
					Cell c = r.getCell(j);  //getCell
					String value = new DataFormatter().formatCellValue(c);  //must make it a string character
					data[i][j] = value;
				}
			}
			
			return data;
		}
		catch(Exception e)
		{
			return null;
		}
		finally {
			try {
				sh = null;
				wb.close();
				wb=null;
				fin.close();
				fin=null;
				}
			catch(Exception e){
				return null;
			}
		}

	}
}



