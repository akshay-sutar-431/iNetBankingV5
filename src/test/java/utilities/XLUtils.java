package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IDynamicGraph;

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
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String file, String sheet, int colnum, String id, String status) throws IOException {
        fi = new FileInputStream(file);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheet);
        int lastRow = ws.getLastRowNum();
        System.out.println("lastRow; " + lastRow);
        //ws.getRow(2).getCell(0).setCellValue(data);

        if (status.contains("updated")) {
            for (int i = 1; i < lastRow; i++) {
                String cid = XLUtils.getCellData(file, "sheet1", i, 0);
                if (cid.contains(id)) {
                    //XLUtils.setCellData(file, "Sheet1", 0, id, Status);
                    System.out.println("XUTILS: Id Mathced");
                    //row = ws.getRow(i);
                /*    cell = ws.getRow(i).getCell(5);
                    cell.setCellValue(status);
                    System.out.println("XUTILS: Data written"); */

                    //Retrieve the row and check for null
                    XSSFRow sheetrow = ws.getRow(i);
                    if (sheetrow == null) {
                        sheetrow = ws.createRow(i);
                    }
                    //Update the value of cell
                    cell = sheetrow.getCell(colnum);
                    if (cell == null) {
                        cell = sheetrow.createCell(colnum);
                    }
                    cell.setCellValue(status);
                }
            }
        } else if (status.contains("added")) {

            row = ws.createRow(++lastRow);
            cell = row.createCell(colnum);
            cell.setCellValue(id);

            cell = row.createCell(5);
            cell.setCellValue(status);
        } else {
            for (int i = 1; i < lastRow; i++) {
                String cid = XLUtils.getCellData(file, "sheet1", i, 0);
                if (cid.contains(id)) {
                    //XLUtils.setCellData(file, "Sheet1", 0, id, Status);
                    System.out.println("XUTILS: Id Mathced");
                    
                    //Retrieve the row and check for null
                    XSSFRow sheetrow = ws.getRow(i);
                    if (sheetrow == null) {
                        sheetrow = ws.createRow(i);
                    }
                    //Update the value of cell
                    cell = sheetrow.getCell(colnum);
                    if (cell == null) {
                        cell = sheetrow.createCell(colnum);
                    }
                    cell.setCellValue(status);
                }
            }
        }

        fo = new FileOutputStream(file);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
