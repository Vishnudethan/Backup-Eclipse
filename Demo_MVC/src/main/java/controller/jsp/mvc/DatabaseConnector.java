package controller.jsp.mvc;

import java.sql.Connection;

import java.sql.DriverManager;

public class DatabaseConnector {
    public static Connection dbConnect() {
        try {
           // DataBaseConnector obj1 = new DataBaseConnector();
          //  DataBaseConnector obj2 = new DataBaseConnector();
          
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3360/db1"; 
            String uname = "root";
            String pass = "root";
            
            Connection con = DriverManager.getConnection(url, uname, pass); 
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
