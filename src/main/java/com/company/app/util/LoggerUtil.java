package com.company.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger Utility - Centralized logging configuration.
 * Provides consistent logging across the application.
 */
public class LoggerUtil {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public enum LogLevel {
        DEBUG, INFO, WARN, ERROR
    }
    
    public static void debug(String message) {
        log(LogLevel.DEBUG, message, null);
    }
    
    public static void info(String message) {
        log(LogLevel.INFO, message, null);
    }
    
    public static void warn(String message) {
        log(LogLevel.WARN, message, null);
    }
    
    public static void error(String message, Throwable throwable) {
        log(LogLevel.ERROR, message, throwable);
    }
    
    private static void log(LogLevel level, String message, Throwable throwable) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("[%s] [%s] %s", timestamp, level.name(), message);
        
        System.out.println(logMessage);
        
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }
}
