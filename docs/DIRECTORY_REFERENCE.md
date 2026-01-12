# Directory Structure Reference

## Complete Project Hierarchy

```
Java3/
│
├── 📄 README.md                          # Original project requirements
├── 📄 IMPLEMENTATION_SUMMARY.md           # This implementation overview
├── 📄 Makefile                           # Build automation commands
├── 📄 .gitignore                         # Git configuration
├── 📄 pom.xml                            # Maven build configuration
├── 📄 docker-compose.yml                 # Multi-container orchestration
│
├── 📁 src/                               # Source code root
│   ├── 📁 main/                          # Main application code
│   │   ├── 📁 java/
│   │   │   └── 📁 com/company/app/       # Application package root
│   │   │       ├── 📁 core/              # Application entry point
│   │   │       │   └── Application.java  # Main JavaFX application class
│   │   │       │
│   │   │       ├── 📁 ui/                # User interface layer
│   │   │       │   ├── 📁 components/    # Reusable UI components
│   │   │       │   │   ├── MainFrame.java        # Main window container
│   │   │       │   │   ├── NavigationBar.java    # Top navigation bar
│   │   │       │   │   ├── Sidebar.java          # Side navigation menu
│   │   │       │   │   └── StatusBar.java        # Status display bar
│   │   │       │   │
│   │   │       │   ├── 📁 controller/    # UI controllers
│   │   │       │   │   └── MainFrameController.java
│   │   │       │   │
│   │   │       │   └── 📁 layout/        # Layout utilities
│   │   │       │       └── LayoutManager.java
│   │   │       │
│   │   │       ├── 📁 theme/             # Theme management
│   │   │       │   └── ThemeManager.java # Theme switching system
│   │   │       │
│   │   │       ├── 📁 service/           # Business logic services
│   │   │       │   └── ContainerServiceManager.java
│   │   │       │
│   │   │       ├── 📁 integration/       # External service integration
│   │   │       │   ├── ContainerServiceClient.java  # Base client
│   │   │       │   ├── ApiClient.java              # REST API client
│   │   │       │   └── DatabaseClient.java         # Database client
│   │   │       │
│   │   │       ├── 📁 util/              # Utility classes
│   │   │       │   ├── LoggerUtil.java          # Logging utility
│   │   │       │   └── ConfigurationManager.java # Config management
│   │   │       │
│   │   │       └── 📁 exception/         # Custom exceptions
│   │   │           └── ApplicationException.java
│   │   │
│   │   └── 📁 resources/                 # Configuration & assets
│   │       ├── 📁 config/
│   │       │   └── application.properties # Main configuration
│   │       │
│   │       ├── 📁 styles/                # CSS themes
│   │       │   ├── light-theme.css       # Light theme
│   │       │   └── dark-theme.css        # Dark theme
│   │       │
│   │       └── 📁 fxml/                  # FXML layouts (future)
│   │
│   └── 📁 test/                          # Test code
│       ├── 📁 java/
│       │   └── 📁 com/company/app/
│       │       ├── 📁 ui/components/
│       │       │   └── MainFrameTest.java
│       │       ├── 📁 util/
│       │       │   └── ConfigurationManagerTest.java
│       │       └── 📁 service/
│       │           └── ContainerServiceManagerTest.java
│       │
│       └── 📁 resources/                 # Test resources
│
├── 📁 docker/                            # Docker configuration
│   ├── Dockerfile.app                    # Multi-stage build for app
│   └── init-db.sql                       # Database initialization script
│
├── 📁 deployment/                        # Deployment scripts
│   ├── deploy.sh                         # Production deployment script
│   ├── dev-start.sh                      # Development startup script
│   └── cleanup.sh                        # Environment cleanup script
│
├── 📁 docs/                              # Documentation
│   ├── ARCHITECTURE.md                   # Architecture documentation
│   └── SETUP.md                          # Setup & deployment guide
│
└── 📁 logs/                              # Application logs (generated)
```

## File Descriptions

### Core Configuration Files

| File | Purpose |
|------|---------|
| `pom.xml` | Maven project configuration with dependencies |
| `docker-compose.yml` | Orchestration for Backend API, DB, Cache, App |
| `Makefile` | Convenient build and deployment commands |
| `.gitignore` | Git ignore patterns |

### Application Entry Point

| File | Purpose |
|------|---------|
| `Application.java` | Main JavaFX application class |
| `MainFrameController.java` | Primary window controller |

### UI Components (Phase 1)

| Component | File | Purpose |
|-----------|------|---------|
| Main Frame | `MainFrame.java` | Root container for all UI |
| Navigation Bar | `NavigationBar.java` | Top-level navigation |
| Sidebar | `Sidebar.java` | Secondary navigation menu |
| Status Bar | `StatusBar.java` | Application status display |

### Supporting Systems

| System | File | Purpose |
|--------|------|---------|
| Theme | `ThemeManager.java` | Light/Dark theme switching |
| Layout | `LayoutManager.java` | Flexible layout utilities |
| Logging | `LoggerUtil.java` | Centralized logging |
| Config | `ConfigurationManager.java` | Property management |

### Container Integration

| Service | File | Purpose |
|---------|------|---------|
| Base Client | `ContainerServiceClient.java` | Abstract service client |
| API Client | `ApiClient.java` | REST API communication |
| DB Client | `DatabaseClient.java` | Database operations |
| Manager | `ContainerServiceManager.java` | Service lifecycle |

### Docker & Deployment

| File | Purpose |
|------|---------|
| `Dockerfile.app` | Multi-stage build for application container |
| `docker-compose.yml` | Complete service stack configuration |
| `init-db.sql` | Database schema initialization |
| `deploy.sh` | Automated production deployment |
| `dev-start.sh` | Development environment setup |
| `cleanup.sh` | Environment teardown |

### Configuration & Styling

| File | Purpose |
|------|---------|
| `application.properties` | Application configuration |
| `light-theme.css` | Light theme stylesheet |
| `dark-theme.css` | Dark theme stylesheet |

### Documentation

| File | Purpose |
|------|---------|
| `README.md` | Project overview and roadmap |
| `IMPLEMENTATION_SUMMARY.md` | This file - implementation details |
| `ARCHITECTURE.md` | Detailed architecture documentation |
| `SETUP.md` | Setup and deployment guide |

### Testing

| Test Class | Purpose |
|-----------|---------|
| `MainFrameTest.java` | UI component initialization tests |
| `ConfigurationManagerTest.java` | Configuration management tests |
| `ContainerServiceManagerTest.java` | Service manager tests |

## Package Organization

### Package Hierarchy

```
com.company.app
├── core              # Application initialization
├── ui                # User interface layer
│   ├── components    # Reusable UI components
│   ├── controller    # Event handlers & controllers
│   └── layout        # Layout management
├── theme             # Visual styling system
├── service           # Business logic & orchestration
├── integration       # External service clients
├── util              # Helper utilities
└── exception         # Error handling
```

### Dependencies Between Packages

```
core (Application)
  ↓
ui.controller (MainFrameController)
  ↓
ui.components (MainFrame, NavBar, Sidebar, StatusBar)
  ↓
theme (ThemeManager)
  ↓
service (ContainerServiceManager)
  ↓
integration (ApiClient, DatabaseClient)
  ↓
util (LoggerUtil, ConfigurationManager)
```

## Resource Structure

### Configuration Location
```
src/main/resources/config/
└── application.properties    # All runtime configuration
```

### Styling Location
```
src/main/resources/styles/
├── light-theme.css          # Default light theme
└── dark-theme.css           # Alternative dark theme
```

### Future FXML Location
```
src/main/resources/fxml/
├── MainFrame.fxml           # (Planned)
├── Dashboard.fxml           # (Planned)
└── settings.fxml            # (Planned)
```

## Build Artifacts

When you build the project, the following directories are created:

```
target/
├── classes/                  # Compiled Java classes
├── test-classes/            # Compiled test classes
├── app-1.0.0.jar           # Application JAR file
├── app-1.0.0-shaded.jar    # Fat JAR with dependencies
└── site/                    # Generated documentation
    └── jacoco/             # Test coverage reports
```

## Docker Artifacts

When running Docker, the following are created:

```
Docker Containers:
├── enterprise-app            # JavaFX application
├── backend-api              # REST API service
├── enterprise-db            # PostgreSQL database
└── redis-cache              # Redis cache

Docker Volumes:
├── postgres-data            # Database persistence
└── redis-data               # Cache persistence
```

## Quick Navigation

- **To understand the architecture**: See `docs/ARCHITECTURE.md`
- **To set up and deploy**: See `docs/SETUP.md`
- **To see all available commands**: Run `make help`
- **To run tests**: Run `mvn test`
- **To start development**: Run `make dev-start`
