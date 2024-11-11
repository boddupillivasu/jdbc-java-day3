package com.preparedstatements.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatements {

    public static void main(String[] args) {

        try {
            // register the driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            //define connection

            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "786786";

            //establish the connection

            Connection connection = DriverManager.getConnection(url, username, password);

            //creating PreparedStatement Object using con
            String insert = "insert into student values (?,?,?)";


            PreparedStatement pstmt = connection.prepareStatement(insert);

            pstmt.setInt(1, 13);
            pstmt.setString(2, "vasunaidu");
            pstmt.setString(3, "vasuboddupilli@13");

            pstmt.setInt(1, 20);
            pstmt.setString(2, "venkatakalyan");
            pstmt.setString(3, "kalyan@123");

            pstmt.setInt(1, 22);
            pstmt.setString(2, "chandubahrath");
            pstmt.setString(3, "bharath@22");

            pstmt.setInt(1, 34);
            pstmt.setString(2, "manohar");
            pstmt.setString(3, "manohar@123");


            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("the queries are updated" + result);
            } else {
                System.out.println("quires are not updated");
            }

            pstmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

