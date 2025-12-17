package com.company.app.theme;

import javafx.scene.Scene;
import com.company.app.util.LoggerUtil;

/**
 * Theme Manager - Unified styling and color management.
 * Handles application-wide theme configuration and switching.
 */
public class ThemeManager {
    
    private static final String LIGHT_THEME = "light";
    private static final String DARK_THEME = "dark";
    
    private String currentTheme = LIGHT_THEME;
    
    private static class SingletonHolder {
        static final ThemeManager instance = new ThemeManager();
    }
    
    public static ThemeManager getInstance() {
        return SingletonHolder.instance;
    }
    
    private ThemeManager() {
        LoggerUtil.debug("Initializing ThemeManager");
    }
    
    public void setTheme(String theme, Scene scene) {
        try {
            this.currentTheme = theme;
            
            String cssResource = null;
            if (LIGHT_THEME.equals(theme)) {
                cssResource = "/styles/light-theme.css";
            } else if (DARK_THEME.equals(theme)) {
                cssResource = "/styles/dark-theme.css";
            }
            
            if (cssResource != null && scene != null) {
                scene.getStylesheets().clear();
                String resource = getClass().getResource(cssResource).toExternalForm();
                scene.getStylesheets().add(resource);
                LoggerUtil.info("Theme switched to: " + theme);
            }
        } catch (Exception e) {
            LoggerUtil.error("Failed to set theme", e);
        }
    }
    
    public String getCurrentTheme() {
        return currentTheme;
    }
    
    public String[] getAvailableThemes() {
        return new String[]{LIGHT_THEME, DARK_THEME};
    }
}
