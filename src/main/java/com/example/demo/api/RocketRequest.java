package com.example.demo.api;

public class RocketRequest {
  private String name;
  private String range;
  private int capacity;

  public RocketRequest() {
  }

  public RocketRequest(String name, String range, int capacity) {
    this.name = name;
    this.range = range;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
