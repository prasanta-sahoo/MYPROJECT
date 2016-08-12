package com.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;



public class Readxsl {

	/*
	Note : Excel File must be of Word 97-2003 format as jxl support that only
	 To read excel file  
	 @param xlFilePath - excel file path
	 @param sheetName - sheetname of excel
	 @param tableName - tableName within excel file
	 **/
	public static String getCellvalue(String path,String SheetName,int raw,int cal) 
			throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fs);
		int type = wb.getSheet(SheetName).getRow(raw).getCell(cal).getCellType();
		  String value = "";
	        if(type==Cell.CELL_TYPE_STRING){
	            value = wb.getSheet(SheetName).getRow(raw).getCell(cal).getStringCellValue();  
	            System.out.print(""+value);
	        }else if(type==Cell.CELL_TYPE_NUMERIC){
	            int numValue = (int) wb.getSheet(SheetName).getRow(raw).getCell(cal).getNumericCellValue();
	            value = ""+numValue;
	            System.out.print(""+value);
	        }else if(type==Cell.CELL_TYPE_BOOLEAN){
	            boolean boolValue =  wb.getSheet(SheetName).getRow(raw).getCell(cal).getBooleanCellValue();
	            value = ""+boolValue;
	            System.out.print(""+value);
	        }
	        return value;
		}
	
	 public static void writeData(String pathOfFile, String sheetName, int rowNum, int cellNum, String value)
			 
			 throws InvalidFormatException, IOException{
	        FileInputStream fis = new FileInputStream(pathOfFile);
	        Workbook wb = WorkbookFactory.create(fis);
	        wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
	        FileOutputStream fos = new FileOutputStream(pathOfFile);
	        wb.write(fos);
	    }
}
