package configuration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;


public class ReadExcelFile {

    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadExcelFile(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetnumber, int row, int column)
    {
        sheet = wb.getSheetAt(sheetnumber);
        Cell cell = sheet.getRow(row).getCell(column);
        cell.setCellType(CellType.STRING);
        String data = cell.getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex)
    {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

}
