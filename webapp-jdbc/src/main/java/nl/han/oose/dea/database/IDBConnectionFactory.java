package nl.han.oose.dea.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by uwe on 12/05/17.
 */
public interface IDBConnectionFactory {
    Connection getConnection() throws SQLException;
}
