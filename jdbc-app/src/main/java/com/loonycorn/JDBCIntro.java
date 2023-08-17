package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.DriverManager; // class DriverManager
import java.sql.SQLException; // class SQLException
public class JDBCIntro {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin123";
        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connection has been established");
                //Connection has been established
            }
        }
        catch (SQLException | ClassNotFoundException excp) {

            System.out.println("Connection error");
            excp.printStackTrace();
        }
    }
}