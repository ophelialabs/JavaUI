package com.company.app.integration;

import java.sql.Connection;
import com.company.app.util.LoggerUtil;

/**
 * Database Client - Database container integration.
 * Manages database connection and operations.
 */
public class DatabaseClient extends ContainerServiceClient {
    
    private Connection connection;
    private String username;
    private String password;
    
    public DatabaseClient(String serviceName, String serviceUrl, int servicePort, String username, String password) {
        super(serviceName, serviceUrl, servicePort);
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void connect() throws Exception {
        LoggerUtil.info("Connecting to database service: " + serviceName + " at " + serviceUrl + ":" + servicePort);
        // Implementation for database connection
    }
    
    @Override
    public void disconnect() throws Exception {
        LoggerUtil.info("Disconnecting from database service: " + serviceName);
        if (connection != null) {
            connection.close();
        }
    }
    
    @Override
    public boolean isServiceAvailable() {
        try {
            LoggerUtil.debug("Checking database availability for: " + serviceName);
            return connection != null && !connection.isClosed();
        } catch (Exception e) {
            LoggerUtil.error("Database availability check failed", e);
            return false;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
