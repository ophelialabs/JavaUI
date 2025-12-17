package com.company.app.integration;

import com.company.app.util.LoggerUtil;

/**
 * Container Service Client - Base class for container integration.
 * Manages communication with containerized services.
 */
public abstract class ContainerServiceClient {
    
    protected String serviceName;
    protected String serviceUrl;
    protected int servicePort;
    protected long connectionTimeout;
    
    public ContainerServiceClient(String serviceName, String serviceUrl, int servicePort) {
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.servicePort = servicePort;
        this.connectionTimeout = 5000; // Default 5 second timeout
        
        LoggerUtil.debug("Initialized ContainerServiceClient for: " + serviceName);
    }
    
    /**
     * Connect to container service
     */
    public abstract void connect() throws Exception;
    
    /**
     * Disconnect from container service
     */
    public abstract void disconnect() throws Exception;
    
    /**
     * Check if service is available
     */
    public abstract boolean isServiceAvailable();
    
    public String getServiceName() {
        return serviceName;
    }
    
    public String getServiceUrl() {
        return serviceUrl;
    }
    
    public int getServicePort() {
        return servicePort;
    }
    
    public void setConnectionTimeout(long timeout) {
        this.connectionTimeout = timeout;
    }
}
