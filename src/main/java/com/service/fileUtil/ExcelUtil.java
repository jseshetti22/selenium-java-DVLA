package com.service.fileUtil;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell cell;


    public void setExcelFile(String path, String sheetName) {
        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String SAMPLE_XLSX_FILE_PATH,String sheetName) {
        setExcelFile(SAMPLE_XLSX_FILE_PATH,"Sheet1");
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        return ExcelWSheet.getPhysicalNumberOfRows();
    }

    public String getCellData(String SAMPLE_XLSX_FILE_PATH,int rowNum, int colNum) {
        try {
            setExcelFile(SAMPLE_XLSX_FILE_PATH,"Sheet1");
            cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
            String cellValue = cell.getStringCellValue();
            return cellValue;
        } catch (Exception e) {
            return "";
        }
    }

}



