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

## Packaging (create JAR)

Build and package the application into a runnable JAR:

Windows (Maven installed):
```bash
cd "c:\Users\Dev Jean\spring Boot"
mvn clean package
```

Windows (using Maven Wrapper):
```bash
cd "c:\Users\Dev Jean\spring Boot"
mvnw.cmd clean package
```

After a successful build the JAR will be in the target/ directory, e.g.
target/<artifactId>-<version>.jar (for example target/application-name-0.0.1-SNAPSHOT.jar).

## Run the JAR

Run the packaged jar:

```bash
# Windows (PowerShell / CMD)
java -jar target/application-name-0.0.1-SNAPSHOT.jar
```

Optional: override properties from command line:

```bash
java -jar target/application-name-0.0.1-SNAPSHOT.jar --server.port=8081
```

Use the Maven Spring Boot plugin to run without packaging:

```bash
mvn spring-boot:run
# or with wrapper
mvnw.cmd spring-boot:run
```

## Connect to MySQL

1. Create a database and user in MySQL:

```sql
CREATE DATABASE myapp_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'myapp_user'@'localhost' IDENTIFIED BY 'strong_password';
GRANT ALL PRIVILEGES ON myapp_db.* TO 'myapp_user'@'localhost';
FLUSH PRIVILEGES;
```

2. Add MySQL driver dependency to pom.xml (if not present):

```xml
<!-- ...existing code... -->
<dependencies>
  <!-- ...existing code... -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
  </dependency>
  <!-- ...existing code... -->
</dependencies>
<!-- ...existing code... -->
```

3. Example application.properties for MySQL (place in src/main/resources/application.properties):

```properties
// filepath: c:\Users\Dev Jean\spring Boot\src\main\resources\application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/myapp_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=myapp_user
spring.datasource.password=strong_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
```

Notes:
- Replace myapp_db / myapp_user / strong_password with your values.
- For production use, avoid storing plaintext passwords in properties; use environment variables or a secrets manager and/or Spring Boot support for externalized configuration.
- If using MySQL 5.x, change the Hibernate dialect accordingly.