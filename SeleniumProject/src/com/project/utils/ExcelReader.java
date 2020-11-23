package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void ReadFromExcel(String filepath, String filename, String sheetname) throws IOException
	{
		
		File file = new File(filepath + "/" + filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		System.out.println("The number of rows are: " + rowCount);
		for(int r = 0; r < rowCount+1; r++)
		{
			Row row = sheet.getRow(r);
			for(int c = 0; c<row.getLastCellNum();c++)
			{
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue().toString() + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException
	{
		String ProjectPath = System.getProperty("user.dir");
        String filepath = ProjectPath + "/src/com/project/testdata";
        String filename = "CalorieTestData.xlsx";
        String sheetname ="CalorieTestSheet";
        ExcelReader.ReadFromExcel(filepath, filename, sheetname);
	
	}
}