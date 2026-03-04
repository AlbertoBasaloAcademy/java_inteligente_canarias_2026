package com.example.demo.api;

import com.example.demo.util.LoggerUtil;

public record HealthResponse(
    String status,
    String message,
    long timestamp,
    String version) {

  public HealthResponse {
    LoggerUtil.logInfo(HealthResponse.class.getSimpleName(),
        "HealthResponse created: status=" + status + ", version=" + version);
  }
}
