package com.magicbricks.parameters;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static String getCellData(String excelPath, String sheetName, int rowNum, int ColNum) {
		String cellData = "";
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			cellData = wb.getSheet(sheetName).getRow(rowNum).getCell(ColNum).toString();
		} catch (Exception e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}
		return cellData;
	}

}
