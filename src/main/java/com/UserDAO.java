

package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO extends DBAccess {
    public ArrayList<company> companyList() {
        ArrayList<company> list = new ArrayList<>();

        String sql = "SELECT * FROM companies";

        try {
            connect();
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                company c = new company();
                c.setCompanyName(rs.getString("company_name"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                c.setContactPerson(rs.getString("contact_person"));
                c.setContactMobile(rs.getString("contact_mobile"));
                list.add(c);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return list.isEmpty() ? null : list;
    }
}

