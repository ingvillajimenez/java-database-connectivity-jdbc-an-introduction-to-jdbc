package com.loonycorn;

import com.mysql.cj.jdbc.MysqlDataSource; // class MysqlDataSource

import java.sql.Connection; // interface Connection
import java.sql.SQLException; // class SQLException

public class DBUtils {

    private static final String dbURL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "admin123";

    public static Connection getMysqlConnection(String schemaName) {

        MysqlDataSource mysqlDS = null;
        Connection conn = null;

        try {
            mysqlDS = new MysqlDataSource();

            mysqlDS.setURL(dbURL + schemaName);
            mysqlDS.setUser(username);
            mysqlDS.setPassword(password);

            conn = mysqlDS.getConnection();
        }
        catch (SQLException ex) {

            ex.printStackTrace();
        }

        return conn;
    }
}
