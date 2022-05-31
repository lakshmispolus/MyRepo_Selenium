package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static XSSFWorkbook w;
	public static HSSFSheet s;
	public static FileInputStream f;

	public static String readStringData(int i, int j) throws IOException {

		File file = new File("src\\test\\resources\\TestData_ExcelFiles\\TestData.xls");
		Workbook workBook = WorkbookFactory.create(file);
		int sheetNumber = 0;
		Object sheet = workBook.getSheetAt(sheetNumber);
		Row r = ((HSSFSheet) sheet).getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int i, int j) throws IOException {

		File file = new File("src\\test\\resources\\TestData_ExcelFiles\\TestData.xls");
		Workbook workBook = WorkbookFactory.create(file);
		int sheetNumber = 0;
		Object sheet = workBook.getSheetAt(sheetNumber);
		Row r = ((HSSFSheet) sheet).getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);

	}

}