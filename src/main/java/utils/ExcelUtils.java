package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    // Load Excel file
    public ExcelUtils(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get cell data
    public String getCellData(int row, int col) {
        Row r = sheet.getRow(row);
        Cell cell = r.getCell(col);
        return cell != null ? cell.toString() : "";
    }

    // Get total rows
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Close workbook
    public void close() throws IOException {
        workbook.close();
    }
}
