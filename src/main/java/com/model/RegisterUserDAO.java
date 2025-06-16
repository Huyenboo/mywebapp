package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUserDAO {
    private final String url = "jdbc:mysql://localhost:3306/user_registration";
    private final String user = "root";
    private final String password = "";

    public boolean insertUser(User userObj) {
        String sql = "INSERT INTO users (user_id, name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userObj.getUserId());
            pstmt.setString(2, userObj.getName());
            pstmt.setString(3, userObj.getEmail());
            pstmt.setString(4, userObj.getPassword());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean checkLogin(String userId, String password) {
        String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Nếu có kết quả → đăng nhập đúng
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
