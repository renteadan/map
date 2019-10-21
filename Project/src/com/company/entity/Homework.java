package com.company.entity;

public class Homework<ID> extends Entity<ID> {
  private int startWeek,endWeek;
  private String description;

  Homework(ID id) {
    super(id);
  }

  public int getStartWeek() {
    return startWeek;
  }

  public int getEndWeek() {
    return endWeek;
  }

  public String getDescription() {
    return description;
  }
}
