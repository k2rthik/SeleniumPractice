package datadriven_testing;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UsingExcelFile
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\broly\\OneDrive\\Desktop\\tsData.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet ts = wb.getSheet("tsData");
		for (int i = 1; i <= ts.getLastRowNum(); i++)
		{
			for (int j = 0; j < ts.getRow(i).getLastCellNum(); j++)
			{
				System.out.print(ts.getRow(i).getCell(j).toString() + "\t");
			}
			System.out.println();
		}

		wb.close();
	}
}
