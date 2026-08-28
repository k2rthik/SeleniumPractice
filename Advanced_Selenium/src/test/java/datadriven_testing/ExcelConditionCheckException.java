package datadriven_testing;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelConditionCheckException
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\broly\\OneDrive\\Desktop\\tsData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ws = wb.getSheet("tsData");
		String expected = "peh";
		boolean avail = false;

		for (int i = 1; i <= ws.getLastRowNum(); i++)
		{
			String data;
			Row row = ws.getRow(i);
			try
			{
				data = row.getCell(1).toString();
				if (data.equals(expected))
				{
					avail = true;
					System.out.println(row.getCell(0).toString() 
							+ "\t" + row.getCell(1).toString() 
							+ "\t" + row.getCell(2).toString());
				}
			} catch (Exception e){}
		}

		if (!avail)
			System.out.println(expected + " is not available");
	}
}
