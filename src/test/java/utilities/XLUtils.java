package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class XLUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;


    public static int getRowCount(String xlfile, String xlsheet) throws IOException, IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int rowcount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowcount;
    }


    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        int cellcount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }


    public static String getCellData(String file, String sheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(file);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheet);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String file, String sheet, int colnum, String data, String status) throws IOException {
        fi = new FileInputStream(file);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheet);
        int lastRow = ws.getLastRowNum();
        System.out.println("lastRow; " + lastRow);
        //row = ws.getRow(rownum);
        //ws.getRow(2).getCell(0).setCellValue(data);
        row = ws.createRow(++lastRow);
        cell = row.createCell(colnum);
        cell.setCellValue(data);

        cell = row.createCell(5);
        cell.setCellValue(status);

        fo = new FileOutputStream(file);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
