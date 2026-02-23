# Agents Instructions

## Product Overview
Astro Bookings is a fictional space travel booking system API. Built with Spring Boot and Java, it offers backend endpoints for managing rocket launches with passenger bookings, pricing, and payment processing.

## Technical Implementation

### Tech Stack
- Language: **Java 21**
- Framework: **Spring Boot 4.0.3**
- Database: **None (mock data only, demo stage)**
- Security: **Not implemented (training/demo only)**
- Testing: **Playwright 1.57**
- Logging: **Console (built-in)**

### Development workflow

```bash
# Set up the project
./mvnw clean install
# Build the project
./mvnw package
# Run the project (dev with hot reload)
./mvnw spring-boot:run  
# Run the project (compiled)
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=prod"
# Run with java -jar
java -jar target/*.jar
# Test the project
./mvnw test
# Test UI (Playwright)
npx playwright test
# Compile (build sources only)
./mvnw compile
```

### Folder structure

```text
.                              # Project root
├─ AGENTS.md                   # This file with instructions
├─ README.md                   # Project overview and quick start
├─ pom.xml                     # Maven dependencies and scripts
├─ src/                        # Source code
│   ├─ main/
│   │   └─ java/*/             # Main application code
│   │       ├─ astro_bookings/ # AstroBookings package
│   │       └─ resources/      # Static resources (if any)
│   └─ test/
│       └─ java/*/             # Test code
├─ package.json                # NPM dependencies for tests
├─ playwright.config.ts        # Test e2e config
├─ tests/                      # Test e2e files
└─ target/                     # Compiled output (generated)
```

## Environment
- Code and documentation in English.
- Sacrifice grammar for conciseness in responses.
- Windows environment using Git Bash.
- Default branch: `main`.
- Server port: `3000` (configurable via `PORT` env var).
- Base URL for tests: `http://localhost:3000`.

## Important Notes
- Demo/training project only.
- No database or authentication yet.
- Playwright runs smoke tests on dev server.
- Java compilation targets Java 21.
