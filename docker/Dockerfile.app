# Multi-stage build for JavaFX Application
FROM maven:3.8.6-eclipse-temurin-17 as builder

WORKDIR /build

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build application
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy JAR from builder
COPY --from=builder /build/target/app-*.jar app.jar

# Copy resources
COPY --from=builder /build/src/main/resources ./resources

# Expose port
EXPOSE 8000

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 \
  CMD java -version || exit 1

# Run application
ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]
