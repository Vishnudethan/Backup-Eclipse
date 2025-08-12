package com.demo.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter empname : ");
            String name = sc.nextLine();
            System.out.println("Enter empaddress : ");
            String  address = sc.nextLine();
            DataBaseConnector obj1 = new DataBaseConnector();
            DataBaseConnector obj2 = new DataBaseConnector();
            System.out.println(obj1);
            System.out.println(obj2);
            

            String query = "insert into emp(empname,empaddress) values('" + name + "',  '"+address+"'  )";
            Connection con = DataBaseConnector.dbConnect(); 
            
            PreparedStatement ps = con.prepareStatement(query); 
          
            int rowCount = ps.executeUpdate(); 
            
            if (rowCount != 0) {
                
                System.out.println("Query OK");
                System.out.println(rowCount + " row(s) affected!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}