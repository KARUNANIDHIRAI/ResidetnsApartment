package com.residents.residentsResource.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String XlFile, String XlSheet) throws IOException {
		fis = new FileInputStream(XlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		int rowCount= ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	public static int getCellCount(String XlFile, String XlSheet, int rowNum) throws IOException {
		fis = new FileInputStream(XlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row=ws.getRow(rowNum);
		int cellCount= row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	public static String getCellData(String XlFile, String XlSheet, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(XlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row= ws.getRow(rowNum);
		cell = row.getCell(colNum);
	
		
		String data;
		try {
			DataFormatter Formatter = new DataFormatter();
			String cellData = Formatter.formatCellValue(cell);
			return cellData;
			
					
		}
		catch (Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}

	public static void setCellData(String XlFile, String XlSheet, int rowNum, int colNum, String data) throws IOException {
		fis = new FileInputStream(XlFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XlSheet);
		row= ws.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
        fos = new FileOutputStream(XlFile);
	    wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	
}
