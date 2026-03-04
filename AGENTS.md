# Agents Instructions

## Product Overview
Laboratory for Java intelligent programming course using AI techniques.
Spring Boot REST API demonstrating clean code patterns and best practices.
Edition: Canarias 2026 - Focus on teaching modern Java development with AI.

## Technical Implementation

### Tech Stack
- Language: **Java 21**
- Framework: **Spring Boot 3.3.6**
- Build Tool: **Maven 3.6+**
- Database: **None (in-memory for demo)**
- Security: **Spring Security defaults**
- Testing: **JUnit 5 + Mockito (unit), Playwright (E2E)**
- Logging: **Custom LoggerUtil with console output**

### Development workflow
```bash
# Set up the project
mvn clean install

# Build the project
mvn clean package

# Run the project
mvn spring-boot:run

# Run unit tests
mvn test

# Run E2E tests
npm install
npx playwright test

# Deploy the project
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Folder structure
```text
.                                # Project root
├── AGENTS.md                     # This file with instructions for AI agents
├── README.md                     # Main human documentation
├── SPRING_README.md              # Spring Boot specific guide
├── pom.xml                       # Maven configuration
├── playwright.config.ts          # E2E tests configuration
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java       # Main Spring Boot entry point
│   │   │   ├── api/                       # DTOs and API models
│   │   │   ├── controller/                # REST controllers
│   │   │   ├── model/                     # Entity models
│   │   │   ├── service/                   # Business logic layer
│   │   │   └── util/                      # Shared utilities (LoggerUtil)
│   │   └── resources/
│   │       └── application.properties     # Spring configuration
│   └── test/
│       └── java/com/example/demo/         # Unit tests
├── tests/                        # E2E tests with Playwright
├── docs/                         # Documentation and specifications
└── specs/                        # Feature specifications
```

## Environment
- Code and documentation must be in English.
- Chat responses must be in the language of the user prompt.
- Sacrifice grammar for conciseness in responses.
- This is a Windows environment using git bash terminal.
- Default branch: `main`.
- API runs on `http://localhost:8080` by default.
- Follow layered architecture: controller → service → model.
- Use Spring annotations for dependency injection.
- Implement exception handling with @RestControllerAdvice.
- Write tests for all business logic in services.
