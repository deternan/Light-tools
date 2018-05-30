package File;

/*
 * JAR
 * poi-3.17.jar
 * poi-ooxml-3.17.jar
 * poi-ooxml-schemas-3.17.jar
 * xmlbeans.jar
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel 
{

	public Read_Excel() throws IOException
	{
		//String excelFilePath = "C:\\Users\\Barry\\Desktop\\value_20180530.xls";
        //FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		String excelFilePath =  "C:\\Users\\Barry\\Desktop\\value_20180530.xls";	 
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));		 
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
 		
        //Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
         
        workbook.close();
        inputStream.close();
		
	}
	
	private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException 
	{
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
	
	public static void main(String[] args) 
	{
		try {
			Read_Excel RE = new Read_Excel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
