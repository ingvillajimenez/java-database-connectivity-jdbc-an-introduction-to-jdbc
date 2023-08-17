package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.SQLException; // class SQLException
//import com.mysql.cj.jdbc.MysqlDataSource; // class MysqlDataSource
public class JDBCIntro {

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection(" ")) {

            if (conn != null) {
                System.out.println("Connection has been established");
                //Connection has been established
            }
            else {
                System.out.println("Connection error");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

//        MysqlDataSource mysqlDS = null;
//
//        try {
//            mysqlDS = new MysqlDataSource();
//
//            mysqlDS.setURL("jdbc:mysql://localhost:3306");
//            mysqlDS.setUser("root");
//            mysqlDS.setPassword("admin123");
//
//            Connection conn = mysqlDS.getConnection();
//
//            if (conn != null) {
//                System.out.println("Connection has been established");
//                //Connection has been established
//            }
//            else {
//                System.out.println("Connection error");
//            }
//        }
//        catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    }
}

//MySQL Installation notes
//https://dev.mysql.com/doc/refman/8.0/en/installing.html

//Starting up MySQL Server (Linux / MacOS)
//https://dev.mysql.com/doc/refman/8.0/en/starting-server.html

//Starting up MySQL Server (Windows)
//https://dev.mysql.com/doc/refman/8.0/en/windows-server-first-start.html

//MySQL Java Connector
//https://dev.mysql.com/downloads/connector/j/

// DataSource documentation
// https://docs.oracle.com/en/java/javase/15/docs/api/java.sql/javax/sql/DataSource.html