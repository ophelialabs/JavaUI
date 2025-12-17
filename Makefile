.PHONY: help build test run deploy clean dev-start dev-stop docker-build docker-up docker-down logs

help:
	@echo "Enterprise UI Application - Available Commands"
	@echo "=============================================="
	@echo "Build & Test:"
	@echo "  make build           - Build application JAR"
	@echo "  make test            - Run unit tests"
	@echo "  make test-coverage   - Run tests with coverage report"
	@echo ""
	@echo "Development:"
	@echo "  make dev-start       - Start development environment"
	@echo "  make dev-stop        - Stop development environment"
	@echo "  make run             - Run application locally"
	@echo ""
	@echo "Docker & Deployment:"
	@echo "  make docker-build    - Build Docker images"
	@echo "  make docker-up       - Start Docker containers"
	@echo "  make docker-down     - Stop Docker containers"
	@echo "  make deploy          - Deploy to production"
	@echo "  make logs            - View Docker logs"
	@echo ""
	@echo "Maintenance:"
	@echo "  make clean           - Clean build artifacts"
	@echo "  make format          - Format code"
	@echo ""

build:
	@echo "Building application..."
	mvn clean package -DskipTests

test:
	@echo "Running tests..."
	mvn test

test-coverage:
	@echo "Running tests with coverage..."
	mvn test jacoco:report
	@echo "Coverage report: target/site/jacoco/index.html"

run:
	@echo "Running application..."
	mvn javafx:run

dev-start:
	@echo "Starting development environment..."
	docker-compose up -d
	@echo "Development environment started!"
	@echo "Services available at:"
	@echo "  API: http://localhost:8080"
	@echo "  DB: localhost:5432"
	@echo "  Cache: localhost:6379"

dev-stop:
	@echo "Stopping development environment..."
	docker-compose down
	@echo "Development environment stopped"

docker-build:
	@echo "Building Docker images..."
	docker-compose build

docker-up:
	@echo "Starting Docker containers..."
	docker-compose up -d
	@sleep 5
	@docker-compose ps

docker-down:
	@echo "Stopping Docker containers..."
	docker-compose down

deploy:
	@echo "Deploying application..."
	@chmod +x deployment/deploy.sh
	@./deployment/deploy.sh

logs:
	@docker-compose logs -f

clean:
	@echo "Cleaning build artifacts..."
	mvn clean
	@rm -rf target/
	@echo "Clean complete"

format:
	@echo "Formatting code..."
	mvn spotless:apply

install-deps:
	@echo "Installing dependencies..."
	mvn dependency:resolve

status:
	@docker-compose ps
	@echo ""
	@echo "Service Status:"
	@docker-compose exec -T backend-api curl -s http://localhost:8080/health || echo "API: Unavailable"
	@docker-compose exec -T enterprise-db pg_isready || echo "DB: Unavailable"
	@docker-compose exec -T redis-cache redis-cli ping || echo "Cache: Unavailable"

ps:
	@docker-compose ps

shell-app:
	@docker-compose exec app /bin/sh

shell-db:
	@docker-compose exec enterprise-db psql -U admin -d appdb

shell-cache:
	@docker-compose exec redis-cache redis-cli

.DEFAULT_GOAL := help
