package database.connection;

import database.exception.DBConnectionException;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utils.DataPropLoader.getDBProperty;

@Log4j2
public class DBConnection {

    private DBConnection() {
    }

    private static DBConnection instance = null;

    public static DBConnection getInstance() {

        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws DBConnectionException {
        Connection connection;

        try {
            Class.forName(getDBProperty("jdbc.driver"));
            log.debug("Try connect to {} with user: {} and password: {} ...", getDBProperty("mysql.database"), getDBProperty("mysql.user"), getDBProperty("mysql.password"));

            connection = DriverManager.getConnection(getDBProperty("mysql.url"), getDBProperty("mysql.user"), getDBProperty("mysql.password"));
            log.debug("Connected to {} database successfully!", getDBProperty("mysql.database"));

        } catch (ClassNotFoundException | SQLException e) {
            log.error(String.format("Class %s not found!",getDBProperty("jdbc.driver")), e);
            throw new DBConnectionException("Can't connection to database.", e);
        }
        return connection;
    }
}
