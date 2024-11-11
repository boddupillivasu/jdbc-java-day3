package com.preparedstatements.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExampleOnPreparedStatements {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter item id:");
        int id = scanner.nextInt();


        System.out.println("enter item price:");
        float price = scanner.nextFloat();

        System.out.println("enter item name:");
        String name = scanner.next();//taking the string input only used sc.next

//        System.out.println("enter item price:");
//        float price = scanner.nextFloat();


        //reg driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        //define connection

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "786786";

        //establish connection

        Connection connection = DriverManager.getConnection(url, username, password);

        //create prepared statement object for connection

        String location = "insert into item values (?,?,?)";

        //  PreparedStatement pstmt=connection.prepareStatement(location);

        //here prepare statements are interface
        PreparedStatement preparedStatement = connection.prepareStatement(location);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setFloat(3, price);

        int res = preparedStatement.executeUpdate();

        if (res > 0) {
            System.out.println("all the quires are updated:" + res);
        } else
            System.out.println("not updated");

        preparedStatement.close();
        connection.close();
        scanner.close();


    }
}
