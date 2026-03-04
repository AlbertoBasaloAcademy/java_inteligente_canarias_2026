package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.HealthResponse;
import com.example.demo.util.LoggerUtil;

@RestController
@RequestMapping("/api")
public class HealthController {

  @GetMapping("/health/status")
  public ResponseEntity<HealthResponse> getHealthStatus() {
    LoggerUtil.logInfo(HealthController.class.getSimpleName(),
        "Method entry: getHealthStatus(), path=/api/health/status");
    try {
      HealthResponse response = new HealthResponse(
          "UP",
          "Application is running normally",
          System.currentTimeMillis(),
          "0.1.0");
      LoggerUtil.logInfo(HealthController.class.getSimpleName(),
          "Response generated: status=" + response.status() + ", version=" + response.version());
      return ResponseEntity.ok(response);
    } catch (Exception exception) {
      LoggerUtil.logError(HealthController.class.getSimpleName(),
          "Error in getHealthStatus(): " + exception.getMessage());
      throw exception;
    }
  }
}
