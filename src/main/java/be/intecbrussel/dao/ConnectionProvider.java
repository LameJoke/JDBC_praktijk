package be.intecbrussel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private Connection connection;

    private static final ConnectionProvider instance = new ConnectionProvider();

    public static ConnectionProvider getInstance() {
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/JDBCPraktijk_db?serverTimezone=UTC",
                                "root", "mysql");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return connection;
    }
}