# Project Setup and Deployment Guide

## Prerequisites

- Java 17 or later
- Maven 3.8+
- Docker and Docker Compose
- Git (optional)

## Project Structure

See `ARCHITECTURE.md` for detailed architecture documentation.

## Getting Started

### 1. Development Setup

```bash
# Make deployment scripts executable
chmod +x deployment/*.sh

# Start development environment
./deployment/dev-start.sh
```

### 2. Production Deployment

```bash
# Deploy to production
./deployment/deploy.sh

# Verify services are running
docker-compose ps

# View logs
docker-compose logs -f
```

### 3. Building Locally

```bash
# Build application JAR
mvn clean package

# Run tests
mvn test

# Run application
mvn javafx:run
```

## Docker Services

All services are containerized and orchestrated via Docker Compose.

### Access Points

- **Application UI**: http://localhost:8000
- **Backend API**: http://localhost:8080
- **Database**: localhost:5432
- **Redis Cache**: localhost:6379

## Configuration

Edit `src/main/resources/config/application.properties` to customize:
- Service endpoints
- Database credentials
- Logging levels
- UI settings

## Testing

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MainFrameTest

# Run with coverage
mvn test jacoco:report
```

## Troubleshooting

### Container issues
```bash
# Check container status
docker-compose ps

# View container logs
docker-compose logs [service-name]

# Restart services
docker-compose restart

# Force rebuild
docker-compose up --build
```

### Maven issues
```bash
# Clear cache
mvn clean

# Force dependency download
mvn dependency:resolve
```

## Cleanup

```bash
# Stop and remove containers
./deployment/cleanup.sh

# Or manually
docker-compose down -v
```

## Production Considerations

1. Update credentials in application.properties
2. Use environment variables for sensitive data
3. Enable SSL/TLS for API endpoints
4. Configure monitoring and logging
5. Set up backup strategies for database
6. Implement rate limiting on API
7. Enable security policies in Docker

## Support and Documentation

- Architecture: See `ARCHITECTURE.md`
- Code style follows Java conventions
- API documentation in Javadoc comments
- Unit tests provide usage examples
