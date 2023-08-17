package com.loonycorn;

import java.sql.*;

public class DeliveryPartnerQueries {

    public ResultSet getAllDelPartners(Connection conn) {

        try {
            Statement stmnt = conn.createStatement();

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners";

            return stmnt.executeQuery(query);
        }
        catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet getDelPartnerById(Connection conn, int id) {

        try {

            String query = "select first_name, last_name, hourly_rate, is_fulltime " +
                    "from delpartners where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            return ps.executeQuery();
        }
        catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
    }

    public int addNewDelPartner(Connection conn, String fName, String lName,
                                double hourlyRate, boolean isFT) {

        int status = 0;

        try {
            String query = "insert into delpartners "
                    + "(first_name, last_name, hourly_rate, is_fulltime) "
                    + "values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setDouble(3, hourlyRate);
            ps.setBoolean(4, isFT);

            status = ps.executeUpdate();

        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return status;

    }
}
