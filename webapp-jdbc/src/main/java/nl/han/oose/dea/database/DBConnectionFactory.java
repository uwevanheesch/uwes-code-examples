package nl.han.oose.dea.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    public static final String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String ITEM_DB_CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/itemdb";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mypassword";

    static {
        try {
            Class.forName(MYSQL_JDBC_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(ITEM_DB_CONNECTION_STRING, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
