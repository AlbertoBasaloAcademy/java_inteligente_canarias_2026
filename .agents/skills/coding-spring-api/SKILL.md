---
name: coding-spring-api
description: "Writes API endpoints with Spring Boot following layered architecture patterns. To be used for implementing RESTful endpoints with validation, exception handling, and business logic in Java."
---

# Writing a Spring API

Follow a **layered architecture** with clear separation of concerns between HTTP handling (controllers), business logic (services), and contracts/models (DTOs and entities).

## Layered Architecture Pattern

The application uses three main layers:

```
Controllers (HTTP Layer)
    ↓
Services (Business Logic)
    ↓
Types/Models (DTOs, Entities, Error Contracts)
```

## Project Structure

Organize code by technical layer:

```
src/main/java/com/example/app/
├── Application.java
├── controller/
│   └── ResourceController.java
├── service/
│   └── ResourceService.java
├── dto/
│   ├── CreateResourceRequest.java
│   ├── UpdateResourceRequest.java
│   └── ResourceResponse.java
├── model/
│   └── Resource.java
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── mapper/
    └── ResourceMapper.java
```

## Controller Layer

### File Naming
- Use PascalCase with `Controller` suffix: `ResourceController.java`
- One controller per resource
- Base endpoint should be plural and kebab-case (example: `/api/resources`)

### Controller Pattern

Controllers should delegate business rules to services and focus on HTTP concerns:
- Use `@RestController` and `@RequestMapping`
- Validate payloads with service/domain validation methods
- Return `ResponseEntity` with proper status codes
- Keep methods thin and deterministic

See [ResourceController.java](./ResourceController.java) template for complete example implementation.

### HTTP Status Codes

| Method | Success | Validation Error | Not Found |
|--------|---------|------------------|-----------|
| GET    | 200     | N/A              | 404       |
| POST   | 201     | 400              | N/A       |
| PUT    | 200     | 400              | 404       |
| DELETE | 204     | N/A              | 404       |

## Service Layer

### File Naming
- Use PascalCase with `Service` suffix: `ResourceService.java`
- One service per domain

### Service Pattern

Services encapsulate domain and business logic:
- Perform CRUD operations and enforce business rules
- Throw domain exceptions (`ResourceNotFoundException`) instead of returning null for missing data
- Keep transactions in service methods (`@Transactional`)
- Do not include framework-specific HTTP concerns in services

See [ResourceService.java](./ResourceService.java) template for complete example implementation.

## Types/Models Layer

### File Naming
- Use PascalCase: `Resource.java`, `CreateResourceRequest.java`, `ResourceResponse.java`
- Keep DTOs separate from persistence entities

### Type Definitions

Organize types into three categories:
- **Entity**: persistence/domain object
- **Request DTOs**: contracts for create/update payloads
- **Response DTOs**: safe HTTP response shape

See [ResourceContracts.java](./ResourceContracts.java) template for complete example implementation.

### Validation Guidelines

- Prefer manual validation with plain Java (null checks, ranges, string rules)
- Keep validation in service/domain methods that return all field errors
- Return all field errors in a single response via `@RestControllerAdvice`
- Avoid extra dependencies when simple validation logic is enough

## Error Handling

Centralize exception mapping in a global handler:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage()));
    }
}
```

Key patterns:
- Use custom exceptions for domain errors
- Map validation failures to `400 Bad Request`
- Use a consistent error payload (`code`, `message`, optional `fieldErrors`)

## Application Setup

### Bootstrapping

Use standard Spring Boot startup and constructor injection:

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Key patterns:
- Prefer constructor injection over field injection
- Keep configuration in `application.yml`/`application.properties`
- Externalize environment-specific values

## Best Practices

1. **Validation First**: Validate requests explicitly with minimal dependencies
2. **Thin Controllers**: Keep HTTP-only concerns in controllers
3. **Rich Services**: Concentrate business rules and orchestration in services
4. **Global Error Handling**: Use `@RestControllerAdvice` for consistent API errors
5. **DTO Separation**: Never expose JPA entities directly in API responses
6. **Transaction Boundaries**: Define transactional behavior at service layer
7. **Constructor Injection**: Favor immutability and testability
8. **API Consistency**: Keep endpoint naming, status codes, and error shapes predictable
