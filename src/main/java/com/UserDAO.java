package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO extends DBAccess{
	public ArrayList<Employee> userList() {
		ArrayList<Employee> list = new ArrayList<>();
		
		String sql = "SELECT * FROM employees";
		
		try {
            connect();
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
            	Employee emp = new Employee();
            	emp.setId(rs.getString("id"));
                emp.setName(rs.getString("name"));
                emp.setGender(rs.getString("gender"));
                emp.setDepartment(rs.getString("department"));
                emp.setHireDate(rs.getString("hire_date"));
                list.add(emp);
            }
 
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
		
		// 値が取得できなかった場合はnullを返却します。
		if (list.isEmpty()) {
	        return null;
	    }
 
        return list;
	} 
}
