package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.ResultSet; // interface ResultSet
import java.sql.SQLException; // class SQLException
import java.sql.Statement; // interface Statement

public class JDBCIntro {

    public static void main(String[] args) {

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")) {

            Statement stmnt = conn.createStatement();

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners";

            System.out.println("Now to iterate over the results... \n");

            ResultSet rs = stmnt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("first_name")
                        + "\t" + rs.getString("last_name")
                        + "\t" + rs.getDouble("hourly_rate")
                        + "\t" + rs.getBoolean("is_fulltime"));
                //Adam	Bell	18.5	true
                //Eric	Jones	22.75	false
                //Pam	Cruz	19.0	true
            }

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