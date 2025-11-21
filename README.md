# Spring Boot Application

A Spring Boot application built with Maven.

## Table of Contents

- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Building](#building)
- [Running](#running)
- [Testing](#testing)

## Requirements

- **Java**: JDK 11 or higher
- **Maven**: 3.6.0 or higher
- **Spring Boot**: 2.x or 3.x (verify in [pom.xml](pom.xml))

## Project Structure

```
spring-boot/
├── src/
│   ├── main/
│   │   ├── java/com/example/          # Application source code
│   │   │   ├── controller/            # REST controllers
│   │   │   ├── service/               # Business logic
│   │   │   ├── repository/            # Data access layer
│   │   │   ├── model/                 # Entity classes
│   │   │   └── Application.java       # Main entry point
│   │   └── resources/
│   │       └── application.properties # Configuration
│   └── test/
│       └── java/com/example/          # Test classes
├── target/                             # Compiled output (generated)
├── pom.xml                             # Maven configuration
├── mvnw & mvnw.cmd                    # Maven wrapper scripts
└── README.md                           # This file
```

## Getting Started

### 1. Clone or Download the Project

```bash
cd "spring Boot"
```

### 2. Verify Prerequisites

Check Java version:
```bash
java -version
```

Check Maven version:
```bash
mvn -version
```

## Building

Build the project using Maven:

```bash
mvn clean install
```

Or using the Maven wrapper (no Maven installation needed):

```bash
./mvnw clean install          # Linux/Mac
mvnw.cmd clean install        # Windows
```

**Build options:**
- `clean` - Removes previous build artifacts
- `install` - Compiles, tests, and packages the application

## Running

### Option 1: Using Maven directly

```bash
mvn spring-boot:run
```

### Option 2: Using the JAR file

```bash
# Build the JAR first
mvn clean package

# Run the JAR
java -jar target/application-name-0.0.1-SNAPSHOT.jar
```

### Option 3: Using Maven wrapper

```bash
./mvnw spring-boot:run        # Linux/Mac
mvnw.cmd spring-boot:run      # Windows
```

The application will typically start on `http://localhost:8080`

## Testing

Run all tests:

```bash
mvn test
```

Run tests with Maven wrapper:

```bash
./mvnw test
```

## Configuration

Application properties can be modified in [src/main/resources/application.properties](src/main/resources/application.properties)

Common configurations:
```properties
server.port=8080
spring.application.name=spring-boot-app
spring.jpa.hibernate.ddl-auto=update
```

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/)
- [Spring Boot Starters](https://spring.io/projects/spring-boot#learn)