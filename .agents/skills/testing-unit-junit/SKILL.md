---
name: testing-unit-junit
description: "Writes and maintains unit tests for Spring applications using JUnit 5 and Mockito. To be used for testing business logic in services and utilities in a minimal and simple way."
---

# Unit Testing Skill (Spring)

When asked to write or maintain unit tests for Spring projects, follow these guidelines.

## Minimal Stack

- **JUnit 5** for test runner and assertions
- **Mockito** for mocking dependencies
- Avoid loading full Spring context for unit tests
- Keep tests fast, isolated, and focused on business logic

## When to Write Unit Tests

- **New services/utilities**: Add tests for new business logic
- **Bug fixes**: Add regression tests for the fixed behavior
- **Complex logic**: Cover edge cases and error paths
- **Refactoring**: Verify behavior before/after refactor

## File Naming and Location

- **Colocate tests** in `src/test/java` mirroring package structure from `src/main/java`
- **Naming convention**: `{ClassName}Test.java` (example: `RocketServiceTest.java`)
- Keep integration tests separate (example: `*IT.java`)

## Test Structure

Use `@ExtendWith(MockitoExtension.class)` and arrange-act-assert:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResourceServiceTest {

    @Mock
    private ResourceRepository repository;

    @InjectMocks
    private ResourceService service;

    @Test
    void shouldReturnResourceWhenIdExists() {
        // Arrange
        Resource entity = new Resource();
        entity.setId("resource-1");
        when(repository.findById("resource-1")).thenReturn(java.util.Optional.of(entity));

        // Act
        ResourceResponse response = service.getById("resource-1");

        // Assert
        assertEquals("resource-1", response.id());
        verify(repository, times(1)).findById("resource-1");
    }
}
```

## Mocking Dependencies

- Mock repository, gateway, and external collaborators
- Do not mock value objects or simple DTOs
- Stub only what each test needs
- Verify critical interactions (`verify(...)`) when behavior matters

## Running Tests

- **Maven**: `mvn test`
- **Gradle**: `./gradlew test`
- Run specific class:
  - Maven: `mvn -Dtest=ResourceServiceTest test`
  - Gradle: `./gradlew test --tests ResourceServiceTest`

## Coverage Expectations

- Prioritize service/business logic coverage
- Cover happy path + edge cases + error path
- Validate key business rules and state transitions
- Prefer meaningful cases over chasing 100% blindly

## Best Practices

- Test behavior, not implementation details
- Use descriptive test names (`should...When...`)
- Keep one logical assertion goal per test
- Keep tests deterministic (no real time/network/db)
- Use builders/factories for readable test data

## Common JUnit/Mockito Assertions

```java
assertEquals(expected, actual);
assertTrue(condition);
assertThrows(MyException.class, () -> service.execute());
verify(mock).save(entity);
verify(mock, never()).delete(any());
```

## Minimalism Rules

- Prefer plain unit tests over `@SpringBootTest`
- Use `@SpringBootTest` only for integration scenarios
- Keep fixtures small and explicit
- Avoid unnecessary test frameworks beyond JUnit + Mockito
