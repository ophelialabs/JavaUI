package com.company.app.core;

import javafx.application.Application;
import javafx.stage.Stage;
import com.company.app.ui.controller.MainFrameController;
import com.company.app.util.LoggerUtil;

/**
 * Main entry point for the application.
 * Initializes and launches the JavaFX application.
 */
public class Application extends javafx.application.Application {
    
    private static final String APP_TITLE = "Enterprise UI Application";
    private static final String APP_VERSION = "1.0.0";
    
    private MainFrameController mainFrameController;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            LoggerUtil.info("Starting application: " + APP_TITLE + " v" + APP_VERSION);
            
            // Initialize main frame
            mainFrameController = new MainFrameController();
            mainFrameController.initialize(primaryStage);
            
            // Configure primary stage
            primaryStage.setTitle(APP_TITLE);
            primaryStage.setWidth(1200);
            primaryStage.setHeight(800);
            primaryStage.setOnCloseRequest(event -> onApplicationExit());
            
            // Show stage
            primaryStage.show();
            
            LoggerUtil.info("Application started successfully");
        } catch (Exception e) {
            LoggerUtil.error("Failed to start application", e);
            System.exit(1);
        }
    }
    
    private void onApplicationExit() {
        LoggerUtil.info("Application shutting down");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
