---
name: coding-java
description: "Best practices for clean and maintainable code in Java. To be used for writing Java code that is easy to read, maintain, and follows industry standards."
---
# Clean code best practices

## Variables and naming
- Name classes, methods, and variables descriptively.
- Use named constants instead of magic numbers or strings.
- Follow Java naming conventions: `PascalCase` for classes, `camelCase` for methods/variables, `UPPER_SNAKE_CASE` for constants.

## Methods and complexity
- Keep methods small and focused on a single responsibility.
- Avoid deep nesting; prefer guard clauses and early returns.
- Keep method signatures simple and avoid too many parameters (prefer value objects/DTOs when needed).

## Classes and packages
- Keep classes cohesive and focused on one purpose.
- Favor composition over inheritance.
- Prefer interfaces for contracts and dependency inversion.
- Organize packages by feature or bounded context, not only by technical layer.

## Error handling and comments
- Use exceptions for exceptional flows, not for normal control flow.
- Throw specific exceptions with meaningful messages.
- Handle exceptions at appropriate boundaries (e.g., API/controller layer).
- Write comments to explain the "why", not the "what".

## General principles
- Keep it simple and avoid over-engineering.
- Keep code DRY by extracting reusable logic.
- Prefer immutability where practical.
- Minimize external dependencies when Java standard library is enough.

## Java-specific guidelines

- Use one public top-level type per file.
- Prefer constructor injection over field injection.
- Program to interfaces, not implementations.
- Use `final` for fields and variables that should not change.
- Use `enum` for fixed sets of values.
- Use `Optional` as return type when absence is valid; avoid using it in fields.
- Use Streams when they improve readability; prefer loops when clearer.
- Use `List`, `Set`, `Map` interfaces in signatures.
- Keep DTOs and domain entities separated.
- Validate input explicitly and fail fast with clear errors.
