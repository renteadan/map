package com.company.entity;

public class Homework<ID> extends Entity<ID> {
  private int startWeek,endWeek;
  private String description;

  public Homework(ID id,int startWeek, int endWeek, String description) {
    super(id);
    this.startWeek = startWeek;
    this.endWeek = endWeek;
    this.description = description;
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
