package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.ResultSet; // interface ResultSet
import java.sql.SQLException; // class SQLException

public class JDBCIntro {

    public static void main(String[] args) {

        DeliveryPartnerQueries dpq = new DeliveryPartnerQueries();

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")) {

            System.out.println("\n##############\n");
            System.out.println("Retrieving all Delivery Partner details... \n");

            ResultSet rs = dpq.getAllDelPartners(conn);

            while (rs.next()) {
                System.out.println(rs.getString("first_name")
                        + "\t" + rs.getString("last_name")
                        + "\t" + rs.getDouble("hourly_rate")
                        + "\t" + rs.getBoolean("is_fulltime"));
            }

            System.out.println("\n#############\n");
            System.out.println("Retrieving the details of one partner...\n");

            rs = dpq.getDelPartnerById(conn, 102);

            rs.next();

            System.out.println(rs.getString("first_name")
                    + "\t" + rs.getString("last_name")
                    + "\t" + rs.getDouble("hourly_rate")
                    + "\t" + rs.getBoolean("is_fulltime"));

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