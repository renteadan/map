package com.company.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Homework<ID> extends Entity<ID> {
  private int startWeek,endWeek;
  private String description;

  public Homework(ID id,int endWeek, String description) {
    super(id);
    String str = "2019-09-30 00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    this.startWeek = (int) ChronoUnit.WEEKS.between(dateTime,LocalDateTime.now()) + 1;
    this.endWeek = endWeek;
    this.description = description;
  }

  @SuppressWarnings("unchecked")
  public Homework(String[] args) {
    super((ID) args[0]);
    this.startWeek = Integer.parseInt(args[1]);
    this.endWeek = Integer.parseInt(args[2]);
    this.description = args[3];
  }

  public int getMaxGrade() {
    if (getCurrentWeek() > endWeek) {
      return 10 - (getCurrentWeek() - endWeek);
    }
    return 10;
  }

  public static int getWeekOf(LocalDateTime date) {
    String str = "2019-09-30 00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    return (int) ChronoUnit.WEEKS.between(dateTime,date) + 1;
  }

  private int getCurrentWeek() {
    String str = "2019-09-30 00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    return (int) ChronoUnit.WEEKS.between(dateTime,LocalDateTime.now()) + 1;
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
    return String.format("ID=%s.Start week is %d, end week is %d and description is %s",id,startWeek,endWeek,description);
  }

  @Override
  public String toFile() {
    return String.format("%s;%d;%d;%s", id, startWeek,endWeek,description);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Homework<?> homework = (Homework<?>) o;
    return Objects.equals(this.getId(), homework.getId());
  }

}
