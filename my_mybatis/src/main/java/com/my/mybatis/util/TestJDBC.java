package com.my.mybatis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {
    public static void main(String[] a) throws Exception {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/samp_db";
        String username = "root";
        String password = "";
        Class.forName(driver); //classLoader,加载对应驱动
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "");
        pstmt.setString(2, "");
        pstmt.setString(3, "");
        int o = pstmt.executeUpdate();
        pstmt.close();
        conn.close();


        //
        String sql1 = "select * from students";
        PreparedStatement pstmt1;
        pstmt1 = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        System.out.println("============================");
        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
                if ((i == 2) && (rs.getString(i).length() < 8)) {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
        System.out.println("============================");

    }
}
