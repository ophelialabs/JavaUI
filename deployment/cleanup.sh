#!/bin/bash

# Cleanup script

set -e

echo "Cleaning up containers and volumes..."

# Stop containers
docker-compose down

# Remove volumes (optional - comment out to keep data)
# docker-compose down -v

echo "Cleanup complete"
