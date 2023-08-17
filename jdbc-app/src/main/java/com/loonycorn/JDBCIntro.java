package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.SQLException; // class SQLException
import java.sql.Statement; // interface Statement

public class JDBCIntro {

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")) {

            Statement stmnt = conn.createStatement();

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners";

            stmnt.executeQuery(query);

            System.out.println("Query has been executed successfully");
            //Query has been executed successfully
        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

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