package datadriven_testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWriteIntoSheet
{
	public static void main(String[] args) throws Exception
	{
		String fpath = "C:\\Users\\broly\\OneDrive\\Desktop\\data\\tsData.xlsx";
		FileInputStream fs = new FileInputStream(fpath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet ts = wb.getSheet("tsData");
		Cell cell = ts.getRow(4).createCell(0);
		cell.setCellValue("blah");
		System.out.println(ts.getRow(3).getCell(1).toString());
		
		FileOutputStream fo = new FileOutputStream(fpath);
		wb.write(fo);
		wb.close();
	}
}
