package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.LoggerUtil;

@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    LoggerUtil.logInfo(HelloController.class.getSimpleName(),
        "Method entry: hello(), path=/api/hello");
    try {
      String response = "Hello from Spring Boot!";
      LoggerUtil.logInfo(HelloController.class.getSimpleName(), "Response generated: " + response);
      return response;
    } catch (Exception exception) {
      LoggerUtil.logError(HelloController.class.getSimpleName(),
          "Error in hello(): " + exception.getMessage());
      throw exception;
    }
  }
}
