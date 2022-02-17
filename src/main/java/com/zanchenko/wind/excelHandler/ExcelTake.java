package com.zanchenko.wind.excelHandler;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelTake {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    public ExcelTake(String excelPath, String sheeName) throws IOException {
        try{
            //InputStream file = new FileInputStream(excelPath);
            //workbook = new XSSFWorkbook(file);
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheeName);
        }
        catch (Exception e){
            System.out.println("error: " + e.getMessage());
            System.out.println("cause: " + e.getCause());
            e.printStackTrace();
        }

    }
//    public static void main(String[] args) throws IOException {
//        String excelPath = "C:\\Users\\lesha\\Desktop\\2012-12.xlsx";
//        String sheetName = "2012-12";
//        ExcelTake excel = new ExcelTake(excelPath, sheetName);
//
//        excel.getRowcCount();
//        excel.getCellData(1,1);
//    }

    //    public static void getCellData(int rowNum, int colNum) throws IOException {
//        DataFormatter formatter = new DataFormatter();
//        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
//        System.out.println(value);
//    }
    public static String getCellData(int rowNum, int colNum) throws IOException {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
//    System.out.println(value);
        return (String) value;
    }
    public static int getRowcCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows: " + rowCount);
        return rowCount;
    }
}
