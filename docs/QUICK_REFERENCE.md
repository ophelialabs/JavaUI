# 🚀 Quick Reference Card

## Essential Commands

### 🏗️ Build & Compile
```bash
mvn clean package              # Build JAR
mvn clean package -DskipTests  # Skip tests
mvn compile                    # Just compile
```

### 🧪 Testing
```bash
mvn test                       # Run all tests
mvn test -Dtest=ClassName     # Specific test
mvn test jacoco:report        # With coverage
```

### 🚀 Run Application
```bash
mvn javafx:run                # Run locally
make run                      # Using Makefile
```

### 🐳 Docker Commands
```bash
docker-compose up -d          # Start services
docker-compose down           # Stop services
docker-compose ps             # View status
docker-compose logs -f        # View logs
docker-compose restart        # Restart all
```

### 📋 Makefile Commands
```bash
make help                     # View all commands
make build                    # Build application
make test                     # Run tests
make dev-start               # Start development env
make dev-stop                # Stop development env
make deploy                  # Production deploy
make logs                    # View Docker logs
make clean                   # Clean artifacts
```

### 📁 File Organization
```bash
src/main/java/com/company/app/
├── core/         → Application entry point
├── ui/           → UI components & controllers
├── theme/        → Theme management
├── service/      → Business services
├── integration/  → Container clients
├── util/         → Utilities
└── exception/    → Error handling
```

---

## 🎯 Common Tasks

### Start Development
```bash
make dev-start
# Access at: http://localhost:8000
```

### Deploy to Production
```bash
make deploy
```

### Run All Tests
```bash
mvn test
```

### View Service Status
```bash
make ps
# or
docker-compose ps
```

### View Logs
```bash
make logs
# or
docker-compose logs -f
```

### Stop Everything
```bash
make dev-stop
# or
docker-compose down
```

---

## 📚 Documentation Map

| Filename | Purpose | Read When |
|----------|---------|-----------|
| **INDEX.md** | Master guide | First - orientation |
| **IMPLEMENTATION_SUMMARY.md** | Overview | Understanding scope |
| **DIRECTORY_REFERENCE.md** | File structure | Finding files |
| **ARCHITECTURE.md** | Design details | Learning architecture |
| **SETUP.md** | Installation | Setting up |
| **COMPLETION_REPORT.md** | What was done | Checking status |

---

## 🔗 Key Endpoints

| Service | URL | Purpose |
|---------|-----|---------|
| Application | http://localhost:8000 | JavaFX UI |
| Backend API | http://localhost:8080 | REST API |
| Database | localhost:5432 | PostgreSQL |
| Cache | localhost:6379 | Redis |

---

## 📦 Project Structure

```
Java3/
├── src/                    # Source code
│   ├── main/
│   │   ├── java/          # Java sources (15 files)
│   │   └── resources/     # Config & styles
│   └── test/              # Tests (3 files)
├── docker/                # Docker files
├── deployment/            # Scripts
├── docs/                  # Documentation
├── pom.xml               # Maven config
├── docker-compose.yml    # Services
├── Makefile             # Commands
└── README.md            # Overview
```

---

## 🎯 Key Components

### UI Components (Phase 1 - Complete)
- ✅ MainFrame - Window container
- ✅ NavigationBar - Top navigation
- ✅ Sidebar - Side navigation
- ✅ StatusBar - Status display
- ✅ ThemeManager - Theming system
- ✅ LayoutManager - Layout utilities

### Services
- ContainerServiceManager - Service orchestration
- ApiClient - API communication
- DatabaseClient - DB operations
- ConfigurationManager - Settings management
- LoggerUtil - Logging

---

## 🔐 Configuration

**File**: `src/main/resources/config/application.properties`

Key settings:
```properties
app.name=Enterprise UI Application
service.api.port=8080
service.database.port=5432
service.cache.port=6379
logging.level=DEBUG
ui.theme=light
```

---

## 🧪 Testing

**Location**: `src/test/java/com/company/app/`

Test classes:
- MainFrameTest.java
- ConfigurationManagerTest.java
- ContainerServiceManagerTest.java

Run with:
```bash
mvn test
```

---

## 📊 Quick Stats

- **Java Files**: 15 (sources) + 3 (tests)
- **Config Files**: 5
- **Documentation**: 7 files
- **Deployment Scripts**: 3
- **Total Files**: 34+
- **Lines of Code**: ~2000+

---

## 🚀 Getting Started (30 seconds)

```bash
# 1. Prerequisites
java -version    # Java 17+
mvn -version    # Maven 3.8+
docker --version # Docker

# 2. Start
cd /Users/jesse/Desktop/Company/new/java/Java3
make dev-start

# 3. Access
# Open browser: http://localhost:8000
# Check API: http://localhost:8080
```

---

## 🛠️ Troubleshooting

### Container Issues
```bash
make ps                    # Check status
make logs                  # View logs
docker-compose restart     # Restart services
```

### Build Issues
```bash
mvn clean                  # Clean
mvn compile               # Recompile
mvn dependency:resolve    # Update deps
```

### Port Already in Use
```bash
docker-compose down       # Stop containers
lsof -i :8080            # Check port
```

---

## 📞 Need Help?

1. **Quick answers**: Check `DIRECTORY_REFERENCE.md`
2. **Setup issues**: See `docs/SETUP.md`
3. **Architecture questions**: Read `docs/ARCHITECTURE.md`
4. **Code examples**: Look in `src/test/`
5. **Full overview**: Start with `INDEX.md`

---

## ✨ Next Steps

- [ ] Run `make dev-start`
- [ ] Verify services running
- [ ] Run `mvn test`
- [ ] Read `docs/ARCHITECTURE.md`
- [ ] Explore source code
- [ ] Implement Phase 2 features

---

**Status**: ✅ Phase 1 Complete - Ready for Development
**Last Updated**: December 17, 2025
