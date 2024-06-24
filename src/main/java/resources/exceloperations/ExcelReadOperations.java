package resources.exceloperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import resources.webdriveroperations.AppConfig;
public class ExcelReadOperations {

	public static String GetDataFromExcel(String SheetName,int RowNum,int CellNum) throws IOException
	{   String path="";
		if(AppConfig.env.contentEquals("QA"))
		{
			path = "Login_Credentials/MasterDataSheet.xlsx";
		}
		else if(AppConfig.env.contentEquals("UAT"))
		{
			path= "Login_Credentials/MasterDataSheetUAT.xlsx";
		}
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);
		
		double numericvalue =0;
		Date dateCellVal;
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		String Data= null;
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();	
		Cell tempCellData = row.getCell(CellNum);
		evaluator.evaluateFormulaCell(tempCellData);	
			
		if(tempCellData.getCellType()==CellType.STRING)
			{	evaluator.evaluateFormulaCell(tempCellData);
				Data= row.getCell(CellNum).getStringCellValue();
				
			}
			else if(tempCellData.getCellType()==CellType.NUMERIC)
			{	evaluator.evaluateFormulaCell(tempCellData);
				numericvalue= row.getCell(CellNum).getNumericCellValue();
				Data = NumberToTextConverter.toText(numericvalue);
			}
			else if(tempCellData.getCellType()==CellType.NUMERIC)
			{	evaluator.evaluate(tempCellData);
				numericvalue= row.getCell(CellNum).getNumericCellValue();
				Data = NumberToTextConverter.toText(numericvalue);
			}
			else if(tempCellData.getStringCellValue().contains("/"))
			{	evaluator.evaluateFormulaCell(tempCellData);
				dateCellVal= row.getCell(CellNum).getDateCellValue();
				Data = df.format(dateCellVal);
			}
			else
			{	evaluator.evaluateFormulaCell(tempCellData);
				Data= row.getCell(CellNum).getStringCellValue();
			}
		workbook.close();
		return Data;
	}

	public static int GetTotalRowsfromExcelSheet(String SheetName) throws IOException
	{
		String path = "Login_Credentials/MasterDataSheet.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		workbook.close();
		int totalrow = sheet.getLastRowNum();
		return totalrow;

	}


}
