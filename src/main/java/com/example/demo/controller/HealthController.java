package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.HealthResponse;

@RestController
@RequestMapping("/api")
public class HealthController {

  @GetMapping("/health/status")
  public ResponseEntity<HealthResponse> getHealthStatus() {
    HealthResponse response = new HealthResponse(
        "UP",
        "Application is running normally",
        System.currentTimeMillis(),
        "1.0.0");
    return ResponseEntity.ok(response);
  }
}
