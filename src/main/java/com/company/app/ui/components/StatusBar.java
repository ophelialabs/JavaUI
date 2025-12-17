package com.company.app.ui.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import com.company.app.util.LoggerUtil;

/**
 * Status Bar component - Bottom status information display.
 * Shows application status, connection status, and user information.
 */
public class StatusBar extends HBox {
    
    private Label statusLabel;
    private Label connectionLabel;
    private Label timeLabel;
    
    public StatusBar() {
        initialize();
    }
    
    private void initialize() {
        LoggerUtil.debug("Initializing StatusBar");
        
        this.setStyle("-fx-background-color: #34495e; -fx-padding: 8px 15px;");
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefHeight(35);
        
        // Status label
        statusLabel = new Label("Ready");
        statusLabel.setStyle("-fx-text-fill: white; -fx-font-size: 11px;");
        
        // Connection label
        connectionLabel = new Label("● Connected");
        connectionLabel.setStyle("-fx-text-fill: #2ecc71; -fx-font-size: 11px;");
        
        // Time label (right-aligned)
        timeLabel = new Label("Last updated: --:--:--");
        timeLabel.setStyle("-fx-text-fill: #bdc3c7; -fx-font-size: 11px;");
        
        // Spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        this.getChildren().addAll(
            statusLabel,
            connectionLabel,
            spacer,
            timeLabel
        );
        
        LoggerUtil.debug("StatusBar initialized successfully");
    }
    
    public void setStatus(String status) {
        statusLabel.setText(status);
    }
    
    public void setConnectionStatus(String status, boolean connected) {
        String color = connected ? "#2ecc71" : "#e74c3c";
        String indicator = connected ? "●" : "○";
        connectionLabel.setText(indicator + " " + status);
        connectionLabel.setStyle("-fx-text-fill: " + color + "; -fx-font-size: 11px;");
    }
    
    public void setLastUpdated(String time) {
        timeLabel.setText("Last updated: " + time);
    }
}
