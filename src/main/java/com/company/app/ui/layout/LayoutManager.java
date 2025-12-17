package com.company.app.ui.layout;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import com.company.app.util.LoggerUtil;

/**
 * Layout Manager - Flexible component positioning.
 * Provides utility methods for creating consistent layouts.
 */
public class LayoutManager {
    
    public enum LayoutType {
        HORIZONTAL, VERTICAL, GRID, BORDER
    }
    
    /**
     * Create a horizontal layout with flexible spacing
     */
    public static HBox createHorizontalLayout(double spacing, Pos alignment) {
        HBox layout = new HBox();
        layout.setSpacing(spacing);
        layout.setAlignment(alignment);
        return layout;
    }
    
    /**
     * Create a vertical layout with flexible spacing
     */
    public static VBox createVerticalLayout(double spacing, Pos alignment) {
        VBox layout = new VBox();
        layout.setSpacing(spacing);
        layout.setAlignment(alignment);
        return layout;
    }
    
    /**
     * Create a grid layout
     */
    public static GridPane createGridLayout(int rows, int cols, double hgap, double vgap) {
        GridPane grid = new GridPane();
        grid.setHgap(hgap);
        grid.setVgap(vgap);
        LoggerUtil.debug("Created grid layout: " + rows + "x" + cols);
        return grid;
    }
    
    /**
     * Set grow priority for a node in HBox
     */
    public static void setHGrow(javafx.scene.Node node, Priority priority) {
        HBox.setHgrow(node, priority);
    }
    
    /**
     * Set grow priority for a node in VBox
     */
    public static void setVGrow(javafx.scene.Node node, Priority priority) {
        VBox.setVgrow(node, priority);
    }
}
