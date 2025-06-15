package com;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSX {

    public static void main(String[] args) {
        readXLSXFile("C:\\kenshu\\ECSITE\\社員データ (2).xlsx");
    }

    private static void readXLSXFile(String file) {
    	String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = ""; // Thay đổi nếu có mật khẩu

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis)
        ) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();

            String sql = "INSERT INTO employees (id, name, gender, department, hire_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 1; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                try {
                    // Dùng hàm helper để đọc cell an toàn
                    String id = getCellValueAsString(row.getCell(0));
                    String name = getCellValueAsString(row.getCell(1));
                    String gender = getCellValueAsString(row.getCell(2));
                    String department = getCellValueAsString(row.getCell(3));
                    String dateStr = getCellValueAsString(row.getCell(4));

                    java.sql.Date hireDate = java.sql.Date.valueOf(dateStr); // yyyy-MM-dd

                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setString(3, gender);
                    ps.setString(4, department);
                    ps.setDate(5, hireDate);
                    ps.executeUpdate();

                } catch (Exception e) {
                    System.out.println("Lỗi ở dòng " + (i + 1) + ": " + e.getMessage());
                }
            }

            System.out.println("Nhập dữ liệu thành công!");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc cell theo kiểu chuỗi an toàn
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new java.text.SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BLANK: return "";
            default: return "UNKNOWN";
        }
    }
}
