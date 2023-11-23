package org.h2k.openmrs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary {
	public String generateFutureDate(int n)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 10);
		Date d = cal.getTime();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		System.out.println(sdf.format(d));
		return sdf.format(d);
	}
	
	public String generateRandomString(String str)
	{
		Random rand = new Random();
		int value = rand.nextInt(100); // between range 0-99 .. excluding 100
		int upperCaseValue = 65 + rand.nextInt(26);
		char upperCaseChar = (char)upperCaseValue;
		System.out.println(upperCaseChar);
		int lowerCaseValue = 97+ rand.nextInt(26);
		char lowerCaseChar = (char)lowerCaseValue;
		System.out.println(lowerCaseChar);
    	String name=str+upperCaseChar+lowerCaseChar+value;
    	System.out.println(name);
    	return name;
	}
	
	public String[][] readXLSX() throws IOException
	{
		File f = new File("InputData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of rows::" +rows);
		System.out.println("Number of columns::" +columns);
		
		String data[][] = new String[rows][columns];
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				data[i][j] = cell.getStringCellValue();
				System.out.print(data[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return data;
	}
}