package com.example.demo.api;

public class RocketResponse {
  private String id;
  private String name;
  private String range;
  private int capacity;

  public RocketResponse(String id, String name, String range, int capacity) {
    this.id = id;
    this.name = name;
    this.range = range;
    this.capacity = capacity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
