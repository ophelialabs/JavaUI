package com.company.app.ui.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import com.company.app.util.LoggerUtil;

/**
 * Sidebar component - Secondary navigation and context menu.
 * Provides hierarchical navigation and contextual options.
 */
public class Sidebar extends VBox {
    
    private VBox navigationItems;
    private ScrollPane scrollPane;
    
    public Sidebar() {
        initialize();
    }
    
    private void initialize() {
        LoggerUtil.debug("Initializing Sidebar");
        
        this.setStyle("-fx-background-color: #ecf0f1; -fx-border-right: 1px solid #bdc3c7;");
        this.setPrefWidth(250);
        this.setFillWidth(true);
        
        // Navigation items container
        navigationItems = new VBox();
        navigationItems.setSpacing(5);
        navigationItems.setPadding(new Insets(15));
        navigationItems.setStyle("-fx-background-color: #ecf0f1;");
        
        // Add menu items
        navigationItems.getChildren().addAll(
            createMenuItem("Dashboard", "View application overview"),
            createMenuItem("Users", "Manage user accounts"),
            createMenuItem("Reports", "Generate and view reports"),
            createMenuItem("Settings", "Application configuration"),
            createMenuItem("Help", "Documentation and support")
        );
        
        // Scroll pane
        scrollPane = new ScrollPane(navigationItems);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-control-inner-background: #ecf0f1;");
        
        this.getChildren().add(scrollPane);
        VBox.setVgrow(scrollPane, javafx.scene.layout.Priority.ALWAYS);
        
        LoggerUtil.debug("Sidebar initialized successfully");
    }
    
    private Button createMenuItem(String title, String description) {
        VBox itemBox = new VBox();
        itemBox.setSpacing(3);
        itemBox.setPadding(new Insets(8));
        itemBox.setStyle("-fx-background-color: white; -fx-border-radius: 4; -fx-padding: 8;");
        
        Button titleButton = new Button(title);
        titleButton.setWrapText(true);
        titleButton.setMaxWidth(Double.MAX_VALUE);
        titleButton.setStyle("-fx-font-weight: bold; -fx-text-alignment: left; -fx-padding: 8px; -fx-background-color: transparent;");
        
        Button descButton = new Button(description);
        descButton.setWrapText(true);
        descButton.setMaxWidth(Double.MAX_VALUE);
        descButton.setStyle("-fx-font-size: 10px; -fx-text-fill: #7f8c8d; -fx-padding: 0; -fx-background-color: transparent;");
        
        itemBox.getChildren().addAll(titleButton, descButton);
        return (Button) itemBox.getChildren().get(0);
    }
}
