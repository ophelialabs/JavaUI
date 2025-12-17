package com.company.app.ui.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.company.app.ui.components.MainFrame;
import com.company.app.theme.ThemeManager;
import com.company.app.util.LoggerUtil;

/**
 * Main Frame Controller - Manages the primary application window.
 * Handles initialization and event delegation for the main frame.
 */
public class MainFrameController {
    
    private MainFrame mainFrame;
    private Stage primaryStage;
    private Scene scene;
    
    public MainFrameController() {
        LoggerUtil.debug("Initializing MainFrameController");
    }
    
    public void initialize(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Create main frame component
        mainFrame = new MainFrame();
        
        // Create scene
        scene = new Scene(mainFrame, 1200, 800);
        
        // Apply theme
        ThemeManager.getInstance().setTheme("light", scene);
        
        // Set scene on stage
        primaryStage.setScene(scene);
        
        // Setup event handlers
        setupEventHandlers();
        
        LoggerUtil.info("MainFrameController initialized successfully");
    }
    
    private void setupEventHandlers() {
        // Navigation bar button handlers
        mainFrame.getNavigationBar().getHomeButton().setOnAction(e -> handleHomeAction());
        mainFrame.getNavigationBar().getDashboardButton().setOnAction(e -> handleDashboardAction());
        mainFrame.getNavigationBar().getSettingsButton().setOnAction(e -> handleSettingsAction());
    }
    
    private void handleHomeAction() {
        LoggerUtil.debug("Home button clicked");
        mainFrame.getStatusBar().setStatus("Navigating to Home");
    }
    
    private void handleDashboardAction() {
        LoggerUtil.debug("Dashboard button clicked");
        mainFrame.getStatusBar().setStatus("Navigating to Dashboard");
    }
    
    private void handleSettingsAction() {
        LoggerUtil.debug("Settings button clicked");
        mainFrame.getStatusBar().setStatus("Navigating to Settings");
    }
    
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
