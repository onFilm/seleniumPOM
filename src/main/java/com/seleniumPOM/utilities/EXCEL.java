package com.seleniumPOM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class EXCEL {

	// Dependencies: POI | HSSF Workbook/Sheet/Row/Cell
	// This method will read and return Excel data into a double array
	public static String[][] get(String filename) {
		String[][] dataTable = null;
		File file = new File(filename);
		try {
			// Create a file input stream to read Excel workbook and worksheet
			FileInputStream xlfile = new FileInputStream(file);
			HSSFWorkbook xlwb = new HSSFWorkbook(xlfile);
			HSSFSheet xlSheet = xlwb.getSheetAt(0);

			// Get the number of rows and columns
			int numRows = xlSheet.getLastRowNum() + 1;
			int numCols = xlSheet.getRow(0).getLastCellNum();

			// Create double array data table - rows x cols
			// We will return this data table
			dataTable = new String[numRows][numCols];

			// For each row, create a HSSFRow, then iterate through the "columns"
			// For each "column" create an HSSFCell to grab the value at the specified cell
			// (i,j)
			for (int i = 0; i < numRows; i++) {
				HSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; j < numCols; j++) {
					HSSFCell xlCell = xlRow.getCell(j);
					dataTable[i][j] = xlCell.toString();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		return dataTable;
	}

}
