package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.util.LoggerUtil;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    LoggerUtil.logInfo(DemoApplication.class.getSimpleName(), "Application startup initiated");
    ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
    LoggerUtil.logInfo(DemoApplication.class.getSimpleName(),
        "Spring initialization completed: " + context.getApplicationName());
    LoggerUtil.logInfo(DemoApplication.class.getSimpleName(),
        "Available endpoints: GET /api/hello, GET /api/health/status");
  }
}
