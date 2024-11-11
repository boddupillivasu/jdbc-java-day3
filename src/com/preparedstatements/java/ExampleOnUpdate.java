package com.preparedstatements.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExampleOnUpdate {
    public static void main(String[] args) {


        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("enter the itemid to update");
            int dno = sc.nextInt();

            System.out.println("enter the new itemname ");
            String dna = sc.next();

            System.out.println("enter the new itemprice");
            String dl = sc.next();

            //load or register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //define the connection url for mysql database;
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String userName = "root";
            String password = "786786";

            //establish the connection between the java class and database
            Connection con = DriverManager.getConnection(url, userName, password);

            //creating PreparedStatement Object using con
            String query = "update item set itemname=?,itemprice=? where itemid=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, dna);
            pstmt.setString(2, dl);
            pstmt.setInt(3, dno);


            int iobj = pstmt.executeUpdate();

            if (iobj > 0) {
                System.out.println("Record is updated : " + iobj);
            } else {
                System.out.println("Record is not updated ");
            }

            pstmt.close();
            con.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}