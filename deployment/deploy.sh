#!/bin/bash

# Deployment script for enterprise application

set -e

echo "======================================"
echo "Enterprise Application Deployment"
echo "======================================"

# Check prerequisites
echo "Checking prerequisites..."
if ! command -v docker &> /dev/null; then
    echo "Error: Docker is required but not installed."
    exit 1
fi

if ! command -v docker-compose &> /dev/null; then
    echo "Error: Docker Compose is required but not installed."
    exit 1
fi

# Build application
echo "Building application..."
mvn clean package -DskipTests

# Build Docker images
echo "Building Docker images..."
docker-compose build

# Start containers
echo "Starting containers..."
docker-compose up -d

# Wait for services to be ready
echo "Waiting for services to be ready..."
sleep 30

# Run health checks
echo "Running health checks..."
docker-compose ps

# Display logs
echo "======================================"
echo "Deployment Complete!"
echo "======================================"
echo "Application is running at: http://localhost:8000"
echo "API Service: http://localhost:8080"
echo "Database: localhost:5432"
echo "Cache: localhost:6379"
echo ""
echo "To view logs: docker-compose logs -f"
echo "To stop: docker-compose down"
