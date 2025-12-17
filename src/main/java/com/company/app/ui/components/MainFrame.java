package com.company.app.ui.components;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import com.company.app.util.LoggerUtil;

/**
 * Main Frame component - Primary application window container.
 * Provides the root layout structure for the application.
 */
public class MainFrame extends BorderPane {
    
    private NavigationBar navigationBar;
    private Sidebar sidebar;
    private VBox contentArea;
    private StatusBar statusBar;
    
    public MainFrame() {
        initialize();
    }
    
    private void initialize() {
        LoggerUtil.debug("Initializing MainFrame");
        
        // Create components
        navigationBar = new NavigationBar();
        sidebar = new Sidebar();
        statusBar = new StatusBar();
        
        // Initialize content area
        contentArea = new VBox();
        contentArea.setStyle("-fx-background-color: #f5f5f5;");
        contentArea.setPrefHeight(Double.MAX_VALUE);
        
        // Create center layout (sidebar + content)
        HBox centerLayout = new HBox();
        centerLayout.setSpacing(0);
        centerLayout.getChildren().addAll(sidebar, contentArea);
        HBox.setHgrow(contentArea, javafx.scene.layout.Priority.ALWAYS);
        
        // Set layout structure
        this.setTop(navigationBar);
        this.setCenter(centerLayout);
        this.setBottom(statusBar);
        
        LoggerUtil.debug("MainFrame initialized successfully");
    }
    
    public VBox getContentArea() {
        return contentArea;
    }
    
    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
    
    public Sidebar getSidebar() {
        return sidebar;
    }
    
    public StatusBar getStatusBar() {
        return statusBar;
    }
}
