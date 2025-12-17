package com.company.app.service;

import com.company.app.integration.ContainerServiceClient;
import com.company.app.util.LoggerUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * Container Service Manager - Manages containerized services lifecycle.
 * Handles initialization, monitoring, and health checks of container services.
 */
public class ContainerServiceManager {
    
    private Map<String, ContainerServiceClient> services;
    
    private static class SingletonHolder {
        static final ContainerServiceManager instance = new ContainerServiceManager();
    }
    
    public static ContainerServiceManager getInstance() {
        return SingletonHolder.instance;
    }
    
    private ContainerServiceManager() {
        services = new HashMap<>();
        LoggerUtil.info("ContainerServiceManager initialized");
    }
    
    /**
     * Register a container service
     */
    public void registerService(String serviceId, ContainerServiceClient client) {
        services.put(serviceId, client);
        LoggerUtil.info("Registered container service: " + serviceId);
    }
    
    /**
     * Get a registered service
     */
    public ContainerServiceClient getService(String serviceId) {
        return services.get(serviceId);
    }
    
    /**
     * Start all registered services
     */
    public void startAllServices() {
        LoggerUtil.info("Starting all container services...");
        for (Map.Entry<String, ContainerServiceClient> entry : services.entrySet()) {
            try {
                entry.getValue().connect();
                LoggerUtil.info("Started service: " + entry.getKey());
            } catch (Exception e) {
                LoggerUtil.error("Failed to start service: " + entry.getKey(), e);
            }
        }
    }
    
    /**
     * Stop all registered services
     */
    public void stopAllServices() {
        LoggerUtil.info("Stopping all container services...");
        for (Map.Entry<String, ContainerServiceClient> entry : services.entrySet()) {
            try {
                entry.getValue().disconnect();
                LoggerUtil.info("Stopped service: " + entry.getKey());
            } catch (Exception e) {
                LoggerUtil.error("Failed to stop service: " + entry.getKey(), e);
            }
        }
    }
    
    /**
     * Check health of all services
     */
    public Map<String, Boolean> healthCheckAllServices() {
        Map<String, Boolean> healthStatus = new HashMap<>();
        LoggerUtil.debug("Running health check on all services...");
        
        for (Map.Entry<String, ContainerServiceClient> entry : services.entrySet()) {
            boolean isHealthy = entry.getValue().isServiceAvailable();
            healthStatus.put(entry.getKey(), isHealthy);
            LoggerUtil.debug("Health check for " + entry.getKey() + ": " + (isHealthy ? "HEALTHY" : "UNHEALTHY"));
        }
        
        return healthStatus;
    }
}
