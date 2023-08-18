package com.loonycorn;

import java.sql.Connection; // interface Connection
import java.sql.ResultSet; // interface ResultSet
import java.sql.SQLException; // class SQLException

public class JDBCIntro {

    public static void main(String[] args) {

        DeliveryPartnerQueries dpq = new DeliveryPartnerQueries();

        try (Connection conn = DBUtils.getMysqlConnection("DeliveryService")) {



            System.out.println("###############");
            System.out.println("Deleting the user with ID 101...\n");

            int status = dpq.deleteDeliveryPartner(conn, 101);

            System.out.println("Status returned: " + status);
            //Status returned: 1

            System.out.println("\n##############");
            System.out.println("Retrieving all Delivery Partner details...\n");

            ResultSet rs = dpq.getAllDelPartners(conn);

            while (rs.next()) {
                System.out.println(rs.getString("first_name")
                        + "\t" + rs.getString("last_name")
                        + "\t" + rs.getDouble("hourly_rate")
                        + "\t" + rs.getBoolean("is_fulltime"));
                //Eric	Jones	22.75	false
                //Pam	Cruz	21.0	true
                //Gav	Comey	19.0	true
            }

//            System.out.println("#############");
//            System.out.println("Updating hourly rates for FT partners...\n");
//
//            int status = dpq.applyPayAdjustment(conn, 2, true);
//
//            System.out.println("Status returned: " + status);
//            //Status returned: 3
//
//            System.out.println("\n#############");
//            System.out.println("Retrieving all Delivery Partner details...\n");
//
//            ResultSet rs = dpq.getAllDelPartners(conn);

//            while (rs.next()) {
//                System.out.println(rs.getString("first_name")
//                        + "\t" + rs.getString("last_name")
//                        + "\t" + rs.getDouble("hourly_rate")
//                        + "\t" + rs.getBoolean("is_fulltime"));
//                //Adam	Bell	20.5	true
//                //Eric	Jones	22.75	false
//                //Pam	Cruz	21.0	true
//                //Gav	Comey	19.0	true
//            }

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