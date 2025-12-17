package com.company.app.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ConfigurationManager tests
 */
public class ConfigurationManagerTest {
    
    @Test
    public void testSingletonInstance() {
        ConfigurationManager manager1 = ConfigurationManager.getInstance();
        ConfigurationManager manager2 = ConfigurationManager.getInstance();
        assertSame(manager1, manager2);
    }
    
    @Test
    public void testGetProperty() {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        String appName = manager.getProperty("app.name", "default");
        assertNotNull(appName);
    }
    
    @Test
    public void testGetIntProperty() {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        int port = manager.getIntProperty("service.api.port", 8080);
        assertTrue(port > 0);
    }
}
