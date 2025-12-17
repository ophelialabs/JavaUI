package com.company.app.ui.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MainFrame component tests
 */
public class MainFrameTest {
    
    private MainFrame mainFrame;
    
    @BeforeEach
    public void setUp() {
        mainFrame = new MainFrame();
    }
    
    @Test
    public void testMainFrameInitialization() {
        assertNotNull(mainFrame);
    }
    
    @Test
    public void testContentAreaNotNull() {
        assertNotNull(mainFrame.getContentArea());
    }
    
    @Test
    public void testNavigationBarNotNull() {
        assertNotNull(mainFrame.getNavigationBar());
    }
    
    @Test
    public void testSidebarNotNull() {
        assertNotNull(mainFrame.getSidebar());
    }
    
    @Test
    public void testStatusBarNotNull() {
        assertNotNull(mainFrame.getStatusBar());
    }
}
