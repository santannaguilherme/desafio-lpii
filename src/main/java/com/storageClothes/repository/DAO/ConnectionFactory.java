package com.storageClothes.repository.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;database=AulaLPII;user=sa;password=123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
