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
}
