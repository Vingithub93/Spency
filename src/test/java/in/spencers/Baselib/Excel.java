package in.spencers.Baselib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static FileInputStream fis;
	public static Workbook wb;
	
	public static String getCellvalue(String sheetName, int row, int cell)
	{
		try{
		fis =new FileInputStream("./data/input.xlsx");
		wb = WorkbookFactory.create(fis);
		}
		catch(Exception exe)
		{
			
		}
		return wb.getSheet(sheetName).getRow(row).getCell(cell).toString();

	}
}
