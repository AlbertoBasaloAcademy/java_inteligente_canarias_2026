package com.example.demo.model;

import java.util.Optional;

public enum RangeType {
  SUBORBITAL("suborbital"),
  ORBITAL("orbital"),
  MOON("moon"),
  MARS("mars");

  private final String value;

  RangeType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static Optional<RangeType> fromValue(String value) {
    return java.util.Arrays.stream(RangeType.values())
        .filter(rt -> rt.value.equalsIgnoreCase(value))
        .findFirst();
  }
}
