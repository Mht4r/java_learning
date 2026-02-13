package com.expansetracker;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Dotenv dotenv = null;
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    private static boolean initialized = false;

    // Load environment variables
    static {
        try {
            dotenv = Dotenv.configure()
                    .directory(".")
                    .ignoreIfMissing()
                    .load();
            
            // Cache database credentials
            dbUrl = dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/expense_tracker");
            dbUser = dotenv.get("DB_USER", "root");
            dbPassword = dotenv.get("DB_PASSWORD", "");
            
            // Load MySQL JDBC driver once
            Class.forName("com.mysql.cj.jdbc.Driver");
            initialized = true;
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error loading .env file: " + e.getMessage());
        }
    }

    // Get a new database connection for each request
    public static Connection getConnection() throws SQLException {
        if (!initialized) {
            throw new SQLException("Database connection not initialized. Check JDBC driver and .env file.");
        }
        
        try {
            // Create a new connection for each request
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            // Only print success message on first connection
            if (!initialized) {
                System.out.println("Database connected successfully!");
            }
            
            return conn;
            
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            System.err.println("Please check your .env file and ensure MySQL is running.");
            throw e;
        }
    }

    // Test database connection (for initial setup)
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("Database connected successfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            System.err.println("Please check your .env file and ensure MySQL is running.");
            return false;
        }
    }
}
