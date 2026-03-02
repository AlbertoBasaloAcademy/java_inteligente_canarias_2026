# Spring Boot Demo Application

A modern bare-bone Spring Boot application using Java 21.

## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Testing the Endpoint

```bash
curl http://localhost:8080/api/hello
```

Expected response: `Hello from Spring Boot!`

## Building the Application

```bash
mvn clean package
```

## Running Tests

```bash
mvn test
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── DemoApplication.java
│   │       └── controller/
│   │           └── HelloController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/example/demo/
            └── DemoApplicationTests.java
```
