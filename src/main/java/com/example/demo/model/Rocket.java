package com.example.demo.model;

import java.util.UUID;

public class Rocket {
  private final String id;
  private String name;
  private RangeType range;
  private int capacity;

  public Rocket(String name, RangeType range, int capacity) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.range = range;
    this.capacity = capacity;
  }

  public Rocket(String id, String name, RangeType range, int capacity) {
    this.id = id;
    this.name = name;
    this.range = range;
    this.capacity = capacity;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RangeType getRange() {
    return range;
  }

  public void setRange(RangeType range) {
    this.range = range;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
