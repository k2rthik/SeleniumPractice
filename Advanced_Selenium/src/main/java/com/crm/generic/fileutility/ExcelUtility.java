package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public String readFromExcel(String sheet,int rnum, int cnum) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rnum).getCell(cnum).toString();
		wb.close();
		fis.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public void writeIntoExcel(String sheet,int rnum, int cnum,String data) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		if(wb.getSheet(sheet).getLastRowNum()<rnum)
			wb.getSheet(sheet).createRow(rnum).createCell(cnum).setCellValue(data);
		else 
			wb.getSheet(sheet).getRow(rnum).createCell(cnum).setCellValue(data);
		
		FileOutputStream fo = new FileOutputStream("./src/test/resources/testdata.xlsx");
		wb.write(fo);
		wb.close();
		fis.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		ExcelUtility eu = new ExcelUtility();
		System.out.println(eu.readFromExcel("tsData", 5, 0));
		System.out.println(eu.getRowCount("tsData"));
		//eu.writeIntoExcel("tsData", 5, 0, "meh");
	}
}
