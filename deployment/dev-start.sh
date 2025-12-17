#!/bin/bash

# Development startup script

set -e

echo "Starting development environment..."

# Check if containers are running
if docker ps | grep -q "enterprise-db"; then
    echo "Containers already running"
else
    echo "Starting Docker containers..."
    docker-compose up -d
fi

echo "Development environment started!"
echo ""
echo "Running application..."
cd /Users/jesse/Desktop/Company/new/java/Java3
mvn javafx:run
