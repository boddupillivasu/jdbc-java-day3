package com.preparedstatements.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExampleOnStatementUsingTab {
    public static void main(String[] args) {

        //user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter table id:");
        int id = scanner.nextInt();

        System.out.println("enter table name:");
        String name  = scanner.next();

        System.out.println("enter table price:");
        double pr = scanner.nextDouble();

        //reg driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //define connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String password = "786786";
            //establish connection

            Connection con = DriverManager.getConnection(url,user,password);

            //statement
            Statement statement = con.createStatement();
            String data ="insert into tab values("+id+",'"+name+"',"+pr+")";

            int res = statement.executeUpdate(data);
            if (res>0){
                System.out.println("records initialized successfully");

            }else {
                System.out.println("not initilized");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
