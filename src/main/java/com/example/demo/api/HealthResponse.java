package com.example.demo.api;

public record HealthResponse(
    String status,
    String message,
    long timestamp,
    String version) {
}
