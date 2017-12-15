package utility;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingUserDataFromExcel {
		//1. check whether TC is present or not
		//2. If TC is present then check for Run Mode
		//3. If run mode is Yes then run that TC
		
	public static boolean isTCPresent(String TestCaseName) throws IOException
	{
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\UserData\\LoginUserData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh=wb.getSheet("AllTestCases");
		
		//tsotal no of rows
		int totalRows=sh.getPhysicalNumberOfRows();
		
		//total no of columns
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=1;i<totalRows;i++)
		{
			if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TestCaseName))
			{
				if(sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y"))
				{
					return true;
				}
			}
		
		
		}
		return false;
	}
	public static Object[][] readTCdata(String SheetName) throws IOException
	{
		//System.out.println(SheetName);
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\UserData\\LoginUserData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh= wb.getSheet(SheetName);
		
		//total no of rows
		int totalRows=sh.getPhysicalNumberOfRows();
		
		//total no of columns
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		// create two D Object Array
		Object arr[][] = new Object[totalRows][totalColumns];
		
		for(int i=0;i<totalRows;i++)
		{
			for(int j=0;j<totalColumns;j++)
			{
			arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}

}
