package com.company.app.util;

import java.io.InputStream;
import java.util.Properties;
import com.company.app.util.LoggerUtil;

/**
 * Configuration Manager - Centralized application configuration.
 * Loads and manages application properties.
 */
public class ConfigurationManager {
    
    private static final String CONFIG_FILE = "application.properties";
    private Properties properties;
    
    private static class SingletonHolder {
        static final ConfigurationManager instance = new ConfigurationManager();
    }
    
    public static ConfigurationManager getInstance() {
        return SingletonHolder.instance;
    }
    
    private ConfigurationManager() {
        loadConfiguration();
    }
    
    private void loadConfiguration() {
        properties = new Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);
            if (input != null) {
                properties.load(input);
                LoggerUtil.info("Configuration loaded from " + CONFIG_FILE);
            } else {
                LoggerUtil.warn("Configuration file not found: " + CONFIG_FILE);
            }
        } catch (Exception e) {
            LoggerUtil.error("Failed to load configuration", e);
        }
    }
    
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                LoggerUtil.warn("Invalid integer value for key: " + key);
            }
        }
        return defaultValue;
    }
}
