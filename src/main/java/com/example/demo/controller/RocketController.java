package com.example.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ErrorResponse;
import com.example.demo.api.RocketRequest;
import com.example.demo.api.RocketResponse;
import com.example.demo.model.Rocket;
import com.example.demo.service.RocketService;

@RestController
@RequestMapping("/api/rockets")
public class RocketController {

  private final RocketService rocketService;

  public RocketController(RocketService rocketService) {
    this.rocketService = rocketService;
  }

  private RocketResponse toResponse(Rocket rocket) {
    return new RocketResponse(rocket.getId(), rocket.getName(),
        rocket.getRange().getValue(), rocket.getCapacity());
  }

  @PostMapping
  public ResponseEntity<?> createRocket(@RequestBody RocketRequest request) {
    try {
      Rocket rocket = rocketService.createRocket(request.name(), request.range(),
          request.capacity());
      return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(rocket));
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorResponse("Validation failed: " + e.getMessage()));
    }
  }

  @GetMapping
  public ResponseEntity<Collection<RocketResponse>> getAllRockets() {
    Collection<Rocket> rockets = rocketService.getAllRockets();
    Collection<RocketResponse> responses = rockets.stream()
        .map(this::toResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getRocketById(@PathVariable String id) {
    return rocketService.getRocketById(id).map(rocket -> {
      RocketResponse response = new RocketResponse(rocket.getId(), rocket.getName(),
          rocket.getRange().getValue(), rocket.getCapacity());
      return ResponseEntity.ok((Object) response);
    }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body((Object) new ErrorResponse("Rocket not found")));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateRocket(@PathVariable String id,
      @RequestBody RocketRequest request) {
    try {
      Rocket rocket = rocketService.updateRocket(id, request.name(), request.range(),
          request.capacity());
      if (rocket == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse("Rocket not found"));
      }
      return ResponseEntity.ok(toResponse(rocket));
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorResponse("Validation failed: " + e.getMessage()));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteRocket(@PathVariable String id) {
    if (rocketService.deleteRocket(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("Rocket not found"));
  }
}
