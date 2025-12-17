# Architecture Documentation

## Project Structure Overview

This enterprise-grade Java application follows a layered architecture pattern optimized for production environments.

### Directory Structure

```
Java3/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/company/app/
│   │   │       ├── core/              # Application entry point
│   │   │       ├── ui/                # User interface layer
│   │   │       │   ├── components/    # UI components (Main Frame, Nav Bar, Sidebar, etc.)
│   │   │       │   ├── controller/    # UI controllers
│   │   │       │   └── layout/        # Layout managers
│   │   │       ├── theme/             # Theming system
│   │   │       ├── service/           # Business logic services
│   │   │       ├── integration/       # External service integration (API, DB, Cache)
│   │   │       ├── util/              # Utility classes (Logger, Config)
│   │   │       └── exception/         # Custom exceptions
│   │   └── resources/
│   │       ├── config/                # Configuration files
│   │       ├── styles/                # CSS theme files
│   │       └── fxml/                  # JavaFX FXML files (future)
│   └── test/
│       ├── java/
│       │   └── com/company/app/       # Unit tests
│       └── resources/                 # Test resources
├── docker/                            # Docker configuration
│   ├── Dockerfile.app                 # Application container
│   └── init-db.sql                    # Database initialization
├── deployment/                        # Deployment scripts
│   ├── deploy.sh                      # Production deployment
│   ├── dev-start.sh                   # Development startup
│   └── cleanup.sh                     # Environment cleanup
├── docs/                              # Documentation
├── docker-compose.yml                 # Multi-container orchestration
├── pom.xml                            # Maven configuration
└── README.md                          # Project README
```

## Architecture Layers

### 1. **Presentation Layer** (`ui/`)
- **Components**: Reusable UI building blocks
  - MainFrame: Application window container
  - NavigationBar: Top navigation
  - Sidebar: Secondary navigation
  - StatusBar: Status display

- **Controllers**: Handle UI events and business logic integration
  - MainFrameController: Manages main window

### 2. **Theme Layer** (`theme/`)
- **ThemeManager**: Singleton pattern for theme management
- Supports light and dark themes
- CSS-based styling system

### 3. **Service Layer** (`service/`)
- **ContainerServiceManager**: Lifecycle management for containerized services
- Health checks and service monitoring
- Connection pooling and resource management

### 4. **Integration Layer** (`integration/`)
- **ContainerServiceClient**: Abstract base for service clients
- **ApiClient**: REST API communication
- **DatabaseClient**: Database operations

### 5. **Utility Layer** (`util/`)
- **LoggerUtil**: Centralized logging
- **ConfigurationManager**: Singleton configuration manager
- Configuration property management

### 6. **Exception Handling** (`exception/`)
- **ApplicationException**: Custom exceptions with error codes
- Consistent error handling across layers

## Design Patterns Used

1. **Singleton Pattern**
   - ThemeManager
   - ConfigurationManager
   - ContainerServiceManager

2. **Factory Pattern**
   - Layout creation in LayoutManager
   - Service client creation

3. **Observer Pattern**
   - JavaFX event handling
   - Service status monitoring

4. **Layered Architecture**
   - Clear separation of concerns
   - Easy to test and maintain

## Containerized Services Integration

### Services Configured

1. **Backend API** (Port 8080)
   - REST API service
   - Health check endpoint
   - Depends on database and cache

2. **PostgreSQL Database** (Port 5432)
   - Primary data storage
   - Persistent volume for data
   - Health checks enabled

3. **Redis Cache** (Port 6379)
   - Session/cache storage
   - High-performance in-memory store
   - Persistent storage configured

4. **JavaFX UI Application** (Port 8000)
   - Main application container
   - Connects to all services
   - Configuration via environment variables

## Build & Deployment

### Build Process
- Maven multi-module project
- JavaFX integrated
- Shade plugin for fat JAR creation

### Containerization
- Multi-stage Docker build
- Optimized image size
- Alpine base for runtime efficiency

### Orchestration
- Docker Compose for local development
- Service dependencies properly configured
- Health checks for all services

### Deployment Scripts
- `deploy.sh`: Production deployment with validation
- `dev-start.sh`: Development environment setup
- `cleanup.sh`: Environment teardown

## Testing Strategy

- Unit tests in `src/test/`
- Framework: JUnit 5
- Coverage for:
  - Component initialization
  - Service management
  - Configuration loading

## Configuration Management

Properties file: `src/main/resources/config/application.properties`

Key configurations:
- Service endpoints and ports
- Database credentials
- Logging levels
- UI window dimensions

## Security Considerations

- Credentials externalized to properties
- Container network isolation
- Health checks for service availability
- Exception handling with error codes

## Future Enhancements

- Phase 2: Feature implementation (Agent Popup, Dashboard Components)
- Phase 3: State management, error UI, accessibility, performance optimization
- Kubernetes migration from Docker Compose
- CI/CD pipeline integration
- Monitoring and observability (Prometheus, ELK stack)
