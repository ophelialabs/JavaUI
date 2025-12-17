package com.company.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.company.app.integration.ContainerServiceClient;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ContainerServiceManager tests
 */
public class ContainerServiceManagerTest {
    
    private ContainerServiceManager manager;
    
    @BeforeEach
    public void setUp() {
        manager = ContainerServiceManager.getInstance();
    }
    
    @Test
    public void testSingletonInstance() {
        ContainerServiceManager manager1 = ContainerServiceManager.getInstance();
        ContainerServiceManager manager2 = ContainerServiceManager.getInstance();
        assertSame(manager1, manager2);
    }
    
    @Test
    public void testRegisterService() {
        MockContainerService mockService = new MockContainerService("test", "http://localhost", 8080);
        manager.registerService("test-service", mockService);
        
        ContainerServiceClient retrieved = manager.getService("test-service");
        assertNotNull(retrieved);
    }
    
    // Mock implementation for testing
    private static class MockContainerService extends ContainerServiceClient {
        public MockContainerService(String serviceName, String serviceUrl, int servicePort) {
            super(serviceName, serviceUrl, servicePort);
        }
        
        @Override
        public void connect() throws Exception {
            // Mock implementation
        }
        
        @Override
        public void disconnect() throws Exception {
            // Mock implementation
        }
        
        @Override
        public boolean isServiceAvailable() {
            return true;
        }
    }
}
