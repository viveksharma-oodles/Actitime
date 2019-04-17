package com.actitime.generic;

import java.io.File;
/*
 * */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutilities {
	static final String filePath= "./testdata/testdata.xlsx";
	
	
	public static String readData(String sheet, int row, int cell) {
		
		String value =null;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
			value=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return value;
		
		
		
	}


}