package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/luyentap";
    private static final String USER = "root";
    private static final String PASSWORD = "123456@";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement cstmt) {
        if (cstmt != null) {
            try{
                cstmt.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try{
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
