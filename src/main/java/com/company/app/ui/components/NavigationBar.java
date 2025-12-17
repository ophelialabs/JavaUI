package com.company.app.ui.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import com.company.app.util.LoggerUtil;

/**
 * Navigation Bar component - Top-level navigation and controls.
 * Provides primary navigation menu and application-level actions.
 */
public class NavigationBar extends HBox {
    
    private Button homeButton;
    private Button dashboardButton;
    private Button settingsButton;
    private Label appTitleLabel;
    private HBox actionButtons;
    
    public NavigationBar() {
        initialize();
    }
    
    private void initialize() {
        LoggerUtil.debug("Initializing NavigationBar");
        
        this.setStyle("-fx-background-color: #2c3e50; -fx-padding: 10px;");
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefHeight(60);
        
        // App title
        appTitleLabel = new Label("Enterprise Application");
        appTitleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        // Navigation buttons
        homeButton = createNavButton("Home");
        dashboardButton = createNavButton("Dashboard");
        settingsButton = createNavButton("Settings");
        
        // Action buttons container
        actionButtons = new HBox();
        actionButtons.setSpacing(10);
        actionButtons.setPadding(new Insets(0, 10, 0, 0));
        actionButtons.setAlignment(Pos.CENTER_RIGHT);
        
        // Add help and user menu buttons
        Button helpButton = createNavButton("Help");
        Button userButton = createNavButton("User");
        actionButtons.getChildren().addAll(helpButton, userButton);
        
        // Layout
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        this.getChildren().addAll(
            appTitleLabel,
            homeButton,
            dashboardButton,
            settingsButton,
            spacer,
            actionButtons
        );
        
        LoggerUtil.debug("NavigationBar initialized successfully");
    }
    
    private Button createNavButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-padding: 8px 15px; -fx-font-size: 12px; -fx-background-color: #34495e; -fx-text-fill: white;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-padding: 8px 15px; -fx-font-size: 12px; -fx-background-color: #3a5068; -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-padding: 8px 15px; -fx-font-size: 12px; -fx-background-color: #34495e; -fx-text-fill: white;"));
        return button;
    }
    
    public Button getHomeButton() {
        return homeButton;
    }
    
    public Button getDashboardButton() {
        return dashboardButton;
    }
    
    public Button getSettingsButton() {
        return settingsButton;
    }
}
