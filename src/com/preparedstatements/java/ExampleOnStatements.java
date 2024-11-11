package com.preparedstatements.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExampleOnStatements {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //take input
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter customer id:");
        int id = scanner.nextInt();

        System.out.println("enter customer name:");
        String name = scanner.next();

        System.out.println("enter customer sal:");
        double sal = scanner.nextDouble();

        //reg driver class

        Class.forName("com.mysql.cj.jdbc.Driver");

        //define connection
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "786786";

        //establish connection

        Connection connection = DriverManager.getConnection(url, user, password);

        //create statement object for con

        Statement statement = connection.createStatement();

        String data = "insert into customer values(" + id + ",'" + name + "'," + sal + ")";

        int res = statement.executeUpdate(data);

        if (res > 0)
            System.out.println("quires are updated" + res);
        else
            System.out.println("not updated");

        statement.close();
        connection.close();

//        scanner.close();
//        public static void main(String[] args) {
//
//            try {
//
//                Scanner sc = new Scanner(System.in);
//
//                System.out.println("Enter the customer Id :");
//                int eid=sc.nextInt();
//
//                System.out.println("Enter the customer Name :");
//                String en=sc.next();
//
//                System.out.println("Enter the customer Salary :");
//                float esal=sc.nextFloat();
//
//
//                //load or register the driver
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                //define the connection url for mysql database;
//                String url="jdbc:mysql://localhost:3306/jdbc";
//                String userName="root";
//                String password="786786";
//
//                //establish the connection between the java class and database
//                Connection con =DriverManager.getConnection(url,userName,password);
//
//                //creating statment object using con
//                Statement stmtObj=con.createStatement();
//
//                //Execute the Queries
//                String query="insert into customer values("+eid+",'"+en+"',"+esal+")";
//
//                int iobj=stmtObj.executeUpdate(query);
//
//                if(iobj>0) {
//                    System.out.println("Record is inserted Successfully");
//                }else {
//                    System.out.println("Record is Not Inserted ");
//                }
//
//                //close the objects
//                stmtObj.close();
//                con.close();
//
//
//            } catch (ClassNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//


        }
}
