package com.example.demo.model;

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

  public static RangeType fromValue(String value) {
    for (RangeType rangeType : RangeType.values()) {
      if (rangeType.value.equalsIgnoreCase(value)) {
        return rangeType;
      }
    }
    return null;
  }
}
