package com.company.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Homework<ID> extends Entity<ID> {
  private int startWeek,endWeek;
  private String description;

  public Homework(ID id,int endWeek, String description) {
    super(id);
    String str = "2019-09-30 00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    this.startWeek = (int) ChronoUnit.WEEKS.between(dateTime,LocalDateTime.now());
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

  public String info() {
    return String.format("%s. Start week is %d, end week is %d and description is %s",id,startWeek,endWeek,description);
  }
}
