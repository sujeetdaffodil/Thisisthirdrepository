package resources.exceloperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.opencsv.CSVWriter;

public class ExcelWriteOperations {
	static String workspacePath= System.getProperty("user.dir");
	
	public static void UpdatePasswordInExcelSheet(String NewPassword, String SheetName) throws IOException
	

	{	String path = workspacePath+"Login_Credentials/MasterDataSheet.xlsx";	
		Cell cell = null;
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(SheetName);
		
		Row row = sheet.getRow(1);
		cell= row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				

	    if (cell == null) {
	        cell = row.createCell(1);
	        cell.setCellValue(NewPassword);

	        } else {

	        	cell.setCellValue(NewPassword);

	        }

		fis.close();
	    FileOutputStream outFile =new FileOutputStream(new File(path));
	    workbook.write(outFile);
	    workbook.close();
	    outFile.close();
	}
	
	public static void GenerateDeregisterCsv(List<String> emails) throws IOException
	{	String csvPath = workspacePath+"/Importing_files/Deregisteredemp.csv";
		CSVWriter csvWrite = new CSVWriter(new FileWriter(csvPath, false));
		String[] header = "Email Address,Employee Reference Number".split(",");
		String[] emailArray = new String[emails.size()];
		emailArray = emails.toArray(emailArray);
		csvWrite.writeNext(header);
		for(int i =0;i<emails.size();i++)	
			{csvWrite.writeNext(emails.get(i).split(","));
			}	
		csvWrite.flush();
		csvWrite.close();
	
		
	}
	public static void GenerateImportCsv(String email) throws IOException
	{	String csvPath = workspacePath+"/Importing_files/ImportEmployees.csv";
		System.out.println(email);
		CSVWriter csvWrite = new CSVWriter(new FileWriter(csvPath, false));
		String[] header = "Email Address,Employee Reference Number".split(",");
		String[] stringArray = email.split(" ");
		csvWrite.writeNext(header);
		csvWrite.writeNext(stringArray);
		csvWrite.flush();
		csvWrite.close();
	}
	
}
